package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.dao.EvaluationMapper;
import com.yuhao.canteen.entity.Evaluation;
import com.yuhao.canteen.service.EvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements EvaluationService {

    //添加菜品评论
    public Result addEvaluation(Evaluation evaluation) {
        save(evaluation);
        return Result.ok("添加评价成功！");
    }
    //根据菜品 ID 查询评论列表
    public Result<List<Evaluation>> getEvaluationsByDishId(String dishId) {
        QueryWrapper<Evaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dish_id", dishId);
        return Result.ok(list(queryWrapper),"查询评论列表成功！");
    }
    //删除评价
    public Result deleteEvaluationByDishId(String dishId) {
        QueryWrapper<Evaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dish_id", dishId);
        remove(queryWrapper);
        return Result.ok("删除评论成功！");
    }


}
