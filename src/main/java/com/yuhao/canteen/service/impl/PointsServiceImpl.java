package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.dao.PointsMapper;
import com.yuhao.canteen.entity.Points;
import com.yuhao.canteen.entity.User;
import com.yuhao.canteen.service.PointsService;
import com.yuhao.canteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsServiceImpl extends ServiceImpl<PointsMapper, Points> implements PointsService {
    @Autowired
    private UserService userService;

    //查看用户积分
    public Result<Float> getPointsBalance(String userId) {
       User user= userService.findUserByUserId(userId);
       return Result.ok(user.getPoint(),"查询用户积分成功！");
    }
    //增加用户积分
    public Result addPoints(String userId, float amount, String type, Integer orderId, String time) {
        Points points = new Points();
        points.setId(IdUtils.generateId(Constant.POINT_PREFIX));
        points.setUserId(userId);
        points.setAmount(amount);
        points.setType(type);
        points.setOrderId(orderId);
        points.setTime(time);
        save(points);
        return Result.ok("增加用户积分成功");
    }
    //减少用户积分
    public Result reducePoints(String userId, int amount, String type, Integer orderId, String time) {
        if (getPointsBalance(userId).getData()>= amount) {
            addPoints(userId, -amount, type, orderId, time);
            return Result.ok("积分扣除成功！");
        } else {
            return Result.failture("积分不足，扣除失败！");
        }
    }
}
