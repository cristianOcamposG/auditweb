package com.process.AuditPrue.manage_beans;

import com.process.AuditPrue.model.CompanyModel;
import com.process.ErrorMenssage.Message;
import com.process.auditexception.AuditEJBException;
import com.process.entity.Company;
import com.sun.net.httpserver.HttpServer;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
    List<Company> listaCompanyRUC;

    private Company company = new Company();

    public List<Company> getListaCompany() {
        listaCompany = companyModel.listarCompany();
        return listaCompany;
    }

    public List<Company> getListaCompanyRUC() throws AuditEJBException, Exception {
        try {
            listaCompanyRUC = companyModel.findByRucCompany(company);
            return listaCompanyRUC;
        } catch (AuditEJBException e) {
            throw new AuditEJBException("Error al buscar company por ruc model.", e);
        }

    }

    public void setListaCompanyRUC(List<Company> listaCompanyRUC) {
        this.listaCompanyRUC = listaCompanyRUC;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean guardarCompany() throws Exception {
        boolean estado = false;
        companyModel.insertarCompany(company);
        return estado;
    }

    public String obtenerRuc() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ruc = request.getParameter("ruc");
        company = companyModel.obtenerRuc(ruc);

        return "ver que puede ser";
    }

    public String ModificarCompany() throws Exception {

        String ruc = null;
        if (companyModel.editComapany(ruc) == 0) {
            Message.addErrorMessage("error", "en bean");
            return null;
        }
        System.out.println("exito");
        return "ver que retornar";
    }

    public String EliminarCompany() throws Exception {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ruc = request.getParameter("ruc");

        if (companyModel.EliminarComapany(ruc) > 0) {
            Message.addErrorMessage("exito", "al borrar");
        } else {
            Message.addErrorMessage("fracaso", "al borrar");
        }
        return null;
    }
}
