--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2024-07-10 16:54:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 221 (class 1259 OID 17510)
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    idcliente integer NOT NULL,
    idpersona integer NOT NULL,
    contrasenia character varying NOT NULL,
    estado boolean DEFAULT true NOT NULL
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 17509)
-- Name: clientes_idcliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_idcliente_seq OWNER TO postgres;

--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 220
-- Name: clientes_idcliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_idcliente_seq OWNED BY public.clientes.idcliente;


--
-- TOC entry 217 (class 1259 OID 17479)
-- Name: cuentas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuentas (
    idcuenta integer NOT NULL,
    nrocuenta character varying,
    tipocuenta character varying,
    saldoinicial numeric(15,2),
    estado boolean DEFAULT true,
    idcliente integer NOT NULL,
    saldoactual numeric(15,2),
    fechaapertura date
);


ALTER TABLE public.cuentas OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 17478)
-- Name: cuentas_idcuenta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cuentas_idcuenta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cuentas_idcuenta_seq OWNER TO postgres;

--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 216
-- Name: cuentas_idcuenta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cuentas_idcuenta_seq OWNED BY public.cuentas.idcuenta;


--
-- TOC entry 219 (class 1259 OID 17494)
-- Name: movimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movimientos (
    idmovimiento integer NOT NULL,
    entidad integer,
    fechamovimiento date NOT NULL,
    valormovimiento numeric(15,2),
    saldomovimiento numeric(15,2),
    idcuenta integer NOT NULL,
    estado character varying
);


ALTER TABLE public.movimientos OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 17493)
-- Name: movimientos_idmovimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movimientos_idmovimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movimientos_idmovimiento_seq OWNER TO postgres;

--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 218
-- Name: movimientos_idmovimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movimientos_idmovimiento_seq OWNED BY public.movimientos.idmovimiento;


--
-- TOC entry 215 (class 1259 OID 17429)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    idpersona integer NOT NULL,
    nombres character varying,
    apellidos character varying,
    fechanacimiento date,
    nroidentificacion character varying,
    telefono character varying,
    direccion character varying,
    genero character varying,
    edad integer
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 17428)
-- Name: persona_idpersona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persona_idpersona_seq OWNER TO postgres;

--
-- TOC entry 3363 (class 0 OID 0)
-- Dependencies: 214
-- Name: persona_idpersona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_idpersona_seq OWNED BY public.persona.idpersona;


--
-- TOC entry 3192 (class 2604 OID 17513)
-- Name: clientes idcliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN idcliente SET DEFAULT nextval('public.clientes_idcliente_seq'::regclass);


--
-- TOC entry 3189 (class 2604 OID 17482)
-- Name: cuentas idcuenta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuentas ALTER COLUMN idcuenta SET DEFAULT nextval('public.cuentas_idcuenta_seq'::regclass);


--
-- TOC entry 3191 (class 2604 OID 17497)
-- Name: movimientos idmovimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos ALTER COLUMN idmovimiento SET DEFAULT nextval('public.movimientos_idmovimiento_seq'::regclass);


--
-- TOC entry 3188 (class 2604 OID 17432)
-- Name: persona idpersona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN idpersona SET DEFAULT nextval('public.persona_idpersona_seq'::regclass);


--
-- TOC entry 3353 (class 0 OID 17510)
-- Dependencies: 221
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (idcliente, idpersona, contrasenia, estado) FROM stdin;
2	2	123456	t
3	3	123456	t
4	4	123456	t
5	5	1234567	t
6	6	1234567	t
1	9	2222225	t
7	10	1234567	t
8	11	1234567	t
\.


--
-- TOC entry 3349 (class 0 OID 17479)
-- Dependencies: 217
-- Data for Name: cuentas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuentas (idcuenta, nrocuenta, tipocuenta, saldoinicial, estado, idcliente, saldoactual, fechaapertura) FROM stdin;
7	55544488777	Cuenta Corriente	5500.00	t	3	4200.00	2024-07-01
6	11222444555	Cuenta Corriente	1500.00	t	2	2550.00	2024-05-06
4	111222333	Ahorros	2000.00	t	1	4945.00	2024-04-22
5	555444333	Cuenta Corriente	1500.00	t	1	3973.50	2024-07-08
\.


--
-- TOC entry 3351 (class 0 OID 17494)
-- Dependencies: 219
-- Data for Name: movimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movimientos (idmovimiento, entidad, fechamovimiento, valormovimiento, saldomovimiento, idcuenta, estado) FROM stdin;
2	1	2024-07-08	2000.00	4000.00	4	true
7	1	2024-07-10	1000.00	5000.00	4	true
8	1	2024-07-10	1000.00	6500.00	7	true
9	1	2024-07-10	-2300.00	4200.00	7	true
10	1	2024-07-10	850.00	2350.00	6	true
11	1	2024-07-10	200.00	2550.00	6	true
12	1	2024-07-10	2050.00	3550.00	5	true
13	1	2024-07-10	-38.50	3511.50	5	true
14	1	2024-07-10	-38.75	3472.75	5	true
15	1	2024-07-10	0.75	3473.50	5	true
16	1	2024-07-10	235.28	2785.28	6	true
17	1	2024-07-10	-235.28	2550.00	6	true
18	1	2024-07-10	-55.00	4945.00	4	true
19	1	2024-07-10	500.00	3973.50	5	true
\.


--
-- TOC entry 3347 (class 0 OID 17429)
-- Dependencies: 215
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (idpersona, nombres, apellidos, fechanacimiento, nroidentificacion, telefono, direccion, genero, edad) FROM stdin;
2	Jose	Lema	1997-05-02	1234562	595981555444	Casa de los naranjo	Masculino	28
3	Marianela	Montalvo	2001-07-05	543212	595981222111	Avda. Simpreviva N° 1245	Femenino	24
1	Juan	Osorio	1995-03-22	222111	595991777888	Alejandria N° 5252	Masculino	29
4	Alan	Sanier	1988-07-05	543212	595981555444	Avda. P. Sherman y calle Wallabie	Masculino	37
5	Oscar	Delarrenta	1972-07-05	55454	595982777888	Calle 1 esquina calle 1, Australia	Masculino	52
6	Juana	De Arco	1974-07-05	654654654	595984552663	Rue de la Bastille, France	Femenino	50
7	Juan	Osorio	1995-03-22	\N	595991777888	Alejandria N° 5252	\N	30
8	Juan	Osorio	1995-03-22	\N	595991777888	Avd. Principal Nro 55555	\N	30
9	Juan	Osorio	1996-03-22	222111	595991777888	Avd. Principal Nro 55555	Masculino	31
10	Oscar	Delarrenta y Herrera	1972-07-05	55454	595982777888	Calle 1 esquina calle 1, Australia	Masculino	52
11	Oscar	Delarrenta y Herrera	1972-07-05	55454	595982777888	Calle 1 esquina calle 2, Australia	Masculino	52
\.


--
-- TOC entry 3364 (class 0 OID 0)
-- Dependencies: 220
-- Name: clientes_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_idcliente_seq', 8, true);


--
-- TOC entry 3365 (class 0 OID 0)
-- Dependencies: 216
-- Name: cuentas_idcuenta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cuentas_idcuenta_seq', 7, true);


--
-- TOC entry 3366 (class 0 OID 0)
-- Dependencies: 218
-- Name: movimientos_idmovimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movimientos_idmovimiento_seq', 19, true);


--
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 214
-- Name: persona_idpersona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_idpersona_seq', 11, true);


--
-- TOC entry 3201 (class 2606 OID 17518)
-- Name: clientes clientes_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pk PRIMARY KEY (idcliente);


--
-- TOC entry 3197 (class 2606 OID 17487)
-- Name: cuentas cuentas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT cuentas_pk PRIMARY KEY (idcuenta);


--
-- TOC entry 3199 (class 2606 OID 17501)
-- Name: movimientos movimientos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pk PRIMARY KEY (idmovimiento);


--
-- TOC entry 3195 (class 2606 OID 17436)
-- Name: persona persona_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (idpersona);


--
-- TOC entry 3203 (class 2606 OID 17519)
-- Name: clientes clientes_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona);


--
-- TOC entry 3202 (class 2606 OID 17502)
-- Name: movimientos movimientos_cuentas_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_cuentas_fk FOREIGN KEY (idcuenta) REFERENCES public.cuentas(idcuenta);


-- Completed on 2024-07-10 16:54:26

--
-- PostgreSQL database dump complete
--

