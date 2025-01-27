--用户表--
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
--菜单表--
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
    dish_id VARCHAR(50) NOT NULL COMMENT '菜单ID',
    quantity INT NOT NULL COMMENT '菜品的数量',
    order_time VARCHAR(20) NOT NULL COMMENT '订单生成时间',
    total_price DECIMAL(10, 2) NOT NULL COMMENT '订单的总价',
    status ENUM('待支付', '已支付', '已取消', '已完成') DEFAULT '待支付' COMMENT '订单状态，使用枚举类型，方便管理订单状态',
    payment_method ENUM('微信支付', '支付宝支付', '校园卡支付', '现金支付') COMMENT '支付方式，使用枚举类型，方便记录用户的支付方式',
    delivery_address VARCHAR(255) COMMENT '送餐地址，用于记录用户的送餐位置，可为空，例如用户自取时可能不需要地址',
    delivery_time TIMESTAMP COMMENT '预计送餐时间，可根据实际业务逻辑计算或手动输入，可为空',
    delivery_status ENUM('未配送', '已配送', '配送中') DEFAULT '未配送' COMMENT '送餐状态，使用枚举类型，方便管理送餐状态',
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (dish_id) REFERENCES menu(menu_id)
);

CREATE TABLE order_details (
    detail_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '订单详情的唯一标识符，作为主键',
    order_id INT NOT NULL COMMENT '订单的唯一标识符，关联订单表的 order_id，用于标识该订单详情属于哪个订单',
    menu_id INT NOT NULL COMMENT '菜单的唯一标识符，关联菜单表的 menu_id，用于标识该订单详情中的菜品',
    quantity INT NOT NULL COMMENT '该菜品在订单中的数量',
    unit_price DECIMAL(10, 2) NOT NULL COMMENT '该菜品的单价，使用 DECIMAL 类型存储，保留两位小数',
    sub_total DECIMAL(10, 2) NOT NULL COMMENT '该菜品的小计金额，根据单价和数量计算得出，保留两位小数',
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (menu_id) REFERENCES menu(menu_id)
);

CREATE TABLE delivery (
    delivery_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '配送的唯一标识符，作为主键',
    order_id INT NOT NULL COMMENT '订单的唯一标识符，关联订单表的 order_id，用于标识该配送信息属于哪个订单',
    delivery_person_id INT COMMENT '配送人员的唯一标识符，关联配送人员表的 person_id，用于标识负责该订单配送的人员，可为空，可能存在未分配配送员的情况',
    delivery_start_time TIMESTAMP COMMENT '配送开始时间，记录配送人员开始配送的时间，可为空，当开始配送时记录',
    delivery_end_time TIMESTAMP COMMENT '配送结束时间，记录配送人员完成配送的时间，可为空，当完成配送时记录',
    delivery_status ENUM('待分配', '已分配', '已取货', '配送中', '已完成') DEFAULT '待分配' COMMENT '配送状态，使用枚举类型，方便管理配送进度',
    actual_delivery_address VARCHAR(255) COMMENT '实际送餐地址，用于记录实际送餐的地址，可为空，当送餐地址发生变更时使用',
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (delivery_person_id) REFERENCES delivery_persons(person_id)
);

CREATE TABLE evaluation (
    evaluation_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '评价的唯一标识符，作为主键',
    menu_id INT NOT NULL COMMENT '菜单的唯一标识符，关联菜单表的 menu_id，用于标识该评价针对哪个菜品',
    user_id INT NOT NULL COMMENT '用户的唯一标识符，关联用户表的 user_id，用于标识该评价由哪个用户做出',
    rating INT NOT NULL COMMENT '评分，使用整数表示，可根据具体的评分范围设定，例如 1 到 5 分',
    comment TEXT COMMENT '用户的评论内容，可存储较长的文本，用户可对菜品和服务进行评价',
    evaluation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '评价时间，记录用户提交评价的时间，默认为当前时间戳',
    FOREIGN KEY (menu_id) REFERENCES menu(menu_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE points (
    point_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '积分记录的唯一标识符，作为主键',
    user_id INT NOT NULL COMMENT '用户的唯一标识符，关联用户表的 user_id，用于标识积分所属的用户',
    point_amount INT NOT NULL COMMENT '积分数量，存储用户的积分数量，可以为正（获得积分）或负（消耗积分）',
    transaction_type ENUM('下单奖励', '评价奖励', '兑换消耗', '活动奖励', '惩罚扣除') NOT NULL COMMENT '积分交易类型，表明积分的来源或用途',
    transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '积分交易时间，记录积分发生变动的时间，默认为当前时间戳',
    order_id INT COMMENT '订单的唯一标识符，关联订单表的 order_id，当积分变动与订单相关时使用，如下单奖励或兑换消耗积分',
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

CREATE TABLE likes (
    like_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '点赞ID',
    user_id INT NOT NULL COMMENT '用户ID',
    menu_id INT NOT NULL COMMENT '菜单ID',
    liked_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间，记录用户点赞的时间，默认为当前时间戳',
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (menu_id) REFERENCES menu(menu_id)
);


CREATE TABLE system_dictionary (
    dictionary_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '字典的唯一标识符，作为主键',
    dictionary_type VARCHAR(50) NOT NULL COMMENT '字典类型，用于区分不同类型的字典项，如订单状态、支付方式、菜品分类等',
    dictionary_key VARCHAR(50) NOT NULL COMMENT '字典项的键，唯一标识一个字典项，通常是一个简短的代码或名称',
    dictionary_value VARCHAR(255) NOT NULL COMMENT '字典项的值，存储该字典项的具体内容或描述',
    display_order INT DEFAULT 0 COMMENT '显示顺序，用于控制字典项在界面上的显示顺序，数字越小越靠前',
    is_enabled TINYINT(1) DEFAULT 1 COMMENT '是否启用，用于标记该字典项是否可用，1 表示启用，0 表示禁用',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，记录字典项的创建时间，默认为当前时间戳',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间，记录字典项的最后更新时间，每次更新自动更新为当前时间戳'
);