/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bizummultihilo;

import java.util.ArrayList;
import java.util.Random;
import java.math.*;

/**
 *
 * @author yago4
 */
public class BizumMultihilo {

     public static void main(String[] args) {
        int numUsuarios = 4000;  
        int numTransacciones = 10000;
        double saldoInicialMax = 1000.0;  
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Random random = new Random();

  
        for (int i = 0; i < numUsuarios; i++) {
            usuarios.add(new Usuario(i, random.nextDouble() * saldoInicialMax));
        }

        Contabilidad contabilidad = new Contabilidad(usuarios);

        double saldoTotalInicial = contabilidad.calcularTotalSaldo();
        System.out.printf("Saldo total inicial: %.2f euros\n", saldoTotalInicial);

  
        ArrayList<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < numTransacciones; i++) {
            int idOrigen = random.nextInt(numUsuarios);
            int idDestino = random.nextInt(numUsuarios);
            double monto = random.nextDouble() * 500;

            Thread transaccion = new Transaccion(contabilidad, idOrigen, idDestino, monto);
            hilos.add(transaccion);
        }

  
        for (Thread hilo : hilos) {
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double saldoTotalFinal = contabilidad.calcularTotalSaldo();
        System.out.printf("Saldo total final: %.2f euros\n", saldoTotalFinal);
        System.out.printf("Saldo total inicial: %.2f euros\n", saldoTotalInicial);
       
        if (Math.abs(saldoTotalInicial - saldoTotalFinal) < 0.01) {
            System.out.println("La contabilidad es correcta: el saldo total se mantiene.");
        } else {
            System.out.println("Discrepancia en la contabilidad: revisar el código.");
        }
        
        // Al cambiar el número de usuarios y al quitar el sincronizado hice varias pruebas y a veces si que había diferencia
    }
}
