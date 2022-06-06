from fastapi import FastAPI
from routes.index import user,dept_route,employee_grade_route,employee_route,grade_route,salary_details_route
app = FastAPI()

app.include_router(user)
app.include_router(dept_route)
app.include_router(employee_grade_route)
app.include_router(employee_route)
app.include_router(grade_route)
app.include_router(salary_details_route)
