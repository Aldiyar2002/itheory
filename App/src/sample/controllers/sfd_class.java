package sample.controllers;

import sample.FileOperations;
import sample.Node;

import java.util.ArrayList ;
import java.util.Scanner ;

public class sfd_class
{
    private ArrayList <Node<Character , Integer>> kody = null ;

    private void decipher (String liniya , String pismena)
    {

        if (liniya.length () == 0)
        {
            FileOperations oFile = new FileOperations () ;
            oFile.writeFile (pismena , "src/sample/txt_files/decoded.txt") ;
            System.out.println(pismena);
            return ;
        }

        int snachalo = 0 ;

        for (int o=0 ; o<liniya.length () ; o++)
        {
            String kod = "" ;
            boolean konecloops = false ;

            for (int p=0; p<=o; p++)
            {
                kod += liniya.charAt (p) ;
            }

            for (Node <Character , Integer> k : this.kody)
            {

                if (kod.equals (k.getCode ()))
                {
                    pismena += k.getKey ();
                    snachalo = o+1;
                    konecloops = true; //destroy two loops that was compared
                    break;
                }
            }

            if (konecloops)
            {
                break;
            }
        }

        this.decipher (liniya.substring (snachalo), pismena);
    }

    public static void main (String [] args)
    {
        FileOperations oFile = new FileOperations () ;
        sfd_class dcde = new sfd_class () ;
        Scanner refr = oFile.openFile ("src/sample/txt_files/encddfile.txt") ;
        String liniya = null ;
        Scanner refr1 = oFile.openFile("src/sample/txt_files/userText.txt");
        String liniya1 = null;
        Scanner refr2 = oFile.openFile ("src/sample/txt_files/encddfile.txt") ;
        String liniya2 = null ;

        dcde.kody = oFile.readCodes ("src/sample/txt_files/storage.bin") ;
        // is needed to represent information in the form of a binary data system and its contents can be very different.
        System.out.println("Task 1");
        System.out.println("Encoded text: ");
        while ((liniya2 = oFile.readFile (refr2)) != null)
        {
            System.out.println(liniya2);
        }
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println();
        //For decoding, a function is needed, lines that were read from the encoded text are embedded in it.
        System.out.println("Task 3");
        System.out.println("Decoded text: ");
        while ((liniya = oFile.readFile (refr)) != null)
        {
            dcde.decipher (liniya , "") ;
        }
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("Original text: ");
        while ((liniya1 = oFile.readFile(refr1)) != null)
        {
            System.out.println(liniya1);
        }

    }
}
