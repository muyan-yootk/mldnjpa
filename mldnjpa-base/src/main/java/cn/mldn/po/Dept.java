package cn.mldn.po;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name="dept")
public class Dept implements Serializable { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String deptno;
	private double avgsal;
	@Temporal(TemporalType.DATE)
	private Date createdate;
	private String dname;
	private int num;
	// setter、getter略
	public Dept() {
	}

	public String getDeptno() {
		return this.deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public double getAvgsal() {
		return this.avgsal;
	}

	public void setAvgsal(double avgsal) {
		this.avgsal = avgsal;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}