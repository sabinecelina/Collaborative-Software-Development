package de.hfu;
import java.util.Scanner; 

public class App 
{
    public static void main( String[] args )
    {
     Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter a word and you will  get it in uppercase");

    String word = myObj.nextLine();  // Read user input
    System.out.println(word.toUpperCase());  // Output user input
    }
}
