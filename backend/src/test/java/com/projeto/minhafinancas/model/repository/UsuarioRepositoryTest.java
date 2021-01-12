package com.projeto.minhafinancas.model.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.projeto.minhafinancas.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	@Autowired
	public UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeEmail() {
		
		//Cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);
		
		//Ação
		Boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertTrue(result);
		
		
	}
	

	

}
