# create database
CREATE DATABASE IF NOT EXISTS bms
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;
# 选择数据库
USE bms;
# 创建用户表
CREATE TABLE t_user (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(50) NOT NULL UNIQUE,
                        password VARCHAR(100) NOT NULL,
                        role VARCHAR(20) DEFAULT 'user'
);
# 创建默认用户
INSERT INTO t_user (username, password, role)
VALUES ('admin', 'admin', 'admin'),('operator', 'operator', 'operator');
