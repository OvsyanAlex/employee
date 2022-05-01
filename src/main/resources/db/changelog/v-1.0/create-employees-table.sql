CREATE TABLE employees
(
    id                 BIGSERIAL PRIMARY KEY NOT NULL,
    surname            VARCHAR(255)          NOT NULL,
    name               VARCHAR(255)          NOT NULL,
    middle_name        VARCHAR(255),
    gender             VARCHAR(255)          NOT NULL,
    birthday           DATE                  NOT NULL,
    phone              VARCHAR(255)          NOT NULL,
    email              VARCHAR(255)          NOT NULL,
    date_of_employment DATE                  NOT NULL,
    date_of_dismissal  DATE,
    post               VARCHAR(255)          NOT NULL,
    salary             INTEGER               NOT NULL,
    director           BOOLEAN               NOT NULL,
    department_id         INTEGER               NOT NULL
);