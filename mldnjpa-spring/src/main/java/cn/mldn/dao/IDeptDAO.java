package cn.mldn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.mldn.po.Dept;
public interface IDeptDAO extends JpaRepository<Dept, Long> { 
}
  