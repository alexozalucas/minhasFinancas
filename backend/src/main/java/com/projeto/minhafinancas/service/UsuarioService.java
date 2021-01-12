package com.projeto.minhafinancas.service;

import com.projeto.minhafinancas.model.entity.Usuario;

public interface UsuarioService {

	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
}
