package com.accenture.learningweb.service;

import com.accenture.learningweb.dao.LoginServiceDAO;
import com.accenture.learningweb.model.User;

public class LoginServiceImpl implements LoginServiceFacade {

	LoginServiceDAO dao=new LoginServiceDAO();
	@Override
	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		return dao.validateUser(user);
	}

}
