package com.playdata.jpaTest.entitymanager.exam;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity {
	@Id
	@GeneratedValue
	private Long productNo;
	private String productName;
	private String company;
	private int price;
	@CreationTimestamp
	private Date createDate;
	@UpdateTimestamp
	private Date updateDate;

	public ProductEntity(String productName, String company, int price) {
		super();
		this.productName = productName;
		this.company = company;
		this.price = price;
	}
	
	
}
