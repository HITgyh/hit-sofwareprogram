package com.example.hitsoftware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hitsoftware.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper extends BaseMapper<Customer> {
}
