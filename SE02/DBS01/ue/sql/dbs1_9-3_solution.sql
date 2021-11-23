--a) 
SELECT table_name
FROM ALL_TABLES
WHERE OWNER ='HR';

--b) 
SELECT text
FROM ALL_VIEWS
WHERE OWNER ='HR' and VIEW_NAME = 'EMP_DETAILS_VIEW';

--c) 
SELECT c.table_name, c.column_name, c.data_type
FROM ALL_TAB_COLUMNS c
WHERE OWNER ='HR';

--d)
