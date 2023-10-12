package com.playdata.jpaTest.relation;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playdata.jpaTest.entitymanager.test.PersonEntity;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	EntityManager em;

	@Autowired
	public ProductDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insert(ProductEntity entity) {
		em.persist(entity);
	}

	@Override
	public ProductEntity read(Long productNo) {
		return em.find(ProductEntity.class, productNo);
	}

	@Override
	public void update(ProductEntity entity) {
		ProductEntity product = em.find(ProductEntity.class, entity.getProductNo());
		product.setCompany(entity.getCompany());
	}

	@Override
	public void delete(Long productNo) {
		em.remove(em.find(ProductEntity.class, productNo));;
	}

	@Override
	public List<ProductEntity> list() {
		// TODO Auto-generated method stub
		List<ProductEntity> list = em.createQuery("select p from ProductEntity as p", ProductEntity.class)
										.getResultList();
		return list;
	}
	
	
	

}
