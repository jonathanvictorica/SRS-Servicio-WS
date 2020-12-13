package com.utn.frba.srs.shared.domain.crqs;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SynSpringCommandBus implements CommandBus{
	private Map<Class, CommandHandler> handlers;

	public SynSpringCommandBus(List<CommandHandler> commandHandlerImplementations) {
		this.handlers = new HashMap<>();
		commandHandlerImplementations.forEach(commandHandler -> {
			Class<?> commandClass = getCommandClass(commandHandler);
			handlers.put(commandClass, commandHandler);
		});
	}

	@Override
	public void invoke(Command command) throws Exception  {
		
		handlers.get(command.getClass()).invoke(command);
	}

	private Class<?> getCommandClass(CommandHandler handler) {
		Type commandInterface = ((ParameterizedType) handler.getClass().getGenericInterfaces()[0])
				.getActualTypeArguments()[0];
		return getClass(commandInterface.getTypeName());
	}

	private Class<?> getClass(String name) {
		try {
			return Class.forName(name);
		} catch (Exception e) {
			return null;
		}
	}
}
