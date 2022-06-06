from fastapi import APIRouter
from config.db import conn
from models.index import employee_grade
from schemas.index import Employee_grade

employee_grade_route = APIRouter()

@employee_grade_route.get("/emp_grade/")
async def read_data():
    return conn.execute(employee_grade.select()).fetchall()

@employee_grade_route.get("/emp_grade/{id}")
async def read_data_id(id):
    return conn.execute(employee_grade.select().where
    (employee_grade.c.emp_id == id)).fetchall()

@employee_grade_route.post("/emp_grade/")
async def write_data(employee_grades: Employee_grade):
    conn.execute(employee_grade.insert().values(
        emp_id = employee_grades.emp_id,
        emp_dept_id = employee_grades.emp_dept_id,
        emp_grade_id = employee_grades.emp_grade_id,
    ))

@employee_grade_route.put("/emp_grade/{id}")
async def update_data(id: int, employee_grades: Employee_grade):
    conn.execute(employee_grade.update().values(
        emp_id = employee_grades.emp_id,
        emp_dept_id = employee_grades.emp_dept_id,
        emp_grade_id = employee_grades.emp_grade_id,     
    ).where(employee_grade.c.emp_id == id)).fetchall()

@employee_grade_route.delete("/emp_grade/{id}")
async def delete_data(id:int):
    conn.execute(employee_grade.delete().where(employee_grade.c.emp_id == id))
    return conn.execute(employee_grade.select()).fetchall()