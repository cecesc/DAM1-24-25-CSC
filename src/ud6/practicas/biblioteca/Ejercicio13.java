package ud6.practicas.biblioteca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*Ejercicio 13
Modifica el programa Gestisimal realizado anteriormente añadiendo las siguientes mejoras:
• Utiliza una lista en lugar de un array para el almacenamiento de los datos.
• Comprueba la existencia del código en el alta, la baja y la modificación
de artículos para evitar errores.
• Cambia la opción “Salida de stock” por “Venta”. Esta nueva opción permitirá hacer una
 venta de varios artículos y emitir la factura correspondiente. 
 Se debe preguntar por los códigos y las cantidades de cada artículo que
  se quiere comprar. Aplica un 21% de IVA.
*/
public class Ejercicio13 {

	static Scanner s = new Scanner(System.in);
	private static final String NOMBRE_FICHERO = "MisArticulos.obj";
	static ArrayList<Articulo> articulos = new ArrayList<Articulo>();

	public void iniciarEjercicio(){

		// RECUPERAMOS LA COLECCION DESDE FICHERO
		cargarDiscos();

		// Scanner s = new Scanner(System.in);

		// MENU ///////////////////////////////////////////////////////////////////
		int opcion;
		do {
			opcion = menu();
			if(opcion==1)listarArticulos();
			if(opcion==2)nuevoArticulo();
			if(opcion==3)eliminarArticulo();
			if(opcion==4)modificarArticulo();
			if(opcion==5)entradaMercancia();
			if(opcion==6)salidaMercancia();		
			if(opcion==8)guardarArticulos();
			if(opcion==9)modificarCodigo();
		} while (opcion != 7);
		guardarArticulos();
	}
	
	private int menu() {
		pintaTitulo("G E S T E S I M A L");
		System.out.println("1. Listado");
		System.out.println("2. Alta");
		System.out.println("3. Baja");
		System.out.println("4. Modificación de articulo (excepto codigo)");
		System.out.println("5. Entrada de mercancía");
		System.out.println("6. Salida de mercancía");
		System.out.println("7. Salir (ojo NO guarda)");
		System.out.println("8. Guardar Todos los articulos");
		System.out.println("9. CAMBIO DE CODIGO de articulo");
		System.out.print("Introduzca una opción: ");
		return s.nextInt();
	}

	// LISTADO ////////////////////////////////////////////////////////////
	private void listarArticulos() {
		pintaTitulo("LISTADO");

		for (Articulo a : articulos) {
			System.out.println(a);
		}
		return;

	}

	// ALTA ///////////////////////////////////////////////////////////////
	private void nuevoArticulo() {
		String descripcionIn;
		String codigoIn;
		Double precioDeCompraIn;
		Double precioDeVentaIn;
		Integer stockIn;
		pintaTitulo("NUEVO ARTÍCULO");
		
		codigoIn = peticionCodigo();
		pintaTitulo("DATOS DEL NUEVO ARTICULO");
		System.out.println("Codigo valido: " + codigoIn);
		System.out.print("Descripcion: ");
		descripcionIn = s.next();
		System.out.print("Precio de compra: ");
		precioDeCompraIn = Double.parseDouble(s.next());
		System.out.print("Precio de venta: ");
		precioDeVentaIn = Double.parseDouble(s.next());
		System.out.print("Stock: ");
		stockIn = Integer.parseInt(s.next());

		articulos.add(new Articulo(codigoIn, descripcionIn, precioDeCompraIn, precioDeVentaIn, stockIn));
		// }
	}

	// BAJA ///////////////////////////////////////////////////////////////
	private void eliminarArticulo() {
		String codigoIn;
		pintaTitulo("BAJA");
		System.out.print("Por favor, introduzca el código del artículo: ");
		codigoIn = s.next();
		if (!existeCodigo(codigoIn)) {
			System.out.println("Lo siento, el código introducido no existe.");
		} else {
			// como obtengo uyn objetyo para un codigo determinado
			articulos.remove(posicionConCodigo(codigoIn));
			System.out.println("Artículo borrado. Con codigo: " + codigoIn);
		}
		return;
	}

	// MODIFICACIÓN ///////////////////////////////////////////////////////
	private void modificarArticulo() {
		String codigoIn;
		String descripcionIn;
		pintaTitulo("MODIFICACIÓN");
		System.out.print("Por favor, introduzca el código del artículo: ");
		codigoIn = s.next();

		if (!existeCodigo(codigoIn)) {
			System.out.println("Lo siento, el código introducido no existe.");
		} else {
			int i = posicionConCodigo(codigoIn);
			Articulo prov = articulos.get(i);
			System.out.print("Introduzca los nuevos datos del artículo");
			System.out.println(" o INTRO para dejarlos igual.");

			// NO DEJO TOCAR EL CODIGO
			System.out.println("Código: " + prov.getCodigo());

			System.out.println("Descripción: " + prov.getDescripcion());
			System.out.print("Nueva descripción: ");
			descripcionIn = s.next();
			if (!descripcionIn.equals("")) {
				prov.setDescripcion(descripcionIn);
			}

			System.out.println("Precio de compra: " + prov.getPrecioDeCompra());
			System.out.print("Nuevo precio de compra: ");
			String precioDeCompraIntroducidoString = s.next();
			if (!precioDeCompraIntroducidoString.equals("")) {
				prov.setPrecioDeCompra(Double.parseDouble(precioDeCompraIntroducidoString));
			}

			System.out.println("Precio de venta: " + prov.getPrecioDeVenta());
			System.out.print("Nuevo precio de venta: ");
			String precioDeVentaIntroducidoString = s.next();
			if (!precioDeVentaIntroducidoString.equals("")) {
				prov.setPrecioDeVenta(Double.parseDouble(precioDeVentaIntroducidoString));
			}

			System.out.println("Stock: " + prov.getStock());
			System.out.print("Nuevo stock: ");
			String stockIntroducidoString = s.next();
			if (!stockIntroducidoString.equals("")) {
				prov.setStock(Integer.parseInt(stockIntroducidoString));
			}

			articulos.set(i, prov);
		}
		return;
	}

	// ENTRADA DE MERCANCÍA /////////////////////////////////////////////
	private void entradaMercancia() {
		String codigoIn;
		pintaTitulo("ENTRADA DE MERCANCÍA");
		System.out.print("Por favor, introduzca el código del artículo: ");
		codigoIn = s.next();

		if (!existeCodigo(codigoIn)) {
			System.out.println("Lo siento, el código introducido no existe.");
		} else {
			int i = posicionConCodigo(codigoIn);
			Articulo prov = articulos.get(i);

			System.out.println("Entrada de mercancía del siguiente artículo: ");
			System.out.println(prov);
			System.out.print("Introduzca el número de unidades que entran: ");
			String stockIntroducidoString = s.next();
			prov.setStock(Integer.parseInt(stockIntroducidoString) + prov.getStock());// comprobar
			System.out.println("La mercancía ha entrado en el almacén.");
			System.out.println("nuevo stock: " + prov.getStock());

			articulos.set(i, prov);
		}
		return;
	}

	// SALIDA DE MERCANCÍA ////////////////////////////////////////////
	private void salidaMercancia() {
		String codigoIn;
		Integer stockIn;
		pintaTitulo("SALIDA DE MERCANCÍA");
		System.out.print("Por favor, introduzca el código del artículo: ");
		codigoIn = s.next();

		if (!existeCodigo(codigoIn)) {
			System.out.println("Lo siento, el código introducido no existe.");
		} else {
			int i = posicionConCodigo(codigoIn);
			Articulo prov = articulos.get(i);
			System.out.println("Salida de mercancía del siguiente artículo: ");
			System.out.println(prov);
			System.out.print("Introduzca el número de unidades que desea sacar del almacén: ");
			stockIn = Integer.parseInt(s.next());
			if (prov.getStock() - stockIn > 0) {
				prov.setStock(prov.getStock() - stockIn);
				System.out.println("La mercancía ha salido del almacén.");
				System.out.println("nuevo stock: " + prov.getStock());

				articulos.set(i, prov);
			} else {
				System.out.println("Lo siento, no se pueden sacar tantas unidades.");
			}
		}
		return;
	}

	private void modificarCodigo() {
		String codigoIn;
		String nuevoCodigo;
		pintaTitulo("MODIFICAR SOLO CODIGO de articulo!");
		System.out.print("Por favor, introduzca el código del artículo: ");
		codigoIn = s.next();
		if (!existeCodigo(codigoIn)) {
			System.out.println("Lo siento, el código introducido no existe.");
		} else {
			System.out.print("Por favor, introduzca el código nuevo para el articulo:\n " + articulos.get(posicionConCodigo(codigoIn)));
			System.out.println();
			System.out.print("Codigo nuevo:");
			nuevoCodigo = s.next();
			if(existeCodigo(nuevoCodigo)) {
				System.out.println("Lo siento, ese codigo ya existe en algun articulo");
				return;
			}else {
				articulos.get(posicionConCodigo(codigoIn)).setCodigo(nuevoCodigo);
				System.out.println("Codigo nuevo establecido");
			}
		}
		

		return;
	} 

	public static void guardarArticulos() {
		try {
			FileOutputStream fileOut = new FileOutputStream(NOMBRE_FICHERO);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			// escribimos objetos en el flujo de salida
			objectOut.writeObject(articulos);

			objectOut.close();
			fileOut.close();
			System.out.println("Articulos guardados en archivo correctamente.");
		} catch (IOException kagada) {
			System.out.println("Error al guardar en archivo: " + kagada.getMessage());
		}
	}

	public static void cargarDiscos() {

		try {
			FileInputStream fileIn = new FileInputStream(NOMBRE_FICHERO);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			articulos = (ArrayList<Articulo>) objectIn.readObject();

			objectIn.close();
			fileIn.close();
			System.out.println("Articulos cargados desde archivo correctamente.");
		} catch (IOException | ClassNotFoundException cagada) {
			System.out.println("Error al cargar desde archivo: " + cagada.getMessage());
		}
	}

	public static boolean existeCodigo(String codigo) {
		for (Articulo a : articulos) {
			if (a.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}

	public static void pintaTitulo(String titulo) {
		System.out.println("\n" + titulo);
		for (int i = 0; i < titulo.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public static int posicionConCodigo(String codigo) {

		for (int i = 0; i < articulos.size(); i++) {
			if (articulos.get(i).getCodigo().equals(codigo)) {
				return i;
			}
		}
		return -1;
	}

	
	public static String peticionCodigo() {

		String codigoIn;
		System.out.println("Por favor, introduzca el codigo del artículo.");
		System.out.print("Código: ");
		do {
			codigoIn = s.next();
			if (existeCodigo(codigoIn)) {
				System.out.println("Ese código ya existe en la base de datos.");
				System.out.print("Introduzca otro código: ");
			}
		} while (existeCodigo(codigoIn));
		return codigoIn;
	}
}
