package pkg;
import java.util.*;

public class Topic extends Message {

	// Default Constructor
	public Topic() {
		super();
	}

	// Parameterized constructor
	public Topic(String auth, String subj, String bod, int i) {
		super(auth,subj,bod,i);
	}

	// Returns if it's a reply (false)
	public boolean isReply(){
		String waht = this.getClass().getName();
		//System.out.println("ooga: " + waht);
		if (waht.contains("Reply")) {
			return true;
		}
		else {
			return false;
		}
	}
}
