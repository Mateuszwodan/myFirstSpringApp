package com.matex.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.matex.app.model.User;
import com.matex.app.model.DTO.Answer;
import com.matex.app.model.DTO.TextToProcess;
import com.matex.app.model.DTO.TransactionDTO;
import com.matex.app.model.DTO.UserDTO;
import com.matex.app.service.App;
import com.matex.app.service.DatabaseService;
import com.matex.app.service.UserService;

@RestController
@CrossOrigin(origins = "https://myfirstspringapp.herokuapp.com/")
public class HelloController {
	
	private final App appService;
	private final DatabaseService databaseService;
	private final UserService userService;
	
	@Autowired
	public HelloController(App appService, DatabaseService databaseService, UserService userService)
	{
	this.appService = appService;	
	this.databaseService = databaseService;
	this.userService = userService;
	}

    @RequestMapping("/")
    	public ResponseEntity<Object> redirectToExternalUrl() throws URISyntaxException {
    	    URI yahoo = new URI("http://localhost:8080/index.html#/");
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
    @PreAuthorize("hasRole('ROLE_USER')")
    public  @ResponseBody TextToProcess processSomeText(@RequestBody TextToProcess textToProcess) {
        TextToProcess ans = new TextToProcess();
        ans.settext(appService.processText(textToProcess));
        return ans;
    }
    @RequestMapping(value = "/googleIt", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess GoogleIt(@RequestBody TextToProcess textToProcess) {
        TextToProcess ans = new TextToProcess();
        ans.settext(appService.googleIt(textToProcess.gettext()));
        return ans;
    }
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess saveUser(@RequestBody UserDTO usersTo) {
        TextToProcess ans = new TextToProcess();
        ans.settext(databaseService.saveUser(usersTo));
        return ans;
    }
    @RequestMapping(value = "/getUsers123", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<User> getUsers() {
    	return userService.getAll();
    }
    @RequestMapping(value = "/getTransactions", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<TransactionDTO> getTransactions(Principal principal) {
    	List<TransactionDTO> transactions = databaseService.getAllTransactions();
    	//System.out.println(principal.getName());
    	//System.out.println(principal.toString());
    	return transactions;
    }
    @RequestMapping(value = "/saveTransaction", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess saveTransaction(@RequestBody TransactionDTO transactionTo) {
    	
    	UserDTO first;
    	UserDTO second;
    	TextToProcess ans;
    	ans = new TextToProcess();
    	try{
    	first = userService.getUserByUsername(transactionTo.getDebtor().getName());
    	second = userService.getUserByUsername(transactionTo.getCreditor().getName());
    	}catch(Exception e)
    	{
    		ans.settext("Error");
    		return ans;
    	}
    	TransactionDTO trans = new TransactionDTO(first, second, transactionTo.getDebt(), transactionTo.getDescription()); 	
        ans.settext(databaseService.saveTransaction(trans));
        return ans;
    }
    @RequestMapping(value = "/deleteTransaction", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess deleteTransaction(@RequestBody TransactionDTO transactionTo) {
    	
    	UserDTO first;
    	UserDTO second;
    	TextToProcess ans;
    	ans = new TextToProcess();
    	try{
    	first = userService.getUserByUsername(transactionTo.getDebtor().getName());
    	second = userService.getUserByUsername(transactionTo.getCreditor().getName());
    	}catch(Exception e)
    	{
    		ans.settext("Error");
    		return ans;
    	}
    	TransactionDTO trans = new TransactionDTO(first, second, transactionTo.getDebt(), transactionTo.getDescription(), transactionTo.getId()); 	
        ans.settext(databaseService.deleteTransaction(trans));
        return ans;
    }


}
