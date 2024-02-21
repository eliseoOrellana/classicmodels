select customerNumber, customerName,creditLimit from customers
where customerName LIKE '%Ltd%'
order by creditLimit desc;