--
-- PostgreSQL database dump
--

-- Dumped from database version 12.11 (Ubuntu 12.11-1.pgdg18.04+1)
-- Dumped by pg_dump version 14.4 (Ubuntu 14.4-1.pgdg18.04+1)

-- Started on 2022-11-03 12:03:32 IST

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 17842831)
-- Name: email_validation_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.email_validation_status (
    email_validation_status_id smallint NOT NULL,
    status_description character varying(20) NOT NULL
);


ALTER TABLE public.email_validation_status OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17842829)
-- Name: email_validation_status_email_validation_status_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.email_validation_status_email_validation_status_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.email_validation_status_email_validation_status_id_seq OWNER TO postgres;

--
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 202
-- Name: email_validation_status_email_validation_status_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.email_validation_status_email_validation_status_id_seq OWNED BY public.email_validation_status.email_validation_status_id;


--
-- TOC entry 205 (class 1259 OID 17842837)
-- Name: external_providers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.external_providers (
    external_provider_id integer NOT NULL,
    provider_name character varying(50) NOT NULL,
    ws_endpoint character varying(200)
);


ALTER TABLE public.external_providers OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17842835)
-- Name: external_providers_external_provider_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.external_providers_external_provider_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.external_providers_external_provider_id_seq OWNER TO postgres;

--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 204
-- Name: external_providers_external_provider_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.external_providers_external_provider_id_seq OWNED BY public.external_providers.external_provider_id;


--
-- TOC entry 207 (class 1259 OID 17842843)
-- Name: granted_permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.granted_permissions (
    role_id integer NOT NULL,
    permission_id integer NOT NULL
);


ALTER TABLE public.granted_permissions OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17842841)
-- Name: granted_permissions_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.granted_permissions_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.granted_permissions_role_id_seq OWNER TO postgres;

--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 206
-- Name: granted_permissions_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.granted_permissions_role_id_seq OWNED BY public.granted_permissions.role_id;


--
-- TOC entry 209 (class 1259 OID 17842849)
-- Name: hashing_algorithms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hashing_algorithms (
    hash_algorithm_id smallint NOT NULL,
    algorithm_name character varying(10) NOT NULL
);


ALTER TABLE public.hashing_algorithms OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17842847)
-- Name: hashing_algorithms_hash_algorithm_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hashing_algorithms_hash_algorithm_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hashing_algorithms_hash_algorithm_id_seq OWNER TO postgres;

--
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 208
-- Name: hashing_algorithms_hash_algorithm_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hashing_algorithms_hash_algorithm_id_seq OWNED BY public.hashing_algorithms.hash_algorithm_id;


--
-- TOC entry 219 (class 1259 OID 17842937)
-- Name: mobile_validation_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mobile_validation_status (
    mobile_validation_status_id smallint NOT NULL,
    status_description character varying NOT NULL
);


ALTER TABLE public.mobile_validation_status OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 17842855)
-- Name: permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permissions (
    permission_id integer NOT NULL,
    permission_description character varying(50) NOT NULL
);


ALTER TABLE public.permissions OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17842853)
-- Name: permissions_permission_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permissions_permission_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permissions_permission_id_seq OWNER TO postgres;

--
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 210
-- Name: permissions_permission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permissions_permission_id_seq OWNED BY public.permissions.permission_id;


--
-- TOC entry 218 (class 1259 OID 17842882)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    role_id smallint NOT NULL,
    role_description character varying(30) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 17842861)
-- Name: user_account_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account_detail (
    first_name character varying(100) NOT NULL,
    gender character(1) NOT NULL,
    last_name character varying(100) NOT NULL,
    middle_name character varying(100),
    user_id integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.user_account_detail OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 17843035)
-- Name: user_account_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_account_detail_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_account_detail_id_seq OWNER TO postgres;

--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 222
-- Name: user_account_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_account_detail_id_seq OWNED BY public.user_account_detail.id;


--
-- TOC entry 214 (class 1259 OID 17842867)
-- Name: user_login_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_login_data (
    user_id integer NOT NULL,
    full_name character varying(1000) NOT Null,
    password_hash character varying(250) NULL,
    password character varying(250) NOT NULL,
    password_salt character varying(100) NULL,
    hash_algorithm_id smallint NULL,
    username character varying(100) NOT NULL,
    confirmation_token character varying(100),
    token_generation_time timestamp without time zone,
    email_validation_status_id smallint NULL,
    password_recovery_token character varying(100),
    recovery_token_time timestamp without time zone,
    mobile_validation_status_id smallint NULL,
    mobile_number bigint NOT NULL
);


ALTER TABLE public.user_login_data OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 17842876)
-- Name: user_login_data_external; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_login_data_external (
    user_id integer NOT NULL,
    external_provider_id integer NOT NULL,
    external_provider_token character varying(100) NOT NULL
);


ALTER TABLE public.user_login_data_external OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17842874)
-- Name: user_login_data_external_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_login_data_external_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_login_data_external_user_id_seq OWNER TO postgres;

--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 215
-- Name: user_login_data_external_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_login_data_external_user_id_seq OWNED BY public.user_login_data_external.user_id;


--
-- TOC entry 213 (class 1259 OID 17842865)
-- Name: user_login_data_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_login_data_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_login_data_user_id_seq OWNER TO postgres;

--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 213
-- Name: user_login_data_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_login_data_user_id_seq OWNED BY public.user_login_data.user_id;


--
-- TOC entry 220 (class 1259 OID 17843019)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_roles (
    user_id integer NOT NULL,
    role_id smallint NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 17843027)
-- Name: user_roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_roles_id_seq OWNER TO postgres;

--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 221
-- Name: user_roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_roles_id_seq OWNED BY public.user_roles.id;


--
-- TOC entry 217 (class 1259 OID 17842880)
-- Name: user_roles_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_roles_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_roles_role_id_seq OWNER TO postgres;

--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 217
-- Name: user_roles_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_roles_role_id_seq OWNED BY public.roles.role_id;


--
-- TOC entry 2861 (class 2604 OID 17842966)
-- Name: email_validation_status email_validation_status_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_validation_status ALTER COLUMN email_validation_status_id SET DEFAULT nextval('public.email_validation_status_email_validation_status_id_seq'::regclass);


--
-- TOC entry 2862 (class 2604 OID 17842840)
-- Name: external_providers external_provider_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_providers ALTER COLUMN external_provider_id SET DEFAULT nextval('public.external_providers_external_provider_id_seq'::regclass);


--
-- TOC entry 2863 (class 2604 OID 17842846)
-- Name: granted_permissions role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.granted_permissions ALTER COLUMN role_id SET DEFAULT nextval('public.granted_permissions_role_id_seq'::regclass);


--
-- TOC entry 2864 (class 2604 OID 17842990)
-- Name: hashing_algorithms hash_algorithm_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hashing_algorithms ALTER COLUMN hash_algorithm_id SET DEFAULT nextval('public.hashing_algorithms_hash_algorithm_id_seq'::regclass);


--
-- TOC entry 2865 (class 2604 OID 17842858)
-- Name: permissions permission_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions ALTER COLUMN permission_id SET DEFAULT nextval('public.permissions_permission_id_seq'::regclass);


--
-- TOC entry 2869 (class 2604 OID 17843002)
-- Name: roles role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN role_id SET DEFAULT nextval('public.user_roles_role_id_seq'::regclass);


--
-- TOC entry 2866 (class 2604 OID 17843037)
-- Name: user_account_detail id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account_detail ALTER COLUMN id SET DEFAULT nextval('public.user_account_detail_id_seq'::regclass);


--
-- TOC entry 2867 (class 2604 OID 17842870)
-- Name: user_login_data user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data ALTER COLUMN user_id SET DEFAULT nextval('public.user_login_data_user_id_seq'::regclass);


--
-- TOC entry 2868 (class 2604 OID 17842879)
-- Name: user_login_data_external user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data_external ALTER COLUMN user_id SET DEFAULT nextval('public.user_login_data_external_user_id_seq'::regclass);


--
-- TOC entry 2870 (class 2604 OID 17843029)
-- Name: user_roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles ALTER COLUMN id SET DEFAULT nextval('public.user_roles_id_seq'::regclass);


--
-- TOC entry 3027 (class 0 OID 17842831)
-- Dependencies: 203
-- Data for Name: email_validation_status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.email_validation_status (email_validation_status_id, status_description) FROM stdin;
\.


--
-- TOC entry 3029 (class 0 OID 17842837)
-- Dependencies: 205
-- Data for Name: external_providers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.external_providers (external_provider_id, provider_name, ws_endpoint) FROM stdin;
\.


--
-- TOC entry 3031 (class 0 OID 17842843)
-- Dependencies: 207
-- Data for Name: granted_permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.granted_permissions (role_id, permission_id) FROM stdin;
\.


--
-- TOC entry 3033 (class 0 OID 17842849)
-- Dependencies: 209
-- Data for Name: hashing_algorithms; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hashing_algorithms (hash_algorithm_id, algorithm_name) FROM stdin;
\.


--
-- TOC entry 3043 (class 0 OID 17842937)
-- Dependencies: 219
-- Data for Name: mobile_validation_status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mobile_validation_status (mobile_validation_status_id, status_description) FROM stdin;
\.


--
-- TOC entry 3035 (class 0 OID 17842855)
-- Dependencies: 211
-- Data for Name: permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permissions (permission_id, permission_description) FROM stdin;
\.


--
-- TOC entry 3042 (class 0 OID 17842882)
-- Dependencies: 218
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (role_id, role_description) FROM stdin;
\.


--
-- TOC entry 3036 (class 0 OID 17842861)
-- Dependencies: 212
-- Data for Name: user_account_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_account_detail (first_name, gender, last_name, middle_name, user_id, id) FROM stdin;
\.


--
-- TOC entry 3038 (class 0 OID 17842867)
-- Dependencies: 214
-- Data for Name: user_login_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_login_data (user_id, password_hash, password_salt, hash_algorithm_id, email_address, confirmation_token, token_generation_time, email_validation_status_id, password_recovery_token, recovery_token_time, mobile_validation_status_id, mobile_number) FROM stdin;
\.


--
-- TOC entry 3040 (class 0 OID 17842876)
-- Dependencies: 216
-- Data for Name: user_login_data_external; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_login_data_external (user_id, external_provider_id, external_provider_token) FROM stdin;
\.


--
-- TOC entry 3044 (class 0 OID 17843019)
-- Dependencies: 220
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_roles (user_id, role_id, id) FROM stdin;
\.


--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 202
-- Name: email_validation_status_email_validation_status_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.email_validation_status_email_validation_status_id_seq', 1, false);


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 204
-- Name: external_providers_external_provider_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.external_providers_external_provider_id_seq', 1, false);


--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 206
-- Name: granted_permissions_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.granted_permissions_role_id_seq', 1, false);


--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 208
-- Name: hashing_algorithms_hash_algorithm_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hashing_algorithms_hash_algorithm_id_seq', 1, false);


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 210
-- Name: permissions_permission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permissions_permission_id_seq', 1, false);


--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 222
-- Name: user_account_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_account_detail_id_seq', 1, false);


--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 215
-- Name: user_login_data_external_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_login_data_external_user_id_seq', 1, false);


--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 213
-- Name: user_login_data_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_login_data_user_id_seq', 1, false);


--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 221
-- Name: user_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_roles_id_seq', 1, false);


--
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 217
-- Name: user_roles_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_roles_role_id_seq', 1, false);


--
-- TOC entry 2872 (class 2606 OID 17842968)
-- Name: email_validation_status email_validation_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_validation_status
    ADD CONSTRAINT email_validation_status_pkey PRIMARY KEY (email_validation_status_id);


--
-- TOC entry 2874 (class 2606 OID 17842889)
-- Name: external_providers external_providers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_providers
    ADD CONSTRAINT external_providers_pkey PRIMARY KEY (external_provider_id);


--
-- TOC entry 2876 (class 2606 OID 17842992)
-- Name: hashing_algorithms hashing_algorithms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hashing_algorithms
    ADD CONSTRAINT hashing_algorithms_pkey PRIMARY KEY (hash_algorithm_id);


--
-- TOC entry 2888 (class 2606 OID 17842958)
-- Name: mobile_validation_status mobile_validation_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mobile_validation_status
    ADD CONSTRAINT mobile_validation_status_pkey PRIMARY KEY (mobile_validation_status_id);


--
-- TOC entry 2878 (class 2606 OID 17842893)
-- Name: permissions permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT permissions_pkey PRIMARY KEY (permission_id);


--
-- TOC entry 2880 (class 2606 OID 17843042)
-- Name: user_account_detail user_account_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account_detail
    ADD CONSTRAINT user_account_detail_pkey PRIMARY KEY (id);


--
-- TOC entry 2884 (class 2606 OID 17842897)
-- Name: user_login_data_external user_login_data_external_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data_external
    ADD CONSTRAINT user_login_data_external_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2882 (class 2606 OID 17842899)
-- Name: user_login_data user_login_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data
    ADD CONSTRAINT user_login_data_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2886 (class 2606 OID 17843004)
-- Name: roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (role_id);


--
-- TOC entry 2890 (class 2606 OID 17843034)
-- Name: user_roles user_roles_pkey1; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey1 PRIMARY KEY (id);


--
-- TOC entry 2891 (class 2606 OID 17842902)
-- Name: granted_permissions granted_permissions_permission_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.granted_permissions
    ADD CONSTRAINT granted_permissions_permission_fk FOREIGN KEY (permission_id) REFERENCES public.permissions(permission_id);


--
-- TOC entry 2892 (class 2606 OID 17843005)
-- Name: granted_permissions granted_permissions_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.granted_permissions
    ADD CONSTRAINT granted_permissions_role_fk FOREIGN KEY (role_id) REFERENCES public.roles(role_id);


--
-- TOC entry 2895 (class 2606 OID 17842993)
-- Name: user_login_data hash_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data
    ADD CONSTRAINT hash_fk FOREIGN KEY (hash_algorithm_id) REFERENCES public.hashing_algorithms(hash_algorithm_id);


--
-- TOC entry 2893 (class 2606 OID 17843043)
-- Name: user_account_detail user_account_detail_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account_detail
    ADD CONSTRAINT user_account_detail_user_fk FOREIGN KEY (user_id) REFERENCES public.user_login_data(user_id);


--
-- TOC entry 2894 (class 2606 OID 17842969)
-- Name: user_login_data user_login_data_email_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data
    ADD CONSTRAINT user_login_data_email_fk FOREIGN KEY (email_validation_status_id) REFERENCES public.email_validation_status(email_validation_status_id);


--
-- TOC entry 2897 (class 2606 OID 17842927)
-- Name: user_login_data_external user_login_data_external_provider_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data_external
    ADD CONSTRAINT user_login_data_external_provider_id_fk FOREIGN KEY (external_provider_id) REFERENCES public.external_providers(external_provider_id);


--
-- TOC entry 2896 (class 2606 OID 17843022)
-- Name: user_login_data user_login_data_mobile_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data
    ADD CONSTRAINT user_login_data_mobile_fk FOREIGN KEY (mobile_validation_status_id) REFERENCES public.mobile_validation_status(mobile_validation_status_id);


--
-- TOC entry 2899 (class 2606 OID 17843053)
-- Name: user_roles user_roles_role_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_role_id_fk FOREIGN KEY (role_id) REFERENCES public.roles(role_id);


--
-- TOC entry 2898 (class 2606 OID 17843048)
-- Name: user_roles user_roles_user_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_user_id_fk FOREIGN KEY (user_id) REFERENCES public.user_login_data(user_id);


-- Completed on 2022-11-03 12:03:32 IST

--
-- PostgreSQL database dump complete
--

