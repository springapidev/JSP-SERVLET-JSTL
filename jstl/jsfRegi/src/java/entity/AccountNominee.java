/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "account_nominee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountNominee.findAll", query = "SELECT a FROM AccountNominee a")
    , @NamedQuery(name = "AccountNominee.findByAccountId", query = "SELECT a FROM AccountNominee a WHERE a.accountNomineePK.accountId = :accountId")
    , @NamedQuery(name = "AccountNominee.findByNomineeId", query = "SELECT a FROM AccountNominee a WHERE a.accountNomineePK.nomineeId = :nomineeId")})
public class AccountNominee implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountNomineePK accountNomineePK;

    public AccountNominee() {
    }

    public AccountNominee(AccountNomineePK accountNomineePK) {
        this.accountNomineePK = accountNomineePK;
    }

    public AccountNominee(long accountId, long nomineeId) {
        this.accountNomineePK = new AccountNomineePK(accountId, nomineeId);
    }

    public AccountNomineePK getAccountNomineePK() {
        return accountNomineePK;
    }

    public void setAccountNomineePK(AccountNomineePK accountNomineePK) {
        this.accountNomineePK = accountNomineePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNomineePK != null ? accountNomineePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountNominee)) {
            return false;
        }
        AccountNominee other = (AccountNominee) object;
        if ((this.accountNomineePK == null && other.accountNomineePK != null) || (this.accountNomineePK != null && !this.accountNomineePK.equals(other.accountNomineePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AccountNominee[ accountNomineePK=" + accountNomineePK + " ]";
    }
    
}
