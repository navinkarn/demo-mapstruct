package com.example.demo.dto;

public class EmployeeDto {
    private long empId;
    private String fullName;
    private String startDate;
    private String externalId;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId=" + empId +
                ", fullName='" + fullName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", externalId='" + externalId + '\'' +
                '}';
    }
}
