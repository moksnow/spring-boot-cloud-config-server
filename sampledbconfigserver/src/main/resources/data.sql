CREATE SCHEMA IF NOT EXISTS "PUBLIC";

DROP TABLE IF EXISTS PROPERTIES;

CREATE TABLE PROPERTIES (
    key VARCHAR(250) PRIMARY KEY,
    value VARCHAR(250),
    application VARCHAR(250),
    profile VARCHAR(250),
    label VARCHAR(250)
);

INSERT INTO PROPERTIES (key, value, application, profile,label) VALUES
('cm.version', '100', 'sampleconfigclient','default',null);