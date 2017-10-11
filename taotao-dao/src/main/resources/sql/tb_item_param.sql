SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_item_param
-- ----------------------------
DROP TABLE IF EXISTS `tb_item_param`;
CREATE TABLE `tb_item_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_cat_id` bigint(20) DEFAULT NULL COMMENT '商品类目ID',
  `param_data` text COMMENT '参数数据，格式为json格式',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_cat_id` (`item_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品规则参数';
