/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mlyt02;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yago.martinezloureda
 */
public class Hijo {
    public static void main(String[] args) throws IOException {
        int i = Integer.parseInt(args[0]);
        Random r = new Random ();
        char [] alfa = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        File f1 = new File("fichero1.txt");
        File f2 = new File("fichero2.txt");
        File f3 = new File("fichero3.txt");
        File f4 = new File("fichero4.txt");      
        File f5 = new File("fichero5.txt");
              
        switch(i) {
            case 1 -> {
                if (f1.exists()) {
                    f1.delete();
                }
                if(!f1.exists()) {
                    f1.createNewFile();
                }
                try (
                FileOutputStream fich = new FileOutputStream(f1);
                DataOutputStream dOs = new DataOutputStream(fich);
                ) {
                for (int num = 0; num < 100; num++) {
                    int ran = r.nextInt(0,27);
                    char a = alfa[ran];
                    dOs.write(a);
                }
            } catch (IOException ex) {
                Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            case 2 -> {
                if (f2.exists()) {
                    f2.delete();
                }
                if(!f2.exists()) {
                    f2.createNewFile();
                }
                try (
                FileReader fich = new FileReader(f1);
                BufferedReader bR = new BufferedReader(fich);
                FileWriter fiche = new FileWriter(f2);
                BufferedWriter bw = new BufferedWriter(fiche);
                ) {
                    List<Character> vocales = new ArrayList<>();
                    int num;
                    while ((num = bR.read()) != -1) {
                        char ch = (char) num;
                        if ("AEIOU".indexOf(ch) != -1) {
                            vocales.add(ch); 
                        }
                    }

                    Collections.sort(vocales);

                    for (char vocal : vocales) {
                        bw.write(vocal);
                    }

                    bw.flush(); 
                
            } catch (IOException ex) {
                Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
            case 3 -> {
                if (f3.exists()) {
                    f3.delete();
                }
                if(!f3.exists()) {
                    f3.createNewFile();
                }
                try (
                FileReader fich = new FileReader(f1);
                BufferedReader bR = new BufferedReader(fich);
                FileWriter fiche = new FileWriter(f3);
                BufferedWriter bw = new BufferedWriter(fiche);
                ) {
                    List<Character> consonantes = new ArrayList<>();
                    int num;
                    while ((num = bR.read()) != -1) {
                        char ch = (char) num;

                        if ("BCDFGHJKLMNÑPQRSTUVWXYZ".indexOf(ch) != -1) {
                            consonantes.add(ch); 
                        }
                    }

                    Collections.sort(consonantes);

                    for (char consonante : consonantes) {
                        bw.write(consonante);
                    }

                    bw.flush(); 
                
            } catch (IOException ex) {
                Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case 4 -> {
                if (f4.exists()) {
                    f4.delete();
                }
                if (!f4.exists()) {
                    f4.createNewFile();
                }

                try (
                    FileReader fich = new FileReader(f2);
                    BufferedReader bR = new BufferedReader(fich);
                    FileWriter fiche = new FileWriter(f4);
                    BufferedWriter bw = new BufferedWriter(fiche);
                ) {
                 
                    int acuA = 0, acuE = 0, acuI = 0, acuO = 0, acuU = 0;
                    int num;
                    while ((num = bR.read()) != -1) {
                        char ch = (char) num;
                        switch (ch) {
                            case 'A' -> acuA++;
                            case 'E' -> acuE++;
                            case 'I' -> acuI++;
                            case 'O' -> acuO++;
                            case 'U' -> acuU++;
                        }
                    }
                   
                    bw.write("Vocal A: " + acuA + "\n");
                    bw.write("Vocal E: " + acuE + "\n");
                    bw.write("Vocal I: " + acuI + "\n");
                    bw.write("Vocal O: " + acuO + "\n");
                    bw.write("Vocal U: " + acuU + "\n");
                    bw.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 5 -> {
                if (f5.exists()) {
                    f5.delete();
                }
                if (!f5.exists()) {
                    f5.createNewFile();
                }

                try (
                    FileReader fich = new FileReader(f3);
                    BufferedReader bR = new BufferedReader(fich);
                    FileWriter fiche = new FileWriter(f5);
                    BufferedWriter bw = new BufferedWriter(fiche);
                ) {
                    int acuB = 0, acuY = 0;
                    int num;
                    while ((num = bR.read()) != -1) {
                        char ch = (char) num;
                        if (ch == 'B') acuB++;
                        if (ch == 'Y') acuY++;
                    }

                    bw.write("Consonante B: " + acuB + "\n");
                    bw.write("Consonante Y: " + acuY + "\n");
                    bw.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
