package de.hfu;
import java.util.Scanner; 

public class App 
{
    public static void main( String[] args )
    {
    /**
     * Ein Scanner wird erstellt um die Worte einzulesen und sie in Großbuchstaben zurückzugeben
     */
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter a word and you will  get it in uppercase");
    /**
    * Der Scanner liest die Zeile ein und gibt diese in Uppercase wieder aus
    */
    String word = myObj.nextLine();  // Read user input
    System.out.println(word.toUpperCase());  // Output user input
    }
}
