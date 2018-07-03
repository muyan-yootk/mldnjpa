package cn.mldn.service;

import java.util.List;
import java.util.Set;

import cn.mldn.po.Dept;

public interface IDeptService {
	public boolean add(Dept po) ;
	public List<Dept> list() ;  
	public Dept get(long did) ;
	public boolean editDname(long did,String dname) ;
	public boolean remove(Set<Long> ids) ;
}
