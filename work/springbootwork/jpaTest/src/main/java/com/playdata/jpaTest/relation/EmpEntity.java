package com.playdata.jpaTest.relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "emp")
@Getter
@ToString(of = {"id","name","addr"})
@NoArgsConstructor
@AllArgsConstructor
public class EmpEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String addr;
	// FK를 참조할 수 있도록 명시 (조인할 컬럼을 명시)
	// 조인컬럼은 실제 조인할 테이블의 pk명
	@ManyToOne
	@JoinColumn(name = "dept_no")
	private DeptEntity dept;
	
	public EmpEntity(String name, String addr, DeptEntity dept) {
		super();
		this.name = name;
		this.addr = addr;
		this.dept = dept;
	}

}