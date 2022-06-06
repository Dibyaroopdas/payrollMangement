from fastapi import APIRouter
from config.db import conn
from models.index import employee
from schemas.index import Employee

employee_route = APIRouter()

@employee_route.get("/employee/")
async def read_data():
    return conn.execute(employee.select()).fetchall()

@employee_route.get("/employee/{id}")
async def read_data_id(id):
    return conn.execute(employee.select().where
    (employee.c.emp_id == id)).fetchall()

@employee_route.post("/employee/")
async def write_data(employees: Employee):
    conn.execute(employee.insert().values(
        emp_surname = employees.emp_surname,
        emp_name = employees.emp_name,
        emp_address = employees.emp_address,
        emp_city = employees.emp_city,
        emp_pincode = employees.emp_pincode,
        emp_mobile_no = employees.emp_mobile_no,
        emp_state = employees.emp_state,
        emp_mail_id = employees.emp_mail_id,
        emp_pan_no = employees.emp_pan_no
    ))

@employee_route.put("/employee/{id}")
async def update_data(id: int, employees: Employee):
    conn.execute(employee.update().values(
        emp_surname = employees.emp_surname,
        emp_name = employees.emp_name,
        emp_address = employees.emp_address,
        emp_city = employees.emp_city,
        emp_pincode = employees.emp_pincode,
        emp_mobile_no = employees.emp_mobile_no,
        emp_state = employees.emp_state,
        emp_mail_id = employees.emp_mail_id,
        emp_pan_no = employees.emp_pan_no
    ).where(employee.c.id == id)).fetchall()

@employee_route.delete("/employee/{id}")
async def delete_data(id: int):
    conn.execute(employee.delete().where(employee.c.emp_id == id))
    return conn.execute(employee.select()).fetchall()