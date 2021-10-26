## Rebuild Index
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
