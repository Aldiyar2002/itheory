package sample.controllers;

import sample.Node;
import sample.FileOperations;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList ;
import java.util.Scanner ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.LinkedList;

public class sfe_class
{

    private static int cumboly;
    private static int ecde_b;
    private ArrayList<Node <Character, Integer>> frequs = new ArrayList<Node <Character, Integer>> () ;

    public static void main(String[] args)
    {

        DecimalFormat doTreh = new DecimalFormat("#.###");
        sfe_class ecde = new sfe_class () ;
        FileOperations oFile = new FileOperations () ;
        Scanner refr = oFile.openFile("src/sample/txt_files/userText.txt");
        String liniya = null;
        Scanner refr2 = oFile.openFile("src/sample/txt_files/encddfile.txt");
        String str2 = oFile.readFile(refr2);
        String liniya2 = oFile.readFile(refr2);
        while ((liniya = oFile.readFile(refr)) != null)
        {
            ecde.calFrequs(liniya);
        }

        ecde.v_k_sorting();
        ecde.calPossis();
        System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println("1 task");
        System.out.println();
        for (Node <Character, Integer> kod: ecde.frequs)
        {
            char charac = kod.getKey();
            String dlyaSpace = String.valueOf(charac);
            if(kod.getKey() == ' '){
                dlyaSpace = "space";
            }
            float val = (float)kod.getPossibility();
            String ihPossib = doTreh.format(val);
            System.out.println(dlyaSpace + " - " + ihPossib);
        }
        System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println("2 task");
        ecde.generCoda(ecde.frequs) ;


        refr = oFile.openFile ("src/sample/txt_files/userText.txt") ;
/////////////////////
        ochistka();
        /////////////////////
        while ((liniya = oFile.readFile (refr)) != null)
        {
            oFile.writeFile (ecde.ecdes (liniya) , "src/sample/txt_files/encddfile.txt") ;
        }
        oFile.writeCodes (ecde.frequs , "storage.bin") ;
        System.out.println();
        System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println("3 task");
        System.out.println();
        for (Node <Character , Integer> kod : ecde.frequs)
        {
            char charac = kod.getKey();
            String dlyaSpace = String.valueOf(charac);
            if(kod.getKey() == ' '){
                dlyaSpace = "space";
            }
            float val = (float)kod.getPossibility();
            String ihPossib = doTreh.format(val);
            System.out.println(dlyaSpace + " - " + ihPossib +" - " + kod.getCode());
        }
        System.out.println();
        System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println("4 task");
        System.out.println();
        System.out.println(str2);
        System.out.println("File was encoded");
        System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println();
        System.out.println("5 task");
        System.out.println();
        for(int i = 0; i < liniya2.length(); i++){
            ecde_b++;
        }

        System.out.println("Number of bits in the original text: " + cumboly*8 + " bits");
        System.out.println("Number of bits in the compressed text: " + ecde_b + " bits");
        System.out.println("Compressed ratio = " + (float)(cumboly*8)/ecde_b);
        double Acd = 0.0;
        for (Node <Character, Integer> n: ecde.frequs)
        {
            float Poss = (float)n.getPossibility();
            Acd = Acd + Leng(n.getCode()) * Poss;
        }

        System.out.println("Average code length = " + doTreh.format(Acd) + " bits/symbol");

    }
    private static int Leng(String code) {
        return code.length();
    }

    private void calFrequs(String line)
    {

        for (int o = 0; o < line.length(); o++)
        {
            boolean wasAlreadyCreated = true;

            for (Node <Character, Integer> kod : this.frequs)
            {
                if (kod.getKey ().equals (line.charAt (o)))
                {

                    kod.setValue (kod.getValue () + 1) ;
                    wasAlreadyCreated = false;
                    break;
                }
            }

            if (wasAlreadyCreated)
            {
                this.frequs.add(new Node<Character, Integer>(line.charAt(o), 1));
            }
        }
    }

    private void v_k_sorting()
    {
        Collections.sort
                (
                        this.frequs,

                        new Comparator <Node <Character, Integer>> ()
                        {
                            @Override
                            public int compare(Node <Character, Integer> _1st, Node <Character, Integer> _2nd)
                            {
                                if (_1st.getValue () > _2nd.getValue ())
                                {
                                    return -1;
                                }

                                else if (_1st.getValue () < _2nd.getValue ())
                                {
                                    return 1;
                                }

                                else
                                {
                                    return 0;
                                }
                            }
                        }
                );
    }

    private void calPossis ()
    {

        int сharacs_m = 0;
        boolean enumerator = true;

        for (int o = 0; o < 2; o++)
        {
            for (Node<Character, Integer> kod : this.frequs)
            {
                if (enumerator)
                {
                    сharacs_m += kod.getValue();
                }
                else
                {
                    kod.setPossibility((double) kod.getValue() / сharacs_m);
                }
            }
            enumerator = false;
        }
        cumboly = сharacs_m;
    }


    private void generCoda (ArrayList <Node <Character , Integer>> kods_list)
    {

        if (kods_list.size () > 1)
        {
            ArrayList <Node <Character , Integer>> lside = new ArrayList <Node <Character , Integer>> () ;
            ArrayList <Node <Character , Integer>> rside = new ArrayList <Node <Character , Integer>> () ;

            class Helper
            {
                public double sum (ArrayList <Node <Character , Integer>> restList , int nachalo)
                {
                    double res = 0d ;
                    for (int o = nachalo ; o < restList.size () ; o++)
                    {
                        res += restList.get (o).getPossibility () ;
                    }
                    return res ;
                }
            }

            Helper pomosh = new Helper () ;
            int konec = 1 ;

            while (konec < kods_list.size ())
            {
                double pos_ttl = 0d ;
                //System.out.println("Step" + stop);
                for (int o = 0 ; o < konec ; o++)
                {
                    pos_ttl += kods_list.get (o).getPossibility () ;
                }


                if (Math.abs (pos_ttl - pomosh.sum (kods_list , konec)) <= 0.2)
                {
                    for (int o = 0 ; o<konec ; o++)
                    {
                        kods_list.get (o).setCode (kods_list.get (o).getCode () + '0') ;
                        lside.add (kods_list.get (o)) ;
                    }

                    for (int o = konec; o < kods_list.size () ; o++)
                    {
                        kods_list.get (o).setCode (kods_list.get (o).getCode () + '1') ;
                        rside.add (kods_list.get (o)) ;
                    }
                    break ;
                }
                konec++ ;
            }
            System.out.println("");
            DecimalFormat doTreh = new DecimalFormat("#.###");
            for(int o=0;o<konec;o+=2){
                System.out.println("Node" + o + ": " +  lside.get(o) + " " + doTreh.format(lside.get(o).getPossibility()) + " " + lside.get(o).getCode());
                int p= o+1;
               System.out.println("Node" + p + ": " + rside.get(o) + " " + doTreh.format(rside.get(o).getPossibility()) + " " + rside.get(o).getCode());
            }
            this.generCoda (lside) ;
            this.generCoda (rside) ;
        }
    }

    private String ecdes (String kods_line)
    {

        String encdd = "" ;

        for (int o = 0 ; o < kods_line.length () ; o++)
        {
            for (Node <Character , Integer> kod : this.frequs)
            {
                if (kods_line.charAt (o) == kod.getKey ())
                {
                    encdd += kod.getCode () ;
                }
            }
        }
        return encdd ;
    }
    public static void ochistka()
    {
        try{
            FileWriter filwr = new FileWriter("src/sample/txt_files/encddfile.txt", false);

            PrintWriter prinwr = new PrintWriter(filwr, false);

            prinwr.flush();
            prinwr.close();
            filwr.close();
        }catch(Exception exception){
            System.out.println("Exception found");
        }
    }
}
