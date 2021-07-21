CREATE DATABASE ml_app_consultorio;

ALTER SCHEMA ml_app_consultorio DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_spanish_ci;

--- 1)

CREATE USER 'ml_app_user1'@'localhost' IDENTIFIED BY 'ml_app_user1';

GRANT SELECT, INSERT, UPDATE, DELETE ON ml_app_consultorio.* TO 'ml_app_user1'@'localhost';

--- 2)

CREATE USER 'ml_app_user2'@'localhost' IDENTIFIED BY 'ml_app_user2';

GRANT ALL PRIVILEGES  ON *.*  TO 'ml_app_user2'@'localhost';

--- 3)

CREATE USER 'ml_app_user3'@'localhost' IDENTIFIED BY 'ml_app_user3';

GRANT ALL SELECT  ON ml_app_consultorio  TO 'ml_app_user3'@'localhost';