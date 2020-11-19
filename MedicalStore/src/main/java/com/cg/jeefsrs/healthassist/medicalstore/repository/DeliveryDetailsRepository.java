package com.cg.jeefsrs.healthassist.medicalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.jeefsrs.healthassist.medicalstore.entity.DeliveryDetails;

@Repository
public interface DeliveryDetailsRepository extends  JpaRepository<DeliveryDetails, Integer> {

}
