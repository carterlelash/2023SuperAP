package pkg;
import java.util.*;
import java.io.*;

public class Reply extends Message {

	// Default Constructor
	public Reply() {
		super();
	}

	// Parameterized Constructor
	public Reply(String auth, String subj, String bod, int i) {
		super(auth,subj,bod,i);
	}

	// Returns if this is a reply (true)
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
