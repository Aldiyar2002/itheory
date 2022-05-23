package sample;

import sample.Node;

import java.util.Scanner ;
import java.util.ArrayList ;
import java.io.ObjectOutputStream ;
import java.io.FileOutputStream ;
import java.io.ObjectInputStream ;
import java.io.FileInputStream ;
import java.io.File ;
import java.io.BufferedReader ;
import java.io.BufferedWriter ;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.FileNotFoundException ;
import java.io.IOException ;

public class FileOperations
{
    private static FileInputStream byteInput = null;

    public Scanner openFile (String file_name)
    {

        Scanner refer_f = null ;

        try
        {
            refer_f = new Scanner (new BufferedReader (new FileReader (new File (file_name)))) ;
        }

        catch (FileNotFoundException ex)
        {
            System.out.println (file_name + " could not found.!") ;
            ex.printStackTrace () ;
        }

        return refer_f ;
    }

    public String readFile (Scanner kod_file)
    {
        String line = null ;

        if (kod_file.hasNextLine ())
        {
            line = kod_file.nextLine () ;
        }

        return line ;
    }

    public void writeFile (String line , String file_name)
    {

        try (BufferedWriter writer = new BufferedWriter (new FileWriter (new File (file_name) , true)))
        {
            writer.write (line + '\n') ;
        }

        catch (IOException ex)
        {
            System.out.println ("Could not write to the " + file_name + ".!") ;
            ex.printStackTrace () ;
        }
    }

    public void writeCodes (ArrayList <Node<Character , Integer>> list , String file_name)
    {

        try (ObjectOutputStream output = new ObjectOutputStream (new FileOutputStream (new File (file_name))))
        {
            output.writeObject (list) ;
        }

        catch (FileNotFoundException ex)
        {
            System.out.println (file_name + " could not found.!") ;
            ex.printStackTrace () ;
        }

        catch (IOException ex)
        {
            System.out.println ("Could not write to the " + file_name + ".!") ;
            ex.printStackTrace () ;
        }
    }

    public ArrayList<Node<Character, Integer>> readCodes (String file_name)
    {
        ArrayList <Node <Character , Integer>> codes = null ;

        try (ObjectInputStream input = new ObjectInputStream (new FileInputStream (new File (file_name))))
        {
            codes = (ArrayList <Node <Character , Integer>>) input.readObject () ;
        }

        catch (FileNotFoundException ex)
        {
            System.out.println (file_name + " could not found.!") ;
            ex.printStackTrace () ;
        }

        catch (ClassNotFoundException ex)
        {
            System.out.println ("Node class could not found.!") ;
            ex.printStackTrace () ;
        }

        catch (IOException ex)
        {
            System.out.println ("Could not read from " + file_name + ".!") ;
        }

        return codes ;
    }
}
