from fastapi import APIRouter
from config.db import conn
from models.index import users
from schemas.index import User,Dept,Employee_grade,Employee,Grade,Salary_details

user = APIRouter()

@user.get("/")
async def read_data():
    return conn.execute(users.select()).fetchall()

@user.get("/user/{id}")
async def read_data_id(id):
    return conn.execute(users.select().where
    (users.c.id == id)).fetchall()

@user.post("/user/")
async def write_data(user: User):
    conn.execute(users.insert().values(
        user_name = user.user_name,
        user_email = user.user_email,
        user_type = user.user_type,
        user_password = user.user_password

    )).fetchall()

@user.put("/user/{id}")
async def update_data(id: int, user: User):
    conn.execute(users.update().values(
        user_name = user.user_name,
        user_email = user.user_email,
        user_type = user.user_type,
        user_password = user.user_password        
    ).where(users.c.id == id)).fetchall()

@user.delete("/")
async def delete_data():
    conn.execute(users.delete().where(users.c.id == id))
    return conn.execute(users.select()).fetchall()