package org.info23;

public class Banco {

    private static int contadorCuentas = 1;
    Cliente cliente;
    private int numeroCuenta;
    private int moneda;
    private double fondo = 0.0;

    public Banco() {
    }

    public Banco(Cliente cliente) {
        this.numeroCuenta = contadorCuentas;
        this.cliente = cliente;
        contadorCuentas += 1;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getFondo() {
        return fondo;
    }

    public void setFondo(double fondo) {
        this.fondo = fondo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toString() {

        return "\nTitular: " + this.cliente.getTitular() +
                "\nDNI: " + this.cliente.getDni() +
                "\nN° Cuenta: " + this.cliente.getnCuenta() +
                "\nMoneda: " + moneda +
                "\nFondos : " + Utils.doubleToString(this.getFondo()) +
                "\n";
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setFondo(getFondo() + valor);
            System.out.println("Operacion finalizada con exito");
        } else {
            System.out.println("No se puede realizar la operacion");
        }
    }

    public void extraer(double extraccion) {
        if (this.fondo > 0) {
            fondo -= extraccion;
        } else {
            System.out.println("FONDOS INSUFICIENTES ");
        }
    }

    public void transferir(Banco cuentaDeposito, Double valor) { // cuenta deposito?...
        if (this.fondo > 0) {
            cuentaDeposito.depositar(valor);
            this.extraer(valor);
        } else {
            System.out.println("No se Puede Trasnferir, FONDOS INSUFICIENTES");
        }
    }


}
