package org.info23;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Banco> cuentaBancaria;

    public static void main(String[] args) {
        cuentaBancaria = new ArrayList<Banco>();
        operaciones();
    }

    public static void operaciones() {
        System.out.println("******************************************************");
        System.out.println("*            -= Bienvenidos a la BANCA =-            *");
        System.out.println("*     Seleccione la operacion que desea realizar     *");
        System.out.println("******************************************************");
        System.out.println("1 - Crea Cuenta ");
        System.out.println("2 - Depositar Dinero ");
        System.out.println("3 - Extraer Dinero ");
        System.out.println("4 - Transferir ");
        System.out.println("5 - Ver Cuentas ");
        System.out.println("6 - Exportar Información ");
        System.out.println("7 - Salir ");

        int operacion = input.nextInt(); // ingreso por teclado la opcion

        switch (operacion) {
            case 1:
                crearCuenta();
                break;
            case 2:
                depositarDinero();
                break;
            case 3:
                extraerDinero();
                break;
            case 4:
                transferir();
                break;
            case 5:
                verCuentas();
                break;
            case 6:
                //Exportar_CSV.exportarCSV(); // aplicar esta funcionalidad al finalizar la creacion de cuentas
                break;
            case 7:
                System.out.println("Gracias por confiar en nosotros..Adios!! ");
                System.exit(0);

            default:
                System.out.println("OPCION INCORRECTA, INTENTE DE NUEVO");
                operaciones();
                break;
        }
    }

    public static void crearCuenta() {
        System.out.print("Titular de la cuenta: ");
        String titular = input.next(); // titular es el nombre

        System.out.print("dni: ");
        int dni = input.nextInt(); // dni del titular

        System.out.print("Numero de Cuenta: ");
        int nCuenta = input.nextInt(); // ingresa un numero de cuenta personal, puede generarse aleatoriamente?

        System.out.print("tipo de cuenta:---->     1 - AHORRO        2 - CORRIENTE");
        String tipoCuenta = input.next();

        System.out.print("Moneda:----> 1- PESOS              2- USD");
        int tipoMoneda = input.nextInt();

        if (tipoMoneda == 1) {
            String moneda1 = "PESOS";
        } else {
            if (tipoMoneda == 2) {
                String moneda1 = "USD";
            } else {
                System.out.print("OPCION INCORRECTA, INTENTE DE NUEVO");
            }
        }

        Cliente cliente = new Cliente(titular, dni, nCuenta, tipoCuenta, tipoMoneda);

        Banco banco = new Banco(cliente); //llamo a la clase Cliente y le paso los parametros

        cuentaBancaria.add(banco); //debo agregar a la lista la cuenta del cliente
        System.out.println("Cuenta Creada Satisfactoriamente");

        operaciones();
    }

    private static Banco encontrarCuenta(int numero) {
        Banco banco = null;
        for (Banco c : cuentaBancaria) {
            if (c.getNumeroCuenta() == numero & banco != null) ;
            banco = c;
        }
        return banco;
    }

    public static void depositarDinero() {
        System.out.print("Numero de Cuenta: ");
        int numeroCuenta = input.nextInt();

        // Banco banco = encontrarCuenta(numeroCuenta); // busca si existe la cuenta

        for (Banco cuenta : cuentaBancaria) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                System.out.print("Ingrese el MONTO que desea Depositar");
                double montoDeposito = input.nextDouble();
                cuenta.depositar(montoDeposito); // sin resolver aun
                operaciones();

            }
        }
        System.out.println("Error: N° de Cuenta no Existe!! ");
        operaciones();
    }

    public static void extraerDinero() {
        System.out.print("N° de Cuenta: ");
        int numeroCuenta = input.nextInt();

        for (Banco cuenta : cuentaBancaria) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                System.out.print("Ingrese MONTO a Extraer ");
                double extraccion = input.nextDouble();
                cuenta.extraer(extraccion); // sin resolver aun
                operaciones();
            }
        }
        operaciones();
    }

    public static void transferir() {
        System.out.print("Número de cuenta REMITENTE: "); //Solicito numero de cuenta del que envia
        int cuentaRemitente = input.nextInt();

        for (Banco cuenta1 : cuentaBancaria) {
            if (cuenta1.getNumeroCuenta() == cuentaRemitente) {
                System.out.print("Número de Cuenta DESTINO: "); //Solicito numero de cuenta del que recibe
                int cuentaDestino = input.nextInt();

                for (Banco cuenta2 : cuentaBancaria) {
                    if (cuenta2.getNumeroCuenta() == cuentaDestino) {

                        System.out.print("Ingrese Monto a ENVIAR");
                        double valor = input.nextDouble();

                        cuenta1.extraer(valor); // sin resolver aun
                        cuenta2.depositar(valor); // sin resolver aun
                        operaciones();
                    }
                    System.out.println("No Existe cuenta DESTINO!!");
                }
                System.out.println("Cuenta REMITENTE no Existe");
            }
        }
        operaciones();
    }

    public static void verCuentas() {
        if (cuentaBancaria.size() > 0) {
            for (Banco banco : cuentaBancaria) {
                System.out.println(banco);
            }
        } else {
            System.out.println("no se encontraron cuentas!");
        }
        operaciones();
    }
}