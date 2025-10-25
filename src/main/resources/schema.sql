CREATE TABLE if not exists EMPLOYEES (
   employee_id varchar(50) NOT NULL,
   contact_number varchar(30) NOT NULL,
   email varchar(30) NOT NULL,
   first_name varchar(30) NOT NULL,
   last_name varchar(30),
   employee_type ENUM ('DEVELOPER_1', 'DEVELOPER_2', 'DEVELOPER_3', 'LEAD_DEVELOPER', 'MANAGER'),
   created_at date NOT NULL,
   created_by varchar(20) NOT NULL,
   updated_at date DEFAULT NULL,
   updated_by varchar(20) DEFAULT NULL,
   PRIMARY KEY (employee_id)
);


    CREATE TABLE if not exists ADDRESSES (
       address_id int NOT NULL,
       address_line1 varchar(30) NOT NULL,
       address_line2 varchar(30) NOT NULL,
       apt_no varchar(6) NOT NULL,
       city varchar(30) NOT NULL,
       state varchar(20) NOT NULL,
       zipcode varchar(8) NOT NULL,
       PRIMARY KEY (address_id)
    );
