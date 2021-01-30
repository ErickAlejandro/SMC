/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Matriculacion;
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
public class MatriculacionJpaController implements Serializable {

    public MatriculacionJpaController( ) {
             this.emf = Persistence.createEntityManagerFactory("SistemaClaudioNeiraPU");

    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Matriculacion matriculacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(matriculacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Matriculacion matriculacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            matriculacion = em.merge(matriculacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = matriculacion.getNMatricula();
                if (findMatriculacion(id) == null) {
                    throw new NonexistentEntityException("The matriculacion with id " + id + " no longer exists.");
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
            Matriculacion matriculacion;
            try {
                matriculacion = em.getReference(Matriculacion.class, id);
                matriculacion.getNMatricula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The matriculacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(matriculacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Matriculacion> findMatriculacionEntities() {
        return findMatriculacionEntities(true, -1, -1);
    }

    public List<Matriculacion> findMatriculacionEntities(int maxResults, int firstResult) {
        return findMatriculacionEntities(false, maxResults, firstResult);
    }

    private List<Matriculacion> findMatriculacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Matriculacion.class));
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

    public Matriculacion findMatriculacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Matriculacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getMatriculacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Matriculacion> rt = cq.from(Matriculacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
