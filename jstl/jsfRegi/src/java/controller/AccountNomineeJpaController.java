/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import entity.AccountNominee;
import entity.AccountNomineePK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author User
 */
public class AccountNomineeJpaController implements Serializable {

    public AccountNomineeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AccountNominee accountNominee) throws PreexistingEntityException, Exception {
        if (accountNominee.getAccountNomineePK() == null) {
            accountNominee.setAccountNomineePK(new AccountNomineePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(accountNominee);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAccountNominee(accountNominee.getAccountNomineePK()) != null) {
                throw new PreexistingEntityException("AccountNominee " + accountNominee + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AccountNominee accountNominee) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            accountNominee = em.merge(accountNominee);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                AccountNomineePK id = accountNominee.getAccountNomineePK();
                if (findAccountNominee(id) == null) {
                    throw new NonexistentEntityException("The accountNominee with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(AccountNomineePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AccountNominee accountNominee;
            try {
                accountNominee = em.getReference(AccountNominee.class, id);
                accountNominee.getAccountNomineePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accountNominee with id " + id + " no longer exists.", enfe);
            }
            em.remove(accountNominee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AccountNominee> findAccountNomineeEntities() {
        return findAccountNomineeEntities(true, -1, -1);
    }

    public List<AccountNominee> findAccountNomineeEntities(int maxResults, int firstResult) {
        return findAccountNomineeEntities(false, maxResults, firstResult);
    }

    private List<AccountNominee> findAccountNomineeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AccountNominee.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AccountNominee findAccountNominee(AccountNomineePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AccountNominee.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountNomineeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AccountNominee> rt = cq.from(AccountNominee.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
