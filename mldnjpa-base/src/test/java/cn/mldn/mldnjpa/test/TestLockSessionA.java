package cn.mldn.mldnjpa.test;

import java.util.concurrent.TimeUnit;

import javax.persistence.LockModeType;

import org.junit.Test;

import cn.mldn.po.Dept;
import cn.mldn.util.jpa.JPAEntityFactory;

public class TestLockSessionA {

	@Test
	public void testLockSessionA() throws Exception {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		// 根据id进行数据的查询，并且进行读锁的配置处理
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 1L, LockModeType.PESSIMISTIC_WRITE);
		dept.setDname("中国软件协会"); 
		TimeUnit.SECONDS.sleep(30);
		System.out.println("SessionA数据更新完毕。");
		JPAEntityFactory.getEntityManager().getTransaction().commit();
	}
	
	@Test
	public void testLockSessionOPTA() throws Exception {
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		// 根据id进行数据的查询，并且进行读锁的配置处理
		Dept dept = JPAEntityFactory.getEntityManager().find(Dept.class, 1L, LockModeType.OPTIMISTIC_FORCE_INCREMENT); 
		dept.setDname("中国科学管理学会"); 
		TimeUnit.SECONDS.sleep(30);	// 休眠30秒
		System.out.println("SessionA数据更新完毕。");
		JPAEntityFactory.getEntityManager().getTransaction().commit();
	} 
}
