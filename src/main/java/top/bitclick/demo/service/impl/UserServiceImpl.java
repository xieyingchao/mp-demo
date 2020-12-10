package top.bitclick.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.bitclick.demo.entity.User;
import top.bitclick.demo.mapper.UserMapper;
import top.bitclick.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xie Yingchao
 * @since 2020-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAllByName(String name) {
        return userMapper.selectAllByName(name);
    }
}
