package com.projeto.minhafinancas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.minhafinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	Boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
	
}
