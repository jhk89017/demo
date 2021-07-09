package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	/* getMapping으로 가져옴 */
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "홍길동");
		//hong이 주석 달았습니다.
		return "hello";	//=> templates/hello.html 을 찾는 것
	}
	
	@GetMapping("/apiTest1")
	@ResponseBody
	public String api_String(@RequestParam String name) {
		return "hello!" + name;
		
		//http://localhost:9091/apiTest1?name=hong
		//=> 결과 : hello! hong
	}
	
	@GetMapping("/apiTest2")
	@ResponseBody
	public Person api_object(@RequestParam String name, @RequestParam int age) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		
		return p;
		
		//http://localhost:9091/apiTest2?name=hong&age=20
		//=> 결과 - json의 형태로 {"name":"hong","age":20}
	}
	
}//

class Person {
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
