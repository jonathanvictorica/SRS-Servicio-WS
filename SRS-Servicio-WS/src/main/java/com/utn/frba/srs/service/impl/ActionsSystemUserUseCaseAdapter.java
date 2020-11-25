package com.utn.frba.srs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.exception.NotFoundException;
import com.utn.frba.srs.exception.SRSException;
import com.utn.frba.srs.model.SystemUser;
import com.utn.frba.srs.repository.SystemUserRepository;
import com.utn.frba.srs.service.ActionsSystemUserUseCasePort;

@Service
public class ActionsSystemUserUseCaseAdapter implements ActionsSystemUserUseCasePort {

	@Autowired
	private SystemUserRepository systemUserRepository;

	@Override
	public void unlockUser(Long id) throws NotFoundException {
		SystemUser systemUser = systemUserRepository.findById(id).orElseThrow(() -> new NotFoundException(id + ""));
		systemUser.setActive(true);
		systemUser.setBloqueadedUser(false);
		systemUser.setFallidedIntentCount(0);
		systemUserRepository.save(systemUser);
	}

	@Override
	public void changePassword(Long userId, String password) throws NotFoundException {
		SystemUser systemUser = systemUserRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId + ""));
		systemUser.setPassword(password);
		systemUserRepository.save(systemUser);

	}

	@Override
	public SystemUser validateCredential(String nick, String password) throws SRSException {
		SystemUser systemUser = systemUserRepository.findByNick(nick).orElseThrow(() -> new NotFoundException(nick + ""));
		systemUser.validatePassword(password);
		return systemUser;
	}

}
