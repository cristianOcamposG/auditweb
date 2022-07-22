/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.process.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author crixx
 */
@Embeddable
public class UserRolPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol")
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_company")
    private int idCompany;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_auditor")
    private int idAuditor;

    public UserRolPK() {
    }

    public UserRolPK(int idUser, int idRol, int idCompany, int idAuditor) {
        this.idUser = idUser;
        this.idRol = idRol;
        this.idCompany = idCompany;
        this.idAuditor = idAuditor;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdAuditor() {
        return idAuditor;
    }

    public void setIdAuditor(int idAuditor) {
        this.idAuditor = idAuditor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idRol;
        hash += (int) idCompany;
        hash += (int) idAuditor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRolPK)) {
            return false;
        }
        UserRolPK other = (UserRolPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.idCompany != other.idCompany) {
            return false;
        }
        if (this.idAuditor != other.idAuditor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.process.entity.UserRolPK[ idUser=" + idUser + ", idRol=" + idRol + ", idCompany=" + idCompany + ", idAuditor=" + idAuditor + " ]";
    }
    
}
