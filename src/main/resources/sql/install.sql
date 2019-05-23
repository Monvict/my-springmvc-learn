
create table city(
id int(4) primary key auto_increment,
province_id int(4) not null,
city_name VARCHAR(128),
description VARCHAR(512)
);
