show databases;
use employees;
show tables;

#1
select gender, count(*) as 'Count'
from employees
group by gender;
#2a
select first_name , count(*) as 'Count'
from employees
group by first_name
order by count(*) DESC
LIMIT 1;
#2b
select first_name , count(*) as 'Count'
from employees
where gender = 'M'
group by first_name
order by count(*) DESC
LIMIT 1;
#2c
select first_name , count(*) as 'Count'
from employees
where gender = 'F'
group by first_name 
order by count(*) DESC
LIMIT 1;
#3
select employees.last_name as 'Last Name', count(*)as 'Count'
from employees, dept_manager
where employees.emp_no = dept_manager.emp_no
group by last_name
order by count(*) DESC ;
#4a
select gender as 'Gender', avg(salary) as 'Average Salary'
from employees
INNER JOIN salaries on employees.emp_no = salaries.emp_no
group by gender having gender = 'M';
#4b
select gender as 'Gender', avg(salary) as 'Average Salary'
from employees
INNER JOIN salaries on employees.emp_no = salaries.emp_no
group by gender having gender = 'F';
#4c
select avg(salary) as 'Average Salary'
from employees
INNER JOIN salaries on employees.emp_no = salaries.emp_no;

#5
select count(*) as 'Employees' ,SUM(CASE employees.gender WHEN 'M' THEN 1 ELSE 0 END) AS 'MALE', SUM(CASE employees.gender WHEN 'F' THEN 1 ELSE 0 END) AS 'FEMALE'
from employees
where YEAR(employees.hire_date) >= (SELECT MAX(YEAR(employees.hire_date))-5 FROM employees);


#6a
select avg(YEAR(now()) - YEAR(birth_date )) as 'Average Age'
from employees
where gender = 'M';
#6b
select avg(YEAR(now()) - YEAR(birth_date )) as 'Average Age'
from employees
where gender = 'F';
#6c
select avg(YEAR(now()) - YEAR(birth_date )) as 'Average Age'
from employees;
#7
select departments.dept_name as 'Department Name',SUM(CASE employees.gender WHEN 'M' THEN 1 ELSE 0 END) AS 'MALE', SUM(CASE employees.gender WHEN 'F' THEN 1 ELSE 0 END) AS 'FEMALE'
from departments, employees, dept_emp
where employees.emp_no = dept_emp.emp_no AND dept_emp.dept_no = departments.dept_no
group by departments.dept_name;
#8a
select count(*)/(select count(*) from employees) *100 as 'Transfers'#, YEAR(employees.hire_date)
from employees
INNER JOIN dept_emp on employees.emp_no = dept_emp.emp_no
INNER JOIN current_dept_emp on employees.emp_no = current_dept_emp.emp_no
where current_dept_emp.dept_no != dept_emp.dept_no AND YEAR(current_dept_emp.from_date) >= (SELECT MAX(YEAR(employees.hire_date))-10 FROM employees) AND employees.gender = 'M';
#8b
select count(*)/(select count(*) from employees) *100 as 'Transfers'#, YEAR(employees.hire_date)
from employees
INNER JOIN dept_emp on employees.emp_no = dept_emp.emp_no
INNER JOIN current_dept_emp on employees.emp_no = current_dept_emp.emp_no
where current_dept_emp.dept_no != dept_emp.dept_no AND YEAR(current_dept_emp.from_date) >= (SELECT MAX(YEAR(employees.hire_date))-10 FROM employees) AND employees.gender = 'F';
#8c
select  count(*)/(select count(*) from employees) *100 as 'Transfers'#, YEAR(employees.hire_date)
from employees
INNER JOIN dept_emp on employees.emp_no = dept_emp.emp_no
INNER JOIN current_dept_emp on employees.emp_no = current_dept_emp.emp_no
where current_dept_emp.dept_no != dept_emp.dept_no AND YEAR(current_dept_emp.from_date) >= (SELECT MAX(YEAR(employees.hire_date))-10 FROM employees);

#bonus male
select employees.emp_no, employees.first_name, employees.last_name, employees.gender, AVG(salaries.salary)
from employees
INNER JOIN salaries ON employees.emp_no = salaries.emp_no
where YEAR(salaries.from_date) >= (SELECT MAX(YEAR(employees.hire_date))-10 FROM employees) AND YEAR(salaries.from_date) <= (SELECT MAX(YEAR(employees.hire_date)) FROM employees) 
group by salaries.emp_no having employees.gender = 'M' 
order by AVG(salaries.salary) DESC
limit 10;

#bonus female
select employees.emp_no, employees.first_name, employees.last_name, employees.gender, AVG(salaries.salary)
from employees
INNER JOIN salaries ON employees.emp_no = salaries.emp_no
where YEAR(salaries.from_date) >= (SELECT MAX(YEAR(employees.hire_date))-10 FROM employees) AND YEAR(salaries.from_date) <= (SELECT MAX(YEAR(employees.hire_date)) FROM employees) 
group by employees.emp_no having employees.gender = 'F' 
order by AVG(salaries.salary) DESC

limit 10;

#bonus both
select employees.emp_no, employees.first_name, employees.last_name, employees.gender, AVG(salaries.salary)
from employees
INNER JOIN salaries ON employees.emp_no = salaries.emp_no
where YEAR(salaries.from_date) >= (SELECT MAX(YEAR(employees.hire_date))-10 FROM employees) AND YEAR(salaries.from_date) <= (SELECT MAX(YEAR(employees.hire_date)) FROM employees) 
group by employees.emp_no 
order by AVG(salaries.salary) DESC
limit 10;

