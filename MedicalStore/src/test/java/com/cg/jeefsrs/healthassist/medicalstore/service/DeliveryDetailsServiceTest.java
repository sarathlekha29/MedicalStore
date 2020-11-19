package com.cg.jeefsrs.healthassist.medicalstore.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jeefsrs.healthassist.medicalstore.entity.DeliveryDetails;
import com.cg.jeefsrs.healthassist.medicalstore.repository.DeliveryDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DeliveryDetailsServiceTest {
	
	@MockBean
	private DeliveryDetailsRepository deliverydetailsrepository;

	@Autowired
	private DeliveryDetailsServiceImpl deliverydetailsService;
	
	 @Test
		public void testaddDeliveryDetails(){
		 DeliveryDetails delivery = new DeliveryDetails();
	        delivery.setOrdersId(1);
	        delivery.setPatientAddress("Tirupati");
	        delivery.setPatientEmail("sarath@gmail.com");
	        delivery.setPatientName("sarath");
	        delivery.setPatientNumber(1234567);
	        
			
			 Mockito.when(deliverydetailsrepository.save(delivery)).thenReturn(delivery);
			 assertThat(deliverydetailsService.addDeliveryDetails(delivery)).isEqualTo(delivery);
			
	    }

	 @Test
		public void testgetAllDeliveryDetails() throws Exception {
		 DeliveryDetails delivery = new DeliveryDetails();
	        delivery.setOrdersId(1);
	        delivery.setPatientAddress("Tirupati");
	        delivery.setPatientEmail("sarath@gmail.com");
	        delivery.setPatientName("sarath");
	        delivery.setPatientNumber(1234567);
	        

	        DeliveryDetails delivery2 = new DeliveryDetails();
	        delivery2.setOrdersId(2);
	        delivery2.setPatientAddress("Banglore");
	        delivery2.setPatientEmail("Lekha@gmail.com");
	        delivery2.setPatientName("Lekha");
	        delivery2.setPatientNumber(1234587);

			List<DeliveryDetails> orderList = new ArrayList<>();
			orderList.add(delivery);
			orderList.add(delivery2);

			Mockito.when(deliverydetailsrepository.findAll()).thenReturn(orderList);
			assertThat(deliverydetailsService.getAllDeliveryDetails()).isEqualTo(orderList);
		}
}
