package com.projeto.minhafinancas.model.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.projeto.minhafinancas.model.entity.Usuario;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)	
public class UsuarioRepositoryTest {
	
	@Autowired
	public UsuarioRepository repository;
	
	@Autowired
	TestEntityManager entityMenage;
	
	@Test
	public void deveVerificarAExistenciaDeEmail() {
		
		//Cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		entityMenage.persist(usuario);
		
		//Ação
		Boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertTrue(result);
		
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
		
		//Ação
		Boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertFalse(result);
				
	}
	
	
	

	

}
