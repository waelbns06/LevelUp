package com.example.levelup.repository;

import com.example.levelup.database.ConexionDB;
import com.example.levelup.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioClienteDAO implements RepositorioDAO<Cliente> {

    @Override
    public void add(Cliente cliente) {
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public Cliente findById(int id) {
        return null;
    }

    @Override
    public List<Cliente> getList() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT id_cliente, nombre, apellidos, email, telefono, direccion FROM cliente";

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                Cliente cliente = new Cliente(
                        resultado.getInt("id_cliente"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("email"),
                        resultado.getString("telefono"),
                        resultado.getString("direccion")
                );

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
        }

        return clientes;
    }
}