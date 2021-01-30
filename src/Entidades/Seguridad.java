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
@Table(name = "seguridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguridad.findAll", query = "SELECT s FROM Seguridad s")
    , @NamedQuery(name = "Seguridad.findByIdSeguridad", query = "SELECT s FROM Seguridad s WHERE s.idSeguridad = :idSeguridad")
    , @NamedQuery(name = "Seguridad.findByCedEst", query = "SELECT s FROM Seguridad s WHERE s.cedEst = :cedEst")
    , @NamedQuery(name = "Seguridad.findByApeEst", query = "SELECT s FROM Seguridad s WHERE s.apeEst = :apeEst")
    , @NamedQuery(name = "Seguridad.findByNomEst", query = "SELECT s FROM Seguridad s WHERE s.nomEst = :nomEst")
    , @NamedQuery(name = "Seguridad.findByA\u00f1oBas", query = "SELECT s FROM Seguridad s WHERE s.a\u00f1oBas = :a\u00f1oBas")
    , @NamedQuery(name = "Seguridad.findByApeRep", query = "SELECT s FROM Seguridad s WHERE s.apeRep = :apeRep")
    , @NamedQuery(name = "Seguridad.findByNomRep", query = "SELECT s FROM Seguridad s WHERE s.nomRep = :nomRep")
    , @NamedQuery(name = "Seguridad.findByDirEst", query = "SELECT s FROM Seguridad s WHERE s.dirEst = :dirEst")
    , @NamedQuery(name = "Seguridad.findByTelEst", query = "SELECT s FROM Seguridad s WHERE s.telEst = :telEst")
    , @NamedQuery(name = "Seguridad.findByFormaTraslado", query = "SELECT s FROM Seguridad s WHERE s.formaTraslado = :formaTraslado")
    , @NamedQuery(name = "Seguridad.findByCedResponsable", query = "SELECT s FROM Seguridad s WHERE s.cedResponsable = :cedResponsable")
    , @NamedQuery(name = "Seguridad.findByApellidosResponsable", query = "SELECT s FROM Seguridad s WHERE s.apellidosResponsable = :apellidosResponsable")
    , @NamedQuery(name = "Seguridad.findByNombresResponsable", query = "SELECT s FROM Seguridad s WHERE s.nombresResponsable = :nombresResponsable")
    , @NamedQuery(name = "Seguridad.findByTelefonoResponsable", query = "SELECT s FROM Seguridad s WHERE s.telefonoResponsable = :telefonoResponsable")
    , @NamedQuery(name = "Seguridad.findByModalidadTransporte", query = "SELECT s FROM Seguridad s WHERE s.modalidadTransporte = :modalidadTransporte")})
public class Seguridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seguridad")
    private Integer idSeguridad;
    @Basic(optional = false)
    @Column(name = "ced_est")
    private String cedEst;
    @Basic(optional = false)
    @Column(name = "ape_est")
    private String apeEst;
    @Basic(optional = false)
    @Column(name = "nom_est")
    private String nomEst;
    @Basic(optional = false)
    @Column(name = "a\u00f1o_bas")
    private int añoBas;
    @Basic(optional = false)
    @Column(name = "ape_rep")
    private String apeRep;
    @Basic(optional = false)
    @Column(name = "nom_rep")
    private String nomRep;
    @Basic(optional = false)
    @Column(name = "dir_est")
    private String dirEst;
    @Basic(optional = false)
    @Column(name = "tel_est")
    private int telEst;
    @Basic(optional = false)
    @Column(name = "forma_traslado")
    private String formaTraslado;
    @Column(name = "ced_responsable")
    private String cedResponsable;
    @Column(name = "apellidos_responsable")
    private String apellidosResponsable;
    @Column(name = "nombres_responsable")
    private String nombresResponsable;
    @Column(name = "telefono_responsable")
    private String telefonoResponsable;
    @Column(name = "modalidad_transporte")
    private String modalidadTransporte;

    public Seguridad() {
    }

    public Seguridad(Integer idSeguridad) {
        this.idSeguridad = idSeguridad;
    }

    public Seguridad(Integer idSeguridad, String cedEst, String apeEst, String nomEst, int añoBas, String apeRep, String nomRep, String dirEst, int telEst, String formaTraslado) {
        this.idSeguridad = idSeguridad;
        this.cedEst = cedEst;
        this.apeEst = apeEst;
        this.nomEst = nomEst;
        this.añoBas = añoBas;
        this.apeRep = apeRep;
        this.nomRep = nomRep;
        this.dirEst = dirEst;
        this.telEst = telEst;
        this.formaTraslado = formaTraslado;
    }

    public Integer getIdSeguridad() {
        return idSeguridad;
    }

    public void setIdSeguridad(Integer idSeguridad) {
        this.idSeguridad = idSeguridad;
    }

    public String getCedEst() {
        return cedEst;
    }

    public void setCedEst(String cedEst) {
        this.cedEst = cedEst;
    }

    public String getApeEst() {
        return apeEst;
    }

    public void setApeEst(String apeEst) {
        this.apeEst = apeEst;
    }

    public String getNomEst() {
        return nomEst;
    }

    public void setNomEst(String nomEst) {
        this.nomEst = nomEst;
    }

    public int getAñoBas() {
        return añoBas;
    }

    public void setAñoBas(int añoBas) {
        this.añoBas = añoBas;
    }

    public String getApeRep() {
        return apeRep;
    }

    public void setApeRep(String apeRep) {
        this.apeRep = apeRep;
    }

    public String getNomRep() {
        return nomRep;
    }

    public void setNomRep(String nomRep) {
        this.nomRep = nomRep;
    }

    public String getDirEst() {
        return dirEst;
    }

    public void setDirEst(String dirEst) {
        this.dirEst = dirEst;
    }

    public int getTelEst() {
        return telEst;
    }

    public void setTelEst(int telEst) {
        this.telEst = telEst;
    }

    public String getFormaTraslado() {
        return formaTraslado;
    }

    public void setFormaTraslado(String formaTraslado) {
        this.formaTraslado = formaTraslado;
    }

    public String getCedResponsable() {
        return cedResponsable;
    }

    public void setCedResponsable(String cedResponsable) {
        this.cedResponsable = cedResponsable;
    }

    public String getApellidosResponsable() {
        return apellidosResponsable;
    }

    public void setApellidosResponsable(String apellidosResponsable) {
        this.apellidosResponsable = apellidosResponsable;
    }

    public String getNombresResponsable() {
        return nombresResponsable;
    }

    public void setNombresResponsable(String nombresResponsable) {
        this.nombresResponsable = nombresResponsable;
    }

    public String getTelefonoResponsable() {
        return telefonoResponsable;
    }

    public void setTelefonoResponsable(String telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }

    public String getModalidadTransporte() {
        return modalidadTransporte;
    }

    public void setModalidadTransporte(String modalidadTransporte) {
        this.modalidadTransporte = modalidadTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguridad != null ? idSeguridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguridad)) {
            return false;
        }
        Seguridad other = (Seguridad) object;
        if ((this.idSeguridad == null && other.idSeguridad != null) || (this.idSeguridad != null && !this.idSeguridad.equals(other.idSeguridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Seguridad[ idSeguridad=" + idSeguridad + " ]";
    }
    
}
