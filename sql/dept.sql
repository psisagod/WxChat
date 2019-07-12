SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`
(
  `dept_id` int(5) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20),
  `pid` int(5),
  PRIMARY KEY (`dept_id`),
  index `idx_dept_name` (`dept_name`)
)
DEFAULT CHARSET=utf8;
