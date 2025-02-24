package com.yuhao.smart_canteen.controller;

import com.yuhao.smart_canteen.common.Result;
import com.yuhao.smart_canteen.service.LikesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("takeout/likes")
@Api(tags = "")
public class LikesController {
    @Autowired
    private LikesService likeService;
    // 用户点赞菜品
    @PostMapping("/{userId}/{dishId}")
    public Result likeDish(@PathVariable Long userId, @PathVariable Long dishId) {
        return likeService.likeDish(userId, dishId);
    }
    // 用户取消点赞菜品
    @GetMapping("/{userId}/{dishId}")
    public Result cancelLikeDish(@PathVariable Long userId, @PathVariable Long dishId) {
        return likeService.cancelLikeDish(userId, dishId);
    }
    // 检查用户是否已经点赞某菜品
    @GetMapping("/{userId}/{dishId}/hasLiked")
    public Result hasLikedDish(@PathVariable Long userId, @PathVariable Long dishId) {
        return likeService.hasLikedDish(userId, dishId);
    }
    // 获取某菜品的点赞数量
    @GetMapping("/{dishId}/count")
    public int getDishLikeCount(@PathVariable Long dishId) {
        return likeService.getDishLikeCount(dishId);
    }
}