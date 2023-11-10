package dao;

import java.util.List;

/**
 * Interfaz con los métodos necesarios para realizar operaciones CRUD sobre la base de datos.
 * 
 * @param <T> tipo de objeto genérico (representa Empleado o Departamento)
 */
public interface DaoInterface<T> {
	/**
	 * Método para listar los registros de tabla.
	 * 
	 * @return 
	 */
	List<T> listar();
	
	/**
	 * Método para insertar un registro en la tabla.
	 * 
	 * @param t registro que se quiere insertar
	 * @return número de filas afectadas
	 */
	T save(T entity);
	
	/**
	 * Método para eliminar un registro de la tabla.
	 * 
	 * @param t registro que se quiere eliminar
	 * @return número de filas afectadas
	 */
	Boolean delete(T entity);
}
