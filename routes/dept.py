from fastapi import APIRouter
from config.db import conn
from models.index import dept
from schemas.index import Dept

dept_route = APIRouter()

@dept_route.get("/dept/")
async def read_data():
    return conn.execute(dept.select()).fetchall()

@dept_route.get("/dept/{id}")
async def read_data_id(id):
    return conn.execute(dept.select().where
    (dept.c.dept_id == id)).fetchall()

@dept_route.post("/dept/")
async def write_data(depts: Dept):
    conn.execute(dept.insert().values(
        dept_name = depts.dept_name,
    ))

@dept_route.put("/dept/{id}")
async def update_data(id: int, depts: Dept):
    conn.execute(dept.update().values(
        dept_name = depts.dept_name,       
    ).where(dept.c.dept_id == id)).fetchall()

@dept_route.delete("/dept/{id}")
async def delete_data(id : int):
    conn.execute(dept.delete().where(dept.c.dept_id == id))
    return conn.execute(dept.select()).fetchall()