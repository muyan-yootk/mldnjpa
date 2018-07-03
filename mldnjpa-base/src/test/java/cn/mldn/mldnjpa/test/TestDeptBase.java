package cn.mldn.mldnjpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import cn.mldn.po.Dept;

public class TestDeptBase {
	@Test
	public void testAdd() {
		// 1、通过指定的持久化单元名称创建一个持久化实体管理类对象（SessionFactory）
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("mldnjpa") ;
		// 2、通过实体管理工厂类创建实体管理类（Session）
		EntityManager entity = managerFactory.createEntityManager() ;
		// 3、增加操作一定要启动事务管理支持，开启事务
		entity.getTransaction().begin();
		// 4、创建一个PO类对象，并且为其设置属性内容
		Dept dept = new Dept() ;
		dept.setDname("产品研发部");
		dept.setCreatedate(new Date());
		dept.setNum(10);
		dept.setAvgsal(26872.23);
		// 5、将数据进行持久化管理（保存）
		entity.persist(dept);
		entity.getTransaction().commit(); // 事务提交
		// 6、关闭相应的连接控制
		entity.close();
		managerFactory.close();
	}
} 
