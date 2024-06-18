-- textbooks テーブルにデータを挿入するクエリ
 	INSERT INTO textbooks (title, author, price, publisher)
 	VALUES
 	('大学生の国語', '田中太郎', 2000, 'あかね新書'),--1
 	('大学生の数学', '佐藤次郎', 1500, '相談社'),--2
 	('大学生の英語', '伊藤三郎', 2300, '四省堂'),--3
 	('大学生の社会', '加藤四郎', 1900, '石波文庫'),--4
 	('大学生の理科', '中島五郎', 2200, '宗英社'),--5
 	--学科ごとの教科書データ
 	--文学部
 	('日本語統語特性論', '加藤重広', 6600, '北海道大学出版会'),--6
 	('国語教師のための語彙指導入門', '鈴木一史', 2090, '明治図書出版'),--7
 	('教室の英文学', '日本英文学会(関東支部)', 2860, '研究社'),--8
 	('ゴシックと身体──想像力と解放の英文学', '小川公代', 2640, '松柏社'),--9
 	('はじめて学ぶフランス文学史', '横山安由美/朝比奈美知子', 3080, 'ミネルヴァ書房'),--10
 	('フランス文学と愛', '野崎歓', 800, '講談社'),--11
 	--経済学部
 	('はじめまして、経済学 ー おカネの物差しをもった哲学', '宿輪純一', 1650, 'ウェッジ'),--12
 	('実験経済学: 研究と実践の手引き', 'N. Jacquemet', 9900, '朝倉書店'),--13
 	('国際経済学15講', '伊藤恵子/伊藤 匡/小森谷 徳純', 2530, '新世社'),--14
 	('国際経済学', '阿部 顕三/遠藤 正寛', 2640, '有斐閣'),--15
 	('財政学', '土居丈朗', 3080, '日本評論社'),--16
 	('基礎から学ぶ財政学1', '矢吹初', 550, '東京出版'),--17
 	('大労働経済学', '宮本弘曉', 2750, '新世社'),--18
 	('大労働経済学入門-新しい働き方の実現を目指して', '脇坂明', 2640, '日本評論社'),--19
 	--経営学部
 	('サクッとわかるビジネス教養 経営学', '池上重輔 ', 1540, '新星出版社'),--20
 	('今さらだけど、ちゃんと知っておきたい「経営学」', '佐藤耕紀', 1870, '同文舘出版'),--21
 	('世界はマーケティングでできている', '三宅宏', 1650, '総合法令出版'),--22
 	('大マーケティングを学んだけれど、どう使えばいいかわからない人へ', '西口一希 ', 1650, '日本実業出版社'),--23
 	('はじめて出会う会計学', '川本淳/野口昌良/浅見裕子/山田純平/荒田映子', 2210, '有斐閣'),--24
 	('新版 会計学入門〈第8版〉: 会計・監査の基礎を学ぶ', '千代田邦夫', 3300, '中央経済グループパブリッシング'),--25
 	('プレステップ金融学', '平田潤', 1980, '弘文堂'),--26
 	('世界一わかりやすい 図解 金融用語', '石原敬子', 1650, '秀和システム'),--27
 	('マネジメント・テキスト グローバル経営入門', '浅川和宏', 3300, '日本経済新聞出版'),--28
 	('グロ-バル企業のデザインマネジメント', '岩谷昌樹', 2750, '学文社'),--29
 	--法学部
 	('民事法学入門 -- 法学の基礎から民事実務までの道しるべ', '伊藤滋夫', 2530, '有斐閣'),--30
 	('事例演習民事訴訟法 第3版', '遠藤賢治', 2970, '有斐閣'),--31
 	('事例演習刑事訴訟法 第3版', '古江賴隆', 3960, '有斐閣'),--32
 	('3訂版 ヴィジュアル法学 事例で学ぶ刑事訴訟法', '刑事法令研究会', 2420, '東京法令出版'),--33
 	('国際法 第2版', '岩沢雄司', 4840, '東京大学出版会'),--34
 	('実践国際法(第3版)', '小松一郎', 5500, '信山社'),--35
 	('一晩でわかる 経営者の法律知識', '大山滋郎', 1220, '双葉社'),--36
 	('経営支配権をめぐる法律実務－解説・書式等とケーススタディ－', '二木康晴/平井貴之', 3850, '新日本法規出版'),--37
 	--理工学部
 	('基礎から学ぶ機械工学 キカイを学んでものづくり力を鍛える!', '門田和雄', 900, 'SBクリエイティブ'),--38
 	('改訂第3版 図解 もの創りのための やさしい機械工学', '門田和雄', 2600, '技術評論社'),--39
 	('化学工学: 解説と演習', '多田豊', 2750, '朝倉書店'),--40
 	('ベーシック化学工学 増補版', '橋本健治', 3300, '化学同人'),--41
 	('土木工事が一番わかる (しくみ図解)', '佐藤拓真', 2200, '技術評論社'),--42
 	('図解入門 よくわかる 最新防災土木の基礎知識', '五十畑弘', 1980, '秀和システム'),--43
 	('環境工学入門 (First Stageシリーズ)', '花木啓祐', 2500, '実教出版'),--44
 	('ゼロからはじめる［環境工学］入門', '原口秀昭', 2500, '彰国社'),--45
 	--外国語学部
 	('ファンダメンタル英語学 改訂版', '中島平三', 1540, 'ひつじ書房'),--46
 	('英語学を学ぼう: 英語学の知見を英語学習に活かす (開拓社言語・文化選書 69)', '高橋勝忠', 2090, '(株)開拓社'),--47
 	('マウスと仲間たち 楽しくかんたん ドイツ語', 'マライ・メントライン', 1320, 'Jリサーチ出版'),--48
 	('おしゃべりなドイツ語 Kindle版', '綿谷エリナ', 2480, '左右社'),--49
 	('はじめて学ぶフランスの歴史と文化', '上垣豊', 3520, 'ミネルヴァ書房'),--50
 	('フランス文化論', 'エルンスト ローベルト・クゥルツィウス/大野俊一', 300, 'みすず書房'),--51
 	('文法から学べるスペイン語 ', '井戸光子/石村あつ', 1980, 'ナツメ社'),--52
 	('ゼロからスタート スペイン語単語 BASIC1000', 'イスパニカ', 1320, 'Jリサーチ出版'),--53
 	
 	--追加の教科書データ
 	--文学部
 	('古典文学入門', '吉田精一', 2640, '新潮社'),--54
 	('和歌を歴史から読む (和歌文学会論集)', '兼築信行/田渕句美子', 5600, '笠間書院'),--55
 	('東西文学論・日本の現代文学 (講談社文芸文庫―現代日本のエッセイ) ', '吉田健一', 1000, '講談社'),--56
 	('Consent in Shakespeare: What Women Do and Do not Say and Do in Shakespeares Mediterranean Comedies and Origin Stories', 'Artemis Preeshl', 8500, 'Routledge'),--57
 	('The 1930s: A Decade of Modern British Fiction (Decades)', 'Nick Hubble/Luke Seaber/Elinor Taylor', 24000, 'Bloomsbury USA Academic'),--58
 	('The Poetics of the American Suburbs (Modern and Contemporary Poetry and Poetics)', 'J.Gil', 9260, 'Palgrave Macmillan'),--59
 	('フランス文学史', '饗庭孝男', 4180, '白水社'),--60
 	('恋するフランス文学', '小倉孝誠', 3520, '慶應義塾大学出版会'),--61
 	('象徴主義第一の武器', 'ジャン・モレアス', 1250, '京緑社'),--62
 	--経済学部
 	('マクロ経済学 新版 (New Liberal Arts Selection)', '齊藤誠/岩本康志/太田聰一/柴田章久', 4620, '有斐閣'),--63
 	('大学の人気講義でよく分かる「ミクロ経済学」超入門', '田中久稔', 1760, 'SBクリエイティブ'),--64
 	('内生的経済成長論 1 第2版', 'R.J.バロー(著)/X.サラ イ マーティン(著)/大住 圭介(翻訳)', 6160, '九州大学出版会'),--65
 	('国際貿易論 第2版', '粕谷慶治/山田晃久', 600, '学文社'),--66
 	('コア・テキスト国際金融論 (ライブラリ経済学コア・テキスト&最先端)', '藤井英次', 3190, '新世社'),--67
 	('国際経済学入門 (経済学叢書Introductory)', '古沢泰治', 2800, '新世社'),--68
 	('自治体の財政担当になったら読む本', '定野司', 2750, '学陽書房'),--69
 	('日本の財政学', '本間正明', 4840, '日本評論社'),--70
 	('地方財政システム論 (有斐閣ブックス 452)', '本諸富徹/門野圭司', 2420, '有斐閣'),--71
 	('労働市場分析: 二重構造の日本的展開', '尾高煌之助', 8800, '岩波書店'),--72
 	('労使関係法の理論と実務', '小嶌典明', 3850, 'ジアース教育新社'),--73
 	('現代日本の労働経済 分析・理論・政策', '石水喜夫', 4730, '岩波書店'),--74
 	--経営学部
 	('実戦のための経営戦略論', '三品和広', 9460, '東洋経済新報社'),--75
 	('【新版】グロービスMBAリーダーシップ', 'グロービス経営大学院', 3080, 'ダイヤモンド社'),--76
 	('イノベーション・マネジメント (放送大学教材) ', '伊藤宗彦', 3410, '放送大学教育振興会'),--77
 	('消費者行動の多国間分析-原産国イメージとブランド戦略', '朴正洙', 3520, '千倉書房'),--78
 	('戦略的ブランド・マネジメント 第3版', 'ケビン・レーン・ケラー (著)/恩藏直人 (監訳)', 8360, '東急エージェンシー'),--79
 	('日本一詳しいWeb集客術「デジタル・マーケティング超入門」', '森和吉', 1650, 'ぱる出版'),--80
 	('財務会計論', '梅原秀継', 3900, '白桃書房'),--81
 	('管理会計の基本 (この1冊ですべてわかる)', '千賀秀信', 1650, '日本実業出版社'),--82
 	('国際会計基準', '白鳥栄一', 500, '日経BP'),--83
 	('金融論 -- 市場と経済政策の有効性', '福田慎一', 500, '有斐閣'),--84
 	('長期投資の理論と実践: パーソナル・ファイナンスと資産運用', '安達智彦/池田昌幸', 7040, '東京大学出版会'),--85
 	('資本市場とリスク管理', '藤井健司', 3740, 'イノベーション・インテリジェンス研究所'),--86
 	('マネジメント・テキスト グローバル経営入門(新装版)', '浅川和宏 ', 3300, '日本経済新聞出版'),--87
 	('ワンルームマンション経営の教科書【入門編】', '東京1R（トウキョウワンルーム）', 1570, '東京出版'),--88
 	('グローバル・サプライチェーン・マネジメント入門 (単行本)', '横田一彦', 2860, '有斐閣'),--89
 	--法学部
 	('契約法〔新版〕', '中田裕康', 5280, '有斐閣'),--90
 	('民法〔財産法〕講義 第2版', '長坂純', 3880, '勁草書房'),--91
 	('家族法 (ライブラリ今日の法律学 8)', '常岡史子', 4380, '新世社'),--92
 	('刑法の諸問題', '瀧川幸辰', 2970, '東京出版'),--93
 	('刑事訴訟法 第5版', '上口裕', 4400, '成文堂'),--94
 	('サイエンス超簡潔講座 犯罪学', 'ティム・ニューバーン (著)/岡邊健 (監修)', 1900, 'ニュートンプレス'),--95
 	('国際人権法講義', '東澤靖 ', 3960, '信山社出版'),--96
 	('国際組織法', '佐藤哲夫', 3740, '有斐閣'),--97
 	('紛争解決と国連・国際法', '西川吉光', 3940, '晃洋書房'),--98
 	('商法I -- 総則・商行為 第6版 (有斐閣Sシリーズ)', '落合 誠一/大塚 龍児/山下 友信', 2260, '有斐閣'),--99
 	('株式会社法(第9版)', '江頭憲治郎', 6270, '有斐閣'),--100
 	('競争法ガイド', 'デビッド・ガーバー (著)/白石 忠志 (翻訳)', 3300, '東京大学出版会'),--101
 	--理工学部
 	('機械設計の知識がやさしくわかる本', '西村仁', 2420, '日本能率協会マネジメントセンター'),--102
 	('熱力学・統計力学 熱をめぐる諸相 (KS物理専門書)', '高橋和孝', 5500, '講談社'),--103
 	('自動制御理論(新装版)', '樋口龍雄', 2860, '森北出版'),--104
 	('図解入門 よくわかる 最新 電磁気学の基本と仕組み', '山﨑耕造', 1980, '秀和システム'),--105
 	('VHDLによるマイクロプロセッサ設計入門: パソコンによるシミュレーションから論理合成、配置配線まで', '仲野巧 ', 3520, 'CQ出版'),--106
 	('エネルギ-変換論入門', '小澤守', 3300, 'コロナ社'),--107
 	('化学プロセス工学 (化学の指針シリーズ)', '小野木克明/田川智彦/小林敬幸/二井晋', 2600, '裳華房'),--108
 	('機械・材料設計に生かす 実践分子動力学シミュレーション:汎用コードで設計を始めるための実践的知識', '泉聡志/増田裕寿', 3740, '森北出版'),--109
 	('現代の化学環境学: 環境の理解と改善のために', '御園生誠 ', 2500, '裳華房'),--110
 	('構造解析のための材料力学', '舘石和雄', 2420, 'コロナ社'),--111
 	('大学土木 道路工学', '稲垣竜興/中村俊行/小梁川雅', 3080, 'オーム社'),--112
 	('河川工学', '風間聡', 2970, '理工図書'),--113
 	--外国語学部
 	('英語音声学入門', '松坂ヒロシ', 2530, '研究社'),--114
 	('新学習指導要領にもとづく英語科教育法 第3版', '望月 昭彦/久保田章/磐崎弘貞/卯城祐司', 2530, '大修館書店'),--115
 	('イギリス・アメリカ文学史 作家のこころ', '福田昇八', 2970, '南雲堂'),--116
 	('必携ドイツ文法総まとめ', '中島悠爾', 1760, '白水社'),--117
 	('ドイツ文学史', '佐藤晃一', 2420, '明治書院'),--118
 	('ドイツ語おもしろ翻訳教室', '太田達也', 1000, 'NHK出版'),--119
 	('フランス語会話 話しかけ&返事のバリエーションを増やす', '吉田泉', 1980, 'ベレ出版'),--120
 	('フランス文化論(1948年)', 'エルンスト ローベルト クゥルツィウス/大野俊一 (翻訳)', 1000, '創元社'),--121
 	('増補 フランス文学案内', '渡辺一夫/鈴木力衛', 1100, '岩波書店'),--122
 	('詳説スペイン語文法', '福嶌教隆/フアン・ロメロ・ディアス', 3630, '白水社'),--123
 	('ラテンアメリカ文学を旅する58章 (エリア・スタディーズ)', '久野量一/松本健二', 2200, '明石書店'),--124
 	('スペイン語 長文翻訳 問題集: ビジネスシーンで使えるフレーズ', '渡辺慎一', 480, '東京出版'),--125
 	('ニューエクスプレスプラス スペイン語', '福嶌教隆', 2310, '白水社'),--126
 	('これからはじめる ドイツ語入門', '高橋亮介', 2200, 'NHK出版'),--127
 	('これからはじめる イタリア語入門 ', '花本知子', 2200, 'NHK出版'),--128
 	('話すための思考が身につく! 中国語文法講義', '林松涛', 2420, 'アスク');--129
 	 
 	-- users テーブルにデータを挿入するクエリ
 	INSERT INTO users (personal_number, password, user_status, introduce)
 	VALUES
 	('00000000', 'himitudesuyo', 1, 'ここに表示されている商品は未出品・未購入のものです'),
 	('11620111', 'himitudesuyo', 2, 'はじめまして、よろしくお願いします。'),
 	('84937592', 'himitudesuyo', 2, 'こんにちは、いいのがたくさんあります！'),
 	('20948499', 'himitudesuyo', 2, '数学、理科の教科書が多いです。'),
 	('21838119', 'himitudesuyo', 2, '文系教科はお任せください！'),
 	('82383211', 'himitudesuyo', 2, ''),
 	('99198373', 'himitudesuyo', 1, ''),
 	('99739387', 'himitudesuyo', 1, ''),
 	('99999999', 'himitudesuyo', 1, ''),
 	('12345678', 'guestaccount', 2, 'このアカウントはゲストアカウントです。'),
 	('99000001', 'himitudesuyo', 1, ''),
 	('99000002', 'himitudesuyo', 1, ''),
 	('99000003', 'himitudesuyo', 1, ''),
 	('99000004', 'himitudesuyo', 1, ''),
 	('99000005', 'himitudesuyo', 1, ''),
 	('99000006', 'himitudesuyo', 1, ''),
 	('99000007', 'himitudesuyo', 1, ''),
 	('99000008', 'himitudesuyo', 1, ''),
 	('99000009', 'himitudesuyo', 1, ''),
 	('99000010', 'himitudesuyo', 1, ''),
 	('99000011', 'himitudesuyo', 1, ''),
 	('99000012', 'himitudesuyo', 1, ''),
 	('99000013', 'himitudesuyo', 1, ''),
 	('99000014', 'himitudesuyo', 1, ''),
 	('99000015', 'himitudesuyo', 1, ''),
 	('99000016', 'himitudesuyo', 1, ''),
 	('99000017', 'himitudesuyo', 1, ''),
 	('99000018', 'himitudesuyo', 1, ''),
 	('99000019', 'himitudesuyo', 1, ''),
 	('99000020', 'himitudesuyo', 1, ''),
 	('99000021', 'himitudesuyo', 1, ''),
 	('99000022', 'himitudesuyo', 1, ''),
 	('99000023', 'himitudesuyo', 1, ''),
 	('99000024', 'himitudesuyo', 1, ''),
 	('99000025', 'himitudesuyo', 1, ''),
 	('99000026', 'himitudesuyo', 1, ''),
 	('99000027', 'himitudesuyo', 1, ''),
 	('99000028', 'himitudesuyo', 1, ''),
 	('99000029', 'himitudesuyo', 1, ''),
 	('99000030', 'himitudesuyo', 1, ''),
 	('99000031', 'himitudesuyo', 1, ''),
 	('99000032', 'himitudesuyo', 1, ''),
 	('99000033', 'himitudesuyo', 1, ''),
 	('99000034', 'himitudesuyo', 1, ''),
 	('99000035', 'himitudesuyo', 1, ''),
 	('99000036', 'himitudesuyo', 1, ''),
 	('99000037', 'himitudesuyo', 1, ''),
 	('99000038', 'himitudesuyo', 1, ''),
 	('99000039', 'himitudesuyo', 1, ''),
 	('99000040', 'himitudesuyo', 1, ''),
 	('99000041', 'himitudesuyo', 1, ''),
 	('99000042', 'himitudesuyo', 1, ''),
 	('99000043', 'himitudesuyo', 1, ''),
 	('99000044', 'himitudesuyo', 1, ''),
 	('99000045', 'himitudesuyo', 1, ''),
 	('99000046', 'himitudesuyo', 1, ''),
 	('99000047', 'himitudesuyo', 1, ''),
 	('99000048', 'himitudesuyo', 1, ''),
 	('99000049', 'himitudesuyo', 1, ''),
 	('99000050', 'himitudesuyo', 1, ''),
 	('99000051', 'himitudesuyo', 1, ''),
 	('99000052', 'himitudesuyo', 1, ''),
 	('99000053', 'himitudesuyo', 1, ''),
 	('99000054', 'himitudesuyo', 1, ''),
 	('99000055', 'himitudesuyo', 1, ''),
 	('99000056', 'himitudesuyo', 1, ''),
 	('99000057', 'himitudesuyo', 1, ''),
 	('99000058', 'himitudesuyo', 1, ''),
 	('99000059', 'himitudesuyo', 1, ''),
 	('99000060', 'himitudesuyo', 1, ''),
 	('99000061', 'himitudesuyo', 1, ''),
 	('99000062', 'himitudesuyo', 1, ''),
 	('99000063', 'himitudesuyo', 1, ''),
 	('99000064', 'himitudesuyo', 1, ''),
 	('99000065', 'himitudesuyo', 1, ''),
 	('99000066', 'himitudesuyo', 1, ''),
 	('99000067', 'himitudesuyo', 1, ''),
 	('99000068', 'himitudesuyo', 1, '');
 	
 	 
 	-- items テーブルにデータを挿入するクエリ
 	INSERT INTO items (textbook_id, item_status, deal_status, seller_id, buyer_id)
 	VALUES
 	(1, 1, 2, 2, 1),
 	(4, 3, 4, 4, 5),
 	(4, 3, 5, 5, 3),
 	(5, 2, 3, 5, 1),
 	(2, 1, 5, 6, 2),
 	(3, 4, 1, 3, 1),
 	(1, 2, 5, 4, 5),
 	(3, 1, 5, 2, 4),
 	(5, 4, 5, 3, 6),
 	(2, 3, 2, 6, 1),
 	(4, 1, 3, 2, 1),
 	(3, 2, 3, 3, 1),
 	(2, 1, 3, 4, 1);
 	
 	-- claims テーブルにデータを挿入するクエリ
 	INSERT INTO claims (message, claim_status)
 	VALUES
 	('購入した商品がまだ届きません', 2),
 	('決済方法をふやしてほしいです', 1),
 	('悪質一郎という学生がひどい対応でした！', 1),
 	('支払いがまだ行われていません', 1);
 	
 	-- item_images テーブルにデータを挿入するクエリ
 	INSERT INTO item_images (item_id, image_path)
 	VALUES
 	(1, 'textbook1_kokugo.png'),
 	(2, 'textbook5_syakai.png'),
 	(3, 'textbook5_syakai.png'),
 	(4, 'textbook4_rika.png'),
 	(4, 'textbook7_blank.png'),
 	(5, 'textbook3_sugakuu.png'),
 	(6, 'textbook6_eigo.png'),
 	(7, 'textbook1_kokugo.png'),
 	(8, 'textbook6_eigo.png'),
 	(9, 'textbook4_rika.png'),
 	(10,'textbook3_sugakuu.png'),
 	(11,'textbook5_syakai.png'),
 	(12,'textbook6_eigo.png'),
 	(13,'textbook3_sugakuu.png'),
 	(6, 'textbook3_sugakuu.png'),
 	(8, 'textbook6_eigo.png');

 	
 	-- reviews テーブルにデータを挿入するクエリ
 	INSERT INTO reviews (item_id, message)
 	VALUES
 	(3, '新品同様でキズなどは特になく良かったです'),
 	(5, '書き込みはありましたがあまり多くなくてよかったです'),
 	(7, '中古でしたが思ったよりキズがなくいい買い物をしました'),
 	(8, '新品の割には使い古された感があったので気になりましたが、使えそうなので大丈夫です'),
 	(9, '破損していましたが表紙だけだったので使えそうです');
 	
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
 	(3, 1, 5),
 	(4, 5, 1),
 	(5, 1, 5),
 	(1, 3, 3),
 	(3, 4, 4);
 	
 	-- students テーブルにデータを挿入するクエリ
 	INSERT INTO students (name, personal_number, birthday, address, number, faculty, department)
 	VALUES
 	('管理者(1)','00000000','2000-1-1','東京都中央区','0120500500','講師','天文学'),--1
 	('三井悠太郎', '11620111', '2000-9-3', '神奈川県横浜市', '08012345678', '文学部', '史学科'),--2
 	('渡邊徹也', '84937592', '2001-10-29', '東京都練馬区', '08089348403', '経済学部', '経済学科'),--3
 	('須谷祐斗', '20948499', '2002-1-22', '埼玉県さいたま市', '08011920241', '教育学部', '教育学科'),--4
 	('江嵜遊太', '21838119', '2001-7-12', '東京都八王子市', '08064730112', '理工学部', '理工学科'),--5
 	('石川星河', '82383211', '2002-3-9', '千葉県柏市', '08019282018', '工学部', '機械工学科'),--6
 	('田村昂暉', '99198373', '2001-12-23', '神奈川県横浜市', '07055292014', '', ''),--7
 	('鈴木一郎', '99739387', '1985-8-17', '岩手県盛岡市', '09092812081', '', ''),--8
 	('悪質一郎', '99999999', '1900-12-31','東京都足立区', '08012334556','',''),--9
 	('ゲストユーザー', '12345678', '1985-8-17', '岩手県盛岡市', '09092812081', '', '');--10
 	
 	-- teachers テーブルにデータを挿入するクエリ
 	INSERT INTO teachers (name, personal_number, birthday, address, number, faculty, department)
 	VALUES
 	('眞鍋早紀', '99000001', '1928-2-18', '北海道札幌市', '09027129038', '文学部', '日本文学科'),--11
 	('阿部陽子', '99000002', '1991-12-9', '北海道小樽市', '07002820089', '理工学部', '電気電子工学科'),--12
 	('芹田敏夫', '99000003', '1962-9-18', '青森県青森市', '08018273828', '経済学部', '経済学科'),--13
 	('西村浩平', '99000004', '1977-7-7', '北海道室蘭市', '09011986521', '外国語学部', '英語学科'),--14
 	('桜井道子', '99000005', '1982-8-12', '青森県八戸市', '09002398223', '経済学部', '国際経済学科'),--15
 	('伊藤悟', '99000006', '1985-2-27', '岩手県盛岡市', '09071829911', '経営学部', '会計学科'),--16
 	('藤本満', '99000007', '1973-10-16', '秋田県秋田市', '07074291081', '経営学部', 'マーケティング学科'),--17
 	('細井重徳', '99000008', '1980-12-8', '山形県山形市', '09011828263', '文学部', '英米文学科'),--18
 	('大野博之', '99000009', '1972-11-19', '宮城県仙台市', '08012899872', '法学部', '民事法学科'),--19
 	('山田花子', '99000010', '1980-01-05', '東京都千代田区', '09012345678', '文学部', 'フランス文学科'),--20
 	('佐藤健太', '99000011', '1985-04-15', '神奈川県横浜市', '08023456789', '法学部', '刑事法学科'),--21
 	('鈴木雅子', '99000012', '1972-07-20', '大阪府大阪市', '07034567890', '理工学部', '機械工学学科'),--22
 	('田中一郎', '99000013', '1978-09-25', '北海道札幌市', '08045678901', '外国語学部', 'ドイツ語学科'),--23
 	('斎藤美奈子', '99000014', '1983-11-12', '愛知県名古屋市', '09056789012', '法学部', '国際法学科'),--24
 	('伊藤健太郎', '99000015', '1977-03-08', '京都府京都市', '07067890123', '経済学部', '財政学科'),--25
 	('渡辺真紀', '99000016', '1982-06-30', '兵庫県神戸市', '08078901234', '経営学部', '金融学科'),--26
 	('小林尚子', '99000017', '1975-12-18', '福岡県福岡市', '09089012345', '文学部', '日本文学科'),--27
 	('加藤拓也', '99000018', '1987-08-22', '沖縄県那覇市', '07090123456', '法学部', '経営法学科'),--28
 	('岡田悠子', '99000019', '1984-02-09', '広島県広島市', '08001234567', '経済学部', '労働経済学科'),--29
 	('松本剛', '99000020', '1979-05-14', '青森県青森市', '07098765432', '外国語学部', 'フランス語学科'),--30
 	('池田光男', '99000021', '1981-10-28', '岐阜県岐阜市', '09087654321', '外国語学部', 'スペイン語学科'),--31
 	('林さやか', '99000022', '1986-03-17', '長野県長野市', '07076543210', '経営学部', '経営学科'),--32
 	('野口隆夫', '99000023', '1980-07-03', '山口県山口市', '08065432109', '理工学部', '電気電子工学科'),--33
 	('村上美穂', '99000024', '1973-11-20', '岡山県岡山市', '09054321098', '文学部', '英米文学科'),--34
 	('高橋雄一', '99000025', '1976-09-06', '鹿児島県鹿児島市', '07043210987', '外国語学部', '英語学科'),--35
 	('中島真紀子', '99000026', '1988-04-28', '長崎県長崎市', '08032109876', '経済学部', '経済学科'),--36
 	('前田健太', '99000027', '1982-12-15', '愛媛県松山市', '09021098765', '理工学部', '化学工学科'),--37
 	('小川彩子', '99000028', '1977-08-02', '新潟県新潟市', '07010987654', '経営学部', 'マーケティング学科'),--38
 	('佐々木大輔', '99000029', '1974-01-19', '岩手県盛岡市', '08009876543', '理工学部', '土木工学科'),--39
 	('大西真悠子', '99000030', '1985-05-06', '石川県金沢市', '09098765432', '経営学部', '会計学科'),--40
 	('渡部拓也', '99000031', '1983-09-11', '福井県福井市', '07076543210', '法学部', '経営法学科'),--41
 	('内田朋子', '99000032', '1978-12-25', '静岡県静岡市', '08065432109', '法学部', '刑事法学科'),--42
 	('菅原悠真', '99000033', '1986-06-13', '岩手県岩手市', '09054321098', '理工学部', '土木工学科'),--43
 	('高木裕美', '99000034', '1971-10-30', '徳島県徳島市', '07043210987', '文学部', 'フランス文学科'),--44
 	('田村悠一', '99000035', '1980-01-05', '東京都千代田区', '09012345678', '理工学部', '機械工学科'),--45
 	('加藤由美', '99000036', '1985-04-15', '神奈川県横浜市', '08023456789', '法学部', '民事法学科'),--46
 	('小林直人', '99000037', '1972-07-20', '大阪府大阪市', '07034567890', '理工学部', '機械工学科'),--47
 	('鈴木美咲', '99000038', '1978-09-25', '北海道札幌市', '08045678901', '外国語学部', 'ドイツ語学科'),--48
 	('山田太郎', '99000039', '1983-11-12', '愛知県名古屋市', '09056789012', '経済学部', '国際経済学科'),--49
 	('伊藤太郎', '99000040', '1977-03-08', '京都府京都市', '07067890123', '経済学部', '財政学科'),--50
 	('渡辺花子', '99000041', '1982-06-30', '兵庫県神戸市', '08078901234', '理工学部', '化学工学科'),--51
 	('田中直美', '99000042', '1975-12-18', '福岡県福岡市', '09089012345', '文学部', '英米文学科'),--52
 	('佐々木健太', '99000043', '1987-08-22', '沖縄県那覇市', '07090123456', '法学部', '国際法学科'),--53
 	('岡田真紀', '99000044', '1984-02-09', '広島県広島市', '08001234567', '外国語学部', 'スペイン語学科'),--54
 	('松本美穂', '99000045', '1979-05-14', '青森県青森市', '07098765432', '法学部', '民事法学科'),--55
 	('池田拓也', '99000046', '1981-10-28', '岐阜県岐阜市', '09087654321', '経済学部', '労働経済学科'),--56
 	('林太郎', '99000047', '1986-03-17', '長野県長野市', '07076543210', '経営学部', '経営学科'),--57
 	('野口朋子', '99000048', '1980-07-03', '山口県山口市', '08065432109', '法学部', '刑事法学科'),--58
 	('高橋直樹', '99000049', '1976-09-06', '鹿児島県鹿児島市', '07043210987', '理工学部', '電気電子工学科'),--59
 	('中島拓也', '99000050', '1988-04-28', '長崎県長崎市', '08032109876', '外国語学部', '英語学科'),--60
 	('小川美佳', '99000051', '1977-08-02', '新潟県新潟市', '07010987654', '経営学部', 'マーケティング学科'),--61
 	('渡部真太郎', '99000052', '1983-09-11', '福井県福井市', '07076543210', '経済学部', '財政学科'),--62
 	('内田夏美', '99000053', '1978-12-25', '静岡県静岡市', '08065432109', '法学部', '国際法学科'),--63
 	('菅原拓也', '99000054', '1986-06-13', '岩手県岩手市', '09054321098', '理工学部', '化学工学科'),--64
 	('高木美恵', '99000055', '1971-10-30', '徳島県徳島市', '07043210987', '経済学部', '経済学科'),--65
 	('西村大介', '99000056', '1980-03-17', '茨城県水戸市', '08032109876', '外国語学部', 'フランス語学科'),--66
 	('田村まゆみ', '99000057', '1984-07-21', '愛知県名古屋市', '09021098765', '経営学部', 'グローバルマネジメント学科'),--67
 	('加藤敦子', '99000058', '1977-11-08', '大阪府大阪市', '07010987654', '経済学部', '労働経済学科'),--68
 	('小林健太郎', '99000059', '1982-04-03', '北海道札幌市', '08009876543', '理工学部', '土木工学科'),--69
 	('斎藤拓也', '99000060', '1987-06-10', '埼玉県さいたま市', '08076543210', '経済学部', '国際経済学科'),--70
 	('伊藤真理子', '99000061', '1981-09-27', '福岡県福岡市', '09065432109', '経営学部', '会計学科'),--71
 	('渡辺大輔', '99000062', '1975-02-14', '広島県広島市', '07054321098', '経営学部', '金融学科'),--72
 	('佐々木真一', '99000063', '1983-10-18', '沖縄県那覇市', '09032109876', '経営学部', '経営学科'),--73
 	('岡田真司', '99000064', '1976-05-07', '岐阜県岐阜市', '07021098765', '経営学部', 'グローバルマネジメント学科'),--74
 	('ハリー・ケイン', '99000065', '1993-7-28', 'ドイツバイエルン州', '02098783879', '', ''),--75
 	('フェデリコ・キエーザ', '99000066', '1997-10-26', 'イタリアトリノ', '0918387321', '', ''),--76
 	('トーマス・ミュラー', '99000067', '1989-9-13', 'ドイツバイエルン州', '080983789113', '', ''),--77
 	('ニン・イーチュオ', '99000068', '2002-10-23', '韓国ソウル特別市', '06001388402', '', '');--78
 	
 	
 	-- lessons テーブルにデータを挿入するクエリ
 	INSERT INTO lessons (name, day, period, teacher_id)
 	VALUES
 	
 	--文学部
 	--日本文学科
 	('古典文学入門', 3, 5, 27),--1
 	('和歌の歴史と鑑賞', 4, 6, 11),--2
 	('現代日本文学論', 5, 2, 27),--3
 	('日本文化と歴史', 3, 2, 11),--4
 	('日本の詩と詩論', 4, 3, 11),--5
 	
 	--英米文学科
 	('Shakespeare Studies', 4, 1, 18),
 	('Modern British Fiction', 5, 4, 34),
 	('American Poetry and Poetics', 1, 5, 52),
 	('Literary Theory', 6, 1, 18),
 	('Postcolonial Literature', 2, 3, 34),--10
 	
 	--フランス文学科
 	('フランス文学史', 4, 2, 44),
 	('フランスのルネサンス文学', 5, 3, 20),
 	('フランス象徴主義文学', 3, 3, 44),
 	('フランスの小説と映画', 6, 4, 20),
 	('フランスの詩人たち', 6, 6, 44),--15
 	
 	--経済学部
 	--経済学科
 	('マクロ経済学', 1, 6, 36),
 	('ミクロ経済学', 5, 5, 13),
 	('経済成長理論', 2, 3, 36),
 	('国際経済学', 4, 4, 65),
 	('開発経済学', 3, 2, 65),--20
 	
 	--国際経済学科
 	('国際貿易論', 2, 3, 15),
 	('国際金融論', 3, 4, 49),
 	('国際開発経済学', 1, 3, 49),
 	('グローバル化と経済', 2, 5, 15),
 	('国際経済政策', 6, 3, 70),--25
 	
 	--財政学科
 	('財政政策論', 2, 4, 25),
 	('公共財政論', 2, 4, 50),
 	('財政システム論', 2, 2, 50),
 	('税制論', 3, 5, 25),
 	('財政の理論と実務', 4, 5, 62),--30
 	
 	--労働経済学科
 	('労働市場分析', 5, 6, 29),
 	('労働法と労使関係', 3, 1, 56),
 	('労働経済政策', 4, 3, 56),
 	('労働心理学', 3, 6, 68),
 	('労働運動の歴史', 1, 5, 29),--35
 	
 	--経営学部
 	--経営学科
 	('経営戦略論', 6, 5, 57),
 	('リーダーシップと組織行動', 3, 3, 32),
 	('イノベーションマネジメント', 5, 3, 73),
 	('組織理論', 3, 6, 32),
 	('ビジネスエシックス', 4, 5, 57),--40
 	
 	--マーケティング学科
 	('消費者行動分析', 2, 5, 38),
 	('ブランドマネジメント', 6, 1, 17),
 	('デジタルマーケティング', 5, 5, 38),
 	('グローバルマーケティング戦略', 1, 5, 61),
 	('広告とプロモーション', 4, 4, 17),--45
 	
 	--会計学科
 	('財務会計論', 3, 5, 16),
 	('管理会計論', 4, 6, 40),
 	('国際会計基準', 1, 2, 16),
 	('財務分析', 6, 4, 71),
 	('会計情報システム', 6, 2, 40),--50
 	
 	--金融学科
 	('金融市場論', 2, 5, 26),
 	('投資理論', 6, 6, 72),
 	('リスク管理', 4, 2, 72),
 	('資本市場論', 1, 6, 26),
 	('国際金融市場', 4, 2, 26),--55
 	
 	--グローバルマネジメント学科
 	('グローバル戦略論', 5, 3, 67),
 	('クロスカルチャーマネジメント', 4, 4, 74),
 	('グローバルサプライチェーン管理', 5, 2, 74),
 	('国際ビジネス法', 2, 2, 74),
 	('企業社会責任（CSR）', 2, 1, 67),--60
 	
 	--法学部
 	--民事法学科
 	('契約法', 3, 1, 19),
 	('財産法', 5, 1, 19),
 	('家族法', 5, 3, 46),
 	('民事訴訟法', 2, 2, 46),
 	('消費者保護法', 5, 2, 55),--65
 	
 	--刑事法学科
 	('刑法一般論', 4, 3, 21),
 	('刑事訴訟法', 6, 3, 42),
 	('犯罪学', 3, 1, 21),
 	('刑事司法制度', 5, 6, 58),
 	('犯罪心理学', 1, 4, 42),--70
 	
 	--国際法学科
 	('国際人権法', 3, 5, 53),
 	('国際組織法', 5, 4, 24),
 	('国際紛争解決法', 2, 4, 63),
 	('国際海洋法', 1, 5, 53),
 	('国際人道法', 3, 6, 24),--75
 	
 	--経営法学科
 	('商法', 4, 1, 28),
 	('会社法', 1, 6, 41),
 	('競争法', 6, 5, 41),
 	('消費者法', 4, 6, 28),
 	('知的財産法', 1, 4, 28),--80
 	
 	--理工学部
 	--機械工学科
 	('機械設計', 2, 6, 45),
 	('熱力学', 2, 1, 22),
 	('自動制御', 6, 3, 45),
 	('ロボット工学', 5, 5, 22),
 	('材料力学', 3, 3, 47),--85
 	
 	--電気電子工学科
 	('電磁気学', 5, 4, 33),
 	('マイクロプロセッサ設計', 1, 3, 59),
 	('電力変換', 6, 6, 59),
 	('通信工学', 2, 4, 12),
 	('VLSI設計', 6, 4, 33),--90
 	
 	--化学工学科
 	('化学プロセス工学', 5, 1, 37),
 	('分子設計', 2, 2, 37),
 	('環境化学工学', 3, 3, 64),
 	('高分子化学',4, 5, 51),
 	('化学エネルギー工学', 6, 1, 51),--95
 	
 	--土木工学科
 	('構造解析', 2, 6, 39),
 	('道路工学', 4, 2, 43),
 	('河川工学', 1, 4, 43),
 	('地震工学', 2, 5, 69),
 	('環境工学', 3, 4, 39),--100
 	
 	--外国語学科
 	--英語学科
 	('英語音声学', 2, 3, 60),
 	('英語教育法', 4, 3, 35),
 	('英米文学史', 5, 6, 35),
 	('英語コミュニケーション', 2, 1, 60),
 	('英語翻訳理論', 4, 1, 14),--105
 	
 	--ドイツ語学科
 	('ドイツ文法', 6, 2, 23),
 	('ドイツ文学鑑賞', 4, 5, 48),
 	('ドイツ語翻訳論', 2, 5, 48),
 	('ドイツの歴史と文化',1, 2, 48),
 	('ドイツ語圏の現代社会', 3, 2, 23),--110
 	
 	--フランス語学科
 	('フランス語会話', 6, 2, 30),
 	('フランス文化論', 1, 3, 66),
 	('フランス文学批評', 6, 5, 66),
 	('フランスの映画と演劇', 2, 6, 30),
 	('フランスの哲学と思想', 3, 4, 66),--115
 	
 	--スペイン語学科
 	('スペイン語文法', 5, 4, 54),
 	('ラテンアメリカ文学', 1, 4, 31),
 	('スペイン語翻訳技術', 5, 1, 31),
 	('スペイン語音楽とダンス', 4, 4, 31),
 	('スペイン語圏の政治と経済', 3, 2, 54),--120
 	
 	--英語
 	('英語Ⅰ', 3, 2, 75),
 	('英語Ⅱ', 5, 3, 75),
 	('英作文', 1, 1, 14),--123
 	
 	--第二外国語
 	('イタリア語入門', 4, 1, 76),
 	('ドイツ語入門', 1, 5, 77),
 	('スペイン語入門', 3, 6, 54),
 	('中国語入門', 1, 2, 78);--127
 	
 	
 	
 	--lesson_textbooks テーブルにデータを挿入するクエリ
 	INSERT INTO lesson_textbooks (lesson_id, textbook_id)
 	VALUES
 	(1, 54),
 	(2, 55),
 	(3, 56),
 	(3, 7),
 	(5, 6),
 	(6, 57),
 	(7, 58),
 	(8, 59),
 	(9, 9),
 	(11, 60),
 	(11, 10),
 	(12, 61),
 	(13, 62),
 	(14, 11),
 	(16, 63),
 	(17, 64),
 	(18, 65),
 	(19, 13),
 	(20, 12),
 	(21, 66),
 	(22, 67),
 	(23, 68),
 	(23, 14),
 	(25, 15),
 	(26, 69),
 	(27, 70),
 	(27, 17),
 	(28, 71),
 	(29, 16),
 	(31, 72),
 	(32, 73),
 	(32, 19),
 	(33, 74),
 	(35, 18),
 	(36, 75),
 	(37, 76),
 	(38, 77),
 	(38, 23),
 	(40, 20),
 	(41, 78),
 	(41, 21),
 	(42, 79),
 	(43, 80),
 	(44, 22),
 	(46, 81),
 	(47, 82),
 	(48, 83),
 	(49, 24),
 	(50, 25),
 	(51, 84),
 	(52, 85),
 	(53, 86),
 	(55, 27),
 	(56, 87),
 	(57, 88),
 	(57, 29),
 	(58, 89),
 	(59, 28),
 	(61, 90),
 	(62, 91),
 	(63, 92),
 	(64, 31),
 	(66, 93),
 	(67, 94),
 	(67, 32),
 	(68, 95),
 	(71, 96),
 	(72, 97),
 	(73, 98),
 	(73, 35),
 	(75, 34),
 	(76, 99),
 	(77, 100),
 	(77, 36),
 	(78, 101),
 	(81, 102),
 	(81, 38),
 	(82, 103),
 	(83, 104),
 	(86, 105),
 	(87, 106),
 	(88, 107),
 	(91, 108),
 	(91, 40),
 	(92, 109),
 	(93, 110),
 	(95, 41),
 	(96, 111),
 	(97, 112),
 	(98, 113),
 	(99, 43),
 	(100, 44),
 	(101, 114),
 	(102, 115),
 	(103, 116),
 	(104, 46),
 	(105, 47),
 	(106, 117),
 	(107, 118),
 	(108, 119),
 	(109, 48),
 	(110, 49),
 	(111, 120),
 	(112, 121),
 	(112, 51),
 	(113, 122),
 	(115, 50),
 	(116, 123),
 	(116, 52),
 	(117, 124),
 	(118, 125),
 	(121, 46),
 	(122, 46),
 	(123, 47),
 	(124, 128),
 	(125, 127),
 	(126, 126),
 	(127, 129);
 	
 	-- timetables テーブルにデータを挿入するクエリ
 	INSERT INTO timetables (lesson_id, user_id)
 	VALUES
 	(57, 2),
 	(112, 2),
 	(9, 2),
 	(33, 2),
 	(76, 2),
 	(22, 2),
 	(101, 2),
 	(68, 2),
 	(3, 2),
 	(89, 2),
 	(43, 2),
 	(14, 2),
 	(61, 3),
 	(98, 3),
 	(50, 3),
 	(105, 3),
 	(2, 3),
 	(87, 3),
 	(27, 3),
 	(119, 3),
 	(7, 3),
 	(40, 3),
 	(81, 3),
 	(58, 3),
 	(16, 4),
 	(95, 4),
 	(12, 4),
 	(70, 4),
 	(37, 4),
 	(115, 4),
 	(25, 4),
 	(90, 4),
 	(63, 4),
 	(110, 4),
 	(5, 4),
 	(92, 4),
 	(29, 5),
 	(82, 5),
 	(49, 5),
 	(18, 5),
 	(97, 5),
 	(24, 5),
 	(67, 5),
 	(103, 5),
 	(8, 5),
 	(86, 5),
 	(54, 5),
 	(115, 5),
 	(46, 6),
 	(15, 6),
 	(75, 6),
 	(100, 6),
 	(31, 6),
 	(91, 6),
 	(59, 6),
 	(111, 6),
 	(23, 6),
 	(6, 6),
 	(94, 6),
 	(51, 6);
 	
 	-- histories テーブルにデータを挿入するクエリ
 	INSERT INTO histories (textbook_id, user_id, status)
 	VALUES
 	(88, 2, 2),
 	(29, 2, 1),
 	(121, 2, 1),
 	(51, 2, 2),
 	(9, 2, 2),
 	(74, 2, 1),
 	(99, 2, 1),
 	(67, 2, 2),
 	(114, 2, 1),
 	(95, 2, 2),
 	(56, 2, 2),
 	(7, 2, 1),
 	(80, 2, 2),
 	(11, 2, 2),
 	(90, 3, 1),
 	(113, 3, 2),
 	(25, 3, 1),
 	(47, 3, 2),
 	(55, 3, 1),
 	(106, 3, 2),
 	(70, 3, 1),
 	(17, 3, 2),
 	(58, 3, 1),
 	(20, 3, 2),
 	(102, 3, 2),
 	(38, 3, 1),
 	(89, 3, 2),
 	(63, 4, 1),
 	(41, 4, 1),
 	(61, 4, 2),
 	(76, 4, 1),
 	(50, 4, 2),
 	(15, 4, 1),
 	(92, 4, 2),
 	(49, 4, 2),
 	(6, 4, 1),
 	(109, 4, 1),
 	(16, 5, 1),
 	(103, 5, 2),
 	(24, 5, 2),
 	(65, 5, 1),
 	(112, 5, 2),
 	(94, 5, 1),
 	(32, 5, 2),
 	(116, 5, 2),
 	(59, 5, 1),
 	(105, 5, 2),
 	(50, 5, 2),
 	(81, 6, 2),
 	(34, 6, 1),
 	(44, 6, 2),
 	(72, 6, 2),
 	(40, 6, 1),
 	(28, 6, 1),
 	(120, 6, 2),
 	(68, 6, 1),
 	(14, 6, 2),
 	(57, 6, 1),
 	(84, 6, 1),
 	(26, 6, 2);
 	