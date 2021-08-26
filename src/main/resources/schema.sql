DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `tweet`;
DROP TABLE IF EXISTS `hashtag`;
DROP TABLE IF EXISTS `tweet_hashtag`;

CREATE TABLE IF NOT EXISTS `user` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `hash` varchar(255) NOT NULL,
    `twitter_id` VARCHAR(300) NOT NULL,
    `name` VARCHAR(300) NOT NULL,
    `deleted` TINYINT(1) NOT NULL DEFAULT 0,
    `created` DATETIME,
    `updated` DATETIME,
    CONSTRAINT `user_hash_uindex` UNIQUE (`hash`),
    CONSTRAINT `user_twitter_id_uindex` UNIQUE (`twitter_id`)
);

CREATE TABLE IF NOT EXISTS `tweet` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `hash` varchar(255) NOT NULL,
    `twitter_id` VARCHAR(300) NOT NULL,
    `user_id` INT(11) NOT NULL,
    `text` VARCHAR(300) NOT NULL,
    `approved` TINYINT(1) NOT NULL DEFAULT 0,
    `deleted` TINYINT(1) NOT NULL DEFAULT 0,
    `created` DATETIME,
    `updated` DATETIME,
    CONSTRAINT `tweet_hash_uindex` UNIQUE (`hash`),
    CONSTRAINT `tweet_twitter_id_uindex` UNIQUE (`twitter_id`),
    CONSTRAINT `tweet_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `hashtag` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `hash` varchar(255) NOT NULL,
    `text` VARCHAR(300) NOT NULL,
    `deleted` TINYINT(1) NOT NULL DEFAULT 0,
    `created` DATETIME,
    `updated` DATETIME,
    CONSTRAINT `hashtag_hash_uindex` UNIQUE (`hash`)
);

CREATE TABLE IF NOT EXISTS `tweet_hashtag` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `hash` varchar(255) NOT NULL,
    `tweet_id` INT(11) NOT NULL,
    `hashtag_id` INT(11) NOT NULL,
    `created` DATETIME,
    `updated` DATETIME,
    CONSTRAINT `tweet_hashtag_hash_uindex` UNIQUE (`hash`),
    CONSTRAINT `tweet_hashtag_tweet_id_hashtag_id_uindex` UNIQUE (`tweet_id`, `hashtag_id`),
    CONSTRAINT `tweet_hashtag_tweet_id_fk` FOREIGN KEY (`tweet_id`) REFERENCES `tweet` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT `tweet_hashtag_hashtag_id_fk` FOREIGN KEY (`hashtag_id`) REFERENCES `hashtag` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);
