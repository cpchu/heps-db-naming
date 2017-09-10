/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.naming.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Paul
 */
@Entity
@Table(name = "device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")
    , @NamedQuery(name = "Device.findByDeviceId", query = "SELECT d FROM Device d WHERE d.deviceId = :deviceId")
    , @NamedQuery(name = "Device.findByQualifier", query = "SELECT d FROM Device d WHERE d.qualifier = :qualifier")
    , @NamedQuery(name = "Device.findByInstance", query = "SELECT d FROM Device d WHERE d.instance = :instance")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "device_id")
    private Integer deviceId;
    @Size(max = 45)
    @Column(name = "qualifier")
    private String qualifier;
    @Size(max = 45)
    @Column(name = "instance")
    private String instance;
    @JoinColumn(name = "system", referencedColumnName = "system_id")
    @ManyToOne(optional = false)
    private System system;
    @JoinColumn(name = "subsystem", referencedColumnName = "subsystem_id")
    @ManyToOne
    private Subsystem subsystem;
    @JoinColumn(name = "device_type", referencedColumnName = "deviceType_id")
    @ManyToOne
    private DeviceType deviceType;
    @OneToMany(mappedBy = "device")
    private Collection<Signal> signalCollection;

    public Device() {
    }

    public Device(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Subsystem getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(Subsystem subsystem) {
        this.subsystem = subsystem;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @XmlTransient
    public Collection<Signal> getSignalCollection() {
        return signalCollection;
    }

    public void setSignalCollection(Collection<Signal> signalCollection) {
        this.signalCollection = signalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceId != null ? deviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.deviceId == null && other.deviceId != null) || (this.deviceId != null && !this.deviceId.equals(other.deviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.naming.entity.Device[ deviceId=" + deviceId + " ]";
    }
    
}
