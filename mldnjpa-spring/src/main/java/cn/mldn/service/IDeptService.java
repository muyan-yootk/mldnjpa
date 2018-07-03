package cn.mldn.service;

import java.util.List;

import cn.mldn.po.Dept;

public interface IDeptService {
	public boolean add(Dept po) ;
	public List<Dept> list() ;  
}
