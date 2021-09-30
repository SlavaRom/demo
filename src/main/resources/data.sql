DROP TABLE IF EXISTS FEEDBACK;

CREATE TABLE FEEDBACK (
                          user_id VARCHAR(250) PRIMARY KEY,
                          message_text CHAR NOT NULL
);
