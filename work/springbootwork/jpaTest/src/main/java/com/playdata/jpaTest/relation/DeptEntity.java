package com.playdata.jpaTest.relation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "dept")
public class DeptEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "dept_no")
	private Long id;
	private String name; // 부서명 
	private String mgr; // 관리자명
	// @OneToMany 관계인 경우 대상 테이블의 어떤 컬럼과 매핑이 되어있는지 엔티티클래스의 컬럼명을 명시한다.
	// @OneToMany로 연결된 테이블을 표현 엔티티의 어떤 컬럼과 연결이 되어 있는지 명시.
	// mappedBy가 정의된 엔티티에서는 조회만 가능하도록
	// 기준이 되는 엔티티는 FK에 해당되는 엔티티
	// 일대다, 다대일에서 기준이 되는 엔티티는 다에 해당하는 엔티티이고 여기서 변경작업을 한다.
	// 양방향관계에서 항상 기준이 되는 엔티티는 외래키테이블을 표현한 엔티티 (EmpEntity, ProductEntity...)
	@OneToMany(mappedBy = "dept")
	private List<EmpEntity> emplist = new ArrayList<>();
	
	
	
	public DeptEntity(String name, String mgr, List<EmpEntity> emplist) {
		super();
		this.name = name;
		this.mgr = mgr;
		this.emplist = emplist;
	}

	@Override
	public String toString() {
		return "DeptEntity [id=" + id + ", name=" + name + ", mgr=" + mgr + ", emplist=" + emplist + "]";
	}

	public DeptEntity(String name, String mgr) {
		super();
		this.name = name;
		this.mgr = mgr;
	}

	
}
