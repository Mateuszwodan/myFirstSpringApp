package com.mycompany.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private final App appService;
	
	@Autowired
	public HelloController(App appService)
	{
	this.appService = appService;	
	}

	@CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/")
    public String index() {
        return appService.thisIsTheText();
    }
    
	@CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/next", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody Answer printSomething() {
        Answer ans = new Answer();
        ans.setname("Jarek");
        ans.setvalue("cos tam");
        return ans;
    }
	
	@CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/processText", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess processSomeText(@RequestBody TextToProcess textToProcess) {
        TextToProcess ans = new TextToProcess();
        ans.settext(appService.processText(textToProcess));
        return ans;
    }

}
