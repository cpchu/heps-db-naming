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
@Table(name = "device_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceType.findAll", query = "SELECT d FROM DeviceType d")
    , @NamedQuery(name = "DeviceType.findByDeviceTypeid", query = "SELECT d FROM DeviceType d WHERE d.deviceTypeid = :deviceTypeid")
    , @NamedQuery(name = "DeviceType.findByDeviceType", query = "SELECT d FROM DeviceType d WHERE d.deviceType = :deviceType")
    , @NamedQuery(name = "DeviceType.findByDescription", query = "SELECT d FROM DeviceType d WHERE d.description = :description")})
public class DeviceType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deviceType_id")
    private Integer deviceTypeid;
    @Size(max = 45)
    @Column(name = "device_type")
    private String deviceType;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "deviceType")
    private List<Device> deviceList;

    public DeviceType() {
    }

    public DeviceType(Integer deviceTypeid) {
        this.deviceTypeid = deviceTypeid;
    }

    public Integer getDeviceTypeid() {
        return deviceTypeid;
    }

    public void setDeviceTypeid(Integer deviceTypeid) {
        this.deviceTypeid = deviceTypeid;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceTypeid != null ? deviceTypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceType)) {
            return false;
        }
        DeviceType other = (DeviceType) object;
        if ((this.deviceTypeid == null && other.deviceTypeid != null) || (this.deviceTypeid != null && !this.deviceTypeid.equals(other.deviceTypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.naming.entity.DeviceType[ deviceTypeid=" + deviceTypeid + " ]";
    }
    
}
