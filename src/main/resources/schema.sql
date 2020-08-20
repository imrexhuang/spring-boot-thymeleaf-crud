-- https://ithelp.ithome.com.tw/articles/10191117

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT COMMENT '編號',
  `name` varchar(255) DEFAULT NULL COMMENT '書籍名稱',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
