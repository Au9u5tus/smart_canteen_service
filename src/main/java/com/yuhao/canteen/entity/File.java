package com.yuhao.canteen.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("attachment")
public class File {
    @TableId
    private String id;
    private String name;
    private String path;
    private String status;
    private String createTime;
}
