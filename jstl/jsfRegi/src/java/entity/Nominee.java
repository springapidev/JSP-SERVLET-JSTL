/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "nominee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nominee.findAll", query = "SELECT n FROM Nominee n")
    , @NamedQuery(name = "Nominee.findById", query = "SELECT n FROM Nominee n WHERE n.id = :id")
    , @NamedQuery(name = "Nominee.findByDateOfBirth", query = "SELECT n FROM Nominee n WHERE n.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Nominee.findByGender", query = "SELECT n FROM Nominee n WHERE n.gender = :gender")
    , @NamedQuery(name = "Nominee.findByMobile", query = "SELECT n FROM Nominee n WHERE n.mobile = :mobile")
    , @NamedQuery(name = "Nominee.findByNationalId", query = "SELECT n FROM Nominee n WHERE n.nationalId = :nationalId")
    , @NamedQuery(name = "Nominee.findByNomineeName", query = "SELECT n FROM Nominee n WHERE n.nomineeName = :nomineeName")})
public class Nominee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "national_id")
    private String nationalId;
    @Basic(optional = false)
    @Column(name = "nominee_name")
    private String nomineeName;

    public Nominee() {
    }

    public Nominee(Long id) {
        this.id = id;
    }

    public Nominee(Long id, Date dateOfBirth, String nomineeName) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.nomineeName = nomineeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
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
        if (!(object instanceof Nominee)) {
            return false;
        }
        Nominee other = (Nominee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Nominee[ id=" + id + " ]";
    }
    
}
