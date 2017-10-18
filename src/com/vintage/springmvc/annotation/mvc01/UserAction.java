package com.vintage.springmvc.annotation.mvc01;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Controller标明是实现Controller接口，供spring扫描// @RequestMapping("/user")标识是公共的访问路径，
 * 类似struts2中的namespace
 * 
 * @author Asus
 *
 */
@RequestMapping("/user")
@Controller
public class UserAction {

	/**
	 * 默认情况下，springmvc不能将String类型转成java.util.Date类型，所有我们只能在Action中自定义类型转换器
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	// 业务控制方法中书写1个模型User来收集客户端的参数
	// 模型中的属性名必须和客户端参数名一一对应
	// 限制只能用post方式 访问
	// @RequestMapping(value = "/register")
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String register(Model model, User user) throws Exception {
		System.out.println(user);
		model.addAttribute("message", "注册成功");
		model.addAttribute("user", user);
		return "success";
	}

	@RequestMapping("/login")
	public String login(Model model, String username, String password) throws Exception {
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		model.addAttribute("username", username);
		model.addAttribute("message", "登录成功");
		return "success";
	}

	// 获取客户端的数组参数（CheckBox）
	@RequestMapping("/hobby")
	public String hobby(Model model, String[] hobbies) throws Exception {
		for (String hobby : hobbies) {
			System.out.println("hobby = " + hobby);
		}

		model.addAttribute("message", "爱好提交成功");
		return "success";
	}

	// 通过转发将参数传递到下一个action
	@RequestMapping("/find")
	public String find(Model model, String id) throws Exception {
		System.out.println("查询id = " + id);
		// 重定向，
		model.addAttribute("id", id);
		return "redirect:/user/update.action";
		// 转发，转发会共享request域对象，参数会共享
		// return "forward:/user/update.action";
	}

	@RequestMapping("/update")
	public String update(Model model, String id) throws Exception {
		System.out.println("更新id = " + id);
		model.addAttribute("message", "用户更新成功" + id);
		return "success";
	}
}
