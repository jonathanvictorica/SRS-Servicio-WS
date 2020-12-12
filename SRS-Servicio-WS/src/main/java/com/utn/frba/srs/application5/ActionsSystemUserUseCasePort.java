package com.utn.frba.srs.application5;

import com.utn.frba.srs.domain.exception.NotFoundException;
import com.utn.frba.srs.domain.exception.SRSException;
import com.utn.frba.srs.domain.model.SystemUser;


public interface ActionsSystemUserUseCasePort {

	void unlockUser(Long id) throws NotFoundException;

	void changePassword(Long userId, String password) throws NotFoundException;

	SystemUser validateCredential(String nick, String password) throws SRSException;

}
