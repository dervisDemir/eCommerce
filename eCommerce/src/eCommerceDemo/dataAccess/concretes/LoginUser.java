package eCommerceDemo.dataAccess.concretes;

import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class LoginUser implements UserDao {
	
	private List<User> users;

	public LoginUser(List<User> users) {
		this.users = users;
	}


	@Override
	public void add(User user) {
		
	}

	@Override
	public void update(User user) {
		
	}

	@Override
	public void delete(User user) {
		
	}

	@Override
	public User getEmail(String mail) {
		
		for (User user : users) {
			if (user.getEmail().equals(mail)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

}
