-- textbooks テーブルにデータを挿入するクエリ
 	INSERT INTO textbooks (title, author, price, publisher)
 	VALUES
 	('大学生の国語', '田中太郎', 2000, 'あかね新書'),
 	('大学生の数学', '佐藤次郎', 1500, '相談社'),
 	('大学生の英語', '伊藤三郎', 2300, '四省堂'),
 	('大学生の社会', '加藤四郎', 1900, '石波文庫'),
 	('大学生の理科', '中島五郎', 2200, '宗英社');
 	 
 	-- users テーブルにデータを挿入するクエリ
 	INSERT INTO users (student_number, password, user_status, introduce)
 	VALUES
 	(11620111, 'himitudesuyo', 2, 'はじめまして、よろしくお願いします。'),
 	(84937592, 'himitudesuyo', 2, 'こんにちは、いいのがたくさんあります！'),
 	(20948499, 'himitudesuyo', 2, '文系教科はお任せください！'),
 	(21838119, 'himitudesuyo', 2, '数学、理科の教科書が多いです。'),
 	(82383211, 'himitudesuyo', 2, ''),
 	(99198373, 'himitudesuyo', 1, ''),
 	(99739387, 'himitudesuyo', 1, '');
 	 
 	-- items テーブルにデータを挿入するクエリ
 	INSERT INTO items (textbook_id, item_status, deal_status, seller_id, buyer_id)
 	VALUES
 	(1, 1, 2, 1, 2),
 	(4, 3, 4, 3, 4),
 	(5, 2, 3, 4, 5),
 	(2, 1, 5, 5, 1),
 	(3, 4, 1, 2, 3);
 	
 	-- claims テーブルにデータを挿入するクエリ
 	INSERT INTO claims (message, claim_status)
 	VALUES
 	('購入したものがまだ届きません', 2),
 	('決済方法をふやしてほしいです', 1);
 	
 	-- item_images テーブルにデータを挿入するクエリ
 	INSERT INTO item_images (item_id, image_path)
 	VALUES
 	(1, 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgwYVB5YDxhUxTNGjsEvlr_e8CorNpwRspvFORMwx90XWPnZzGWpeJC5JyaA-yjqFsV-9S8IATG3L2H9zoLagmsbgflLMBIxzM3zlbDWHtvAT0rXtIX9gNMHrU-iyrzgZRccc0yukxnRjk/s1600/textbook_kokugo.png'),
 	(2, 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEif30sHqsDfKQ1RiP68KBT4wX4ToyAgEjFvT4ZxXc_LnGXBhSNEY9pCExcnnH2V7cn-HT8b0ymBb-Swe6dFDGXQbCes1rmXDGHTqZpJuPs0D2i7LJPWsIW2G8kU_fvz4lxvut7QqgOPFLs/s1600/textbook_syakai.png'),
 	(3, 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiDBRbLotVrskPxXlqe4UlsJ6sw8f2Icd-1DwOt8x9FRNX7ZiUYrTH2Aj65umcIqX44qE42kJfZs_TxOdctfun9ttL61SWAoKhcPHLj-HiYajHCyEXkNfk5D_izepqiA7Qg8A2gDTbJMEI/s1600/textbook_rika.png'),
 	(4, 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEizjxeB8jBITuKJ7kUPwJtjj4cryqPbzmkAkZhRvSTLX2DjqHiJEDbvQGkrOnoT-KmyaiCFDCnw0iTepI3tpVFlIBi4b2IwxqnlLbkdTwoVYPN39xrnnoypAvtosHbqI3umB9a11hmNGks/s1600/textbook_sugaku.png'),
 	(5, 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh8GyoY2jToEdKFC9oo7viuWetbC-NA2VfGxHBraVuqyGPPlAmLh54hhOikSJZQQ-PvaRZOndDysmDfE_Xi3OjX0u-9hZ6PE42j8gENjd3P_8HDRqHJIVKGB19PYg4SmB_yMgG4CgZJsV8/s1600/textbook_eigo.png');
 	
 	-- reviews テーブルにデータを挿入するクエリ
 	INSERT INTO reviews (item_id, message)
 	VALUES
 	(1, '新品同様でキズなどは特になく良かったです'),
 	(2, '書き込みはありましたがあまり多くなくてよかったです'),
 	(3, '中古でしたが思ったよりキズがなくいい買い物をしました'),
 	(4, '新品の割には使い古された感があったので気になりましたが、使えそうなので大丈夫です'),
 	(5, '破損していましたが表紙だけだったので使えそうです');
 	
 	-- notices テーブルにデータを挿入するクエリ
 	INSERT INTO notices (user_id, message, notice_status)
 	VALUES
 	(1, '出品した商品へのレビューが来ました！', 1),
 	(2, '募集していた商品が出品されました！' , 2),
 	(3, '出品した商品へのレビューが来ました！', 2),
 	(4, '出品した商品へのレビューが来ました！', 1),
 	(5, '募集していた商品が出品されました！', 2),
 	(5, '出品した商品へのレビューが来ました！', 1),
 	(2, '出品した商品へのレビューが来ました！', 2),
 	(1, '募集していた商品が出品されました！', 1);
 	
 	-- requests テーブルにデータを挿入するクエリ
 	INSERT INTO requests (textbook_id, user_id, item_status)
 	VALUES
 	(2, 2, 2),
 	(4, 5, 1),
 	(5, 1, 5);
 	
 	-- students テーブルにデータを挿入するクエリ
 	INSERT INTO students (name, student_number, birthday, address, number, faculty, department)
 	VALUES
 	('三井悠太郎', 11620111, '2000-9-3', '神奈川県横浜市', '08012345678', '文学部', '史学科'),
 	('渡邊徹也', 84937592, '2001-10-29', '東京都練馬区', '08089348403', '経済学部', '経済学科'),
 	('須谷裕斗', 20948499, '2002-1-22', '埼玉県大宮市', '08011920241', '教育学部', '教育学科'),
 	('江嵜遊太', 21838119, '2001-7-12', '東京都八王子市', '08064730112', '理工学部', '理工学科'),
 	('石川星河', 82383211, '2002-3-9', '千葉県柏市', '08019282018', '工学部', '機械工学科'),
 	('田村昂暉', 99198373, '2001-12-23', '神奈川県横浜市', '07055292014', '', ''),
 	('鈴木一郎', 99739387, '1985-8-17', '岩手県盛岡市', '09092812081', '', '');
 	
