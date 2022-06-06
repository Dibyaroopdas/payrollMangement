from datetime import date
import imp
from os import access
from tokenize import String
from pydantic import BaseModel
from pymysql import Date
from sqlalchemy import Integer

class User(BaseModel):
    user_name:str
    user_email:str
    user_type:str
    user_password:str

class Dept(BaseModel):
    dept_name:str

class Employee_grade(BaseModel):
    emp_id:int
    emp_dept_id:str
    emp_grade_id:str


class Employee(BaseModel):
    emp_surname:str
    emp_name:str
    emp_address:str
    emp_city:str
    emp_pincode:int
    emp_mobile_no:str
    emp_state:str
    emp_mail_id:str
    emp_pan_no:str

class Grade(BaseModel):
    grade_name:str
    grade_name_short:str
    grade_basic:int
    grade_ta:int
    grade_hra:int
    grade_ma:int
    grade_bonus:int
    grade_pf:int
    grade_pt:int

class Salary_details(BaseModel):
    transacton_id:int
    emp_id:int
    emp_salary_month:str
    emp_salary_year:str
    emp_dept_id:int
    emp_grade_id:int
    emp_basic:int
    emp_ta:int
    emp_hra:int
    emp_ma:int
    emp_bonus:int
    emp_pf:int
    emp_pt:int
    emp_gross:int
    emp_total_salary:int