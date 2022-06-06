package com.example.payrollmanagement.models;


import java.sql.Date;

public class EmployeeModel {

    int emp_id,emp_pincode;
    String emp_surname,emp_name,emp_address,emp_city,emp_state,emp_mail_id,emp_pan_no,emp_mobile_no ;


    public EmployeeModel() {
    }





    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_pincode() {
        return emp_pincode;
    }

    public void setEmp_pincode(int emp_pincode) {
        this.emp_pincode = emp_pincode;
    }

    public String getEmp_mobile_no() {
        return emp_mobile_no;
    }

    public void setEmp_mobile_no(String emp_mobile_no) {
        this.emp_mobile_no = emp_mobile_no;
    }

    public String getEmp_surname() {
        return emp_surname;
    }

    public void setEmp_surname(String emp_surname) {
        this.emp_surname = emp_surname;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public String getEmp_state() {
        return emp_state;
    }

    public void setEmp_state(String emp_state) {
        this.emp_state = emp_state;
    }

    public String getEmp_mail_id() {
        return emp_mail_id;
    }

    public void setEmp_mail_id(String emp_mail_id) {
        this.emp_mail_id = emp_mail_id;
    }

    public String getEmp_pan_no() {
        return emp_pan_no;
    }

    public void setEmp_pan_no(String emp_pan_no) {
        this.emp_pan_no = emp_pan_no;
    }


}
