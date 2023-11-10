package dao.departamento;

import java.util.List;
import java.util.logging.Logger;

import db.HibernateManager;
import jakarta.persistence.TypedQuery;
import models.Departamento;

public class DaoDepartamentoImpl implements DaoDepartamento{
	private final Logger logger = Logger.getLogger(DaoDepartamentoImpl.class.getName());
	
	@Override
	public List<Departamento> listar() {
		logger.info("findAll()");
        HibernateManager hb = HibernateManager.getInstance();
        hb.open();
        TypedQuery<Departamento> query = hb.getManager().createNamedQuery("Departamento.findAll", Departamento.class);
        List<Departamento> list = query.getResultList();
        hb.close();
        return list;
	}

	@Override
	public Departamento save(Departamento entity) {
		return null;
	}

	@Override
	public Boolean delete(Departamento entity) {
		return null;
	}

}
