
package com.process.AuditPrue.manage_beans;

import com.process.AuditPrue.model.CompanyModel;
import com.process.entity.Company;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author crixx
 */
@Named(value = "companyManageBeans")
@RequestScoped
public class CompanyManageBeans {

    @EJB
    private CompanyModel companyModel;
    
    List<Company> listaCompany;   

    public List<Company> getListaCompany() {
        listaCompany = companyModel.listarCompany();
        return listaCompany;
    }

    public CompanyManageBeans() {
    }
    
}
