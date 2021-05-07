package eCommerceDemo.business.concretes;

import java.util.Scanner;
import java.util.regex.Pattern;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.GAuthService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userdao;
	private GAuthService gAuthService;

	private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();
	}
	
	public UserManager(UserDao userdao, GAuthService gAuthService) {
		this.userdao = userdao;
		this.gAuthService = gAuthService;
	}
	
	@Override
	public void register(User user) {
		
		if (user.getFirstName().length() <= 2 && user.getLastName().length() <= 2) {
			System.out.println("Ad ve soyad en az iki karakterden oluþmalýdýr..!");
			return;
		}
		if (user.getPassword().length() <= 6) {
			System.out.println("Parolanýz en az 6 karakterden oluþmalýdýr..!");
			return;
		}
		if (userdao.getEmail(user.getEmail()) != null) {
			System.out.println("Sistemde bu mail adresi ile kullanýcý bulunmaktadýr..!");
			return;
		}
		if (!(isValidEmail(user.getEmail()))) {
			System.out.println("Lütfen geçerli bir mail adresi giriniz..!");
			return;
		} else {
			System.out.println("Doðrulama kodunuz mail adresine gönderilmiþtir.");
		}
		userdao.add(user);
		
	}

	@Override
	public void verify(User user) {
				int realCode = (int) (100 * Math.random() * 1000);
				
				try (Scanner scanner = new Scanner(System.in)) {
					System.out.println("Dogrulama kodunuz :" + realCode);
					System.out.println("Mail adresimize gönderilen dogrulama kodunu giriniz : ");
					
					int verify = scanner.nextInt();
					if (realCode == verify) {
						System.out.println("Hesabýnýz doðrulandý");
					} else {
						System.out.println("Lütfen Doðrulama Kodunu Tekrar Giriniz:" + realCode);
					}
				}catch(Exception e){
					
				}
		
	}

	@Override
	public void login(User user) {
		
		if ((user.getEmail().equals("dervisdemirank@hotmail.com") && user.getPassword().equals("271163"))) {
			System.out.println(user.getFirstName() + " Giriþiniz Baþarýlý..!");
		}else {
			System.out.println("Lütfen Mail/Parola kontrol ediniz..!");

		}
		
	}

	@Override
	public void registerWithGoogleAccount(String email, String password) {
		
		gAuthService.sign(email, password);
		User user = new User(1, "Derviþ", "DEMÝR", email, password);
		user.setEmail(email);
		
		
	}

	@Override
	public User getEmail(String mail) {
		
		return userdao.getEmail(mail);
	}

}
