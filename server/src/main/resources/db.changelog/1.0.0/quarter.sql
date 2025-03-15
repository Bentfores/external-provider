--liquibase formatted sql

--changeset yuliezai
create table quarter
(
    id         uuid      not null
        constraint pk_quarter primary key,
    time       timestamp not null,
    updated_at timestamp not null
);
