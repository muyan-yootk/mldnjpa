package cn.mldn.mldnjpa.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import cn.mldn.po.Dept;
import cn.mldn.util.jpa.JPAEntityFactory;

public class TestCriteria {
	 
	@Test
	public void testFindIN() {
		Set<Long> allDeptnos = new HashSet<Long>() ;
		allDeptnos.add(1L) ;
		allDeptnos.add(6L) ;
		allDeptnos.add(7L) ;
		// 根据部门的PO类型来获取一个查询对象
		CriteriaQuery<Dept> criteriaQuery = JPAEntityFactory.getEntityManager().getCriteriaBuilder().createQuery(Dept.class) ;
		Root<Dept> root = criteriaQuery.from(Dept.class) ; // 根据指定的PO类定义数据来源（FROM子句），得到根查询对象
		// 定义一个查询的断言配置，查询平均工资高于8000的部门信息
		criteriaQuery.where(root.get("deptno").in(allDeptnos)) ; // 条件应该放在where子句之中 
		// 所有的查询语句都通过Criteria创建，而真正发出查询的一定还是Query
		TypedQuery<Dept> query = JPAEntityFactory.getEntityManager().createQuery(criteriaQuery) ;
		List<Dept> list = query.getResultList() ;
		list.forEach((dept)->{
			System.out.println(dept); 
		});
	}
	
	@Test
	public void testFindCondition() {
		// 根据部门的PO类型来获取一个查询对象
		CriteriaQuery<Dept> criteriaQuery = JPAEntityFactory.getEntityManager().getCriteriaBuilder().createQuery(Dept.class) ;
		Root<Dept> root = criteriaQuery.from(Dept.class) ; // 根据指定的PO类定义数据来源（FROM子句），得到根查询对象
		// 定义一个查询的断言配置，查询平均工资高于8000的部门信息
		Predicate predicate = JPAEntityFactory.getEntityManager().getCriteriaBuilder().gt(root.get("avgsal"),8000.00) ;
		criteriaQuery.where(predicate) ; // 条件应该放在where子句之中
		// 所有的查询语句都通过Criteria创建，而真正发出查询的一定还是Query
		TypedQuery<Dept> query = JPAEntityFactory.getEntityManager().createQuery(criteriaQuery) ;
		List<Dept> list = query.getResultList() ;
		list.forEach((dept)->{
			System.out.println(dept); 
		});
	}
	
	@Test
	public void testFindAll() {
		// 根据部门的PO类型来获取一个查询对象
		CriteriaQuery<Dept> criteriaQuery = JPAEntityFactory.getEntityManager().getCriteriaBuilder().createQuery(Dept.class) ;
		criteriaQuery.from(Dept.class) ; // 根据指定的PO类定义数据来源（FROM子句）
		// 所有的查询语句都通过Criteria创建，而真正发出查询的一定还是Query
		TypedQuery<Dept> query = JPAEntityFactory.getEntityManager().createQuery(criteriaQuery) ;
		List<Dept> list = query.getResultList() ;
		list.forEach((dept)->{
			System.out.println(dept); 
		});
	}
}
