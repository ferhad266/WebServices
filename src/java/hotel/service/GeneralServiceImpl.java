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
import hotel.business.HotelBusiness;
import hotel.business.HotelBusinessImpl;
import hotel.business.LoginBusinessImpl;
import hotel.dao.HotelDao;
import hotel.dao.HotelDaoImpl;
import hotel.dao.LoginDao;
import hotel.dao.LoginDaoImpl;
import hotel.model.Worker;
import hotel.response.ExceptionConstants;
import hotel.response.RespLogin;
import hotel.response.RespStatus;
import hotel.response.RespWorker;
import hotel.response.RespWorkerList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import hotel.business.LoginBusiness;
import hotel.model.LoginUser;
import java.util.UUID;
import org.apache.log4j.Logger;

/**
 *
 * @author ferha
 */
public class GeneralServiceImpl implements GeneralService {

    HotelDao hotelDao = new HotelDaoImpl();
    HotelBusiness hotelService = new HotelBusinessImpl(hotelDao);
    LoginDao loginDao = new LoginDaoImpl();
    LoginBusiness loginBusiness = new LoginBusinessImpl(loginDao);
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Logger LOGGER = Logger.getLogger(GeneralServiceImpl.class);

    public RespWorkerList getWorkerList(ReqToken reqToken) {
        RespWorkerList response = new RespWorkerList();
        String token = reqToken.getToken();
        LOGGER.info("Get Worker List request: token:" + token);
        List<RespWorker> respWorkerList = new ArrayList<RespWorker>();
        try {
            if (token == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data"));
                LOGGER.warn("Get Worker List request: token:" + token + " Token invalid request data");
                return response;
            }
            LoginUser userToken = loginBusiness.checkToken(token);
            if (userToken == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_TOKEN, "Invalid Token"));
                LOGGER.warn("Get Worker List request: token:" + token + " Invalid Token");
                return response;
            }
            List<Worker> workerList = hotelService.getWorkerList();
            for (Worker worker : workerList) {
                RespWorker respWorker = new RespWorker();
                respWorker.setId(worker.getId());
                respWorker.setName(worker.getName());
                respWorker.setSurname(worker.getSurname());
                respWorker.setFatherName(worker.getFatherName());
                respWorker.setDob(df.format(worker.getDob()));
                respWorkerList.add(respWorker);
            }
            response.setWorkerList(respWorkerList);
            response.setStatus(RespStatus.getSuccessMessage());
            LOGGER.info("Get Worker List response: token:" + token + " is Success");
        } catch (Exception e) {
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
            LOGGER.error("Get Worker List response: token:" + token + " ",e);
        }
        return response;
    }

    public RespWorker getWorkerById(ReqWorkerId reqWorkerId) {
        RespWorker response = new RespWorker();
        try {
            Long workerId = reqWorkerId.getWorkerId();
            String token = reqWorkerId.getToken();
            if (token == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data"));
                return response;
            }
            LoginUser userToken = loginBusiness.checkToken(token);
            if (userToken == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_TOKEN, "Invalid Token"));
                return response;
            }
            if (workerId == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data!"));
                return response;
            }
            Worker worker = hotelService.getWorkerById(workerId);
            if (worker == null) {
                response.setStatus(new RespStatus(ExceptionConstants.WORKER_NOT_FOUND, "Worker not found!"));
                return response;
            }
            response.setId(worker.getId());
            response.setName(worker.getName());
            response.setSurname(worker.getSurname());
            response.setFatherName(worker.getFatherName());
            response.setDob(df.format(worker.getDob()));
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception ex) {
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
            ex.printStackTrace();
        }
        return response;
    }

    public RespStatus addWorker(ReqWorker reqWorker) {
        RespStatus response = null;
        try {
            String name = reqWorker.getName();
            String surname = reqWorker.getSurname();
            String fatherName = reqWorker.getFatherName();
            Date dob = reqWorker.getDob();
            String phone = reqWorker.getPhone();
            String email = reqWorker.getEmail();
            String token = reqWorker.getToken();
            if (token == null || name == null || surname == null || dob == null) {
                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data!");
                return response;
            }
            LoginUser userToken = loginBusiness.checkToken(token);
            if (userToken == null) {
                response = new RespStatus(ExceptionConstants.INVALID_TOKEN, "Invalid Token");
                return response;
            }
            Worker worker = new Worker();
            worker.setName(name);
            worker.setSurname(surname);
            worker.setFatherName(fatherName);
            worker.setDob(dob);
            worker.setPhone(phone);
            worker.setEmail(email);
            boolean isAdded = hotelService.addWorker(worker);
            if (!isAdded) {
                response = new RespStatus(ExceptionConstants.ADD_WORKER_IS_FAIL, "Add worker is fail!");
            }
            response = RespStatus.getSuccessMessage();

        } catch (Exception ex) {
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception");
            ex.printStackTrace();
        }
        return response;
    }

    public RespStatus updateWorker(ReqWorker reqWorker) {
        RespStatus response = null;
        try {
            Long workerId = reqWorker.getWorkerId();
            String name = reqWorker.getName();
            String surname = reqWorker.getSurname();
            String fatherName = reqWorker.getFatherName();
            Date dob = reqWorker.getDob();
            String phone = reqWorker.getPhone();
            String email = reqWorker.getEmail();

            if (workerId == null || name == null || surname == null || dob == null) {
                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data!");
                return response;
            }
            Worker worker = new Worker();
            worker.setName(name);
            worker.setSurname(surname);
            worker.setFatherName(fatherName);
            worker.setDob(dob);
            worker.setPhone(phone);
            worker.setEmail(email);
            boolean isUpdate = hotelService.updateWorker(worker, workerId);
            if (!isUpdate) {
                response = new RespStatus(ExceptionConstants.UPDATE_WORKER_IS_FAIL, "Update worker is fail!");
            }
            response = RespStatus.getSuccessMessage();

        } catch (Exception ex) {
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception");
            ex.printStackTrace();
        }
        return response;
    }

    public RespStatus deleteWorker(Long workerId) {
        RespStatus response = null;
        try {
            if (workerId == null) {
                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data!");
                return response;
            }

            boolean isDelete = hotelService.deleteWorker(workerId);
            if (!isDelete) {
                response = new RespStatus(ExceptionConstants.DELETE_WORKER_IS_FAIL, "Delete worker is fail!");
            }
            response = RespStatus.getSuccessMessage();

        } catch (Exception ex) {
            response = new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception");
            ex.printStackTrace();
        }
        return response;
    }

    public RespLogin login(ReqLogin reqLogin) {
        RespLogin response = new RespLogin();
        String username = reqLogin.getUsername();
        String password = reqLogin.getPassword();
        try {
            if (username == null || password == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data!"));
                return response;
            }
            LoginUser loginUser = loginBusiness.login(username, password);
            if (loginUser == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_USERNAME_OR_PASSWORD, "Invalid username or password!"));
                return response;
            }
            if (loginUser.getToken() != null) {
                response.setStatus(new RespStatus(ExceptionConstants.SESSION_IS_ALREADY_EXIST, "Session is already exist!"));
                return response;
            }
            String token = UUID.randomUUID().toString();
            boolean isUpdateToken = loginBusiness.updateTokenById(token, loginUser.getId());
            if (!isUpdateToken) {
                response.setStatus(new RespStatus(ExceptionConstants.CREATE_TOKEN_IS_FAIL, "Create token is fail!"));
                return response;
            }
            response.setFullname(loginUser.getFullname());
            response.setToken(token);
            response.setLoginDate(loginUser.getDataDate());
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception ex) {
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
            ex.printStackTrace();
        }
        return response;
    }

    public RespStatus logout(ReqLogout reqLogout) {
        RespStatus response = null;
        try {
            String token = reqLogout.getToken();
            if (token == null) {
                response = new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
                return response;
            }
            LoginUser userToken = loginBusiness.checkToken(token);
            if (userToken == null) {
                response = new RespStatus(ExceptionConstants.INVALID_TOKEN, "Invalid Token");
                return response;
            }
            boolean isUpdate = loginBusiness.updateTokenById(null, userToken.getId());
            if (!isUpdate) {
                response = new RespStatus(ExceptionConstants.LOGOUT_IS_FAIL, "Logout is fail!");
                return response;
            }
            response = RespStatus.getSuccessMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public RespWorker getWorkerById2(Long workerId) {
        RespWorker response = new RespWorker();
        try {
            if (workerId == null) {
                response.setStatus(new RespStatus(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data!"));
                return response;
            }
            Worker worker = hotelService.getWorkerById(workerId);
            if (worker == null) {
                response.setStatus(new RespStatus(ExceptionConstants.WORKER_NOT_FOUND, "Worker not found!"));
                return response;
            }
            response.setId(worker.getId());
            response.setName(worker.getName());
            response.setSurname(worker.getSurname());
            response.setFatherName(worker.getFatherName());
            response.setDob(df.format(worker.getDob()));
            response.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception ex) {
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
            ex.printStackTrace();
        }
        return response;
    }

}
