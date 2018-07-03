package cn.mldn.mldnjpa.test;

import java.util.Date;

import org.junit.Test;
 
import cn.mldn.po.Dept;
import cn.mldn.util.jpa.JPAEntityFactory;

public class TestDeptCRUD {
	
	@Test
	public void testEdit() {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		Dept dept = new Dept() ;
		dept.setDeptno(10L);
		dept.setDname("软件维护管理部");
		dept.setCreatedate(new Date());
		dept.setNum(30);
		dept.setAvgsal(16872.23);
		// 5、将数据进行持久化管理（保存）
		JPAEntityFactory.getEntityManager().merge(dept); 
		JPAEntityFactory.getEntityManager().getTransaction().commit(); // 事务提交
		JPAEntityFactory.close();
	}
	
	@Test
	public void testDelete() {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 3L) ;
		JPAEntityFactory.getEntityManager().remove(dept); 
		JPAEntityFactory.getEntityManager().getTransaction().commit(); // 事务提交
		JPAEntityFactory.close();
	}
	@Test 
	public void testEdit2() {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		Dept dept = new Dept() ;
		dept.setDname("舞蹈部");
		dept.setCreatedate(new Date());
		dept.setNum(30);
		dept.setAvgsal(3672.23);
		JPAEntityFactory.getEntityManager().merge(dept); 
		JPAEntityFactory.getEntityManager().getTransaction().commit(); // 事务提交
		JPAEntityFactory.close();
	}
	
	@Test
	public void testAddAndGet() {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		Dept dept = new Dept() ;
		dept.setDname("产品研发部");
		dept.setCreatedate(new Date());
		dept.setNum(10);
		dept.setAvgsal(26872.23);
		JPAEntityFactory.getEntityManager().persist(dept);
		JPAEntityFactory.getEntityManager().getTransaction().commit(); // 事务提交
		System.out.println("***** 增加后的部门编号：" + dept.getDeptno());
		JPAEntityFactory.getEntityManager().clear();
		System.out.println("---------------------------------------------");
		System.out.println(JPAEntityFactory.getEntityManager().find(Dept.class, dept.getDeptno())); ;
		JPAEntityFactory.close();
	}
	
	@Test
	public void testFindId() {
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 11L) ;
		System.out.println(dept); 
	} 
	
	@Test
	public void testAdd() {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		Dept dept = new Dept() ;
		dept.setDname("产品研发部");
		dept.setCreatedate(new Date());
		dept.setNum(10);
		dept.setAvgsal(26872.23);
		// 5、将数据进行持久化管理（保存）
		JPAEntityFactory.getEntityManager().persist(dept);
		JPAEntityFactory.getEntityManager().getTransaction().commit(); // 事务提交
		JPAEntityFactory.close();
	}
} 
