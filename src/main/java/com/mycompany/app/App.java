package com.mycompany.app;

import org.springframework.stereotype.Service;

/**
 * Hello world!
 *
 */
@Service
public class App 
{
    public String thisIsTheText()
    {
    	return "Print me";
    }
    public String processText(TextToProcess textToProcess)
    {
    	return new StringBuilder(textToProcess.gettext()).reverse().toString();
    }
}
