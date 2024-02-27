CREATE TABLE transaction_change_in_notes_and_coins
(
    id                               VARCHAR(255) NOT NULL,
    number_of_two_hundred_rand_notes INT,
    number_of_one_hundred_rand_notes INT,
    number_of_fifty_rand_notes       INT,
    number_of_twenty_rand_notes      INT,
    number_of_ten_rand_notes         INT,
    number_of_five_rand_coins        INT,
    number_of_two_rand_coins         INT,
    number_of_one_rand_coins         INT,
    number_of_fifty_cent_coins       INT,
    number_of_twenty_cent_coins      INT,
    number_of_ten_cent_coins         INT,
    number_of_five_cent_coins        INT,
    number_of_one_cent_coins         INT,
    CONSTRAINT pk_transaction_change_in_notes_and_coins PRIMARY KEY (id)
);

CREATE TABLE transaction
(
    id            VARCHAR(255) NOT NULL,
    selling_price DECIMAL,
    payment_value DECIMAL,
    change        DECIMAL,
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

ALTER TABLE transaction_change_in_notes_and_coins
    ADD CONSTRAINT fk_transaction_change_in_notes_and_coins_id FOREIGN KEY (id) REFERENCES transaction (id);


