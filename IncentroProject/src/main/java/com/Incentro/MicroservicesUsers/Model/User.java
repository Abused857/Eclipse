package com.Incentro.MicroservicesUsers.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="users")
public class User {

		@Id
		@Column (name="id", columnDefinition = "varchar(50) not null")
		private String id;
		
		@Column (name="name", columnDefinition = "varchar(50) not null")
		private String name;
		
		@Column (name="last_name", columnDefinition = "varchar(50) not null")
		private String lastName;
		
		@Column (name="dni", columnDefinition = "varchar(50) not null")
		private String dni;
		
		@Column (name="phone", columnDefinition = "varchar(15) not null")
		private String phone;
		
		@Column (name="address", columnDefinition = "varchar(50) not null")
		private String address;
		
		@Column (name="email", columnDefinition ="varchar(50) not null")
		private String email;
		
		public User() {}
		
		public User(String id, String name, String lastName, String dni, String phone, String address, String email)
		{
			
				
				
				this.id = id;
				this.name = name;
				this.lastName = lastName;
				this.dni = dni;
				this.phone = phone;
				this.address = address;
				this.email = email;
			
		}

		public String getId() {
			return id;
		}

		private void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getDni() {
			return dni;
		}

		private void setDni(String dni) {
			this.dni = dni;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
}
