package cn.mldn.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.po.Dept;
import cn.mldn.service.IDeptService;
@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptDAO deptDAO ;
	
	@Override
	public boolean editDname(long did, String dname) {
		return this.deptDAO.doEditDname(did, dname) > 0 ;
	}
	@Override
	public boolean remove(Set<Long> ids) {
		return this.deptDAO.doRemoveByIds(ids) > 0; 
	}
	
	@Override
	public Dept get(long did) {
		return this.deptDAO.findById(did);
	}
	
	@Override
	public boolean add(Dept po) {
		Dept dept = this.deptDAO.save(po) ; // 返回持久化后的对象
		System.out.println("【业务层】" + dept); 
		return dept.getDeptno() != null ; 
	}

	@Override
	public List<Dept> list() {
		return this.deptDAO.findAll() ; 
	}

}
