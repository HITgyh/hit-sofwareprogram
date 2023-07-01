package com.example.hitsoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * Package: com.example.hitsoftware.entity
 * Discription:
 *
 * @Author: JUSTIN
 * @Create:6/28/2023 - 9:59 AM
 * @Version:
 */
@Data
@TableName("warehouse")
public class WareHouse {

    @TableId
    private Integer wareHouseId;
    private String wareHouseAddress;
    private String managerName;
    private String managerContact;
    private String managerAddress;

    public WareHouse(Integer wareHouseId, String wareHouseAddress, String managerName, String managerContact, String managerAddress) {
        this.wareHouseId = wareHouseId;
        this.wareHouseAddress = wareHouseAddress;
        this.managerName = managerName;
        this.managerContact = managerContact;
        this.managerAddress = managerAddress;

    }
}
