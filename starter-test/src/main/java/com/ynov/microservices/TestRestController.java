package com.ynov.microservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestRestController {

	@GetMapping("/{title}")
	public Pojo getPojo(@PathVariable("title") String title, @RequestParam(value = "description",required = false) String description) {
		System.out.println(this);
		Pojo pojo = new Pojo();
		pojo.setDescription("super description : " + description);
		pojo.setTitle("super titre : " + title);
		return pojo;
	}
	
	@PostMapping("/")
	public Pojo getPojo2(@RequestBody Pojo pojoGet) {
		System.out.println(this);
		Pojo pojo = new Pojo();
		pojo.setDescription("super description : " + pojoGet.getDescription());
		pojo.setTitle("super titre : " + pojoGet.getTitle());
		return pojo;
	}
	
}
