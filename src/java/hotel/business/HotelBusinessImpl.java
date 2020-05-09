package hotel.business;

import java.util.List;

import hotel.dao.HotelDao;
import hotel.model.Customer;
import hotel.model.Payment;
import hotel.model.Register;
import hotel.model.Room;
import hotel.model.Worker;

public class HotelBusinessImpl implements HotelBusiness {

    private HotelDao hotelDao;

    public HotelBusinessImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public List<Worker> getWorkerList() throws Exception {
        return hotelDao.getWorkerList();
    }

    @Override
    public List<Room> getRoomList() throws Exception {
        return hotelDao.getRoomList();
    }

    @Override
    public boolean addRoom(Room room) throws Exception {
        return hotelDao.addRoom(room);
    }

    @Override
    public boolean addWorker(Worker worker) throws Exception {
        return hotelDao.addWorker(worker);
    }

    @Override
    public Worker getWorkerById(Long workerId) throws Exception {
        return hotelDao.getWorkerById(workerId);
    }

    @Override
    public Room getRoomById(Long roomId) throws Exception {
        return hotelDao.getRoomById(roomId);
    }

    @Override
    public boolean updateWorker(Worker worker, Long workerId) throws Exception {
        return hotelDao.updateWorker(worker, workerId);
    }

    @Override
    public boolean deleteWorker(Long workerId) throws Exception {
        return hotelDao.deleteWorker(workerId);
    }

    @Override
    public List<Worker> searchWorkerData(String keyword) throws Exception {
        return hotelDao.searchWorkerData(keyword);
    }

    @Override
    public boolean updateRoom(Room room, Long roomId) throws Exception {
        return hotelDao.updateRoom(room, roomId);
    }

    @Override
    public boolean deleteRoom(Long roomId) throws Exception {
        return hotelDao.deleteRoom(roomId);
    }

    @Override
    public List<Room> searchRoomData(String keyword) throws Exception {
        return hotelDao.searchRoomData(keyword);
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        return hotelDao.getPaymentList();
    }

    @Override
    public List<Register> getRegisterList() throws Exception {
        return hotelDao.getRegisterList();
    }

    @Override
    public List<Customer> getCustomerList() throws Exception {
        return hotelDao.getCustomerList();
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        return hotelDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) throws Exception {
        return hotelDao.getPaymentById(paymentId);
    }

    @Override
    public boolean updatePayment(Payment payment, Long paymentId) throws Exception {
        return hotelDao.updatePayment(payment, paymentId);
    }

    @Override
    public boolean addRegister(Register register) throws Exception {
        return hotelDao.addRegister(register);
    }

    @Override
    public Register getRegisterById(Long registerId) throws Exception {
        return hotelDao.getRegisterById(registerId);
    }

    @Override
    public boolean updateRegister(Register register, Long registerId) throws Exception {
        return hotelDao.updateRegister(register, registerId);
    }

    @Override
    public boolean deletePayment(Long paymentId) throws Exception {
        return hotelDao.deletePayment(paymentId);
    }

    @Override
    public boolean deleteCustomer(Long customerId) throws Exception {
        return hotelDao.deleteCustomer(customerId);
    }

    @Override
    public boolean deleteRegister(Long registerId) throws Exception {
        return hotelDao.deleteRegister(registerId);
    }

    @Override
    public boolean addCustomer(Customer customer) throws Exception {
        return hotelDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) throws Exception {
        return hotelDao.getCustomerById(customerId);
    }

    @Override
    public boolean UpdateCustomer(Customer customer, Long customerId) throws Exception {
        return hotelDao.UpdateCustomer(customer, customerId);
    }

    @Override
    public List<Register> searchRegisterData(String keyword) throws Exception {
        return hotelDao.searchRegisterData(keyword);
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        return hotelDao.searchPaymentData(keyword);
    }

    @Override
    public List<Customer> searchCustomerData(String keyword) throws Exception {
        return hotelDao.searchCustomerData(keyword);
    }

}
