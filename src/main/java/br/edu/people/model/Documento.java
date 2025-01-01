package br.edu.people.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int nrDocumento;
    private String tpDocumento;
    @ManyToOne
    private Pessoa pessoa_id;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public int getNrDocumento() {
        return nrDocumento;
    }
    public void setNrDocumento(int nrDocumento) {
        this.nrDocumento = nrDocumento;
    }
    public String getTpDocumento() {
        return tpDocumento;
    }
    public void setTpDocumento(String tpDocumento) {
        this.tpDocumento = tpDocumento;
    }
    public Pessoa getPessoa_id() {
        return pessoa_id;
    }
    public void setPessoa_id(Pessoa pessoa_id) {
        this.pessoa_id = pessoa_id;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Documento other = (Documento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Documento [id=" + id + "]";
    }    

    
}
