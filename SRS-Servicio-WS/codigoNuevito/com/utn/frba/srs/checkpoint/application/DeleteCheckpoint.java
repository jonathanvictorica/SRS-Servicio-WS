package com.utn.frba.srs.checkpoint.application;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.application.DeleteCheckpoint.DeleteCheckpointCommand;
import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.shared.domain.DomainException;
import com.utn.frba.srs.shared.domain.NotFoundException;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;

@Service
public class DeleteCheckpoint implements CommandHandler<DeleteCheckpointCommand> {

	private CheckpointRepository checkpointRepository;
	
	@Autowired
	public DeleteCheckpoint(CheckpointRepository checkpointRepository) {
		super();
		this.checkpointRepository = checkpointRepository;
	}

	@Override
	public void invoke(DeleteCheckpointCommand command) throws DomainException {
		Checkpoint checkpoint = checkpointRepository.findById(command.getId()).orElseThrow(NotFoundException::new);
		checkpointRepository.deleteById(checkpoint.getId());
	}

	@Data
	public static class DeleteCheckpointCommand implements Serializable, Command {
		private static final long serialVersionUID = 1L;

		private UUID id;
	}

}
