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
@Table(name = "account_open")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountOpen.findAll", query = "SELECT a FROM AccountOpen a")
    , @NamedQuery(name = "AccountOpen.findById", query = "SELECT a FROM AccountOpen a WHERE a.id = :id")
    , @NamedQuery(name = "AccountOpen.findByAccountHolderName", query = "SELECT a FROM AccountOpen a WHERE a.accountHolderName = :accountHolderName")
    , @NamedQuery(name = "AccountOpen.findByAccountNumber", query = "SELECT a FROM AccountOpen a WHERE a.accountNumber = :accountNumber")
    , @NamedQuery(name = "AccountOpen.findByAddress", query = "SELECT a FROM AccountOpen a WHERE a.address = :address")
    , @NamedQuery(name = "AccountOpen.findByBalanceAmount", query = "SELECT a FROM AccountOpen a WHERE a.balanceAmount = :balanceAmount")
    , @NamedQuery(name = "AccountOpen.findByBithDate", query = "SELECT a FROM AccountOpen a WHERE a.bithDate = :bithDate")
    , @NamedQuery(name = "AccountOpen.findByEmail", query = "SELECT a FROM AccountOpen a WHERE a.email = :email")
    , @NamedQuery(name = "AccountOpen.findByGender", query = "SELECT a FROM AccountOpen a WHERE a.gender = :gender")
    , @NamedQuery(name = "AccountOpen.findByMobile", query = "SELECT a FROM AccountOpen a WHERE a.mobile = :mobile")
    , @NamedQuery(name = "AccountOpen.findByNationalId", query = "SELECT a FROM AccountOpen a WHERE a.nationalId = :nationalId")
    , @NamedQuery(name = "AccountOpen.findByOpeningDate", query = "SELECT a FROM AccountOpen a WHERE a.openingDate = :openingDate")
    , @NamedQuery(name = "AccountOpen.findByPrimaryDepositAmount", query = "SELECT a FROM AccountOpen a WHERE a.primaryDepositAmount = :primaryDepositAmount")
    , @NamedQuery(name = "AccountOpen.findByProfession", query = "SELECT a FROM AccountOpen a WHERE a.profession = :profession")
    , @NamedQuery(name = "AccountOpen.findByTotalWithrawn", query = "SELECT a FROM AccountOpen a WHERE a.totalWithrawn = :totalWithrawn")
    , @NamedQuery(name = "AccountOpen.findByAcTypeId", query = "SELECT a FROM AccountOpen a WHERE a.acTypeId = :acTypeId")})
public class AccountOpen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "account_holder_name")
    private String accountHolderName;
    @Basic(optional = false)
    @Column(name = "account_number")
    private long accountNumber;
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "balance_amount")
    private double balanceAmount;
    @Column(name = "bith_date")
    @Temporal(TemporalType.DATE)
    private Date bithDate;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "mobile")
    private String mobile;
    @Basic(optional = false)
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "opening_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;
    @Basic(optional = false)
    @Column(name = "primary_deposit_amount")
    private double primaryDepositAmount;
    @Column(name = "profession")
    private String profession;
    @Basic(optional = false)
    @Column(name = "total_withrawn")
    private double totalWithrawn;
    @Basic(optional = false)
    @Column(name = "ac_type_id")
    private long acTypeId;

    public AccountOpen() {
    }

    public AccountOpen(Long id) {
        this.id = id;
    }

    public AccountOpen(Long id, String accountHolderName, long accountNumber, double balanceAmount, String mobile, String nationalId, double primaryDepositAmount, double totalWithrawn, long acTypeId) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balanceAmount = balanceAmount;
        this.mobile = mobile;
        this.nationalId = nationalId;
        this.primaryDepositAmount = primaryDepositAmount;
        this.totalWithrawn = totalWithrawn;
        this.acTypeId = acTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Date getBithDate() {
        return bithDate;
    }

    public void setBithDate(Date bithDate) {
        this.bithDate = bithDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public double getPrimaryDepositAmount() {
        return primaryDepositAmount;
    }

    public void setPrimaryDepositAmount(double primaryDepositAmount) {
        this.primaryDepositAmount = primaryDepositAmount;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getTotalWithrawn() {
        return totalWithrawn;
    }

    public void setTotalWithrawn(double totalWithrawn) {
        this.totalWithrawn = totalWithrawn;
    }

    public long getAcTypeId() {
        return acTypeId;
    }

    public void setAcTypeId(long acTypeId) {
        this.acTypeId = acTypeId;
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
        if (!(object instanceof AccountOpen)) {
            return false;
        }
        AccountOpen other = (AccountOpen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AccountOpen[ id=" + id + " ]";
    }
    
}
