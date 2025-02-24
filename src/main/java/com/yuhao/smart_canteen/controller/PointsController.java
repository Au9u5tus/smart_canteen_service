package com.yuhao.smart_canteen.controller;

import com.yuhao.smart_canteen.entity.UserEntity;
import com.yuhao.smart_canteen.service.PointsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("takeout/points")
@Api(tags="")
public class PointsController {
    @Autowired
    private PointsService pointsService;

    // 查看用户积分
    @GetMapping("/{userId}")
    public Integer getUserPoints(@PathVariable Long userId) {
    return pointsService.getUserPoints(userId);
    }
    // 增加用户积分
    @PostMapping("/add/{userId}")
    public UserEntity addPoints(@PathVariable Long userId, @RequestParam double pointsToAdd) {
        return pointsService.addPoints(userId, pointsToAdd);
    }
    // 减少用户积分
    @PostMapping("/reduce/{userId}")
    public UserEntity reducePoints(@PathVariable Long userId, @RequestParam int pointsToReduce) {
        return pointsService.reducePoints(userId, pointsToReduce);
    }

}