package com.group14.project.web.test.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.group14.project.web.beans.Authority;
import com.group14.project.web.beans.Gender;
import com.group14.project.web.beans.Order;
import com.group14.project.web.beans.OrderStatus;
import com.group14.project.web.beans.OrdersDetail;
import com.group14.project.web.beans.Product;
import com.group14.project.web.beans.Storage;
import com.group14.project.web.beans.Supplier;
import com.group14.project.web.beans.User;

public class DataTestGeneration {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private static List<User> userList;
	private static List<Product> productList;
	private static List<Order> orderList;
	private static List<OrdersDetail> ordersDetailList;
	private static List<Supplier> supplierList;
	private static List<Storage> storageList;

	public static void generateData(JdbcTemplate jdbcTemplate) {
		resetDataTest(jdbcTemplate);
		generateUserList();
		generateOrderList();
		generateOrdersDetailList();
		generateProductList();
		generateStorageList();
		generateSupplierList();
	}

	private static void resetDataTest(JdbcTemplate jdbcTemplate) {
		jdbcTemplate.execute("call resetData()");
	}

	private static void generateUserList() {
		try {
			userList = new ArrayList<>();
			userList.add(new User(1, "Abe3", "0wSqw59960l905$Z8W5CC0iwqWDE!d1TGsG3q!7qlNN!4I7oHu7Wm5jgZ5Ts", "Harmon",
					"AbeSSims856@example.com", dateFormat.parse("1948-01-02"), Gender.FEMALE,
					"3940 South Cedar Tree Ct", "823-7123", Authority.ROLE_USER));
			userList.add(new User(2, "Danna877", "B7P10gD7VQ6OnhCS!of!H!39QZr2SiM0LoG3uDoN1R3wIj9T6!94RiDX67TY",
					"Pereira", "Bolin641@example.com", dateFormat.parse("1993-03-10"), Gender.MALE,
					"3017 Pine Tree Parkway", "936-7671", Authority.ROLE_USER));
			userList.add(new User(3, "Lynwood893", "RZdFWl2MKCin!h26FZuG2OwwEmJJMiVEHEM74D$q1U78Hi1LBonSNVF4eurl",
					"Talbot", "Arroyo@nowhere.com", dateFormat.parse("1956-03-16"), Gender.FEMALE,
					"2478 New Oak Street", "097-0506", Authority.ROLE_USER));
			userList.add(new User(4, "Terry581", "$647w81THB00ga3!U7UCC0Pj35a011aHj!5e9iH2npt2ySbdKWtaf5mmdcAF",
					"Dougherty", "FrederickLandis@example.com", dateFormat.parse("1988-01-02"), Gender.OTHER,
					"2467 S Market Street", "949-5258", Authority.ROLE_USER));
			userList.add(new User(5, "Ackerman1983", "4cb58hP01CKa!od35!3ATMI19h1!v0nn31$j4Y5OCL5$l2721lNheAME17xz",
					"Zamora", "Oralia_Sousa6@example.com", dateFormat.parse("1964-06-17"), Gender.MALE,
					"2381 Front Blvd", "511-7814", Authority.ROLE_USER));
			userList.add(new User(6, "Augusta8", "J6X1$94cOH0C0G!bSe3kUB7hv$918632514UoG249tdp02isR2ss62fxi7Wq",
					"Knowles", "Bennett_J.Maldonado58@example.com", dateFormat.parse("1948-01-04"), Gender.MALE,
					"491 White Prospect Hill Parkway", "652-4022", Authority.ROLE_ADMIN));
			userList.add(new User(7, "Flagg2018", "7c$6c!m4L8y$$s2v677!7U!ghFDFPcT42PTHg78eip6fl1FxvK74!3DI59dy",
					"Collins", "AlesiaLilly47@nowhere.com", dateFormat.parse("1996-05-02"), Gender.OTHER,
					"499 Hazelwood Ct", "314-7268", Authority.ROLE_USER));
			userList.add(new User(8, "Boyle8", "9fC4J8n1T3BYJTcRw8kcyV77G177WPo0In33ZiShNEn!WeZT87P2q5!3BwrB", "Bolin",
					"lhonzjm1591@example.com", dateFormat.parse("2000-12-20"), Gender.OTHER, "1808 Market Hwy",
					"409-1121", Authority.ROLE_USER));
			userList.add(new User(9, "Armand1971", "kpmw$9SQrF7fF2v36L4qh5xku$0sG0HnneqRyY04g!$86cSD92!c7Fhj$dFP",
					"Goble", "AddisonS51@example.com", dateFormat.parse("1976-01-18"), Gender.MALE,
					"27 West Fox Hill Ct", "352-0271", Authority.ROLE_USER));
			userList.add(new User(10, "Sharice1966", "83$w79296$yk34WD5Lulw3JEtHh02!8M2qvW$!bGIXwAd7RiM27A95iwEZo8",
					"Colon", "WillardAiello@nowhere.com", dateFormat.parse("1966-12-25"), Gender.MALE,
					"1614 Mountain Court", "984-5666", Authority.ROLE_USER));
			userList.add(new User(11, "Abel379", "h!pHI1me0U7PNgziW5aS5h5$ka9I9s50GIW2q2VN!Y6oPWIy86vse9!fp8!k",
					"Harms", "qfaozsv350@example.com", dateFormat.parse("1951-09-05"), Gender.MALE, "46 Cedar Tree Hwy",
					"944-6714", Authority.ROLE_USER));
			userList.add(new User(12, "Ariel2021", "TJ1ehPSq3c1we60j2oGkgb39!hBy85BS17y9Wud4kAwvC00vS!72u!!yjDcR",
					"Mcmahan", "EarnestAndres453@example.com", dateFormat.parse("1997-07-23"), Gender.MALE,
					"217 South Pine Tree Ave", "628-2237", Authority.ROLE_USER));
			userList.add(new User(13, "Antonia48", "JRGgucr2c$Ybh!1NvX$M269gtv83dQcsK9P$!5h9Fdj5Z6bkRuIF47314bz9",
					"Talbott", "xglzwedk.kovibhvvd@example.com", dateFormat.parse("1980-10-12"), Gender.MALE,
					"774 Ironwood Avenue", "094-6481", Authority.ROLE_USER));
			userList.add(new User(14, "Mathilda94", "u7559IzM$pRpL3$Tm7DPQ0gpeynHvr14$HU5m5Xqd5Z3A5g!I0Rf55d0iAH7",
					"Doughty", "DollyMares67@example.com", dateFormat.parse("1949-08-11"), Gender.MALE, "2020 Town Ct",
					"205-2565", Authority.ROLE_USER));
			userList.add(new User(15, "Lachelle2005", "H6rAduWEcHM7CF8WEb07MFxe53LZl05dCOuB4!Htos!M94Y85Vyvs1krCO7S",
					"Knowlton", "TiffanyM.Cunningham62@example.com", dateFormat.parse("1963-05-17"), Gender.FEMALE,
					"3433 Fox Hill Ln", "180-2614", Authority.ROLE_USER));
			userList.add(new User(16, "Elaine2009", "!$5G0x3Ijy49yNvwJ1bhku2927s9y2$ggR3Q2Hy3Gn04wL4G95S1$J5q8M1Z",
					"Perez", "Vernon_Estrada24@nowhere.com", dateFormat.parse("1995-06-26"), Gender.OTHER,
					"865 New Hazelwood Road", "519-5709", Authority.ROLE_USER));
			userList.add(new User(17, "Dan1998", "$8yWXf7!QT0$ORd06ADha5RnBzjuI8dM4SI65cwo9E8zU$AyxaLM0$V!TeG9",
					"Zapata", "AdellAbreu@example.com", dateFormat.parse("1948-02-27"), Gender.FEMALE,
					"144 North Ashwood Cir", "005-4104", Authority.ROLE_USER));
			userList.add(new User(18, "Sell1", "8!$07NMympl977f!8H!8RN7M000bjU2ZLG0L26V6MDphp0gazagoer$4o2LF", "Talley",
					"Peek26@nowhere.com", dateFormat.parse("1981-02-22"), Gender.OTHER, "2150 SW Riverview Avenue",
					"826-9038", Authority.ROLE_USER));
			userList.add(new User(19, "Wanetta518", "f4p1zNo74j8qSi!48!oHcc8h9J5UzVI9xC159jXMIK9Za68$g2i8VSE46Mw1",
					"Harness", "Rubin432@example.com", dateFormat.parse("1988-02-18"), Gender.OTHER,
					"3179 Parkwood Pkwy", "034-5754", Authority.ROLE_ADMIN));
			userList.add(new User(20, "Adolfo286", "6RkLl22uiD$wx8lggw!2515z6!$$59Lcwe1abCfb4c8k1jI7!nrMuM7N!RFu",
					"Zaragoza", "LalaHough@nowhere.com", dateFormat.parse("1992-05-05"), Gender.FEMALE,
					"3656 Stonewood Parkway", "254-5662", Authority.ROLE_USER));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void generateProductList() {
		productList = new ArrayList<>();
		productList.add(new Product("B004DGBO5O", "Retellopor",
				"Excepturi perferendis veritatis voluptatem labore maxime odit distinctio sint voluptatem. Deserunt perferendis rerum, blanditiis iste amet natus ea eligendi;",
				7, 18639664, "Intel Core i7 6600HQ", "NVIDIA GT 1000 TI 4GB DDR5",
				"Ram 4GB DDR3 2400MHz productList.add(new Product(1 slots)", "SSD SATA3 256GB"));
		productList.add(new Product("B00U9IFHF6", "Tabcessollator",
				"Non vero minima dolorem aspernatur accusamus inventore voluptatem, quas tenetur. Inventore at voluptatem pariatur commodi ipsum vitae et facere iste.",
				8, 23725245, "Intel Core i5 7200M", "NVIDIA GTX 1000 TI 6GB DDR4",
				"Ram 2GB DDR3 2666MHz productList.add(new Product(1 slots)", "HDD SATA3 1TB"));
		productList.add(new Product("B0009Z24FZ", "Playplottimry",
				"Et est laborum dicta molestiae, nam non nam quo molestiae; perspiciatis in accusamus, natus recusandae blanditiis sit perspiciatis doloribus sit.",
				7, 19043374, "Intel Core i7 7400H", "NVIDIA MX 1040 MAX-Q 6GB DDR4",
				"Ram 2GB DDR3 2666MHz productList.add(new Product(1 slots)", "HDD SATA4 128GB"));
		productList.add(new Product("B0040N2V57", "Rewoofer",
				"Omnis quaerat consectetur saepe animi aspernatur porro magnam illo eligendi. Quis obcaecati rem neque modi quia qui et temporibus fuga.",
				5, 11369584, "Intel Core i7 6300U", "NVIDIA GT 1060  4GB DDR5",
				"Ram 8GB DDR3 1666MHz productList.add(new Product(1 slots)", "HDD SATA4 256GB"));
		productList.add(new Product("B006Q1KQ6B", "Comcordphone",
				"Et debitis et numquam ad ut aperiam facilis atque doloremque. Aut aliquid ratione eius, fuga quae quod perspiciatis omnis laudantium.",
				1, 28164886, "Intel Core i9 7600H", "NVIDIA GT 1040  2GB DDR4",
				"Ram 2GB DDR4 2666MHz productList.add(new Product(2 slots)", "SSD SATA4 1TB"));
		productList.add(new Product("B00Q0G57TF", "Moncorder",
				"Beatae dolor architecto quam commodi itaque nihil est neque sed. Inventore error dignissimos error natus fugiat ut et doloremque laborum.",
				8, 23742758, "Intel Core i6 5600H", "NVIDIA MX 1050 MAX-Q 6GB DDR5",
				"Ram 4GB DDR4 2666MHz productList.add(new Product(1 slots)", "SSD SATA4 128GB"));
		productList.add(new Product("B00R375CN4", "Conculra",
				"Sint provident magnam cumque beatae amet vitae odio beatae quia. Sit repellat quis, aliquid omnis quae at suscipit hic voluptates!",
				1, 20023010, "Intel Core i5 7600H", "NVIDIA GT 1050 TI 2GB DDR5",
				"Ram 4GB DDR4 2133MHz productList.add(new Product(1 slots)", "HDD SATA3 1TB"));
		productList.add(new Product("B0074OZ522", "Prowoofimator",
				"Est perspiciatis veritatis error voluptas dolores ad ipsam sed soluta. Ut vitae, aut et modi rerum perspiciatis delectus iste nostrum.",
				3, 11068668, "Intel Core i4 5300H", "NVIDIA MX 1050  2GB DDR4",
				"Ram 8GB DDR4 1666MHz productList.add(new Product(1 slots)", "SSD SATA4 128GB"));
		productList.add(new Product("B00ZK1WUE0", "Cleancessepridge",
				"Assumenda vel adipisci minus, necessitatibus deleniti et quis nihil hic; exercitationem voluptatem doloribus esse earum repellendus ipsa consequuntur earum?",
				2, 25682496, "Intel Core i4 6200HQ", "NVIDIA GTX 1060  2GB DDR5",
				"Ram 2GB DDR4 2666MHz productList.add(new Product(1 slots)", "SSD SATA3 1TB"));
		productList.add(new Product("B00C80O57D", "Anjectadlet",
				"Pariatur totam et voluptatibus dolor eos omnis, doloribus placeat est. Aperiam ut ullam et sit enim est quasi et nisi!",
				1, 9032157, "Intel Core i7 5600HQ", "NVIDIA GTX 1060  6GB DDR4",
				"Ram 4GB DDR4 2666MHz productList.add(new Product(1 slots)", "SSD SATA4 1TB"));
		productList.add(new Product("B003HP9184", "Tabpickra",
				"Qui numquam et, dignissimos beatae reiciendis omnis impedit error quod. Aperiam ut laudantium provident consequuntur numquam molestiae aperiam et sed?",
				4, 6598421, "Intel Core i5 6500HQ", "NVIDIA GT 1000 MAX-Q 2GB DDR4",
				"Ram 16GB DDR3 2400MHz productList.add(new Product(1 slots)", "HDD SATA4 256GB"));
		productList.add(new Product("B009ZYIY22", "Chartiner",
				"Omnis dicta debitis incidunt molestiae vel esse nihil earum molestiae. Voluptatem in id aut eos aliquid recusandae rerum esse itaque;",
				7, 21433187, "Intel Core i8 6400M", "NVIDIA GT 1040  4GB DDR4",
				"Ram 16GB DDR3 2400MHz productList.add(new Product(2 slots)", "HDD SATA4 512GB"));
		productList.add(new Product("B001KAL07G", "Subjectra",
				"Quis odio voluptatem, aliquam sint iste exercitationem necessitatibus eligendi repudiandae; ipsa sit debitis placeat nihil nemo vitae itaque eos facere.",
				8, 20088590, "Intel Core i6 6200HQ", "NVIDIA GTX 1060  4GB DDR4",
				"Ram 4GB DDR3 2666MHz productList.add(new Product(2 slots)", "SSD SATA3 512GB"));
		productList.add(new Product("B00A114L31", "Antellgaer",
				"Quos suscipit quia ipsa quia sit sunt, et nesciunt magni. Cumque sed sunt dolor et numquam qui numquam, laborum sit!",
				1, 29771053, "Intel Core i6 6300H", "NVIDIA GTX 1060 MAX-Q 6GB DDR4",
				"Ram 2GB DDR3 2400MHz productList.add(new Product(1 slots)", "SSD SATA3 512GB"));
		productList.add(new Product("B0018F2WRI", "Tweetcessridge",
				"Vitae non qui, quisquam natus incidunt error ipsam illum eligendi. Omnis harum quod earum perspiciatis amet sed sint totam beatae.",
				2, 22337066, "Intel Core i7 5600U", "NVIDIA GT 1060 TI 2GB DDR5",
				"Ram 4GB DDR4 2666MHz productList.add(new Product(1 slots)", "SSD SATA3 256GB"));
		productList.add(new Product("B00WMA7T43", "Readfindonor",
				"Voluptas est, voluptatem ut praesentium dolores perspiciatis temporibus id ipsa. Dolorem est incidunt quia minus modi voluptatem et dolorum consectetur.",
				3, 8259561, "Intel Core i6 5200H", "NVIDIA MX 1040  6GB DDR4",
				"Ram 16GB DDR4 2133MHz productList.add(new Product(1 slots)", "HDD SATA4 256GB"));
		productList.add(new Product("B0084E3455", "Anputon",
				"Expedita quis qui molestiae doloribus doloremque veritatis blanditiis est ullam. Eos distinctio odio excepturi aut voluptatem quaerat repudiandae dicta itaque!",
				5, 24845491, "Intel Core i8 5600H", "NVIDIA MX 1060 TI 2GB DDR4",
				"Ram 4GB DDR4 2666MHz productList.add(new Product(1 slots)", "HDD SATA3 512GB"));
		productList.add(new Product("B00QOQ1400", "Reputicer",
				"Architecto et ab doloremque, aliquam quia sed facilis laborum est. Non fugit tempora sit error ducimus voluptatem et laborum qui!",
				4, 25548260, "Intel Core i5 5600H", "NVIDIA MX 1040 TI 6GB DDR4",
				"Ram 4GB DDR4 2133MHz productList.add(new Product(2 slots)", "HDD SATA4 512GB"));
		productList.add(new Product("B00928E7LH", "Printmutphone",
				"Unde quo ullam et laboriosam ea natus dolorem sit hic. Sit voluptas consequatur, sed qui suscipit ut dolorum ut sit.",
				3, 9642231, "Intel Core i5 6400H", "NVIDIA GT 1050 MAX-Q 2GB DDR5",
				"Ram 2GB DDR4 2400MHz productList.add(new Product(2 slots)", "SSD SATA4 256GB"));
		productList.add(new Product("B007B7XYO8", "Supbandfiator",
				"Consequatur iusto odio tenetur accusamus omnis iste dolores voluptas voluptatem. Aliquid error quia quod sint iste ratione molestias quo dignissimos.",
				3, 17712839, "Intel Core i7 7300U", "NVIDIA MX 1060 TI 4GB DDR4",
				"Ram 8GB DDR3 1666MHz productList.add(new Product(1 slots)", "HDD SATA3 256GB"));
	}

	private static void generateOrderList() {
		try {
			orderList = new ArrayList<>();
			orderList.add(new Order(1, 19, "240 Hidden Front Way", 20669516, dateFormat.parse("2018-10-16"),
					dateFormat.parse("2018-06-04"), OrderStatus.SHIPPING));
			orderList.add(new Order(2, 14, "2948 Stonewood Pkwy", 12765144, dateFormat.parse("2018-07-06"),
					dateFormat.parse("2018-08-04"), OrderStatus.PREPARING));
			orderList.add(new Order(3, 6, "44 West Church Ct", 26183965, dateFormat.parse("2018-09-23"),
					dateFormat.parse("2018-06-08"), OrderStatus.FINISH));
			orderList.add(new Order(4, 12, "3778 Edgewood Highway", 15011253, dateFormat.parse("2018-06-07"),
					dateFormat.parse("2018-06-20"), OrderStatus.FINISH));
			orderList.add(new Order(5, 13, "12 1st Circle", 10638312, dateFormat.parse("2018-07-14"),
					dateFormat.parse("2018-06-13"), OrderStatus.FINISH));
			orderList.add(new Order(6, 19, "3570 Flintwood Parkway", 14468376, dateFormat.parse("2018-08-09"),
					dateFormat.parse("2018-08-02"), OrderStatus.FINISH));
			orderList.add(new Order(7, 1, "1790 SW Church Avenue", 16253911, dateFormat.parse("2018-09-29"),
					dateFormat.parse("2018-09-05"), OrderStatus.SHIPPING));
			orderList.add(new Order(8, 10, "2014 Social Road", 16593285, dateFormat.parse("2018-08-03"),
					dateFormat.parse("2018-06-12"), OrderStatus.CANCELED));
			orderList.add(new Order(9, 6, "34 Riddle Hill Pkwy", 29772230, dateFormat.parse("2018-06-21"),
					dateFormat.parse("2018-06-17"), OrderStatus.PREPARING));
			orderList.add(new Order(10, 16, "65 Waterview Avenue", 13259688, dateFormat.parse("2018-06-25"),
					dateFormat.parse("2018-08-16"), OrderStatus.FINISH));
			orderList.add(new Order(11, 13, "3760 West Social Parkway", 25730564, dateFormat.parse("2018-06-05"),
					dateFormat.parse("2018-09-12"), OrderStatus.PREPARING));
			orderList.add(new Order(12, 10, "1254 New Cedar Tree Rd", 23017219, dateFormat.parse("2018-08-01"),
					dateFormat.parse("2018-06-06"), OrderStatus.SHIPPING));
			orderList.add(new Order(13, 19, "2354 N Cedar Tree Hwy", 29597276, dateFormat.parse("2018-06-01"),
					dateFormat.parse("2018-06-05"), OrderStatus.SHIPPING));
			orderList.add(new Order(14, 4, "95 North Church Road", 10095912, dateFormat.parse("2018-06-05"),
					dateFormat.parse("2018-09-04"), OrderStatus.CANCELED));
			orderList.add(new Order(15, 4, "47 W Ashwood Avenue", 26492226, dateFormat.parse("2018-07-20"),
					dateFormat.parse("2018-06-03"), OrderStatus.FINISH));
			orderList.add(new Order(16, 5, "2455 Buttonwood Ln", 5525857, dateFormat.parse("2018-07-09"),
					dateFormat.parse("2018-09-15"), OrderStatus.FINISH));
			orderList.add(new Order(17, 10, "10 Social Lane", 18019869, dateFormat.parse("2018-06-21"),
					dateFormat.parse("2018-08-01"), OrderStatus.SHIPPING));
			orderList.add(new Order(18, 16, "633 New Parkwood St", 9548201, dateFormat.parse("2018-07-12"),
					dateFormat.parse("2018-06-14"), OrderStatus.FINISH));
			orderList.add(new Order(19, 6, "2762 Buttonwood Road", 17588674, dateFormat.parse("2018-06-09"),
					dateFormat.parse("2018-07-06"), OrderStatus.FINISH));
			orderList.add(new Order(20, 16, "1027 NW Ashwood Cir", 12075225, dateFormat.parse("2018-06-12"),
					dateFormat.parse("2018-06-24"), OrderStatus.FINISH));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void generateOrdersDetailList() {
		ordersDetailList = new ArrayList<>();
		ordersDetailList.add(new OrdersDetail(7, "B00ZK1WUE0", 21972197, 2));
		ordersDetailList.add(new OrdersDetail(9, "B00ZK1WUE0", 17185807, 2));
		ordersDetailList.add(new OrdersDetail(18, "B00QOQ1400", 20325079, 7));
		ordersDetailList.add(new OrdersDetail(4, "B0040N2V57", 25491587, 4));
		ordersDetailList.add(new OrdersDetail(8, "B00ZK1WUE0", 6930615, 9));
		ordersDetailList.add(new OrdersDetail(10, "B009ZYIY22", 19105567, 9));
		ordersDetailList.add(new OrdersDetail(5, "B00R375CN4", 18109444, 7));
		ordersDetailList.add(new OrdersDetail(8, "B00C80O57D", 26330977, 2));
		ordersDetailList.add(new OrdersDetail(6, "B0074OZ522", 17515953, 2));
		ordersDetailList.add(new OrdersDetail(3, "B0040N2V57", 10976107, 8));
		ordersDetailList.add(new OrdersDetail(13, "B001KAL07G", 14906273, 9));
		ordersDetailList.add(new OrdersDetail(19, "B00928E7LH", 9953051, 1));
		ordersDetailList.add(new OrdersDetail(2, "B0040N2V57", 12313916, 5));
		ordersDetailList.add(new OrdersDetail(14, "B00A114L31", 7632314, 8));
		ordersDetailList.add(new OrdersDetail(20, "B007B7XYO8", 23384275, 4));
		ordersDetailList.add(new OrdersDetail(9, "B003HP9184", 19164861, 10));
		ordersDetailList.add(new OrdersDetail(15, "B0018F2WRI", 7873292, 1));
		ordersDetailList.add(new OrdersDetail(17, "B00QOQ1400", 5247062, 4));
		ordersDetailList.add(new OrdersDetail(3, "B006Q1KQ6B", 26115453, 4));
		ordersDetailList.add(new OrdersDetail(1, "B00U9IFHF6", 13863661, 9));
		ordersDetailList.add(new OrdersDetail(9, "B00C80O57D", 12140101, 7));
		ordersDetailList.add(new OrdersDetail(18, "B00928E7LH", 21422572, 10));
		ordersDetailList.add(new OrdersDetail(10, "B00C80O57D", 24476379, 8));
		ordersDetailList.add(new OrdersDetail(16, "B00WMA7T43", 10612720, 3));
		ordersDetailList.add(new OrdersDetail(5, "B006Q1KQ6B", 6800593, 10));
		ordersDetailList.add(new OrdersDetail(11, "B003HP9184", 24285581, 3));
		ordersDetailList.add(new OrdersDetail(4, "B006Q1KQ6B", 27470571, 10));
		ordersDetailList.add(new OrdersDetail(10, "B003HP9184", 21705683, 7));
		ordersDetailList.add(new OrdersDetail(5, "B00Q0G57TF", 22635042, 1));
		ordersDetailList.add(new OrdersDetail(2, "B0009Z24FZ", 17061468, 5));
		ordersDetailList.add(new OrdersDetail(4, "B00Q0G57TF", 16757288, 9));
		ordersDetailList.add(new OrdersDetail(6, "B00Q0G57TF", 19591788, 3));
		ordersDetailList.add(new OrdersDetail(11, "B009ZYIY22", 23018582, 1));
		ordersDetailList.add(new OrdersDetail(19, "B007B7XYO8", 6014244, 9));
		ordersDetailList.add(new OrdersDetail(6, "B00R375CN4", 27543558, 1));
		ordersDetailList.add(new OrdersDetail(12, "B001KAL07G", 29116561, 5));
		ordersDetailList.add(new OrdersDetail(17, "B0084E3455", 11778768, 5));
		ordersDetailList.add(new OrdersDetail(12, "B009ZYIY22", 17559805, 5));
		ordersDetailList.add(new OrdersDetail(1, "B004DGBO5O", 20475104, 8));
		ordersDetailList.add(new OrdersDetail(14, "B0018F2WRI", 15055586, 10));
		ordersDetailList.add(new OrdersDetail(20, "B004DGBO5O", 24744841, 8));
		ordersDetailList.add(new OrdersDetail(7, "B0074OZ522", 17089866, 6));
		ordersDetailList.add(new OrdersDetail(13, "B00A114L31", 12408389, 6));
		ordersDetailList.add(new OrdersDetail(7, "B00R375CN4", 8210050, 4));
		ordersDetailList.add(new OrdersDetail(15, "B00WMA7T43", 7993517, 3));
		ordersDetailList.add(new OrdersDetail(1, "B0009Z24FZ", 22612086, 10));
		ordersDetailList.add(new OrdersDetail(16, "B0084E3455", 10348494, 3));
		ordersDetailList.add(new OrdersDetail(2, "B00U9IFHF6", 17061044, 2));
		ordersDetailList.add(new OrdersDetail(8, "B0074OZ522", 6456203, 5));
		ordersDetailList.add(new OrdersDetail(3, "B0009Z24FZ", 29873361, 9));
	}
	
	private static void generateSupplierList() {
		supplierList = new ArrayList<>();
		supplierList.add(new Supplier(1, "National Space Resea", "Deleniti molestiae aut aliquid nobis. Molestias nesciunt velit qui sunt? Exercitationem rerum non omnis perspiciatis. Consequuntur quam nemo maxime sint."));
		supplierList.add(new Supplier(2, "Smart Thermal Resour", "Error consequatur fuga minima deleniti. Earum repellendus alias quidem recusandae; velit harum non natus quia. Possimus at dolores est harum."));
		supplierList.add(new Supplier(3, "Pacific High-Technol", "Sunt vitae qui quia sit. Doloremque ut qui numquam qui! Maiores voluptatem inventore nulla quas. Eos eaque fugit aut consectetur?"));
		supplierList.add(new Supplier(4, "Federal Management I", "Dolorem tenetur ut quos maxime; quaerat enim natus pariatur quia? Omnis quo modi nemo at. Laudantium numquam tempore velit tenetur."));
		supplierList.add(new Supplier(5, "City M-Mobile Inc.", "Error est exercitationem at minus. Quia quo est a minima. Sint itaque nam quia delectus. Consequatur rerum consequatur qui animi."));
		supplierList.add(new Supplier(6, "South Laboratories C", "Nulla saepe rem sit velit. Nostrum iste qui officiis blanditiis. Maxime nostrum distinctio voluptatem accusamus. Vel repudiandae qui itaque eaque."));
		supplierList.add(new Supplier(7, "Home High-Technologi", "Sapiente sit a voluptatum nihil. Qui ut accusamus nihil dolores. Iure voluptates quia odit iste. Eligendi repudiandae natus reprehenderit odit?"));
		supplierList.add(new Supplier(8, "First High-Technolog", "Enim id dicta dolorum porro; nostrum omnis sit in consequatur. Est ut nam magnam modi! Quos dignissimos saepe dolores molestias."));
		supplierList.add(new Supplier(9, "South A-Mobile Inc.", "Harum molestias sint veritatis fugiat. Aliquid ab animi ut explicabo. Dolor unde a aut hic! Soluta dolorem sequi quia sed?"));
		supplierList.add(new Supplier(10, "South 3G Wireless In", "Architecto totam quis aut harum. Unde modi suscipit ipsa id. Est molestiae possimus doloremque dolor. Mollitia eaque autem sapiente nulla."));
	}
	
	private static void generateStorageList() {
		storageList = new ArrayList<>();
		try {
			storageList.add(new Storage(1, "B0009Z24FZ", dateFormat.parse("2018-09-22"), 5, 18728587));
			storageList.add(new Storage(2, "B00R375CN4", dateFormat.parse("2018-08-21"), 34, 7226939));
			storageList.add(new Storage(3, "B004DGBO5O", dateFormat.parse("2018-06-02"), 8, 7325602));
			storageList.add(new Storage(4, "B00ZK1WUE0", dateFormat.parse("2018-09-07"), 26, 9904723));
			storageList.add(new Storage(5, "B0074OZ522", dateFormat.parse("2018-08-27"), 28, 21147156));
			storageList.add(new Storage(6, "B001KAL07G", dateFormat.parse("2018-08-12"), 24, 10077881));
			storageList.add(new Storage(7, "B00A114L31", dateFormat.parse("2018-07-26"), 34, 24189773));
			storageList.add(new Storage(8, "B0018F2WRI", dateFormat.parse("2018-06-04"), 19, 27969580));
			storageList.add(new Storage(9, "B00U9IFHF6", dateFormat.parse("2018-07-02"), 5, 24109201));
			storageList.add(new Storage(10, "B003HP9184", dateFormat.parse("2018-09-28"), 18, 29746594));
			storageList.add(new Storage(11, "B003HP9184", dateFormat.parse("2018-08-19"), 23, 12466279));
			storageList.add(new Storage(12, "B001KAL07G", dateFormat.parse("2018-08-06"), 24, 19907188));
			storageList.add(new Storage(13, "B00WMA7T43", dateFormat.parse("2018-07-01"), 7, 10124207));
			storageList.add(new Storage(14, "B00928E7LH", dateFormat.parse("2018-07-21"), 15, 24843857));
			storageList.add(new Storage(15, "B009ZYIY22", dateFormat.parse("2018-06-09"), 3, 18637603));
			storageList.add(new Storage(16, "B0084E3455", dateFormat.parse("2018-10-14"), 21, 13054007));
			storageList.add(new Storage(17, "B00ZK1WUE0", dateFormat.parse("2018-08-18"), 14, 29552338));
			storageList.add(new Storage(18, "B00WMA7T43", dateFormat.parse("2018-09-04"), 24, 19064757));
			storageList.add(new Storage(19, "B006Q1KQ6B", dateFormat.parse("2018-08-29"), 22, 26695789));
			storageList.add(new Storage(20, "B0084E3455", dateFormat.parse("2018-07-08"), 18, 23690084));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
