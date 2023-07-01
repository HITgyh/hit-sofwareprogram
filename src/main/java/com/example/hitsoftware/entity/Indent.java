package com.example.hitsoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("indent")
public class Indent {

    @TableId
    private Integer indentId;
    private String time;
    private Integer productId;
    private String productType;
    private Float productRetailUnitPrice;
    private Integer productNumber;
    private Float price;
    private Integer wareHouseId;
    private String customerName;
    private String customerContact;
    private String customerAddress;
    private String courierName;
    private String courierContact;

    public Indent(Integer indentId, String time, Integer productId, String productType, Integer productNumber, Float price, Integer wareHouseId, String customerName, String customerContact, String customerAddress, String courierName, String courierContact) {
        this.indentId = indentId;
        this.time = time;
        this.productId = productId;
        this.productType = productType;
        this.productNumber = productNumber;
        this.price = price;
        this.wareHouseId = wareHouseId;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.customerAddress = customerAddress;
        this.courierName = courierName;
        this.courierContact = courierContact;
    }
}
