import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class DNA {

    public static boolean isValidDNA(String dna)
    {
        char [] dnastring = dna.toCharArray();
        char a = "A".charAt(0);
        char c = "C".charAt(0);
        char t = "T".charAt(0);
        char g = "G".charAt(0);



        for (char x: dnastring)
        {
            if (x!=a && x!= c && x!= t && x!= g)
            {
                return false;
            }
        }

        return true;

    }

    public static String complementWC(String dna)
    {
        String sample = dna;
        for (int i = 0; i < sample.length(); i++)
        {
            if (sample.charAt(i) == "A".charAt(0))
            {
                sample = sample.substring(0,i) + "T" + sample.substring(i+1);
            }
            else if (sample.charAt(i) == "C".charAt(0))
            {
                sample = sample.substring(0,i) + "G" + sample.substring(i+1);
            }
            else if (sample.charAt(i) == "T".charAt(0))
            {
                sample = sample.substring(0,i) + "A" + sample.substring(i+1);
            }
            else if (sample.charAt(i) == "G".charAt(0))
            {
                sample = sample.substring(0,i) + "C" + sample.substring(i+1);
            }

        }

        return sample;
    }

    public static boolean isPalindromeWC(String dna)
    {
        String right = dna;
        String opp = complementWC(dna);

        for (int i = 0; i < right.length(); i++)
        {
            if (right.charAt(i) != opp.charAt(opp.length()-1-i))
            {
                return false;
            }
        }

        return true;

    }


    public static void main (String [] args) throws IOException
    {
        String path = args[0];
        File myFile = new File(path);
        Scanner cp = new Scanner(myFile);
        while (cp.hasNextLine())
        {
            String data = cp.nextLine();
            System.out.println("DNA sequence from file: " + data);
            if (isValidDNA(data))
            {
                System.out.println(data + " is a valid DNA sequence.");
                System.out.println("Watson-Crick complement of " + data + " is: " + complementWC(data));
                if (isPalindromeWC(data))
                {
                    System.out.println(data + " is a Watson-Crick complemented palindrome.");
                }
                else
                {
                    System.out.println(data + " is not a Watson-Crick complemented palindrome.");
                }
            }
            else
            {
                System.out.println(data + " is not a valid DNA sequence.");
            }

            System.out.println("____________________________________________________________________");

        }
        cp.close();
    }
}
