package eCommerceDemo;

import java.util.ArrayList;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.GAuthConnect;
import eCommerceDemo.dataAccess.concretes.LoginUser;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<User> users = new ArrayList<>();
		UserService userService = new UserManager(new LoginUser(users), new GAuthConnect());
		User user = new User(1, "Derviþ", "DEMÝR", "dervisdemirank@hotmail.com", "1111111111");
		userService.register(user);
		userService.verify(user);
		userService.login(user);
		users.add(user);
		userService.registerWithGoogleAccount("selder3706@gmail.com", "17082011");
		

	}

}
