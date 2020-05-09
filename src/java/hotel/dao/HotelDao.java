package hotel.dao;

import hotel.model.Customer;
import hotel.model.Payment;
import hotel.model.Register;
import java.util.List;

import hotel.model.Room;
import hotel.model.Worker;

public interface HotelDao {

    Worker getWorkerById(Long workerId) throws Exception;

    Room getRoomById(Long roomId) throws Exception;

    Payment getPaymentById(Long paymentId) throws Exception;

    Register getRegisterById(Long registerId) throws Exception;

    Customer getCustomerById(Long customerId) throws Exception;

    List<Worker> getWorkerList() throws Exception;

    List<Room> getRoomList() throws Exception;

    List<Payment> getPaymentList() throws Exception;

    List<Register> getRegisterList() throws Exception;

    List<Customer> getCustomerList() throws Exception;

    List<Worker> searchWorkerData(String keyword) throws Exception;

    List<Room> searchRoomData(String keyword) throws Exception;

    List<Register> searchRegisterData(String keyword) throws Exception;

    List<Payment> searchPaymentData(String keyword) throws Exception;

    List<Customer> searchCustomerData(String keyword) throws Exception;

    boolean addWorker(Worker worker) throws Exception;

    boolean addRoom(Room room) throws Exception;

    boolean addPayment(Payment payment) throws Exception;

    boolean addRegister(Register register) throws Exception;

    boolean addCustomer(Customer customer) throws Exception;

    boolean updateWorker(Worker worker, Long workerId) throws Exception;

    boolean updateRoom(Room room, Long roomId) throws Exception;

    boolean updatePayment(Payment payment, Long paymentId) throws Exception;

    boolean updateRegister(Register register, Long registerId) throws Exception;

    boolean UpdateCustomer(Customer customer, Long customerId) throws Exception;

    boolean deleteWorker(Long workerId) throws Exception;

    boolean deleteRoom(Long roomId) throws Exception;

    boolean deletePayment(Long paymentId) throws Exception;

    boolean deleteCustomer(Long customerId) throws Exception;

    boolean deleteRegister(Long registerId) throws Exception;

}
