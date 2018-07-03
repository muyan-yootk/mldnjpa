package cn.mldn.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
public class Dept implements Serializable {   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptno;
	private double avgsal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	private String dname;
	private int num;
	@Version
	private Long vseq ;  
	
	// setter、getter略
	public Dept() {
	}

	public Long getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Long deptno) {
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

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", avgsal=" + avgsal + ", createdate=" + createdate + ", dname=" + dname
				+ ", num=" + num + "]";
	}
	

}