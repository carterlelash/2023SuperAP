package pkg;
import java.util.*;
import java.io.*;

public class Message {

	private String auth;
	private String subj;
	private String bod;
	private int i;

	private ArrayList <Message> messageList = new ArrayList <Message> ();

	// Default Constructor
	public Message() {
		this.auth = "";
		this.subj = "";
		this.bod = "";
		this.i = 0;
	}
	
	// Parameterized Constructor
	public Message(String auth, String subj, String bod, int i) {
		this.auth = auth;
		this.subj = subj;
		this.bod = bod;
		this.i = i;
		
	}

	// This function is responsbile for printing the Message
	// (whether Topic or Reply), and all of the Message's "subtree" recursively:

	// After printing the Message with indentation n and appropriate format (see output details),
	// it will invoke itself recursively on all of the Replies inside its childList, 
	// incrementing the indentation value at each new level.

	// Note: Each indentation increment represents 2 spaces. e.g. if indentation ==  1, the reply should be indented 2 spaces, 
	// if it's 2, indent by 4 spaces, etc. 
	public void print(int indentation){
		Message messB = messageList.get((indentation/2)-1);
		if (messB.isReply()) {
			for (int x = 0; x < indentation; x++) {
				System.out.print(" ");
			}
		}
			System.out.print("Reply " + messB.getId() + ": ");
			for (int h = 0; h < indentation/2; h++) {
				System.out.print("Re: ");
			}
			System.out.println("\"" + messB.getBody() + "\"");
		if (messB.isReply()) {
			for (int g = 0; g < indentation+2; g++) {
				System.out.print(" ");
			}
		}
		if (((indentation+2)/2)-1 < messageList.size()) {
			print(indentation+2);
		}
	}

	// Default function for inheritance
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

	// Returns the subject String
	public String getSubject(){
		return this.subj;
	} 

	// Returns the ID
	public int getId(){
		return this.i;
	}
	public String getBody() {
		return this.bod;
	}

	// Adds a child pointer to the parent's childList.
	public void addChild(Message child){
		messageList.add(child);
		for (int y = 0; y < messageList.size(); y++) {
			Message a = messageList.get(y);	
			//System.out.println("Message " + a.getId() + ": " + a.getBody());
		}
	}

}
