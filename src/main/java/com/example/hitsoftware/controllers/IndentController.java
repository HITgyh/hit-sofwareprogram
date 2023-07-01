package com.example.hitsoftware.controllers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hitsoftware.entity.Indent;
import com.example.hitsoftware.service.IIndentService;
import com.example.hitsoftware.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/indent")
public class IndentController {

    @Autowired
    IIndentService indentService;

    /**
     * 添加订单的方法
     * @param indent 订单
     * @return 结果类
     */
    @PostMapping("/add")
    public Result addIndent(@RequestBody Indent indent){
        log.info("indent add, indent={}",indent);
        Indent indent1 = indentService.getById(indent.getIndentId());
        if(null!=indent1)
            return Result.fail("indent exists");
        indentService.save(indent);
        return Result.success();
    }

    /**
     * 删除订单的方法
     * @param id 订单编号
     * @return 结果类
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteIndent(@PathVariable Integer id){
        log.info("indent add, id={}",id);
        Indent indent = indentService.getById(id);
        if(null==indent)
            return Result.fail("indent not exists");
        indentService.removeById(id);
        return Result.success();
    }

    /**
     * 某一订单详细信息
     * @param id 订单编号
     * @return 结果
     */
    @GetMapping("/detail/{id}")
    public Result detailIndent(@PathVariable Integer id){
        log.info("indent add, id={}",id);
        Indent indent = indentService.getById(id);
        if(null==indent)
            return Result.fail("indent not exists");
        return Result.success(indent);
    }

    /**
     * 全部订单列表
     * @param pageNum 页码
     * @param pageSize 页容量
     * @return 结果
     */
    @GetMapping("/list")
    public Result listIndent(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "30")int pageSize){
        log.info("indent list, pageNum={} pageSize={}",pageNum,pageSize);
        Page<Indent> page = new Page<>(pageNum,pageSize);
        IPage<Indent> iPage = indentService.page(page);
        return Result.success(iPage);
    }

    /**
     * 修改某一订单
     * @param indent 修改后订单
     * @return 结果
     */
    @PutMapping("/edit")
    public Result editIndent(@RequestBody Indent indent){
        log.info("indent list, indent={}",indent);
        this.deleteIndent(indent.getIndentId());
        this.addIndent(indent);
        return Result.success();
    }
}
