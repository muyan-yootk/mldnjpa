package cn.mldn.dao;

import java.util.List;

import cn.mldn.po.Dept;

public interface IDeptDAO { 
	public boolean doCreate(Dept po) ;
	public List<Dept> findAll() ; 
}
 