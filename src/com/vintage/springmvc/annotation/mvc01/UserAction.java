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
 * @Controller������ʵ��Controller�ӿڣ���springɨ��// @RequestMapping("/user")��ʶ�ǹ����ķ���·����
 * ����struts2�е�namespace
 * 
 * @author Asus
 *
 */
@RequestMapping("/user")
@Controller
public class UserAction {

	/**
	 * Ĭ������£�springmvc���ܽ�String����ת��java.util.Date���ͣ���������ֻ����Action���Զ�������ת����
	 * 
	 * @param request
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	// ҵ����Ʒ�������д1��ģ��User���ռ��ͻ��˵Ĳ���
	// ģ���е�����������Ϳͻ��˲�����һһ��Ӧ
	// ����ֻ����post��ʽ ����
	// @RequestMapping(value = "/register")
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String register(Model model, User user) throws Exception {
		System.out.println(user);
		model.addAttribute("message", "ע��ɹ�");
		model.addAttribute("user", user);
		return "success";
	}

	@RequestMapping("/login")
	public String login(Model model, String username, String password) throws Exception {
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		model.addAttribute("username", username);
		model.addAttribute("message", "��¼�ɹ�");
		return "success";
	}

	// ��ȡ�ͻ��˵����������CheckBox��
	@RequestMapping("/hobby")
	public String hobby(Model model, String[] hobbies) throws Exception {
		for (String hobby : hobbies) {
			System.out.println("hobby = " + hobby);
		}

		model.addAttribute("message", "�����ύ�ɹ�");
		return "success";
	}

	// ͨ��ת�����������ݵ���һ��action
	@RequestMapping("/find")
	public String find(Model model, String id) throws Exception {
		System.out.println("��ѯid = " + id);
		// �ض���
		model.addAttribute("id", id);
		return "redirect:/user/update.action";
		// ת����ת���Ṳ��request����󣬲����Ṳ��
		// return "forward:/user/update.action";
	}

	@RequestMapping("/update")
	public String update(Model model, String id) throws Exception {
		System.out.println("����id = " + id);
		model.addAttribute("message", "�û����³ɹ�" + id);
		return "success";
	}
}
