package com.projeto.minhafinancas.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.projeto.minhafinancas.model.enums.StatusLancamento;
import com.projeto.minhafinancas.model.enums.Tipolancamento;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table( name ="lancamento", schema ="financas")
public class Lancamento {
	
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="mes")
	private String mes;
	
	@Column(name ="descricao")
	private String descricao;
	
	@Column(name ="ano")
	private Integer ano;
	
	@Column(name ="id_usuario")
	private String senha;
	
	@Column(name ="valor")
	private BigDecimal valor;
	
	@Column(name ="data_cadastro")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataCadastro;
	
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private Tipolancamento tipo;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private StatusLancamento status;
	
	
	
	
	

}
