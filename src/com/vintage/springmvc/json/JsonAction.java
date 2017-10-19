package com.vintage.springmvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonAction {

	// 1.����jackson-core-asl-1.9.11.jar
	// jackson-mapper-asl-1.9.11.jar�İ�
	// 2.����������
	// ����json��ʽ���ݣ�@ResponseBody��ʶ��Person����ת��Ϊjson�ı�
	@RequestMapping("/entity")
	public @ResponseBody Person add(Person person) throws Exception {
		System.out.println(person);
		return person;
	}

	// Listתjson
	@RequestMapping("/list")
	public @ResponseBody List<Person> list() throws Exception {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("kiki", 10000.0));
		persons.add(new Person("vintage", 20000.0));
		return persons;
	}

	// Mapתjson
	@RequestMapping("/map")
	public @ResponseBody Map<String, Person> map() throws Exception {
		Map<String, Person> persons = new HashMap<String, Person>();
		persons.put("kik", new Person("kiki", 10000.0));
		persons.put("vin", new Person("vintage", 20000.0));
		return persons;
	}

	// datagrid
	@RequestMapping("/datagrid")
	public @ResponseBody Map<String, Object> datagrid() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("kiki", 10000.0));
		persons.add(new Person("vintage", 20000.0));
		persons.add(new Person("jordan", 10000.0));
		persons.add(new Person("bryant", 20000.0));
		persons.add(new Person("james", 10000.0));
		persons.add(new Person("rose", 20000.0));
		map.put("total", persons.size());
		map.put("rows", persons);
		return map;
	}
}
