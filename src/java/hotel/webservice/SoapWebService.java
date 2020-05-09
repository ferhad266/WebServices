/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.webservice;

import hote.request.ReqLogin;
import hote.request.ReqLogout;
import hote.request.ReqToken;
import hote.request.ReqWorker;
import hote.request.ReqWorkerId;
import hotel.response.RespLogin;
import hotel.response.RespStatus;
import hotel.response.RespWorker;
import hotel.response.RespWorkerList;
import hotel.service.GeneralService;
import hotel.service.GeneralServiceImpl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ferha
 */
@WebService(serviceName = "SoapWebService")
public class SoapWebService {

    GeneralService generalService = new GeneralServiceImpl();

    @WebMethod(operationName = "test")
    public String test(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "getWorkerList")
    public RespWorkerList getWorkerList(ReqToken reqToken) {
        return generalService.getWorkerList(reqToken);
    }

    @WebMethod(operationName = "getWorkerById")
    public RespWorker getWorkerById(@WebParam(name = "workerId") ReqWorkerId reqWorkerId) {
        return generalService.getWorkerById(reqWorkerId);
    }

    @WebMethod(operationName = "addWorker")
    public RespStatus addWorker(@WebParam(name = "reqWorker") ReqWorker reqWorker) {
        return generalService.addWorker(reqWorker);
    }

    @WebMethod(operationName = "updateWorker")
    public RespStatus updateWorker(@WebParam(name = "reqWorker") ReqWorker reqWorker) {
        return generalService.updateWorker(reqWorker);
    }

    @WebMethod(operationName = "deleteWorker")
    public RespStatus deleteWorker(@WebParam(name = "workerId") Long workerId) {
        return generalService.deleteWorker(workerId);
    }

    @WebMethod(operationName = "loginUser")
    public RespLogin login(@WebParam(name = "reqLogin") ReqLogin reqLogin) {
        return generalService.login(reqLogin);
    }

    @WebMethod(operationName = "logout")
    public RespStatus logout(@WebParam(name = "reqLogin") ReqLogout reqLogout) {
        return generalService.logout(reqLogout);
    }
}
