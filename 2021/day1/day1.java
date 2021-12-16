import java.io.*;
import java.util.*;
public class day1 {
    public static void main(String[] args) {
        //Array of type
        ArrayList<Integer> tokens = new ArrayList<Integer>();
        
        //Read file from command line and add lines to arraylist
        try {
            Scanner scnr = new Scanner(new File(args[0]));
            while (scnr.hasNextLine()) {
                tokens.add(Integer.parseInt(scnr.nextLine()));
            }
            scnr.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("No file");
        }
        
        //Count number of times measurement increased from last
        int amtIncreased = 0;
        int lastToken = tokens.get(0);
        for(int token : tokens) {
            if(token > lastToken) {
                amtIncreased++;
            }
            lastToken = token;
        }
        
        //Measurement for day1
        System.out.println(amtIncreased + " is amount increased");
        
        //Count three-measurement sliding window
        amtIncreased = 0;
        lastToken = tokens.get(0) + tokens.get(1) + tokens.get(2);
        int currentToken = tokens.get(0);
        for(int i = 1; i + 2 < tokens.size(); i++) {
            currentToken = (tokens.get(i) + tokens.get(i + 1) + tokens.get(i + 2));
            if(currentToken > lastToken) {
                amtIncreased++;
            }
            lastToken = currentToken;
        }
        
        //Measurement for day1 part 2
        System.out.println(amtIncreased + " is amount increased for part 2");
    }
}