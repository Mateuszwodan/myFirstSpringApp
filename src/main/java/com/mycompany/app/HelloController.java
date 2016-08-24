package com.mycompany.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private final App appService;
	
	@Autowired
	public HelloController(App appService)
	{
	this.appService = appService;	
	}

    @RequestMapping("/")
    public String index() {
        return appService.thisIsTheText();
    }
    
    @RequestMapping("/next")
    public String printSomething() {
        return appService.thisIsTheText().concat(" and more");
    }

}
