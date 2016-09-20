# JavaWeb_tallyWeb
 无框架简易记账网站

* 技术：DAO + JSP + Servlet

* 工具：Eclipse for Java EE + MySQL

 使用方法：

1. 导入jar包：jsp-api.jar + servlet-api.jar + taglibs-standard-compat-1.2.5.jar + taglibs-standard-impl-1.2.5.jar + taglibs-standard-jstlel-1.2.5.jar + taglibs-standard-spec-1.2.5.jar 
 

2. 建立数据库：

 create database tally;


 create table user(
	id int(32) primary key not null auto_increment,

	userName varchar(32) not null,
	
	password varchar(32) not null
	);


 create table item(
	id int(32) primary key not null auto_increment,

	date date not null,

	location varchar(32),

	detail varchar(32),

	amount double(9,5) not null,

	user_id int(32),
	
	foreign key(user_id) references user(id) on delete restrict on update restrict
	);
