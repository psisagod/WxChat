SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
  `teacher_id` int(5) NOT NULL,
  `teacher_name` varchar(5),
  `deptid` varchar(5),
  `phone` varchar(20),
  `gender` tinyint(1),
  `openid` varchar(20),
  PRIMARY KEY (`teacher_id`),
  index `idx_teacher_name` (`teacher_name`),
  index `idx_deptid` (`deptid`)
)
DEFAULT CHARSET=utf8;
