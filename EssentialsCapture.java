/**
 * A Java program that takes the name of item, the quantity and the quantity
 * as input from the user.
 * The name of the item is a string, the quantity and quantitys are integers.
 * 
 */

import java.util.Scanner;
//import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 * @author Emmanuel Kebede Martey
 * 
 */

public class EssentialsCapture{

    /**
	 * Constructor
	 */
	public EssentialsCapture() {
		// the constructor
	}
    
    public void capture()throws InputMismatchException{
        
        PrintWriter printWriter = null;
        PrintWriter printWriters = null;
    		
        try {
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
        }catch(FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

        try {
            printWriters = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));
        }catch(FileNotFoundException fnfe) {
            fnfe.getMessage();
        }

        /**
         * The scanner takes input from the user and and assigns it to the 
         * variables.
         * Then it prints out the input of the user as a string in the command prompt
         * It also prints out the user's input into a file.
         * The file can only be appended but not updated.
         * This is a way to take the intial of the items.
         * The items in the file are backed up into another file.
         */

        String item ="";
        int quantity=0;
        int price=0;

        Scanner std = new Scanner(System.in);
        Scanner stdin = new Scanner(System.in);
        System.out.print("How many items are there? ");
        int numItems = stdin.nextInt();

        for(int i = 0; i < numItems; i++){

            System.out.print("Enter the name of the item: ");
            item = std.nextLine();

            System.out.print("Enter the quantity: ");
            
            //Assigns the next integer value to the integer variable (i.e. quantity)
            quantity = stdin.nextInt();
            
            //Checking for the expected data type 
            if(quantity<0) {
                System.out.println("Number Entered: ["+quantity+"] is negative");
                //Note this statement
                System.exit(0);
            }

            System.out.print("Enter the price: ");
            price = stdin.nextInt();
            
            //Checking for the expected data type 
                    if(price<0) {
                        System.out.println("Number Entered: ["+price+"] is negative");
                        //Note this statement
                        System.exit(0);
                    }
                
            System.out.println();
            System.out.println(item + "     " + quantity + "      GHS " + price);

            //The ouput must be printed in the file and the backup file.
            printWriter.println(item + "     " + quantity + "      GHS " + price);
            printWriters.println(item + "     " + quantity + "      GHS " + price);
        }
        //The Scanner objects must be closed 
        stdin.close();
        std.close();
        printWriter.close();
        printWriters.close();
        
    }

    
	/**
	 * 
	 * @param args
	 *
	 */
	public static void main(String args[]) 
	{
		
        EssentialsCapture Fiifi = new EssentialsCapture();
        Fiifi.capture();
 
    
	}

}