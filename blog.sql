CREATE TABLE tbl_blog (
  blog_id number(4) primary key,
  blog_create_date date DEFAULT sysdate,
  blog_content varchar2(256) DEFAULT NULL,
  blog_acc number(8) DEFAULT NULL,
  blog_ref number(8) DEFAULT NULL
);

create sequence seq_tbl_blog
start with 1
increment by 1
maxvalue 9999999
minvalue 1;

insert into tbl_blog(blog_id,blog_content,blog_acc,blog_ref) values(1,'»¶Ó­À´µ½Å£¶ú',4,20);
commit

select * from tbl_blog
