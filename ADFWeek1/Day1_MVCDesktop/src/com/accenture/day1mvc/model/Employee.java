package com.accenture.day1mvc.model;

public class Employee {
	
	private int empId;
	private String empName;
	private double empSal;
	private double totalSal;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public double getTotalSal() {
		return totalSal;
	}
	public void setTotalSal(double totalSal) {
		this.totalSal = totalSal;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", totalSal=" + totalSal
				+ "]";
	}
	
	

}
