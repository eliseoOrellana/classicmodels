select salesRepEmployeeNumber,employees.firstName,employees.lastName,count(salesRepEmployeeNumber) as Cant_Clientes from customers
inner join employees
on employees.employeeNumber=customers.salesRepEmployeeNumber
group by salesRepEmployeeNumber 
order by Cant_Clientes desc ;

select sales_rep_employee_number,employees.first_name,employees.last_name,count(sales_rep_employee_number) as Cant_Clientes from customers
inner join employees
on employees.employee_number=customers.sales_rep_employee_number
group by sales_rep_employee_number 
order by Cant_Clientes desc ;