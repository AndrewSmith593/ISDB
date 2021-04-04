package com.example.demo.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.sandwich.Sandwich;

@Entity
@Table(name = "user")
public class User {
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private Integer id;
	@NotBlank
	@Size(min = 6, max = 30, message = "Username must be between 6 and 30 characters long.")
	private String username;
	@NotBlank
	@Email(message = "Email should be valid.")
	private String email;
	@NotBlank
	@Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters long.")
	private String password;

	// @OneToMany(mappedBy = "user", targetEntity = Sandwich.class)
	@OneToMany(targetEntity = Sandwich.class)
	private List<Sandwich> uSandwiches;

	public User() {
		super();
	}

	public User(String username, String email, String password,
			List<Sandwich> uSandwiches) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.uSandwiches = uSandwiches;
	}

	public Integer getId() {
		return id;
	}

	public List<Sandwich> getuSandwiches() {
		return uSandwiches;
	}

	public void setuSandwiches(List<Sandwich> uSandwiches) {
		this.uSandwiches = uSandwiches;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("%3s %15s %20s %10.2f", id, username, email,
				password);
	}

}
