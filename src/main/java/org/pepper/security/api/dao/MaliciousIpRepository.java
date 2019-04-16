package org.pepper.security.api.dao;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Repository("maliciousIps")
public class MaliciousIpRepository {

	private static Logger logger = LoggerFactory.getLogger(MaliciousIpRepository.class);
    private static Set<String> REPOSITORY;

    private void initialize() {
    	if(REPOSITORY != null) return;
    	
    	logger.debug("initializing malicious ip repository");
		try {
			final String uri = "https://www.binarydefense.com/banlist.txt";
		    RestTemplate restTemplate = new RestTemplate();
		    String rawResult = restTemplate.getForObject(uri, String.class);
		    String[] splitResults = rawResult.split("\n");
		    
		    //	find all of the malicious IPs and push them to the set
		    REPOSITORY = new HashSet<String>(splitResults.length);
		    for(String line : splitResults) {
		    	if(StringUtils.isEmpty(line)) continue;
		    	if(line.startsWith("#")) continue;
		    	REPOSITORY.add(line);
		    }
		} catch (Exception e) {
			logger.error("Failed to retrieve the banlist feed and initialize malicious IPs.");
			logger.error(e.getMessage());
		}
    }

    public boolean isMalicious(String ip) {
    	logger.debug("Checking if ip is malicious: " + ip);
        initialize();
        return REPOSITORY != null && REPOSITORY.contains(ip);
    }

}
