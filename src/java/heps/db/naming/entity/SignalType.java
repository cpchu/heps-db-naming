/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "signal_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SignalType.findAll", query = "SELECT s FROM SignalType s")
    , @NamedQuery(name = "SignalType.findBySignalTypeid", query = "SELECT s FROM SignalType s WHERE s.signalTypeid = :signalTypeid")
    , @NamedQuery(name = "SignalType.findBySignalType", query = "SELECT s FROM SignalType s WHERE s.signalType = :signalType")
    , @NamedQuery(name = "SignalType.findByDescription", query = "SELECT s FROM SignalType s WHERE s.description = :description")})
public class SignalType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "signalType_id")
    private Integer signalTypeid;
    @Size(max = 45)
    @Column(name = "signal_type")
    private String signalType;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "signalType")
    private List<Signal> signalList;

    public SignalType() {
    }

    public SignalType(Integer signalTypeid) {
        this.signalTypeid = signalTypeid;
    }

    public Integer getSignalTypeid() {
        return signalTypeid;
    }

    public void setSignalTypeid(Integer signalTypeid) {
        this.signalTypeid = signalTypeid;
    }

    public String getSignalType() {
        return signalType;
    }

    public void setSignalType(String signalType) {
        this.signalType = signalType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Signal> getSignalList() {
        return signalList;
    }

    public void setSignalList(List<Signal> signalList) {
        this.signalList = signalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (signalTypeid != null ? signalTypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SignalType)) {
            return false;
        }
        SignalType other = (SignalType) object;
        if ((this.signalTypeid == null && other.signalTypeid != null) || (this.signalTypeid != null && !this.signalTypeid.equals(other.signalTypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.naming.entity.SignalType[ signalTypeid=" + signalTypeid + " ]";
    }
    
}
