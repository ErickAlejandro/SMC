/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Who I am
 */
@Entity
@Table(name = "a\u00f1olectivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "A\u00f1olectivo.findAll", query = "SELECT a FROM A\u00f1olectivo a")
    , @NamedQuery(name = "A\u00f1olectivo.findById", query = "SELECT a FROM A\u00f1olectivo a WHERE a.id = :id")
    , @NamedQuery(name = "A\u00f1olectivo.findByA\u00f1o", query = "SELECT a FROM A\u00f1olectivo a WHERE a.a\u00f1o = :a\u00f1o")
    , @NamedQuery(name = "A\u00f1olectivo.findByEstado", query = "SELECT a FROM A\u00f1olectivo a WHERE a.estado = :estado")})
public class Añolectivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "a\u00f1o")
    private String año;
    @Column(name = "estado")
    private String estado;

    public Añolectivo() {
    }

    public Añolectivo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof Añolectivo)) {
            return false;
        }
        Añolectivo other = (Añolectivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.A\u00f1olectivo[ id=" + id + " ]";
    }
    
}
