/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "signal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Signal.findAll", query = "SELECT s FROM Signal s")
    , @NamedQuery(name = "Signal.findBySignalId", query = "SELECT s FROM Signal s WHERE s.signalId = :signalId")})
public class Signal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "signal_id")
    private Integer signalId;
    @JoinColumn(name = "device", referencedColumnName = "device_id")
    @ManyToOne
    private Device device;
    @JoinColumn(name = "signalType", referencedColumnName = "signalType_id")
    @ManyToOne
    private SignalType signalType;

    public Signal() {
    }

    public Signal(Integer signalId) {
        this.signalId = signalId;
    }

    public Integer getSignalId() {
        return signalId;
    }

    public void setSignalId(Integer signalId) {
        this.signalId = signalId;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public SignalType getSignalType() {
        return signalType;
    }

    public void setSignalType(SignalType signalType) {
        this.signalType = signalType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (signalId != null ? signalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Signal)) {
            return false;
        }
        Signal other = (Signal) object;
        if ((this.signalId == null && other.signalId != null) || (this.signalId != null && !this.signalId.equals(other.signalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.naming.entity.Signal[ signalId=" + signalId + " ]";
    }
    
}
