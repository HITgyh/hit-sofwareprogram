package com.example.hitsoftware.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SupplierVo {

    @TableId
    private String supplierName;
    private String supplierContact;
    private String supplierAddress;
}
