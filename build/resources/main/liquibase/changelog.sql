-- liquibase formatted sql

-- changeset liquibase:1

create table t_value
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);


create table t_click
(
    id       bigint auto_increment
        primary key,
    date     datetime(6) null,
    value_id bigint      null,
    constraint FKgwj8cme7ycviek7jrmt8xij94
        foreign key (value_id) references t_value (id)
);

INSERT INTO t_value (name)
SELECT 'regularCustomer'
WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'regularCustomer');

INSERT INTO t_value (name)
SELECT 'wholesale'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'wholesale');

INSERT INTO t_value (name)
SELECT 'recommended'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'recommended');

INSERT INTO t_value (name)
SELECT 'yandex'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'yandex');

INSERT INTO t_value (name)
SELECT 'google'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'google');

INSERT INTO t_value (name)
SELECT 'instagram'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'instagram');

INSERT INTO t_value (name)
SELECT 'tikTok'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'tikTok');

INSERT INTO t_value (name)
SELECT 'youtube'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'youtube');

INSERT INTO t_value (name)
SELECT 'twogis'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'twogis');