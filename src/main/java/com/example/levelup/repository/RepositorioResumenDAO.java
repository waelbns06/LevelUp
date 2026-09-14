package com.example.levelup.repository;

import com.example.levelup.database.ConexionDB;
import com.example.levelup.model.ProductoBajoStock;
import com.example.levelup.model.ResumenFacturacionCategoria;
import com.example.levelup.model.ResumenFacturacionCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioResumenDAO {

    public List<ResumenFacturacionCliente> getFacturacionPorCliente() {

        List<ResumenFacturacionCliente> lista = new ArrayList<>();

        String sql = """
                SELECT CONCAT(c.nombre, ' ', c.apellidos) AS nombre_cliente,
                       SUM(p.total) AS total_facturado
                FROM cliente c
                INNER JOIN pedido p ON c.id_cliente = p.id_cliente
                GROUP BY c.id_cliente, c.nombre, c.apellidos
                ORDER BY total_facturado DESC
                """;

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                ResumenFacturacionCliente resumen =
                        new ResumenFacturacionCliente(
                                resultado.getString("nombre_cliente"),
                                resultado.getDouble("total_facturado")
                        );

                lista.add(resumen);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener facturación por cliente: " + e.getMessage());
        }

        return lista;
    }

    public List<ResumenFacturacionCategoria> getFacturacionPorCategoria() {

        List<ResumenFacturacionCategoria> lista = new ArrayList<>();

        String sql = """
                SELECT cat.nombre AS nombre_categoria,
                       SUM(dp.subtotal) AS total_facturado
                FROM categoria cat
                INNER JOIN producto pr ON cat.id_categoria = pr.id_categoria
                INNER JOIN detalle_pedido dp ON pr.id_producto = dp.id_producto
                GROUP BY cat.id_categoria, cat.nombre
                ORDER BY total_facturado DESC
                """;

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                ResumenFacturacionCategoria resumen =
                        new ResumenFacturacionCategoria(
                                resultado.getString("nombre_categoria"),
                                resultado.getDouble("total_facturado")
                        );

                lista.add(resumen);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener facturación por categoría: " + e.getMessage());
        }

        return lista;
    }

    public List<ProductoBajoStock> getProductosBajoStock() {

        List<ProductoBajoStock> lista = new ArrayList<>();

        String sql = """
                SELECT nombre AS nombre_producto,
                       stock
                FROM producto
                WHERE stock <= 20
                ORDER BY stock ASC
                """;

        try (
                Connection conexion = ConexionDB.getConnection();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                ProductoBajoStock producto =
                        new ProductoBajoStock(
                                resultado.getString("nombre_producto"),
                                resultado.getInt("stock")
                        );

                lista.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener productos con bajo stock: " + e.getMessage());
        }

        return lista;
    }
}