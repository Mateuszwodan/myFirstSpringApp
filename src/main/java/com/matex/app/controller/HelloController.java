package com.matex.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.matex.app.database.DAO.TransactionDAO;
import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.model.Users;
import com.matex.app.model.to.Answer;
import com.matex.app.model.to.ClientTo;
import com.matex.app.model.to.TextToProcess;
import com.matex.app.model.to.TransactionTo;
import com.matex.app.model.to.UsersTo;
import com.matex.app.service.App;
import com.matex.app.service.DatabaseService;
import com.matex.app.service.UserService;

@RestController
@CrossOrigin
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
    public  @ResponseBody TextToProcess saveUser(@RequestBody ClientTo clientTo) {
    	ClientTo client = new ClientTo(clientTo.getEmail(), clientTo.getName());
        TextToProcess ans = new TextToProcess();
        ans.settext(databaseService.saveUser(client));
        return ans;
    }
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<ClientTo> showUsers() {
    	List<ClientTo> clients = databaseService.getAllUsers();
        return clients;
    }
    @RequestMapping(value = "/getUsers123", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<Users> getUsers() {
    	return userService.getAll();
    }
    @RequestMapping(value = "/getTransactions", method = RequestMethod.GET, produces = "application/json")
    public  @ResponseBody List<TransactionTo> getTransactions() {
    	List<TransactionTo> transactions = databaseService.getAllTransactions();
    	return transactions;
    }
    @RequestMapping(value = "/saveTransaction", method = RequestMethod.POST, produces = "application/json")
    public  @ResponseBody TextToProcess saveTransaction(String debtor, String creditor, Double debt) {
    	
    	UsersTo first;
    	UsersTo second;
    	try{
    	first = userService.getUserByUsername(debtor);
    	second = userService.getUserByUsername(creditor);
    	}catch(Exception e)
    	{
    		return null;
    	}
    	TransactionTo transactionTo = new TransactionTo(first, second, debt); 	
        TextToProcess ans = new TextToProcess();
        ans.settext(databaseService.saveTransaction(transactionTo));
        return ans;
    }

}
