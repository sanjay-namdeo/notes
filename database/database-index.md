## Database Index
An index is a copy of information from a table that speeds up retrieval of rows from the table or view. Two main characteristics of an index are:

### Smaller than a table
This allows SQL Server to search the index more quickly, so when a query hits a particular column in our table and if that column has an index on it, the SQL Server can choose to search the index rather than searching the entire table because the index is much smaller, and therefore it can be scanned faster

### Presorted
This also means that search can be performed faster because everything is already presorted, for example, if we’re searching for some string that starts with the letter “Z” the SQL Server is smart enough to start the search from the bottom of an index because it knows where the search criteria is going to be
