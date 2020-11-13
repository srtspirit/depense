DELETE FROM article;
INSERT INTO article(id, name, parent_article_id)
VALUES(615, 'books', null ),
(618, 'books', null ),
(619, 'auto', null ),
(620, 'moto', 619 ),
(628, 'newArt', null );
