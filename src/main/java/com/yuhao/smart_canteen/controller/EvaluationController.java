package com.yuhao.smart_canteen.controller;

import com.yuhao.smart_canteen.entity.EvaluationEntity;
import com.yuhao.smart_canteen.service.EvaluationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("evaluation")
@Api(tags="")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

// 根据菜品 ID 查询评价
    @GetMapping("/dish/{dishId}")
    public List<EvaluationEntity> getCommentsByDishId(@PathVariable Long dishId) {
        return evaluationService.getEvaluationsByDishId(dishId);
    }
    // 根据用户 ID 查询评价
    @GetMapping("/user/{userId}")
    public List<EvaluationEntity> getCommentsByUserId(@PathVariable Long userId) {
        return evaluationService.getEvaluationsByUserId(userId);
    }
    // 根据评价 ID 删除评价
    @GetMapping("/deleteComment/{id}")
    public void deleteComment(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
    }
    // 根据评价 ID 查询评价
    @GetMapping("/getCommentById/{id}")
    public EvaluationEntity getCommentById(@PathVariable Long id) {
        return evaluationService.getEvaluationById(id);
    }
}