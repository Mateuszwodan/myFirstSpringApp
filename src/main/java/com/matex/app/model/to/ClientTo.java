package com.matex.app.model.to;

import lombok.Getter;
import lombok.Setter;

	public class ClientTo {

		@Getter
		@Setter
		private long id;

		@Getter
		@Setter
		private String email;

		@Getter
		@Setter
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
