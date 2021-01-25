package com.utn.fbra.srs.infraestructure.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.fbra.srs.application.usecase.AdmUsuarioUC;
import com.utn.fbra.srs.application.usecase.AdmUsuarioUC.CrearUsuario;
import com.utn.fbra.srs.application.usecase.AdmUsuarioUC.ModificarUsuario;
import com.utn.fbra.srs.infraestructure.controller.AdmUsuarioController.CrearUsuarioRequest;
import com.utn.fbra.srs.infraestructure.controller.AdmUsuarioController.ModificarUsuarioRequest;
import com.utn.fbra.srs.shared.application.AdmUseCase;
import com.utn.fbra.srs.shared.infraestructure.AdmController;
import com.utn.fbra.srs.shared.infraestructure.BaseController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/usuario")
@Api(tags = "UsuarioController")
public class AdmUsuarioController extends BaseController
		implements AdmController<CrearUsuarioRequest, ModificarUsuarioRequest, UUID> {

	private AdmUseCase<CrearUsuario, ModificarUsuario, UUID> admUsuario = new AdmUsuarioUC();

	@Override
	public void crear(CrearUsuarioRequest request) throws Exception {
		admUsuario.crear(new AdmUsuarioUC.CrearUsuario());
	}

	@Override
	public void modificar(ModificarUsuarioRequest request) throws Exception {
		admUsuario.modificar(new AdmUsuarioUC.ModificarUsuario());
	}

	@Override
	public void eliminar(UUID request) throws Exception {
		admUsuario.eliminar(request);
	}

	public static class CrearUsuarioRequest {
		private UUID usuarioID;
		private String nick;
		private String password;
		private String mail;
		private String nombre;
		private String apellido;
		private String perfilUsuario;

		public UUID getUsuarioID() {
			return usuarioID;
		}

		public void setUsuarioID(UUID usuarioID) {
			this.usuarioID = usuarioID;
		}

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getPerfilUsuario() {
			return perfilUsuario;
		}

		public void setPerfilUsuario(String perfilUsuario) {
			this.perfilUsuario = perfilUsuario;
		}

	}

	public static class ModificarUsuarioRequest {

	}

}
