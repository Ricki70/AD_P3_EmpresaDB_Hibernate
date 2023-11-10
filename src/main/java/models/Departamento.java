package models;

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

	public Departamento(String nombre) {
		setNombre(nombre);
	}

	public Departamento(Integer id, String nombre) {
		setNombre(nombre);
	}
	
	@Override
	public String toString() {
		String format = "[ %-36s ][ %-15s ]";
		return String.format(format, this.id.toString(), this.nombre);
	}
}