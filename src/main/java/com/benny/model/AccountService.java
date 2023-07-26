package com.benny.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountDao aDao;
	
	public boolean checkLogin(Account users) {
		return aDao.checkLogin(users);
	}
	
}
