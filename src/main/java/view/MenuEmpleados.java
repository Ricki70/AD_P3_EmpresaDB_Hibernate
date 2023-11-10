package view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import IO.IO;
import constantes.color.Colores;
import controllers.EmpresaController;
import models.Empleado;

public class MenuEmpleados {
	public static void mostrarMenu(EmpresaController controller) {

		List<String> opciones = List.of(
				"\n =======|MENU EMPLEADOS|========\n", 
				"| 1.- Listar Empleados	        |\n",
				"| 2.- Agregar Empleado	        |\n",
				"| 3.- Modificar Empleado 	|\n",
				"| 4.- Eliminar Empleado	     	|\n",
				"| 5.- Volver al menu principal  |\n", 
				" ===============================\n");

		while (true) {
			opciones.stream().forEach(System.out::print);
			IO.print("\nIntroduce tu elección: ");
			switch (IO.readInt()) {
				case 1:
					listarEmpleados(controller);
					break;
				case 2:
					insertEmpleado();
					break;
				case 3:
					updateEmpleado();
					break;
				case 4:
					deleteEmpleado();
					break;
				case 5:
					MenuPrincipal.main(null);
					break;
				default:
					IO.println(Colores.ROJO + "Opción no válida" + Colores.RESET);
			}
		}
	}

	private static void listarEmpleados(EmpresaController controller) {
		List<Empleado> empleados = controller.getEmpleados().stream()
                .sorted(Comparator.comparing(Empleado::getNombre))
                .collect(Collectors.toList());
        empleados.forEach(System.out::println);
	}

	private static void insertEmpleado() {

	}

	private static void updateEmpleado() {

	}

	private static void deleteEmpleado() {

	}
}
