/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab1;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Damian Darczuk
 */
public class DiskFile implements Serializable, Comparable<DiskFile> {
    private Set<DiskFile> files;
    private int date; 
    private String name; 
    
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.date;
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
