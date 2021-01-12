package com.projeto.minhafinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.minhafinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}