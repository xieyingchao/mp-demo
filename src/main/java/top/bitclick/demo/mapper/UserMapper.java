package top.bitclick.demo.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.bitclick.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.bitclick.demo.model.MyPage;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Xie Yingchao
 * @since 2020-12-05
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAllByName(String name);

    List<User> selectAllByNamePagination(Page<User> page,String name);

    MyPage<User> mySelectPage(MyPage<User> myPage, String name);  //传入自定义Page对象

    List<User> selectAllByNameAge(String name, Integer age);
}
