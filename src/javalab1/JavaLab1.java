/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Damian Darczuk
 */




public class JavaLab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        int tryb = 1;
        String sciezka = "tak";
        boolean czyPoprawne = false;
        Scanner odczyt = new Scanner(System.in); 

 
        while(!czyPoprawne) {  
            try {
                tryb = odczyt.nextInt();            
                sciezka = odczyt.next();
                if (!new File(sciezka).exists()) {
                   throw  new FileNotFoundException();
                }
                czyPoprawne = true;
            }
            catch(FileNotFoundException e ) { 
                System.out.println("Niepoprawna ścieżka. Wpisz poprawną! ");
            }
            catch (NumberFormatException n) { System.out.println("Niepoprawne dane! " +
                     "\n Który element tablicy chcesz zobaczyć: ");
            }       // zmienić wyjątek 
        }
            
       System.out.println("Wybrałeś tryb: " + tryb + " Dla ścieżki: " + sciezka); 
       DiskFile file = new DiskFile(sciezka, tryb);
       file.wypisz();
        

    
    }
    
}
