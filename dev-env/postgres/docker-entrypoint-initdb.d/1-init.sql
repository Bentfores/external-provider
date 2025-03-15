\c

create user "bentfores-external-provider" with password 'bentfores-external-provider';

create database "bentfores-external-provider" with owner = postgres;

grant all privileges on database "bentfores-external-provider" to "bentfores-external-provider";

\c "bentfores-external-provider"

alter role "bentfores-external-provider" set search_path = bentfores_external_provider, public;

create schema bentfores_external_provider authorization "bentfores-external-provider";
