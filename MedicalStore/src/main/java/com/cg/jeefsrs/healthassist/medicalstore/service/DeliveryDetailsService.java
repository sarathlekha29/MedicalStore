package com.cg.jeefsrs.healthassist.medicalstore.service;

import java.util.List;

import com.cg.jeefsrs.healthassist.medicalstore.entity.DeliveryDetails;

public interface DeliveryDetailsService {
	public DeliveryDetails addDeliveryDetails(DeliveryDetails deliverydetails);
	public List<DeliveryDetails> getAllDeliveryDetails();
}
