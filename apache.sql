SET FOREIGN_KEY_CHECKS=0;
create database apache;
use apache;
-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_detail` text NOT NULL,
  `comment_user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE KEY `comment_id` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for comment_product
-- ----------------------------
DROP TABLE IF EXISTS `comment_product`;
CREATE TABLE `comment_product` (
  `comment_id` int(11) NOT NULL,
  `product_id` varchar(50) NOT NULL,
  UNIQUE KEY `comment_id` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_product
-- ----------------------------

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `order_id` varchar(255) NOT NULL,
  `product_id` int(11) NOT NULL,
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_user_id` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_oldprice` double(10,2) NOT NULL,
  `product_nowprice` double(10,2) NOT NULL,
  `product_remaining` int(11) NOT NULL,
  `product_category` int(3) NOT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `product_desc` text,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('13', '062ef099-6880-46bb-9b12-12de10d3754a', 'TCL电视机', '4798.00', '4798.00', '100', '3', '/Apache/upload/item/user/product/062ef099-6880-46bb-9b12-12de10d3754a/2019042220140898498.jpg', 'TCL电视机');
INSERT INTO `product` VALUES ('14', '062ef099-6880-46bb-9b12-12de10d3754a', '创维电视机', '6999.00', '6999.00', '100', '3', '/Apache/upload/item/user/product/062ef099-6880-46bb-9b12-12de10d3754a/2019042220145636571.jpg', '创维电视机');
INSERT INTO `product` VALUES ('15', '062ef099-6880-46bb-9b12-12de10d3754a', '康佳电视机', '3469.00', '3469.00', '100', '3', '/Apache/upload/item/user/product/062ef099-6880-46bb-9b12-12de10d3754a/2019042220151099738.jpg', '康佳电视机');
INSERT INTO `product` VALUES ('16', '062ef099-6880-46bb-9b12-12de10d3754a', '索尼电视机', '5099.00', '5099.00', '100', '3', '/Apache/upload/item/user/product/062ef099-6880-46bb-9b12-12de10d3754a/2019042220152339151.jpg', '索尼电视机');
INSERT INTO `product` VALUES ('17', '09412935-3a7e-4d57-bc25-a96700529421', '富士X-T20', '6699.00', '6699.00', '100', '9', '/Apache/upload/item/user/product/09412935-3a7e-4d57-bc25-a96700529421/2019042220182317610.jpg', '富士X-T20');
INSERT INTO `product` VALUES ('18', '09412935-3a7e-4d57-bc25-a96700529421', '佳能EOS 800D', '4599.00', '4599.00', '100', '9', '/Apache/upload/item/user/product/09412935-3a7e-4d57-bc25-a96700529421/2019042220184156937.jpg', '佳能EOS 800D');
INSERT INTO `product` VALUES ('19', '09412935-3a7e-4d57-bc25-a96700529421', '尼康D5300', '4199.00', '4199.00', '100', '9', '/Apache/upload/item/user/product/09412935-3a7e-4d57-bc25-a96700529421/2019042220190391100.jpg', '尼康D5300');
INSERT INTO `product` VALUES ('20', '09412935-3a7e-4d57-bc25-a96700529421', '松下LX10', '3398.00', '3398.00', '100', '9', '/Apache/upload/item/user/product/09412935-3a7e-4d57-bc25-a96700529421/2019042220191998561.jpg', '松下LX10');
INSERT INTO `product` VALUES ('21', '09412935-3a7e-4d57-bc25-a96700529421', '索尼ILCE-6000L', '3599.00', '3599.00', '100', '9', '/Apache/upload/item/user/product/09412935-3a7e-4d57-bc25-a96700529421/2019042220193292165.jpg', '索尼ILCE-6000L');
INSERT INTO `product` VALUES ('22', '2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', '海尔洗衣机', '2099.00', '2099.00', '100', '4', '/Apache/upload/item/user/product/2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c/2019042220212387361.jpg', '海尔洗衣机');
INSERT INTO `product` VALUES ('23', '2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', '海信洗衣机', '1599.00', '1599.00', '100', '4', '/Apache/upload/item/user/product/2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c/2019042220213831046.jpg', '海信洗衣机');
INSERT INTO `product` VALUES ('24', '2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', '美的洗衣机', '1599.00', '1599.00', '100', '4', '/Apache/upload/item/user/product/2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c/2019042220214792790.jpg', '美的洗衣机');
INSERT INTO `product` VALUES ('25', '2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', '小天鹅洗衣机', '4299.00', '4299.00', '100', '4', '/Apache/upload/item/user/product/2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c/2019042220220171904.jpg', '小天鹅洗衣机');
INSERT INTO `product` VALUES ('26', '2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', '云米洗衣机', '2999.00', '2999.00', '100', '4', '/Apache/upload/item/user/product/2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c/2019042220221443860.jpg', '云米洗衣机');
INSERT INTO `product` VALUES ('27', '33f3d6dd-187a-4bee-bae6-fec04f13903a', '林端沙发', '1197.93', '1197.93', '100', '11', '/Apache/upload/item/user/product/33f3d6dd-187a-4bee-bae6-fec04f13903a/2019042220235353547.jpg', '林端沙发');
INSERT INTO `product` VALUES ('28', '33f3d6dd-187a-4bee-bae6-fec04f13903a', '森林季节沙发', '2080.00', '2080.00', '100', '11', '/Apache/upload/item/user/product/33f3d6dd-187a-4bee-bae6-fec04f13903a/2019042220241124941.jpg', '森林季节沙发');
INSERT INTO `product` VALUES ('29', '33f3d6dd-187a-4bee-bae6-fec04f13903a', '优奕酷沙发', '3870.00', '3870.00', '100', '11', '/Apache/upload/item/user/product/33f3d6dd-187a-4bee-bae6-fec04f13903a/2019042220242341971.jpg', '优奕酷沙发');
INSERT INTO `product` VALUES ('30', '33f3d6dd-187a-4bee-bae6-fec04f13903a', '佐尔适沙发', '3100.00', '3100.00', '100', '11', '/Apache/upload/item/user/product/33f3d6dd-187a-4bee-bae6-fec04f13903a/2019042220243428493.jpg', '佐尔适沙发');
INSERT INTO `product` VALUES ('31', '46e0d845-b939-4e0d-84c3-bf43d0440ca5', '华为Matebook', '5699.00', '5699.00', '100', '10', '/Apache/upload/item/user/product/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220252556026.jpg', '华为Matebook');
INSERT INTO `product` VALUES ('32', '46e0d845-b939-4e0d-84c3-bf43d0440ca5', '惠普ENVY13', '6399.00', '6399.00', '100', '10', '/Apache/upload/item/user/product/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220254199327.jpg', '惠普ENVY13');
INSERT INTO `product` VALUES ('33', '46e0d845-b939-4e0d-84c3-bf43d0440ca5', '雷神911', '6099.00', '6099.00', '100', '10', '/Apache/upload/item/user/product/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220260862173.jpg', '雷神911');
INSERT INTO `product` VALUES ('34', '46e0d845-b939-4e0d-84c3-bf43d0440ca5', '联想小新潮7000', '5499.00', '5499.00', '100', '10', '/Apache/upload/item/user/product/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220262419829.jpg', '联想小新潮7000');
INSERT INTO `product` VALUES ('35', '46e0d845-b939-4e0d-84c3-bf43d0440ca5', '荣耀MagicBook', '3999.00', '3999.00', '100', '10', '/Apache/upload/item/user/product/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220263662377.jpg', '荣耀MagicBook');
INSERT INTO `product` VALUES ('36', '46e0d845-b939-4e0d-84c3-bf43d0440ca5', '小米笔记本Air', '5499.00', '5499.00', '100', '10', '/Apache/upload/item/user/product/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220265297536.jpg', '小米笔记本Air');
INSERT INTO `product` VALUES ('37', '4df7e762-0328-4257-8c9e-f453246043ba', '凡尔舍床', '2699.00', '2699.00', '100', '13', '/Apache/upload/item/user/product/4df7e762-0328-4257-8c9e-f453246043ba/2019042220275140632.jpg', '凡尔舍床');
INSERT INTO `product` VALUES ('38', '4df7e762-0328-4257-8c9e-f453246043ba', '华纳斯床', '1499.00', '1499.00', '100', '13', '/Apache/upload/item/user/product/4df7e762-0328-4257-8c9e-f453246043ba/2019042220280429275.jpg', '华纳斯床');
INSERT INTO `product` VALUES ('39', '4df7e762-0328-4257-8c9e-f453246043ba', '苏菲洛克床', '1799.00', '1799.00', '100', '13', '/Apache/upload/item/user/product/4df7e762-0328-4257-8c9e-f453246043ba/2019042220281745278.jpg', '苏菲洛克床');
INSERT INTO `product` VALUES ('40', '4df7e762-0328-4257-8c9e-f453246043ba', '新尚美家床', '269.00', '269.00', '100', '13', '/Apache/upload/item/user/product/4df7e762-0328-4257-8c9e-f453246043ba/2019042220282944739.jpg', '新尚美家床');
INSERT INTO `product` VALUES ('41', '7f4ec721-a4d7-4718-80cd-978af67578df', '阿迪达斯鞋子', '799.00', '799.00', '100', '17', '/Apache/upload/item/user/product/7f4ec721-a4d7-4718-80cd-978af67578df/2019042220291694342.jpg', '阿迪达斯鞋子');
INSERT INTO `product` VALUES ('42', '7f4ec721-a4d7-4718-80cd-978af67578df', '花花公子鞋子', '218.00', '218.00', '100', '17', '/Apache/upload/item/user/product/7f4ec721-a4d7-4718-80cd-978af67578df/2019042220292877192.jpg', '花花公子鞋子');
INSERT INTO `product` VALUES ('43', '7f4ec721-a4d7-4718-80cd-978af67578df', '骆驼鞋子', '139.00', '139.00', '100', '17', '/Apache/upload/item/user/product/7f4ec721-a4d7-4718-80cd-978af67578df/2019042220294046954.jpg', '骆驼鞋子');
INSERT INTO `product` VALUES ('44', '7f4ec721-a4d7-4718-80cd-978af67578df', '双星鞋子', '99.00', '99.00', '100', '17', '/Apache/upload/item/user/product/7f4ec721-a4d7-4718-80cd-978af67578df/2019042220295313422.jpg', '双星鞋子');
INSERT INTO `product` VALUES ('45', '7f4ec721-a4d7-4718-80cd-978af67578df', '特步鞋子', '159.00', '159.00', '100', '17', '/Apache/upload/item/user/product/7f4ec721-a4d7-4718-80cd-978af67578df/2019042220300590324.jpg', '特步鞋子');
INSERT INTO `product` VALUES ('46', '8ffae528-54e5-4db8-a73d-43f1c1a3711f', '海尔洗碗机', '1699.00', '1699.00', '100', '5', '/Apache/upload/item/user/product/8ffae528-54e5-4db8-a73d-43f1c1a3711f/2019042220311088723.jpg', '海尔洗碗机');
INSERT INTO `product` VALUES ('47', '8ffae528-54e5-4db8-a73d-43f1c1a3711f', '美的洗碗机', '1399.00', '1399.00', '100', '5', '/Apache/upload/item/user/product/8ffae528-54e5-4db8-a73d-43f1c1a3711f/2019042220312326762.jpg', '美的洗碗机');
INSERT INTO `product` VALUES ('48', '8ffae528-54e5-4db8-a73d-43f1c1a3711f', '松下洗碗机', '2999.00', '2999.00', '100', '5', '/Apache/upload/item/user/product/8ffae528-54e5-4db8-a73d-43f1c1a3711f/2019042220313511721.jpg', '松下洗碗机');
INSERT INTO `product` VALUES ('49', '8ffae528-54e5-4db8-a73d-43f1c1a3711f', '西门子洗碗机', '3999.00', '3999.00', '100', '5', '/Apache/upload/item/user/product/8ffae528-54e5-4db8-a73d-43f1c1a3711f/2019042220314640917.jpg', '西门子洗碗机');
INSERT INTO `product` VALUES ('50', '90025b39-7c63-4fdb-a485-4a06320726ff', 'Apple iPhone XS Max', '9699.00', '9699.00', '100', '8', '/Apache/upload/item/user/product/90025b39-7c63-4fdb-a485-4a06320726ff/2019042220323565104.jpg', 'Apple iPhone XS Max');
INSERT INTO `product` VALUES ('51', '90025b39-7c63-4fdb-a485-4a06320726ff', 'OPPO Reno', '3599.00', '3599.00', '100', '8', '/Apache/upload/item/user/product/90025b39-7c63-4fdb-a485-4a06320726ff/2019042220324990552.jpg', 'OPPO Reno');
INSERT INTO `product` VALUES ('52', '90025b39-7c63-4fdb-a485-4a06320726ff', '华为 HUAWEI P30 Pro', '5488.00', '5488.00', '100', '8', '/Apache/upload/item/user/product/90025b39-7c63-4fdb-a485-4a06320726ff/2019042220330657052.jpg', '华为 HUAWEI P30 Pro');
INSERT INTO `product` VALUES ('53', '90025b39-7c63-4fdb-a485-4a06320726ff', '三星 Galaxy S10+', '6999.00', '6999.00', '100', '8', '/Apache/upload/item/user/product/90025b39-7c63-4fdb-a485-4a06320726ff/2019042220332052835.jpg', '三星 Galaxy S10+');
INSERT INTO `product` VALUES ('54', '90025b39-7c63-4fdb-a485-4a06320726ff', '小米9', '2999.00', '2999.00', '100', '8', '/Apache/upload/item/user/product/90025b39-7c63-4fdb-a485-4a06320726ff/2019042220333387941.png', '小米9');
INSERT INTO `product` VALUES ('55', 'ccc7b97e-bce9-4daa-8312-1341cb1a752c', 'dickies帽子', '129.00', '129.00', '100', '18', '/Apache/upload/item/user/product/ccc7b97e-bce9-4daa-8312-1341cb1a752c/2019042220392324995.jpg', 'dickies帽子');
INSERT INTO `product` VALUES ('56', 'ccc7b97e-bce9-4daa-8312-1341cb1a752c', 'MLB帽子', '358.00', '358.00', '100', '18', '/Apache/upload/item/user/product/ccc7b97e-bce9-4daa-8312-1341cb1a752c/2019042220393672380.jpg', 'MLB帽子');
INSERT INTO `product` VALUES ('57', 'ccc7b97e-bce9-4daa-8312-1341cb1a752c', 'U.S.POLO帽子', '99.00', '99.00', '100', '18', '/Apache/upload/item/user/product/ccc7b97e-bce9-4daa-8312-1341cb1a752c/2019042220394869254.jpg', 'U.S.POLO帽子');
INSERT INTO `product` VALUES ('58', 'ccc7b97e-bce9-4daa-8312-1341cb1a752c', 'Under Armour帽子', '229.00', '229.00', '100', '18', '/Apache/upload/item/user/product/ccc7b97e-bce9-4daa-8312-1341cb1a752c/2019042220400258802.jpg', 'Under Armour帽子');
INSERT INTO `product` VALUES ('59', 'ccc7b97e-bce9-4daa-8312-1341cb1a752c', '浩冠帽子', '42.00', '42.00', '100', '18', '/Apache/upload/item/user/product/ccc7b97e-bce9-4daa-8312-1341cb1a752c/2019042220401231432.jpg', '浩冠帽子');
INSERT INTO `product` VALUES ('60', 'ead1026e-d24a-4357-b04f-8a209a08729e', '奥克斯空调', '6999.00', '6999.00', '100', '6', '/Apache/upload/item/user/product/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220405928107.jpg', '奥克斯空调');
INSERT INTO `product` VALUES ('61', 'ead1026e-d24a-4357-b04f-8a209a08729e', '格力空调', '2299.00', '2299.00', '100', '6', '/Apache/upload/item/user/product/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220411169290.jpg', '格力空调');
INSERT INTO `product` VALUES ('62', 'ead1026e-d24a-4357-b04f-8a209a08729e', '美的空调', '1899.00', '1899.00', '100', '6', '/Apache/upload/item/user/product/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220412518945.jpg', '美的空调');
INSERT INTO `product` VALUES ('63', 'ead1026e-d24a-4357-b04f-8a209a08729e', '扬子空调', '1299.00', '1299.00', '100', '6', '/Apache/upload/item/user/product/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220413916184.jpg', '扬子空调');
INSERT INTO `product` VALUES ('64', 'ead1026e-d24a-4357-b04f-8a209a08729e', '长虹空调', '1299.00', '1299.00', '100', '6', '/Apache/upload/item/user/product/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220415040500.jpg', '长虹空调');
INSERT INTO `product` VALUES ('65', 'ead1026e-d24a-4357-b04f-8a209a08729e', '志高空调', '1499.00', '1499.00', '100', '6', '/Apache/upload/item/user/product/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220420150024.jpg', '志高空调');
INSERT INTO `product` VALUES ('66', 'f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '蔓斯菲尔桌子', '119.00', '119.00', '100', '19', '/Apache/upload/item/user/product/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220432126691.jpg', '蔓斯菲尔桌子');
INSERT INTO `product` VALUES ('67', 'f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '木以成居桌子', '159.00', '159.00', '100', '19', '/Apache/upload/item/user/product/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220433370641.jpg', '木以成居桌子');
INSERT INTO `product` VALUES ('68', 'f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '帅力桌子', '129.00', '129.00', '100', '19', '/Apache/upload/item/user/product/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220434472952.jpg', '帅力桌子');
INSERT INTO `product` VALUES ('69', 'f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '听竹轩桌子', '131.40', '131.40', '100', '19', '/Apache/upload/item/user/product/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220435745197.jpg', '听竹轩桌子');
INSERT INTO `product` VALUES ('70', 'f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '香可桌子', '199.00', '199.00', '100', '19', '/Apache/upload/item/user/product/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220441243063.jpg', '香可桌子');
INSERT INTO `product` VALUES ('71', 'f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '雅美乐桌子', '169.00', '169.00', '100', '19', '/Apache/upload/item/user/product/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220442660593.jpg', '雅美乐桌子');
INSERT INTO `product` VALUES ('72', 'fbd238fb-b401-4cb6-bbff-b171472af0eb', '傲风AutoFul椅子', '1289.00', '1289.00', '100', '12', '/Apache/upload/item/user/product/fbd238fb-b401-4cb6-bbff-b171472af0eb/2019042220451521759.jpg', '傲风AutoFul椅子');
INSERT INTO `product` VALUES ('73', 'fbd238fb-b401-4cb6-bbff-b171472af0eb', '得力椅子', '459.00', '459.00', '100', '12', '/Apache/upload/item/user/product/fbd238fb-b401-4cb6-bbff-b171472af0eb/2019042220452721017.jpg', '得力椅子');
INSERT INTO `product` VALUES ('74', 'fbd238fb-b401-4cb6-bbff-b171472af0eb', '华恺之星椅子', '168.00', '168.00', '100', '12', '/Apache/upload/item/user/product/fbd238fb-b401-4cb6-bbff-b171472af0eb/2019042220454030621.jpg', '华恺之星椅子');
INSERT INTO `product` VALUES ('75', 'fbd238fb-b401-4cb6-bbff-b171472af0eb', '联丰椅子', '298.00', '298.00', '100', '12', '/Apache/upload/item/user/product/fbd238fb-b401-4cb6-bbff-b171472af0eb/2019042220455131285.jpg', '联丰椅子');
INSERT INTO `product` VALUES ('76', 'fbd238fb-b401-4cb6-bbff-b171472af0eb', '泉枫椅子', '109.00', '109.00', '100', '12', '/Apache/upload/item/user/product/fbd238fb-b401-4cb6-bbff-b171472af0eb/2019042220460528086.jpg', '泉枫椅子');

-- ----------------------------
-- Table structure for productbigcategory
-- ----------------------------
DROP TABLE IF EXISTS `productbigcategory`;
CREATE TABLE `productbigcategory` (
  `product_big_category_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_big_category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`product_big_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productbigcategory
-- ----------------------------
INSERT INTO `productbigcategory` VALUES ('1', '家用电器');
INSERT INTO `productbigcategory` VALUES ('2', '数码');
INSERT INTO `productbigcategory` VALUES ('3', '家居');
INSERT INTO `productbigcategory` VALUES ('4', '服装');
INSERT INTO `productbigcategory` VALUES ('5', '食品');
INSERT INTO `productbigcategory` VALUES ('6', '文娱');
INSERT INTO `productbigcategory` VALUES ('7', '其他');

-- ----------------------------
-- Table structure for productcategory
-- ----------------------------
DROP TABLE IF EXISTS `productcategory`;
CREATE TABLE `productcategory` (
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_big_category_id` int(11) NOT NULL,
  `product_category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productcategory
-- ----------------------------
INSERT INTO `productcategory` VALUES ('3', '1', '电视机');
INSERT INTO `productcategory` VALUES ('4', '1', '洗衣机');
INSERT INTO `productcategory` VALUES ('5', '1', '洗碗机');
INSERT INTO `productcategory` VALUES ('6', '1', '空调');
INSERT INTO `productcategory` VALUES ('8', '2', '手机');
INSERT INTO `productcategory` VALUES ('9', '2', '相机');
INSERT INTO `productcategory` VALUES ('10', '2', '笔记本');
INSERT INTO `productcategory` VALUES ('11', '3', '沙发');
INSERT INTO `productcategory` VALUES ('12', '3', '椅子');
INSERT INTO `productcategory` VALUES ('13', '3', '床');
INSERT INTO `productcategory` VALUES ('17', '4', '鞋子');
INSERT INTO `productcategory` VALUES ('18', '4', '帽子');
INSERT INTO `productcategory` VALUES ('19', '3', '桌子');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_user_id` varchar(255) NOT NULL,
  `shop_category` int(11) NOT NULL,
  `shop_name` varchar(255) NOT NULL,
  `shop_desc` text NOT NULL,
  `shop_address` varchar(255) NOT NULL,
  `shop_phone` varchar(255) NOT NULL,
  `shop_image` varchar(255) NOT NULL,
  `shop_status` int(11) NOT NULL DEFAULT '0',
  `shop_createtime` datetime DEFAULT NULL,
  `shop_last_edit_time` datetime DEFAULT NULL,
  `shop_priority` int(11) NOT NULL DEFAULT '0',
  `shop_level` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`shop_id`,`shop_name`),
  UNIQUE KEY `shop_user_id` (`shop_user_id`),
  UNIQUE KEY `shop_name` (`shop_name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('11', '062ef099-6880-46bb-9b12-12de10d3754a', '0', '电视机', '一个电视机店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/062ef099-6880-46bb-9b12-12de10d3754a/2019042220133962998.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('12', '09412935-3a7e-4d57-bc25-a96700529421', '0', '相机', '一个相机店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/09412935-3a7e-4d57-bc25-a96700529421/2019042220174888249.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('13', '2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', '0', '洗衣机', '一个洗衣机店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c/2019042220205731427.jpeg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('14', '33f3d6dd-187a-4bee-bae6-fec04f13903a', '0', '沙发', '一个沙发店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/33f3d6dd-187a-4bee-bae6-fec04f13903a/2019042220232750224.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('15', '46e0d845-b939-4e0d-84c3-bf43d0440ca5', '0', '笔记本', '一个笔记本店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220250368771.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('16', '4df7e762-0328-4257-8c9e-f453246043ba', '0', '床', '一个床店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/4df7e762-0328-4257-8c9e-f453246043ba/2019042220273132018.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('17', '7f4ec721-a4d7-4718-80cd-978af67578df', '0', '鞋子', '一个鞋子店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/7f4ec721-a4d7-4718-80cd-978af67578df/2019042220285610174.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('18', '8ffae528-54e5-4db8-a73d-43f1c1a3711f', '0', '洗碗机', '一个洗碗机店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/8ffae528-54e5-4db8-a73d-43f1c1a3711f/2019042220304870195.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('19', '90025b39-7c63-4fdb-a485-4a06320726ff', '0', '手机', '一个手机店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/90025b39-7c63-4fdb-a485-4a06320726ff/2019042220321380451.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('20', 'ccc7b97e-bce9-4daa-8312-1341cb1a752c', '0', '帽子', '一个帽子店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/ccc7b97e-bce9-4daa-8312-1341cb1a752c/2019042220390373237.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('21', 'ead1026e-d24a-4357-b04f-8a209a08729e', '0', '空调', '一个空调店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220404034516.jpg', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('22', 'f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '0', '桌子', '一个桌子店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220430037832.gif', '0', null, null, '0', '1');
INSERT INTO `shop` VALUES ('23', 'fbd238fb-b401-4cb6-bbff-b171472af0eb', '0', '椅子', '一个椅子店铺', '重庆永川', '110', '/Apache/upload/item/user/shop/fbd238fb-b401-4cb6-bbff-b171472af0eb/2019042220445634779.jpg', '0', null, null, '0', '1');

-- ----------------------------
-- Table structure for shopcategory
-- ----------------------------
DROP TABLE IF EXISTS `shopcategory`;
CREATE TABLE `shopcategory` (
  `shop_category_id` int(11) NOT NULL,
  `shop_category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`shop_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcategory
-- ----------------------------

-- ----------------------------
-- Table structure for useraddress
-- ----------------------------
DROP TABLE IF EXISTS `useraddress`;
CREATE TABLE `useraddress` (
  `user_address_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_address_user_id` varchar(50) NOT NULL,
  `user_address_name` varchar(255) NOT NULL,
  `user_address_phone` varchar(255) NOT NULL,
  `user_address_address` varchar(255) NOT NULL,
  PRIMARY KEY (`user_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of useraddress
-- ----------------------------

-- ----------------------------
-- Table structure for usercheck
-- ----------------------------
DROP TABLE IF EXISTS `usercheck`;
CREATE TABLE `usercheck` (
  `user_id` varchar(50) NOT NULL,
  `user_username` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`user_username`),
  UNIQUE KEY `user_username` (`user_username`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usercheck
-- ----------------------------
INSERT INTO `usercheck` VALUES ('062ef099-6880-46bb-9b12-12de10d3754a', 'dianshiji', 'dianshiji');
INSERT INTO `usercheck` VALUES ('09412935-3a7e-4d57-bc25-a96700529421', 'xiangji', 'xiangji');
INSERT INTO `usercheck` VALUES ('2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', 'xiyiji', 'xiyiji');
INSERT INTO `usercheck` VALUES ('33f3d6dd-187a-4bee-bae6-fec04f13903a', 'shafa', 'shafa');
INSERT INTO `usercheck` VALUES ('46e0d845-b939-4e0d-84c3-bf43d0440ca5', 'bijiben', 'bijiben');
INSERT INTO `usercheck` VALUES ('4df7e762-0328-4257-8c9e-f453246043ba', 'chuang', 'chuang');
INSERT INTO `usercheck` VALUES ('7f4ec721-a4d7-4718-80cd-978af67578df', 'xiezi', 'xiezi');
INSERT INTO `usercheck` VALUES ('8ffae528-54e5-4db8-a73d-43f1c1a3711f', 'xiwanji', 'xiwanji');
INSERT INTO `usercheck` VALUES ('90025b39-7c63-4fdb-a485-4a06320726ff', 'shouji', 'shouji');
INSERT INTO `usercheck` VALUES ('ccc7b97e-bce9-4daa-8312-1341cb1a752c', 'maozi', 'maozi');
INSERT INTO `usercheck` VALUES ('e35aec26-5213-4eb3-8d4e-b74a4901b8b9', 'admin', 'admin');
INSERT INTO `usercheck` VALUES ('ead1026e-d24a-4357-b04f-8a209a08729e', 'kongtiao', 'kongtiao');
INSERT INTO `usercheck` VALUES ('f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', 'zhuozi', 'zhuozi');
INSERT INTO `usercheck` VALUES ('fbd238fb-b401-4cb6-bbff-b171472af0eb', 'yizi', 'yizi');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_phone` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_head_image` varchar(255) NOT NULL,
  `user_default_address` int(11) NOT NULL,
  `user_status` int(11) NOT NULL,
  `user_apply_shop` int(1) NOT NULL DEFAULT '0',
  `user_type` int(11) NOT NULL,
  `user_createtime` datetime NOT NULL,
  `user_last_edit_time` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('062ef099-6880-46bb-9b12-12de10d3754a', '电视机', '110', '597973086@qq.com', '/Apache/upload/item/user/head/062ef099-6880-46bb-9b12-12de10d3754a/2019042220075871093.jpg', '0', '1', '1', '0', '2019-04-22 20:07:59', '2019-04-22 20:07:59');
INSERT INTO `userinfo` VALUES ('09412935-3a7e-4d57-bc25-a96700529421', '相机', '110', '597973086@qq.com', '/Apache/upload/item/user/head/09412935-3a7e-4d57-bc25-a96700529421/2019042220084898333.jpg', '0', '1', '1', '0', '2019-04-22 20:08:48', '2019-04-22 20:08:48');
INSERT INTO `userinfo` VALUES ('2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c', '洗衣机', '110', '597973086@qq.com', '/Apache/upload/item/user/head/2eaa4c2a-dcdb-479f-9f3d-4ff8e22bdf9c/2019042220071639047.jpg', '0', '1', '1', '0', '2019-04-22 20:07:17', '2019-04-22 20:07:17');
INSERT INTO `userinfo` VALUES ('33f3d6dd-187a-4bee-bae6-fec04f13903a', '沙发', '110', '597973086@qq.com', '/Apache/upload/item/user/head/33f3d6dd-187a-4bee-bae6-fec04f13903a/2019042220112065410.jpg', '0', '1', '1', '0', '2019-04-22 20:11:20', '2019-04-22 20:11:20');
INSERT INTO `userinfo` VALUES ('46e0d845-b939-4e0d-84c3-bf43d0440ca5', '笔记本', '110', '597973086@qq.com', '/Apache/upload/item/user/head/46e0d845-b939-4e0d-84c3-bf43d0440ca5/2019042220083081198.jpg', '0', '1', '1', '0', '2019-04-22 20:08:30', '2019-04-22 20:08:30');
INSERT INTO `userinfo` VALUES ('4df7e762-0328-4257-8c9e-f453246043ba', '床', '110', '597973086@qq.com', '/Apache/upload/item/user/head/4df7e762-0328-4257-8c9e-f453246043ba/2019042220103246708.jpg', '0', '1', '1', '0', '2019-04-22 20:10:32', '2019-04-22 20:10:32');
INSERT INTO `userinfo` VALUES ('7f4ec721-a4d7-4718-80cd-978af67578df', '鞋子', '110', '597973086@qq.com', '/Apache/upload/item/user/head/7f4ec721-a4d7-4718-80cd-978af67578df/2019042220120393579.png', '0', '1', '1', '0', '2019-04-22 20:12:03', '2019-04-22 20:12:03');
INSERT INTO `userinfo` VALUES ('8ffae528-54e5-4db8-a73d-43f1c1a3711f', '洗碗机', '110', '597973086@qq.com', '/Apache/upload/item/user/head/8ffae528-54e5-4db8-a73d-43f1c1a3711f/2019042220062221884.jpg', '0', '1', '1', '0', '2019-04-22 20:06:22', '2019-04-22 20:06:22');
INSERT INTO `userinfo` VALUES ('90025b39-7c63-4fdb-a485-4a06320726ff', '手机', '110', '597973086@qq.com', '/Apache/upload/item/user/head/90025b39-7c63-4fdb-a485-4a06320726ff/2019042220090686393.jpg', '0', '1', '1', '0', '2019-04-22 20:09:07', '2019-04-22 20:09:07');
INSERT INTO `userinfo` VALUES ('ccc7b97e-bce9-4daa-8312-1341cb1a752c', '帽子', '110', '597973086@qq.com', '/Apache/upload/item/user/head/ccc7b97e-bce9-4daa-8312-1341cb1a752c/2019042220113616492.jpg', '0', '1', '1', '0', '2019-04-22 20:11:37', '2019-04-22 20:11:37');
INSERT INTO `userinfo` VALUES ('e35aec26-5213-4eb3-8d4e-b74a4901b8b9', 'admin', '110', '597973086@qq.com', '/Apache/upload/item/user/head/e35aec26-5213-4eb3-8d4e-b74a4901b8b9/2019041516030073171.jpg', '0', '1', '0', '2', '2019-04-15 16:03:00', '2019-04-15 16:03:00');
INSERT INTO `userinfo` VALUES ('ead1026e-d24a-4357-b04f-8a209a08729e', '空调', '110', '597973086@qq.com', '/Apache/upload/item/user/head/ead1026e-d24a-4357-b04f-8a209a08729e/2019042220044771436.jpg', '0', '1', '1', '0', '2019-04-22 20:04:48', '2019-04-22 20:04:48');
INSERT INTO `userinfo` VALUES ('f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e', '桌子', '110', '597973086@qq.com', '/Apache/upload/item/user/head/f2f280fa-cd56-4d2f-8ec7-d3b79ecc497e/2019042220101180633.png', '0', '1', '1', '0', '2019-04-22 20:10:11', '2019-04-22 20:10:11');
INSERT INTO `userinfo` VALUES ('fbd238fb-b401-4cb6-bbff-b171472af0eb', '椅子', '110', '597973086@qq.com', '/Apache/upload/item/user/head/fbd238fb-b401-4cb6-bbff-b171472af0eb/2019042220105726992.jpg', '0', '1', '1', '0', '2019-04-22 20:10:58', '2019-04-22 20:10:58');

-- ----------------------------
-- Table structure for userorder
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `order_id` varchar(255) NOT NULL,
  `order_payment_amount` double(10,2) NOT NULL,
  `order_createtime` datetime NOT NULL,
  `order_status` int(11) NOT NULL,
  `order_logistics` varchar(255) DEFAULT NULL,
  `order_user_id` varchar(255) NOT NULL,
  `order_user_address` varchar(255) NOT NULL,
  `order_comment` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userorder
-- ----------------------------
