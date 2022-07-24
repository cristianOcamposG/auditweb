package com.process.AuditPrue.model;

import com.process.ErrorMenssage.Message;
import com.process.auditexception.AuditEJBException;
import com.process.entity.Company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CompanyModel {

    @PersistenceContext(unitName = "AuditoriaDS")
    private EntityManager em;

    Date Fecha;

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(String f) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Fecha = sdf.parse(f);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Company> listarCompany() {
        StringBuilder sb = new StringBuilder();
        sb.append("select c.* ");
        sb.append("  from base.company c");
        Query query = em.createNativeQuery(sb.toString(), Company.class);
        return query.getResultList();

    }

    public List<Company> findByRucCompany(Company company) throws AuditEJBException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT c.* ");
            sb.append("FROM base.company c");
            sb.append("where ruc =?1 ");

            Query query = em.createNativeQuery(sb.toString());
            query.setParameter(1, company.getRuc());
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");

            List l = query.getResultList();

            if (l.isEmpty()) {
                return null;
            } else {
                return query.getResultList();
            }
        } catch (Exception ex) {
            throw new AuditEJBException("Error al buscar company por ruc manage.", ex);
        }
    }

    public boolean insertarCompany(Company company) throws AuditEJBException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO base.company ");
            sb.append("(name, ruc, date_create,  phone, address, status) ");
            sb.append("VALUES(?1,?2,CURRENT_DATE,?3,?4,true)");
            Query q = em.createNativeQuery(sb.toString());
            q.setParameter(1, company.getName());
            q.setParameter(2, company.getRuc());
            q.setParameter(3, company.getPhone());
            q.setParameter(4, company.getAddress());

            int result = q.executeUpdate();

            return result > 0;

        } catch (Exception e) {
            Message.addErrorMessage("RUC", "Ya existe un ruc registrado");
            throw new AuditEJBException("Error al crear company.", e);

        }

    }

    public Company obtenerRuc(String ruc) {

        return em.find(Company.class, ruc);

    }

    public int editComapany(String ruc) throws AuditEJBException {
        try {
            Company company = obtenerRuc(ruc);
            company.setDateModified(Fecha);
            company.setPhone(company.getPhone());
            company.setAddress(company.getPhone());
            em.merge(company);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int EliminarComapany(String ruc) {
        try {
            Company company = em.find(Company.class, ruc);
            if (company != null) {
                em.remove(company);
                em.flush();
                return 1;
            }
            return 0;

        } catch (Exception e) {
            return 0;
        }

    }

}
