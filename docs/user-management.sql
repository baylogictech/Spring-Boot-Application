--
-- PostgreSQL database dump
--

-- Dumped from database version 12.11 (Ubuntu 12.11-1.pgdg18.04+1)
-- Dumped by pg_dump version 14.4 (Ubuntu 14.4-1.pgdg18.04+1)

-- Started on 2022-10-28 11:00:51 IST

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
-- TOC entry 205 (class 1259 OID 17842765)
-- Name: email_validation_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.email_validation_status (
    email_validation_status_id SERIAL,
    status_description character varying(20) NOT NULL
);


ALTER TABLE public.email_validation_status OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 17842788)
-- Name: external_providers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.external_providers (
    external_provider_id SERIAL,
    provider_name character varying(50) NOT NULL,
    ws_endpoint character varying(200)
);


ALTER TABLE public.external_providers OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17842775)
-- Name: granted_permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.granted_permissions (
    role_id SERIAL,
    permission_id integer NOT NULL
);


ALTER TABLE public.granted_permissions OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17842760)
-- Name: hashing_algorithms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hashing_algorithms (
    hash_algorithm_id SERIAL,
    algorithm_name character varying(10) NOT NULL
);


ALTER TABLE public.hashing_algorithms OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 17842778)
-- Name: permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permissions (
    permission_id SERIAL,
    permission_description character varying(50) NOT NULL
);


ALTER TABLE public.permissions OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17842755)
-- Name: user_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account (
    id SERIAL,
    first_name character varying(100) NOT NULL,
    gender character(1) NOT NULL,
    last_name character varying(100) NOT NULL,
    middle_name character varying(100),
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.user_account OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17842747)
-- Name: user_login_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_login_data (
    user_id SERIAL,
    login_name character varying(50) NOT NULL,
    password_hash character varying(250) NOT NULL,
    password_salt character varying(100) NOT NULL,
    hash_algorithm_id integer NOT NULL,
    email_address character varying(100) NOT NULL,
    confirmation_token character varying(100),
    token_generation_time timestamp without time zone,
    email_validation_status_id integer NOT NULL,
    password_recovery_token character varying(100),
    recovery_token_time timestamp without time zone
);


ALTER TABLE public.user_login_data OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 17842783)
-- Name: user_login_data_external; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_login_data_external (
    user_id SERIAL,
    external_provider_id integer NOT NULL,
    external_provider_token character varying(100) NOT NULL
);


ALTER TABLE public.user_login_data_external OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17842770)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_roles (
    role_id SERIAL,
    role_description character varying(30) NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

--
-- TOC entry 2984 (class 0 OID 17842765)
-- Dependencies: 205
-- Data for Name: email_validation_status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.email_validation_status (email_validation_status_id, status_description) FROM stdin;
\.


--
-- TOC entry 2989 (class 0 OID 17842788)
-- Dependencies: 210
-- Data for Name: external_providers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.external_providers (external_provider_id, provider_name, ws_endpoint) FROM stdin;
\.


--
-- TOC entry 2986 (class 0 OID 17842775)
-- Dependencies: 207
-- Data for Name: granted_permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.granted_permissions (role_id, permission_id) FROM stdin;
\.


--
-- TOC entry 2983 (class 0 OID 17842760)
-- Dependencies: 204
-- Data for Name: hashing_algorithms; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hashing_algorithms (hash_algorithm_id, algorithm_name) FROM stdin;
\.


--
-- TOC entry 2987 (class 0 OID 17842778)
-- Dependencies: 208
-- Data for Name: permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permissions (permission_id, permission_description) FROM stdin;
\.


--
-- TOC entry 2982 (class 0 OID 17842755)
-- Dependencies: 203
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_account (first_name, gender, last_name, middle_name, user_id, role_id) FROM stdin;
\.


--
-- TOC entry 2981 (class 0 OID 17842747)
-- Dependencies: 202
-- Data for Name: user_login_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_login_data (user_id, login_name, password_hash, password_salt, hash_algorithm_id, email_address, confirmation_token, token_generation_time, email_validation_status_id, password_recovery_token, recovery_token_time) FROM stdin;
\.


--
-- TOC entry 2988 (class 0 OID 17842783)
-- Dependencies: 209
-- Data for Name: user_login_data_external; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_login_data_external (user_id, external_provider_id, external_provider_token) FROM stdin;
\.


--
-- TOC entry 2985 (class 0 OID 17842770)
-- Dependencies: 206
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_roles (role_id, role_description) FROM stdin;
\.


--
-- TOC entry 2839 (class 2606 OID 17842769)
-- Name: email_validation_status email_validation_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.email_validation_status
    ADD CONSTRAINT email_validation_status_pkey PRIMARY KEY (email_validation_status_id);


--
-- TOC entry 2847 (class 2606 OID 17842792)
-- Name: external_providers external_providers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_providers
    ADD CONSTRAINT external_providers_pkey PRIMARY KEY (external_provider_id);


--
-- TOC entry 2837 (class 2606 OID 17842764)
-- Name: hashing_algorithms hashing_algorithms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hashing_algorithms
    ADD CONSTRAINT hashing_algorithms_pkey PRIMARY KEY (hash_algorithm_id);


--
-- TOC entry 2843 (class 2606 OID 17842782)
-- Name: permissions permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT permissions_pkey PRIMARY KEY (permission_id);


--
-- TOC entry 2835 (class 2606 OID 17842759)
-- Name: user_account user_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2845 (class 2606 OID 17842787)
-- Name: user_login_data_external user_login_data_external_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data_external
    ADD CONSTRAINT user_login_data_external_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2833 (class 2606 OID 17842751)
-- Name: user_login_data user_login_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data
    ADD CONSTRAINT user_login_data_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2841 (class 2606 OID 17842774)
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (role_id);


--
-- TOC entry 2852 (class 2606 OID 17842808)
-- Name: granted_permissions granted_permissions_permission_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.granted_permissions
    ADD CONSTRAINT granted_permissions_permission_fk FOREIGN KEY (permission_id) REFERENCES public.permissions(permission_id);


--
-- TOC entry 2851 (class 2606 OID 17842803)
-- Name: granted_permissions granted_permissions_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.granted_permissions
    ADD CONSTRAINT granted_permissions_role_fk FOREIGN KEY (role_id) REFERENCES public.user_roles(role_id);


--
-- TOC entry 2848 (class 2606 OID 17842798)
-- Name: user_login_data hash_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data
    ADD CONSTRAINT hash_fk FOREIGN KEY (hash_algorithm_id) REFERENCES public.hashing_algorithms(hash_algorithm_id);


--
-- TOC entry 2850 (class 2606 OID 17842793)
-- Name: user_account role_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES public.user_roles(role_id);


--
-- TOC entry 2849 (class 2606 OID 17842813)
-- Name: user_login_data user_login_data_email_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data
    ADD CONSTRAINT user_login_data_email_fk FOREIGN KEY (email_validation_status_id) REFERENCES public.email_validation_status(email_validation_status_id);


--
-- TOC entry 2854 (class 2606 OID 17842823)
-- Name: user_login_data_external user_login_data_external_provider_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data_external
    ADD CONSTRAINT user_login_data_external_provider_id_fk FOREIGN KEY (external_provider_id) REFERENCES public.external_providers(external_provider_id);


--
-- TOC entry 2853 (class 2606 OID 17842818)
-- Name: user_login_data_external user_login_data_external_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_login_data_external
    ADD CONSTRAINT user_login_data_external_user_fk FOREIGN KEY (user_id) REFERENCES public.user_account(user_id);


-- Completed on 2022-10-28 11:00:51 IST

--
-- PostgreSQL database dump complete
--

