package cn.mldn.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.po.Dept;
import cn.mldn.service.IDeptService;


@ContextConfiguration(locations= {"classpath:spring/spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class) 
public class TestDeptService {
	@Autowired
	private IDeptService deptService ;
	@Test 
	public void testEdit() {
		System.out.println(this.deptService.editDname(1, "小强生产部"));
	}
	@Test 
	public void testRemove() {
		Set<Long> ids = new HashSet<Long>() ;
		ids.add(1L) ;
		ids.add(2L) ;
		ids.add(3L) ;
		System.out.println(this.deptService.remove(ids));
	}
	
	@Test 
	public void testGet() {
		System.out.println(this.deptService.get(1L));
	}
	@Test
	public void testAdd() {
		Dept dept = new Dept() ;
		dept.setDeptno(10L);
		dept.setDname("软件维护管理部");
		dept.setCreatedate(new Date());
		dept.setNum(30);
		dept.setAvgsal(16872.23);
		System.out.println(this.deptService.add(dept));
	}
	@Test 
	public void testList() {
		System.out.println(this.deptService.list());
	}
}
