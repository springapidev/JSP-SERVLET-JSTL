/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class AccountNomineePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "account_id")
    private long accountId;
    @Basic(optional = false)
    @Column(name = "nominee_id")
    private long nomineeId;

    public AccountNomineePK() {
    }

    public AccountNomineePK(long accountId, long nomineeId) {
        this.accountId = accountId;
        this.nomineeId = nomineeId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(long nomineeId) {
        this.nomineeId = nomineeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) accountId;
        hash += (int) nomineeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountNomineePK)) {
            return false;
        }
        AccountNomineePK other = (AccountNomineePK) object;
        if (this.accountId != other.accountId) {
            return false;
        }
        if (this.nomineeId != other.nomineeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AccountNomineePK[ accountId=" + accountId + ", nomineeId=" + nomineeId + " ]";
    }
    
}
