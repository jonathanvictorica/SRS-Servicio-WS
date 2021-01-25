package com.utn.frba.srs.round.application;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.round.application.FindRound.RoundListQuery;
import com.utn.frba.srs.round.application.FindRoundBySubsidiaryHandler.FindRoundBySubsidiaryQuery;
import com.utn.frba.srs.round.domain.model.Round;
import com.utn.frba.srs.round.domain.repository.RoundRepository;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.crqs.Query;
import com.utn.frba.srs.shared.domain.crqs.QueryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class FindRoundBySubsidiaryHandler extends FindRound
		implements QueryHandler<RoundListQuery, FindRoundBySubsidiaryQuery> {

	@Autowired
	public FindRoundBySubsidiaryHandler(RoundRepository roundRepository) {
		super(roundRepository);
	}

	@Override
	public RoundListQuery ask(FindRoundBySubsidiaryQuery query) throws DomainException {
		return new RoundListQuery(Round.findBySubsidiary(query.subsidiaryId).stream().map(a -> roundMapper.roundToRoundQuery(a))
				.collect(Collectors.toList()));
	}

	@Data
	@AllArgsConstructor
	public static class FindRoundBySubsidiaryQuery implements Query<RoundListQuery> {
		private Long subsidiaryId;
	}

}
