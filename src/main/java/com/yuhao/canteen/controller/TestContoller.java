package com.yuhao.canteen.controller;

import com.yuhao.canteen.common.UserUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestContoller {
    @RequestMapping("test")
    public String test() {
        return "";
    }
}
