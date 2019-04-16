package org.pepper.security.api.controller;

import java.util.HashMap;

import org.pepper.security.api.model.IpAddress;
import org.pepper.security.api.service.IpAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api")
@Controller
public class IpAddressController {
	private static Logger logger = LoggerFactory.getLogger(IpAddressController.class);
	
	//	TODO: In order to use this API Service you'll need to sign up for an ipinfo.io API key for free
	private static final String API_KEY = null;

    private final IpAddressService ipAddressService;

    @Autowired
    public IpAddressController(IpAddressService ipAddressService) {
    	logger.debug("Initializing IpAddressController");
        this.ipAddressService = ipAddressService;
    }

	@GetMapping(path = "/maliciousAddresses")
	public @ResponseBody String getMaliciousIps() {
    	logger.debug("API call received: api/maliciousAddresses");
		String result = null;
		try {
			final String uri = "https://www.binarydefense.com/banlist.txt";
		    RestTemplate restTemplate = new RestTemplate();
		    result = restTemplate.getForObject(uri, String.class);
		} catch (Exception e) {
			logger.error("Failed to retrieve the banlist feed.");
			logger.error(e.getMessage());
		}
		
	    return result;
	}
	
	@GetMapping(path = "/ipAddress/{ip}")
	public @ResponseBody IpAddress get(@PathVariable String ip) {
    	logger.debug("API call received: api/ipAddress/{ip}");
		try {
			String url = new StringBuilder().append("http://ipinfo.io/").append(ip).append("?token=").append(API_KEY).toString();
			logger.debug("IP Request URL: " + url);

		    RestTemplate restTemplate = new RestTemplate();
		    boolean isMalicious = ipAddressService.isMalicious(ip);
		    IpAddress result = IpAddress.convertIpInfo(ip, isMalicious, restTemplate.getForObject(url, HashMap.class));
		    logger.info("Successfully retrieved IP Address info for " + ip);
		    return result;
		} catch (Exception e) {
			logger.error("Retrieve IP Info Data. Please verify that the API Key is correct.");
			logger.error(e.getMessage());
			e.printStackTrace();
			return new IpAddress(ip);
		}
	}
	
}
