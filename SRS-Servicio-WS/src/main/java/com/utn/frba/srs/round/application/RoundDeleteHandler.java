package com.utn.frba.srs.round.application;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.RoundDeleteHandler.RoundDeleteCommand;
import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.round.domain.RoundRepository;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;

@Service
public class RoundDeleteHandler implements CommandHandler<RoundDeleteCommand>{

	private Round round;

	@Autowired
	private RoundDeleteHandler(RoundRepository roundRepository) {
		round = new Round(roundRepository);
	}

	public void invoke(RoundDeleteCommand data) {
		round.delete(data.id);
	}

	@Data
	public static class RoundDeleteCommand implements Serializable,Command {


		private static final long serialVersionUID = 1L;
		private Long id;
	}

}
