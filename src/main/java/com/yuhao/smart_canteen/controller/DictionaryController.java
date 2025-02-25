package com.yuhao.smart_canteen.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhao.smart_canteen.entity.DictionaryEntity;
import com.yuhao.smart_canteen.service.DictionaryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/systemdictionary")
@Api(tags="")
@Slf4j
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @PostMapping("/addDictionary")
    public boolean addDictionary(@RequestBody DictionaryEntity dictionary) {
        return dictionaryService.save(dictionary);
    }

    @GetMapping("/page")
    public IPage<DictionaryEntity> getDictionaryPage(
            @RequestParam(defaultValue = "1") long pageNo,  // 当前页码，默认值为 1
            @RequestParam(defaultValue = "10") long pageSize     // 每页显示的记录数，默认值为 10
    ) {
        // 创建 Page 对象
        Page<DictionaryEntity> page = new Page<>(pageNo, pageSize);
        // 调用 Service 层的分页查询方法
        return dictionaryService.getDictionaryPage(page);
    }

//    // 根据 ID 删除字典项
//    @GetMapping("/{id}")
//    public boolean deleteDictionary(@PathVariable Integer id) {
//        return systemDictionaryService.removeById(id);
//    }
//
//    // 根据 ID 更新字典项
//    @PutMapping
//    public boolean updateDictionary(@RequestBody SystemDictionaryDTO dictionary) {
//        return systemDictionaryService.updateById(dictionary);
//    }
//
//    // 根据 ID 查询字典项
//    @GetMapping("/{id}")
//    public SystemDictionary getDictionaryById(@PathVariable Integer id) {
//        return systemDictionaryService.getById(id);
//    }
//
//    // 查询所有字典项
    @GetMapping("/getAllDictionaries")
    public List<DictionaryEntity> getAllDictionaries() {
        return dictionaryService.list();
    }
//
//    // 根据字典类型查询字典项
//    @GetMapping("/type/{type}")
//    public List<SystemDictionary> getDictionariesByType(@PathVariable String type) {
//        QueryWrapper<SystemDictionary> wrapper = new QueryWrapper<>();
//        wrapper.eq("dictionary_type", type);
//        return systemDictionaryService.list(wrapper);
//    }

}