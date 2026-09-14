package com.example.levelup.model;

public class ProductoBajoStock {

    private String nombreProducto;
    private int stock;

    public ProductoBajoStock() {
    }

    public ProductoBajoStock(String nombreProducto, int stock) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}