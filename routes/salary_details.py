from fastapi import APIRouter
from config.db import conn
from models.index import salary_details
from schemas.index import Salary_details

salary_details_route = APIRouter()

@salary_details_route.get("/salary_det/")
async def read_data():
    return conn.execute(salary_details.select()).fetchall()

@salary_details_route.get("/salary_det/{id}")
async def read_data_id(id):
    return conn.execute(salary_details.select().where
    (salary_details.c.emp_id == id)).fetchall()

@salary_details_route.post("/salary_det/")
async def write_data(salary_detail: Salary_details):
    conn.execute(salary_details.insert().values(
        transacton_id = salary_detail.transacton_id,
        emp_id = salary_detail.emp_id,
        emp_salary_month = salary_detail.emp_id,
        emp_salary_year = salary_detail.emp_id,
        emp_dept_id = salary_detail.emp_dept_id,
        emp_grade_id = salary_detail.emp_grade_id,
        emp_basic = salary_detail.emp_basic,
        emp_ta = salary_detail.emp_ta,
        emp_hra = salary_detail.emp_hra,
        emp_ma = salary_detail.emp_ma,
        emp_bonus = salary_detail.emp_bonus,
        emp_pf = salary_detail.emp_pf,
        emp_pt = salary_detail.emp_pt,
        emp_gross = salary_detail.emp_gross,
        emp_total_salary = salary_detail.emp_total_salary

    )).fetchall()

@salary_details_route.put("/salary_det/{id}")
async def update_data(id: int, salary_detail: Salary_details):
    conn.execute(salary_details.update().values(
        transacton_id = salary_detail.transacton_id,
        emp_id = salary_detail.emp_id,
        emp_salary_month = salary_detail.emp_id,
        emp_salary_year = salary_detail.emp_id,
        emp_dept_id = salary_detail.emp_dept_id,
        emp_grade_id = salary_detail.emp_grade_id,
        emp_basic = salary_detail.emp_basic,
        emp_ta = salary_detail.emp_ta,
        emp_hra = salary_detail.emp_hra,
        emp_ma = salary_detail.emp_ma,
        emp_bonus = salary_detail.emp_bonus,
        emp_pf = salary_detail.emp_pf,
        emp_pt = salary_detail.emp_pt,
        emp_gross = salary_detail.emp_gross,
        emp_total_salary = salary_detail.emp_total_salary   
    ).where(salary_details.c.transaction_id == id)).fetchall()

@salary_details_route.delete("/salary_det/{id}")
async def delete_data(id : int):
    conn.execute(salary_details.delete().where(salary_details.c.transaction_id == id))
    return conn.execute(salary_details.select()).fetchall()