package com.wufeng.code.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author niuyq
 * @date 2021-12-9
 */
public class JsonUtil {

    /**
     * JSON对象转JAVA实体对象 （json对象key值支持下划线分割格式）
     *
     * @param jsonObject
     * @param t
     * @param <T>
     */
    public static <T> void json2Bean(JSONObject jsonObject, T t) {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        Set<String> collect = Arrays.asList(declaredFields).stream().map(it -> it.getName()).collect(Collectors.toSet());
        jsonObject.entrySet().stream()
                .filter(item -> collect.contains(StrUtil.toCamelCase(item.getKey())))
                .forEach(item -> BeanUtil.setProperty(t, StrUtil.toCamelCase(item.getKey()), item.getValue()));
    }
}
