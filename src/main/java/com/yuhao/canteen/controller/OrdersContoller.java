package com.yuhao.canteen.controller;

import com.yuhao.canteen.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("orders")
@RestController
public class OrdersContoller {

    @PostMapping("createOrder")
    public Result createOrder(@RequestBody List<String> detailIds) {
        return null;
    }

}
