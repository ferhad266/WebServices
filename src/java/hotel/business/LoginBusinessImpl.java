/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.business;

import hotel.dao.LoginDao;
import hotel.model.LoginUser;

/**
 *
 * @author ferha
 */
public class LoginBusinessImpl implements LoginBusiness{
    
    private LoginDao loginDao;

    public LoginBusinessImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public LoginUser login(String username, String password) throws Exception {
        return loginDao.login(username, password);
    }

    public boolean updateTokenById(String token, Long userId) throws Exception {
        return loginDao.updateTokenById(token, userId);
    }

    public LoginUser checkToken(String token) throws Exception {
        return loginDao.checkToken(token);
    }
    
}
