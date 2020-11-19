package com.cg.jeefsrs.healthassist.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jeefsrs.healthassist.medicalstore.entity.DeliveryDetails;
import com.cg.jeefsrs.healthassist.medicalstore.service.DeliveryDetailsServiceImpl;

@RestController
@RequestMapping("/api/v2")
public class DeliveryDetailsController {
	
	@Autowired
	private DeliveryDetailsServiceImpl deliverydetailsservice;
	
	@PostMapping("/AddDeliveryDetails")
	public DeliveryDetails addDeliveryDetails( @RequestBody DeliveryDetails deliverydetails) {
		return deliverydetailsservice.addDeliveryDetails(deliverydetails);
	} 

	@GetMapping("/DeliveryDetails")
	public List<DeliveryDetails> getAllDeliveryDetails() {
		return deliverydetailsservice.getAllDeliveryDetails();
	}
	
}
