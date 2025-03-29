package com.yuhao.canteen.constant;

//已接单，待取餐；已取餐，配送中；已送达
public enum DeliveryEnum {
    WILLDELIVERY("1","已接单，待取餐"),
    DELIVERYING("2","已取餐，配送中"),
    DELIVERYED("3","已送达");


    private String code;
    private String desc;

    DeliveryEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static DeliveryEnum getDeliveryEnum(String code) {
        for (DeliveryEnum deliveryEnum : DeliveryEnum.values()) {
            if (deliveryEnum.code.equals(code)) {
                return deliveryEnum;
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
