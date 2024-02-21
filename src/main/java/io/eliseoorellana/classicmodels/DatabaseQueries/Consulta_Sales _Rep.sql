select offices.country,offices.city, employees.firstName,employees.lastName,employees.email  from offices 
inner join employees 
on employees.officeCode=offices.officeCode
where employees.jobTitle='Sales Rep'
order by offices.country ASC, offices.city ASC, employees.firstName ASC;
