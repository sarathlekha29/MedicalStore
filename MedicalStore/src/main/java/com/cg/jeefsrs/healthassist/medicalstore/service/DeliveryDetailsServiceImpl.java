package com.cg.jeefsrs.healthassist.medicalstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jeefsrs.healthassist.medicalstore.entity.DeliveryDetails;
import com.cg.jeefsrs.healthassist.medicalstore.repository.DeliveryDetailsRepository;

@Service
@Transactional
public class DeliveryDetailsServiceImpl implements DeliveryDetailsService{

	@Autowired
	private DeliveryDetailsRepository deliverydetailsrepository;
	
	public DeliveryDetails addDeliveryDetails(DeliveryDetails deliverydetails) {
		return  deliverydetailsrepository.save(deliverydetails);
	}
	
	public List<DeliveryDetails> getAllDeliveryDetails() {
		return deliverydetailsrepository.findAll();
	}
	 
}
