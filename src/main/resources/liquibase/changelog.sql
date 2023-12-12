-- liquibase formatted sql

-- changeset liquibase:1

create table t_click
(
    id   bigint auto_increment
        primary key,
    time datetime(6) null
);

create table t_value
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

INSERT INTO t_value (name)
SELECT 'Постоянный покупатель'
WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'Постоянный покупатель');

INSERT INTO t_value (name)
SELECT 'Оптовик'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'Оптовик');

INSERT INTO t_value (name)
SELECT 'По рекомендации'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'По рекомендации');

INSERT INTO t_value (name)
SELECT 'Яндекс'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'Яндекс');

INSERT INTO t_value (name)
SELECT 'Google'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'Google');

INSERT INTO t_value (name)
SELECT 'Instagram'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'Instagram');

INSERT INTO t_value (name)
SELECT 'Tik tok'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'Tik tok');

INSERT INTO t_value (name)
SELECT 'YouTube'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = 'YouTube');

INSERT INTO t_value (name)
SELECT '2GIS'
    WHERE NOT EXISTS (SELECT 1 FROM t_value WHERE name = '2GIS');