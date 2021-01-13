package com.projeto.minhafinancas.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.minhafinancas.exception.ErroAutenticacao;
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
		
		Optional<Usuario> usuario = repository.findByEmail(email);
		System.out.print("teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeete");
		if (!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado");
		}

		if (!usuario.get().getSenha().equals(senha)) {

			throw new ErroAutenticacao("Senha inválida");
		}

		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		Boolean exists = repository.existsByEmail(email);
		if (exists) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}

	}

}
