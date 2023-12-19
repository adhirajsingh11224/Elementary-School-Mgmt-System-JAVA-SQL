SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT;
SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS;
SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION;
SET NAMES utf8;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=NO_AUTO_VALUE_ON_ZERO */;


CREATE DATABASE /*!32312 IF NOT EXISTS*/ `school_mgmt_db`;
USE `school_mgmt_db`;
CREATE TABLE `compsubject_details` (
  `studentID` int(11) DEFAULT NULL,
  `labActivityScore` int(11) DEFAULT NULL,
  `homeworkScore` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Overall_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `compsubject_details` (`studentID`,`labActivityScore`,`homeworkScore`,`month`,`year`,`Overall_score`) VALUES (116,1,2,'july',2022,3),(117,3,3,'july',2022,6),(118,4,5,'july',2022,9),(119,4,1,'july',2022,5),(120,4,5,'july',2022,9);
CREATE TABLE `engsubjectdetails` (
  `studentID` int(11) DEFAULT NULL,
  `ParticipationScore` int(11) DEFAULT NULL,
  `homeworkScore` int(11) DEFAULT NULL,
  `readingScore` int(11) DEFAULT NULL,
  `speakingScore` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Overall_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `engsubjectdetails` (`studentID`,`ParticipationScore`,`homeworkScore`,`readingScore`,`speakingScore`,`month`,`year`,`Overall_score`) VALUES (101,2,2,2,2,'mar',2023,8),(102,5,5,4,3,'mar',2023,17),(103,5,5,5,3,'mar',2023,18),(104,3,3,3,3,'mar',2023,12),(105,3,3,3,3,'mar',2023,12),(101,2,2,2,2,'mar',2023,8),(102,2,2,2,2,'mar',2023,8),(103,2,2,2,2,'mar',2023,8),(104,2,2,2,2,'mar',2023,8),(105,2,2,2,2,'mar',2023,8),(101,2,2,2,2,'mar',2023,8),(102,2,2,2,2,'mar',2023,8),(103,2,2,2,2,'mar',2023,8),(104,2,2,2,2,'mar',2023,8);
CREATE TABLE `gksubjectdetails` (
  `studentID` int(11) DEFAULT NULL,
  `ParticipationScore` int(11) DEFAULT NULL,
  `homeworkScore` int(11) DEFAULT NULL,
  `quizScore` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Overall_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `gksubjectdetails` (`studentID`,`ParticipationScore`,`homeworkScore`,`quizScore`,`month`,`year`,`Overall_score`) VALUES (101,2,2,2,'mar',2023,6),(102,3,3,3,'mar',2023,9),(103,3,3,3,'mar',2023,9),(104,2,3,4,'mar',2023,9),(105,3,3,4,'mar',2023,10);
CREATE TABLE `hindisubjectdetails` (
  `studentID` int(11) DEFAULT NULL,
  `ParticipationScore` int(11) DEFAULT NULL,
  `homeworkScore` int(11) DEFAULT NULL,
  `speakingScore` int(11) DEFAULT NULL,
  `readingScore` int(11) DEFAULT NULL,
  `listeningScore` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Overall_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `hindisubjectdetails` (`studentID`,`ParticipationScore`,`homeworkScore`,`speakingScore`,`readingScore`,`listeningScore`,`month`,`year`,`Overall_score`) VALUES (101,2,3,4,4,5,'mar',2023,18),(102,2,3,4,4,5,'mar',2023,18),(103,2,3,4,4,5,'mar',2023,18),(104,2,3,4,4,5,'mar',2023,18),(105,2,3,4,4,5,'mar',2023,18);
CREATE TABLE `homeroom_details` (
  `id` int(11) NOT NULL DEFAULT '0',
  `regularity` int(11) DEFAULT NULL,
  `communication` int(11) DEFAULT NULL,
  `uniform` int(11) DEFAULT NULL,
  `homeroom_score` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `homeroom_details` (`id`,`regularity`,`communication`,`uniform`,`homeroom_score`,`month`,`year`) VALUES (106,5,3,4,12,'mar',2023),(107,2,2,2,6,'may',2023),(108,4,3,2,0,'july',2021),(109,4,4,4,12,'mar',2023),(116,2,3,4,9,'june',2022),(119,4,2,4,10,'june',2022),(120,3,3,4,0,'july',2021);
CREATE TABLE `logindetails` (
  `id` int(11) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `logindetails` (`id`,`firstName`,`lastName`,`category`,`password`) VALUES (0,'FirstNameX','LastNameX','admin','admin'),(1,'Adhiraj','Singh','admin','admin'),(3,'FNAME','LNAME','admin','admin'),(9,'krishna','p','teacher','root'),(21,'jhon','kane','teacher','welcome@123'),(24,'abc','e','teacher','welcome@123'),(27,'aarti','s','teacher','welcome@123'),(31,'TeacherTest','LastName','teacher','welcome@123'),(35,'A','S','teacher','welcome@123'),(55,'James','Lester','teacher','welcome@123'),(93,'ankita','m','teacher','welcome@123'),(131,'priyanka','c','teacher','welcome@123'),(145,'vyom','m','teacher','welcome@123'),(167,'suparna','m','teacher','123'),(188,'Teacher','Lname','teacher','welcome@123'),(193,'sunneeta','u','teacher','welcome@123');
CREATE TABLE `mathsubject_details` (
  `studentID` int(11) DEFAULT NULL,
  `ParticipationScore` int(11) DEFAULT NULL,
  `homeworkScore` int(11) DEFAULT NULL,
  `testScore` int(11) DEFAULT NULL,
  `doubtsScore` int(11) DEFAULT NULL,
  `conceptUnderstanding` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Overall_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `mathsubject_details` (`studentID`,`ParticipationScore`,`homeworkScore`,`testScore`,`doubtsScore`,`conceptUnderstanding`,`month`,`year`,`Overall_score`) VALUES (101,2,2,2,2,2,'mar',2023,8),(102,3,3,3,3,3,'mar',2023,12),(103,4,4,4,4,4,'mar',2023,16),(104,4,4,5,5,3,'mar',2023,16),(105,4,4,5,5,4,'mar',2023,17);
CREATE TABLE `sciencessubjectdetails` (
  `studentID` int(11) DEFAULT NULL,
  `ParticipationScore` int(11) DEFAULT NULL,
  `homeworkScore` int(11) DEFAULT NULL,
  `testScore` int(11) DEFAULT NULL,
  `doubtsScore` int(11) DEFAULT NULL,
  `conceptUnderstanding` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Overall_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `sciencessubjectdetails` (`studentID`,`ParticipationScore`,`homeworkScore`,`testScore`,`doubtsScore`,`conceptUnderstanding`,`month`,`year`,`Overall_score`) VALUES (101,2,2,2,2,2,'mar',2023,10),(102,3,3,3,3,3,'mar',2023,15),(103,4,4,4,4,4,'mar',2023,20),(104,5,5,5,5,5,'mar',2023,25),(105,1,1,1,1,1,'mar',2023,5),(102,2,2,2,2,2,'mar',2023,10),(103,2,2,2,2,2,'mar',2023,10),(102,2,2,2,2,2,'mar',2023,10),(103,2,2,2,2,2,'mar',2023,10),(104,2,2,2,2,2,'mar',2023,10),(105,2,2,2,2,2,'mar',2023,10),(102,2,2,2,2,2,'may',2022,10),(103,3,3,3,3,3,'may',2022,15),(104,4,4,4,4,4,'may',2022,20),(105,5,5,5,5,5,'may',2022,25),(103,4,5,4,3,3,'june',2022,19),(104,3,3,2,1,1,'june',2022,10),(105,1,5,5,4,2,'june',2022,17),(111,2,2,2,2,2,'june',2022,10),(112,1,2,1,2,2,'june',2022,8),(114,3,3,3,4,2,'june',2022,15),(115,3,2,4,2,3,'june',2022,14),(102,2,2,2,2,4,'may',2022,12),(104,2,3,4,1,2,'may',2022,12),(105,4,2,4,5,3,'may',2022,18);
CREATE TABLE `sstsubjectdetails` (
  `studentID` int(11) DEFAULT NULL,
  `ParticipationScore` int(11) DEFAULT NULL,
  `homeworkScore` int(11) DEFAULT NULL,
  `testScore` int(11) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Overall_score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `sstsubjectdetails` (`studentID`,`ParticipationScore`,`homeworkScore`,`testScore`,`month`,`year`,`Overall_score`) VALUES (101,2,2,2,'mar',2023,6),(102,2,3,3,'mar',2023,8),(103,5,3,4,'mar',2023,12),(104,5,5,4,'mar',2023,14),(105,5,5,4,'mar',2023,14);
CREATE TABLE `student_details` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `homeroom_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `student_details` (`id`,`firstname`,`lastname`,`class`,`contact`,`email`,`address`,`homeroom_score`) VALUES (101,'Jack','H','2C','8899227756','parent@gmail.com','address34',NULL),(102,'student 2','L','1A','1111111111','parent2@gmail.com','address 2',NULL),(103,'student 3','L','1A','2222222222','parent3@gmail.com','address 3',NULL),(104,'student4','L','1A','3333333333','4@gmail.com','address 4',NULL),(105,'student5','L','1A','4444444444','5@gmail.com','address 5',NULL),(106,'student 6','L','2A','6666666666','parent@gmail.com','address 6',6),(107,'student 7','L','2A','1111111111','parent@gmail.com','address 7',6),(108,'student 8','L','2A','1111111111','email@gmail.com','address 8',6),(109,'student 9','L','2A','1111111111','parent@gmail.com','address 9',6),(110,'student 10','L','2A','1111111111','email@gmail.com','address 10',13),(111,'student11','L','1C','1111111111','parent11@gmail.com','address11',NULL),(112,'student 12','L','1C','2222222222','gmail@gmail.com','address 12',NULL),(113,'student 13','L','1C','6666666666','parent@gmail.com','address 13',NULL);
INSERT INTO `student_details` (`id`,`firstname`,`lastname`,`class`,`contact`,`email`,`address`,`homeroom_score`) VALUES (114,'student 14','L','1C','777777777','a@gmail.com','address14',NULL),(115,'student 15','L','1C','9999999999','parent@gmail.com','address15',NULL),(116,'student 16','L','1B','9999999999','1@gmail.com','address16',6),(117,'student 17','L','1B','9999999999','a@gmail.com','address 17',8),(118,'student 18','L','1B','9999999999','parent@gmail.com','address18',51),(119,'student 19','L','1B','9999999999','a@gmail.com','address 19',8),(120,'student 20','L','1B','1111111111','parent@gmail.com','address',8);
CREATE TABLE `teacher_details` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `homeroom_class` varchar(10) DEFAULT NULL,
  `subject` varchar(30) DEFAULT NULL,
  `subjectClass1` varchar(10) DEFAULT NULL,
  `subjectclass2` varchar(10) DEFAULT NULL,
  `subjectclass3` varchar(10) DEFAULT NULL,
  `subjectclass4` varchar(10) DEFAULT NULL,
  `subjectclass5` varchar(10) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `teacher_details` (`id`,`firstname`,`lastname`,`homeroom_class`,`subject`,`subjectClass1`,`subjectclass2`,`subjectclass3`,`subjectclass4`,`subjectclass5`,`contact`,`email`) VALUES (9,'krishna','p','1B','Science','1A','1C','1D','2A','1A','9999999999','k@gmail.com'),(21,'jhon','kane','4D','Hindi','2A','2B','3A','3B','4B','1111111111','testTeacherT2@outlook.com'),(24,'abc','e','5C','Science','3B','3C','4B','4C','5B','1111111111','testTeacherT2@outlook.com'),(27,'aarti','s','1C','Mathematics','1A','1B','1D','2A','2B','9999999999','a@gmail.com'),(31,'TeacherTest','LastName','3D','Mathematics','3D','2D','3D','4D','5C','8822773344','testTeacherT1@outlook.com '),(35,'A','S','5D','English','4B','4C','4D','5A','5B','1111111111','testTeacherT2@outlook.com'),(55,'James','Lester','4A','Hindi','3C','4B','4C','5B','5C','1111111111','testTeacherT2@outlook.com'),(93,'ankita','m','2B','Social Studies','1A','1B','1C','1D','2A','7777777777','a@gmail.com'),(131,'priyanka','c','1A','ICT','1B','1C','1D','2A','2B','9999999999','priyanka@gmail.com'),(145,'vyom','m','2C','General Knowledge','1A','1B','1C','1D','2A','6666666666','123@gmail.com');
INSERT INTO `teacher_details` (`id`,`firstname`,`lastname`,`homeroom_class`,`subject`,`subjectClass1`,`subjectclass2`,`subjectclass3`,`subjectclass4`,`subjectclass5`,`contact`,`email`) VALUES (167,'suparna','m','2A','English','1A','1B','1C','1D','2B','6666666666','s@gmail.com'),(188,'Teacher','Lname','4C','Mathematics','1A','1B','1C','2A','2B','1122442255','testTeacherT1@outlook.com'),(193,'sunneeta','u','1D','Hindi','1A','1B','1C','2A','2B','9999999999','a@gmail.com');
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT;
SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS;
SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
