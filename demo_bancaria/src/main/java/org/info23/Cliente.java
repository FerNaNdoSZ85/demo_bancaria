package org.info23;

public class Cliente {
    private static int contador = 1;
    int dni;
    private int nCuenta;
    private String titular;
    private String tipoCuenta;

    private int tipoMoneda;

    public Cliente() {
    } //puedo quitarlo?

    public Cliente(String titular, int dni, int nCuenta, String tipoCuenta, int tipoMoneda) {
        this.titular = titular;
        this.dni = dni;
        this.nCuenta = nCuenta;
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        contador += 1;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(int nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getMoneda() {
        return tipoMoneda;
    }

    public void setMoneda(int moneda) {
        this.tipoMoneda = moneda;
    }

    public String toString() {
        return "\nTITULAR: " + this.getTitular() +
                "\nDNI: " + this.getDni() +
                "\nN° Cuenta: " + this.getnCuenta() +
                "\nMoneda: " + this.getMoneda() +
                "\nCUENTA: " + this.getTipoCuenta();  // falta agregar y mostrar tipo cuenta ahorro, corriente, usd o peso
    }
}
