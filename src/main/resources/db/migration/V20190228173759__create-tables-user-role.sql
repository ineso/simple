create table role (id  bigserial not null, name varchar(255) not null, primary key (id));
create table user_role (user_id int8 not null, role_id int8 not null, primary key (user_id, role_id));
create table userapp (id  bigserial not null, account_non_expired boolean, account_non_locked boolean, credentials_non_expired boolean, enabled boolean, password varchar(255), username varchar(255) not null, primary key (id));
alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);
alter table userapp add constraint UK_k2rx49yciylkm7d2wv0mjl670 unique (username);
alter table user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role;
alter table user_role add constraint FK30ldrrhcixdmus3wkta4vc6q9 foreign key (user_id) references userapp;
