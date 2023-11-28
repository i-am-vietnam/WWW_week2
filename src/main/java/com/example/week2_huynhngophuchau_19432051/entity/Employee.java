package com.example.week2_huynhngophuchau_19432051.entity;

import java.util.Date;

public class Employee {
        private int empId;
        private String fullName;
        private Date dob;
        private String email;
        private String phone;
        private String address;
        private int status;

        public Employee(int empId, String fullName, Date dob, String email, String phone, String address, int status) {
            this.empId = empId;
            this.fullName = fullName;
            this.dob = dob;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.status = status;
        }

        public Employee() {
        }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
