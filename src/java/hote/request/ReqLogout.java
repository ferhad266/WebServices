/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hote.request;

import hotel.response.RespStatus;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferha
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqLogout {

    private String token;
    private RespStatus status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RespStatus getStatus() {
        return status;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReqLogout{" + "token=" + token + ", status=" + status + '}';
    }

}
