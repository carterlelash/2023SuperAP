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
		if (this.getClass().equals("Reply")) {
			return true;
		}
		else {
			return false;
		}
	}
}
