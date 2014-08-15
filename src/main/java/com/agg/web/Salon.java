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
@Table(name = "salon")
@NamedQueries({
    @NamedQuery(name = "Salon.findAll", query = "SELECT s FROM Salon s")})
public class Salon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salon")
    private Integer idSalon;
    @Size(max = 1)
    @Column(name = "edificio")
    private String edificio;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "numero")
    private Integer numero;
    @OneToMany(mappedBy = "idSalon")
    private Collection<Materia> materiaCollection;

    public Salon(Integer idSalon, String edificio) {
        this.idSalon = idSalon;
        this.edificio = edificio;
    }
    
    

    public Salon() {
    }

    public Salon(String edificio, Integer nivel, Integer numero) {
        this.edificio = edificio;
        this.nivel = nivel;
        this.numero = numero;
    }

    public Salon(Integer idSalon, String edificio, Integer nivel, Integer numero) {
        this.idSalon = idSalon;
        this.edificio = edificio;
        this.nivel = nivel;
        this.numero = numero;
    }

    public Salon(Integer idSalon) {
        this.idSalon = idSalon;
    }

    public Integer getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(Integer idSalon) {
        this.idSalon = idSalon;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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
        hash += (idSalon != null ? idSalon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salon)) {
            return false;
        }
        Salon other = (Salon) object;
        if ((this.idSalon == null && other.idSalon != null) || (this.idSalon != null && !this.idSalon.equals(other.idSalon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agg.web.Salon[ idSalon=" + idSalon + " ]";
    }
    
}
