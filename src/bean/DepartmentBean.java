package bean;

import java.io.Serializable;

public class DepartmentBean implements Serializable {
	private static final long serialVersionUID = 1L;


	private String id;
	private String job_name;

	public DepartmentBean(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return job_name;
	}

	public void setJobName(String job_name) {
		this.job_name = job_name;
	}
}

