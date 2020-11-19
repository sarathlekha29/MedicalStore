package com.cg.jeefsrs.healthassist.medicalstore.repository;



import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jeefsrs.healthassist.medicalstore.entity.DeliveryDetails;



@RunWith(SpringRunner.class)
@DataJpaTest
class DeliveryDetailsRepositoryTest {
	
	@Autowired
	    private DeliveryDetailsRepository deliverydetailsrepository;
	
	@Autowired
	    private TestEntityManager testEntityManager;
	 
	 @Test
	    public void testAddDetails() throws Exception{
		 DeliveryDetails delivery = getDeliveryDetails();
		 DeliveryDetails saveInDb = testEntityManager.persist(delivery);
		 DeliveryDetails getFromInDb = deliverydetailsrepository.findById(saveInDb.getDeliveryId()).get();
		 assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	 
		private DeliveryDetails getDeliveryDetails() {
			// TODO Auto-generated method stub
			DeliveryDetails delivery = new DeliveryDetails();
			delivery.setOrdersId(1);
	        delivery.setPatientAddress("Tirupati");
	        delivery.setPatientEmail("sarath@gmail.com");
	        delivery.setPatientName("sarath");
	        delivery.setPatientNumber(1234567);
	        return delivery;
		}
		
	@Test
	    public void getAllDeliveryDetails() throws Exception{
		
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

	        //Save into in memory database
	        testEntityManager.persist(delivery);
	        testEntityManager.persist(delivery2);

	        //Retrieve all tickets
	        List<DeliveryDetails> deliverylist = (List<DeliveryDetails>) deliverydetailsrepository.findAll();
	        Assert.assertEquals(2, deliverylist.size());
	    }

}
