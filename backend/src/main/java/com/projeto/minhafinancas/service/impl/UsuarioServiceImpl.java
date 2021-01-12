package com.projeto.minhafinancas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.minhafinancas.exception.RegraNegocioException;
import com.projeto.minhafinancas.model.entity.Usuario;
import com.projeto.minhafinancas.model.repository.UsuarioRepository;
import com.projeto.minhafinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.repository = usuarioRepository;
	}
	
	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarEmail(String email) {
		Boolean exists = repository.existsByEmail(email);
		if(exists) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}
		
	}
	
	
	
	

}
