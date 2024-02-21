select salesRepEmployeeNumber,employees.firstName,employees.lastName,count(salesRepEmployeeNumber) as Cant_Clientes from customers
inner join employees
on employees.employeeNumber=customers.salesRepEmployeeNumber
group by salesRepEmployeeNumber 
order by Cant_Clientes desc ;