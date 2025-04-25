--liquibase formatted sql

--changeset yuliezai:1
create table if not exists dynamic_configs
(
    id             uuid    not null
        constraint pk_dynamic_configs primary key,
    product_number decimal not null default 300
);