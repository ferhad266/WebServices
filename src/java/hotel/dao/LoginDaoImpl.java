/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.model.LoginUser;
import hotel.model.Role;
import hotel.util.JdbcUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ferha
 */
public class LoginDaoImpl implements LoginDao {

    @Override
    public LoginUser login(String username, String password) throws Exception {
        LoginUser loginUser = new LoginUser();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT lc.id_login_company,lc.username,lc.fullname,lc.token,lc.data_date FROM ewebservicedb.login_company lc \n"
                + "where lc.active = 1 and lc.username = ? and lc.password = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    loginUser.setId(rs.getLong("id_login_company"));
                    loginUser.setUsername(rs.getString("username"));
                    loginUser.setFullname(rs.getString("fullname"));
                    loginUser.setDataDate(rs.getDate("data_date"));
                    loginUser.setToken(rs.getString("token"));
                } else {
                    loginUser = null;
                }
            } else {
                System.out.println("Connetion is null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }

        return loginUser;
    }

    public boolean updateTokenById(String token, Long userId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update ewebservicedb.login_company set token = ?\n"
                + "where id_login_company = ?;";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, token);
                ps.setLong(2, userId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return result;
    }

    public LoginUser checkToken(String token) throws Exception {
        LoginUser loginUser = new LoginUser();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ewebservicedb.login_company\n"
                + "where active = 1 and token = ?";
        try {
            c = DBHelper.ConnectToDB();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, token);
                rs = ps.executeQuery();
                if (rs.next()) {
                    loginUser.setId(rs.getLong("id_login_company"));
                    loginUser.setUsername(rs.getString("username"));
                } else {
                    loginUser = null;
                }
            } else {
                System.out.println("Connetion is null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }

        return loginUser;
    }

}
