insert into account (name, balance) values ('Lenalidomide 25 mg', 28);

insert into product (lot_number, expiration_date, balance) values ('ABC123', '2022-12-31', 0);
insert into product (lot_number, expiration_date, balance) values ('DEF789', '2024-12-31', 0);

insert into transaction (account_id, type) values (1, 'RECEPTION');
insert into product_transaction (product_id, transaction_id, quantity) values (1,1, 28);
update product set balance = balance + 28 where id = 1;

insert into transaction (account_id, type) values (1, 'DISPENSE');
insert into product_transaction (product_id, transaction_id, quantity) values (1,2,7);
update product set balance = balance - 7 where id = 1;

insert into transaction (account_id, type) values (1, 'RECEPTION');
insert into product_transaction (product_id, transaction_id, quantity) values (2,3, 56);
update product set balance = balance + 56 where id = 2;

insert into transaction (account_id, type) values (1, 'DISPENSE');
insert into product_transaction (product_id, transaction_id, quantity) values (2,4,21);
update product set balance = balance - 21 where id = 2;


-- SELECT T.*,PT.QUANTITY FROM TRANSACTION T
-- JOIN PRODUCT_TRANSACTION PT ON T.ID = PT.TRANSACTION_ID
-- JOIN PRODUCT P ON PT.PRODUCT_ID = P.ID

-- SELECT pt.product_id, sum(case t.type
--                            when 'RECEPTION' then quantity
--                            when 'DISPENSE' then pt.quantity * -1 end) as balance
-- FROM PRODUCT_TRANSACTION pt
--          JOIN transaction t ON t.id = pt.transaction_id
-- GROUP BY pt.product_id