CREATE TABLE IF NOT EXISTS PHOTOZ (
    id bigint  primary key auto_increment,
    file_name varchar(255),
    content_type varchar(255),
    data binary
    );