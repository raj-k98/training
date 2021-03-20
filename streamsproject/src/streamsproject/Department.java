package streamsproject;

public class Department {
	private Integer departmentId;
	private String departmentname;
	private Integer managerId;

	public Department(Integer departmentId, String departmentname, Integer managerId) {
		super();
		this.departmentId = departmentId;
		this.departmentname = departmentname;
		this.managerId = managerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentname=" + departmentname + ", managerId="
				+ managerId + "]";
	}

}
