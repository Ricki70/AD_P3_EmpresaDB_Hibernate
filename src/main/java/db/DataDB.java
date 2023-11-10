package db;

import java.util.List;

import models.Departamento;

public final class DataDB {
    public static List<Departamento> getDepartamentoInit() {
        return List.of(
        		new Departamento("Informatica"),
                new Departamento("Administracion"),
                new Departamento("Recursos Humanos")
        );
    }
    
//    public static List<Empleado> getEmpleadoInit() {
//        return List.of(
//        		new Empleado("Pedro", 3500.0, LocalDate.parse("12-03-2000", DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
//        		new Empleado("Pablo", 4000.0, LocalDate.parse("24-12-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
//        		new Empleado("Alfonso", 2500.0, LocalDate.parse("10-04-1996", DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
//        		new Empleado("Almudena", 5000.0, LocalDate.parse("22-06-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
//        		new Empleado("Sara", 4750.0, LocalDate.parse("18-08-1999", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
//        );
//    }
//    
//    public static List<Proyecto> getProyectoInit() {
//        return List.of(
//        		new Proyecto("Evalaneca"),
//                new Proyecto("OrganismoGestion")
//        );
//    }
}