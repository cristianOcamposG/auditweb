/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.process.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crixx
 */
@Entity
@Table(name = "branch_office")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchOffice.findAll", query = "SELECT b FROM BranchOffice b"),
    @NamedQuery(name = "BranchOffice.findById", query = "SELECT b FROM BranchOffice b WHERE b.id = :id"),
    @NamedQuery(name = "BranchOffice.findByName", query = "SELECT b FROM BranchOffice b WHERE b.name = :name"),
    @NamedQuery(name = "BranchOffice.findByStatus", query = "SELECT b FROM BranchOffice b WHERE b.status = :status")})
public class BranchOffice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBranchOffice")
    private List<Area> areaList;
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company idCompany;
    @OneToMany(mappedBy = "idBranchOffice")
    private List<DetailArea> detailAreaList;

    public BranchOffice() {
    }

    public BranchOffice(Integer id) {
        this.id = id;
    }

    public BranchOffice(Integer id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    @XmlTransient
    public List<DetailArea> getDetailAreaList() {
        return detailAreaList;
    }

    public void setDetailAreaList(List<DetailArea> detailAreaList) {
        this.detailAreaList = detailAreaList;
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
        if (!(object instanceof BranchOffice)) {
            return false;
        }
        BranchOffice other = (BranchOffice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.process.entity.BranchOffice[ id=" + id + " ]";
    }
    
}
