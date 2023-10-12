package com.playdata.jpaTest.relation;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryEntity {
	@Id
	@GeneratedValue
	private Long categoryId;
	private String categoryName;
	private String info;

	public CategoryEntity(String categoryName, String info) {
		super();
		this.categoryName = categoryName;
		this.info = info;
	}
	
}
