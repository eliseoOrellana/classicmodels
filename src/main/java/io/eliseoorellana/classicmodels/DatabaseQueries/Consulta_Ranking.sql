select customers.country, customers.city, count(customers.city) as cantidad from orders
inner join customers
on customers.customerNumber=orders.customerNumber
group by customers.city 
order by cantidad desc;