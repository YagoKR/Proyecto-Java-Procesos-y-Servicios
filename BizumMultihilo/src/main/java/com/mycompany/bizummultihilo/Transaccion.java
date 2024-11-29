/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bizummultihilo;

/**
 *
 * @author yago4
 */
import java.util.Random;

public class Transaccion extends Thread {
    private Contabilidad contabilidad;
    private int idUsuarioOrigen;
    private int idUsuarioDestino;
    private double monto;

    public Transaccion(Contabilidad contabilidad, int idUsuarioOrigen, int idUsuarioDestino, double monto) {
        this.contabilidad = contabilidad;
        this.idUsuarioOrigen = idUsuarioOrigen;
        this.idUsuarioDestino = idUsuarioDestino;
        this.monto = monto;
    }

    @Override
    public synchronized void run() {
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    contabilidad.registrarTransaccion(idUsuarioOrigen, idUsuarioDestino, monto);
    }
}
