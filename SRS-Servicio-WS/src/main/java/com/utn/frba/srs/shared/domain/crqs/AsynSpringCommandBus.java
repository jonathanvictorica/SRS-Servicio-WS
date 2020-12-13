package com.utn.frba.srs.shared.domain.crqs;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("AsynSpringCommandBus")
public class AsynSpringCommandBus implements CommandBus {

	private Queue<Command> events = new LinkedList<Command>();

	private CommandBus commandBusSyncr;

	@Autowired
	public AsynSpringCommandBus(CommandBus commandBusSyncr) {
		this.commandBusSyncr = commandBusSyncr;
	}

	@Override
	public void invoke(Command command) throws Exception {
		events.add(command);
	}

	@Scheduled(fixedRate = 10000)
	public void execute() throws Exception {
		while (!events.isEmpty()) {
			commandBusSyncr.invoke(events.poll());
		}
	}
}
