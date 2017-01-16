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
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.matex.app.database.DAO.TransactionDAO;
import com.matex.app.model.User;
import com.matex.app.model.to.Answer;
import com.matex.app.model.to.TextToProcess;
import com.matex.app.model.to.TransactionTo;
import com.matex.app.model.to.UsersTo;
import com.matex.app.service.App;
import com.matex.app.service.DatabaseService;
import com.matex.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class HelloController {
	
	private final App appService;
	private final DatabaseService databaseService;
	private final UserService userService;
	private final TransactionDAO transactionDAO;
	
	@Autowired
	public HelloController(App appService, DatabaseService databaseService, UserService userService, TransactionDAO Transaction)
	{
	this.appService = appService;	
	this.databaseService = databaseService;
	this.userService = userService;
	this.transactionDAO = Transaction;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    public  @ResponseBody TextToProcess saveUser(@RequestBody UsersTo usersTo) {
    	UsersTo users = new UsersTo(usersTo.getUsername(), usersTo.getPassword(), usersTo.getEnabled());
        TextToProcess ans = new TextToProcess();
        ans.settext(databaseService.saveUser(users));
        return ans;
    }
    @RequestMapping(value = "/getUsers123", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<User> getUsers() {
    	return userService.getAll();
    }
    @RequestMapping(value = "/getTransactions", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<TransactionTo> getTransactions(Principal principal) {
    	List<TransactionTo> transactions = databaseService.getAllTransactions();
    	//System.out.println(principal.getName());
    	//System.out.println(principal.toString());
    	return transactions;
    }
    @RequestMapping(value = "/saveTransaction", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess saveTransaction(@RequestBody TransactionTo transactionTo) {
    	
    	UsersTo first;
    	UsersTo second;
    	TextToProcess ans;
    	ans = new TextToProcess();
    	try{
    	first = userService.getUserByUsername(transactionTo.getDebtor().getUsername());
    	second = userService.getUserByUsername(transactionTo.getCreditor().getUsername());
    	}catch(Exception e)
    	{
    		ans.settext("Error");
    		return ans;
    	}
    	TransactionTo trans = new TransactionTo(first, second, transactionTo.getDebt(), transactionTo.getDescription()); 	
        ans.settext(databaseService.saveTransaction(trans));
        return ans;
    }
    @RequestMapping(value = "/deleteTransaction", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess deleteTransaction(@RequestBody TransactionTo transactionTo) {
    	
    	UsersTo first;
    	UsersTo second;
    	TextToProcess ans;
    	ans = new TextToProcess();
    	try{
    	first = userService.getUserByUsername(transactionTo.getDebtor().getUsername());
    	second = userService.getUserByUsername(transactionTo.getCreditor().getUsername());
    	}catch(Exception e)
    	{
    		ans.settext("Error");
    		return ans;
    	}
    	TransactionTo trans = new TransactionTo(first, second, transactionTo.getDebt(), transactionTo.getDescription(), transactionTo.getId()); 	
        ans.settext(databaseService.deleteTransaction(trans));
        return ans;
    }


}
