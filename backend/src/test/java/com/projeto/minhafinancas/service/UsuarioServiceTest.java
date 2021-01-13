package com.projeto.minhafinancas.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.projeto.minhafinancas.exception.ErroAutenticacao;
import com.projeto.minhafinancas.exception.RegraNegocioException;
import com.projeto.minhafinancas.model.entity.Usuario;
import com.projeto.minhafinancas.model.repository.UsuarioRepository;
import com.projeto.minhafinancas.service.impl.UsuarioServiceImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {


	@InjectMocks
	UsuarioServiceImpl service;

	@Mock
	UsuarioRepository repository;

	public void initMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deveSalvarUmUsuario() {

		
		
		Usuario usuario = Usuario.builder().id(1l).nome("teste").email("email@email.com.br").senha("123").build();
		service.validarEmail(usuario.getEmail());
	
		Mockito.when(repository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

		Usuario usuarioSalvo = service.salvarUsuario(usuario);

		Assertions.assertNotNull(usuarioSalvo);
		Assertions.assertEquals(usuarioSalvo.getId(), 1l);
		Assertions.assertEquals(usuarioSalvo.getNome(), "teste");
		Assertions.assertEquals(usuarioSalvo.getEmail(), "email@email.com.br");
		Assertions.assertEquals(usuarioSalvo.getSenha(), "123");

	}
	
	@Test
	public void NaoDeveSalvarUsuarioComEmailJaCadastrado() {
		
		/* TODO : teste ainda não implementado*/
		
		/*
		String email = "email@email.com.br";
		Usuario usuario = Usuario.builder().id(1l).nome("teste").email(email).senha("123").build();
		
		// Cenário		
		//Mockito.doThrow(RegraNegocioException.class).when(service).validarEmail(email);
		
			
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

		Exception exception = assertThrows(RegraNegocioException.class,
				() -> this.service.validarEmail("email@email.com.br"));
		

		//acao		
		service.salvarUsuario(usuario);
		
		//verificacao
		Mockito.verify(repository,Mockito.never()).save(usuario);
		*/
		/*Assertions.assertEquals(ErroAutenticacao.class, exception.getClass());
		Assertions.assertEquals(exception.getMessage(), "Usuário não encontrado");*/
		
		
		
	}
	
	

	@Test
	public void deveAutenticarUmUsuarioComSucesso() {

		// cenario
		String email = "email@email.com";
		String senha = "senha";
		Usuario usuario = Usuario.builder().email(email).senha(senha).id(1l).build();

		Mockito.when(repository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(usuario));

		// acao
		Usuario result = service.autenticar(email, senha);
		Assertions.assertNotNull(result);

	}

	@Test
	public void deveLancarErroQuandoNaoEncontrarUsuarioCadastradoComOEmailInformado() {

		// cenario
		Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());

		// acao
		Exception exception = assertThrows(ErroAutenticacao.class, () -> service.autenticar("email@email", "senha"));

		Assertions.assertEquals(ErroAutenticacao.class, exception.getClass());
		Assertions.assertEquals(exception.getMessage(), "Usuário não encontrado");
	}

	@Test
	public void deveLancarErroQuandoSenhaNaoBater() {

		// cenario

		String senha = "senha";
		Usuario usuario = Usuario.builder().email("email@email.com").senha(senha).id(1l).build();

		Mockito.when(repository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(usuario));

		// acao
		Exception exception = assertThrows(ErroAutenticacao.class, () -> service.autenticar("email@email", "123"));

		Assertions.assertEquals(ErroAutenticacao.class, exception.getClass());
		Assertions.assertEquals(exception.getMessage(), "Senha inválida");

	}

	@Test
	public void deveValidarEmail() {

		// Cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
		// acao
		service.validarEmail("email@email.com.br");

	}

	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {

		// Cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

		Exception exception = assertThrows(RegraNegocioException.class,
				() -> this.service.validarEmail("email@email.com.br"));

		Assertions.assertEquals(RegraNegocioException.class, exception.getClass());

	}

}
