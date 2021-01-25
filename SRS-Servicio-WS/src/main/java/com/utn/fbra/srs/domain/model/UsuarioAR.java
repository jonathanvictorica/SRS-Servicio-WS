package com.utn.fbra.srs.domain.model;

import java.util.Optional;

import com.utn.fbra.srs.domain.DomainException;
import com.utn.fbra.srs.domain.repository.RepositoryFactory;
import com.utn.fbra.srs.domain.repository.RondaEjecucionRepository;
import com.utn.fbra.srs.domain.repository.UsuarioRepository;
import com.utn.fbra.srs.domain.vo.FlagVO;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.MailVO;
import com.utn.fbra.srs.domain.vo.NickVO;
import com.utn.fbra.srs.domain.vo.NombreVO;
import com.utn.fbra.srs.domain.vo.NumeroVO;
import com.utn.fbra.srs.domain.vo.PasswordVO;
import com.utn.fbra.srs.domain.vo.PerfilVO;
import com.utn.fbra.srs.shared.domain.AggregateRoot;

public class UsuarioAR extends AggregateRoot {

	private IdVO usuarioID;
	private NickVO nick;
	private PasswordVO password;
	private MailVO mail;
	private NumeroVO intentos;
	private FlagVO esBloqueado;
	private FlagVO esActivo;
	private NombreVO nombre;
	private NombreVO apellido;
	private PerfilVO perfilUsuario;

	public UsuarioAR(IdVO usuarioID, NickVO nick, PasswordVO password, MailVO mail, NombreVO nombre, NombreVO apellido,
			PerfilVO perfilUsuario) {
		super();
		this.usuarioID = usuarioID;
		this.nick = nick;
		this.password = password;
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
		this.perfilUsuario = perfilUsuario;
		this.esActivo = FlagVO.TRUE;
		this.esBloqueado = FlagVO.FALSE;
		this.intentos.setear(0);

	}

	public UsuarioAR() {
		super();
	}

	public UsuarioAR(IdVO usuarioID) {
		super();
		this.usuarioID = usuarioID;
	}

	public void cambiar(NickVO nick, MailVO mail, NombreVO nombre, NombreVO apellido, PerfilVO perfilUsuario) {
		this.nick = nick;
		this.mail = mail;
		this.nombre = nombre;
		this.apellido = apellido;
		this.perfilUsuario = perfilUsuario;

	}

	private static UsuarioRepository getUsuarioRepository() {
		return (UsuarioRepository) RepositoryFactory.create("UsuarioRepository");
	}

	public static UsuarioAR buscarPorID(IdVO id) throws DomainException {
		return Optional.ofNullable(getUsuarioRepository().findById(id))
				.orElseThrow(() -> new DomainException("No existe el usuario con el id " + id.toString()));
	}

	public void registrar() throws DomainException {
		validarUsuario();
		getUsuarioRepository().registrar(this);
	}

	private void validarUsuario() throws DomainException {
		if (!getUsuarioRepository().validarUnicoID(usuarioID)) {
			throw new DomainException("Ya existe un usuario con el id informado.");
		}
		if (!getUsuarioRepository().validarUnicoNick(usuarioID, nick)) {
			throw new DomainException("Ya existe un usuario con el mismo nick.");
		}
		if (!getUsuarioRepository().validarUnicoMail(usuarioID, mail)) {
			throw new DomainException("Ya existe un usuario con el mail informado.");
		}
	}

	public void modificar() throws DomainException {
		validarUsuario();
		getUsuarioRepository().modificar(this);
	}

	public void eliminar() {
		getUsuarioRepository().eliminar(this);
	}

	public void validarCredencial() throws DomainException {
		if (!getUsuarioRepository().validarCredencial(this.nick, this.password)) {
			this.intentos.incrementar(1);
			if (this.intentos.equals(3)) {
				this.esBloqueado = FlagVO.TRUE;
			}
			throw new DomainException("Credenciales invalidas");
		} else {
			this.intentos.setear(0);
		}
	}

}
