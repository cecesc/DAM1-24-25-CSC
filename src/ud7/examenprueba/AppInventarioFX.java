package ud7.examenprueba;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class AppInventarioFX extends Application {

    // Campos de entrada
    private TextField campoCodigo, campoNombre, campoCantidad, campoPrecio, campoBuscar;
    // Área de texto para mostrar mensajes y productos
    private TextArea areaResultado;
    // Ruta del fichero binario
    private final String FICHERO = "src/ud7/examenprueba/inventario.dat";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gestión de Inventario");

        // Crear campos de texto
        campoCodigo = new TextField();
        campoNombre = new TextField();
        campoCantidad = new TextField();
        campoPrecio = new TextField();
        campoBuscar = new TextField();

        // Etiquetas
        campoCodigo.setPromptText("Código");
        campoNombre.setPromptText("Nombre");
        campoCantidad.setPromptText("Cantidad");
        campoPrecio.setPromptText("Precio");
        campoBuscar.setPromptText("Código a buscar");

        // Área para mostrar resultados
        areaResultado = new TextArea();
        areaResultado.setEditable(false);

        // Botones
        Button btnAgregar = new Button("Agregar Producto");
        Button btnListar = new Button("Listar Productos");
        Button btnBuscar = new Button("Buscar Producto");

        // Asociar eventos a los botones
        btnAgregar.setOnAction(e -> agregarProducto());
        btnListar.setOnAction(e -> listarProductos());
        btnBuscar.setOnAction(e -> buscarProducto());

        // Layouts: organizamos visualmente los elementos
        VBox entradaDatos = new VBox(5, campoCodigo, campoNombre, campoCantidad, campoPrecio, btnAgregar);
        VBox buscarBox = new VBox(5, campoBuscar, btnBuscar);
        VBox botonesBox = new VBox(10, btnListar);
        VBox panelIzquierdo = new VBox(15, entradaDatos, buscarBox, botonesBox);
        panelIzquierdo.setPrefWidth(200);

        HBox principal = new HBox(15, panelIzquierdo, areaResultado);
        principal.setPadding(new javafx.geometry.Insets(10));

        // Crear y mostrar escena
        Scene scene = new Scene(principal, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    // Método para agregar un nuevo producto
    private void agregarProducto() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText().trim());
            String nombre = campoNombre.getText().trim();
            int cantidad = Integer.parseInt(campoCantidad.getText().trim());
            double precio = Double.parseDouble(campoPrecio.getText().trim());

            if (nombre.isEmpty()) {
                areaResultado.setText("ERROR: El nombre no puede estar vacío.");
                return;
            }

            List<Producto> productos = leerProductos();

            // Verificar si ya existe el código
            for (Producto p : productos) {
                if (p.getCodigo() == codigo) {
                    areaResultado.setText("ERROR: Ya existe un producto con ese código.");
                    return;
                }
            }

            productos.add(new Producto(codigo, nombre, cantidad, precio));
            guardarProductos(productos);
            areaResultado.setText("Producto agregado correctamente.");

            // Limpiar campos
            campoCodigo.clear();
            campoNombre.clear();
            campoCantidad.clear();
            campoPrecio.clear();

        } catch (NumberFormatException e) {
            areaResultado.setText("ERROR: Código, cantidad o precio con formato incorrecto.");
        } catch (IOException | ClassNotFoundException e) {
            areaResultado.setText("ERROR al guardar el producto: " + e.getMessage());
        }
    }

    // Método para listar todos los productos ordenados por código
    private void listarProductos() {
        try {
            List<Producto> productos = leerProductos();
            productos.sort(Comparator.comparingInt(Producto::getCodigo));

            if (productos.isEmpty()) {
                areaResultado.setText("No hay productos en el inventario.");
            } else {
                StringBuilder sb = new StringBuilder("LISTADO DE PRODUCTOS:\n");
                for (Producto p : productos) {
                    sb.append(p).append("\n");
                }
                areaResultado.setText(sb.toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            areaResultado.setText("ERROR al leer el inventario: " + e.getMessage());
        }
    }

    // Método para buscar un producto por su código
    private void buscarProducto() {
        try {
            int codigoBuscado = Integer.parseInt(campoBuscar.getText().trim());
            List<Producto> productos = leerProductos();

            for (Producto p : productos) {
                if (p.getCodigo() == codigoBuscado) {
                    areaResultado.setText("Producto encontrado:\n" + p.toString());
                    return;
                }
            }

            areaResultado.setText("Producto no encontrado.");

        } catch (NumberFormatException e) {
            areaResultado.setText("ERROR: Código de búsqueda no válido.");
        } catch (IOException | ClassNotFoundException e) {
            areaResultado.setText("ERROR al buscar el producto: " + e.getMessage());
        }
    }

    // Método para leer productos del archivo binario
    private List<Producto> leerProductos() throws IOException, ClassNotFoundException {
        File f = new File(FICHERO);
        if (!f.exists()) return new ArrayList<>(); // Si no existe, lista vacía

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (List<Producto>) ois.readObject();
        }
    }

    // Método para guardar la lista de productos en el archivo binario
    private void guardarProductos(List<Producto> productos) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            oos.writeObject(productos);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}