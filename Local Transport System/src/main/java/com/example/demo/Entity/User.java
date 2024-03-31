package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="USER_INFO")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Getter
	@Id
	@Column(name="USERNAME", nullable = false)
	private String userName;
	
	@Column(name="NAME", nullable = false)
	private String name;

	@Column(name="EMAIL", nullable = false)
	private String email;

	@Column(name="PASSWORD", nullable = false)
	private String password;

	@Column(name="CONTACT_NUMBER")
	private long contact;

}
