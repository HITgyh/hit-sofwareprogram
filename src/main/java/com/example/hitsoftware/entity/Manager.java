package com.example.hitsoftware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("manager")
public class Manager {

    @TableId
    private String managerName;
    private String managerContact;
    private String managerAddress;

    public Manager(String managerName, String managerContact, String managerAddress) {
        this.managerName = managerName;
        this.managerContact = managerContact;
        this.managerAddress = managerAddress;
    }
}
