package com.example.hitsoftware.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class CustomerVo {

    @TableId
    private String customerName;
    private String customerContact;
    private String customerAddress;
}
