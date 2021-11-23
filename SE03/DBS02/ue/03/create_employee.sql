DROP TABLE employee;

CREATE TABLE employee(
    employee_id NUMBER,
    name VARCHAR(100),
    dept VARCHAR(100),
    CONSTRAINT pk_employee PRIMARY KEY(employee_id)
);

SELECT * 
FROM employee;

