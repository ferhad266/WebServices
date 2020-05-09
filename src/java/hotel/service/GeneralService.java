/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.service;

import hote.request.ReqLogin;
import hote.request.ReqLogout;
import hote.request.ReqToken;
import hote.request.ReqWorker;
import hote.request.ReqWorkerId;
import hotel.response.RespLogin;
import hotel.response.RespStatus;
import hotel.response.RespWorker;
import hotel.response.RespWorkerList;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ferha
 */
public interface GeneralService {
    
    RespWorkerList getWorkerList(ReqToken reqToken);
    
    RespWorker getWorkerById(ReqWorkerId reqWorkerId);
    
    RespWorker getWorkerById2(Long workerId);

    RespStatus addWorker(ReqWorker reqWorker);
    
    RespStatus updateWorker(ReqWorker reqWorker);
    
    RespStatus deleteWorker(@PathParam("workerId") Long workerId);
    
    RespLogin login(ReqLogin reqLogin);
    
    RespStatus logout(ReqLogout reqLogout);
}
