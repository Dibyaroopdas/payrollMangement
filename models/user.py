from sqlalchemy.sql.sqltypes import String,Integer,Date
from sqlalchemy import Integer, Table,Column
from config.db import meta

users = Table(
    'user_table',meta,
    Column('user_id',Integer,primary_key=True),
    Column('user_name',String(255)),
    Column('user_email',String(255)),
    Column('user_type',String(255)),
    Column('user_password',String(255))
)

dept = Table(
    'dept_table',meta,
    Column('dept_id',Integer,primary_key=True),
    Column('dept_name',String(255)),
)

employee_grade = Table(
    'employee_grade_table',meta,
    Column('transaction_id',Integer,primary_key=True),
    Column('emp_id',String(255)),
    Column('emp_dept_id',String(255)),
    Column('emp_grade_id',String(255))
)

employee = Table(
    'employee_table',meta,
    Column('emp_id',Integer,primary_key=True),
    Column('emp_surname',String(255)),
    Column('emp_name',String(255)),
    Column('emp_address',String(255)),
    Column('emp_city',String(255)),
    Column('emp_pincode',Integer),
    Column('emp_mobile_no',String(11)),
    Column('emp_state',String(255)),
    Column('emp_mail_id',String(255)),
    Column('emp_pan_no',String(255)),
)

grade = Table(
    'grade_table',meta,
    Column('grade_id',Integer,primary_key=True),
    Column('grade_name',String(255)),
    Column('grade_name_short',String(255)),
    Column('grade_basic',Integer),
    Column('grade_ta',Integer),
    Column('grade_hra',Integer),
    Column('grade_ma',Integer),
    Column('grade_bonus',Integer),
    Column('grade_pf',Integer),
    Column('grade_pt',Integer),
)

salary_details = Table(
    'salary_details_table',meta,
    Column('transacton_id',Integer,primary_key=True),
    Column('emp_id',Integer),
    Column('emp_salary_month',String(255)),
    Column('emp_salary_year',String(255)),
    Column('emp_dept_id',Integer),
    Column('emp_grade_id',Integer),
    Column('emp_basic',Integer),
    Column('emp_ta',Integer),
    Column('emp_hra',Integer),
    Column('emp_ma',Integer),
    Column('emp_bonus',Integer),
    Column('emp_pf',Integer),
    Column('emp_pt',Integer),
    Column('emp_gross',Integer),
    Column('emp_total_salary',Integer)
)