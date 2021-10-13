
-- Table: empik.request_counter

-- DROP TABLE empik.request_counter

CREATE TABLE IF NOT EXISTS empik.request_counter (
        id bigserial,
        login character varying COLLATE pg_catalog."default" NOT NULL UNIQUE,
        request_count bigint NOT NULL,
        CONSTRAINT request_counter_pkey PRIMARY KEY (id)
    )
    TABLESPACE pg_default;

ALTER TABLE empik.request_counter
    OWNER to postgres;
