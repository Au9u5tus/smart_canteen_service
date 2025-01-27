package com.yuhao.smart_canteen.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("takeout/delivery")
@Api(tags="")
public class DeliveryController {
//    @Autowired
//    private DeliveryService deliveryService;
//
//    @GetMapping("page")
//    @ApiOperation("分页")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
//        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
//    })
//    @RequiresPermissions("takeout:delivery:page")
//    public Result<PageData<DeliveryDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
//        PageData<DeliveryDTO> page = deliveryService.page(params);
//
//        return new Result<PageData<DeliveryDTO>>().ok(page);
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation("信息")
//    @RequiresPermissions("takeout:delivery:info")
//    public Result<DeliveryDTO> get(@PathVariable("id") Long id){
//        DeliveryDTO data = deliveryService.get(id);
//
//        return new Result<DeliveryDTO>().ok(data);
//    }
//
//    @PostMapping
//    @ApiOperation("保存")
//    @LogOperation("保存")
//    @RequiresPermissions("takeout:delivery:save")
//    public Result save(@RequestBody DeliveryDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
//
//        deliveryService.save(dto);
//
//        return new Result();
//    }
//
//    @PutMapping
//    @ApiOperation("修改")
//    @LogOperation("修改")
//    @RequiresPermissions("takeout:delivery:update")
//    public Result update(@RequestBody DeliveryDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
//
//        deliveryService.update(dto);
//
//        return new Result();
//    }
//
//    @DeleteMapping
//    @ApiOperation("删除")
//    @LogOperation("删除")
//    @RequiresPermissions("takeout:delivery:delete")
//    public Result delete(@RequestBody Long[] ids){
//        //效验数据
//        AssertUtils.isArrayEmpty(ids, "id");
//
//        deliveryService.delete(ids);
//
//        return new Result();
//    }
//
//    @GetMapping("export")
//    @ApiOperation("导出")
//    @LogOperation("导出")
//    @RequiresPermissions("takeout:delivery:export")
//    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
//        List<DeliveryDTO> list = deliveryService.list(params);
//
//        ExcelUtils.exportExcelToTarget(response, null, list, DeliveryExcel.class);
//    }

}