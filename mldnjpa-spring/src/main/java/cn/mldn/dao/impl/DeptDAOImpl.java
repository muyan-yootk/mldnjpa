package cn.mldn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cn.mldn.dao.IDeptDAO;
import cn.mldn.po.Dept;
@Repository
public class DeptDAOImpl implements IDeptDAO {
	@PersistenceContext
	private EntityManager entityManager ;	// 通过外部配置的Factory获取Manager
	@Override
	public boolean doCreate(Dept po) {
		this.entityManager.persist(po); 
		return true; 
	}

	@Override
	public List<Dept> findAll() {
		String jpql = "SELECT d FROM Dept d" ;
		TypedQuery<Dept> query = this.entityManager.createQuery(jpql,Dept.class) ;
		return query.getResultList(); 
	}

}
