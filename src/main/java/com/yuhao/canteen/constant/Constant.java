package com.yuhao.canteen.constant;

public interface Constant {
    /**
     * 成功
     */
    int SUCCESS = 1;
    /**
     * 失败
     */
    int FAIL = 0;
    /**
     * 未登录
     */
    int UNLOGIN=-1;
    /**
     * 菜单根节点标识
     */
    Long MENU_ROOT = 0L;
    /**
     * 部门根节点标识
     */
    Long DEPT_ROOT = 0L;
    /**
     *  升序
     */
    String ASC = "asc";
    /**
     * 降序
     */
    String DESC = "desc";
    /**
     * 创建时间字段名
     */
    String CREATE_DATE = "create_date";

    /**
     * 数据权限过滤
     */
    String SQL_FILTER = "sqlFilter";
    /**
     * 当前页码
     */
    String PAGE = "page";
    /**
     * 每页显示记录数
     */
    String LIMIT = "limit";
    /**
     * 排序字段
     */
    String ORDER_FIELD = "orderField";
    /**
     * 排序方式
     */
    String ORDER = "order";
    /**
     * token header
     */
    String TOKEN_HEADER = "token";

    /**
     * 云存储配置KEY
     */
    String SLAT = "SMART_CANTEEN_IS_OK";

    int EXIST=1;

    int DELETED=0;


    String USER_PREFIX="USER_";

    String ORDER_PREFIX="ORDER_";

    String ORDER_DETAIL_PREFOX="ORDER_DETAIL_";

    String FILE_PREFIX="FILE_";

    String DISH_PREFIX="DISH_";

    String POINT_PREFIX="POINT_";

    String DELIVERY_PREFIX="DELIVERY_";

    String UPLOAD_DIR = "uploads/";
}
