create database flightticket;

CREATE TABLE `flight` (
  `flight_number` varchar(255) NOT NULL,
  `seats` int(12) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`flight_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `flightbooking` (
  `id` int(12) unsigned NOT NULL AUTO_INCREMENT,
  `flight_number` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `flight_number_idx` (`flight_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;