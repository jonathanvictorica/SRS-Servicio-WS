package com.utn.frba.srs.service;

import com.utn.frba.srs.exception.NotFoundException;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.SystemUser;


public interface ActionsSystemUserUseCasePort {

	void unlockUser(Long id) throws NotFoundException;

	void changePassword(Long userId, String password) throws NotFoundException;

	SystemUser validateCredential(String nick, String password) throws SRSException;

}
