/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Entidades.Discapacidad;
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
public class DiscapacidadJpaController implements Serializable {

    public DiscapacidadJpaController( ) {
       this.emf = Persistence.createEntityManagerFactory("SistemaClaudioNeiraPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Discapacidad discapacidad) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(discapacidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDiscapacidad(discapacidad.getId()) != null) {
                throw new PreexistingEntityException("Discapacidad " + discapacidad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Discapacidad discapacidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            discapacidad = em.merge(discapacidad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = discapacidad.getId();
                if (findDiscapacidad(id) == null) {
                    throw new NonexistentEntityException("The discapacidad with id " + id + " no longer exists.");
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
            Discapacidad discapacidad;
            try {
                discapacidad = em.getReference(Discapacidad.class, id);
                discapacidad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The discapacidad with id " + id + " no longer exists.", enfe);
            }
            em.remove(discapacidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Discapacidad> findDiscapacidadEntities() {
        return findDiscapacidadEntities(true, -1, -1);
    }

    public List<Discapacidad> findDiscapacidadEntities(int maxResults, int firstResult) {
        return findDiscapacidadEntities(false, maxResults, firstResult);
    }

    private List<Discapacidad> findDiscapacidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Discapacidad.class));
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

    public Discapacidad findDiscapacidad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Discapacidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiscapacidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Discapacidad> rt = cq.from(Discapacidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
