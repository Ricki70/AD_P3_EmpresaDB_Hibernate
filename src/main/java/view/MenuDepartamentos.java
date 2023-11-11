package view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import IO.IO;
import constantes.color.Colores;
import controllers.EmpresaController;
import models.Departamento;

public class MenuDepartamentos {
	public static void mostrarMenu(EmpresaController controller ) {

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
				insertDepartamento();
				break;
			case 3:
				updateDepartamento();
				break;
			case 4:
				deleteDepartamento();
				break;
			case 5:
				MenuPrincipal.main(null);
				break;
			default:
				IO.println(Colores.ROJO + "Opción no válida" + Colores.RESET);
			}
		}
	}

	private static void listarDepartamentos(EmpresaController controller) {

		
		
		// Obtenemos todos los tenistas
		List<Departamento> departamentos = controller.getDepartamentos().stream()
                .sorted(Comparator.comparing(Departamento::getNombre))
                .collect(Collectors.toList());
		String format = "[ %-36s ][ %-20s ][ %-55s ]";
		System.out.println(String.format(format, "ID", "NOMBRE", "JEFE"));
        departamentos.forEach(System.out::println);
	}

	private static void insertDepartamento() {
	}

	private static void updateDepartamento() {
	}

	private static void deleteDepartamento() {
	}
}