package models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity(name = "departamento")
@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM departamento d")
public class Departamento {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String nombre;
	
	//TODO: Revisar que se puedan insertar jefes en la clase departamento, por algun motivo me da error de clave foranea
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jefe", nullable = true)
	private Empleado jefe;
	
	@OneToMany(mappedBy = "departamento", orphanRemoval = false, cascade = CascadeType.ALL)
    private Set<Empleado> empleados = new HashSet<>();
	
	public Departamento(String nombre) {
		setNombre(nombre);
	}

	public Departamento(Integer id, String nombre) {
		setNombre(nombre);
	}
	
	@Override
	public String toString() {
	    String format = "[ %-36s ][ %-20s ][ %-55s ]";
	    String jefeInfo = (jefe != null) ? jefe.getId() + " | " + jefe.getNombre() : "N/A";
		return String.format(format, this.id.toString(), this.nombre, jefeInfo);
	}
}