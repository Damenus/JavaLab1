/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab1;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Damian Darczuk
 */
public class DiskFile implements Serializable, Comparable<DiskFile> {    
    
    public enum Type {
        Katalog,
        Plik;
    }    
    
    private Set<DiskFile> Files;
    private Date date; 
    private String name;
    private Type type;
    
    public DiskFile() {        
    }
    
    public DiskFile(String sciezka, int tryb) {
        File file = new File(sciezka);
        
        this.name = file.getName();
        this.date.setTime(file.lastModified());
        
        if (file.isFile())
             this.type = type.Plik;
        else if (file.isDirectory()) {
            this.type = type.Katalog;
            
            File[] filesArray = file.listFiles();
            
            if (tryb == 1) {
                Files = new TreeSet();
            }
            else if (tryb == 2) {
                Files = new HashSet();
            }
            
            for(File f : filesArray) {
                Files.add(new DiskFile(f.getAbsolutePath(),tryb) );
                   
            }
            
            
         }    
        
    }
    
    
    public void wypisz() {
        
        System.out.println("-");   
        System.out.println(this.getName());   
        
        if (this.getType() == type.Katalog)
             System.out.println("\tK\t");
        else
            System.out.println("\tP\t");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        String formatedDate = sdf.format(date);
        System.out.println(formatedDate);        
        
    }
    
    Type getType() {
        return this.type;
    }
    
    String getName() {
        return this.name;
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
       // hash = 89 * hash + this.date;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiskFile other = (DiskFile) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.date != other.date) {
            return false;
        }
        return true;
    }
    
     @Override
    public int compareTo(DiskFile o) {
        return name.compareTo(o.name);
    }
    
    private void przeszukaj(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                przeszukaj(file);
            } else {
                // tu sobie sprawdz czy to poszukiwany plik
            }
        }
    }
}