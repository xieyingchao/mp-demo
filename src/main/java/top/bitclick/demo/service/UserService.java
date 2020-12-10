package top.bitclick.demo.service;

import top.bitclick.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xie Yingchao
 * @since 2020-12-05
 */
public interface UserService extends IService<User> {

    List<User> selectAllByName(String name);

}
