package com.utn.fbra.srs.domain.repository;

import com.utn.fbra.srs.domain.model.UsuarioAR;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.MailVO;
import com.utn.fbra.srs.domain.vo.NickVO;
import com.utn.fbra.srs.domain.vo.PasswordVO;

public interface UsuarioRepository extends Repository<UsuarioAR, IdVO> {

	boolean validarCredencial(NickVO nick, PasswordVO password);

	boolean validarUnicoID(IdVO usuarioID);

	boolean validarUnicoNick(IdVO usuarioID, NickVO nick);

	boolean validarUnicoMail(IdVO usuarioID, MailVO mail);

}
