package com.example.hitsoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("courier")
public class Courier {

    @TableId
    private String courierName;
    private String courierContact;
    private String courierFree;

    public Courier(String courierName, String courierContact, String courierFree) {
        this.courierName = courierName;
        this.courierContact = courierContact;
        this.courierFree = courierFree;
    }
}
