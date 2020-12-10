package top.bitclick.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill");
        /**
         * @metaObject: 元数据
         * @fieldNmae: 需要填充的字段名
         * @fieldType: 字段类型
         * @fieldVal: 字段值
         */
        this.strictInsertFill(metaObject, "createTime", LocalDate.class, LocalDate.now());
        this.strictUpdateFill(metaObject, "updateTime", LocalDate::now, LocalDate.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill");
        this.strictUpdateFill(metaObject, "updateTime", LocalDate::now, LocalDate.class);
    }
}
