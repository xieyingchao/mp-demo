package top.bitclick.demo.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyPage<T> extends Page<T> {

    private int age;

    public MyPage(long current, long size){
        super(current, size);
    }
}
