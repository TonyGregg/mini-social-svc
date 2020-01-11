-- Car type

create table car_type (id bigint NOT NULL auto_increment, 
	category varchar(35) not null, 
    price_min int, price_max int, primary key (`id`));

insert into car_type values (1, 'Luxury', 30000, 600000);
insert into car_type values (2, 'Luxury SUV', 40000,100000);
insert into car_type values (3, 'Sports', 25000,50000);
insert into car_type values (4, 'Electric', 25000,150000);
insert into car_type values (5, 'Electric SUV', 60000,350000);
insert into car_type values (6, 'Electric Sedan', 60000,150000);
insert into car_type values (7, 'Luxury Sedan', 30000,120000);

select * from car_type;


create table car (
  id bigint  NOT NULL AUTO_INCREMENT,
  type_id bigint not null,
  name varchar(35) not null,
  PRIMARY KEY (id),
  foreign key(type_id) references car_type(id));

alter table car add invoice_number varchar(25) not null;
    
    

insert into car values(1, 1, 'Benz S/E class');
insert into car values(2, 2, 'Benz SUV E Class');
insert into car values(3, 3, 'BMW i3');
insert into car values(4, 3, 'Ford Mustang');
insert into car values(5, 4, 'GM Bolt');
insert into car values(6, 4, 'Nissan Leaf');
insert into car values(7, 5, 'Tesla Model X');
insert into car values(8, 6, 'Tesla Model S');
insert into car values(9, 7, 'Lexus 350');
insert into car values(10, 7, 'Acura RLX');



select * from car;

select category, price_min, price_max, name
from car, car_type
where car.type_id = car_type.id;

/*
SQL docker commands used
docker run -p 3306:3306 -d --name mysql -e MYSQL_ROOT_PASSWORD=password123 mysql/mysql-server

docker ps

CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS                            PORTS                               NAMES
2a7ddb28e587        mysql/mysql-server   "/entrypoint.sh mysq…"   8 seconds ago       Up 7 seconds (health: starting)   0.0.0.0:3306->3306/tcp, 33060/tcp   mysql

if docker is not running
start by

docker start mysql

Antonys-MacBook-Pro:~ genil$ docker exec -it mysql bash
bash-4.2# mysql -uroot -ppassword123
mysql> CREATE USER 'tacos'@'%' IDENTIFIED BY 'password123';
Query OK, 0 rows affected (0.01 sec)

mysql> GRANT ALL PRIVILEGES ON * . * TO 'tacos'@'%'
    -> ;
Query OK, 0 rows affected (0.00 sec)

If it is a new project in IntelliJ IDE, copy the connection to clipboard and paste it right in the new connection tab.
Make sure to run the queries from SYS schema.

*/

-- Customer and order tables

create table customers (customer_id bigint NOT NULL auto_increment,
	customer_name varchar(60) not null,
	contact_name varchar(40) not null,
	country varchar(50) not null,
    primary key (`customer_id`));

create table orders (order_id bigint NOT NULL auto_increment,
	customer_id bigint not null,
	order_date date not null,
    primary key (`order_id`));

insert into customers values(1, 'Alfreds Futterkiste','Maria Anders', 'Germany');
insert into customers values(2, 'Kailavan','Kannamma', 'India');
insert into customers values(3, 'John Phalmer','Serneena Phalmer', 'USA');
insert into customers values(4, 'Kung Fi','Mang Yo', 'China');


insert into orders values(1, 2, '2019-02-14');
insert into orders values(2, 4, '2019-12-23');
insert into orders values(3, 12, '2019-10-05');
insert into orders values(4, 14, '2018-07-06');


SELECT orders.Order_ID, customers.customer_Name, orders.order_Date
FROM orders
INNER JOIN customers ON orders.customer_ID=customers.customer_ID;

-- Right Join. Show all records from right table (customers table) and only the matching record from the left table

SELECT orders.Order_ID, customers.customer_Name, orders.order_Date, customers.country
FROM orders right  JOIN customers
    ON customers.customer_ID=orders.customer_ID;

-- Left Join. Show all records from left table and only the matching record from the right table

SELECT orders.Order_ID, customers.customer_Name, orders.order_Date, customers.country
FROM orders left  JOIN customers
    ON customers.customer_ID=orders.customer_ID;