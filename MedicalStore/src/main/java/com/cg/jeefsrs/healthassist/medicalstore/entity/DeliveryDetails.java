package com.cg.jeefsrs.healthassist.medicalstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class DeliveryDetails {
			
	    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	    private int DeliveryId;
	    @Column(nullable = false)
		private String patientName;
		@Column(nullable = false)
		private String patientAddress;
		@Column(nullable = false)
		private String patientEmail;
		@Column(nullable = false)
		private long patientNumber;
		@Column(nullable = false)
		private int OrdersId;

		
		public DeliveryDetails() {
			 
		}
		public DeliveryDetails(String patientName, String patientAddress, String patientEmail, long patientNumber) {
			super();
			this.patientName = patientName;
			this.patientAddress = patientAddress;
			this.patientEmail = patientEmail;
			this.patientNumber = patientNumber;  
		}  
		public int getDeliveryId() {  
			return DeliveryId;  
		}
		public void setDeliveryId(int deliveryId) {
			DeliveryId = deliveryId;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		} 
		public String getPatientAddress() {
			return patientAddress;
		}
		public void setPatientAddress(String patientAddress) {
			this.patientAddress = patientAddress;
		}
		public String getPatientEmail() {
			return patientEmail;
		}
		public void setPatientEmail(String patientEmail) {
			this.patientEmail = patientEmail;
		}
		public long getPatientNumber() {
			return patientNumber;
		}
		public void setPatientNumber(long patientNumber) {
			this.patientNumber = patientNumber;
		}
		public int getOrdersId() {
			return OrdersId;
		}
		public void setOrdersId(int ordersId) {
			OrdersId = ordersId;
		}
		@Override
		public String toString() {
			return "DeliveryDetails [DeliveryId=" + DeliveryId + ", patientName=" + patientName + ", patientAddress="
					+ patientAddress + ", patientEmail=" + patientEmail + ", patientNumber=" + patientNumber
					+ ", OrdersId=" + OrdersId + "]";
		}
		
		
}
