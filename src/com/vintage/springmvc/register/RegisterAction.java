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
 * ��ӱ��������������ת����
 * 
 * @author Asus
 *
 */
@SuppressWarnings("deprecation")
public class RegisterAction extends AbstractCommandController {

	public RegisterAction() {
		// ��������Ϊusername����ӦUser�е�username���ԣ��������Բ�Ϊusername����ȡ�����ֵ�����ᱨ��
		this.setCommandClass(User.class);
	}

	/**
	 * ������ת�������Զ���ת����
	 */
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		// ��springMVC�ڲ�ע��һ���Զ��������ת����������1������Ŀ�����ͣ�����2���������Ա༭�����Զ���ת������
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@Override
	protected ModelAndView handle(//
			HttpServletRequest req, //
			HttpServletResponse resp, //
			Object param, // ��װ���������
			BindException e) throws Exception {
		// ��ʱʹ��req.setCharacterEncoding("utf-8")�Ѳ��ܽ�������������⣬��Ҫ��doPOST��ִ��req.getParameter("xxx")֮ǰִ�У�������Ч
		req.setCharacterEncoding("utf-8");
		ModelAndView modelAndView = new ModelAndView();
		// ModelAndView����������Struts2�е�ActionContext�������ڷ�װ�����Ͷ��󣬴��κʹ�ֵ
		User user = (User) param;
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/jsp/index.jsp");
		return modelAndView;
	}

}
