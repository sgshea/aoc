
import java.io.*;
import java.util.*;
public class day2 {

	public static void main(String[] args) {
        //Array of type
        ArrayList<String> tokens = new ArrayList<String>();
        
        //Read file from command line and add lines to arraylist
        try {
            Scanner scnr = new Scanner(new File(args[0]));
            while (scnr.hasNextLine()) {
                tokens.add(scnr.nextLine());
            }
            scnr.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("No file");
        }
        
        //position variables
        int forwards = 0;
        int depth = 0;
        
        for(String token : tokens) {
        	//creates an array of items seperated by a space from each token
        	String[] split = token.split(" ");
        	switch(split[0]) {
        		case "forward":
        			forwards = forwards + Integer.parseInt(split[1]);
        			break;
        		case "down":
        			depth = depth + Integer.parseInt(split[1]);
        			break;
        		case "up":
        			depth = depth - Integer.parseInt(split[1]);
        			break;
        		default:
        			System.out.println("error in switch");
        			break;
        	}
        }
        System.out.println("depth: " + depth + " forwards: " + forwards);
        System.out.println("calculation: " + depth*forwards);
        

	}

}
