package com.mycompany.app;

import org.springframework.stereotype.Component;

@Component
public class Answer {
	String name;
	String value;
	
	public void setname(String x)
	{
		name = x;
	}
	public void setvalue(String x)
	{
		value = x;
	}
	public String getname()
	{
		return name;
	}
	public String getvalue()
	{
		return value;
	}

}
