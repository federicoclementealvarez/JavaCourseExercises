create user 'java'@'%' identified by 'password123';
GRANT SELECT, INSERT, UPDATE, DELETE ON `java`.* TO 'java'@'%';
