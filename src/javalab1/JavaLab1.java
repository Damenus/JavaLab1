/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Math.log;
import static java.lang.StrictMath.log;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Damian Darczuk
 */




public class JavaLab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
      
            
            int tryb = 1;                    
            String sciezka = "tak";
            boolean czyPoprawne = false;
          /*
            Scanner odczyt = new Scanner(System.in);
            
            
            while(!czyPoprawne) {
                try {
                    System.out.println("Wybierz tryb: 1 posortowane, 2 nieposortowane ");
                    tryb = odczyt.nextInt();
                    if (tryb != 1 && tryb != 2)
                        throw new NumberFormatException();
                    
                    System.out.println("Wprowadź ścieżkę ");
                    sciezka = odczyt.next();                    
                    if (!new File(sciezka).exists()) 
                        throw  new FileNotFoundException();                    
                    
                    czyPoprawne = true;
                }
                catch(FileNotFoundException e ) {
                    System.out.println("Niepoprawna ścieżka.\nWpisz poprawną! ");
                }
                catch (NumberFormatException n) { 
                    System.out.println("Niepoprawne dane!\nWybierz poprawny tryb ");
                }        
            }
            
            System.out.println("Wybrałeś tryb: " + tryb + ". Dla ścieżki: " + sciezka);
            
            
          */
        
                       
            DiskFile file = new DiskFile("D:/", tryb);
            File zapisz = new File("D:/tmp.txt");
            
            serialize(file,zapisz);
            DiskFile file2 = deserialize(zapisz);
            
            file2.wypisz();
            
                       
    }
    
    public static void serialize(DiskFile diskFile, File file) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(diskFile);
        } catch (IOException ex) {
            Logger.getLogger(JavaLab1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(JavaLab1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static DiskFile deserialize(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            DiskFile list = (DiskFile) ois.readObject();
            return list;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JavaLab1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
