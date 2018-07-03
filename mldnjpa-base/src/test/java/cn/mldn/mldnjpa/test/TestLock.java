package cn.mldn.mldnjpa.test;

import javax.persistence.LockModeType;

import org.junit.Test;

import cn.mldn.po.Dept;
import cn.mldn.util.jpa.JPAEntityFactory;

public class TestLock {

	@Test
	public void testLockB() {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		// 根据id进行数据的查询，并且进行读锁的配置处理
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		System.out.println(dept);  
		JPAEntityFactory.getEntityManager().getTransaction().rollback();
	}
	
	@Test
	public void testLockA() {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		// 根据id进行数据的查询，并且进行读锁的配置处理
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 1L, LockModeType.PESSIMISTIC_READ);
		System.out.println(dept); 
		JPAEntityFactory.getEntityManager().getTransaction().rollback();
	}
}
