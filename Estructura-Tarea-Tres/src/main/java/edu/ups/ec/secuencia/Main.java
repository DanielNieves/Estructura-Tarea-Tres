/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.ups.ec.secuencia;

/**
 *
 * @author Usuario
 */


public class Main {
    public static void main(String[] args) {
        ValidadorModelo modelo = new ValidadorModelo();
        ValidadorVista vista = new ValidadorVista();
        ValidadorControlador controlador = new ValidadorControlador(modelo, vista);
        controlador.imprimirSecuencia();
    }
}