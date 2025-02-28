package com.yuhao.canteen.controller;

import com.yuhao.canteen.entity.Dictionary;
import com.yuhao.canteen.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/getAllDicts")
    public List<Dictionary> getAllDicts(){
       return  dictionaryService.list();
    }
}
