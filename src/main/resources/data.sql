-- 더미데이터
INSERT INTO article(title, content) VALUES ('안녕하세요', '반가워요');
INSERT INTO article(title, content) VALUES ('안녕', '반가워');
INSERT INTO article(title, content) VALUES ('안녕하세요 반가워요', '네 반가워요');

-- 더미데이터
INSERT INTO article(title, content) VALUES ('연말에 뭐하세요?', '댓글로 알려주세요');
INSERT INTO article(title, content) VALUES ('크리스마스에 뭐하세요?', '댓글 써주세요');
INSERT INTO article(title, content) VALUES ('올 한 해 수고하셨어요', '댓글댓글');

-- 더미데이터
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Park', '집돌이');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Kim', '공부');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Choi', '여행');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Park', '맛집');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Kim', '카페');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Choi', '데이트');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Park', '수고하셨어요');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Kim', '고생하셨어요');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Choi', '마무리 잘 하세요');
