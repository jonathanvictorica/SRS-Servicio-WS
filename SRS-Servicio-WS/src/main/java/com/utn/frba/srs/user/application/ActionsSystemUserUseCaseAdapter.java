package com.utn.frba.srs.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.application5.ActionsSystemUserUseCasePort;
import com.utn.frba.srs.infraestructure.repository.hibernate.SystemUserRepository;
import com.utn.frba.srs.shared.domain.NotFoundException;
import com.utn.frba.srs.shared.domain.SRSException;
import com.utn.frba.srs.user.domain.infraestructure.persistence.hibernate.entity.SystemUser;

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
