package org.pepper.security.api.service;

import org.pepper.security.api.dao.MaliciousIpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class IpAddressService {

	private static Logger logger = LoggerFactory.getLogger(IpAddressService.class);
    private final MaliciousIpRepository maliciousRepo;
    
    @Autowired
    public IpAddressService(@Qualifier("maliciousIps") MaliciousIpRepository maliciousRepo) {
    	logger.debug("constructor()");
        this.maliciousRepo = maliciousRepo;
    }
    
    public boolean isMalicious(String ip) {
    	logger.debug("isMalicious(" + ip + ")");
    	return maliciousRepo.isMalicious(ip);
    }
}
