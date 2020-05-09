/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.response;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferha
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RespWorkerList {

    private List<RespWorker> workerList;
    private RespStatus status;

    public List<RespWorker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<RespWorker> workerList) {
        this.workerList = workerList;
    }

    public RespStatus getStatus() {
        return status;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RespWorkerList{" + "workerList=" + workerList + ", status=" + status + '}';
    }

}
