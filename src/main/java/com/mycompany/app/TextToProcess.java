package com.mycompany.app;

import org.springframework.stereotype.Component;

@Component
public class TextToProcess {

	private String text;

	public String gettext() {
		return text;
	}

	public void settext(String text) {
		this.text = text;
	}
}
