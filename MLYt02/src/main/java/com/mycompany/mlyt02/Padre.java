/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mlyt02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yago.martinezloureda
 */
public class Padre {
    
    public static void main(String[] args) {
        File f4 = new File ("fichero4.txt");
        File f5 = new File ("fichero5.txt");
        try {
            ProcessBuilder pb [] = new ProcessBuilder[5];
            String f = "C:\\Users\\yago4\\OneDrive\\Documentos\\NetBeansProjects\\MLYt02\\target\\classes";
            for (int i = 0; i < 5; i++) {
                String s = "" + (i+1);
                pb[i] = new ProcessBuilder ("java","-cp",f,"com.mycompany.mlyt02.Hijo",s);
            }
            
            Process p1 = pb[0].start();
            p1.waitFor();
            Process p2 = pb[1].start();
            Process p3 = pb[2].start();
            p3.waitFor();
            Process p4 = pb[3].start();
            p4.waitFor();
            Process p5 = pb[4].start();
            p5.waitFor();
       
        } catch (IOException ex) {
            Logger.getLogger(Padre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Padre.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Contenido de fichero4.txt:");
        mostrarFichero(f4);
            
        System.out.println("\nContenido de fichero5.txt:");
        mostrarFichero(f5);
    }
    
    public static void mostrarFichero(File file) {
        try (FileReader f = new FileReader(file);
             BufferedReader br = new BufferedReader(f)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Padre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
