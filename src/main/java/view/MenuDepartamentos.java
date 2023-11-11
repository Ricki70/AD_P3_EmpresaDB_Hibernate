package view;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import IO.IO;
import constantes.color.Colores;
import controllers.EmpresaController;
import models.Empleado;
import models.Departamento;

public class MenuDepartamentos {
	public static void mostrarMenu(EmpresaController controller) {

		List<String> opciones = List.of("\n ======|MENU DEPARTAMENTOS|=====\n", "| 1.- Listar Departamentos	|\n",
				"| 2.- Agregar Departamento	|\n", "| 3.- Modificar Departamento    |\n",
				"| 4.- Eliminar Departamento     |\n", "| 5.- Volver al menu principal  |\n",
				" ===============================\n");

		while (true) {
			opciones.stream().forEach(System.out::print);
			IO.print("\nIntroduce tu elección: ");
			switch (IO.readInt()) {
			case 1:
				listarDepartamentos(controller);
				break;
			case 2:
				insertDepartamento(controller);
				break;
			case 3:
				updateDepartamento(controller);
				break;
			case 4:
				deleteDepartamento(controller);
				break;
			case 5:
				MenuPrincipal.main(null);
				break;
			default:
				IO.println(Colores.ROJO + "Opción no válida" + Colores.RESET);
			}
		}
	}

	/**
	 * Método para listar los departamentos al usuario.
	 * 
	 * @param controller
	 */
	private static void listarDepartamentos(EmpresaController controller) {
		// Obtenemos todos los departamentos
		List<Departamento> departamentos = controller.getDepartamentos().stream()
                .sorted(Comparator.comparing(Departamento::getNombre))
                .collect(Collectors.toList());
		// Mostramos todos los departamentos
		String format = "[ %-36s ][ %-20s ][ %-55s ]";
		System.out.println(String.format(format, "ID", "NOMBRE", "JEFE"));
        departamentos.forEach(System.out::println);
	}

	/**
	 * Método para solicitar campos de un departamento e insertarlo en la base de datos.
	 * 
	 * @param controller
	 */
	private static void insertDepartamento(EmpresaController controller) {
		// Obtenemos los datos del departamento que se quiere insertar
		String nombre = IO.readString("Nombre ? ");
		UUID jefe = IO.readUUIDOptional("Jefe ? ");

		// Creamos el departamento y lo insertamos
		Departamento departamento = new Departamento(nombre, new Empleado(jefe));
				
		// Comprobamos si se ha insertado el registro y damos feedback
		IO.println(controller.createDepartamento(departamento) ? "Insertado correctamente" :
				Colores.ROJO 
				+ "No se ha encontrado un empleado con el ID introducido" 
				+ Colores.RESET);
	}

	private static void updateDepartamento(EmpresaController controller) {
		// Obtenemos los datos del departamento que se quiere modificar
				IO.print("ID ? ");
				UUID id = IO.readUUID();
				IO.print("Nombre ? ");
				String nombre = IO.readStringOptional();
				IO.print("Jefe ? ");
				UUID jefe = IO.readUUIDOptional();

				// Creamos el departamento y lo modificamos
				Departamento departamento = new Departamento(id, nombre, new Empleado(jefe));
				IO.println(controller.updateDepartamento(departamento) ? "Actualizado correctamente"
						: Colores.ROJO 
						+ "\nRegistro no encontrado o Información no válida\n" 
						+ "Asegúrese de:\n"
						+ "- Haber rellenado al menos 1 campo\n"
						+ "- Que el ID del departamento a modificar exista en la tabla departamento\n"
						+ "- Que el ID del jefe exista en la tabla empleado" 
						+ Colores.RESET);
	}

	private static void deleteDepartamento(EmpresaController controller) {
		UUID jefe = IO.readUUID("ID Departamento ? ");
		Departamento departamento = new Departamento(jefe);
		
		IO.println(controller.deleteDepartamento(departamento) ? "Eliminado correctamente" :
			Colores.ROJO 
			+ "No se ha encontrado un Departamento con el ID introducido" 
			+ Colores.RESET);
	}
}