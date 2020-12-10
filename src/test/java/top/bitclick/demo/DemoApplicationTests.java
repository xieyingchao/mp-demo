package top.bitclick.demo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.bitclick.demo.entity.User;
import top.bitclick.demo.enums.SexEnum;
import top.bitclick.demo.mapper.UserMapper;
import top.bitclick.demo.model.MyPage;
import top.bitclick.demo.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void testMP(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("id",2);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testOptimisticLocker(){
        User user = userMapper.selectById(1L);
        user.setName("xieyingchao");
        int num = userMapper.updateById(user);
        System.out.println(num);
    }

    @Test
    void testOptimisticLocker2(){
        User user = userMapper.selectById(1L);
        user.setName("xieyingchao");

        User user1 = userMapper.selectById(1L);
        user1.setName("tangcongxuan");
        int num2 = userMapper.updateById(user1);
        System.out.println(num2);

        int num = userMapper.updateById(user);
        System.out.println(num);
    }

    @Test
    void testLogicDelete(){
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(2);
        objects.add(3);
        userMapper.deleteBatchIds(objects);
    }

    @Test
    void testAutoFill(){
        User user = new User();
        //user.setId(9L);
        user.setName("hanha");
        userMapper.insert(user);

        User user2 = new User();
        user2.setId(6L);
        user2.setAge(22);
        userService.updateById(user2);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(8L);
        userMapper.updateById(user);
    }

    @Test
    void testPagination(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    @Test
    void testSelectAllByName(){
        List<User> xiaoxie = userService.selectAllByName("xiaoxie");
        xiaoxie.forEach(System.out::println);
    }

    @Test
    void testMyPagination(){
        Page<User> page = new Page<>(2,2);
        List<User> users = userMapper.selectAllByNamePagination(page, "xiaoxie");
        //page.getRecords().forEach(System.out::println);
        users.forEach(System.out::println);
    }

    @Test
    void testMyPagination1(){
        MyPage<User> myPage = new MyPage<>(1, 2);
        myPage.setAge(18);
        userMapper.mySelectPage(myPage,"xiaoxie");
        myPage.getRecords().forEach(System.out::println);
    }

    @Test
    void testEnum(){
        User user = new User();
        user.setName("hahaha");
        user.setAge(22);
        user.setSex(SexEnum.FEMALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    void testDynamicalSql(){
        String name = "xiaoxie";
        List<User> users = userMapper.selectAllByNameAge(name, 18);
        users.forEach(System.out::println);
    }
}
