package com.playdata.jpaTest.entitymanager.test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// 이제부터는 JPA가 관리하는 객체, 테이블과 매핑되는 객체
@Entity
@Table(name = "person")
public class PersonEntity {
	// 기본키로 설정 - 기본키는 의미있는 값을 넣기 보다 Long타입으로 시퀀스를 적용하거나 UUID를 이용해서값을 만드는것을 선호
	@Id
	// 시퀀스
	@GeneratedValue
	private Long id;
	@Column(name="pass")
	private String password;
	private String name;
	private int jumsu;
	// 처음 데이터가 저장될때 시간을 저장
	@CreationTimestamp
	private Date createDate;
	// update쿼리가 실행될때 현재 시간의 값을 저장함 
	// 마지막 수정시간을 자동으로 저장
	@UpdateTimestamp
	private Date modifyDate;
	// 오라클의 데이터 타입을 blob이나 clob을 정의할 수 있다.
	// @Lob으로 정의된 필드가 Sting이면 자동으로 CLOB으로 타입의 정의
	@Lob
	private String info;
	@Transient // 디비테이블에 컬럼으로 포함시키지 않겠다는 의미
	private String testval;

	public PersonEntity() {
		
	}
	
	public PersonEntity(Long id, String password, String name, int jumsu, Date createDate, Date modifyDate, String info,
			String testval) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.jumsu = jumsu;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.info = info;
		this.testval = testval;
	}
	
	

	public PersonEntity(String password, String name, int jumsu, String info) {
		super();
		this.password = password;
		this.name = name;
		this.jumsu = jumsu;
		this.info = info;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", password=" + password + ", name=" + name + ", jumsu=" + jumsu
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", info=" + info + ", testval="
				+ testval + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTestval() {
		return testval;
	}

	public void setTestval(String testval) {
		this.testval = testval;
	}

}
