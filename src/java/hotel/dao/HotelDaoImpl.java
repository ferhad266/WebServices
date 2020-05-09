package hotel.dao;

import hotel.model.Customer;
import hotel.model.Payment;
import hotel.model.Register;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hotel.model.Room;
import hotel.model.Worker;
import hotel.util.JdbcUtility;
import java.sql.Date;
import org.apache.log4j.Logger;

public class HotelDaoImpl implements HotelDao {
    Logger LOGGER = Logger.getLogger(HotelDaoImpl.class);

//    UPDATE
    @Override
    public boolean updateWorker(Worker worker, Long workerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE WORKER SET NAME=?,SURNAME=?,DOB=?,FATHER_NAME=?,PHONE=?,EMAIL=?" + " WHERE id_worker = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, worker.getName());
                ps.setString(2, worker.getSurname());
                ps.setDate(3, (Date) worker.getDob());
                ps.setString(4, worker.getFatherName());
                ps.setString(5, worker.getPhone());
                ps.setString(6, worker.getEmail());
                ps.setLong(7, workerId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean updateRoom(Room room, Long roomId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE ROOM SET ROOM_NUMBER=?,ROOM_SITUATION=?,PRICE=?,HUMAN_COUNT=?,ROOM_TYPE=?" + " WHERE ID=?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, room.getRoomNumber());
                ps.setString(2, room.getRoomSituation());
                ps.setFloat(3, room.getPrice());
                ps.setInt(4, room.getHumanCount());
                ps.setString(5, room.getRoomType());
                ps.setLong(6, roomId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean updatePayment(Payment payment, Long paymentId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PAYMENT SET AMOUNT=?,REG_ID=?,ROOM_ID=?,WORKER_ID=?" + " WHERE ID = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setFloat(1, payment.getAmount());
                ps.setLong(2, payment.getRegister().getId());
                ps.setLong(3, payment.getRoom().getId());
                ps.setLong(4, payment.getWorker().getId());
                ps.setLong(5, paymentId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean updateRegister(Register register, Long registerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = " UPDATE REGISTER SET NAME=?,SURNAME=?,DOB=?,FATHER_NAME=?,ADULT_COUNT=?,CHILD_COUNT=?,PHONE=?,EMAIL=?,CHECK_IN=?,CHECK_OUT=?,WORKER_ID=? "
                + " WHERE ID =?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, register.getName());
                ps.setString(2, register.getSurname());
                ps.setDate(3, (Date) register.getDob());
                ps.setString(4, register.getFatherName());
                ps.setString(5, register.getAdultCount());
                ps.setString(6, register.getChildCount());
                ps.setString(7, register.getPhone());
                ps.setString(8, register.getEmail());
                ps.setDate(9, (Date) register.getCheck_in());
                ps.setDate(10, (Date) register.getCheck_out());
                ps.setLong(11, register.getWorker().getId());
                ps.setLong(12, registerId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean UpdateCustomer(Customer customer, Long customerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE CUSTOMER SET NAME=?,SURNAME=?,PHONE=?,CHECK_IN=?,CHECK_OUT=?,WORKER_ID=?,ROOM_ID=?" + " WHERE ID = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getSurname());
                ps.setString(3, customer.getPhone());
                ps.setDate(4, (Date) customer.getCheck_in());
                ps.setDate(5, (Date) customer.getCheck_out());
                ps.setLong(6, customer.getWorker().getId());
                ps.setLong(7, customer.getRoom().getId());
                ps.setLong(9, customerId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;

    }

//    DELETE
    @Override
    public boolean deleteRoom(Long roomId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE ROOM SET ACTIVE = 0" + " WHERE ID = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, roomId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deleteWorker(Long workerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE WORKER SET ACTIVE = 0" + " WHERE id_worker = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, workerId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deletePayment(Long paymentId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PAYMENT SET ACTIVE = 0" + " WHERE ID = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, paymentId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deleteCustomer(Long customerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE CUSTOMER SET ACTIVE = 0" + " WHERE ID = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, customerId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deleteRegister(Long registerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE REGISTER SET ACTIVE = 0" + " WHERE ID = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, registerId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

//    ByIdList
    @Override
    public Customer getCustomerById(Long customerId) throws Exception {
        Customer customer = new Customer();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       C.ID,\n"
                + "       C.NAME,\n"
                + "       C.SURNAME,\n"
                + "       C.PHONE,\n"
                + "       C.CHECK_IN,\n"
                + "       C.CHECK_OUT,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       R.ID ROOM_ID,\n"
                + "       R.ROOM_NUMBER,\n"
                + "       R.ROOM_TYPE\n"
                + "  FROM CUSTOMER C\n"
                + "       INNER JOIN WORKER W\n"
                + "          ON C.WORKER_ID = W.ID\n"
                + "       INNER JOIN ROOM R\n"
                + "          ON C.ROOM_ID = R.ID\n"
                + " WHERE C.ACTIVE = 1 AND C.ID=?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, customerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    customer.setR(rs.getLong("r"));
                    customer.setId(rs.getLong("ID"));
                    customer.setName(rs.getString("NAME"));
                    customer.setSurname(rs.getString("SURNAME"));
                    customer.setPhone(rs.getString("PHONE"));
                    customer.setCheck_in(rs.getDate("CHECK_IN"));
                    customer.setCheck_out(rs.getDate("CHECK_OUT"));
                    Worker worker = new Worker();
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    Room room = new Room();
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    room.setRoomType(rs.getString("ROOM_TYPE"));
                    customer.setWorker(worker);
                    customer.setRoom(room);
                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return customer;
    }

    @Override
    public Register getRegisterById(Long registerId) throws Exception {
        Register register = new Register();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       R.ID,\n"
                + "       R.NAME,\n"
                + "       R.SURNAME,\n"
                + "       R.DOB,\n"
                + "       R.FATHER_NAME,\n"
                + "       R.ADULT_COUNT,\n"
                + "       R.CHILD_COUNT,\n"
                + "       R.PHONE,\n"
                + "       R.EMAIL,\n"
                + "       R.CHECK_IN,\n"
                + "       R.CHECK_OUT,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       RM.ID ROOM_ID,\n"
                + "       RM.ROOM_NUMBER,\n"
                + "       RM.ROOM_TYPE\n"
                + "  FROM REGISTER R \n"
                + "  INNER JOIN WORKER W \n"
                + "  ON R.WORKER_ID = W.ID\n"
                + "  INNER JOIN ROOM RM\n"
                + "  ON R.ROOM_ID = RM.ID\n"
                + " WHERE R.ACTIVE = 1 AND R.ID=? ";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, registerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    register.setR(rs.getLong("r"));
                    register.setId(rs.getLong("ID"));
                    register.setName(rs.getString("NAME"));
                    register.setSurname(rs.getString("SURNAME"));
                    register.setDob(rs.getDate("DOB"));
                    register.setFatherName(rs.getString("FATHER_NAME"));
                    register.setAdultCount(rs.getString("ADULT_COUNT"));
                    register.setChildCount(rs.getString("CHILD_COUNT"));
                    register.setPhone(rs.getString("PHONE"));
                    register.setEmail(rs.getString("EMAIL"));
                    register.setCheck_in(rs.getDate("CHECK_IN"));
                    register.setCheck_out(rs.getDate("CHECK_OUT"));
                    Worker worker = new Worker();
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    Room room = new Room();
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    room.setRoomType(rs.getString("ROOM_TYPE"));
                    register.setWorker(worker);
                    register.setRoom(room);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return register;
    }

    @Override
    public Worker getWorkerById(Long workerId) throws Exception {
        Worker worker = new Worker();
        List<Worker> workerList = new ArrayList<Worker>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id_worker,NAME,SURNAME,DOB,FATHER_NAME,PHONE,EMAIL FROM WORKER\r\n"
                + " WHERE ACTIVE = 1 AND id_worker = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, workerId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    worker.setId(rs.getLong("id_worker"));
                    worker.setName(rs.getString("NAME"));
                    worker.setSurname(rs.getString("SURNAME"));
                    worker.setDob(rs.getDate("DOB"));
                    worker.setFatherName(rs.getString("FATHER_NAME"));
                    worker.setPhone(rs.getString("PHONE"));
                    worker.setEmail(rs.getString("EMAIL"));
                } else {
                    worker = null;
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return worker;
    }

    @Override
    public Room getRoomById(Long roomId) throws Exception {
        Room room = new Room();
        List<Room> roomList = new ArrayList<Room>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,ROOM_NUMBER,ROOM_SITUATION,PRICE,HUMAN_COUNT,ROOM_TYPE FROM ROOM\r\n"
                + " WHERE ACTIVE = 1 AND ID = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, roomId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    room.setR(rs.getLong("r"));
                    room.setId(rs.getLong("ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    room.setRoomSituation(rs.getString("ROOM_SITUATION"));
                    room.setPrice(rs.getFloat("PRICE"));
                    room.setHumanCount(rs.getInt("HUMAN_COUNT"));
                    room.setRoomType(rs.getString("ROOM_TYPE"));
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }

        return room;
    }

    @Override
    public Payment getPaymentById(Long paymentId) throws Exception {
        Payment payment = new Payment();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,P.ID,\n"
                + "       R.ID REGISTER_ID,\n"
                + "       R.NAME REGISTER_NAME,\n"
                + "       R.SURNAME REGISTER_SURNAME,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       RM.ID ROOM_ID,\n"
                + "       RM.ROOM_NUMBER,\n"
                + "       P.AMOUNT,\n"
                + "       P.PAY_DATE\n"
                + "  FROM PAYMENT P\n"
                + "       INNER JOIN REGISTER R\n"
                + "          ON P.REG_ID = R.ID\n"
                + "       INNER JOIN WORKER W\n"
                + "          ON P.WORKER_ID = W.ID\n"
                + "       INNER JOIN ROOM RM\n"
                + "          ON P.ROOM_ID = RM.ID\n"
                + " WHERE P.ACTIVE = 1 AND P.ID=?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, paymentId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    payment.setId(rs.getLong("ID"));
                    Worker worker = new Worker();
                    Register register = new Register();
                    Room room = new Room();
                    payment.setR(rs.getLong("r"));
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    payment.setWorker(worker);
                    register.setId(rs.getLong("REGISTER_ID"));
                    register.setName(rs.getString("REGISTER_NAME"));
                    register.setSurname(rs.getString("REGISTER_SURNAME"));
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    payment.setWorker(worker);
                    payment.setRoom(room);
                    payment.setRegister(register);
                    payment.setAmount(rs.getFloat("AMOUNT"));
                    payment.setPayDate(rs.getDate("PAY_DATE"));
                }
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return payment;
    }

//    SEARCH
    @Override
    public List<Customer> searchCustomerData(String keyword) throws Exception {
        List<Customer> customerList = new ArrayList<Customer>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       C.ID,\n"
                + "       C.NAME,\n"
                + "       C.SURNAME,\n"
                + "       C.PHONE,\n"
                + "       C.CHECK_IN,\n"
                + "       C.CHECK_OUT,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       R.ID ROOM_ID,\n"
                + "       R.ROOM_NUMBER,\n"
                + "       R.ROOM_TYPE\n"
                + "  FROM CUSTOMER C\n"
                + "       INNER JOIN WORKER W\n"
                + "          ON C.WORKER_ID = W.ID\n"
                + "       INNER JOIN ROOM R\n"
                + "          ON C.ROOM_ID = R.ID\n"
                + " WHERE C.ACTIVE = 1 AND W.ACTIVE = 1 AND R.ACTIVE = 1 AND LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?) OR LOWER(PHONE) LIKE LOWER(?) OR"
                + " LOWER(WORKER_NAME) LIKE LOWER(?) OR LOWER(WORKER_SURNAME) LIKE LOWER(?) OR LOWER(ROOM_NUMBER) LIKE LOWER(?) OR LOWER(ROOM_TYPE) LIKE LOWER(?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                ps.setString(7, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setR(rs.getLong("r"));
                    customer.setName(rs.getString("NAME"));
                    customer.setSurname(rs.getString("SURNAME"));
                    customer.setPhone(rs.getString("PHONE"));
                    customer.setCheck_in(rs.getDate("CHECK_IN"));
                    customer.setCheck_out(rs.getDate("CHECK_OUT"));
                    Worker worker = new Worker();
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    Room room = new Room();
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    room.setRoomType(rs.getString("ROOM_TYPE"));
                    customer.setWorker(worker);
                    customer.setRoom(room);
                    customerList.add(customer);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return customerList;
    }

    @Override
    public List<Worker> searchWorkerData(String keyword) throws Exception {
        List<Worker> workerList = new ArrayList<Worker>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,NAME,SURNAME,DOB,FATHER_NAME,PHONE,EMAIL FROM WORKER W WHERE W.ACTIVE = 1\r\n"
                + " AND LOWER(W.NAME) LIKE LOWER(?) OR LOWER(W.SURNAME) LIKE LOWER(?) OR LOWER(W.FATHER_NAME) LIKE LOWER(?) OR LOWER(W.PHONE) LIKE LOWER(?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Worker worker = new Worker();
                    worker.setR(rs.getLong("r"));
                    worker.setId(rs.getLong("ID"));
                    worker.setName(rs.getString("NAME"));
                    worker.setSurname(rs.getString("SURNAME"));
                    worker.setDob(rs.getDate("DOB"));
                    worker.setFatherName(rs.getString("FATHER_NAME"));
                    worker.setPhone(rs.getString("PHONE"));
                    worker.setEmail(rs.getString("EMAIL"));
                    workerList.add(worker);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return workerList;
    }

    @Override
    public List<Register> searchRegisterData(String keyword) throws Exception {
        List<Register> registerList = new ArrayList<Register>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       R.ID,\n"
                + "       R.NAME,\n"
                + "       R.SURNAME,\n"
                + "       R.DOB,\n"
                + "       R.FATHER_NAME,\n"
                + "       R.ADULT_COUNT,\n"
                + "       R.CHILD_COUNT,\n"
                + "       R.PHONE,\n"
                + "       R.EMAIL,\n"
                + "       R.CHECK_IN,\n"
                + "       R.CHECK_OUT,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       RM.ID ROOM_ID,\n"
                + "       RM.ROOM_NUMBER,\n"
                + "       RM.ROOM_TYPE\n"
                + "  FROM REGISTER R \n"
                + "  INNER JOIN WORKER W \n"
                + "  ON R.WORKER_ID = W.ID\n"
                + "  INNER JOIN ROOM RM\n"
                + "  ON R.ROOM_ID = RM.ID\n"
                + " WHERE R.ACTIVE = 1 AND W.ACTIVE = 1 AND RM.ACTIVE = 1 AND LOWER(NAME) LIKE LOWER(?)"
                + " OR LOWER(SURNAME) LIKE LOWER(?) OR LOWER(DOB) LIKE LOWER(?) OR"
                + " LOWER(FATHER_NAME) LIKE LOWER(?) OR LOWER(WORKER_NAME) LIKE LOWER(?) OR LOWER(WORKER_SURNAME) LIKE LOWER(?) OR LOWER(ROOM_NUMBER) LIKE LOWER(?) OR LOWER(ROOM_TYPE) LIKE LOWER(?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                ps.setString(7, "%" + keyword + "%");
                ps.setString(8, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Register register = new Register();
                    register.setR(rs.getLong("r"));
                    register.setId(rs.getLong("ID"));
                    register.setName(rs.getString("NAME"));
                    register.setSurname(rs.getString("SURNAME"));
                    register.setDob(rs.getDate("DOB"));
                    register.setFatherName(rs.getString("FATHER_NAME"));
                    register.setAdultCount(rs.getString("ADULT_COUNT"));
                    register.setChildCount(rs.getString("CHILD_COUNT"));
                    register.setPhone(rs.getString("PHONE"));
                    register.setEmail(rs.getString("EMAIL"));
                    register.setCheck_in(rs.getDate("CHECK_IN"));
                    register.setCheck_out(rs.getDate("CHECK_OUT"));
                    Worker worker = new Worker();
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    Room room = new Room();
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    register.setWorker(worker);
                    register.setRoom(room);
                    registerList.add(register);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return registerList;
    }

    @Override
    public List<Room> searchRoomData(String keyword) throws Exception {
        List<Room> roomList = new ArrayList<Room>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,ROOM_NUMBER,ROOM_SITUATION,PRICE,HUMAN_COUNT,ROOM_TYPE FROM ROOM R WHERE R.ACTIVE = 1\r\n"
                + "AND LOWER(R.ROOM_NUMBER) LIKE LOWER(?) OR LOWER(R.ROOM_SITUATION) LIKE LOWER(?) OR LOWER(R.PRICE) LIKE LOWER(?) OR LOWER(R.HUMAN_COUNT) LIKE LOWER(?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Room room = new Room();
                    room.setId(rs.getLong("ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    room.setRoomSituation(rs.getString("ROOM_SITUATION"));
                    room.setPrice(rs.getFloat("PRICE"));
                    room.setHumanCount(rs.getInt("HUMAN_COUNT"));
                    room.setRoomType(rs.getString("ROOM_TYPE"));
                    roomList.add(room);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return roomList;
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        List<Payment> paymentList = new ArrayList<Payment>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,P.ID,\n"
                + "       R.ID REGISTER_ID,\n"
                + "       R.NAME REGISTER_NAME,\n"
                + "       R.SURNAME REGISTER_SURNAME,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       RM.ID ROOM_ID,\n"
                + "       RM.ROOM_NUMBER,\n"
                + "       P.AMOUNT,\n"
                + "       P.PAY_DATE\n"
                + "  FROM PAYMENT P\n"
                + "       INNER JOIN REGISTER R\n"
                + "          ON P.REG_ID = R.ID\n"
                + "       INNER JOIN WORKER W\n"
                + "          ON P.WORKER_ID = W.ID\n"
                + "       INNER JOIN ROOM RM\n"
                + "          ON P.ROOM_ID = RM.ID\n"
                + " WHERE P.ACTIVE = 1 AND W.ACTIVE = 1 AND RM.ACTIVE = 1 AND R.ACTIVE = 1 AND LOWER(R.REGISTER_NAME) LIKE LOWER(?)"
                + " OR LOWER(R.REGISTER_SURNAME) LIKE LOWER(?) OR LOWER(W.WORKER_NAME) LIKE LOWER(?) OR"
                + " LOWER(W.WORKER_SURNAME) LIKE LOWER(?) OR LOWER(RM.ROOM_NUMBER) LIKE LOWER(?) OR LOWER(P.AMOUNT) LIKE LOWER(?) OR LOWER(P.PAY_DATE) LIKE LOWER(?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                ps.setString(7, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setId(rs.getLong("ID"));
                    Worker worker = new Worker();
                    Register register = new Register();
                    Room room = new Room();
                    payment.setR(rs.getLong("r"));
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    payment.setWorker(worker);
                    register.setId(rs.getLong("REGISTER_ID"));
                    register.setName(rs.getString("REGISTER_NAME"));
                    register.setSurname(rs.getString("REGISTER_SURNAME"));
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    payment.setWorker(worker);
                    payment.setRoom(room);
                    payment.setRegister(register);
                    payment.setAmount(rs.getFloat("AMOUNT"));
                    payment.setPayDate(rs.getDate("PAY_DATE"));
                    paymentList.add(payment);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return paymentList;

    }

//    LIST
    @Override
    public List<Customer> getCustomerList() throws Exception {
        List<Customer> customerList = new ArrayList<Customer>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,\n"
                + "       C.ID,\n"
                + "       C.NAME,\n"
                + "       C.SURNAME,\n"
                + "       C.PHONE,\n"
                + "       C.CHECK_IN,\n"
                + "       C.CHECK_OUT,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       R.ID ROOM_ID,\n"
                + "       R.ROOM_NUMBER,\n"
                + "       R.ROOM_TYPE\n"
                + "  FROM CUSTOMER C\n"
                + "       INNER JOIN WORKER W\n"
                + "          ON C.WORKER_ID = W.ID\n"
                + "       INNER JOIN ROOM R\n"
                + "          ON C.ROOM_ID = R.ID\n"
                + " WHERE C.ACTIVE = 1";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getLong("ID"));
                    customer.setR(rs.getLong("r"));
                    customer.setName(rs.getString("NAME"));
                    customer.setSurname(rs.getString("SURNAME"));
                    customer.setPhone(rs.getString("PHONE"));
                    customer.setCheck_in(rs.getDate("CHECK_IN"));
                    customer.setCheck_out(rs.getDate("CHECK_OUT"));
                    Worker worker = new Worker();
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    Room room = new Room();
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    room.setRoomType(rs.getString("ROOM_TYPE"));
                    customer.setWorker(worker);
                    customer.setRoom(room);
                    customerList.add(customer);
                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return customerList;
    }

    @Override
    public List<Register> getRegisterList() throws Exception {
        List<Register> registerList = new ArrayList<Register>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT \n"
                + "       R.id_register,\n"
                + "       R.NAME,\n"
                + "       R.SURNAME,\n"
                + "       R.DOB,\n"
                + "       R.FATHER_NAME,\n"
                + "       R.ADULT_COUNT,\n"
                + "       R.CHILD_COUNT,\n"
                + "       R.PHONE,\n"
                + "       R.EMAIL,\n"
                + "       R.CHECK_IN,\n"
                + "       R.CHECK_OUT,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       RM.ID ROOM_ID,\n"
                + "       RM.ROOM_NUMBER,\n"
                + "       RM.ROOM_TYPE\n"
                + "  FROM REGISTER R \n"
                + "  INNER JOIN WORKER W \n"
                + "  ON R.WORKER_ID = W.ID\n"
                + "  INNER JOIN ROOM RM\n"
                + "  ON R.ROOM_ID = RM.ID\n"
                + " WHERE R.ACTIVE = 1";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Register register = new Register();
                    register.setR(rs.getLong("r"));
                    register.setId(rs.getLong("ID"));
                    register.setName(rs.getString("NAME"));
                    register.setSurname(rs.getString("SURNAME"));
                    register.setDob(rs.getDate("DOB"));
                    register.setFatherName(rs.getString("FATHER_NAME"));
                    register.setAdultCount(rs.getString("ADULT_COUNT"));
                    register.setChildCount(rs.getString("CHILD_COUNT"));
                    register.setPhone(rs.getString("PHONE"));
                    register.setEmail(rs.getString("EMAIL"));
                    register.setCheck_in(rs.getDate("CHECK_IN"));
                    register.setCheck_out(rs.getDate("CHECK_OUT"));
                    Worker worker = new Worker();
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    Room room = new Room();
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    register.setWorker(worker);
                    register.setRoom(room);
                    registerList.add(register);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return registerList;
    }

    @Override
    public List<Room> getRoomList() throws Exception {
        List<Room> roomList = new ArrayList<Room>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,ROOM_NUMBER,ROOM_SITUATION,PRICE,HUMAN_COUNT,ROOM_TYPE FROM ROOM\r\n" + "WHERE ACTIVE = 1";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Room room = new Room();
                    room.setR(rs.getLong("r"));
                    room.setId(rs.getLong("ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    room.setRoomSituation(rs.getString("ROOM_SITUATION"));
                    room.setPrice(rs.getFloat("PRICE"));
                    room.setHumanCount(rs.getInt("HUMAN_COUNT"));
                    room.setRoomType(rs.getString("ROOM_TYPE"));
                    roomList.add(room);
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }

        return roomList;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList<Payment>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,P.ID,\n"
                + "       R.ID REGISTER_ID,\n"
                + "       R.NAME REGISTER_NAME,\n"
                + "       R.SURNAME REGISTER_SURNAME,\n"
                + "       W.ID WORKER_ID,\n"
                + "       W.NAME WORKER_NAME,\n"
                + "       W.SURNAME WORKER_SURNAME,\n"
                + "       RM.ID ROOM_ID,\n"
                + "       RM.ROOM_NUMBER,\n"
                + "       P.AMOUNT,\n"
                + "       P.PAY_DATE\n"
                + "  FROM PAYMENT P\n"
                + "       INNER JOIN REGISTER R\n"
                + "          ON P.REG_ID = R.ID\n"
                + "       INNER JOIN WORKER W\n"
                + "          ON P.WORKER_ID = W.ID\n"
                + "       INNER JOIN ROOM RM\n"
                + "          ON P.ROOM_ID = RM.ID\n"
                + " WHERE P.ACTIVE = 1";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setId(rs.getLong("ID"));
                    Worker worker = new Worker();
                    Register register = new Register();
                    Room room = new Room();
                    payment.setR(rs.getLong("r"));
                    worker.setId(rs.getLong("WORKER_ID"));
                    worker.setName(rs.getString("WORKER_NAME"));
                    worker.setSurname(rs.getString("WORKER_SURNAME"));
                    payment.setWorker(worker);
                    register.setId(rs.getLong("REGISTER_ID"));
                    register.setName(rs.getString("REGISTER_NAME"));
                    register.setSurname(rs.getString("REGISTER_SURNAME"));
                    room.setId(rs.getLong("ROOM_ID"));
                    room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                    payment.setWorker(worker);
                    payment.setRoom(room);
                    payment.setRegister(register);
                    payment.setAmount(rs.getFloat("AMOUNT"));
                    payment.setPayDate(rs.getDate("PAY_DATE"));
                    paymentList.add(payment);
                }
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return paymentList;
    }

    @Override
    public List<Worker> getWorkerList() throws Exception {
        List<Worker> workerList = new ArrayList<Worker>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id_worker,NAME,SURNAME,DOB,FATHER_NAME,PHONE,EMAIL FROM WORKER\r\n" + " WHERE ACTIVE = 1";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Worker worker = new Worker();
                    worker.setId(rs.getLong("id_worker"));
                    worker.setName(rs.getString("NAME"));
                    worker.setSurname(rs.getString("SURNAME"));
                    worker.setDob(rs.getDate("DOB"));
                    worker.setFatherName(rs.getString("FATHER_NAME"));
                    worker.setPhone(rs.getString("PHONE"));
                    worker.setEmail(rs.getString("EMAIL"));
                    workerList.add(worker);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception ex) {
            LOGGER.error("Get worker List:",ex);
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return workerList;
    }

//    ADD
    @Override
    public boolean addWorker(Worker worker) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO WORKER(NAME,SURNAME,DOB,FATHER_NAME,PHONE,EMAIL)\r\n"
                + " VALUES(?,?,?,?,?,?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, worker.getName());
                ps.setString(2, worker.getSurname());
                ps.setDate(3, new java.sql.Date(worker.getDob().getTime()));
                ps.setString(4, worker.getFatherName());
                ps.setString(5, worker.getPhone());
                ps.setString(6, worker.getEmail());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean addRoom(Room room) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO ROOM(ID,ROOM_NUMBER,ROOM_SITUATION,PRICE,HUMAN_COUNT,ROOM_TYPE)\r\n"
                + "VALUES(ROOM_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, room.getRoomNumber());
                ps.setString(2, room.getRoomSituation());
                ps.setFloat(3, room.getPrice());
                ps.setInt(4, room.getHumanCount());
                ps.setString(5, room.getRoomType());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connetion is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean addPayment(Payment payment) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PAYMENT(ID,AMOUNT,PAY_DATE,REG_ID,ROOM_ID,WORKER_ID)\n"
                + " VALUES(PAY_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setFloat(1, payment.getAmount());
                ps.setDate(2, new java.sql.Date(payment.getPayDate().getTime()));
                ps.setLong(3, payment.getRegister().getId());
                ps.setLong(4, payment.getRoom().getId());
                ps.setLong(5, payment.getWorker().getId());
                ps.execute();
                isAdded = true;
            } else {
                System.out.println("Connection is null!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return isAdded;
    }

    @Override
    public boolean addCustomer(Customer customer) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = " INSERT INTO CUSTOMER(ID,NAME,SURNAME,PHONE,CHECK_IN,CHECK_OUT,WORKER_ID,ROOM_ID)"
                + " VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, customer.getName());
                ps.setString(2, customer.getSurname());
                ps.setString(3, customer.getPhone());
                ps.setDate(4, new java.sql.Date(customer.getCheck_in().getTime()));
                ps.setDate(5, new java.sql.Date(customer.getCheck_out().getTime()));
                ps.setLong(6, customer.getWorker().getId());
                ps.setLong(7, customer.getRoom().getId());
                ps.execute();
                isAdded = true;
            } else {
                System.out.println("Connection is null!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return isAdded;
    }

    @Override
    public boolean addRegister(Register register) throws Exception {
        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO REGISTER(ID,NAME,SURNAME,DOB,FATHER_NAME,ADULT_COUNT,CHILD_COUNT,PHONE,EMAIL,CHECK_IN,CHECK_OUT,WORKER_ID,ROOM_ID) "
                + "VALUES(REG_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, register.getName());
                ps.setString(2, register.getSurname());
                ps.setDate(3, new java.sql.Date(register.getDob().getTime()));
                ps.setString(4, register.getFatherName());
                ps.setString(5, register.getAdultCount());
                ps.setString(6, register.getChildCount());
                ps.setString(7, register.getPhone());
                ps.setString(8, register.getEmail());
                ps.setDate(9, new java.sql.Date(register.getCheck_in().getTime()));
                ps.setDate(10, new java.sql.Date(register.getCheck_out().getTime()));
                ps.setLong(11, register.getWorker().getId());
                ps.setLong(12, register.getRoom().getId());
                ps.execute();
                isAdded = true;
            } else {
                System.out.println("Connection is null!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return isAdded;
    }

}
