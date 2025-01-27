package com.yuhao.smart_canteen.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("takeout/dish")
@Api(tags="")
public class DishController {
//    @Autowired
//    private DishService dishService;
//
//    @GetMapping("page")
//    @ApiOperation("分页")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
//        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
//    })
//    @RequiresPermissions("takeout:dish:page")
//    public Result<PageData<DishDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
//        PageData<DishDTO> page = dishService.page(params);
//
//        return new Result<PageData<DishDTO>>().ok(page);
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation("信息")
//    @RequiresPermissions("takeout:dish:info")
//    public Result<DishDTO> get(@PathVariable("id") Long id){
//        DishDTO data = dishService.get(id);
//
//        return new Result<DishDTO>().ok(data);
//    }
//
//    @PostMapping
//    @ApiOperation("保存")
//    @LogOperation("保存")
//    @RequiresPermissions("takeout:dish:save")
//    public Result save(@RequestBody DishDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
//
//        dishService.save(dto);
//
//        return new Result();
//    }
//
//    @PutMapping
//    @ApiOperation("修改")
//    @LogOperation("修改")
//    @RequiresPermissions("takeout:dish:update")
//    public Result update(@RequestBody DishDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
//
//        dishService.update(dto);
//
//        return new Result();
//    }
//
//    @DeleteMapping
//    @ApiOperation("删除")
//    @LogOperation("删除")
//    @RequiresPermissions("takeout:dish:delete")
//    public Result delete(@RequestBody Long[] ids){
//        //效验数据
//        AssertUtils.isArrayEmpty(ids, "id");
//
//        dishService.delete(ids);
//
//        return new Result();
//    }
//
//    @GetMapping("export")
//    @ApiOperation("导出")
//    @LogOperation("导出")
//    @RequiresPermissions("takeout:dish:export")
//    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
//        List<DishDTO> list = dishService.list(params);
//
//        ExcelUtils.exportExcelToTarget(response, null, list, DishExcel.class);
//    }

}