package com.utn.frba.srs.round.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.FindRound.RoundQuery;
import com.utn.frba.srs.round.application.FindRoundBySubsidiryAndNameHandler.FindRoundBySubsidiryAndNameQuery;
import com.utn.frba.srs.round.domain.model.Round;
import com.utn.frba.srs.round.domain.repository.RoundRepository;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.crqs.Query;
import com.utn.frba.srs.shared.domain.crqs.QueryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class FindRoundBySubsidiryAndNameHandler extends FindRound implements QueryHandler<RoundQuery, FindRoundBySubsidiryAndNameQuery> {

	@Autowired
	public FindRoundBySubsidiryAndNameHandler(RoundRepository roundRepository) {
		super(roundRepository);
	}

	@Override
	public RoundQuery ask(FindRoundBySubsidiryAndNameQuery query) throws DomainException {
		return roundMapper.roundToRoundQuery(Round.findBySubsidiaryAndName(query.getSubsidiaryId(), query.getRoundName()));
	}

	@Data
	@AllArgsConstructor
	public static class FindRoundBySubsidiryAndNameQuery implements Query<RoundQuery> {
		private Long subsidiaryId;
		private String roundName;
	}

}
