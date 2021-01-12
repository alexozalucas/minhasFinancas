package com.projeto.minhafinancas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.projeto.minhafinancas.exception.RegraNegocioException;
import com.projeto.minhafinancas.model.entity.Usuario;
import com.projeto.minhafinancas.model.repository.UsuarioRepository;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;

	@Autowired
	UsuarioRepository repository;
	


	@Test
	public void deveValidarEmail() {

		// cenario
		repository.deleteAll();
		

		service.validarEmail("email@email.com.br");

	}

	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
					
		//cenario
		Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com.br").build();
		repository.save(usuario) ;	
		
				
		Exception exception = assertThrows(RegraNegocioException.class, () ->
		 	this.service.validarEmail("email@email.com.br"));
	
		assertEquals(RegraNegocioException.class,exception.getClass());
		 
		
	}

}
