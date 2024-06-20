-- 各種テーブル削除
 	DROP TABLE IF EXISTS textbooks;
 	DROP TABLE IF EXISTS users;
 	DROP TABLE IF EXISTS items;
 	DROP TABLE IF EXISTS claims;
 	DROP TABLE IF EXISTS item_images;
 	DROP TABLE IF EXISTS image_data;
 	DROP TABLE IF EXISTS reviews;
 	DROP TABLE IF EXISTS notices;
 	DROP TABLE IF EXISTS requests;
 	DROP TABLE IF EXISTS students;
 	DROP TABLE IF EXISTS teachers;
 	DROP TABLE IF EXISTS lessons;
 	DROP TABLE IF EXISTS lesson_textbooks;
 	DROP TABLE IF EXISTS timetables;
 	DROP TABLE IF EXISTS histories;
 	 
 	-- textbooks テーブルを作成するクエリ
 	CREATE TABLE textbooks (
 	id SERIAL PRIMARY KEY,
 	title TEXT,
 	author TEXT,
 	price INTEGER,
 	publisher TEXT
 	);
 	 
 	-- users テーブルを作成するクエリ
 	CREATE TABLE users (
 	id SERIAL PRIMARY KEY,
 	personal_number TEXT,
 	password TEXT,
 	user_status INTEGER,
 	introduce TEXT
 	);
 	 
 	-- items テーブルを作成するクエリ
 	CREATE TABLE items (
 	id SERIAL PRIMARY KEY,
 	textbook_id INTEGER,
 	item_status INTEGER,
 	deal_status INTEGER,
 	seller_id INTEGER,
 	buyer_id INTEGER
 	);
 	
 	-- claims テーブルを作成するクエリ
 	CREATE TABLE claims (
 	id SERIAL PRIMARY KEY,
 	message TEXT,
 	claim_status INTEGER
 	);
 	
 	-- item_images テーブルを作成するクエリ
 	CREATE TABLE item_images (
 	id SERIAL PRIMARY KEY,
 	item_id INTEGER,
 	image_path TEXT,
 	style INTEGER
 	);
 	
 	-- image_data テーブルを作成するクエリ
 	CREATE TABLE image_data (
 	id SERIAL PRIMARY KEY,
 	item_image_id INTEGER,
 	image BYTEA
 	);
 	
 	-- reviews テーブルを作成するクエリ
 	CREATE TABLE reviews (
 	id SERIAL PRIMARY KEY,
 	item_id INTEGER,
 	message TEXT
 	);
 	
 	-- notices テーブルを作成するクエリ
 	CREATE TABLE notices (
 	id SERIAL PRIMARY KEY,
 	user_id INTEGER,
 	message TEXT,
 	notice_status INTEGER
 	);
 	
 	-- requests テーブルを作成するクエリ
 	CREATE TABLE requests (
 	id SERIAL PRIMARY KEY,
 	textbook_id INTEGER,
 	user_id INTEGER,
 	item_status INTEGER
 	);
 	
 	-- students テーブルを作成するクエリ
 	CREATE TABLE students (
 	id SERIAL PRIMARY KEY,
 	name TEXT,
 	personal_number TEXT,
 	birthday DATE,
 	address TEXT,
 	number TEXT,
 	faculty TEXT,
 	department TEXT
 	);
 	
 	-- teachers テーブルを作成するクエリ
 	CREATE TABLE teachers (
 	id SERIAL PRIMARY KEY,
 	name TEXT,
 	personal_number TEXT,
 	birthday DATE,
 	address TEXT,
 	number TEXT,
 	faculty TEXT,
 	department TEXT
 	);
 	
 	-- lessons テーブルを作成するクエリ
 	CREATE TABLE lessons (
 	id SERIAL PRIMARY KEY,
 	name TEXT,
 	day INTEGER,
 	period INTEGER,
 	teacher_id INTEGER
 	);
 	
 	-- lesson_textbooks テーブルを作成するクエリ
 	CREATE TABLE lesson_textbooks (
 	id SERIAL PRIMARY KEY,
 	lesson_id INTEGER,
 	textbook_id INTEGER
 	);
 	
 	--timetables テーブルを作成するクエリ
 	CREATE TABLE timetables (
 	id SERIAL PRIMARY KEY,
 	lesson_id INTEGER,
 	user_id INTEGER
 	);
 	
 	--histories テーブルを作成するクエリ
 	CREATE TABLE histories (
 	id SERIAL PRIMARY KEY,
 	textbook_id INTEGER,
 	user_id INTEGER,
 	status INTEGER
 	);
 	

