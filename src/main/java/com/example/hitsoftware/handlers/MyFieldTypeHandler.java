package com.example.hitsoftware.handlers;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.example.hitsoftware.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


@MappedTypes({Object.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyFieldTypeHandler extends AbstractJsonTypeHandler<Object> {
    private static final Logger log = LoggerFactory.getLogger(JacksonTypeHandler.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    public MyFieldTypeHandler(Class<?> type) {
        if (log.isTraceEnabled()) {
            log.trace("JacksonTypeHandler(" + type + ")");
        }
        Assert.notNull(type, "Type argument cannot be null", new Object[0]);
    }

    protected Object parse(String json) {
        try {
            // 这里进行了json解析，同样在这里也可以进行字段查询后的处理，如对象内部的手机号字段的加密展示等
            return getObjectMapper().readValue(json, new TypeReference<Product>(){});
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    protected String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException var3) {
            throw new RuntimeException(var3);
        }
    }
    public static ObjectMapper getObjectMapper() {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }

        return objectMapper;
    }
    public static void setObjectMapper(ObjectMapper om) {
        objectMapper = om;
    }
}
