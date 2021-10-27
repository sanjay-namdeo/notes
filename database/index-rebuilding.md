## Rebuild Index

### Why
The SQL Server database engine automatically maintains indexes whenever insert, update or delete operations are made to the underlying data. Over time this modification can cause the information in the index to become scattered in the database(fragmented)

> You can remedy index fragmentation by reorganizing or rebuilding an index. **Rebuilding an index drops and re-creates the index**. This removes fragmentation, reclaims disk space by compacting the pages based on the specified or existing fill factory settings, and reorders the index rows in contiguous pages.

When ALL is specified, all the indexes on the table are dropped and rebuilt in a single transaction. Reorganizing an index uses minimal system resources. It de-fragments the leaf level of clustered and non-clustered indexes on tables and views by physically reordering the leaf-level pages to match the logical, left to right, order of the leaf nodes. Reorganizing also compacts the index pages. Compaction is based on the existing fill factor value.

### Reorganize
**Reorganize is a light-weight** the process which goes through the existing index and cleans it up. It is a cleanup operation that leaves the system as it is without locking out affect tables and views. The organizing index is much better from an efficiency standpoint.

```sql
ALTER INDEX ALL ON Config_Mst REORGANIZE;
```

### Rebuild
**Rebuild is a heavy-duty** operation where indexes are deleted and re-created from scratch with an entirely new structure, free from all piled-up fragments and empty-space pages. As it locks affected tables and views, it results in long downtimes that could not be acceptable in some environments. 

```sql
ALTER INDEX ALL ON Config_Mst REBUILD;
```
### Script to Rebuild Index

```sql
Create Procedure [dbo].[IndexRebuild]
(@database nvarchar(50)
)
with recompile
as
begin
DECLARE
@Table NVARCHAR(255)
DECLARE
@cmd NVARCHAR(1000)
DECLARE
@cmdUpdate NVARCHAR(1000)
SET @cmd = 'DECLARE TableCursor CURSOR READ_ONLY FOR SELECT ''['' + table_catalog + ''].['' + table_schema + ''].['' +
table_name + '']'' as tableName FROM ['+ @database +'].INFORMATION_SCHEMA.TABLES WHERE table_type = ''BASE TABLE'''
-- create table cursor
EXEC (@cmd)
OPEN TableCursor
FETCH NEXT FROM TableCursor INTO @Table
WHILE @@FETCH_STATUS = 0
BEGIN
BEGIN TRY
SET @cmd = 'ALTER INDEX ALL ON ' + @Table + ' REBUILD'
PRINT @Table +' ' + CONVERT(VARCHAR(16), Current_timestamp, 120) -- uncomment if you want to see commands
EXEC (@cmd)
set @cmdUpdate ='UPDATE STATISTICS ' + @Table;
PRINT
@Table +' Statistics ' + CONVERT(VARCHAR(16), Current_timestamp, 120)
Exec (@cmdUpdate)
END TRY
BEGIN CATCH
PRINT '---'
--PRINT @cmd
PRINT ERROR_MESSAGE()
PRINT '---'
END CATCH
FETCH NEXT FROM TableCursor INTO @Table
END
CLOSE TableCursor DEALLOCATE TableCursor
end
```
