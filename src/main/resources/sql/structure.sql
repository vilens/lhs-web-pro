/**********
架构
 */
-- Session 会话
CREATE TABLE `local_session` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `token` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'token',
  `user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `login_time` datetime NOT NULL,
  `expiry_time` datetime NOT NULL,
  `context_json` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'json',
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Session会话';

/**********
用户相关
 */
-- 用户
create table `user` (
  id bigint(32) unsigned NOT NULL auto_increment COMMENT '主键ID',
  username varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  mobile varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'mobile',
  wx_openid varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  wx_access_token varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  wx_nickname varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  wx_sex int(1) COLLATE utf8mb4_unicode_ci DEFAULT '0',
  wx_city varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  wx_province varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  wx_country varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  wx_headimgurl varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  wx_privilege varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 收货信息表
create table `recipient_info` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `recipient` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收件人',
  `address` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '详细地址',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='收货信息表';

-- 喜欢作品表
create table `love_painting` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `painting_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画作id',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='喜欢作品表';
-- 关注画家表
create table `follow_painter` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `painter_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画家id',
  `painter_user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画家id',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='喜欢作品表';

/**********
业务相关
 */
-- 画家标签
create table `painter_tag` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='画家标签';
-- 画家标签关系表
create table `painter_tag_relation` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `painter_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画家id',
  `painter_tag_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画家标签id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='画家标签关系表';
-- 画家表
create table `painter` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画家姓名',
  `head_url` varchar(200) COLLATE utf8mb4_unicode_ci NULL COMMENT '画家头像地址',
  `painter_value` varchar(50) COLLATE utf8mb4_unicode_ci NULL COMMENT '身价',
  `sex` INT(2) COLLATE utf8mb4_unicode_ci NULL COMMENT '性别',
  `birthday` date NULL,
  `summary` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '简介',
  `create_time` datetime NOT NULL,
  `del_flag` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0 已删除 1 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='画家表';
-- 画作表
create table `painting` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画作名称',
  `user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `painter_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画家id',
  `classify_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类id',
  `url` varchar(200) COLLATE utf8mb4_unicode_ci NULL COMMENT '作品url地址',
  `price` DECIMAL(13,2) COLLATE utf8mb4_unicode_ci NULL COMMENT '作品价格',
  `painting_mount` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0 未装裱 1 已装裱',
  `material_quality` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '材质',
  `width` int(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '宽',
  `height` int(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '高',
  `location` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所在地',
  `weight` int(6) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权重',
  `draw_year` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创作年份',
  `salability` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0 不可出售 1 可出售',
  `status` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0 未售出 1 已售出',
  `personal_letter` VARCHAR(1000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作者手札',
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `del_flag` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0 已删除 1 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='画作表';
-- 补充图片表
create table `painting_images` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `painting_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画作id',
  `img_url` varchar(200) COLLATE utf8mb4_unicode_ci NULL COMMENT '图片url地址',
  `create_time` datetime NOT NULL,
  `del_flag` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0 已删除 1 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='补充图片表';

-- 画作故事
create table `painting_story` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NULL COMMENT '标题',
  `image_url` varchar(200) COLLATE utf8mb4_unicode_ci NULL COMMENT '故事图片url地址',
  `desc` varchar(1000) COLLATE utf8mb4_unicode_ci NULL COMMENT '故事详细',
  `sort` INT(2) COLLATE utf8mb4_unicode_ci NULL COMMENT '排序',
  `painting_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画作id',
  `author` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作者名称',
  `author_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作者id',
  `type` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '1 文本 2 图片',
  `browse_count` INT(6) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '浏览量',
  `likes` INT(6) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '点赞量',
  `create_time` datetime NOT NULL,
  `modify_time` datetime NOT NULL,
  `del_flag` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '0 已删除 1 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='画作心路';

-- 分类
CREATE TABLE `classify` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `pid` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '父ID',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='分类';
/**********
订单相关
 */

-- 订单表
create table `order` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `order_code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单号',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单名称',
  `painting_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画作id',
  `purchaser_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '买方id',
  `seller_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '卖方id',
  `price` DECIMAL(13,2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '成交价格',
  `status` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单状态 0.待付款 1.已付款 （用户创建完订单，付款） 2.已发货  （买家已经发货） 3.交易完成 （完成所有流程） 4.交易取消 （买家或者买家取消订单）',
  `payment_type` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付类型 1 微信 2 支付宝',
  `desc` varchar(50) COLLATE utf8mb4_unicode_ci NULL COMMENT '订单明细',
  `payment_time` datetime NOT NULL COMMENT '付款时间',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';

-- 订单流水表
create table `order_flow` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `order_flow_code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '交易流水',
  `trading_flow_code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方支付流水',
  `payment_type` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付类型 1 微信 2 支付宝',
  `status` INT(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态 1 成功 0 失败',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单流水表';

/**********
后台运维
 */
-- 摄影图片标签表
create table `photograph_tag` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `place` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '地点',
  `time` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '时间字符串',
  `activity` varchar(50) COLLATE utf8mb4_unicode_ci NULL COMMENT '活动名称',
  `photographer` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '摄影师',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='摄影标签表';

-- 摄影图片表
create table `photograph_resource` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `url` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片url地址',
  `md5` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'md5加密',
  `photograph_tag_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '摄影图片标签id',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='摄影图片表';

-- 用户和摄影图片标签授权表（作废）
/*
create table `user_photograph_tag_auth` (
  `id` bigint(32) unsigned NOT NULL COMMENT '主键ID',
  `photograph_tag_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '摄影图片标签id',
  `user_id` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `create_user` bigint(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户和摄影图片标签授权表';
*/