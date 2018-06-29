create table province(id int(4) primary key auto_increment,
name varchar(32) not null,
area double(10,3),
populations int(10));

-- 初始化数据
insert into province(name, area, populations) values ("江西省", 166999.361, 45120002);
insert into province(name, area, populations) values ("广东省", 179736.258, 111690962);
insert into province(name, area, populations) values ("湖南省", 211817.321, 68221247);
insert into province(name, area, populations) values ("湖北省", 185926.657, 59023678);
