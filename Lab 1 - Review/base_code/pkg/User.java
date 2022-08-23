package pkg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {

	private String password;
	private String user;

	// Creates a User with empty name and password.
	public User() {
		this.user = "";
		this.password = "";
	}

	// Creates a User with given username and password.
	public User(String usr, String pwd) {
		this.user = usr;
		this.password = pwd;
	}

	// Returns the username
	public String getUsername(){
		return this.user;
	}

	// Returns true if the stored username/password matches the parameters. Otherwise returns false.
	// Note that, even with a User with empty name and password, this is actually a valid User object (it is the default User), 
	// This function must still return false if given an empty username string.  
	public boolean check(String usr, String psd) throws FileNotFoundException{
		File userfile = new File ("users.txt");
		Scanner sc = new Scanner(userfile);
		String checkuser = usr + " " + psd;
		ArrayList <String> namesAndPasswords = new ArrayList <String> ();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			namesAndPasswords.add(line);
		}
		if (namesAndPasswords.indexOf(checkuser)>=0) {
			return true;
		}
		else {
			return false;
		}

	}

	// Sets a new password.
	// This function should only set the password if the current (old) password is passed in.
	// Also, a default User cannot have its password changed. 
	// Return true if password changed, return false if not.
	public boolean setPassword(String oldPass, String newPass) throws FileNotFoundException{
		File userfile = new File ("users.txt");
		Scanner sc = new Scanner(userfile);

		ArrayList <String> namesAndPasswords = new ArrayList <String> ();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			namesAndPasswords.add(line);
		}

		int passwd = namesAndPasswords.indexOf(oldPass);
		if (passwd < 0) {
			return false;
		}
		namesAndPasswords.add(passwd, this.getUsername() + " " + newPass);
		return true;
	}
}
