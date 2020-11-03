package com.accenture.ioc.utility;

public class EmployeeSQLQueries {

	private String searchEmployee;
	private String createEmployee;
	private String deleteEmployee;
	
	public EmployeeSQLQueries() {
		// TODO Auto-generated constructor stub
		System.out.println("EmployeeSQLQueries object getting constructed ");
	}

	public EmployeeSQLQueries(String searchEmployee, String createEmployee, String deleteEmployee) {
		super();
		System.out.println("EmployeeSQLQueries Parameterised constructer called");
		this.searchEmployee = searchEmployee;
		this.createEmployee = createEmployee;
		this.deleteEmployee = deleteEmployee;
	}

	public String getSearchEmployee() {
		System.out.println("In getSearchEmployee");
		return searchEmployee;
	}

	public void setSearchEmployee(String searchEmployee) {
		System.out.println("In setSearchEmployee");
		this.searchEmployee = searchEmployee;
	}

	public String getCreateEmployee() {
		System.out.println("In getCreateEmployee");
		return createEmployee;
	}

	public void setCreateEmployee(String createEmployee) {
		System.out.println("In setCreateEmployee");
		this.createEmployee = createEmployee;
	}

	public String getDeleteEmployee() {
		System.out.println("In getDeleteEmployee");
		return deleteEmployee;
	}

	public void setDeleteEmployee(String deleteEmployee) {
		System.out.println("In setDeleteEmployee");
		this.deleteEmployee = deleteEmployee;
	}
}
