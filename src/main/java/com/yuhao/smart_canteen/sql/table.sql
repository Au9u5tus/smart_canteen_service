CREATE TABLE USER (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '用户ID',
	student_id VARCHAR ( 50 ) NOT NULL UNIQUE COMMENT '学号',
	username VARCHAR ( 50 ) NOT NULL UNIQUE COMMENT '用户名',
	PASSWORD VARCHAR ( 255 ) NOT NULL COMMENT '密码',
	NAME VARCHAR ( 100 ) NOT NULL COMMENT '真实姓名',
	gender VARCHAR ( 2 ) NOT NULL COMMENT '性别',
	point INT ( 10 ) NOT NULL COMMENT '积分',
	phone VARCHAR ( 20 ) COMMENT '联系电话',
	email VARCHAR ( 100 ) UNIQUE COMMENT '电子邮件地址',
	avatar VARCHAR ( 255 ) COMMENT '头像',
	role VARCHAR ( 2 ) NOT NULL DEFAULT '1' COMMENT '角色',
	reg_date VARCHAR ( 20 ) NOT NULL COMMENT '注册系统的日期',
	last_login VARCHAR ( 20 ) NOT NULL COMMENT '最后登录系统的时间',
	STATUS VARCHAR ( 2 ) DEFAULT '1' COMMENT '用户账号的状态'
);
CREATE TABLE dish (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '菜单唯一标识符，作为主键',
	NAME VARCHAR ( 100 ) NOT NULL COMMENT '菜单名称',
	description TEXT COMMENT '菜单描述',
	price FLOAT ( 10 ) NOT NULL COMMENT '菜品价格',
	category VARCHAR ( 2 ) NOT NULL COMMENT '菜品分类',
	image_url_first VARCHAR ( 255 ) COMMENT '菜品主图的 URL',
	image_url_second VARCHAR ( 255 ) COMMENT '菜品的第二张图',
	image_url_third VARCHAR ( 255 ) COMMENT '菜品的第三张图',
	image_url_forth VARCHAR ( 255 ) COMMENT '菜品的第四张图',
	available BOOLEAN DEFAULT TRUE COMMENT '菜品是否可用',
	create_date VARCHAR ( 255 ) COMMENT '菜品创建日期',
	update_date VARCHAR ( 255 ) COMMENT '菜品更新日期'
);
CREATE TABLE orders (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '订单ID',
	user_id VARCHAR ( 50 ) NOT NULL COMMENT '用户ID',
	dish_id VARCHAR ( 50 ) NOT NULL COMMENT '菜品ID',
	quantity INT NOT NULL COMMENT '菜品的数量',
	order_time VARCHAR ( 20 ) NOT NULL COMMENT '订单生成时间',
	total_price FLOAT ( 10 ) NOT NULL COMMENT '订单的总价',
	STATUS VARCHAR ( 2 ) DEFAULT '1' COMMENT '订单状态',
	pay_method VARCHAR ( 2 ) DEFAULT '1' COMMENT '支付方式',
	address VARCHAR ( 255 ) COMMENT '送餐地址',
	del_time VARCHAR ( 20 ) NOT NULL COMMENT '预计送餐时间',
	del_status VARCHAR ( 2 ) DEFAULT '1' COMMENT '送餐状态',
	FOREIGN KEY ( user_id ) REFERENCES USER ( id ),
	FOREIGN KEY ( dish_id ) REFERENCES dish ( id )
);
CREATE TABLE order_details (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '订单详情ID',
	order_id VARCHAR ( 50 ) NOT NULL COMMENT '订单ID',
	dish_id VARCHAR ( 50 ) NOT NULL COMMENT '菜品ID',
	quantity INT NOT NULL COMMENT '菜品订单中的数量',
	unit_price FLOAT NOT NULL COMMENT '该菜品的单价',
	sub_total FLOAT NOT NULL COMMENT '该菜品的小计金额',
	FOREIGN KEY ( order_id ) REFERENCES orders ( id ),
	FOREIGN KEY ( dish_id ) REFERENCES menu ( id )
);
CREATE TABLE delivery (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '配送ID',
	order_id VARCHAR ( 50 ) NOT NULL COMMENT '订单ID',
	person_id VARCHAR ( 50 ) COMMENT '配送人员ID',
	start_time VARCHAR ( 20 ) COMMENT '配送开始时间',
	end_time VARCHAR ( 20 ) COMMENT '配送结束时间',
	STATUS VARCHAR ( 2 ) DEFAULT '1' COMMENT '配送状态',
	address VARCHAR ( 255 ) COMMENT '实际送餐地址',
	FOREIGN KEY ( order_id ) REFERENCES orders ( id )
);
CREATE TABLE evaluation (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '评价ID',
	dish_id VARCHAR ( 50 ) NOT NULL COMMENT '菜品ID',
	user_id VARCHAR ( 50 ) NOT NULL COMMENT '用户ID',
	rating INT NOT NULL COMMENT '评分',
	COMMENT TEXT COMMENT '用户的评论内容',
	eval_time VARCHAR ( 20 ) COMMENT '评价时间',
	FOREIGN KEY ( dish_id ) REFERENCES dish ( id ),
	FOREIGN KEY ( user_id ) REFERENCES USER ( id )
);
CREATE TABLE points (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '积分ID',
	user_id VARCHAR ( 50 ) NOT NULL COMMENT '用户ID',
	amount INT NOT NULL COMMENT '积分数量',
	type VARCHAR ( 2 ) NOT NULL COMMENT '积分交易类型',
	time VARCHAR ( 20 ) COMMENT '积分交易时间',
	order_id INT COMMENT '订单ID',
	FOREIGN KEY ( user_id ) REFERENCES USER ( id )
);
CREATE TABLE likes (
	id VARCHAR ( 50 ) PRIMARY KEY COMMENT '点赞ID',
	user_id VARCHAR ( 50 ) NOT NULL COMMENT '用户ID',
	dish_id VARCHAR ( 50 ) NOT NULL COMMENT '菜单ID',
	liked_time VARCHAR ( 20 ) COMMENT '点赞时间',
	FOREIGN KEY ( user_id ) REFERENCES USER ( id ),
	FOREIGN KEY ( dish_id ) REFERENCES dish ( id )
);

DROP TABLE IF EXISTS `system_dictionary`;
CREATE TABLE `system_dictionary`  (
  `dictionary_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典的唯一标识符，作为主键',
  `dictionary_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型，用于区分不同类型的字典项，如订单状态、支付方式、菜品分类等',
  `dictionary_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典项的键，唯一标识一个字典项，通常是一个简短的代码或名称',
  `dictionary_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典项的值，存储该字典项的具体内容或描述',
  `display_order` int(11) NULL DEFAULT 0 COMMENT '显示顺序，用于控制字典项在界面上的显示顺序，数字越小越靠前',
  `is_enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用，用于标记该字典项是否可用，1 表示启用，0 表示禁用',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，记录字典项的创建时间，默认为当前时间戳',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间，记录字典项的最后更新时间，每次更新自动更新为当前时间戳',
  PRIMARY KEY (`dictionary_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_dictionary
-- ----------------------------
INSERT INTO `system_dictionary` VALUES (1, 'user_gender', '1', '男', 1, 1, '2025-01-18 19:58:04', '2025-01-18 20:00:12');
INSERT INTO `system_dictionary` VALUES (2, 'user_gender', '2', '女', 2, 1, '2025-01-18 19:58:04', '2025-01-18 20:00:18');
INSERT INTO `system_dictionary` VALUES (3, 'user_role', '1', '学生', 1, 1, '2025-01-18 19:59:03', '2025-01-18 20:00:22');
INSERT INTO `system_dictionary` VALUES (4, 'user_role', '2', '食堂管理员', 2, 1, '2025-01-18 19:59:03', '2025-01-18 20:00:28');
INSERT INTO `system_dictionary` VALUES (5, 'user_status', '1', '正常', 1, 1, '2025-01-18 20:00:03', '2025-01-18 20:00:36');
INSERT INTO `system_dictionary` VALUES (6, 'user_status', '0', '停用', 2, 1, '2025-01-18 20:00:03', '2025-01-18 20:01:01');
INSERT INTO `system_dictionary` VALUES (11, 'menu_category', '1', '主食', 1, 1, '2025-01-18 20:11:23', '2025-01-18 20:11:23');
INSERT INTO `system_dictionary` VALUES (12, 'menu_category', '2', '小吃', 2, 1, '2025-01-18 20:11:23', '2025-01-18 20:11:23');
INSERT INTO `system_dictionary` VALUES (13, 'menu_category', '3', '饮料', 3, 1, '2025-01-18 20:11:23', '2025-01-18 20:11:23');
INSERT INTO `system_dictionary` VALUES (14, 'menu_category', '4', '甜品', 4, 1, '2025-01-18 20:11:23', '2025-01-18 20:11:23');
INSERT INTO `system_dictionary` VALUES (15, 'menu_category', '5', '套餐', 5, 1, '2025-01-18 20:11:23', '2025-01-18 20:11:23');
INSERT INTO `system_dictionary` VALUES (16, 'orders_status', '1', '待支付', 1, 1, '2025-01-18 20:48:47', '2025-01-18 20:48:47');
INSERT INTO `system_dictionary` VALUES (17, 'orders_status', '2', '已支付', 2, 1, '2025-01-18 20:48:47', '2025-01-18 20:48:47');
INSERT INTO `system_dictionary` VALUES (18, 'orders_status', '3', '已取消', 3, 1, '2025-01-18 20:48:47', '2025-01-18 20:49:15');
INSERT INTO `system_dictionary` VALUES (19, 'orders_pay_method', '1', '积分支付', 1, 1, '2025-01-18 20:53:09', '2025-01-18 20:53:09');
INSERT INTO `system_dictionary` VALUES (20, 'orders_pay_method', '2', '微信', 2, 1, '2025-01-18 20:53:09', '2025-01-18 20:53:09');
INSERT INTO `system_dictionary` VALUES (21, 'orders_pay_method', '3', '支付宝', 3, 1, '2025-01-18 20:53:09', '2025-01-18 20:53:09');
INSERT INTO `system_dictionary` VALUES (22, 'orders_del_status', '1', '未配送', 1, 1, '2025-01-18 20:57:15', '2025-01-18 20:57:15');
INSERT INTO `system_dictionary` VALUES (23, 'orders_del_status', '2', '已配送', 2, 1, '2025-01-18 20:57:15', '2025-01-18 20:57:15');
INSERT INTO `system_dictionary` VALUES (24, 'orders_del_status', '3', '配送中', 3, 1, '2025-01-18 20:57:15', '2025-01-18 20:57:15');
INSERT INTO `system_dictionary` VALUES (25, 'delivery_status', '1', '待分配', 1, 1, '2025-01-18 21:12:06', '2025-01-18 21:12:06');
INSERT INTO `system_dictionary` VALUES (26, 'delivery_status', '2', '已分配', 2, 1, '2025-01-18 21:12:06', '2025-01-18 21:12:06');
INSERT INTO `system_dictionary` VALUES (27, 'delivery_status', '3', '已取货', 3, 1, '2025-01-18 21:12:06', '2025-01-18 21:12:06');
INSERT INTO `system_dictionary` VALUES (28, 'delivery_status', '4', '配送中', 4, 1, '2025-01-18 21:12:06', '2025-01-18 21:12:06');
INSERT INTO `system_dictionary` VALUES (29, 'delivery_status', '5', '已完成', 5, 1, '2025-01-18 21:12:06', '2025-01-18 21:12:06');
INSERT INTO `system_dictionary` VALUES (30, 'points_type', '1', '积分充值', 1, 1, '2025-01-18 21:26:31', '2025-01-18 21:26:31');
INSERT INTO `system_dictionary` VALUES (31, 'points_type', '2', '配送订单', 2, 1, '2025-01-18 21:26:31', '2025-01-18 21:26:31');

SET FOREIGN_KEY_CHECKS = 1;