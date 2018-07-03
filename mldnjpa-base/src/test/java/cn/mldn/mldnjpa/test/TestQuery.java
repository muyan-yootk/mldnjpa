package cn.mldn.mldnjpa.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;

import cn.mldn.po.Dept;
import cn.mldn.util.jpa.JPAEntityFactory;

public class TestQuery { 
	
	@Test
	public void testDelete() {
		String jpql = "DELETE FROM Dept AS d WHERE d.deptno=:pdno" ;
		Query query = JPAEntityFactory.getEntityManager().createQuery(jpql) ;
		query.setParameter("pdno", 5L) ;
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		System.out.println("数据更新影响行数：" + query.executeUpdate());
		JPAEntityFactory.getEntityManager().getTransaction().commit();
	}   
	
	
	@Test
	public void testEdit() {
		String jpql = "UPDATE Dept AS d SET d.dname=:pdna,d.avgsal=:pas WHERE d.deptno=:pdno" ;
		Query query = JPAEntityFactory.getEntityManager().createQuery(jpql) ;
		query.setParameter("pdna", "技术体验部") ;
		query.setParameter("pas", 5671.23) ;
		query.setParameter("pdno", 1L) ;
		JPAEntityFactory.getEntityManager().getTransaction().begin();
		System.out.println("数据更新影响行数：" + query.executeUpdate());
		JPAEntityFactory.getEntityManager().getTransaction().commit();
	}   
	
	@Test
	public void testCount() {
		String jpql = "SELECT COUNT(d) FROM Dept AS d WHERE d.dname LIKE :kw" ;
		TypedQuery<Long> query = JPAEntityFactory.getEntityManager().createQuery(jpql, Long.class) ;
		query.setParameter("kw", "%软%" ) ;
		Long result = query.getSingleResult() ;
		System.out.println("数据行数：" + result);
	}   
	
	@Test
	public void testFindLike() {
		String jpql = "SELECT d FROM Dept AS d WHERE d.dname LIKE :kw" ;
		TypedQuery<Dept> query = JPAEntityFactory.getEntityManager().createQuery(jpql, Dept.class) ;
		query.setParameter("kw", "%软%" ) ;
		query.setFirstResult(0) ; 
		query.setMaxResults(3) ;
		List<Dept> list = query.getResultList() ; // 直接返回List数据信息
		list.forEach((dept)->{
			System.out.println(dept);
		}); 
	}  
	
	@Test
	public void testFindSplit() {
		String jpql = "SELECT d FROM Dept AS d" ;
		TypedQuery<Dept> query = JPAEntityFactory.getEntityManager().createQuery(jpql, Dept.class) ;
		query.setFirstResult(0) ;
		query.setMaxResults(3) ;
		List<Dept> list = query.getResultList() ; // 直接返回List数据信息
		list.forEach((dept)->{
			System.out.println(dept);
		});
	}  
	
	@Test
	public void testFindAll() {
		String jpql = "SELECT d FROM Dept AS d" ;
		TypedQuery<Dept> query = JPAEntityFactory.getEntityManager().createQuery(jpql, Dept.class) ;
		List<Dept> list = query.getResultList() ; // 直接返回List数据信息
		list.forEach((dept)->{
			System.out.println(dept);
		});
	} 
	
	@Test
	public void testFindByIdType() {
		String jpql = "SELECT d FROM Dept AS d WHERE d.deptno=:pdno" ;
		TypedQuery<Dept> query = JPAEntityFactory.getEntityManager().createQuery(jpql, Dept.class) ;
		query.setParameter("pdno", 1L) ; // 设置参数内容 
		Dept dept = query.getSingleResult() ; // 获取一个查询数据
		System.out.println(dept);  
	} 
	
	@Test
	public void testFindByIdFlag() {
		String jpql = "SELECT d FROM Dept AS d WHERE d.deptno=:pdno" ;
		Query query = JPAEntityFactory.getEntityManager().createQuery(jpql, Dept.class) ;
		query.setParameter("pdno", 1L) ; // 设置参数内容 
		Dept dept = (Dept) query.getSingleResult() ; // 获取一个查询数据
		System.out.println(dept); 
	} 
	
	@Test
	public void testFindById() {
		String jpql = "SELECT d FROM Dept AS d WHERE d.deptno=?" ;
		Query query = JPAEntityFactory.getEntityManager().createQuery(jpql, Dept.class) ;
		query.setParameter(0, 1L) ; // 设置参数内容
		Dept dept = (Dept) query.getSingleResult() ; // 获取一个查询数据
		System.out.println(dept); 
	}
	
	
	
}
