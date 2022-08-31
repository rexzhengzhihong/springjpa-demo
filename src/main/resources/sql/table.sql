CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `created_by` varchar(32) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `last_updated_by` varchar(32) DEFAULT NULL,
  `last_updated_date` date DEFAULT NULL,
  `object_version` int(11) DEFAULT NULL,
  `usercode` varchar(32) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8