package com.example.hitsoftware.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * Package: com.example.hitsoftware.entity
 * Discription:
 *
 * @Author: JUSTIN
 * @Create:6/28/2023 - 10:28 AM
 * @Version:
 */
@Data
@TableName("product")
public class Product {

    @TableId
    private Integer productId;
    private String productType;
    private Integer wareHouseId;
    private Float purchaseUnitPrice;
    private Float wholesaleUnitPrice;
    private Float retailUnitPrice;
    private Integer inventory;
    private String supplierName;
    private String supplierContact;
    private String supplierAddress;

    public Product(Integer productId, String productType, Integer wareHouseId, Float purchaseUnitPrice, Float wholesaleUnitPrice, Float retailUnitPrice, Integer inventory, String supplierName, String supplierContact, String supplierAddress) {
        this.productId = productId;
        this.productType = productType;
        this.wareHouseId = wareHouseId;
        this.purchaseUnitPrice = purchaseUnitPrice;
        this.wholesaleUnitPrice = wholesaleUnitPrice;
        this.retailUnitPrice = retailUnitPrice;
        this.inventory = inventory;
        this.supplierName = supplierName;
        this.supplierContact = supplierContact;
        this.supplierAddress = supplierAddress;
    }
}
