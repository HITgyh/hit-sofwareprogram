package com.example.hitsoftware.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hitsoftware.entity.Indent;
import com.example.hitsoftware.mapper.GoodsMapper;
import com.example.hitsoftware.service.IIndentService;
import org.springframework.stereotype.Service;

@Service
public class IndentServiceImpl extends ServiceImpl<GoodsMapper, Indent> implements IIndentService {
}
