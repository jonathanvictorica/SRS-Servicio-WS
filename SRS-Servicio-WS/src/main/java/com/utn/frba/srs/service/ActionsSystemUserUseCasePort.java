package com.utn.frba.srs.service;

import com.utn.frba.srs.model.SystemUser;

public interface ActionsSystemUserUseCasePort {

	void unlockUser(Long id);

	void changePassword(Long userId, String password);

	SystemUser validateCredential(String nick, String password);

}
