package cn.mldn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.po.Dept;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDeptDAO {
	@Autowired
	private IDeptDAO deptDAO;
	@Test
	public void testSplit() { 
		int currentPage = 1 ;
		int lineSize = 3 ;
		Sort sort = new Sort(Sort.Direction.DESC, "deptno");	// 定义排序字段
		Pageable pageable = PageRequest.of((currentPage - 1) * lineSize, lineSize, sort);
		Page<Dept> page = this.deptDAO.findAll(pageable) ;
		System.out.println("【总记录数】" + page.getTotalElements());
		System.out.println("【总页数】" + page.getTotalPages());
		List<Dept> content = page.getContent() ; // 分页数据
		System.out.println(content);
	}

	@Test
	public void testSaveAll() { 
		List<Dept> all = new ArrayList<Dept>() ;
		for (int x = 0 ; x < 10 ; x ++) {
			Dept dept = new Dept();
			dept.setDeptno(10L);
			dept.setDname("小强  -  " + x);
			dept.setCreatedate(new Date());
			dept.setNum(30);
			dept.setAvgsal(1.23);
			all.add(dept) ;
		}
		System.out.println(this.deptDAO.saveAll(all));
	}
	
	@Test
	public void testSave() { 
		Dept dept = new Dept();
		dept.setDeptno(10L);
		dept.setDname("小强人事部");
		dept.setCreatedate(new Date());
		dept.setNum(30);
		dept.setAvgsal(-16872.23);
		System.out.println(this.deptDAO.save(dept));
	}

	@Test
	public void testFindAll() {
		System.out.println(this.deptDAO.findAll());
	}

	@Test
	public void testDelete() {
		this.deptDAO.deleteById(5L);
	}

	@Test
	public void testFindById() {
		Optional<Dept> optional = this.deptDAO.findById(5L);
		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
	}

}
