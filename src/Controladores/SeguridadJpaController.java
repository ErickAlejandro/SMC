/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Seguridad;
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
public class SeguridadJpaController implements Serializable {

    public SeguridadJpaController( ) {
      this.emf = Persistence.createEntityManagerFactory("SistemaClaudioNeiraPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Seguridad seguridad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(seguridad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Seguridad seguridad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            seguridad = em.merge(seguridad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = seguridad.getIdSeguridad();
                if (findSeguridad(id) == null) {
                    throw new NonexistentEntityException("The seguridad with id " + id + " no longer exists.");
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
            Seguridad seguridad;
            try {
                seguridad = em.getReference(Seguridad.class, id);
                seguridad.getIdSeguridad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The seguridad with id " + id + " no longer exists.", enfe);
            }
            em.remove(seguridad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Seguridad> findSeguridadEntities() {
        return findSeguridadEntities(true, -1, -1);
    }

    public List<Seguridad> findSeguridadEntities(int maxResults, int firstResult) {
        return findSeguridadEntities(false, maxResults, firstResult);
    }

    private List<Seguridad> findSeguridadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Seguridad.class));
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

    public Seguridad findSeguridad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Seguridad.class, id);
        } finally {
            em.close();
        }
    }

    public int getSeguridadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Seguridad> rt = cq.from(Seguridad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
