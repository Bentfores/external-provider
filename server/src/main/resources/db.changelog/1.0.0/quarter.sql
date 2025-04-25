--liquibase formatted sql

--changeset yuliezai:1
create table if not exists quarter
(
    id         uuid      not null
        constraint pk_quarter primary key,
    time       timestamp not null,
    updated_at timestamp not null
);
