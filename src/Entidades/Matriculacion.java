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
@Table(name = "matriculacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matriculacion.findAll", query = "SELECT m FROM Matriculacion m")
    , @NamedQuery(name = "Matriculacion.findByNMatricula", query = "SELECT m FROM Matriculacion m WHERE m.nMatricula = :nMatricula")
    , @NamedQuery(name = "Matriculacion.findByFecha", query = "SELECT m FROM Matriculacion m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Matriculacion.findByCedEst", query = "SELECT m FROM Matriculacion m WHERE m.cedEst = :cedEst")
    , @NamedQuery(name = "Matriculacion.findByApeEst", query = "SELECT m FROM Matriculacion m WHERE m.apeEst = :apeEst")
    , @NamedQuery(name = "Matriculacion.findByNomEst", query = "SELECT m FROM Matriculacion m WHERE m.nomEst = :nomEst")
    , @NamedQuery(name = "Matriculacion.findByA\u00f1oBas", query = "SELECT m FROM Matriculacion m WHERE m.a\u00f1oBas = :a\u00f1oBas")
    , @NamedQuery(name = "Matriculacion.findByCarnet", query = "SELECT m FROM Matriculacion m WHERE m.carnet = :carnet")
    , @NamedQuery(name = "Matriculacion.findByDiscapacidad", query = "SELECT m FROM Matriculacion m WHERE m.discapacidad = :discapacidad")
    , @NamedQuery(name = "Matriculacion.findByPorcentaje", query = "SELECT m FROM Matriculacion m WHERE m.porcentaje = :porcentaje")
    , @NamedQuery(name = "Matriculacion.findByA\u00f1olectivo", query = "SELECT m FROM Matriculacion m WHERE m.a\u00f1olectivo = :a\u00f1olectivo")
    , @NamedQuery(name = "Matriculacion.findByCedRep", query = "SELECT m FROM Matriculacion m WHERE m.cedRep = :cedRep")
    , @NamedQuery(name = "Matriculacion.findByApeRep", query = "SELECT m FROM Matriculacion m WHERE m.apeRep = :apeRep")
    , @NamedQuery(name = "Matriculacion.findByNomRep", query = "SELECT m FROM Matriculacion m WHERE m.nomRep = :nomRep")
    , @NamedQuery(name = "Matriculacion.findByDirRep", query = "SELECT m FROM Matriculacion m WHERE m.dirRep = :dirRep")
    , @NamedQuery(name = "Matriculacion.findByTelCon", query = "SELECT m FROM Matriculacion m WHERE m.telCon = :telCon")
    , @NamedQuery(name = "Matriculacion.findByTelCelular", query = "SELECT m FROM Matriculacion m WHERE m.telCelular = :telCelular")
    , @NamedQuery(name = "Matriculacion.findByCorreo", query = "SELECT m FROM Matriculacion m WHERE m.correo = :correo")
    , @NamedQuery(name = "Matriculacion.findByCodigodeluz", query = "SELECT m FROM Matriculacion m WHERE m.codigodeluz = :codigodeluz")})
public class Matriculacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "n_matricula")
    private Integer nMatricula;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
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
    private String añoBas;
    @Basic(optional = false)
    @Column(name = "carnet")
    private String carnet;
    @Basic(optional = false)
    @Column(name = "discapacidad")
    private String discapacidad;
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private int porcentaje;
    @Column(name = "a\u00f1olectivo")
    private String añolectivo;
    @Basic(optional = false)
    @Column(name = "ced_rep")
    private String cedRep;
    @Basic(optional = false)
    @Column(name = "ape_rep")
    private String apeRep;
    @Basic(optional = false)
    @Column(name = "nom_rep")
    private String nomRep;
    @Basic(optional = false)
    @Column(name = "dir_rep")
    private String dirRep;
    @Basic(optional = false)
    @Column(name = "tel_con")
    private String telCon;
    @Basic(optional = false)
    @Column(name = "tel_celular")
    private String telCelular;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "codigodeluz")
    private String codigodeluz;

    public Matriculacion() {
    }

    public Matriculacion(Integer nMatricula) {
        this.nMatricula = nMatricula;
    }

    public Matriculacion(Integer nMatricula, String fecha, String cedEst, String apeEst, String nomEst, String añoBas, String carnet, String discapacidad, int porcentaje, String cedRep, String apeRep, String nomRep, String dirRep, String telCon, String telCelular, String correo, String codigodeluz) {
        this.nMatricula = nMatricula;
        this.fecha = fecha;
        this.cedEst = cedEst;
        this.apeEst = apeEst;
        this.nomEst = nomEst;
        this.añoBas = añoBas;
        this.carnet = carnet;
        this.discapacidad = discapacidad;
        this.porcentaje = porcentaje;
        this.cedRep = cedRep;
        this.apeRep = apeRep;
        this.nomRep = nomRep;
        this.dirRep = dirRep;
        this.telCon = telCon;
        this.telCelular = telCelular;
        this.correo = correo;
        this.codigodeluz = codigodeluz;
    }

    public Integer getNMatricula() {
        return nMatricula;
    }

    public void setNMatricula(Integer nMatricula) {
        this.nMatricula = nMatricula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getAñoBas() {
        return añoBas;
    }

    public void setAñoBas(String añoBas) {
        this.añoBas = añoBas;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getAñolectivo() {
        return añolectivo;
    }

    public void setAñolectivo(String añolectivo) {
        this.añolectivo = añolectivo;
    }

    public String getCedRep() {
        return cedRep;
    }

    public void setCedRep(String cedRep) {
        this.cedRep = cedRep;
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

    public String getDirRep() {
        return dirRep;
    }

    public void setDirRep(String dirRep) {
        this.dirRep = dirRep;
    }

    public String getTelCon() {
        return telCon;
    }

    public void setTelCon(String telCon) {
        this.telCon = telCon;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigodeluz() {
        return codigodeluz;
    }

    public void setCodigodeluz(String codigodeluz) {
        this.codigodeluz = codigodeluz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nMatricula != null ? nMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriculacion)) {
            return false;
        }
        Matriculacion other = (Matriculacion) object;
        if ((this.nMatricula == null && other.nMatricula != null) || (this.nMatricula != null && !this.nMatricula.equals(other.nMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Matriculacion[ nMatricula=" + nMatricula + " ]";
    }
    
}
