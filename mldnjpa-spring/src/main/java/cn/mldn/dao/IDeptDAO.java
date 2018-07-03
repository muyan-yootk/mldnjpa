package cn.mldn.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import cn.mldn.po.Dept;
public interface IDeptDAO extends Repository<Dept, Long> { 
	@Modifying	// 属于更新操作
	@Query("UPDATE Dept AS d SET d.dname=?2 WHERE d.deptno=?1")
	public int doEditDname(Long deptno,String dname) ;
	@Modifying	// 属于更新操作
	@Query("DELETE FROM Dept AS d WHERE d.deptno=:dno")
	public int doRemoveById(@Param("dno") Long deptno) ;
	@Modifying	// 属于更新操作
	@Query("DELETE FROM Dept AS d WHERE d.deptno IN :dnos")
	public int doRemoveByIds(@Param("dnos") Set<Long> ids) ;
	public Dept save(Dept po) ; // 【实现】增加方法
	@Query("SELECT d FROM Dept AS d WHERE d.deptno=?1")
	public Dept findById(Long deptno) ;
	@Query("SELECT d FROM Dept AS d")
	public List<Dept> findAll() ;
}
 