package cn.mldn.mldnjpa.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import cn.mldn.po.Dept;
import cn.mldn.util.jpa.JPAEntityFactory;

public class TestNative {
	@Test
	public void testFindAll2() { 
		String sql = "SELECT deptno,dname,createdate,num,avgsal FROM dept" ;
		// 所有的查询语句都通过Criteria创建，而真正发出查询的一定还是Query
		Query query = JPAEntityFactory.getEntityManager().createNativeQuery(sql) ;
		List<Object[]> list = query.getResultList() ;
		list.forEach((array)->{ 
			System.out.println(Arrays.toString(array));   
		});
	}
	
	@Test
	public void testFindAll() {
		String sql = "SELECT deptno,dname,createdate,num,avgsal FROM dept" ;
		// 所有的查询语句都通过Criteria创建，而真正发出查询的一定还是Query
		Query query = JPAEntityFactory.getEntityManager().createNativeQuery(sql,Dept.class) ;
		List<Dept> list = query.getResultList() ;
		list.forEach((dept)->{ 
			System.out.println(dept);  
		});
	}
	
	
	
	
}
