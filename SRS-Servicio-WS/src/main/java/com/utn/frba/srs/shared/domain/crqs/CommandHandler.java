package com.utn.frba.srs.shared.domain.crqs;

public interface CommandHandler<T extends Command> {

    void invoke(T command) throws Exception;
}