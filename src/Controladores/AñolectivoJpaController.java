/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Entidades.Añolectivo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Who I am
 */
public class AñolectivoJpaController implements Serializable {

    public AñolectivoJpaController( ) {
      this.emf = Persistence.createEntityManagerFactory("SistemaClaudioNeiraPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Añolectivo añolectivo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(añolectivo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAñolectivo(añolectivo.getId()) != null) {
                throw new PreexistingEntityException("A\u00f1olectivo " + añolectivo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Añolectivo añolectivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            añolectivo = em.merge(añolectivo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = añolectivo.getId();
                if (findAñolectivo(id) == null) {
                    throw new NonexistentEntityException("The a\u00f1olectivo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Añolectivo añolectivo;
            try {
                añolectivo = em.getReference(Añolectivo.class, id);
                añolectivo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The a\u00f1olectivo with id " + id + " no longer exists.", enfe);
            }
            em.remove(añolectivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Añolectivo> findAñolectivoEntities() {
        return findAñolectivoEntities(true, -1, -1);
    }

    public List<Añolectivo> findAñolectivoEntities(int maxResults, int firstResult) {
        return findAñolectivoEntities(false, maxResults, firstResult);
    }

    private List<Añolectivo> findAñolectivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Añolectivo.class));
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

    public Añolectivo findAñolectivo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Añolectivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getAñolectivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Añolectivo> rt = cq.from(Añolectivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
