/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ups.ec.secuencia;

/**
 *
 * @author Usuario
 */


import java.util.Scanner;
import java.util.Stack;

class ValidadorModelo {

    public void imprimirSecuencia(String secuencia) {
        Stack<Character> pila = new Stack<>();
        boolean error = false;

        for (char c : secuencia.toCharArray()) {
            if (esApertura(c)) {
                pila.push(c);
                imprimirPila(pila);
            } else if (esCierre(c)) {
                if (!pila.isEmpty() && esParValido(pila.peek(), c)) {
                    pila.pop();
                } else {
                    error = true;
                    break;
                }
                imprimirPila(pila);
            }
        }

        if (error || !pila.isEmpty()) {
            System.out.println("Secuencia no válida");
        }
    }

    private boolean esApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean esCierre(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean esParValido(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')')
                || (apertura == '[' && cierre == ']')
                || (apertura == '{' && cierre == '}');
    }

    private void imprimirPila(Stack<Character> pila) {
        for (char c : pila) {
            System.out.print(c);
        }
        System.out.println();
    }
}

class ValidadorVista {

    public String leerSecuencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la secuencia de caracteres:");
        return scanner.nextLine();
    }
}

class ValidadorControlador {

    private ValidadorModelo modelo;
    private ValidadorVista vista;

    public ValidadorControlador(ValidadorModelo modelo, ValidadorVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void imprimirSecuencia() {
        String secuencia = vista.leerSecuencia();
        modelo.imprimirSecuencia(secuencia);
    }
}
