package model;

import java.io.Serializable;

public class User implements Serializable {

	//フィールド
	private String emp_no;
	private String emp_name;
	private String emp_kana;
	private String hire_y;
	private String hire_m;
	private String hire_d;
	//private String retirement_ymd;
	private String department_data;
	private String mail_add;
	private String update_date;
	private String update_person;
	private String registered_date;
	private String registered_person;

	public User(String emp_no, String emp_name, String emp_kana, String hire_y, String hire_m, String hire_d, String department_data, String mail_add, String update_date, String update_person, String registered_date, String registered_person){
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_kana = emp_kana;
		this.hire_y = hire_y;
		this.hire_m = hire_m;
		this.hire_d = hire_d;
		//this.retirement_ymd = retirement_ymd;
		this.department_data = department_data;
		this.mail_add = mail_add;
		this.update_date = update_date;
		this.update_person = update_person;
		this.registered_date = registered_date;
		this.registered_person = registered_person;

	}


	//アクセッサ

	public String getEmpNo() {

		return emp_no;
	}
	public String getEmpName() {
		return emp_name;
	}
	public String getEmpKana() {
		return emp_kana;
	}
	public String getHireY() {
		return hire_y;
	}
	public String getHireM() {
		return hire_m;
	}
	public String getHireD() {
		return hire_d;
	}

	public String getDepartmentData() {
		return department_data;
	}
	public String getMailAdd() {
		return mail_add;
	}
	public String getUpdateDate() {
		return update_date;
	}
	public String getUpdatePerson() {
		return update_person;
	}
	public String getRegisteredDate() {
		return registered_date;
	}
	public String getRegisteredPerson() {
		return registered_person;
	}
}