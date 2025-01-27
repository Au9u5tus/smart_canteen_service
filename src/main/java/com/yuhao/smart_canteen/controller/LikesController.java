package com.yuhao.smart_canteen.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("takeout/likes")
@Api(tags="")
public class LikesController {
//    @Autowired
//    private LikesService likesService;
//
//    @GetMapping("page")
//    @ApiOperation("分页")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
//        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
//        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
//    })
//    @RequiresPermissions("takeout:likes:page")
//    public Result<PageData<LikesDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
//        PageData<LikesDTO> page = likesService.page(params);
//
//        return new Result<PageData<LikesDTO>>().ok(page);
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation("信息")
//    @RequiresPermissions("takeout:likes:info")
//    public Result<LikesDTO> get(@PathVariable("id") Long id){
//        LikesDTO data = likesService.get(id);
//
//        return new Result<LikesDTO>().ok(data);
//    }
//
//    @PostMapping
//    @ApiOperation("保存")
//    @LogOperation("保存")
//    @RequiresPermissions("takeout:likes:save")
//    public Result save(@RequestBody LikesDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
//
//        likesService.save(dto);
//
//        return new Result();
//    }
//
//    @PutMapping
//    @ApiOperation("修改")
//    @LogOperation("修改")
//    @RequiresPermissions("takeout:likes:update")
//    public Result update(@RequestBody LikesDTO dto){
//        //效验数据
//        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
//
//        likesService.update(dto);
//
//        return new Result();
//    }
//
//    @DeleteMapping
//    @ApiOperation("删除")
//    @LogOperation("删除")
//    @RequiresPermissions("takeout:likes:delete")
//    public Result delete(@RequestBody Long[] ids){
//        //效验数据
//        AssertUtils.isArrayEmpty(ids, "id");
//
//        likesService.delete(ids);
//
//        return new Result();
//    }
//
//    @GetMapping("export")
//    @ApiOperation("导出")
//    @LogOperation("导出")
//    @RequiresPermissions("takeout:likes:export")
//    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
//        List<LikesDTO> list = likesService.list(params);
//
//        ExcelUtils.exportExcelToTarget(response, null, list, LikesExcel.class);
//    }

}