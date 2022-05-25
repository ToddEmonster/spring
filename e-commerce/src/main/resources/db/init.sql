-----------------------------------------------------------------------------------------------
-- TODOC
--  Script de réinitalisation de la base de données
-----------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------
--- SUPPRESSIONS DES TABLES
------------------------------------------------------------------------------------------------------------------------

DROP TABLE public.order_product;
DROP TABLE public.table_order;
DROP TABLE public.client_roles;
DROP TABLE public.product;
DROP TABLE public."role";
DROP TABLE public.client;

------------------------------------------------------------------------------------------------------------------------
--- CREATION DES TABLES
------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------- public.client definition
CREATE TABLE public.client (
   id int8 NOT NULL,
   username text NOT NULL,
   email varchar NOT NULL,
   "password" varchar NOT NULL,
   CONSTRAINT client_pk PRIMARY KEY (id)
);

----------------------------------------------------------------------------------------------- public."role" definition
CREATE TABLE public."role" (
   id int4 NOT NULL,
   "name" varchar(255) NOT NULL,
   CONSTRAINT role_pkey PRIMARY KEY (id)
);

----------------------------------------------------------------------------------------- public.client_roles definition
CREATE TABLE public.client_roles (
    client_id int4 NOT NULL,
    role_id int4 NOT NULL,
    CONSTRAINT client_roles_pkey PRIMARY KEY (client_id, role_id)
);

------------------------------------------------------------------------------------------ public.table_order definition
CREATE TABLE public.table_order (
    id int8 NOT NULL,
    date_created date NULL,
    status text NULL,
    client_id int8 NULL,
    CONSTRAINT table_order_pkey PRIMARY KEY (id),
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES public.client(id)
);

---------------------------------------------------------------------------------------------- public.product definition
CREATE TABLE public.product (
    id int8 NOT NULL,
    description text NULL,
    "name" text NULL,
    price float8 NULL,
    picture text NULL,
    quantity int8 NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

---------------------------------------------------------------------------------------- public.order_product definition
CREATE TABLE public.order_product (
    product_id int8 NOT NULL,
    order_id int8 NOT NULL,
    quantity int4 NULL,
    CONSTRAINT order_product_pk PRIMARY KEY (product_id, order_id),
    CONSTRAINT order_product_fk_product FOREIGN KEY (product_id) REFERENCES public.product(id),
    CONSTRAINT order_product_fk_order FOREIGN KEY (order_id) REFERENCES public.table_order(id)
);

------------------------------------------------------------------------------------------------------------------------
--- INSERTIONS
------------------------------------------------------------------------------------------------------------------------

-- CLIENTS -------------------------------------------------------------------------------------------------------------
INSERT INTO
    public.client (id,username,email,"password")
VALUES
    (2,'admin', 'admin@admin.dev','$2y$10$5qlWZh4yIwGthjTv5PCXquQ3vAlh2BrSRO9FYxuqU/FINUaBz3Jry'), -- admin
    (1,'peter', 'peter@bardu.fr','$2y$10$ofanCY3OIdEzZ2qDxaG2TOcVPuGV7dWqScM2z5UfV32EUJpqsmD36'), -- 1234
    (3,'todd', 'toad@yoshi.jp', '$2y$10$mchJXBKVx3M.NugRc7yjIeeOBDnwllUMlDtwWAtfQZHGNB2bYsYtC'), -- emon
    (4,'jeannine', 'jean@nine.com','$2y$10$ontbiDOkb79Vl.deXxiI2.1fs3aSTsECb4o5SFNzldI8I21yS9er6'); -- ninja

-- ROLES ---------------------------------------------------------------------------------------------------------------
INSERT INTO
    public."role" (id,"name")
VALUES
    (1,'ROLE_ADMIN'),
    (2,'ROLE_CLIENT');

-- PRODUCTS ------------------------------------------------------------------------------------------------------------
INSERT INTO
    public.product (id,description,"name",price,picture,quantity)
VALUES
    (1,'Une étincelle de joie éphémère','Spark of Joy',500.0,'https://montywinters.com/wp-content/uploads/2012/12/happy.jpeg',50),
    (4,'De la peur pour AGIR, VITE','FEAR!!',150.0,'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Emojione_BW_1F631.svg/1024px-Emojione_BW_1F631.svg.png?20170608162802',50),
    (3,'Après tout, pourquoi la vie ?...','Sadness...',400.0,'https://shapeplatform.eu/wp-content/uploads/2019/01/untitled-540x282.jpeg',50),
    (2,'De la rage, avec sa dose de cortisol offerte','A n g e r',200.0,'https://upload.wikimedia.org/wikipedia/commons/3/30/Breathe-face-angry.svg',50);

-- ORDERS ------------------------------------------------------------------------------------------------------------
INSERT INTO
    public.table_order (id,date_created,status,client_id)
VALUES
    (1,'2022-04-24','Payée',1);

-- CLIENT_ROLES --------------------------------------------------------------------------------------------------------
INSERT INTO
    public.client_roles (client_id,role_id)
VALUES
    (3,2),
    (2,2),
    (2,1),
    (3,1),
    (1,2),
    (4,2);

-- ORDER_PRODUCTS ------------------------------------------------------------------------------------------------------
INSERT INTO
    public.order_product (product_id,order_id,quantity)
VALUES
    (1,1,10),
    (3,1,3);

