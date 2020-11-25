package com.utn.frba.srs.service.impl;

import org.springframework.stereotype.Service;

import com.utn.frba.srs.model.SystemUser;
import com.utn.frba.srs.service.ActionsSystemUserUseCasePort;

@Service
public class ActionsSystemUserUseCaseAdapter implements ActionsSystemUserUseCasePort {

	@Override
	public void unlockUser(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(Long userId, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public SystemUser validateCredential(String nick, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
