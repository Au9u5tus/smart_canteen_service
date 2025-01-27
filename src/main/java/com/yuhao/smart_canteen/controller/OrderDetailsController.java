package com.yuhao.smart_canteen.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("takeout/orderdetails")
@Api(tags="")
public class OrderDetailsController {
//    @Autowired
//    private OrderDetailsService orderDetailsService;
//
//    @GetMapping("page")
//    @ApiOperation("分页")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
//        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
//    })
//    @RequiresPermissions("takeout:orderdetails:page")
//    public Result<PageData<OrderDetailsDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
//        PageData<OrderDetailsDTO> page = orderDetailsService.page(params);
//
//        return new Result<PageData<OrderDetailsDTO>>().ok(page);
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation("信息")
//    @RequiresPermissions("takeout:orderdetails:info")
//    public Result<OrderDetailsDTO> get(@PathVariable("id") Long id){
//        OrderDetailsDTO data = orderDetailsService.get(id);
//
//        return new Result<OrderDetailsDTO>().ok(data);
//    }
//
//    @PostMapping
//    @ApiOperation("保存")
//    @LogOperation("保存")
//    @RequiresPermissions("takeout:orderdetails:save")
//    public Result save(@RequestBody OrderDetailsDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
//
//        orderDetailsService.save(dto);
//
//        return new Result();
//    }
//
//    @PutMapping
//    @ApiOperation("修改")
//    @LogOperation("修改")
//    @RequiresPermissions("takeout:orderdetails:update")
//    public Result update(@RequestBody OrderDetailsDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
//
//        orderDetailsService.update(dto);
//
//        return new Result();
//    }
//
//    @DeleteMapping
//    @ApiOperation("删除")
//    @LogOperation("删除")
//    @RequiresPermissions("takeout:orderdetails:delete")
//    public Result delete(@RequestBody Long[] ids){
//        //效验数据
//        AssertUtils.isArrayEmpty(ids, "id");
//
//        orderDetailsService.delete(ids);
//
//        return new Result();
//    }
//
//    @GetMapping("export")
//    @ApiOperation("导出")
//    @LogOperation("导出")
//    @RequiresPermissions("takeout:orderdetails:export")
//    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
//        List<OrderDetailsDTO> list = orderDetailsService.list(params);
//
//        ExcelUtils.exportExcelToTarget(response, null, list, OrderDetailsExcel.class);
//    }

}