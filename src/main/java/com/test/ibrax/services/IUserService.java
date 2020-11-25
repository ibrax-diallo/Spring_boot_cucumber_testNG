package com.test.ibrax.services;


import com.test.ibrax.documents.User;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@supinfo.com>
 */
public interface IUserService extends IBaseService<User, String>{

    User findByUsername(String userName);

    User  login (String username, String password);





}
