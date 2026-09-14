package com.example.levelup.model;

public class ResumenFacturacionCategoria {

    private String nombreCategoria;
    private double totalFacturado;

    public ResumenFacturacionCategoria() {
    }

    public ResumenFacturacionCategoria(String nombreCategoria, double totalFacturado) {
        this.nombreCategoria = nombreCategoria;
        this.totalFacturado = totalFacturado;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public double getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
}
