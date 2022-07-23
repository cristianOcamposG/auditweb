
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

   public boolean insertarCompany(Company company) throws Exception{
       try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO base.company ");
            sb.append("(name, ruc, date_create,  phone, address, status) ");
            sb.append("VALUES(?1,?2,CURRENT_DATE,?3,?4,true) ");
            Query q = em.createNativeQuery(sb.toString());
            q.setParameter(1, company.getName());
            q.setParameter(2, company.getRuc());
            q.setParameter(3, company.getPhone());
            q.setParameter(4, company.getAddress());

            int result = q.executeUpdate();

            return result > 0;

       } catch (Exception e) {
           
           System.out.println("Error al actualizar infoDevica por dispositivo."+ e.getMessage());
            throw new Exception("Error al crear la cabecera rendicion."+ e);

           
       }
       
       
   }
     
}
