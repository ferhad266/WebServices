package hotel.webservice;

import hote.request.ReqLogin;
import hote.request.ReqLogout;
import hote.request.ReqToken;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import hote.request.ReqWorker;
import hote.request.ReqWorkerId;
import hotel.response.RespLogin;
import hotel.response.RespStatus;
import hotel.response.RespWorker;
import hotel.response.RespWorkerList;
import hotel.service.GeneralService;
import hotel.service.GeneralServiceImpl;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author mkuchtiak
 */
@Path("/webservice")
public class WebServices {

    GeneralService generalService = new GeneralServiceImpl();

    @GET
    @Path("/test")
    @Produces("text/html")
    public String test() {
        return "<html><body><h1>Hello Ferhad!</h1></body></html>";
    }

    @GET
    @Path("/getWorkerList")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespWorkerList getWorkerList(ReqToken reqToken) {
        return generalService.getWorkerList(reqToken);
    }

    @POST
    @Path("/getWorkerById")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespWorker getWorkerById(ReqWorkerId reqWorkerId) {
        return generalService.getWorkerById(reqWorkerId);
    }
    
    @GET
    @Path("/getWorkerById2")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespWorker getWorkerById2(@QueryParam(value = "workerId") Long workerId){
        return generalService.getWorkerById2(workerId);
    }
    
    @POST
    @Path("/addWorker")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatus addWorker(ReqWorker reqWorker) {
        return generalService.addWorker(reqWorker);
    }

    @PUT
    @Path("/updateWorker")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatus updateWorker(ReqWorker reqWorker) {
        return generalService.updateWorker(reqWorker);
    }

    @PUT
    @Path("/updateWorker/{workerId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatus deleteWorker(@PathParam("workerId") Long workerId) {
        return generalService.deleteWorker(workerId);
    }

    @POST
    @Path("/loginUser")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespLogin login(ReqLogin reqLogin){
        return generalService.login(reqLogin);
    }
    
    @POST
    @Path("/logout")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatus logout(ReqLogout reqLogout){
        return generalService.logout(reqLogout); 
    }
    
    
}
