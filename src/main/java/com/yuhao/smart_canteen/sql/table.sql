CREATE TABLE user (
                      id VARCHAR(50) PRIMARY KEY COMMENT '用户ID',
                      student_id VARCHAR(50) NOT NULL UNIQUE COMMENT '学号',
                      username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
                      password VARCHAR(255) NOT NULL COMMENT '密码',
                      name VARCHAR(100) NOT NULL COMMENT '真实姓名',
                      gender VARCHAR(2) NOT NULL COMMENT '性别',
                      point INT(10) NOT NULL COMMENT '积分',
                      phone VARCHAR(20) COMMENT '联系电话',
                      email VARCHAR(100) UNIQUE COMMENT '电子邮件地址',
                      avatar VARCHAR(255) COMMENT '头像',
                      role VARCHAR(2) NOT NULL default '1'  COMMENT '角色',
                      reg_date VARCHAR(20) NOT NULL COMMENT '注册系统的日期',
                      last_login VARCHAR(20) NOT NULL COMMENT '最后登录系统的时间',
                      status VARCHAR(2) DEFAULT '1' COMMENT '用户账号的状态'
);
CREATE TABLE dish (
                      id VARCHAR(50) PRIMARY KEY COMMENT '菜单唯一标识符，作为主键',
                      name VARCHAR(100) NOT NULL COMMENT '菜单名称',
                      description TEXT COMMENT '菜单描述',
                      price FLOAT(10) NOT NULL COMMENT '菜品价格',
                      category VARCHAR(2) NOT NULL COMMENT '菜品分类',
                      image_url_first VARCHAR(255) COMMENT '菜品主图的 URL',
                      image_url_second VARCHAR(255) COMMENT '菜品的第二张图',
                      image_url_third VARCHAR(255) COMMENT '菜品的第三张图',
                      image_url_forth VARCHAR(255) COMMENT '菜品的第四张图',
                      available BOOLEAN DEFAULT TRUE COMMENT '菜品是否可用',
                      create_date VARCHAR(255) COMMENT '菜品创建日期',
                      update_date VARCHAR(255) COMMENT '菜品更新日期'
);

CREATE TABLE orders (
                        id VARCHAR(50) PRIMARY KEY COMMENT '订单ID',
                        user_id VARCHAR(50) NOT NULL COMMENT '用户ID',
                        dish_id VARCHAR(50) NOT NULL COMMENT '菜品ID',
                        quantity INT NOT NULL COMMENT '菜品的数量',
                        order_time VARCHAR(20) NOT NULL COMMENT '订单生成时间',
                        total_price FLOAT(10) NOT NULL COMMENT '订单的总价',
                        status VARCHAR(2) DEFAULT '1' COMMENT '订单状态',
                        pay_method VARCHAR(2) DEFAULT '1' COMMENT '支付方式',
                        address VARCHAR(255) COMMENT '送餐地址',
                        del_time VARCHAR(20) NOT NULL COMMENT '预计送餐时间',
                        del_status VARCHAR(2) DEFAULT '未配送' COMMENT '送餐状态',
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (dish_id) REFERENCES menu(id)
);

CREATE TABLE order_details (
                               id VARCHAR(50) PRIMARY KEY COMMENT '订单详情ID',
                               order_id VARCHAR(50) NOT NULL COMMENT '订单ID',
                               dish_id VARCHAR(50) NOT NULL COMMENT '菜品ID',
                               quantity INT NOT NULL COMMENT '菜品订单中的数量',
                               unit_price FLOAT NOT NULL COMMENT '该菜品的单价',
                               sub_total FLOAT NOT NULL COMMENT '该菜品的小计金额',
                               FOREIGN KEY (order_id) REFERENCES orders(id),
                               FOREIGN KEY (dish_id) REFERENCES menu(id)
);

CREATE TABLE delivery (
                          id INT VARCHAR(50) PRIMARY KEY COMMENT '配送ID',
                          order_id INT NOT NULL COMMENT '订单ID',
                          person_id VARCHAR(50) COMMENT '配送人员ID',
                          start_time VARCHAR(20) COMMENT '配送开始时间',
                          end_time VARCHAR(20) COMMENT '配送结束时间',
                          status VARCHAR(2) DEFAULT '1' COMMENT '配送状态',
                          address VARCHAR(255) COMMENT '实际送餐地址',
                          FOREIGN KEY (order_id) REFERENCES orders(id),
                          FOREIGN KEY (delivery_person_id) REFERENCES user(id)
);

CREATE TABLE evaluation (
                            id VARCHAR(50) PRIMARY KEY COMMENT '评价ID',
                            dish_id VARCHAR(50) NOT NULL COMMENT '菜品ID',
                            user_id VARCHAR(50) NOT NULL COMMENT '用户ID',
                            rating INT NOT NULL COMMENT '评分',
                            comment TEXT COMMENT '用户的评论内容',
                            eval_time VARCHAR(20) COMMENT '评价时间',
                            FOREIGN KEY (dish_id) REFERENCES menu(id),
                            FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE points (
                        id VARCHAR(50) PRIMARY KEY COMMENT '积分ID',
                        user_id VARCHAR(50) NOT NULL COMMENT '用户ID',
                        amount INT NOT NULL COMMENT '积分数量',
                        type VARCHAR(2) NOT NULL COMMENT '积分交易类型',
                        time VARCHAR(20) COMMENT '积分交易时间',
                        order_id INT COMMENT '订单ID',
                        FOREIGN KEY (user_id) REFERENCES user(user_id),
);

CREATE TABLE likes (
                       id VARCHAR(50) PRIMARY KEY COMMENT '点赞ID',
                       user_id VARCHAR(50) NOT NULL COMMENT '用户ID',
                       dish_id VARCHAR(50) NOT NULL COMMENT '菜单ID',
                       liked_time VARCHAR(20 COMMENT '点赞时间，记录用户点赞的时间，默认为当前时间戳',
                       FOREIGN KEY (user_id) REFERENCES user(id),
                       FOREIGN KEY (dish_id) REFERENCES dish(id)
);


CREATE TABLE system_dictionary (
                                   id INT AUTO_INCREMENT PRIMARY KEY COMMENT '字典的唯一标识符，作为主键',
                                   type VARCHAR(50) NOT NULL COMMENT '字典类型',
                                   key VARCHAR(50) NOT NULL COMMENT '字典项的键',
                                   value VARCHAR(255) NOT NULL COMMENT '字典项的值',
                                   display_order INT DEFAULT 0 COMMENT '显示顺序',
                                   is_enabled TINYINT(1) DEFAULT 1 COMMENT '是否启用',
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);;;