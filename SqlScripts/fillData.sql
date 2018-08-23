INSERT INTO public.t_unit(
	name, shortcut)
	VALUES ('Kilogramy', 'KG');
	
INSERT INTO public.t_unit(
	name, shortcut)
	VALUES ('Litry', 'L');
	
INSERT INTO public.t_unit(
	name, shortcut)
	VALUES ('Metry', 'M');
	
	
	
INSERT INTO public.t_product(
	name, unit_id)
	VALUES ('Ziemniaki', 1);
	
INSERT INTO public.t_product(
	name, unit_id)
	VALUES ('Mleko', 2);
	
INSERT INTO public.t_product(
	name, unit_id)
	VALUES ('Cebula', 3);


	
INSERT INTO public.t_client(
	name, address)
	VALUES ('ACompany', 'Nowhere 21');
	
INSERT INTO public.t_client(
	name, address)
	VALUES ('BCompany', 'Nowhere 23');

INSERT INTO public.t_client(
	name, address)
	VALUES ('CCompany', 'Nowhere 24');
	

	
INSERT INTO public.t_order(
	client_id, realization_date)
	VALUES (1, '2018-06-02')
	
INSERT INTO public.t_order(
	client_id, realization_date)
	VALUES (2, '2018-06-02')
	
INSERT INTO public.t_order(
	client_id, realization_date)
	VALUES (3, '2018-06-03')