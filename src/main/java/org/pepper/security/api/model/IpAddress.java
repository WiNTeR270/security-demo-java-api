package org.pepper.security.api.model;

import java.util.HashMap;
import org.springframework.util.StringUtils;

public class IpAddress {
	/* IP Info Fields. */
	private static final String IP_INFO_FIELD_NAME_CITY = "city";
	private static final String IP_INFO_FIELD_NAME_REGION = "region";
	private static final String IP_INFO_FIELD_NAME_COUNTRY = "country";
	private static final String IP_INFO_FIELD_NAME_POSTAL = "postal";
	private static final String IP_INFO_FIELD_NAME_LOCATION = "loc";
	
	/* Member fields. */
	private String ip, city, region, country;
    private Boolean malicious;
    private Integer postal;
    private Double latitude, longitude;
    
    public IpAddress (String ip) 
    {
    	this.ip = ip; 
    }

	public String getIp() {
		return ip;
	}

	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getCountry() {
		return country;
	}

	public Boolean getMalicious() {
		return malicious;
	}

	public Integer getPostal() {
		return postal;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	protected void setIp(String ip) {
		this.ip = ip;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	protected void setCountry(String country) {
		this.country = country;
	}

	protected void setMalicious(Boolean malicious) {
		this.malicious = malicious;
	}

	protected void setPostal(Integer postal) {
		this.postal = postal;
	}

	protected void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	protected void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
    
	public static IpAddress convertIpInfo(String ip, boolean isMalicious, HashMap data) {
		IpAddress result = new IpAddress(ip);
		result.setMalicious(isMalicious);
		result.setCity((String) data.get(IP_INFO_FIELD_NAME_CITY));
		result.setRegion((String) data.get(IP_INFO_FIELD_NAME_REGION));
		result.setCountry((String) data.get(IP_INFO_FIELD_NAME_COUNTRY));
	    
	    String postal = (String)data.get(IP_INFO_FIELD_NAME_POSTAL);
	    result.setPostal(!StringUtils.isEmpty(postal) ? Integer.parseInt(postal) : null);
	    
	    String loc = (String)data.get(IP_INFO_FIELD_NAME_LOCATION);
	    if(!StringUtils.isEmpty(loc)) {
	    	String[] values = loc.split(",");
	    	result.setLatitude(Double.parseDouble(values[0]));
	    	result.setLongitude(Double.parseDouble(values[1]));
	    }
	    
	    return result;
	}
}
