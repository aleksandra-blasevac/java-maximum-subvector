//Aleksandra Blasevac 13158325, Games Development
package assignment1v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //Checks if user specified the location of a single text file
        if (args.length != 1) {
            System.out.println("You must specify the location of one text file in quotes, eg. \"c:\\test\\vector25.txt\"");
            System.exit(0);
        }   
            //Creates an ArrayList to store numbers from the file
            ArrayList<Double> numbers = new ArrayList<>();
            //Stores all the numbers from the file in an ArrayList
            numbers = readFile(args[0], numbers); 
            
            System.out.println(getMaxSubVector(numbers));            
    }
    
    
    private static ArrayList<Double> readFile(String filePath, ArrayList<Double> numbers) 
    {           
        try
        {
            //Creates a File object from command line argument
            File file = new File(filePath);
            //Create a Scanner object to read the file
            Scanner scanner = new Scanner(file);
            //Reads numbers from the text file and adds them to an arraylist
            while(scanner.hasNextLine())
            {
                String[] temp = scanner.nextLine().split(",");
                for (String number : temp) {
                    try 
                    {
                    numbers.add(Double.parseDouble(number));
                    }
                    //Catches an exeption if the file doesn't contain numbers in the right format
                    catch(NumberFormatException exeption)
                    {
                        System.out.println("The supplied file must be a text file containing numbers (possible floating point numbers) separated by commas.");
                        System.exit(-1);
                    }
                }
            }
            scanner.close();
        }
        //Catches an exeption if the file was not found
        catch(FileNotFoundException exception)
        {
            System.out.println("The file " + filePath + " was not found.");
            System.exit(-1);
        }
        //Catches any other IO exeptions
        catch(IOException exception)
        {
            System.out.println("IO exeption " + exception);
        }
        return numbers;
    }

    //Kadane's algorithm found on Wikipedia
    private static String getMaxSubVector(ArrayList<Double> numbers)
    {
        int startPos = 0, endPos = 0;
        double sum = 0, bigSum = 0;
        for (int i = 0; i < numbers.size(); i++)
        {      
            double temp = numbers.get(i);
            //If the new sum is smaller than 0 the start position changes to the next number (i+1)
            if ((sum + temp) < 0)
            {
                sum = 0;
                startPos = i+1;
            }
            //If the new sum is bigger than 0 it's used as the sum.
            else sum += temp;
            
            //If the biggest sum so far is smaller than the new sum biggest sum changes to the new sum and the end position changes to i  
            if (bigSum < sum)
            {
                bigSum = sum;
                endPos = i;
            }
        }
        
        return  startPos + " (initial index)\n" +
                endPos + " (final index)\n" +
                Math.round(bigSum*100)/100.0 + " (value of max sub-vector)";
    }
}









