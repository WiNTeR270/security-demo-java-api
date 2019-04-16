package org.pepper.security.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pepper.security.api.controller.IpAddressController;
import org.pepper.security.api.model.IpAddress;
import org.pepper.security.api.service.IpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(IpAddressController.class)
public class IpAddressControllerIntegrationTest {
 
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private IpAddressService service;
 
    @Test
    public void getIp() throws Exception{
    	ResultActions actions = mvc.perform(get("/api/ipAddress/1.2.254.86"));
		actions.andExpect(status().isOk());
		MvcResult result = actions.andReturn();
		assertTrue(result.getResponse().getContentAsString().contains("\"ip\":\"1.2.254.86\""));
    }
}