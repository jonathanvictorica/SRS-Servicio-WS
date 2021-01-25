package com.utn.frba.srs.round.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.FindRound.RoundQuery;
import com.utn.frba.srs.round.application.FindRoundByIdHandler.FindRoundByIdQuery;
import com.utn.frba.srs.round.domain.model.Round;
import com.utn.frba.srs.round.domain.repository.RoundRepository;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.crqs.Query;
import com.utn.frba.srs.shared.domain.crqs.QueryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class FindRoundByIdHandler extends FindRound implements QueryHandler<RoundQuery, FindRoundByIdQuery> {

	@Autowired
	public FindRoundByIdHandler(RoundRepository roundRepository) {
		super(roundRepository);
	}

	@Override
	public RoundQuery ask(FindRoundByIdQuery query) throws DomainException {
		return roundMapper.roundToRoundQuery(Round.findById(query.getId()));
	}

	@Data
	@AllArgsConstructor
	public static class FindRoundByIdQuery implements Query<RoundQuery> {
		private Long id;
	}

}
