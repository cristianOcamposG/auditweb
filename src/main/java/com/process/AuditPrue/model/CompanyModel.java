
package com.process.AuditPrue.model;


import com.process.entity.Company;
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
   

   public List<Company> listarCompany() {
       StringBuilder sb = new StringBuilder();
            sb.append("select c.* ");
            sb.append("  from base.company c");
       Query query = em.createNativeQuery(sb.toString(),Company.class);
       return query.getResultList();
   
   }

   
     
}
