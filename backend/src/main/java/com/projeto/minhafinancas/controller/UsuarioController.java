package com.projeto.minhafinancas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.minhafinancas.api.dto.UsuarioDTO;
import com.projeto.minhafinancas.exception.RegraNegocioException;
import com.projeto.minhafinancas.model.entity.Usuario;
import com.projeto.minhafinancas.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	/*
	 * public UsuarioController(UsuarioService service) { this.service = service;
	 * 
	 * }
	 */
	@PostMapping
	public ResponseEntity salvar(@RequestBody UsuarioDTO dto) {

		Usuario usuario = Usuario.builder().email(dto.getEmail()).nome(dto.getNome()).senha(dto.getSenha()).build();

		try {
		Usuario usuarioSalvo = service.salvarUsuario(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
					
		
		}
		
		
		
		
	}

}
