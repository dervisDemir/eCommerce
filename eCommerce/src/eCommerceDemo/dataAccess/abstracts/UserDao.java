package eCommerceDemo.dataAccess.abstracts;

import java.util.List;

import eCommerceDemo.entities.concretes.User;

public interface UserDao {
	
	void add(User user);

	void update(User user);

	void delete(User user);

	User getEmail(String mail);

	List<User> getAll();

}
