DROP TABLE IF EXISTS FEEDBACK;

CREATE TABLE FEEDBACK (
                            id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                          user_id VARCHAR(250),
                          message_text CHAR NOT NULL
);
