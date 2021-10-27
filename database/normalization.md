## Normalization
Database normalization is the process of structuring a relational database in accordance with a series of so-called normal forms in order to reduce data redundancy and improve data integrity.

### First Normal Form
A relation is in first normal form if it *does not contain composite or multi-valued attributes*

Example: 
```sql
Student(id, name, phone numbers)
```

Student can have more than one phone numbers, so in this case phone numbers column will become multivalued attribute. 

**To convert it to 1NF**, instead of storing multivalued data(multiple phone numbers) in one row, store one phone number in each row.

### Second Normal Form
A relation must be in *first normal form and should not contain any partial dependencies*. That means no non-prime attribute is dependent on any subset of a candidate key.

Example: 
```sql
Student(Id, ProjectId, StudentName, ProjectName)
```


**To convert to 2NF**, we need to split the table into two tables as below:
```sql
Student(Id, ProjectId, StudentName)
Student(ProjectId, ProjectName)
```

### Third Normal Form
 A relation must be in *second normal form and there is no transitive dependency for non-prime attributes*. 

Example: 
```sql
Student(Id, Name, State, Country, Age)
```

Here, functional dependencies are:
{Id -> Name, 
 Id-> State, 
 State-> Country,
 Id -> Age}

Candidate Key: {Id}

Here Id -> State and State -> Country forms a transitive dependency as Id -> Country, so it violates third normal form.

**To convert it to 3NF** we need to split the table into two
```sql
Student(Id, Name, State, Age)
Student(State Country)
```
