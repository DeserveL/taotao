
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_item_param_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_item_param_item`;
CREATE TABLE `tb_item_param_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `param_data` text COMMENT '参数数据，格式为json格式',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品规格和商品的关系表';
