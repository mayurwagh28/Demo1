package example.spring.mvc.model;

public class UserValidator {
	
	public static boolean isValid(User currentUser) {
		String currentUserName = currentUser.getUserName();
		String currentUserPassword = currentUser.getPassword();
		boolean success = false;
//		Validating this user against hardcoded values : admin, 12345
		if(currentUserName.equals("admin") && currentUserPassword.equals("12345"))
			success = true;
		return success;
	}
}
