package model;

import java.io.Serializable;

public class SearchUser implements Serializable {

	//フィールド
	private String emp_no;
	private String emp_no_after;
	private String emp_name;
	private String emp_kana;
	private String hire_ymd;

	private String hire_y;
	private String hire_m;
	private String hire_d;

	private String retirement_ymd;

	private String retirement_y;
	private String retirement_m;
	private String retirement_d;

	private String department_data;
	private String mail_add;
	private String update_date;
	private String update_person;
	private String registered_date;
	private String registered_person;

	public SearchUser(String emp_no, String emp_no_after, String emp_name, String emp_kana, String hire_ymd, String hire_y, String hire_m, String hire_d, String retirement_ymd, String retirement_y, String retirement_m, String retirement_d, String department_data, String mail_add, String update_date, String update_person, String registered_date, String registered_person){

		this.emp_no = emp_no;
		this.emp_no_after = emp_no_after;
		this.emp_name = emp_name;
		this.emp_kana = emp_kana;
		this.hire_ymd = hire_ymd;

		this.hire_y = hire_y;
		this.hire_m = hire_m;
		this.hire_d = hire_d;

		this.retirement_ymd = retirement_ymd;

		this.retirement_y = retirement_y;
		this.retirement_m = retirement_m;
		this.retirement_d = retirement_d;

		this.department_data = department_data;
		this.mail_add = mail_add;
		this.update_date = update_date;
		this.update_person = update_person;
		this.registered_date = registered_date;
		this.registered_person = registered_person;

	}


	//アクセッサ

	public String getEmpNo() {
		//System.out.print("kiteruyo_UserToUpdDate" + emp_no + "  ");
		return emp_no;
	}
	public String getEmpNoAfter() {
		//System.out.print("kiteruyo_UserToUpdDate_after" + emp_no_after + "  ");
		return emp_no_after;
	}
	public String getEmpName() {
		return emp_name;
	}
	public String getEmpKana() {
		return emp_kana;
	}
	public String getHireYmd() {
		return hire_ymd;
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

	public String getRetirementYmd() {
		return retirement_ymd;
	}

	public String getRetirementY() {
		return retirement_y;
	}
	public String getRetirementM() {
		return retirement_m;
	}
	public String getRetirementD() {
		return retirement_d;
	}

	public String getDepartmentData() {
		System.out.print("SerchUser_department_data" + department_data + "  ");
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