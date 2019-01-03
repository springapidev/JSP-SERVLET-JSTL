/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import entity.AccountOpen;
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
public class AccountOpenJpaController implements Serializable {

    public AccountOpenJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AccountOpen accountOpen) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(accountOpen);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AccountOpen accountOpen) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            accountOpen = em.merge(accountOpen);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = accountOpen.getId();
                if (findAccountOpen(id) == null) {
                    throw new NonexistentEntityException("The accountOpen with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AccountOpen accountOpen;
            try {
                accountOpen = em.getReference(AccountOpen.class, id);
                accountOpen.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accountOpen with id " + id + " no longer exists.", enfe);
            }
            em.remove(accountOpen);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AccountOpen> findAccountOpenEntities() {
        return findAccountOpenEntities(true, -1, -1);
    }

    public List<AccountOpen> findAccountOpenEntities(int maxResults, int firstResult) {
        return findAccountOpenEntities(false, maxResults, firstResult);
    }

    private List<AccountOpen> findAccountOpenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AccountOpen.class));
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

    public AccountOpen findAccountOpen(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AccountOpen.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccountOpenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AccountOpen> rt = cq.from(AccountOpen.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
