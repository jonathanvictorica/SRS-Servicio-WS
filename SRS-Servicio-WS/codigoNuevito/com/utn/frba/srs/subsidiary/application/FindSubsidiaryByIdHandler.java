package com.utn.frba.srs.subsidiary.application;

import java.io.Serializable;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.crqs.Query;
import com.utn.frba.srs.shared.domain.crqs.QueryHandler;
import com.utn.frba.srs.subsidiary.application.FindSubsidiaryByIdHandler.FindSubsidiaryByIdQuery;
import com.utn.frba.srs.subsidiary.application.FindSubsidiaryByIdHandler.SubsidiaryQuery;
import com.utn.frba.srs.subsidiary.domain.Subsidiary;
import com.utn.frba.srs.subsidiary.domain.SubsidiaryRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class FindSubsidiaryByIdHandler implements QueryHandler<SubsidiaryQuery, FindSubsidiaryByIdQuery> {
	protected Subsidiary subsidiary;

	protected SubsidiaryQueryMapper mapper = Mappers.getMapper(SubsidiaryQueryMapper.class);

	@Autowired
	private FindSubsidiaryByIdHandler(SubsidiaryRepository checkpointRepository) {
		subsidiary = new Subsidiary(checkpointRepository);
	}

	@Override
	public SubsidiaryQuery ask(FindSubsidiaryByIdQuery query) throws DomainException {
		return mapper.subsidiaryToSubsidiaryQuery(subsidiary.findById(query.getId()));
	}

	@Data
	@AllArgsConstructor
	public static class FindSubsidiaryByIdQuery implements Query<SubsidiaryQuery> {
		private UUID id;
	}

	@Data
	public static class SubsidiaryQuery implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;



	}

}


@Mapper
interface SubsidiaryQueryMapper {
	public abstract SubsidiaryQuery subsidiaryToSubsidiaryQuery(Subsidiary data);

}
