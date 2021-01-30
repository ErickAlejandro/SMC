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
@Table(name = "discapacidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discapacidad.findAll", query = "SELECT d FROM Discapacidad d")
    , @NamedQuery(name = "Discapacidad.findById", query = "SELECT d FROM Discapacidad d WHERE d.id = :id")
    , @NamedQuery(name = "Discapacidad.findByTipodediscapacidad", query = "SELECT d FROM Discapacidad d WHERE d.tipodediscapacidad = :tipodediscapacidad")})
public class Discapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipodediscapacidad")
    private String tipodediscapacidad;

    public Discapacidad() {
    }

    public Discapacidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipodediscapacidad() {
        return tipodediscapacidad;
    }

    public void setTipodediscapacidad(String tipodediscapacidad) {
        this.tipodediscapacidad = tipodediscapacidad;
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
        if (!(object instanceof Discapacidad)) {
            return false;
        }
        Discapacidad other = (Discapacidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Discapacidad[ id=" + id + " ]";
    }
    
}
