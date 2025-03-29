package com.yuhao.canteen.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.dao.LikesMapper;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.entity.Likes;
import com.yuhao.canteen.service.LikesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements LikesService {
    //分页查询点赞表
    public Result<Page<Likes>> pageQueryLikes(Likes likes) {
        Page<Likes> page = new Page<>(likes.getCurrent(), likes.getSize());
        QueryWrapper<Likes> queryWrapper=new QueryWrapper<>();
        if(StrUtil.isEmpty(likes.getName())){
            queryWrapper.like("name",likes.getName());
        }
        Page<Likes> pageLikes=page(page,queryWrapper);
        return Result.ok(pageLikes,"点赞查询成功！");
    }
    //批量删除功能
    public Result batchDeleteLikes(List<String> ids) {
        removeBatchByIds(ids);
        return Result.ok("批量删除成功！");
    }

}



