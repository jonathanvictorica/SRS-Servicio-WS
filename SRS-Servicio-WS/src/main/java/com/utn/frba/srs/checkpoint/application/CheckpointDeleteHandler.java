package com.utn.frba.srs.checkpoint.application;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utn.frba.srs.checkpoint.application.CheckpointDeleteHandler.CheckpointDeleteCommand;
import com.utn.frba.srs.checkpoint.domain.Checkpoint;
import com.utn.frba.srs.checkpoint.domain.CheckpointRepository;
import com.utn.frba.srs.shared.domain.crqs.Command;
import com.utn.frba.srs.shared.domain.crqs.CommandHandler;

import lombok.Data;
@Service
public class CheckpointDeleteHandler implements CommandHandler<CheckpointDeleteCommand> {

	private Checkpoint checkpoint;

	@Autowired
	private CheckpointDeleteHandler(CheckpointRepository checkpointRepository) {
		checkpoint = new Checkpoint(checkpointRepository);
	}

	public void invoke(CheckpointDeleteCommand data) {
		checkpoint.delete(data.id);
	}

	@Data
	public static class CheckpointDeleteCommand implements Serializable, Command {
		private static final long serialVersionUID = 1L;

		private Long id;
	}

}
