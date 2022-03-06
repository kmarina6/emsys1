package bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;


	private String emp_no;
	private String emp_name;
	private String emp_kana;
	private String hire_ymd;
	private String retirement_ymd;
	private String department_data;
	private String mail_add;
	private String update_date;
	private String update_person;
	private String registered_date;
	private String registered_person;
	private String delete_flag;

	public UserBean(){}

	public String getEmpNo() {
		return emp_no;
	}

	public void setEmpNo(String emp_no) {
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

	public String getHireYmd() {
		return hire_ymd;
	}

	public void setHireYmd(String hire_ymd) {
		this.hire_ymd = hire_ymd;
	}

	public String getRetirementYmd() {
		return retirement_ymd;
	}

	public void setRetirementYmd(String retirement_ymd) {
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

	public String getUpdateDate() {
		return update_date;
	}

	public void setUpdateDate(String update_date) {
		this.update_date = update_date;
	}
	public String getUpdatePerson() {
		return update_person;
	}

	public void setUpdatePerson(String update_person) {
		this.update_person = update_person;
	}

	public String getRegisteredDate() {
		return registered_date;
	}

	public void setRegisteredDate(String registered_date) {
		this.registered_date = registered_date;
	}

	public String getRegisteredPerson() {
		return registered_person;
	}

	public void setRegisteredPerson(String registered_person) {
		this.registered_person = registered_person;
	}

	public String getDeleteFlag() {
		return delete_flag;
	}

	public void setDeleteFlag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
}