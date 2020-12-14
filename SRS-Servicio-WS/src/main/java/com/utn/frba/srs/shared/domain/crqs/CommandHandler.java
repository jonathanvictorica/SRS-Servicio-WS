package com.utn.frba.srs.shared.domain.crqs;

import com.utn.frba.srs.shared.domain.DomainException;

public interface CommandHandler<T extends Command> {

    void invoke(T command) throws DomainException;
}