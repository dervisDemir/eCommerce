package eCommerceDemo.core;

public class GAuthConnect implements GAuthService {

	@Override
	public void sign(String email, String message) {
		
		GAuth gAuth = new GAuth();
		gAuth.sign(email, message);
		
	}

}
