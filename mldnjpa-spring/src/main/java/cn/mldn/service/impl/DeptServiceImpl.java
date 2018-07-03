package cn.mldn.service.impl;

import java.util.List;

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
	public boolean add(Dept po) {
		return this.deptDAO.doCreate(po);
	}

	@Override
	public List<Dept> list() {
		return this.deptDAO.findAll() ; 
	}

}
