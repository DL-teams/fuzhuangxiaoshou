/*
 Navicat Premium Data Transfer

 Source Server         : dezhou
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 14/08/2022 08:47:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', 'admin');
INSERT INTO `admin_user` VALUES (2, '1212', 'hzlll');

-- ----------------------------
-- Table structure for classification
-- ----------------------------
DROP TABLE IF EXISTS `classification`;
CREATE TABLE `classification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classification
-- ----------------------------
INSERT INTO `classification` VALUES (1, '男装', 0, 1);
INSERT INTO `classification` VALUES (2, '女装', 0, 1);
INSERT INTO `classification` VALUES (3, '童装', 0, 1);
INSERT INTO `classification` VALUES (4, '男鞋', 0, 1);
INSERT INTO `classification` VALUES (5, '女鞋', 0, 1);
INSERT INTO `classification` VALUES (6, '童鞋', 0, 1);
INSERT INTO `classification` VALUES (7, 'T恤衫', 1, 2);
INSERT INTO `classification` VALUES (8, '牛仔裤', 1, 2);
INSERT INTO `classification` VALUES (9, '休闲裤', 1, 2);
INSERT INTO `classification` VALUES (10, '衬衫', 1, 2);
INSERT INTO `classification` VALUES (11, '短裤', 1, 2);
INSERT INTO `classification` VALUES (12, '真皮皮衣', 1, 2);
INSERT INTO `classification` VALUES (13, '夹克', 1, 2);
INSERT INTO `classification` VALUES (14, '连衣裙', 2, 2);
INSERT INTO `classification` VALUES (15, '汉服', 2, 2);
INSERT INTO `classification` VALUES (16, '正装裤', 2, 2);
INSERT INTO `classification` VALUES (17, '礼服', 2, 2);
INSERT INTO `classification` VALUES (18, '羊绒衫', 2, 2);
INSERT INTO `classification` VALUES (19, '毛衣', 2, 2);
INSERT INTO `classification` VALUES (20, '婚纱', 2, 2);
INSERT INTO `classification` VALUES (21, '亲子装', 3, 2);
INSERT INTO `classification` VALUES (22, '卫衣', 3, 2);
INSERT INTO `classification` VALUES (23, '外套', 3, 2);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_time` datetime(0) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `total` double NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (21, '德州市德城区', '何作龙', '2022-07-25 11:25:55', '15252456985', 4, 99, 15);
INSERT INTO `order` VALUES (22, '山东', '何', '2022-07-27 09:37:52', '1211212', 4, 366, 15);
INSERT INTO `order` VALUES (23, 'qqq', 'qqq', '2022-07-27 09:51:47', 'qqq', 6, 666, 15);
INSERT INTO `order` VALUES (24, 'qq', 'qq', '2022-08-01 16:26:44', 'qq', 6, 366, 15);
INSERT INTO `order` VALUES (25, '北京市朝阳区', '小明', '2022-08-04 19:00:35', '78542514587', 6, 366, 15);
INSERT INTO `order` VALUES (26, '上海', '小刚', '2022-08-05 14:45:51', '11111', 1, 4952, 16);
INSERT INTO `order` VALUES (27, '上海', '小刚', '2022-08-05 14:47:09', '2323232', 1, 5618, 16);
INSERT INTO `order` VALUES (28, '上海', '小刚', '2022-08-05 14:50:38', '11111', 1, 99, 16);
INSERT INTO `order` VALUES (29, 'ssss', 'QST', '2022-08-10 15:12:16', '123456', 2, 666, 15);
INSERT INTO `order` VALUES (30, '123', '124', '2022-08-10 22:00:07', '12345', 1, 2664, 15);
INSERT INTO `order` VALUES (31, '青岛青劝实训', '何作龙', '2022-08-11 21:44:11', '123232122', 1, 1431, 15);
INSERT INTO `order` VALUES (32, '青岛青软实训', '侯春妍', '2022-08-11 21:46:50', '123231111', 1, 266, 15);
INSERT INTO `order` VALUES (33, 'qwqw', 'wewe', '2022-08-13 19:34:07', '1212', 1, 666, 15);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `sub_total` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (34, 1, 21, 22, 99);
INSERT INTO `order_item` VALUES (35, 1, 22, 24, 366);
INSERT INTO `order_item` VALUES (36, 1, 23, 31, 666);
INSERT INTO `order_item` VALUES (37, 1, 24, 24, 366);
INSERT INTO `order_item` VALUES (38, 1, 25, 24, 366);
INSERT INTO `order_item` VALUES (39, 1, 26, 24, 366);
INSERT INTO `order_item` VALUES (40, 1, 26, 25, 4586);
INSERT INTO `order_item` VALUES (41, 1, 27, 23, 666);
INSERT INTO `order_item` VALUES (42, 1, 27, 24, 366);
INSERT INTO `order_item` VALUES (43, 1, 27, 25, 4586);
INSERT INTO `order_item` VALUES (44, 1, 28, 22, 99);
INSERT INTO `order_item` VALUES (45, 1, 29, 23, 666);
INSERT INTO `order_item` VALUES (46, 3, 30, 23, 2664);
INSERT INTO `order_item` VALUES (47, 1, 31, 22, 99);
INSERT INTO `order_item` VALUES (48, 2, 31, 23, 1332);
INSERT INTO `order_item` VALUES (49, 1, 32, 30, 266);
INSERT INTO `order_item` VALUES (50, 1, 33, 23, 666);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `csid` int(11) NULL DEFAULT NULL,
  `desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_hot` int(11) NULL DEFAULT NULL,
  `market_price` double NULL DEFAULT NULL,
  `pdate` datetime(0) NULL DEFAULT NULL,
  `shop_price` bigint(20) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (21, 7, '衬衫是一种穿在内外上衣之间、也可单独穿用的上衣，男衬衫通常胸前有口袋，袖口有袖头。\r\n穿出你的气质！', '/mall/admin/product/img/CCA4753C8B3C57D67E332935BB1CC3.webp', 0, 689, '2022-08-04 10:29:04', 399, '条形衬衫');
INSERT INTO `product` VALUES (22, 11, 'SUMMER COURT SWEAT SHORTS男子短裤是彪马品牌旗下的一款产品.', '/mall/admin/product/img/7F36E33D186A72079ED6A45046F4DD.jfif', 1, 200, '2022-08-01 13:16:20', 99, '男性短裤');
INSERT INTO `product` VALUES (23, 8, '字母印花半短袖T恤男加肥加大码ins潮流胖子宽松圆领港风夏装高街\r\n描述 ：短袖T恤在夏季一直都是bi备的款式啦，这款灰常喜欢哦，简单又好看的款式背后字母发泡印花设计也是灰常好看的哦，这样就不会显得衣服太多单调啦', '/mall/admin/product/img/8C1B9C420CCE734988CAAC69ED4FF6.jpg', 1, 1000, '2022-08-01 13:16:31', 666, '牛仔裤');
INSERT INTO `product` VALUES (24, 10, '潮流标识款衬衫长袖af衬衣商务大码男纯棉\r\n描述：有良好的染色性能和色牢度，色彩更浓厚、色效更持久，除了透气，还能快速的吸收人体的汗液，保持清爽舒适!', '/mall/admin/product/img/3F42097CE82571DDCB64A1CE6C352B.png', 1, 689, '2022-08-01 13:16:50', 366, '衬衫');
INSERT INTO `product` VALUES (25, 11, '高街出品Travis Scott风格机能风多拉链口袋ins潮人短裤\r\n描述：简洁而随性的没计呈现出，惬意的街头氛围，轻松展现出品牌在塑造都市潮男形象方面的随性、不羁，同时又契合品牌的时尚前卫', '/mall/admin/product/img/7A4E226E20221328F1CD64ACF05123.png', 1, 5585, '2022-08-01 13:16:58', 4586, '短裤');
INSERT INTO `product` VALUES (26, 12, '油蜡马皮调度员复古咔叽 马皮真皮皮衣百搭男士翻领外套\r\n描述：2mm厚度的混有鞣制马皮﹐这种马皮皮革原生态文理自丝，毛孔面不做任何修饰打磨保持粒面﹐光鞣制原色植鞣革再进行二次透染色﹑最后再进行油蜡浸染。皮革硬度中等上身穿着驯化速度较快。', '/mall/admin/product/img/8933A6964D0C78BCAE257324679E01.png', 0, 19999, '2022-08-01 13:17:06', 6666, '夹克');
INSERT INTO `product` VALUES (27, 14, '轻熟风法式连衣裙设计感气质高端衬衫半裙通勤小众夏两件套装裙子\r\n描述：用这样的一款套装来诠释你的沉静优雅，穿着好看舒适才是它的重点，领口圆扣让英气与知性兼具，好看到不行，好穿惬意，年轻又显精神，高腰伞摆裙型裙摆有挺括度，长度恰好，该遮的地方正好遮住把细细的小腿显出来显瘦、显高挑。', '/mall/admin/product/img/A30BABF88CB12DF2A9724E0C549CC7.png', 1, 1212, '2022-08-01 13:17:19', 999, '连衣裙');
INSERT INTO `product` VALUES (28, 15, '汉服，全称是“汉民族传统服饰”，又称汉衣冠、汉装，是从黄帝即位到公元17世纪中叶（明末清初），在汉族的主要居住区，以”华夏－汉”文化为背景和主导思想，以华夏礼仪文化为中心，通过自然演化而形成的具有独特汉民族风貌性格，明显区别于其他民族的传统服装和配饰体系，是中国“衣冠上国”、“礼仪之邦”、“锦绣中华”的体现，承载了汉族的染织绣等杰出工艺和美学，传承了30多项中国非物质文化遗产以及受保护的中国工艺美术。', '/mall/admin/product/img/6B133DA470AA230BDD26253BD179D6.png', 0, 1212, '2022-08-01 14:22:05', 555, '汉服');
INSERT INTO `product` VALUES (29, 16, '正装西裤，其实也就是我们常见的职场西裤，也是日常穿着率最高的西裤。因为工作或者商务场合的需要，所以它们的设计一般是中规中矩，略为保守的西裤版型。颜色多为纯色深色面料或者带一些涤纶丝的细条纹装饰。规矩，也有规矩的好处。西裤，有一个最大的特点，那就是可以很好的修饰你的腿型。正装西裤自然清爽的悬垂感，能很好的掩盖住X型腿或者是O型腿，这也是为什么企业都鼓励或者要求员工上班需要穿制服的原因。一般正装西裤冬天采用羊毛面料，夏天会为了带来凉爽的感觉，在羊毛中加入少量的丝绸。而且正装西裤制作考究，颜色多为深色，而且多为素色，可以是深色的细条纹细格子纹路，但一般不会出现大格子图案。正装西裤会用包边或者法式双缝线缝边。', '/mall/admin/product/img/75EB2B311924B7C46CA77F2691D662.png', 0, 689, '2022-08-01 14:22:14', 333, '正装西裤');
INSERT INTO `product` VALUES (30, 18, '羊绒衫，是以山羊绒为原料针织而成的服装。根据纱线类别分为粗纺针织和精纺针织两种，根据原料比例可以分为纯羊绒及羊绒混纺两种。大众款式多为v型领套头衫、开衫、圆领套衫等。具有山羊绒本身的白、青、紫等天然色彩，也可染色。手感细软、柔滑，有光泽，保暖性好，穿着舒适。', '/mall/admin/product/img/DDCB8AE23DABFA981D940D2032A661.png', 1, 600, '2022-08-01 14:22:31', 266, '羊绒衫');
INSERT INTO `product` VALUES (31, 19, '手工编织本来就是一种靠智慧和耐力，一针一线完成的工艺美术品。一个编织者经过反复构思、设计、施工，才能把精美真品奉献给每一位受益者。她给您带来自豪、美丽与幸福。一件精美的手工编织毛衣，也和羊毛衫、名牌西服一样，会给你带来自信、成功和喜悦。既便如此，这其中，编织者要付出多少的艰辛和耗费去多少宝贵的时间。然而，这就要求编织者们要尽全力的去研究开发，尽力改善右手挂线这一传统的编织方法。', '/mall/admin/product/img/61568103EC9F3621024265ABF7D981.png', 1, 1000, '2022-08-01 14:22:46', 666, '毛衣');
INSERT INTO `product` VALUES (32, 22, '春秋季节卫衣是首选，卫衣一般显得宽大舒适，是休闲类服饰中很受欢迎的服饰。时尚：卫衣能兼顾时尚性与功能性。由于融合舒适与时尚，卫衣成了各年龄段运动者的首选装备。个性：卫衣的涂鸦设计彰显了年轻的个性，舒适的穿着是休闲运动的最佳装备。百搭：卫衣配搭简单，运动裤，牛仔裤，还是裙子都可以搭出轻松的时尚感。', '/mall/admin/product/img/B3D9C8BD2090C01B0F6415EE0EE900.png', 1, 4545, '2022-08-01 14:23:00', 999, '卫衣');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (15, '山东省德州市德城区', '123@163.com', '何作龙', '123456', '15245252587', '龍王');
INSERT INTO `user` VALUES (16, '上海', '7878we@163.com', '罗大佑', '123456', '15248547584', '马鞍山');
INSERT INTO `user` VALUES (17, '123', '123@163.com', 'qwe', 'AADC03FECCA9B5CC2FD64B333CB0875E', '12345678978', '测试1');

SET FOREIGN_KEY_CHECKS = 1;
