package com.playdata.jpaTest.entitymanager.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	// JPA는 EntityManager라는 것을 이용해서 작업을 처리(Spring data jpa 내부에서도 사용)
	EntityManager em;
	
	@Autowired
	public PersonDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insert(PersonEntity dto) {
		System.out.println("persist 메소드 호출전");
		em.persist(dto);
		em.persist(dto);
		em.persist(dto);
		em.persist(new PersonEntity("2222","전병준",55,"test"));
		System.out.println("persist 메소드 호출후");
		System.out.println("=========================================");
		// DB에 저장된 레코드를 조회하는 작업
		// 캐시에 저장되어 있는 객체가 있으면 DB에서 조회하지 않고 캐시에서 객체를 꺼내온다.
		// 변경된 내용을 데이터베이스에 반영
		em.flush(); // sql을 모두 실행 - 캐시를 비우지 않는다.
		em.clear(); // 캐시를 비운다.
		PersonEntity data = em.find(PersonEntity.class, dto.getId());
		System.out.println(data);
		System.out.println(dto==data);
	}

	@Override
	public PersonEntity read(String id) {
		return em.find(PersonEntity.class, Long.parseLong(id));
	}

	@Override
	public void delete(String id) {
		PersonEntity person = em.find(PersonEntity.class, Long.parseLong(id));
		em.remove(person);
		
	}

	@Override
	public void update(PersonEntity dto) {
		// 조회후 수정 -setter메소드를 호출
		PersonEntity person = em.find(PersonEntity.class, dto.getId());
		person.setPassword(dto.getPassword());
		person.setJumsu(dto.getJumsu());
	}

	// JPQL을 사용해서 조회 - 객체지향 쿼리
	// JPQL을 사용하면 이미 셋팅되어 있는 DBMS에 맞춰서 쿼리가 만들어진다.
	// 복잡한 검색조건이나 조인이 들어가는 경우 ANSI조인에서 사용하는 모든 조인을 다 적용할 수 있다.
	// select, from, where, group by, having. join다 지원가능
	@Override
	public List<PersonEntity> list() {
		List<PersonEntity> list = em.createQuery("select p from PersonEntity as p", PersonEntity.class)
										.getResultList();
		return list;
	}

}
