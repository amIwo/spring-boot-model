package com.wufeng.code.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author niuyq
 * @date 20211213
 * https://baomidou.com/guide/generator-new.html#%E4%BB%A3%E7%A0%81%E7%94%9F%E6%88%90%E5%99%A8
 */
public class AutoGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/spring-boot-model?serverTimezone=Asia/Shanghai", "wg", "wg%2017")
                .globalConfig(builder -> {
                    builder.author("niuyq") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\xuexi\\spring-boot-model\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.wufeng.code") // 设置父包名
                            .moduleName("dao") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\xuexi\\spring-boot-model\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("airport_info") // 设置需要生成的表名
                            // 设置过滤表前缀,生成的实体类会把前缀去掉
                            // .addTablePrefix("")
                            // 开启生成@RestController 控制器,开启驼峰转连字符
                            .controllerBuilder().enableRestStyle().enableHyphenStyle()
                            // 开启 @Mapper 注解,启用 BaseResultMap 生成,启用 BaseColumnList
                            .mapperBuilder().enableMapperAnnotation().enableBaseResultMap().enableBaseColumnList()
                            //  开启 lombok 模型,全局主键类型
                            .entityBuilder().enableLombok().idType(IdType.AUTO)
                            .build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

        FreemarkerTemplateEngine freemarkerTemplateEngine = new FreemarkerTemplateEngine();
    }
}
