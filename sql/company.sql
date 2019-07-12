SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`
(
  `company_id` int(5) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(20),
  PRIMARY KEY (`company_id`),
  index `idx_company_name` (`company_name`)
)
DEFAULT CHARSET=utf8;