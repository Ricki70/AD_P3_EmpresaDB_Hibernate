package dao.empleado;

import java.util.List;
import java.util.logging.Logger;

import dao.departamento.DaoDepartamentoImpl;
import db.HibernateManager;
import jakarta.persistence.TypedQuery;
import models.Empleado;

public class DaoEmpleadoImpl implements DaoEmpleado{
	private final Logger logger = Logger.getLogger(DaoDepartamentoImpl.class.getName());
	@Override
	public List<Empleado> listar() {
		logger.info("findAll()");
        HibernateManager hb = HibernateManager.getInstance();
        hb.open();
        TypedQuery<Empleado> query = hb.getManager().createNamedQuery("Empleado.findAll", Empleado.class);
        List<Empleado> list = query.getResultList();
        hb.close();
        return list;
	}

	@Override
	public Empleado save(Empleado entity) {
		return null;
	}

	@Override
	public Boolean delete(Empleado entity) {
		return null;
	}

}
