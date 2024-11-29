/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bizummultihilo;

/**
 *
 * @author yago4
 */
import java.util.ArrayList;


public class Contabilidad {
    private ArrayList<Usuario> usuarios;

    public Contabilidad(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void registrarTransaccion(int idOrigen, int idDestino, double monto) {
        Usuario origen = usuarios.get(idOrigen);
        Usuario destino = usuarios.get(idDestino);

        if (origen.getSaldo() >= monto) {
            origen.restarSaldo(monto);
            destino.agregarSaldo(monto);
            System.out.printf("Transaccion: Usuario %d envia %.2f euros a Usuario %d\n", idOrigen, monto, idDestino);
        } else {
            System.out.printf("Transaccion fallida: Usuario %d no tiene suficiente saldo\n", idOrigen);
        }
    }

    public double calcularTotalSaldo() {
        return usuarios.stream().mapToDouble(Usuario::getSaldo).sum();
    }
}

