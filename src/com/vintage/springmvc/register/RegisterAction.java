package com.vintage.springmvc.register;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

/**
 * 添加编码过滤器和日期转换器
 * 
 * @author Asus
 *
 */
@SuppressWarnings("deprecation")
public class RegisterAction extends AbstractCommandController {

	public RegisterAction() {
		// 表单中属性为username，对应User中的username属性，若表单属性不为username，则取出后空值，不会报错
		this.setCommandClass(User.class);
	}

	/**
	 * 绑定日期转换器，自定义转换器
	 */
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		// 向springMVC内部注入一个自定义的类型转换器：参数1，所需目标类型；参数2，所需属性编辑器（自定义转换规则）
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@Override
	protected ModelAndView handle(//
			HttpServletRequest req, //
			HttpServletResponse resp, //
			Object param, // 封装的请求参数
			BindException e) throws Exception {
		// 此时使用req.setCharacterEncoding("utf-8")已不能解决中文乱码问题，需要在doPOST中执行req.getParameter("xxx")之前执行，否则不生效
		req.setCharacterEncoding("utf-8");
		ModelAndView modelAndView = new ModelAndView();
		// ModelAndView对象类似于Struts2中的ActionContext对象，用于封装参数和对象，传参和传值
		User user = (User) param;
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/jsp/index.jsp");
		return modelAndView;
	}

}
