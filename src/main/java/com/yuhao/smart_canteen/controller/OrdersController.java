package com.yuhao.smart_canteen.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("takeout/orders")
@Api(tags="")
public class OrdersController {
//    @Autowired
//    private OrdersService ordersService;
//
//    @GetMapping("page")
//    @ApiOperation("分页")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
//        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
//    })
//    @RequiresPermissions("takeout:orders:page")
//    public Result<PageData<OrdersDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
//        PageData<OrdersDTO> page = ordersService.page(params);
//
//        return new Result<PageData<OrdersDTO>>().ok(page);
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation("信息")
//    @RequiresPermissions("takeout:orders:info")
//    public Result<OrdersDTO> get(@PathVariable("id") Long id){
//        OrdersDTO data = ordersService.get(id);
//
//        return new Result<OrdersDTO>().ok(data);
//    }
//
//    @PostMapping
//    @ApiOperation("保存")
//    @LogOperation("保存")
//    @RequiresPermissions("takeout:orders:save")
//    public Result save(@RequestBody OrdersDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
//
//        ordersService.save(dto);
//
//        return new Result();
//    }
//
//    @PutMapping
//    @ApiOperation("修改")
//    @LogOperation("修改")
//    @RequiresPermissions("takeout:orders:update")
//    public Result update(@RequestBody OrdersDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
//
//        ordersService.update(dto);
//
//        return new Result();
//    }
//
//    @DeleteMapping
//    @ApiOperation("删除")
//    @LogOperation("删除")
//    @RequiresPermissions("takeout:orders:delete")
//    public Result delete(@RequestBody Long[] ids){
//        //效验数据
//        AssertUtils.isArrayEmpty(ids, "id");
//
//        ordersService.delete(ids);
//
//        return new Result();
//    }
//
//    @GetMapping("export")
//    @ApiOperation("导出")
//    @LogOperation("导出")
//    @RequiresPermissions("takeout:orders:export")
//    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
//        List<OrdersDTO> list = ordersService.list(params);
//
//        ExcelUtils.exportExcelToTarget(response, null, list, OrdersExcel.class);
//    }

}