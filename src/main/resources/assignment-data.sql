INSERT INTO user(id, name, agree_to_terms, is_active, created_at) VALUES
('1', 'Vahap', 1, 1, '2021-03-27 10:57:53'),
('2', 'Efe', 1, 1, '2021-03-27 10:57:53');

INSERT INTO sector(id, parent_id, name, is_active, created_at) VALUES
('1', null, 'Manufacturing', 1, '2020-07-27 10:57:53'),
('2', '1', 'Construction materials', 1, '2020-07-27 10:57:53'),
('3', '1', 'Electronics and Optics', 1, '2020-07-27 10:57:53'),
('4', '1', 'Food and Beverage', 1, '2020-07-27 10:57:53'),
('5', '1', 'Furniture', 1, '2020-07-27 10:57:53'),
('6', '1', 'Machinery', 1, '2020-07-27 10:57:53'),
('7', '1', 'Metalworking', 1, '2020-07-27 10:57:53'),
('8', '1', 'Plastic and Rubber', 1, '2020-07-27 10:57:53'),
('9', '1', 'Printing', 1, '2020-07-27 10:57:53'),
('10', '1', 'Textile and Clothing', 1, '2020-07-27 10:57:53'),
('11', '1', 'Wood', 1, '2020-07-27 10:57:53'),
('12', '1', 'Tourism', 1, '2020-07-27 10:57:53'),
('13', '1', 'Translation services', 1, '2020-07-27 10:57:53'),
('14', '1', 'Transport and Logistics', 1, '2020-07-27 10:57:53'),
('15', '4', 'Bakery & confectionery products', 1, '2020-07-27 10:57:53'),
('16', '4', 'Beverages', 1, '2020-07-27 10:57:53'),
('17', '4', 'Fish & fish products', 1, '2020-07-27 10:57:53'),
('18', '4', 'Meat & meat products', 1, '2020-07-27 10:57:53'),
('19', '4', 'Milk & dairy products', 1, '2020-07-27 10:57:53'),
('20', '4', 'Other', 1, '2020-07-27 10:57:53'),
('21', '4', 'Sweets & snack food', 1, '2020-07-27 10:57:53'),
('22', '5', 'Bathroom/sauna', 1, '2020-07-27 10:57:53'),
('23', '5', 'Bedroom', 1, '2020-07-27 10:57:53'),
('24', '5', 'Children''s room', 1, '2020-07-27 10:57:53'),
('25', '5', 'Kitchen', 1, '2020-07-27 10:57:53'),
('26', '5', 'Living room', 1, '2020-07-27 10:57:53'),
('27', '5', 'Office', 1, '2020-07-27 10:57:53'),
('28', '5', 'Other (Furniture)', 1, '2020-07-27 10:57:53'),
('29', '5', 'Outdoor', 1, '2020-07-27 10:57:53'),
('30', '5', 'Project furniture', 1, '2020-07-27 10:57:53'),
('31', '6', 'Machinery components', 1, '2020-07-27 10:57:53'),
('32', '6', 'Machinery equipment/tools', 1, '2020-07-27 10:57:53'),
('33', '6', 'Manufacture of machinery', 1, '2020-07-27 10:57:53'),
('34', '6', 'Maritime', 1, '2020-07-27 10:57:53'),
('35', '34', 'Aluminium and steel workboats', 1, '2020-07-27 10:57:53'),
('36', '34', 'Boat/Yacht building', 1, '2020-07-27 10:57:53'),
('37', '34', 'Ship repair and conversion', 1, '2020-07-27 10:57:53'),
('38', '34', 'Metal structures', 1, '2020-07-27 10:57:53'),
('39', '38', 'Repair and maintenance service', 1, '2020-07-27 10:57:53'),
('40', '38', 'Other', 1, '2020-07-27 10:57:53'),
('41', '7', 'Construction of metal structures', 1, '2020-07-27 10:57:53'),
('42', '7', 'Houses and buildings', 1, '2020-07-27 10:57:53'),
('43', '7', 'Metal products', 1, '2020-07-27 10:57:53'),
('44', '7', 'Metal works', 1, '2020-07-27 10:57:53'),
('45', '44', 'Construction of metal structures', 1, '2020-07-27 10:57:53'),
('46', '44', 'Houses and buildings', 1, '2020-07-27 10:57:53'),
('47', '44', 'Metal products', 1, '2020-07-27 10:57:53'),
('48', '44', 'Metal works', 1, '2020-07-27 10:57:53'),
('49', '48', 'CNC-machining', 1, '2020-07-27 10:57:53'),
('50', '48', 'Forgings, Fasteners', 1, '2020-07-27 10:57:53'),
('51', '48', 'Gas, Plasma, Laser cutting', 1, '2020-07-27 10:57:53'),
('52', '48', 'MIG, TIG, Aluminum welding', 1, '2020-07-27 10:57:53'),
('53', '8', 'Packaging', 1, '2020-07-27 10:57:53'),
('54', '8', 'Plastic goods', 1, '2020-07-27 10:57:53'),
('55', '8', 'Plastic processing technology', 1, '2020-07-27 10:57:53'),
('56', '55', 'Blowing', 1, '2020-07-27 10:57:53'),
('57', '55', 'Moulding', 1, '2020-07-27 10:57:53'),
('58', '55', 'Plastics welding and processing', 1, '2020-07-27 10:57:53'),
('59', '8', 'Plastic profiles', 1, '2020-07-27 10:57:53'),
('60', '9', 'Advertising', 1, '2020-07-27 10:57:53'),
('61', '9', 'Book/Periodicals printing', 1, '2020-07-27 10:57:53'),
('62', '9', 'Labelling and packaging printing', 1, '2020-07-27 10:57:53'),
('63', '10', 'Clothing', 1, '2020-07-27 10:57:53'),
('64', '10', 'Textile', 1, '2020-07-27 10:57:53'),
('65', '11', 'Other (Wood)', 1, '2020-07-27 10:57:53'),
('66', '11', 'Wooden building materials', 1, '2020-07-27 10:57:53'),
('67', '11', 'Wooden houses', 1, '2020-07-27 10:57:53'),
('68', null, 'Other', 1, '2020-07-27 10:57:53'),
('69', '68', 'Creative industries', 1, '2020-07-27 10:57:53'),
('70', '68', 'Energy technology', 1, '2020-07-27 10:57:53'),
('71', '68', 'Environment', 1, '2020-07-27 10:57:53'),
('72', null, 'Service', 1, '2020-07-27 10:57:53'),
('73', '72', 'Business services', 1, '2020-07-27 10:57:53'),
('74', '72', 'Engineering', 1, '2020-07-27 10:57:53'),
('75', '72', 'Information Technology and Telecommunications', 1, '2020-07-27 10:57:53'),
('76', '75', 'Data processing, Web portals, E-marketing', 1, '2020-07-27 10:57:53'),
('77', '75', 'Programming, Consultancy', 1, '2020-07-27 10:57:53'),
('78', '75', 'Software, Hardware', 1, '2020-07-27 10:57:53'),
('79', '75', 'Telecommunications', 1, '2020-07-27 10:57:53'),
('80', '14', 'Air', 1, '2020-07-27 10:57:53'),
('81', '14', 'Rail', 1, '2020-07-27 10:57:53'),
('82', '14', 'Road', 1, '2020-07-27 10:57:53'),
('83', '14', 'Water', 1, '2020-07-27 10:57:53');