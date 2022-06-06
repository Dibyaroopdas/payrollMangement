from fastapi import APIRouter
from config.db import conn
from models.index import grade
from schemas.index import Grade

grade_route = APIRouter()

@grade_route.get("/grade/")
async def read_data():
    return conn.execute(grade.select()).fetchall()

@grade_route.get("/grade/{id}")
async def read_data_id(id):
    return conn.execute(grade.select().where
    (grade.c.grade_id == id)).fetchall()

@grade_route.post("/grade/")
async def write_data(grades: Grade):
    conn.execute(grade.insert().values(
        grade_name = grades.grade_name,
        grade_name_short = grades.grade_name_short,
        grade_basic = grades.grade_basic,
        grade_ta = grades.grade_ta,
        grade_hra = grades.grade_hra,
        grade_ma = grades.grade_ma,
        grade_bonus = grades.grade_bonus,
        grade_pf = grades.grade_pf,
        grade_pt = grades.grade_pt

    )).fetchall()

@grade_route.put("/grade/{id}")
async def update_data(id: int, grades: Grade):
    conn.execute(grade.update().values(
        grade_name = grades.grade_name,
        grade_name_short = grades.grade_name_short,
        grade_basic = grades.grade_basic,
        grade_ta = grades.grade_ta,
        grade_hra = grades.grade_hra,
        grade_ma = grades.grade_ma,
        grade_bonus = grades.grade_bonus,
        grade_pf = grades.grade_pf,
        grade_pt = grades.grade_pt      
    ).where(grade.c.grade_id== id)).fetchall()

@grade_route.delete("/grade/{id}")
async def delete_data(id : int):
    conn.execute(grade.delete().where(grade.c.grade_id == id))
    return conn.execute(grade.select()).fetchall()