package com.utn.frba.srs.round.application;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.domain.Round;
import com.utn.frba.srs.round.domain.RoundRepository;

import lombok.Data;

@Service
public class RoundDelete {

	private Round round;

	@Autowired
	private RoundDelete(RoundRepository roundRepository) {
		round = new Round(roundRepository);
	}

	public void invoke(RoundDeleteCommand data) {
		round.delete(data.id);
	}

	@Data
	public static class RoundDeleteCommand implements Serializable {

		private static final long serialVersionUID = 1L;

		private String id;
	}

}
