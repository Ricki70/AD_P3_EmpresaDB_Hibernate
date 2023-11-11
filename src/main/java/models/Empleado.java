package models;

import java.time.LocalDate;
import java.util.UUID;

//import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "empleado")
@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM empleado e")
@NamedQuery(name = "Empleado.findAllWithDepartamentoInfo", query = "SELECT e, d.id, d.nombre FROM empleado e LEFT JOIN e.departamento d")
public class Empleado {
	@Id
	private String id = UUID.randomUUID().toString();
	private String nombre;
	private Double salario;
	
	@ManyToOne
	@JoinColumn(name="departamento", nullable = true)
	@OneToOne(mappedBy = "empleado")
	private Departamento departamento;
	
	public Empleado(String nombre, Double salario, LocalDate nacido) {
		setNombre(nombre);
		setSalario(salario);
	}
	
	public Empleado(Integer id, String nombre) {
		setNombre(nombre);
	}
	
	@Override
	public String toString() {
		String format = "[ %-36s ][ %-20s ][ %-8s ][ %-55s ]";
		String salarioStr = (salario != null) ? Double.toString(this.salario) : "N/A";
		String departamentoInfo = (departamento != null) ? departamento.getId() + " | " + departamento.getNombre() : "N/A";
	    return String.format(format, this.id.toString(), this.nombre, salarioStr, departamentoInfo);
	}
}
