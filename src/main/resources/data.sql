-- textbooks テーブルにデータを挿入するクエリ
 	INSERT INTO textbooks (title, author, price, publisher)
 	VALUES
 	('大学生の国語', '田中太郎', '2000', 'ABC新書'),
 	('大学生の数学', '佐藤次郎', '1500', 'DEF書房'),
 	('大学生の英語', '伊藤三郎', '2300', '四省堂'),
 	('大学生の社会', '加藤四郎', '1900', '石波文庫'),
 	('大学生の理科', '中島五郎', '2200', '宗英社');
 	 
 	-- users テーブルにデータを挿入するクエリ
 	INSERT INTO users (student_number, password, user_status, introduce)
 	VALUES
 	('11620111', 'himitudesuyo', 2, 'はじめまして、三井悠太郎です。よろしくお願いします。'),
 	('84937592', 'himitudesuyo', 2, 'こんにちは、いいのがたくさんあります！'),
 	('00739387', 'himitudesuyo', 1, '');
 	 
 	-- itemss テーブルにデータを挿入するクエリ
 	INSERT INTO items (textbook_id, item_status, deal_status, seller_id, buyer_id)
 	VALUES
 	(1, 1, 1, 1, 1);
 	
 	-- claims テーブルにデータを挿入するクエリ
 	INSERT INTO claims (message, claim_status)
 	VALUES
 	('購入したものがまだ届きません', 2),
 	('決済方法をふやしてほしいです', 1);
 	
 	-- item_images テーブルにデータを挿入するクエリ
 	INSERT INTO item_images (item_id, image_path)
 	VALUES
 	(1, 0);
 	
 	-- reviews テーブルにデータを挿入するクエリ
 	INSERT INTO reviews (item_id, message)
 	VALUES
 	(1, '中古ですが気になるようなキズなどは特にありませんでした。良かったです');
 	
 	-- notices テーブルにデータを挿入するクエリ
 	INSERT INTO notices (user_id, message, notice_status)
 	VALUES
 	(2, '出品した商品へのレビューが来ました！', 1);		
 	
 	-- requests テーブルにデータを挿入するクエリ
 	INSERT INTO requests (items_id, user_id, item_status)
 	VALUES
 	(2, 1, 2);
 	
 	-- students テーブルにデータを挿入するクエリ
 	INSERT INTO students (name, student_number, birthday, address, number, faculty, department)
 	VALUES('三井悠太郎', '11620111', '2000-9-3', '神奈川県横浜市青葉区', '08012345678', '文学部', '史学科');
 	
