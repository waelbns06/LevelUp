package com.example.levelup.model;

public class ResumenFacturacionCliente {

    private String nombreCliente;
    private double totalFacturado;

    public ResumenFacturacionCliente() {
    }

    public ResumenFacturacionCliente(String nombreCliente, double totalFacturado) {
        this.nombreCliente = nombreCliente;
        this.totalFacturado = totalFacturado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
}
