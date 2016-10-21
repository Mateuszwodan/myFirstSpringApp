package com.mycompany.app;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping("/")
    	public ResponseEntity<Object> redirectToExternalUrl() throws URISyntaxException {
    	    URI yahoo = new URI("https://boiling-springs-13455.herokuapp.com/index.html#/");
    	    HttpHeaders httpHeaders = new HttpHeaders();
    	    httpHeaders.setLocation(yahoo);
    	    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    	}
    
    @RequestMapping(value = "/next", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody Answer printSomething() {
        Answer ans = new Answer();
        ans.setname("Jarek");
        ans.setvalue("cos tam");
        return ans;
    }
	
    @RequestMapping(value = "/processText", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess processSomeText(@RequestBody TextToProcess textToProcess) {
        TextToProcess ans = new TextToProcess();
        ans.settext(appService.processText(textToProcess));
        return ans;
    }

}
