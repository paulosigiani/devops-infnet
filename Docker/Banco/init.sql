--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4 (Debian 17.4-1.pgdg120+2)
-- Dumped by pg_dump version 17.4 (Debian 17.4-1.pgdg120+2)
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;
--
-- PostgreSQL database dump complete
--

--Cria tabela
CREATE TABLE public.musico (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    cep VARCHAR(255),
    sexo VARCHAR(255),
    idade INTEGER NOT NULL
);
--Insere registros
INSERT INTO public.musico (nome, idade, cpf, sexo, cep)
VALUES (
        'Ana Clara Silva',
        28,
        '647.792.010-71',
        'F',
        '37070140'
    ),
    (
        'Pedro Henrique Santos',
        14,
        '811.165.740-47',
        'M',
        '37010650'
    ),
    (
        'Maria Oliveira Costa',
        45,
        '875.806.630-66',
        'F',
        '31255200'
    ),
    (
        'Lucas Gomes Pereira',
        79,
        '521.665.310-40',
        'M',
        '71020111'
    ),
    (
        'Juliana Alves de Souza',
        31,
        '456.310.510-44',
        'F',
        '70390125'
    ),
    (
        'Paulo Palmuti Sigiani Neto',
        28,
        '125.251.886-24',
        'M',
        '70390125'
    );