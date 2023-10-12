package com.playdata.jpaTest.relation;

import java.util.List;

public interface ProductDAO {
	
	public void insert(ProductEntity entity);
	public ProductEntity read(Long productNo);
	public void update(ProductEntity entity);
	public void delete(Long productNo);
	public List<ProductEntity> list();

}
