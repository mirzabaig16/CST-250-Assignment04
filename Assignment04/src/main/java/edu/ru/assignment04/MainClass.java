package edu.ru.assignment04;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException; 
        import java.util.Random;
public class MainClass
{
    private static String BasePath = "C:\\Users\\Tayyab\\Assignment04\\CST-250-Assignment04\\Assignment04\\src\\main\\java\\edu\\ru\\assignment04\\";
	public static void main(String[] args) {
	    ArrayList<String> names = new ArrayList();// array of string
	    //Reading names from file
	   names = ReadTheFile("names.txt");
		
		//Sorting by alphabetically
      Collections.sort(names);
      	for (String name : names) { 		    
           System.out.println(name);
      }
      //Writing
      WriteToFile("sorted_names.txt",names);
	
      
      //random names from file
     System.out.println(RandomName("sorted_names.txt"));
	}

        //Reading From File
        public static ArrayList<String> ReadTheFile(String fileName){
            ArrayList<String> names = new ArrayList();
        try{
	        File myFile = new File(BasePath+fileName);
	        Scanner scanner = new Scanner(myFile);
	        while(scanner.hasNextLine()){
	           String name = scanner.nextLine(); 
	           names.add(name);// storing in array of string
	        }
                scanner.close();
	      
	    }
	    catch(Exception ex){
	    System.out.println("Error Occured"); 
	    System.out.println("Error Message : "+ex.getMessage());    
	    ex.printStackTrace();
	    }
        return names;
        }
        //Writing To File
        public static void WriteToFile(String fileName,ArrayList<String> names){
             try {
      File myObj = new File(BasePath+fileName);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
      
       FileWriter myWriter = new FileWriter(BasePath+fileName);
       	for (String name : names) { 
           myWriter.write(name);
           myWriter.write("\n");
          // myWriter.write(System.getProperty( "line.separator" ));
      }
      
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
      
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
     
        }
public static String RandomName(String fileName ){
    String result = null;
     try{
	        File myFile = new File(BasePath+fileName);
	        Scanner scanner = new Scanner(myFile);
                int count= 0;
	        while(scanner.hasNextLine()){
	           String name = scanner.nextLine(); 
	           count++;
                   Random rand= new Random();
                   if (rand.nextInt(count) == 0)
                result = name;
                   
                   
	        }
	      scanner.close();
	    }
	    catch(Exception ex){
	    System.out.println("Error Occured"); 
	    System.out.println("Error Message : "+ex.getMessage());    
	    ex.printStackTrace();
	    }
    return result;
}
}

