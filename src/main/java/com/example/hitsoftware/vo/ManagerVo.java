package com.example.hitsoftware.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ManagerVo {

    @TableId
    private String managerName;
    private String managerContact;
    private String address;
}
