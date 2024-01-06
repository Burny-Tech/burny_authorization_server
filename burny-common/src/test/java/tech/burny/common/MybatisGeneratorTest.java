package tech.burny.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.sql.Types;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tech.burny.common.constant.Constants;

@SpringBootTest(classes = {Constants.class})

public class MybatisGeneratorTest {

    @Test
    void contextLoads() {



        FastAutoGenerator.create("jdbc:mysql://192.168.1.62:3306/burny", "burny", "Burny@2024")
                .globalConfig(builder -> {
                    builder.author("cyx") // 设置作者
                            // 开启 swagger 模式 默认不开启
                            .enableSwagger()
                            .outputDir("E://mkdir"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("tech.burny.security");
                            // 设置父包模块名
                            //.moduleName("mapper")
                            // 设置mapperXml生成路径
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/liuph/dev/space/idea/iterge_pre/src/main/resources/mapper"));
                })
//                .strategyConfig(builder -> {
//                    // 设置需要生成的表名
//                    builder.addInclude("t_user,user_info");
//                    // 设置过滤表前缀
//                    //.addTablePrefix("t_", "c_");
//                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .templateEngine(new BeetlTemplateEngine())
                .templateEngine(new FreemarkerTemplateEngine())
                .strategyConfig(b -> new StrategyConfig.Builder()
                        .entityBuilder()
                        .enableLombok()
                        .enableFileOverride()
                        .build())
                .execute();

    }
}
