package com.example.levelup.repository;

import com.example.levelup.database.ConexionDB;
import com.example.levelup.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioProductoDAO implements RepositorioDAO<Producto> {

    @Override
    public void add(Producto producto) {

        String sql = "INSERT INTO producto (nombre, descripcion, precio, stock, tipo_producto, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());
            sentencia.setString(5, producto.getTipoProducto());
            sentencia.setInt(6, producto.getIdCategoria());

            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al añadir producto: " + e.getMessage());
        }
    }

    public void update(Producto producto) {

        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, stock = ?, tipo_producto = ?, id_categoria = ? WHERE id_producto = ?";

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setDouble(3, producto.getPrecio());
            sentencia.setInt(4, producto.getStock());
            sentencia.setString(5, producto.getTipoProducto());
            sentencia.setInt(6, producto.getIdCategoria());
            sentencia.setInt(7, producto.getIdProducto());

            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    @Override
    public void remove(int id) {

        String sql = "DELETE FROM producto WHERE id_producto = ?";

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setInt(1, id);
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al borrar producto: " + e.getMessage());
        }
    }

    @Override
    public Producto findById(int id) {

        String sql = "SELECT id_producto, nombre, descripcion, precio, stock, tipo_producto, id_categoria FROM producto WHERE id_producto = ?";

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setInt(1, id);

            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                return new Producto(
                        resultado.getInt("id_producto"),
                        resultado.getString("nombre"),
                        resultado.getString("descripcion"),
                        resultado.getDouble("precio"),
                        resultado.getInt("stock"),
                        resultado.getString("tipo_producto"),
                        resultado.getInt("id_categoria")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Producto> getList() {

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT id_producto, nombre, descripcion, precio, stock, tipo_producto, id_categoria FROM producto";

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                Producto producto = new Producto(
                        resultado.getInt("id_producto"),
                        resultado.getString("nombre"),
                        resultado.getString("descripcion"),
                        resultado.getDouble("precio"),
                        resultado.getInt("stock"),
                        resultado.getString("tipo_producto"),
                        resultado.getInt("id_categoria")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return productos;
    }
}