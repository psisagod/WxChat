SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
  `student_id` int(5) NOT NULL,
  `student_name` varchar(5),
  `deptid` varchar(5),
  `phone` varchar(20),
  `gender` tinyint(1),
  `openid` varchar(20),
  PRIMARY KEY (`student_id`),
  index `idx_student_name` (`student_name`),
  index `idx_deptid` (`deptid`)
)
DEFAULT CHARSET=utf8;
