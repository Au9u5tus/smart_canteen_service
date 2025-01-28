package com.yuhao.canteen.controller;


import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.dto.SystemDictionaryDTO;
import com.yuhao.canteen.service.SystemDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/dict")
@Api(tags="")
public class SystemDictionaryController {
    @Autowired
    private SystemDictionaryService systemDictionaryService;

    @GetMapping("getAllDicts")
    @ApiOperation("获取字典")
    public Result<List<SystemDictionaryDTO>> getAllDicts(){
        return null;
    }
//
//    @GetMapping("page")
//    @ApiOperation("分页")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
//        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
//    })
//    @RequiresPermissions("takeout:systemdictionary:page")
//    public Result<PageData<SystemDictionaryDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
//        PageData<SystemDictionaryDTO> page = systemDictionaryService.page(params);
//
//        return new Result<PageData<SystemDictionaryDTO>>().ok(page);
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation("信息")
//    @RequiresPermissions("takeout:systemdictionary:info")
//    public Result<SystemDictionaryDTO> get(@PathVariable("id") Long id){
//        SystemDictionaryDTO data = systemDictionaryService.get(id);
//
//        return new Result<SystemDictionaryDTO>().ok(data);
//    }
//
//    @PostMapping
//    @ApiOperation("保存")
//    @LogOperation("保存")
//    @RequiresPermissions("takeout:systemdictionary:save")
//    public Result save(@RequestBody SystemDictionaryDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
//
//        systemDictionaryService.save(dto);
//
//        return new Result();
//    }
//
//    @PutMapping
//    @ApiOperation("修改")
//    @LogOperation("修改")
//    @RequiresPermissions("takeout:systemdictionary:update")
//    public Result update(@RequestBody SystemDictionaryDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
//
//        systemDictionaryService.update(dto);
//
//        return new Result();
//    }
//
//    @DeleteMapping
//    @ApiOperation("删除")
//    @LogOperation("删除")
//    @RequiresPermissions("takeout:systemdictionary:delete")
//    public Result delete(@RequestBody Long[] ids){
//        //效验数据
//        AssertUtils.isArrayEmpty(ids, "id");
//
//        systemDictionaryService.delete(ids);
//
//        return new Result();
//    }
//
//    @GetMapping("export")
//    @ApiOperation("导出")
//    @LogOperation("导出")
//    @RequiresPermissions("takeout:systemdictionary:export")
//    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
//        List<SystemDictionaryDTO> list = systemDictionaryService.list(params);
//
//        ExcelUtils.exportExcelToTarget(response, null, list, SystemDictionaryExcel.class);
//    }

}