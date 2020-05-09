/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.model.LoginUser;

/**
 *
 * @author ferha
 */
public interface LoginDao {

    LoginUser login(String username, String password) throws Exception;

    boolean updateTokenById(String token, Long userId) throws Exception;

    LoginUser checkToken(String token) throws Exception;

}
