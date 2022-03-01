package bean;

import java.io.Serializable;
import java.sql.Date;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;


	private int emp_no;
	private String emp_name;
	private String emp_kana;
	private Date hire_ymd;
	private Date retirement_ymd;
	private String department_data;
	private String mail_add;
	private Date update_date;
	private String update_person;
	private Date registered_date;
	private String registered_person;
	private boolean delete_flag;

	public UserBean(){}

	public int getEmpNo() {
		return emp_no;
	}

	public void setEmpNo(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmpName() {
		return emp_name;
	}

	public void setEmpName(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmpKana() {
		return emp_kana;
	}

	public void setEmpKana(String emp_kana) {
		this.emp_kana = emp_kana;
	}

	public Date getHireYmd() {
		return hire_ymd;
	}

	public void setHireYmd(Date hire_ymd) {
		this.hire_ymd = hire_ymd;
	}

	public Date getRetirementYmd() {
		return retirement_ymd;
	}

	public void setRetirementYmd(Date retirement_ymd) {
		this.retirement_ymd = retirement_ymd;
	}

	public String getDepartmentData() {
		return department_data;
	}

	public void setDepartmentData(String department_data) {
		this.department_data = department_data;
	}

	public String getMailAdd() {
		return mail_add;
	}

	public void setMailAdd(String mail_add) {
		this.mail_add = mail_add;
	}

	public Date getUpdateDate() {
		return update_date;
	}

	public void setUpdateDate(Date update_date) {
		this.update_date = update_date;
	}
	public String getUpdatePerson() {
		return update_person;
	}

	public void setUpdatePerson(String update_person) {
		this.update_person = update_person;
	}

	public Date getRegisteredDate() {
		return registered_date;
	}

	public void setRegisteredDate(Date registered_date) {
		this.registered_date = registered_date;
	}

	public String getRegisteredPerson() {
		return registered_person;
	}

	public void setRegisteredPerson(String registered_person) {
		this.registered_person = registered_person;
	}

	public Boolean getDeleteFlag() {
		return delete_flag;
	}

	public void setDeleteFlag(Boolean delete_flag) {
		this.delete_flag = delete_flag;
	}
}