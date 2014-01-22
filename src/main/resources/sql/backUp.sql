

COPY action (name, ability, triger, type) FROM stdin;
			
Odpornośc 1	Anuluj jedno przydzielone obrażenie	Wymuszony	Pasywne
Odpornośc 2	Anuluj Dwa przydzielone obrażenie	Wymuszony	Pasywne
Odpornośc 3	Anuluj Trzy przydzielone obrażenie	Wymuszony	Pasywne
Odpornośc 4	Anuluj Cztery przydzielone obrażenie	Wymuszony	Pasywne
\.


--
-- Data for Name: card; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY card (name, addicionallcost, basiccost, count, defence, image, strenght, subtypes, edition_name, race_name, type_name) FROM stdin;
Płomienie feniksa	3	4	3	\N	\N	\N	Zaklęcie	Szturm na Ulthan	Elfy Wysokiego Rodu	Taktyka
Cytadela Zmierzchu	2	3	3	\N	\N	1	Budowla	Marsz Potępionych	Elfy Wysokiego Rodu	Wsparcie
Osąd Loeca	3	1	3	\N	\N	\N	Dodatek,Zaklęcie	Legendy	Elfy Wysokiego Rodu	Wsparcie
Tyrion	5	6	3	4	\N	2	\N	Legendy	Elfy Wysokiego Rodu	Legenda
Łzy Ishy	1	1	2	\N	\N	\N	Zaklęcie	Szturm na Ulthan	Elfy Wysokiego Rodu	Taktyka
Szpon Feniksa	2	1	3	\N	\N	\N	Dodatek,Broń	Kataklizm	Elfy Wysokiego Rodu	Wsparcie
Mistyczna Uzdrowicielka	2	2	3	2	\N	1	Czarodziej	Kataklizm	Elfy Wysokiego Rodu	Jednostka
Lśniąca Wieża	1	2	3	\N	\N	1	Budowla	Szturm na Ulthan	Elfy Wysokiego Rodu	Wsparcie
Pomiot Itzla	\N	3	3	1	\N	\N		Marsz Potępionych	Jaszczuroludzie	Jednostka
Elfi Wierzchowiec	2	1	3	\N	\N	\N	dodatek	Legendy	Elfy Wysokiego Rodu	Wsparcie
Archaon	5	7	3	5	\N	3	Legenda	Legendy	Chaos	Legenda
\.


--
-- Data for Name: card_action; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY card_action (card_id, action_id) FROM stdin;
\.


--
-- Data for Name: card_deck; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY card_deck (deck_id, card_id) FROM stdin;
Moj 6	Tyrion
Moj 6	Tyrion
Moj 6	Tyrion
Moj 6	Tyrion
Moj 6	Tyrion
\.


--
-- Data for Name: deck; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY deck (name, basic_race_name, user_nick) FROM stdin;
Moj 1	Elfy Wysokiego Rodu	i1macura
Moj 2	Elfy Wysokiego Rodu	i1macura
Moj 3	Elfy Wysokiego Rodu	i1macura
Moj 4	Elfy Wysokiego Rodu	i1macura
Moj 5	Elfy Wysokiego Rodu	i1rys
Moj 6	Elfy Wysokiego Rodu	i1macura
\.


--
-- Data for Name: edition; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY edition (name) FROM stdin;
Core
Szturm na Ulthan
Marsz Potępionych
Legendy
Kataklizm
Ukryte Królestwa

\.


--
-- Data for Name: race; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY race (name, fraction) FROM stdin;
Elfy Wysokiego Rodu	Porządek
Imperium	Porządek
Krasnoludy	Porządek
Chaos	Zniszczenie
Mroczne Elfy	Zniszczenie
Orki	Zniszczenie
Leśne elfy	Porządek
Jaszczuroludzie	Porządek
Nieumarli	Zniszczenie
Skaveni	Zniszczenie
Neutralni	Neutralni
	Neutralni
\.


--
-- Data for Name: type; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY type (name) FROM stdin;
Wsparcie
Taktyka
Jednostka
Legenda

\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: project; Owner: i1macura
--

COPY "user" (nick, password, role) FROM stdin;
i1macura	admin	admin
i1rys	admin	admin
\.


--
-- Name: action_pkey; Type: CONSTRAINT; Schema: project; Owner: i1macura; Tablespace: 
--

ALTER TABLE ONLY action
    ADD CONSTRAINT action_pkey PRIMARY KEY (name);


--
-- Name: card_pkey; Type: CONSTRAINT; Schema: project; Owner: i1macura; Tablespace: 
--

ALTER TABLE ONLY card
    ADD CONSTRAINT card_pkey PRIMARY KEY (name);


--
-- Name: deck_pkey; Type: CONSTRAINT; Schema: project; Owner: i1macura; Tablespace: 
--

ALTER TABLE ONLY deck
    ADD CONSTRAINT deck_pkey PRIMARY KEY (name);


--
-- Name: edition_pkey; Type: CONSTRAINT; Schema: project; Owner: i1macura; Tablespace: 
--

ALTER TABLE ONLY edition
    ADD CONSTRAINT edition_pkey PRIMARY KEY (name);


--
-- Name: race_pkey; Type: CONSTRAINT; Schema: project; Owner: i1macura; Tablespace: 
--

ALTER TABLE ONLY race
    ADD CONSTRAINT race_pkey PRIMARY KEY (name);


--
-- Name: type_pkey; Type: CONSTRAINT; Schema: project; Owner: i1macura; Tablespace: 
--

ALTER TABLE ONLY type
    ADD CONSTRAINT type_pkey PRIMARY KEY (name);


--
-- Name: user_pkey; Type: CONSTRAINT; Schema: project; Owner: i1macura; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (nick);


--
-- Name: fk_1vxv6m04sabl70mkwekx9emst; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY card_action
    ADD CONSTRAINT fk_1vxv6m04sabl70mkwekx9emst FOREIGN KEY (card_id) REFERENCES card(name);


--
-- Name: fk_4118jmk7vmgu340epqytjehjx; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY deck
    ADD CONSTRAINT fk_4118jmk7vmgu340epqytjehjx FOREIGN KEY (basic_race_name) REFERENCES race(name);


--
-- Name: fk_72x8ijwooye1c735pr2v6y11l; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY card_deck
    ADD CONSTRAINT fk_72x8ijwooye1c735pr2v6y11l FOREIGN KEY (deck_id) REFERENCES deck(name);


--
-- Name: fk_cm8xmccjvp5790q6fqwflaomk; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY card_deck
    ADD CONSTRAINT fk_cm8xmccjvp5790q6fqwflaomk FOREIGN KEY (card_id) REFERENCES card(name);


--
-- Name: fk_dxtvvd5sexguexbvd2jqub9st; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY card
    ADD CONSTRAINT fk_dxtvvd5sexguexbvd2jqub9st FOREIGN KEY (edition_name) REFERENCES edition(name);


--
-- Name: fk_k3oooaacncdpv4aa83pnn0h98; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY card_action
    ADD CONSTRAINT fk_k3oooaacncdpv4aa83pnn0h98 FOREIGN KEY (action_id) REFERENCES action(name);


--
-- Name: fk_ldlbsroa8giu60rvwpcq7uhto; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY deck
    ADD CONSTRAINT fk_ldlbsroa8giu60rvwpcq7uhto FOREIGN KEY (user_nick) REFERENCES "user"(nick);


--
-- Name: fk_opd9hubd8jh0s6w7naxoh7g1j; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY card
    ADD CONSTRAINT fk_opd9hubd8jh0s6w7naxoh7g1j FOREIGN KEY (race_name) REFERENCES race(name);


--
-- Name: fk_s8amncb0b1n7ag1mmtgaau9k3; Type: FK CONSTRAINT; Schema: project; Owner: i1macura
--

ALTER TABLE ONLY card
    ADD CONSTRAINT fk_s8amncb0b1n7ag1mmtgaau9k3 FOREIGN KEY (type_name) REFERENCES type(name);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

