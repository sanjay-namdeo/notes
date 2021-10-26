### Clustered Index
A clustered index **defines the order in which data is physically stored in a table**. Table data can be sorted in only way, therefore, there can be only one clustered index per table. In SQL Server, the *primary key constraint automatically creates a clustered index* on that particular column.

> You can have *only one clustered index in one table*, but you can have one clustered index on multiple columns, and that type of index is called composite index.

### Non Clustered Index
Non-Clustered Index is **similar to the index of a book**. The index of a book consists of a chapter name and page number, if you want to read any topic or chapter then you can directly go to that page by using index of that book. No need to go through each and every page of a book.

> The *data is stored in one place, and index is stored in another place*. The *index contains pointer to the location of data*. Since, the data and non-clustered index is stored separately, then you can have multiple non-clustered index in a table.
In non-clustered index, index contains the pointer to data.
