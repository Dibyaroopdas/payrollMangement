package com.example.payrollmanagement.models;


import java.sql.Date;

public class EmployeeGradeModel {

    int transaction_id,emp_id,emp_dept_id,emp_grade_id;



    public EmployeeGradeModel() {

    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_dept_id() {
        return emp_dept_id;
    }

    public void setEmp_dept_id(int emp_dept_id) {
        this.emp_dept_id = emp_dept_id;
    }

    public int getEmp_grade_id() {
        return emp_grade_id;
    }

    public void setEmp_grade_id(int emp_grade_id) {
        this.emp_grade_id = emp_grade_id;
    }


}
