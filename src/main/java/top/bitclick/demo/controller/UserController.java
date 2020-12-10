package top.bitclick.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.bitclick.demo.entity.User;
import top.bitclick.demo.mapper.UserMapper;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xie Yingchao
 * @since 2020-12-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	

	@GetMapping("/hello")
	public String sayHello(){
		return "hello world";
	}

	@GetMapping("/select/{name}")
	public List<User> getUser(@PathVariable String name){
		return userMapper.selectAllByName(name);
	}

}

