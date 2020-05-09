/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.response;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferha
 */
@XmlRootElement(name = "Worker")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespWorker {

    private Long id;
    @XmlElement(name = "ad")
    private String name;
    @XmlElement(name = "soyad")
    private String surname;
//    @XmlElement(name = "Dogum Tarixi")
    private String dob;
//    @XmlElement(name = "Ata adi")
    private String fatherName;
    private RespStatus status;

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public RespStatus getStatus() {
        return status;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RespWorker{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", fatherName=" + fatherName + '}';
    }

}
