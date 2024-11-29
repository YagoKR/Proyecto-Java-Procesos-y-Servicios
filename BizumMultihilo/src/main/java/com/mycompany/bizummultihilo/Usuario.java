/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bizummultihilo;

/**
 *
 * @author yago4
 */
public class Usuario {
    private int id;
    private double saldo;

    public Usuario(int id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public void agregarSaldo(double monto) {
        saldo += monto;
    }

    public void restarSaldo(double monto) {
        saldo -= monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }
}
