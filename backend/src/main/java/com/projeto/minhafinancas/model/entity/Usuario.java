package com.projeto.minhafinancas.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projeto.minhafinancas.model.enums.StatusLancamento;
import com.projeto.minhafinancas.model.enums.Tipolancamento;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;



@Data
@Builder
@Entity
@Table( name ="usuario", schema ="financas")
public class Usuario {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="nome")
	private String nome;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="senha")
	private String senha;
	
	
	

}
