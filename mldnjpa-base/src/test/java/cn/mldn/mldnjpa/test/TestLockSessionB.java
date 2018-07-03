package cn.mldn.mldnjpa.test;

import java.util.concurrent.TimeUnit;

import javax.persistence.LockModeType;

import org.junit.Test;

import cn.mldn.po.Dept;
import cn.mldn.util.jpa.JPAEntityFactory;

public class TestLockSessionB {

	@Test
	public void testLockSessionB() throws Exception {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		// 根据id进行数据的查询，并且进行读锁的配置处理
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		dept.setDname("中国田胖胖大会"); 
		System.out.println("SessionB数据更新完毕。");
		JPAEntityFactory.getEntityManager().getTransaction().commit();
	}
	
	@Test
	public void testLockSessionOPTB() throws Exception {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		// 根据id进行数据的查询，并且进行读锁的配置处理
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 1L, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		dept.setDname("中国田笨笨研究中心"); 
		dept.setAvgsal(1.1);
		System.out.println("SessionB数据更新完毕。");
		JPAEntityFactory.getEntityManager().getTransaction().commit();
	}
}
