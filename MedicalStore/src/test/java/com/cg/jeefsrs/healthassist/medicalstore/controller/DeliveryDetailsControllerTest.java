package com.cg.jeefsrs.healthassist.medicalstore.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.jeefsrs.healthassist.medicalstore.entity.DeliveryDetails;
import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;
import com.cg.jeefsrs.healthassist.medicalstore.service.DeliveryDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value = DeliveryDetailsController.class)
class DeliveryDetailsControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryDetailsServiceImpl deliverydetailsService;


    @Test
	public void testAddDelivery() throws Exception{
		
        String URI = "/api/v2/AddDeliveryDetails";
        DeliveryDetails deliverydetails = new DeliveryDetails();
		 deliverydetails.setOrdersId(1);
		 deliverydetails.setPatientAddress("Chennai");
		 deliverydetails.setPatientEmail("sarath@gmail.com");
		 deliverydetails.setPatientName("sarath");
		 deliverydetails.setPatientNumber(123523);
        String jsonInput = this.converttoJson(deliverydetails);

        Mockito.when(deliverydetailsService.addDeliveryDetails(Mockito.any(DeliveryDetails.class))).thenReturn(deliverydetails);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }
	
    
	@Test
	void testgetAllDelivery() throws Exception {
		String URI = "/api/v2/DeliveryDetails";
		 DeliveryDetails deliverydetails = new DeliveryDetails();
		 deliverydetails.setOrdersId(1);
		 deliverydetails.setPatientAddress("Chennai");
		 deliverydetails.setPatientEmail("sarath@gmail.com");
		 deliverydetails.setPatientName("sarath");
		 deliverydetails.setPatientNumber(123523);
	        
		 DeliveryDetails deliverydetails2 = new DeliveryDetails();
		 deliverydetails2.setOrdersId(1);
		 deliverydetails2.setPatientAddress("tirupati");
		 deliverydetails2.setPatientEmail("lekha@gmail.com");
		 deliverydetails2.setPatientName("lekha");
		 deliverydetails2.setPatientNumber(1328523);
	        
		        
	    	 List<DeliveryDetails> deliveryList=new ArrayList<>();
	    	 deliveryList.add(deliverydetails);
	    	 deliveryList.add(deliverydetails2);
	    	 
	    	String jsonInput = this.converttoJson(deliveryList);

	         Mockito.when(deliverydetailsService.getAllDeliveryDetails()).thenReturn(deliveryList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	     }
	private String converttoJson(Object orders) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(orders);
	}

}
