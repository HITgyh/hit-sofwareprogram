package com.example.hitsoftware.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hitsoftware.entity.Product;
import com.example.hitsoftware.mapper.ProductMapper;
import com.example.hitsoftware.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * Package: com.example.hitsoftware.service.Impl
 * Discription:
 *
 * @Author: JUSTIN
 * @Create:6/28/2023 - 11:44 AM
 * @Version:
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
}
