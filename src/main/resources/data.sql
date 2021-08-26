INSERT INTO `user` (hash, twitter_id, name, deleted, created, updated) VALUES
    ('ce3a99f829045fd9cd93e6216caa29ee', '1402807716255465473', 'User 1', 0, now(), now()),
    ('8661ff2f7ac1126fb2d068c3a0641945', '1402807716255465474', 'User 2', 0, now(), now()),
    ('a924c3a7735a9487030468db3a4c64c3', '1402807716255465475', 'User 3', 0, now(), now());

INSERT INTO `tweet` (hash, twitter_id, user_id, text, approved, deleted, created, updated) VALUES
    ('709e0b07f589dc4280a7d296403789e2', '1430509162757169152', 1, 'Prueba Tweet 1 #acciona', 0, 0, now(), now()),
    ('25d885125b6bf066f5fe36a7ca7e0d19', '1430509162757169153', 1, 'Prueba Tweet 2 #acciona', 0, 0, now(), now()),
    ('6e9ac390eb3d8aaac914b5c7d776481e', '1430509162757169154', 2, 'Prueba Tweet 3 #prueba', 0, 0, now(), now()),
    ('24e91b64c73515cd9e6dea6b40190994', '1430509162757169155', 3, 'Prueba Tweet 4 #acciona', 0, 0, now(), now()),
    ('bf3225d6350128739b7b009afee3c607', '1430509162757169156', 3, 'Prueba Tweet 5 #prueba', 0, 0, now(), now());

INSERT INTO `hashtag` (hash, text, deleted, created, updated) VALUES
    ('d30dff3ec9f14bbffdb33947fa85e911', 'prueba', 0, now(), now()),
    ('de9bae9921d12baa49ae51b7cda72d8e', 'acciona', 0, now(), now());

INSERT INTO `tweet_hashtag` (hash, tweet_id, hashtag_id, created, updated) VALUES
    ('82d089fbd5d2695eda0fe6976b4ac6fb', 1, 2, now(), now()),
    ('a14482b81ed6135e820db7675ec58460', 2, 2, now(), now()),
    ('6cf10a81f676194b6dc04e27fb1dc2eb', 3, 1, now(), now()),
    ('e87d511f5cda8f66b493d31808251712', 4, 2, now(), now()),
    ('9a3961bb8f1aa2322eb151288fd84991', 5, 1, now(), now());
