/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.process.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crixx
 */
@Entity
@Table(name = "detail_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailArea.findAll", query = "SELECT d FROM DetailArea d"),
    @NamedQuery(name = "DetailArea.findById", query = "SELECT d FROM DetailArea d WHERE d.id = :id"),
    @NamedQuery(name = "DetailArea.findByDescription", query = "SELECT d FROM DetailArea d WHERE d.description = :description"),
    @NamedQuery(name = "DetailArea.findByStatus", query = "SELECT d FROM DetailArea d WHERE d.status = :status")})
public class DetailArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    private boolean status;
    @JoinColumn(name = "id_area", referencedColumnName = "id")
    @ManyToOne
    private Area idArea;
    @JoinColumn(name = "id_branch_office", referencedColumnName = "id")
    @ManyToOne
    private BranchOffice idBranchOffice;
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @ManyToOne
    private Company idCompany;
    @JoinColumn(name = "id_user_modify", referencedColumnName = "id_user")
    @ManyToOne
    private User idUserModify;

    public DetailArea() {
    }

    public DetailArea(Integer id) {
        this.id = id;
    }

    public DetailArea(Integer id, String description, boolean status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public BranchOffice getIdBranchOffice() {
        return idBranchOffice;
    }

    public void setIdBranchOffice(BranchOffice idBranchOffice) {
        this.idBranchOffice = idBranchOffice;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    public User getIdUserModify() {
        return idUserModify;
    }

    public void setIdUserModify(User idUserModify) {
        this.idUserModify = idUserModify;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailArea)) {
            return false;
        }
        DetailArea other = (DetailArea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.process.entity.DetailArea[ id=" + id + " ]";
    }
    
}
