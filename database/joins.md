## SQL Joins
A JOIN clause is used to combine rows from two or more tables, based on a related column between them.

### Types of SQL JOINs
1. **(INNER) JOIN**: Returns records that have matching values in both tables
2. **LEFT (OUTER) JOIN**: Returns all records from the left table, and the matched records from the right table
3. **RIGHT (OUTER) JOIN**: Returns all records from the right table, and the matched records from the left table
4. **FULL (OUTER) JOIN**: Returns all records when there is a match in either left or right table

### INNER JOIN
Orders table
|OrderID|CustomerID|OrderDate|
|---|---|---|
|10308|2|1996-09-18|
|10309|37|1996-09-19|
|10310|77|1996-09-20|

Customers table
|CustomerID|CustomerName|ContactName|Country|
|---|---|---|---|
|1|Alfreds Futterkiste|Maria Anders|Germany|
|2|Ana Trujillo| Emparedados y helados	Ana Trujillo	|Mexico|
|3|Antonio Moreno| Taquería	Antonio Moreno	|Mexico|

Let's create the following SQL statement (that contains an INNER JOIN), that selects records that have matching values in both tables:
```sql
SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;
```

#### Reference
[Referenced from](https://www.w3schools.com/sql/sql_join.asp)
