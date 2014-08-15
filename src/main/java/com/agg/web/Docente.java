/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agg.web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Augusto
 */
@Entity
@Table(name = "docente")
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mdocente")
    private Integer idMdocente;
    @Size(max = 50)
    @Column(name = "nombre_docente")
    private String nombreDocente;
    @OneToMany(mappedBy = "idMdocente")
    private Collection<Materia> materiaCollection;

    public Docente() {
    }

    public Docente(Integer idMdocente, String nombreDocente) {
        this.idMdocente = idMdocente;
        this.nombreDocente = nombreDocente;
    }

    public Docente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public Docente(Integer idMdocente) {
        this.idMdocente = idMdocente;
    }

    public Integer getIdMdocente() {
        return idMdocente;
    }

    public void setIdMdocente(Integer idMdocente) {
        this.idMdocente = idMdocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMdocente != null ? idMdocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.idMdocente == null && other.idMdocente != null) || (this.idMdocente != null && !this.idMdocente.equals(other.idMdocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agg.web.Docente[ idMdocente=" + idMdocente + " ]";
    }
    
}
