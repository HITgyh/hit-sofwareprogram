package com.example.hitsoftware.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hitsoftware.entity.Product;
import com.example.hitsoftware.entity.User;
import com.example.hitsoftware.mapper.ProductMapper;
import com.example.hitsoftware.service.IProductService;
import com.example.hitsoftware.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Package: com.example.hitsoftware.controllers
 * Discription:
 *
 * @Author: JUSTIN
 * @Create:6/28/2023 - 11:53 AM
 * @Version:
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ProductMapper productMapper;

    /**
     * 添加商品的方法
     * @param product 商品
     * @return 结果类
     */
    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product){
        log.info("product add, product={}",product);
        Product product1 = productService.getById(product.getProductId());
        if(null!=product1)
            return Result.fail("Product already exists");
        productService.save(product);
        return Result.success();
    }

    /**
     * 删除商品
     * @param id 商品ID编号
     * @return 结果类
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteProduct(@PathVariable int id){
        log.info("product add, id={}",id);
         Product product = productService.getById(id);
        if(null==product)
            return Result.fail("Product do not exist");
        productService.removeById(id);
        return Result.success();
    }

    /**
     * 某一商品详细信息
     * @param id 商品id
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public Result detailProduct(@PathVariable int id){
        log.info("product add, id={}",id);
        Product product = productMapper.selectById(id);
        //Product product = productService.getById(id);
        if(null==product)
            return Result.fail("Product do not exist");
        return Result.success(product);
    }

    /**
     * 全部商品列表
     * @param pageNum 页码
     * @param pageSize 页容量
     * @return 结果
     */
    @GetMapping("/list")
    public Result listProduct(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "30")int pageSize){
        log.info("product list, pageNum={} pageSize={}",pageNum,pageSize);
        Page<Product> page = new Page<>(pageNum,pageSize);
        IPage<Product> iPage = productService.page(page);
        return Result.success(iPage);
    }

    /**
     * 根据仓库筛选商品，可以查看某一仓库的商品列表
     * @param pageNum 页码
     * @param pageSize 页容量
     * @param num 仓库编号
     * @return 返回页码形式的商品列表
     */
    @GetMapping("/repository")
    public Result repositoryProduct(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "30")int pageSize,int num){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*").eq("ware_house_id",num);
        Page<Product> page = new Page<>(pageNum, pageSize);
        IPage<Product> iPage = productMapper.selectPage(page, queryWrapper);
        return Result.success(iPage);
    }

    /**
     * 修改某一商品信息
     * @param product 修改后的商品
     * @return 结果
     */
    @PutMapping("/edit")
    public Result editOrder(@RequestBody Product product){
        log.info("product list, product={}",product);
        this.deleteProduct(product.getProductId());
        this.addProduct(product);
        return Result.success();
    }
}

