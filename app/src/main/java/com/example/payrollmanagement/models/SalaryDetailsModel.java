package com.example.payrollmanagement.models;

import java.util.Date;

public class SalaryDetailsModel {

    int transaction_id,emp_id,emp_dept_id,emp_grade_id,emp_basic,emp_da,emp_ta,
            emp_hra,emp_ma,emp_bonus,emp_pf,emp_pt,emp_gross,emp_total_salary;
    String emp_salary_month,emp_salary_year;
    Date emp_salary_eimbursment_date;

    public SalaryDetailsModel() {

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

    public int getEmp_basic() {
        return emp_basic;
    }

    public void setEmp_basic(int emp_basic) {
        this.emp_basic = emp_basic;
    }

    public int getEmp_da() {
        return emp_da;
    }

    public void setEmp_da(int emp_da) {
        this.emp_da = emp_da;
    }

    public int getEmp_ta() {
        return emp_ta;
    }

    public void setEmp_ta(int emp_ta) {
        this.emp_ta = emp_ta;
    }

    public int getEmp_hra() {
        return emp_hra;
    }

    public void setEmp_hra(int emp_hra) {
        this.emp_hra = emp_hra;
    }

    public int getEmp_ma() {
        return emp_ma;
    }

    public void setEmp_ma(int emp_ma) {
        this.emp_ma = emp_ma;
    }

    public int getEmp_bonus() {
        return emp_bonus;
    }

    public void setEmp_bonus(int emp_bonus) {
        this.emp_bonus = emp_bonus;
    }

    public int getEmp_pf() {
        return emp_pf;
    }

    public void setEmp_pf(int emp_pf) {
        this.emp_pf = emp_pf;
    }

    public int getEmp_pt() {
        return emp_pt;
    }

    public void setEmp_pt(int emp_pt) {
        this.emp_pt = emp_pt;
    }

    public int getEmp_gross() {
        return emp_gross;
    }

    public void setEmp_gross(int emp_gross) {
        this.emp_gross = emp_gross;
    }

    public int getEmp_total_salary() {
        return emp_total_salary;
    }

    public void setEmp_total_salary(int emp_total_salary) {
        this.emp_total_salary = emp_total_salary;
    }

    public String getEmp_salary_month() {
        return emp_salary_month;
    }

    public void setEmp_salary_month(String emp_salary_month) {
        this.emp_salary_month = emp_salary_month;
    }

    public String getEmp_salary_year() {
        return emp_salary_year;
    }

    public void setEmp_salary_year(String emp_salary_year) {
        this.emp_salary_year = emp_salary_year;
    }

    public Date getEmp_salary_eimbursment_date() {
        return emp_salary_eimbursment_date;
    }

    public void setEmp_salary_eimbursment_date(Date emp_salary_eimbursment_date) {
        this.emp_salary_eimbursment_date = emp_salary_eimbursment_date;
    }
}
