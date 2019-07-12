SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`
(
  `record_id` int(5) NOT NULL AUTO_INCREMENT,
  `companyid` int(5),
  `time` datetime,
  `state` tinyint(1),
  `record_url` varchar(20),
  `studentid` int(5),
  `count` int(5),
  `pcount` int(5),
  `dcount` int(5),
  PRIMARY KEY (`record_id`),
  index `idx_companyid` (`companyid`),
  index `idx_time` (`time`),
  index `idx_state` (`state`),
  index `idx_record_url` (`record_url`),
  index `idx_studentid` (`studentid`)
)
DEFAULT CHARSET=utf8;
