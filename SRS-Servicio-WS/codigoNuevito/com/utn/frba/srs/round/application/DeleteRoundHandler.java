package com.utn.frba.srs.round.application;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.DeleteRoundHandler.DeleteRoundCommand;
import com.utn.frba.srs.round.domain.model.Round;
import com.utn.frba.srs.round.domain.repository.RoundRepository;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;

@Service
public class DeleteRoundHandler implements CommandHandler<DeleteRoundCommand> {

	@Autowired
	private DeleteRoundHandler(RoundRepository roundRepository) {
		Round.injectRepository(roundRepository);
	}

	public void invoke(DeleteRoundCommand data) {
		Round.delete(data.id);
	}

	@Data
	public static class DeleteRoundCommand implements Serializable, Command {

		private static final long serialVersionUID = 1L;
		private Long id;
	}

}
