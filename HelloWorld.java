package helloworld;
import java.util.*;    
import java.io.*;  

public class HelloWorld {

    public static void main(String[] args) { 
        
        Biblio.lireFichier("src/helloworld/biblio.txt");
        /*
          try { 
                BufferedReader br = new BufferedReader(new FileReader("src/helloworld/biblio.txt"));
                String line = br.readLine();                
                while (line != null) {
                    System.out.println(line);                    
                    line = br.readLine();
                }                
                br.close();       
            } catch (Exception ex ) {
                System.out.println("Problème d'ouverture du fichier" + "biblio.txt" );
            } 
         */ 
    }
}