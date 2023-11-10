package view;

import java.util.List;

import IO.IO;
import constantes.color.Colores;
import controllers.EmpresaController;
import dao.departamento.DaoDepartamentoImpl;
import dao.empleado.DaoEmpleadoImpl;
import db.HibernateManager;

import java.util.logging.Logger;

public class MenuPrincipal {
	
	static Logger logger = Logger.getLogger(MenuPrincipal.class.getName());
	
	 // Creamos nuestro controlador y le añadimos y le inyectamos las dependencias
    public static EmpresaController controller = new EmpresaController(
            new DaoDepartamentoImpl(),
            new DaoEmpleadoImpl()
    );
    
	public static void main(String[] args) {	
		
		// iniciamos las tablas de la base de datos
		initDataBase();
		
		List<String> opciones = List.of( 
				"\n =======|MENU PRINCIPAL|========\n",
				"| 1.- Gestionar Departamentos	 |\n", 
				"| 2.- Gestionar Empleados        |\n",
				"| 3.- Gestionar Proyectos        |\n", 
				"| 4.- Salir			 |\n",
				" ===============================\n"		
				);

		while (true) {
			opciones.stream().forEach(System.out :: print);
			IO.print("\nIntroduce tu elección: ");
			switch (IO.readInt()) {
				case 1:  // menú departamentos
					MenuDepartamentos.mostrarMenu(controller);
					break;
				case 2:  // menú empleados
					MenuEmpleados.mostrarMenu(controller);
					break;
				case 3:  // salir del menú
//					MenuProyectos.mostrarMenu();
				case 4:  // salir del menú
					System.exit(1);
				default:
					IO.println(Colores.ROJO + "Opción no válida" + Colores.RESET);
			}
		}

	}
	
	private static void initDataBase() {
		
        HibernateManager hb = HibernateManager.getInstance();

        hb.open();

        hb.close();
    }
	

}
