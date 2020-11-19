package com.cg.jeefsrs.healthassist.medicalstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name  = "orders")
public class Orders {
		
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(nullable = false)
		private int OrdersId;
		@Column(nullable = false)
		private String OrderItem;
		@Column(nullable = false)
		private int OrderDose;
		@Column(nullable = false)
		private int OrderQuantity;
		@Column(nullable = false) 
		private double OrderCost;
		@Column(nullable = false)
		private String orderedDate;
		
		public Orders() {
			
		}
		  
		public Orders(String orderItem, int orderDose, int orderQuantity, double orderCost,
				String orderedDate) {
			super();
			OrderItem = orderItem;
			OrderDose = orderDose;
			OrderQuantity = orderQuantity;
			OrderCost = orderCost;
			this.orderedDate = orderedDate;
		}  
		public int getOrdersId() {
			return OrdersId;
		}
		public void setOrdersId(int ordersId) {
			OrdersId = ordersId;
		}
		public String getOrderItem() {
			return OrderItem;
		}
		public void setOrderItem(String orderItem) {
			OrderItem = orderItem;
		}
		public int getOrderDose() {
			return OrderDose;
		}
		public void setOrderDose(int orderDose) {
			OrderDose = orderDose;
		}
		public int getOrderQuantity() {
			return OrderQuantity;
		}
		public void setOrderQuantity(int orderQuantity) {
			OrderQuantity = orderQuantity;
		}  
		public double getOrderCost() {
			return OrderCost;
		}
		public void setOrderCost(double orderCost) {
			OrderCost = orderCost;
		}
		public String getorderedDate() {
			return orderedDate;
		}
		public void setorderedDate(String orderedDate) {
			this.orderedDate = orderedDate; 
		}
		
		@Override
		public String toString() {
			return "\n Order Id = " + OrdersId + "\n Order Item = " + OrderItem + "\n Order Dose = " + OrderDose
					+ "\n Order Quantity = " + OrderQuantity + "\n Order Cost = " + OrderCost + "\n ordered Date = " + orderedDate + "\n--------------------------\n";
		}
		


}
