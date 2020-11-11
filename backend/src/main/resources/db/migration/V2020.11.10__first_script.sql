
--CREATE SCHEMA depense AUTHORIZATION postgres;

    ---------------------------------

CREATE TABLE depense.article
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    parent_article_id integer,
    CONSTRAINT article_pkey PRIMARY KEY (id),
    CONSTRAINT parent_article FOREIGN KEY (parent_article_id)
        REFERENCES depense.article (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE depense.article
    OWNER to postgres;

CREATE INDEX fki_parent_article
    ON depense.article USING btree
    (parent_article_id)
    TABLESPACE pg_default;

----------------------------------------------------------

CREATE TABLE depense.receipt
(
    amount numeric,
    date date NOT NULL,
    id integer NOT NULL,
    CONSTRAINT receipt_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE depense.receipt
    OWNER to postgres;

    ---------------------------------------------------------

CREATE TABLE depense.expense
(
    amount numeric NOT NULL,
    article_id integer NOT NULL,
    date date NOT NULL,
    id integer NOT NULL,
    purchase character varying(50) COLLATE pg_catalog."default" NOT NULL,
    receipt_id integer,
    CONSTRAINT expense_pkey PRIMARY KEY (id),
    CONSTRAINT expense_article_id_fkey FOREIGN KEY (article_id)
        REFERENCES depense.article (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT expense_receipt_id_fkey FOREIGN KEY (receipt_id)
        REFERENCES depense.receipt (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE depense.expense
    OWNER to postgres;
