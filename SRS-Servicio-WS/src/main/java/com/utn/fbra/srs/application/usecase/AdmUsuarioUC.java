package com.utn.fbra.srs.application.usecase;

import java.util.UUID;

import com.utn.fbra.srs.application.usecase.AdmUsuarioUC.CrearUsuario;
import com.utn.fbra.srs.application.usecase.AdmUsuarioUC.ModificarUsuario;
import com.utn.fbra.srs.domain.event.producer.UsuarioCreadoED;
import com.utn.fbra.srs.domain.model.UsuarioAR;
import com.utn.fbra.srs.domain.vo.IdVO;
import com.utn.fbra.srs.domain.vo.MailVO;
import com.utn.fbra.srs.domain.vo.NickVO;
import com.utn.fbra.srs.domain.vo.NombreVO;
import com.utn.fbra.srs.domain.vo.PasswordVO;
import com.utn.fbra.srs.domain.vo.PerfilVO;
import com.utn.fbra.srs.shared.application.AdmUseCase;
import com.utn.fbra.srs.shared.domain.BusFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AdmUsuarioUC implements AdmUseCase<CrearUsuario, ModificarUsuario, UUID> {

	@Override
	public void crear(CrearUsuario request) throws Exception {
		UsuarioAR usuario = new UsuarioAR(new IdVO(request.getUsuarioID()), new NickVO(request.getNick()),
				new PasswordVO(request.getPassword()), new MailVO(request.getMail()), new NombreVO(request.getNombre()),
				new NombreVO(request.getApellido()), new PerfilVO(request.getPerfilUsuario()));

		usuario.registrar();

		BusFactory.create("domainEventBUS").publicar(new UsuarioCreadoED(request.getUsuarioID().toString(),
				request.getNombre() + request.getApellido(), request.getNick(), request.getMail()));
	}

	@Override
	public void modificar(ModificarUsuario request) throws Exception {
		UsuarioAR usuario = UsuarioAR.buscarPorID(new IdVO(request.usuarioID));

		usuario.cambiar(new NickVO(request.getNick()), new MailVO(request.getMail()), new NombreVO(request.getNombre()),
				new NombreVO(request.getApellido()), new PerfilVO(request.getPerfilUsuario()));

		usuario.modificar();

	}

	@Override
	public void eliminar(UUID request) throws Exception {
		UsuarioAR usuario = new UsuarioAR(new IdVO(request));
		usuario.eliminar();
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CrearUsuario {
		private UUID usuarioID;
		private String nick;
		private String password;
		private String mail;
		private String nombre;
		private String apellido;
		private String perfilUsuario;

	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ModificarUsuario {
		private UUID usuarioID;
		private String nick;
		private String mail;
		private String nombre;
		private String apellido;
		private String perfilUsuario;

	}

}