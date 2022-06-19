-- Account 1
insert into account (name, balance) values ('Lenalidomide 25 mg', 0);

insert into product (account_id, lot_number, expiration_date, balance) values (1, 'ABC123', '2022-12-31', 0);
insert into product (account_id, lot_number, expiration_date, balance) values (1, 'DEF789', '2024-12-31', 0);

insert into transaction (type) values ('RECEPTION');
insert into product_transaction (product_id, transaction_id, quantity) values (1,1, 28);
update product set balance = balance + 28 where id = 1;
update account set balance = balance + 28 where id = 1;

insert into transaction (type) values ('DISPENSE');
insert into product_transaction (product_id, transaction_id, quantity) values (1,2,7);
update product set balance = balance - 7 where id = 1;
update account set balance = balance - 7 where id = 1;

insert into transaction (type) values ('RECEPTION');
insert into product_transaction (product_id, transaction_id, quantity) values (2,3, 56);
update product set balance = balance + 56 where id = 2;
update account set balance = balance + 56 where id = 1;

insert into transaction (type) values ('DISPENSE');
insert into product_transaction (product_id, transaction_id, quantity) values (2,4,21);
update product set balance = balance - 21 where id = 2;
update account set balance = balance - 21 where id = 1;

--- Account 2
insert into account (name, balance) values ('Lenalidomide 5 mg', 0);
insert into product (account_id, lot_number, expiration_date, balance) values (2, 'ABC123', '2022-12-31', 0);

insert into transaction (type) values ('RECEPTION');
insert into product_transaction (product_id, transaction_id, quantity) values (3, 5, 28);
update product set balance = balance + 28 where id = 3;
update account set balance = balance + 28 where id = 2;

-- Account 3

insert into account (name, balance) values ('Lenalidomide 10 mg', 0);

-- SELECT T.*,PT.QUANTITY FROM TRANSACTION T
-- JOIN PRODUCT_TRANSACTION PT ON T.ID = PT.TRANSACTION_ID
-- JOIN PRODUCT P ON PT.PRODUCT_ID = P.ID



-- SELECT pt.product_id, sum(case t.type
--                            when 'RECEPTION' then quantity
--                            when 'DISPENSE' then pt.quantity * -1 end) as balance
-- FROM PRODUCT_TRANSACTION pt
--          JOIN transaction t ON t.id = pt.transaction_id
-- GROUP BY pt.product_id


-- SELECT pt.*, p.lot_number, p.expiration_date, t.type
-- FROM PRODUCT_TRANSACTION pt
--     JOIN product p ON pt.product_id = p.id
--     JOIN transaction t on pt.transaction_id = t.id
-- WHERE p.account_id = 1