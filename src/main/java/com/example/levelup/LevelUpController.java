package com.example.levelup;

import com.example.levelup.model.Cliente;
import com.example.levelup.model.Producto;
import com.example.levelup.model.ProductoBajoStock;
import com.example.levelup.model.ResumenFacturacionCategoria;
import com.example.levelup.model.ResumenFacturacionCliente;
import com.example.levelup.repository.RepositorioClienteDAO;
import com.example.levelup.repository.RepositorioProductoDAO;
import com.example.levelup.repository.RepositorioResumenDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class LevelUpController {

    @FXML private VBox panelCatalogo;
    @FXML private VBox panelEdicion;
    @FXML private VBox panelResumenCategoria;
    @FXML private VBox panelClientes;
    @FXML private VBox panelFacturacion;
    @FXML private VBox panelFacturacionCliente;
    @FXML private VBox panelFacturacionCategoria;
    @FXML private VBox panelProductosBajoStock;
    @FXML private VBox panelCrudProductos;

    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, Integer> colId;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colApellidos;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colTelefono;
    @FXML private TableColumn<Cliente, String> colDireccion;

    @FXML private TableView<ResumenFacturacionCliente> tablaFacturacionCliente;
    @FXML private TableColumn<ResumenFacturacionCliente, String> colResumenClienteNombre;
    @FXML private TableColumn<ResumenFacturacionCliente, Double> colResumenClienteTotal;

    @FXML private TableView<ResumenFacturacionCategoria> tablaFacturacionCategoria;
    @FXML private TableColumn<ResumenFacturacionCategoria, String> colResumenCategoriaNombre;
    @FXML private TableColumn<ResumenFacturacionCategoria, Double> colResumenCategoriaTotal;

    @FXML private TableView<ProductoBajoStock> tablaProductosBajoStock;
    @FXML private TableColumn<ProductoBajoStock, String> colProductoBajoStockNombre;
    @FXML private TableColumn<ProductoBajoStock, Integer> colProductoBajoStockStock;

    @FXML private TextField txtIdProducto;
    @FXML private TextField txtNombreProducto;
    @FXML private TextField txtDescripcionProducto;
    @FXML private TextField txtPrecioProducto;
    @FXML private TextField txtStockProducto;
    @FXML private TextField txtTipoProducto;
    @FXML private TextField txtIdCategoriaProducto;
    @FXML private Label lblMensajeProducto;

    private RepositorioClienteDAO repositorioClienteDAO = new RepositorioClienteDAO();
    private RepositorioResumenDAO repositorioResumenDAO = new RepositorioResumenDAO();
    private RepositorioProductoDAO repositorioProductoDAO = new RepositorioProductoDAO();

    private List<Producto> productos = new ArrayList<>();
    private int posicionProducto = 0;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        colResumenClienteNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        colResumenClienteTotal.setCellValueFactory(new PropertyValueFactory<>("totalFacturado"));

        colResumenCategoriaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));
        colResumenCategoriaTotal.setCellValueFactory(new PropertyValueFactory<>("totalFacturado"));

        colProductoBajoStockNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        colProductoBajoStockStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        cargarClientes();
        cargarFacturacionCliente();
        cargarFacturacionCategoria();
        cargarProductosBajoStock();
        cargarProductos();
    }

    private void cargarClientes() {
        tablaClientes.setItems(
                FXCollections.observableArrayList(
                        repositorioClienteDAO.getList()
                )
        );
    }

    private void cargarFacturacionCliente() {
        tablaFacturacionCliente.setItems(
                FXCollections.observableArrayList(
                        repositorioResumenDAO.getFacturacionPorCliente()
                )
        );
    }

    private void cargarFacturacionCategoria() {
        tablaFacturacionCategoria.setItems(
                FXCollections.observableArrayList(
                        repositorioResumenDAO.getFacturacionPorCategoria()
                )
        );
    }

    private void cargarProductosBajoStock() {
        tablaProductosBajoStock.setItems(
                FXCollections.observableArrayList(
                        repositorioResumenDAO.getProductosBajoStock()
                )
        );
    }

    private void cargarProductos() {

        productos = repositorioProductoDAO.getList();

        if (!productos.isEmpty()) {
            posicionProducto = 0;
            mostrarProducto();
        }
    }

    private void mostrarProducto() {

        if (productos.isEmpty()) {
            limpiarCamposProducto();
            return;
        }

        Producto producto = productos.get(posicionProducto);

        txtIdProducto.setText(String.valueOf(producto.getIdProducto()));
        txtNombreProducto.setText(producto.getNombre());
        txtDescripcionProducto.setText(producto.getDescripcion());
        txtPrecioProducto.setText(String.valueOf(producto.getPrecio()));
        txtStockProducto.setText(String.valueOf(producto.getStock()));
        txtTipoProducto.setText(producto.getTipoProducto());
        txtIdCategoriaProducto.setText(String.valueOf(producto.getIdCategoria()));
    }

    private Producto leerProductoFormulario() {

        Producto producto = new Producto();

        if (!txtIdProducto.getText().isEmpty()) {
            producto.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
        }

        producto.setNombre(txtNombreProducto.getText());
        producto.setDescripcion(txtDescripcionProducto.getText());
        producto.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
        producto.setStock(Integer.parseInt(txtStockProducto.getText()));
        producto.setTipoProducto(txtTipoProducto.getText());
        producto.setIdCategoria(Integer.parseInt(txtIdCategoriaProducto.getText()));

        return producto;
    }

    private void limpiarCamposProducto() {

        txtIdProducto.clear();
        txtNombreProducto.clear();
        txtDescripcionProducto.clear();
        txtPrecioProducto.clear();
        txtStockProducto.clear();
        txtTipoProducto.clear();
        txtIdCategoriaProducto.clear();
    }

    private void ocultarTodos() {

        panelCatalogo.setVisible(false);
        panelEdicion.setVisible(false);
        panelResumenCategoria.setVisible(false);
        panelClientes.setVisible(false);
        panelFacturacion.setVisible(false);
        panelFacturacionCliente.setVisible(false);
        panelFacturacionCategoria.setVisible(false);
        panelProductosBajoStock.setVisible(false);
        panelCrudProductos.setVisible(false);
    }

    @FXML
    private void mostrarCatalogo() {
        ocultarTodos();
        panelCatalogo.setVisible(true);
    }

    @FXML
    private void mostrarEdicion() {
        ocultarTodos();
        panelEdicion.setVisible(true);
    }

    @FXML
    private void mostrarResumenCategoria() {
        ocultarTodos();
        panelResumenCategoria.setVisible(true);
    }

    @FXML
    private void mostrarClientes() {
        ocultarTodos();
        panelClientes.setVisible(true);
        cargarClientes();
    }

    @FXML
    private void mostrarFacturacion() {
        ocultarTodos();
        panelFacturacion.setVisible(true);
    }

    @FXML
    private void mostrarFacturacionCliente() {
        ocultarTodos();
        panelFacturacionCliente.setVisible(true);
        cargarFacturacionCliente();
    }

    @FXML
    private void mostrarFacturacionCategoria() {
        ocultarTodos();
        panelFacturacionCategoria.setVisible(true);
        cargarFacturacionCategoria();
    }

    @FXML
    private void mostrarProductosBajoStock() {
        ocultarTodos();
        panelProductosBajoStock.setVisible(true);
        cargarProductosBajoStock();
    }

    @FXML
    private void mostrarCrudProductos() {
        ocultarTodos();
        panelCrudProductos.setVisible(true);
        cargarProductos();
    }

    @FXML
    private void primerProducto() {
        if (!productos.isEmpty()) {
            posicionProducto = 0;
            mostrarProducto();
        }
    }

    @FXML
    private void anteriorProducto() {
        if (!productos.isEmpty() && posicionProducto > 0) {
            posicionProducto--;
            mostrarProducto();
        }
    }

    @FXML
    private void siguienteProducto() {
        if (!productos.isEmpty() && posicionProducto < productos.size() - 1) {
            posicionProducto++;
            mostrarProducto();
        }
    }

    @FXML
    private void ultimoProducto() {
        if (!productos.isEmpty()) {
            posicionProducto = productos.size() - 1;
            mostrarProducto();
        }
    }

    @FXML
    private void nuevoProducto() {
        limpiarCamposProducto();
        lblMensajeProducto.setText("Introduce los datos del nuevo producto.");
    }

    @FXML
    private void guardarProducto() {

        try {
            Producto producto = leerProductoFormulario();

            repositorioProductoDAO.add(producto);

            lblMensajeProducto.setText("Producto guardado correctamente.");

            cargarProductos();

        } catch (Exception e) {
            lblMensajeProducto.setText("Error al guardar el producto.");
        }
    }

    @FXML
    private void actualizarProducto() {

        try {
            Producto producto = leerProductoFormulario();

            repositorioProductoDAO.update(producto);

            lblMensajeProducto.setText("Producto actualizado correctamente.");

            cargarProductos();

        } catch (Exception e) {
            lblMensajeProducto.setText("Error al actualizar el producto.");
        }
    }

    @FXML
    private void borrarProducto() {

        try {
            int idProducto = Integer.parseInt(txtIdProducto.getText());

            repositorioProductoDAO.remove(idProducto);

            lblMensajeProducto.setText("Producto borrado correctamente.");

            cargarProductos();

        } catch (Exception e) {
            lblMensajeProducto.setText("Error al borrar el producto.");
        }
    }
}
