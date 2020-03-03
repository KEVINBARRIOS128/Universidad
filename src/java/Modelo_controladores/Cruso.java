/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_controladores;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WILDER BARRIOS
 */
@Entity
@Table(name = "cruso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cruso.findAll", query = "SELECT c FROM Cruso c")
    , @NamedQuery(name = "Cruso.findByCodigoCurso", query = "SELECT c FROM Cruso c WHERE c.codigoCurso = :codigoCurso")
    , @NamedQuery(name = "Cruso.findByNombre", query = "SELECT c FROM Cruso c WHERE c.nombre = :nombre")})
public class Cruso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_curso")
    private Integer codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crusoCodigoCurso")
    private Collection<AsignacionCurso> asignacionCursoCollection;

    public Cruso() {
    }

    public Cruso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Cruso(Integer codigoCurso, String nombre) {
        this.codigoCurso = codigoCurso;
        this.nombre = nombre;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<AsignacionCurso> getAsignacionCursoCollection() {
        return asignacionCursoCollection;
    }

    public void setAsignacionCursoCollection(Collection<AsignacionCurso> asignacionCursoCollection) {
        this.asignacionCursoCollection = asignacionCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCurso != null ? codigoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cruso)) {
            return false;
        }
        Cruso other = (Cruso) object;
        if ((this.codigoCurso == null && other.codigoCurso != null) || (this.codigoCurso != null && !this.codigoCurso.equals(other.codigoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_controladores.Cruso[ codigoCurso=" + codigoCurso + " ]";
    }
    
}
