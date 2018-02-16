/********************************************************************
 Lab4.java
 Author: Nate Kiolbasa
 Date: 2/16/18
 Program Description:

 Lets the user input a text file
 and checks to see which words are palindromes

 Algorithm:

 1. Create a method to ask the user to choose a file
 2. Create a method to read the file as an array of strings
 3. Create a method to determine whether the strings are palindromes using recursion
 4. Create a method to determine whether the strings are palindromes using iteration
 5. Display the palindromes for both methods in steps 3 and 4
 6. Display the total palindromes for both methods
 7. End program

 Citation:

 Starting code was provided by Dr. Harms in Lab 1 in CSIT 150 class.
 ********************************************************************/

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab5
{
    public static void main(String[] args) throws Exception
    {
        greeting();

        String [] file;

        file = readFile(getInputFile());

        int counter1 = 0;
        int counter2 = 0;

        System.out.println("Palindromes for the Recursive method: ");
        for (int i = 0; i < file.length; i++)
        {
            if (palindrome(file[i]) == true) {
                counter1++;
                System.out.println(file[i]);
            }
        }
        System.out.println("\nPalindromes for the Iterative method: ");
        for (int i = 0; i < file.length; i++)
        {
            if (palindromeIterative(file[i]) == true)
            {
                counter2++;
                System.out.println(file[i]);
            }
        }
        System.out.println("\nTotal Recursion palindrome(s): " + counter1 + "\nTotal Iterative palindrome(s): " + counter2);
        System.out.println("\nProgram terminating");
    }
    /**
     * get input file
     *
     * @return Scanner file for input
     * @throws IOException
     */
    private static File getInputFile() throws IOException
    {
        // Get the INPUT filename.
        JFileChooser chooser = new JFileChooser();
        File home = new File(System.getProperty("user.home"));
        chooser.setCurrentDirectory(home);
        int status = chooser.showOpenDialog(null);

        if (status != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("No File Chosen");
            System.exit(0);
        }
        // Open the file.
        return chooser.getSelectedFile();
    }

    /**
     * validate whether or not the words from the text file are palindromes using recursion
     * @return word
     */
    public static Boolean palindrome(String word)
    {
        boolean result = true;

        if (word.length() % 2 == 0)
        {
            if (word.length() == 2 && word.charAt(0) == word.charAt(word.length() - 1))
            {
                result = true;
            }
            else if (word.charAt(0) == word.charAt(word.length() - 1) && word.length() > 2)
            {
                word = word.substring(1, word.length() - 1);

                result = palindrome(word);
            }
            else
            {
                result = false;
            }
        }
        else
        {
            if (word.charAt(0) == word.charAt(word.length() - 1) && word.length() > 1)
            {
            word = word.substring(1, word.length() - 1);

            result = palindrome(word);

            }
            else if (word.length() == 1)
            {
                result = true;
            }

            else
            {
                result = false;
            }
        }
        return result;
        /*if (word.length() == 1)
        {
            result = true;
        }
        else if (word.length() == 2)
        {
            if(word.charAt(0) == word.charAt(word.length()-1))
            {
                result = true;
            }
            else
            {
                result = false;
            }
        }

        else if (word.charAt(0) == word.charAt(word.length()-1))
        {
            word = word.substring(1, word.length()-1);

            palindrome(word);

        }
        else
        {
            result = false;
        }
        */
    }
    /**
     * validate whether or not the words from the text file are palindromes using iteration
     * @return word
     */
    public static Boolean palindromeIterative(String word)
    {
        int counter = 0;

                for (int i = 0; i < word.length();i++)
                {
                    //System.out.println(word.charAt(i));
                   // System.out.println(word.charAt(word.length()-(i+1)));

                    if (word.charAt(i) == word.charAt(word.length()-(i+1)))
                    {
                        counter++;
                    }
                }
                if (counter == word.length())
                {
                    return true;
                }

            return false;
    }

    /**
     * read input file
     * @return input file
     * @throws IOException
     */
    public static String [] readFile(File inputFile) throws IOException
    {
        Scanner inputScanner = new Scanner(inputFile);
        int counter = 0;

        while (inputScanner.hasNext())
        {
            inputScanner.nextLine();
            counter++;
        }

        String [] words = new String [counter];

        inputScanner = new Scanner(inputFile);

        counter = 0;

        while (inputScanner.hasNext())
        {
            words[counter] = inputScanner.nextLine();
            counter++;
        }
        inputScanner.close();

        return words;
    }

    /**
     * prints out the purpose of the program
     */
    public static void greeting()
    {
        System.out.println("The purpose of this program is to check a text file for palindromes\n" +
                           "that the user chooses. You will be prompted with a file chooser initially,\n" +
                           "and then the program will read the file and display the palindromes\n" +
                           "recursively and iteratively.\n");
    }
}


