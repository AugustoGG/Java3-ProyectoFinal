/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agg.web;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Augusto
 */
@Entity
@Table(name = "materia")
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")})
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_materia")
    private Integer idMateria;
    @Size(max = 30)
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.DATE)
    private Date horaInicio;
    @Column(name = "hora_termino")
    @Temporal(TemporalType.DATE)
    private Date horaTermino;
    @JoinColumn(name = "id_mdocente", referencedColumnName = "id_mdocente")
    @ManyToOne
    private Docente idMdocente;
    @JoinColumn(name = "id_salon", referencedColumnName = "id_salon")
    @ManyToOne
    private Salon idSalon;

    public Materia() {
    }

    public Materia(String nombreMateria, Docente idMdocente, Salon idSalon) {
        this.nombreMateria = nombreMateria;
        this.idMdocente = idMdocente;
        this.idSalon = idSalon;
    }

    public Materia(Integer idMateria, String nombreMateria, Docente idMdocente, Salon idSalon) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.idMdocente = idMdocente;
        this.idSalon = idSalon;
    }

    public Materia(Integer idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }


    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
    }

    public Docente getIdMdocente() {
        return idMdocente;
    }

    public void setIdMdocente(Docente idMdocente) {
        this.idMdocente = idMdocente;
    }

    public Salon getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(Salon idSalon) {
        this.idSalon = idSalon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agg.web.Materia[ idMateria=" + idMateria + " ]";
    }
    
}
