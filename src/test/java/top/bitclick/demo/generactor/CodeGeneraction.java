package top.bitclick.demo.generactor;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CodeGeneraction {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        String tableName = "user,employee_tml";
        String projectPath = "E:/My_Works/projects/mp-demo/src/main/java";
        String projectRoot = "E:/My_Works/projects/mp-demo";
        String parentName = "top.bitclick.demo";

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath);  //输出路径
        gc.setAuthor("Xie Yingchao");  //作者
        gc.setOpen(false);             //是否打开资源浏览器
        gc.setSwagger2(true);          //是否配置swagger2
        gc.setFileOverride(true);      //是否覆盖原文件
        gc.setBaseResultMap(true);     //是否设置resultMap
        gc.setEnableCache(false);      //xml 二级缓存
        gc.setBaseColumnList(true);    //xml ColumnLis
        //gc.setIdType(IdType.AUTO);     //主键自增策略

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        //配置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        mpg.setDataSource(dsc);

        //包配置,设置包名
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentName);
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setEntityLombokModel(true);                //开启lombok
        strategy.setRestControllerStyle(true);              //开启restful风格
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名映射实体类名的生成策略
        strategy.setInclude(tableName);                      // 需要生成的表名，与数据库对应
        strategy.setTablePrefix("");                        //去除表前缀
        strategy.setFieldPrefix("");                        //去除字段前缀

        //strategy.setSuperServiceClass((Class<?>) null);
        //strategy.setSuperServiceImplClass((Class<?>) null);
        //strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectRoot + "/src/main/resources/mybatis/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null); //指定生成的模板，设置成null将不生成文件
        mpg.setTemplate(tc);

        mpg.execute();
    }
}
