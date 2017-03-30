package database;

import java.awt.List;
import java.util.ArrayList;

import users.User;

public class Workdb {

	public User getUser(User user) {
		// ***
		//
		// SELECT FROM users
		//
		// ***
		return user;
	}
	
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		// ***
		//
		// SELECT * FROM users
		//
		// ***
		return users;
	}
	
	public void insertUser(User user) { 
		// ***
		//
		// INSERT INTO users
		//
		// ***
	}

	public User findUser(String username, String password) {
		User user = new User();
		// ***
		//
		// SELECT FROM users WHERE username="x" and password="y"
		//
		// ***
		return user;
	}
	
	public void upgradeUser(String username) {
		// ***
		//
		// UPDATE WHERE username=x
		//
		// ***
	}
}
