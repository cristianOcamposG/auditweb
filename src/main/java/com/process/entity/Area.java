
package com.process.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crixx
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findById", query = "SELECT a FROM Area a WHERE a.id = :id"),
    @NamedQuery(name = "Area.findByDescription", query = "SELECT a FROM Area a WHERE a.description = :description"),
    @NamedQuery(name = "Area.findByStatus", query = "SELECT a FROM Area a WHERE a.status = :status")})
public class Area implements Serializable {

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
    @JoinColumn(name = "id_branch_office", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BranchOffice idBranchOffice;
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @ManyToOne
    private Company idCompany;
    @OneToMany(mappedBy = "idArea")
    private List<DetailArea> detailAreaList;

    public Area() {
    }

    public Area(Integer id) {
        this.id = id;
    }

    public Area(Integer id, String description, boolean status) {
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
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.process.entity.Area[ id=" + id + " ]";
    }
    
}
