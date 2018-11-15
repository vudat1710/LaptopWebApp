
USE laptopDBTest;
--
-- Delete data from the table 'storage'
--
TRUNCATE TABLE storage;
--
-- Delete data from the table 'ordersdetail'
--
TRUNCATE TABLE ordersdetail;
--
-- Delete data from the table 'product'
--
DELETE FROM product;
--
-- Delete data from the table 'order'
--
DELETE FROM `order`;
--
-- Delete data from the table 'user'
--
DELETE FROM user;
--
-- Delete data from the table 'supplier'
--
DELETE FROM supplier;

--
-- Inserting data into table supplier
--
INSERT INTO supplier(supplierId, supplierBrand, supplierDescription) VALUES
(1, 'National Space Resea', 'Deleniti molestiae aut aliquid nobis. Molestias nesciunt velit qui sunt? Exercitationem rerum non omnis perspiciatis. Consequuntur quam nemo maxime sint.'),
(2, 'Smart Thermal Resour', 'Error consequatur fuga minima deleniti. Earum repellendus alias quidem recusandae; velit harum non natus quia. Possimus at dolores est harum.'),
(3, 'Pacific High-Technol', 'Sunt vitae qui quia sit. Doloremque ut qui numquam qui! Maiores voluptatem inventore nulla quas. Eos eaque fugit aut consectetur?'),
(4, 'Federal Management I', 'Dolorem tenetur ut quos maxime; quaerat enim natus pariatur quia? Omnis quo modi nemo at. Laudantium numquam tempore velit tenetur.'),
(5, 'City M-Mobile Inc.', 'Error est exercitationem at minus. Quia quo est a minima. Sint itaque nam quia delectus. Consequatur rerum consequatur qui animi.'),
(6, 'South Laboratories C', 'Nulla saepe rem sit velit. Nostrum iste qui officiis blanditiis. Maxime nostrum distinctio voluptatem accusamus. Vel repudiandae qui itaque eaque.'),
(7, 'Home High-Technologi', 'Sapiente sit a voluptatum nihil. Qui ut accusamus nihil dolores. Iure voluptates quia odit iste. Eligendi repudiandae natus reprehenderit odit?'),
(8, 'First High-Technolog', 'Enim id dicta dolorum porro; nostrum omnis sit in consequatur. Est ut nam magnam modi! Quos dignissimos saepe dolores molestias.'),
(9, 'South A-Mobile Inc.', 'Harum molestias sint veritatis fugiat. Aliquid ab animi ut explicabo. Dolor unde a aut hic! Soluta dolorem sequi quia sed?'),
(10, 'South 3G Wireless In', 'Architecto totam quis aut harum. Unde modi suscipit ipsa id. Est molestiae possimus doloremque dolor. Mollitia eaque autem sapiente nulla.');

--
-- Inserting data into table user
--
INSERT INTO user(userId, username, password, name, email, birthDate, gender, address, phone, authority) VALUES
(1, 'Abe3', '0wSqw59960l905$Z8W5CC0iwqWDE!d1TGsG3q!7qlNN!4I7oHu7Wm5jgZ5Ts', 'Harmon', 'AbeSSims856@example.com', '1948-01-02', 'FEMALE', '3940 South Cedar Tree Ct', '823-7123', 'ROLE_USER'),
(2, 'Danna877', 'B7P10gD7VQ6OnhCS!of!H!39QZr2SiM0LoG3uDoN1R3wIj9T6!94RiDX67TY', 'Pereira', 'Bolin641@example.com', '1993-03-10', 'MALE', '3017 Pine Tree Parkway', '936-7671', 'ROLE_USER'),
(3, 'Lynwood893', 'RZdFWl2MKCin!h26FZuG2OwwEmJJMiVEHEM74D$q1U78Hi1LBonSNVF4eurl', 'Talbot', 'Arroyo@nowhere.com', '1956-03-16', 'FEMALE', '2478 New Oak Street', '097-0506', 'ROLE_USER'),
(4, 'Terry581', '$647w81THB00ga3!U7UCC0Pj35a011aHj!5e9iH2npt2ySbdKWtaf5mmdcAF', 'Dougherty', 'FrederickLandis@example.com', '1988-01-02', 'OTHER', '2467 S Market Street', '949-5258', 'ROLE_USER'),
(5, 'Ackerman1983', '4cb58hP01CKa!od35!3ATMI19h1!v0nn31$j4Y5OCL5$l2721lNheAME17xz', 'Zamora', 'Oralia_Sousa6@example.com', '1964-06-17', 'MALE', '2381 Front Blvd', '511-7814', 'ROLE_USER'),
(6, 'Augusta8', 'J6X1$94cOH0C0G!bSe3kUB7hv$918632514UoG249tdp02isR2ss62fxi7Wq', 'Knowles', 'Bennett_J.Maldonado58@example.com', '1948-01-04', 'MALE', '491 White Prospect Hill Parkway', '652-4022', 'ROLE_ADMIN'),
(7, 'Flagg2018', '7c$6c!m4L8y$$s2v677!7U!ghFDFPcT42PTHg78eip6fl1FxvK74!3DI59dy', 'Collins', 'AlesiaLilly47@nowhere.com', '1996-05-02', 'OTHER', '499 Hazelwood Ct', '314-7268', 'ROLE_USER'),
(8, 'Boyle8', '9fC4J8n1T3BYJTcRw8kcyV77G177WPo0In33ZiShNEn!WeZT87P2q5!3BwrB', 'Bolin', 'lhonzjm1591@example.com', '2000-12-20', 'OTHER', '1808 Market Hwy', '409-1121', 'ROLE_USER'),
(9, 'Armand1971', 'kpmw$9SQrF7fF2v36L4qh5xku$0sG0HnneqRyY04g!$86cSD92!c7Fhj$dFP', 'Goble', 'AddisonS51@example.com', '1976-01-18', 'MALE', '27 West Fox Hill Ct', '352-0271', 'ROLE_USER'),
(10, 'Sharice1966', '83$w79296$yk34WD5Lulw3JEtHh02!8M2qvW$!bGIXwAd7RiM27A95iwEZo8', 'Colon', 'WillardAiello@nowhere.com', '1966-12-25', 'MALE', '1614 Mountain Court', '984-5666', 'ROLE_USER'),
(11, 'Abel379', 'h!pHI1me0U7PNgziW5aS5h5$ka9I9s50GIW2q2VN!Y6oPWIy86vse9!fp8!k', 'Harms', 'qfaozsv350@example.com', '1951-09-05', 'MALE', '46 Cedar Tree Hwy', '944-6714', 'ROLE_USER'),
(12, 'Ariel2021', 'TJ1ehPSq3c1we60j2oGkgb39!hBy85BS17y9Wud4kAwvC00vS!72u!!yjDcR', 'Mcmahan', 'EarnestAndres453@example.com', '1997-07-23', 'MALE', '217 South Pine Tree Ave', '628-2237', 'ROLE_USER'),
(13, 'Antonia48', 'JRGgucr2c$Ybh!1NvX$M269gtv83dQcsK9P$!5h9Fdj5Z6bkRuIF47314bz9', 'Talbott', 'xglzwedk.kovibhvvd@example.com', '1980-10-12', 'MALE', '774 Ironwood Avenue', '094-6481', 'ROLE_USER'),
(14, 'Mathilda94', 'u7559IzM$pRpL3$Tm7DPQ0gpeynHvr14$HU5m5Xqd5Z3A5g!I0Rf55d0iAH7', 'Doughty', 'DollyMares67@example.com', '1949-08-11', 'MALE', '2020 Town Ct', '205-2565', 'ROLE_USER'),
(15, 'Lachelle2005', 'H6rAduWEcHM7CF8WEb07MFxe53LZl05dCOuB4!Htos!M94Y85Vyvs1krCO7S', 'Knowlton', 'TiffanyM.Cunningham62@example.com', '1963-05-17', 'FEMALE', '3433 Fox Hill Ln', '180-2614', 'ROLE_USER'),
(16, 'Elaine2009', '!$5G0x3Ijy49yNvwJ1bhku2927s9y2$ggR3Q2Hy3Gn04wL4G95S1$J5q8M1Z', 'Perez', 'Vernon_Estrada24@nowhere.com', '1995-06-26', 'OTHER', '865 New Hazelwood Road', '519-5709', 'ROLE_USER'),
(17, 'Dan1998', '$8yWXf7!QT0$ORd06ADha5RnBzjuI8dM4SI65cwo9E8zU$AyxaLM0$V!TeG9', 'Zapata', 'AdellAbreu@example.com', '1948-02-27', 'FEMALE', '144 North Ashwood Cir', '005-4104', 'ROLE_USER'),
(18, 'Sell1', '8!$07NMympl977f!8H!8RN7M000bjU2ZLG0L26V6MDphp0gazagoer$4o2LF', 'Talley', 'Peek26@nowhere.com', '1981-02-22', 'OTHER', '2150 SW Riverview Avenue', '826-9038', 'ROLE_USER'),
(19, 'Wanetta518', 'f4p1zNo74j8qSi!48!oHcc8h9J5UzVI9xC159jXMIK9Za68$g2i8VSE46Mw1', 'Harness', 'Rubin432@example.com', '1988-02-18', 'OTHER', '3179 Parkwood Pkwy', '034-5754', 'ROLE_ADMIN'),
(20, 'Adolfo286', '6RkLl22uiD$wx8lggw!2515z6!$$59Lcwe1abCfb4c8k1jI7!nrMuM7N!RFu', 'Zaragoza', 'LalaHough@nowhere.com', '1992-05-05', 'FEMALE', '3656 Stonewood Parkway', '254-5662', 'ROLE_USER');

--
-- Inserting data into table `order`
--
INSERT INTO `order`(orderId, userId, shipAddress, totalPrice, orderDate, shipDate, status) VALUES
(1, 19, '240 Hidden Front Way', 20669516, '2018-10-16', '2018-06-04', 'SHIPPING'),
(2, 14, '2948 Stonewood Pkwy', 12765144, '2018-07-06', '2018-08-04', 'PREPARING'),
(3, 6, '44 West Church Ct', 26183965, '2018-09-23', '2018-06-08', 'FINISH'),
(4, 12, '3778 Edgewood Highway', 15011253, '2018-06-07', '2018-06-20', 'FINISH'),
(5, 13, '12 1st Circle', 10638312, '2018-07-14', '2018-06-13', 'FINISH'),
(6, 19, '3570 Flintwood Parkway', 14468376, '2018-08-09', '2018-08-02', 'FINISH'),
(7, 1, '1790 SW Church Avenue', 16253911, '2018-09-29', '2018-09-05', 'SHIPPING'),
(8, 10, '2014 Social Road', 16593285, '2018-08-03', '2018-06-12', 'CANCELED'),
(9, 6, '34 Riddle Hill Pkwy', 29772230, '2018-06-21', '2018-06-17', 'PREPARING'),
(10, 16, '65 Waterview Avenue', 13259688, '2018-06-25', '2018-08-16', 'FINISH'),
(11, 13, '3760 West Social Parkway', 25730564, '2018-06-05', '2018-09-12', 'PREPARING'),
(12, 10, '1254 New Cedar Tree Rd', 23017219, '2018-08-01', '2018-06-06', 'SHIPPING'),
(13, 19, '2354 N Cedar Tree Hwy', 29597276, '2018-06-01', '2018-06-05', 'SHIPPING'),
(14, 4, '95 North Church Road', 10095912, '2018-06-05', '2018-09-04', 'CANCELED'),
(15, 4, '47 W Ashwood Avenue', 26492226, '2018-07-20', '2018-06-03', 'FINISH'),
(16, 5, '2455 Buttonwood Ln', 5525857, '2018-07-09', '2018-09-15', 'FINISH'),
(17, 10, '10 Social Lane', 18019869, '2018-06-21', '2018-08-01', 'SHIPPING'),
(18, 16, '633 New Parkwood St', 9548201, '2018-07-12', '2018-06-14', 'FINISH'),
(19, 6, '2762 Buttonwood Road', 17588674, '2018-06-09', '2018-07-06', 'FINISH'),
(20, 16, '1027 NW Ashwood Cir', 12075225, '2018-06-12', '2018-06-24', 'FINISH');

--
-- Inserting data into table product
--
INSERT INTO product(productId, productName, productDescription, supplierId, price, cpu, vga, ram, hardDisk) VALUES
('B004DGBO5O', 'Retellopor', 'Excepturi perferendis veritatis voluptatem labore maxime odit distinctio sint voluptatem. Deserunt perferendis rerum, blanditiis iste amet natus ea eligendi;', 7, 18639664, 'Intel Core i7 6600HQ', 'NVIDIA GT 1000 TI 4GB DDR5', 'Ram 4GB DDR3 2400MHz (1 slots)', 'SSD SATA3 256GB'),
('B00U9IFHF6', 'Tabcessollator', 'Non vero minima dolorem aspernatur accusamus inventore voluptatem, quas tenetur. Inventore at voluptatem pariatur commodi ipsum vitae et facere iste.', 8, 23725245, 'Intel Core i5 7200M', 'NVIDIA GTX 1000 TI 6GB DDR4', 'Ram 2GB DDR3 2666MHz (1 slots)', 'HDD SATA3 1TB'),
('B0009Z24FZ', 'Playplottimry', 'Et est laborum dicta molestiae, nam non nam quo molestiae; perspiciatis in accusamus, natus recusandae blanditiis sit perspiciatis doloribus sit.', 7, 19043374, 'Intel Core i7 7400H', 'NVIDIA MX 1040 MAX-Q 6GB DDR4', 'Ram 2GB DDR3 2666MHz (1 slots)', 'HDD SATA4 128GB'),
('B0040N2V57', 'Rewoofer', 'Omnis quaerat consectetur saepe animi aspernatur porro magnam illo eligendi. Quis obcaecati rem neque modi quia qui et temporibus fuga.', 5, 11369584, 'Intel Core i7 6300U', 'NVIDIA GT 1060  4GB DDR5', 'Ram 8GB DDR3 1666MHz (1 slots)', 'HDD SATA4 256GB'),
('B006Q1KQ6B', 'Comcordphone', 'Et debitis et numquam ad ut aperiam facilis atque doloremque. Aut aliquid ratione eius, fuga quae quod perspiciatis omnis laudantium.', 1, 28164886, 'Intel Core i9 7600H', 'NVIDIA GT 1040  2GB DDR4', 'Ram 2GB DDR4 2666MHz (2 slots)', 'SSD SATA4 1TB'),
('B00Q0G57TF', 'Moncorder', 'Beatae dolor architecto quam commodi itaque nihil est neque sed. Inventore error dignissimos error natus fugiat ut et doloremque laborum.', 8, 23742758, 'Intel Core i6 5600H', 'NVIDIA MX 1050 MAX-Q 6GB DDR5', 'Ram 4GB DDR4 2666MHz (1 slots)', 'SSD SATA4 128GB'),
('B00R375CN4', 'Conculra', 'Sint provident magnam cumque beatae amet vitae odio beatae quia. Sit repellat quis, aliquid omnis quae at suscipit hic voluptates!', 1, 20023010, 'Intel Core i5 7600H', 'NVIDIA GT 1050 TI 2GB DDR5', 'Ram 4GB DDR4 2133MHz (1 slots)', 'HDD SATA3 1TB'),
('B0074OZ522', 'Prowoofimator', 'Est perspiciatis veritatis error voluptas dolores ad ipsam sed soluta. Ut vitae, aut et modi rerum perspiciatis delectus iste nostrum.', 3, 11068668, 'Intel Core i4 5300H', 'NVIDIA MX 1050  2GB DDR4', 'Ram 8GB DDR4 1666MHz (1 slots)', 'SSD SATA4 128GB'),
('B00ZK1WUE0', 'Cleancessepridge', 'Assumenda vel adipisci minus, necessitatibus deleniti et quis nihil hic; exercitationem voluptatem doloribus esse earum repellendus ipsa consequuntur earum?', 2, 25682496, 'Intel Core i4 6200HQ', 'NVIDIA GTX 1060  2GB DDR5', 'Ram 2GB DDR4 2666MHz (1 slots)', 'SSD SATA3 1TB'),
('B00C80O57D', 'Anjectadlet', 'Pariatur totam et voluptatibus dolor eos omnis, doloribus placeat est. Aperiam ut ullam et sit enim est quasi et nisi!', 1, 9032157, 'Intel Core i7 5600HQ', 'NVIDIA GTX 1060  6GB DDR4', 'Ram 4GB DDR4 2666MHz (1 slots)', 'SSD SATA4 1TB'),
('B003HP9184', 'Tabpickra', 'Qui numquam et, dignissimos beatae reiciendis omnis impedit error quod. Aperiam ut laudantium provident consequuntur numquam molestiae aperiam et sed?', 4, 6598421, 'Intel Core i5 6500HQ', 'NVIDIA GT 1000 MAX-Q 2GB DDR4', 'Ram 16GB DDR3 2400MHz (1 slots)', 'HDD SATA4 256GB'),
('B009ZYIY22', 'Chartiner', 'Omnis dicta debitis incidunt molestiae vel esse nihil earum molestiae. Voluptatem in id aut eos aliquid recusandae rerum esse itaque;', 7, 21433187, 'Intel Core i8 6400M', 'NVIDIA GT 1040  4GB DDR4', 'Ram 16GB DDR3 2400MHz (2 slots)', 'HDD SATA4 512GB'),
('B001KAL07G', 'Subjectra', 'Quis odio voluptatem, aliquam sint iste exercitationem necessitatibus eligendi repudiandae; ipsa sit debitis placeat nihil nemo vitae itaque eos facere.', 8, 20088590, 'Intel Core i6 6200HQ', 'NVIDIA GTX 1060  4GB DDR4', 'Ram 4GB DDR3 2666MHz (2 slots)', 'SSD SATA3 512GB'),
('B00A114L31', 'Antellgaer', 'Quos suscipit quia ipsa quia sit sunt, et nesciunt magni. Cumque sed sunt dolor et numquam qui numquam, laborum sit!', 1, 29771053, 'Intel Core i6 6300H', 'NVIDIA GTX 1060 MAX-Q 6GB DDR4', 'Ram 2GB DDR3 2400MHz (1 slots)', 'SSD SATA3 512GB'),
('B0018F2WRI', 'Tweetcessridge', 'Vitae non qui, quisquam natus incidunt error ipsam illum eligendi. Omnis harum quod earum perspiciatis amet sed sint totam beatae.', 2, 22337066, 'Intel Core i7 5600U', 'NVIDIA GT 1060 TI 2GB DDR5', 'Ram 4GB DDR4 2666MHz (1 slots)', 'SSD SATA3 256GB'),
('B00WMA7T43', 'Readfindonor', 'Voluptas est, voluptatem ut praesentium dolores perspiciatis temporibus id ipsa. Dolorem est incidunt quia minus modi voluptatem et dolorum consectetur.', 3, 8259561, 'Intel Core i6 5200H', 'NVIDIA MX 1040  6GB DDR4', 'Ram 16GB DDR4 2133MHz (1 slots)', 'HDD SATA4 256GB'),
('B0084E3455', 'Anputon', 'Expedita quis qui molestiae doloribus doloremque veritatis blanditiis est ullam. Eos distinctio odio excepturi aut voluptatem quaerat repudiandae dicta itaque!', 5, 24845491, 'Intel Core i8 5600H', 'NVIDIA MX 1060 TI 2GB DDR4', 'Ram 4GB DDR4 2666MHz (1 slots)', 'HDD SATA3 512GB'),
('B00QOQ1400', 'Reputicer', 'Architecto et ab doloremque, aliquam quia sed facilis laborum est. Non fugit tempora sit error ducimus voluptatem et laborum qui!', 4, 25548260, 'Intel Core i5 5600H', 'NVIDIA MX 1040 TI 6GB DDR4', 'Ram 4GB DDR4 2133MHz (2 slots)', 'HDD SATA4 512GB'),
('B00928E7LH', 'Printmutphone', 'Unde quo ullam et laboriosam ea natus dolorem sit hic. Sit voluptas consequatur, sed qui suscipit ut dolorum ut sit.', 3, 9642231, 'Intel Core i5 6400H', 'NVIDIA GT 1050 MAX-Q 2GB DDR5', 'Ram 2GB DDR4 2400MHz (2 slots)', 'SSD SATA4 256GB'),
('B007B7XYO8', 'Supbandfiator', 'Consequatur iusto odio tenetur accusamus omnis iste dolores voluptas voluptatem. Aliquid error quia quod sint iste ratione molestias quo dignissimos.', 3, 17712839, 'Intel Core i7 7300U', 'NVIDIA MX 1060 TI 4GB DDR4', 'Ram 8GB DDR3 1666MHz (1 slots)', 'HDD SATA3 256GB');

--
-- Inserting data into table ordersdetail
--
INSERT INTO ordersdetail(orderId, productId, pricePerUnit, quantity) VALUES
(7, 'B00ZK1WUE0', 21972197, 2),
(9, 'B00ZK1WUE0', 17185807, 2),
(18, 'B00QOQ1400', 20325079, 7),
(4, 'B0040N2V57', 25491587, 4),
(8, 'B00ZK1WUE0', 6930615, 9),
(10, 'B009ZYIY22', 19105567, 9),
(5, 'B00R375CN4', 18109444, 7),
(8, 'B00C80O57D', 26330977, 2),
(6, 'B0074OZ522', 17515953, 2),
(3, 'B0040N2V57', 10976107, 8),
(13, 'B001KAL07G', 14906273, 9),
(19, 'B00928E7LH', 9953051, 1),
(2, 'B0040N2V57', 12313916, 5),
(14, 'B00A114L31', 7632314, 8),
(20, 'B007B7XYO8', 23384275, 4),
(9, 'B003HP9184', 19164861, 10),
(15, 'B0018F2WRI', 7873292, 1),
(17, 'B00QOQ1400', 5247062, 4),
(3, 'B006Q1KQ6B', 26115453, 4),
(1, 'B00U9IFHF6', 13863661, 9),
(9, 'B00C80O57D', 12140101, 7),
(18, 'B00928E7LH', 21422572, 10),
(10, 'B00C80O57D', 24476379, 8),
(16, 'B00WMA7T43', 10612720, 3),
(5, 'B006Q1KQ6B', 6800593, 10),
(11, 'B003HP9184', 24285581, 3),
(4, 'B006Q1KQ6B', 27470571, 10),
(10, 'B003HP9184', 21705683, 7),
(5, 'B00Q0G57TF', 22635042, 1),
(2, 'B0009Z24FZ', 17061468, 5),
(4, 'B00Q0G57TF', 16757288, 9),
(6, 'B00Q0G57TF', 19591788, 3),
(11, 'B009ZYIY22', 23018582, 1),
(19, 'B007B7XYO8', 6014244, 9),
(6, 'B00R375CN4', 27543558, 1),
(12, 'B001KAL07G', 29116561, 5),
(17, 'B0084E3455', 11778768, 5),
(12, 'B009ZYIY22', 17559805, 5),
(1, 'B004DGBO5O', 20475104, 8),
(14, 'B0018F2WRI', 15055586, 10),
(20, 'B004DGBO5O', 24744841, 8),
(7, 'B0074OZ522', 17089866, 6),
(13, 'B00A114L31', 12408389, 6),
(7, 'B00R375CN4', 8210050, 4),
(15, 'B00WMA7T43', 7993517, 3),
(1, 'B0009Z24FZ', 22612086, 10),
(16, 'B0084E3455', 10348494, 3),
(2, 'B00U9IFHF6', 17061044, 2),
(8, 'B0074OZ522', 6456203, 5),
(3, 'B0009Z24FZ', 29873361, 9);

--
-- Inserting data into table storage
--
INSERT INTO storage(packageId, productId, importDate, quantity, importPrice) VALUES
(1, 'B0009Z24FZ', '2018-09-22', 5, 18728587),
(2, 'B00R375CN4', '2018-08-21', 34, 7226939),
(3, 'B004DGBO5O', '2018-06-02', 8, 7325602),
(4, 'B00ZK1WUE0', '2018-09-07', 26, 9904723),
(5, 'B0074OZ522', '2018-08-27', 28, 21147156),
(6, 'B001KAL07G', '2018-08-12', 24, 10077881),
(7, 'B00A114L31', '2018-07-26', 34, 24189773),
(8, 'B0018F2WRI', '2018-06-04', 19, 27969580),
(9, 'B00U9IFHF6', '2018-07-02', 5, 24109201),
(10, 'B003HP9184', '2018-09-28', 18, 29746594),
(11, 'B003HP9184', '2018-08-19', 23, 12466279),
(12, 'B001KAL07G', '2018-08-06', 24, 19907188),
(13, 'B00WMA7T43', '2018-07-01', 7, 10124207),
(14, 'B00928E7LH', '2018-07-21', 15, 24843857),
(15, 'B009ZYIY22', '2018-06-09', 3, 18637603),
(16, 'B0084E3455', '2018-10-14', 21, 13054007),
(17, 'B00ZK1WUE0', '2018-08-18', 14, 29552338),
(18, 'B00WMA7T43', '2018-09-04', 24, 19064757),
(19, 'B006Q1KQ6B', '2018-08-29', 22, 26695789),
(20, 'B0084E3455', '2018-07-08', 18, 23690084);