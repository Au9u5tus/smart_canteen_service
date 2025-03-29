package com.yuhao.canteen.constant;
//待支付；已支付；待配送；配送中，已完成；
public enum OrderEnum {
    FOR_PAY("1","待支付"),
    PAYED("2","已支付"),
    FOR_DELIVERY("3","待配送"),
    IN_DELIVERY("4","配送中"),
    FINISHED("5","已完成"),
    CANCELED("6","已取消");

    private String code;
    private String desc;

    OrderEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static OrderEnum getOrderEnum(int code) {
        for (OrderEnum orderEnum : OrderEnum.values()) {
            if (orderEnum.code.equals(code)) {
                return orderEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
