package cn.mldn.dao;

import org.springframework.data.repository.CrudRepository;

import cn.mldn.po.Dept;
public interface IDeptDAO extends CrudRepository<Dept, Long> { 
}
  