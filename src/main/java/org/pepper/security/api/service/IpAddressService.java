package org.pepper.security.api.service;

import org.pepper.security.api.dao.MaliciousIpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class IpAddressService {
    private final MaliciousIpRepository maliciousRepo;
    
    @Autowired
    public IpAddressService(@Qualifier("maliciousIps") MaliciousIpRepository maliciousRepo) {
        this.maliciousRepo = maliciousRepo;
    }
    
    public boolean isMalicious(String ip) {
    	return maliciousRepo.isMalicious(ip);
    }
}
