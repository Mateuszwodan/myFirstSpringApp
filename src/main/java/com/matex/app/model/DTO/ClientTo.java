package com.matex.app.model.to;

import org.springframework.stereotype.Component;

@Component
public class ClientTo {


		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		private long id;

		private String email;

		private String name;
		
		public ClientTo()
		{}
		public ClientTo(long id)
		{
			this.id = id;
		}
		public ClientTo(String email, String name, long id) {
			this.email = email;
			this.name = name;
			this.id = id;
		}
		public ClientTo(String email, String name) {
			this.email = email;
			this.name = name;
		}

		public ClientTo(String email) {
			this.email = email;
		}

	}
