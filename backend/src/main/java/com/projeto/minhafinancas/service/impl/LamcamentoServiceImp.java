package com.projeto.minhafinancas.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.minhafinancas.model.entity.Lancamento;
import com.projeto.minhafinancas.model.enums.StatusLancamento;
import com.projeto.minhafinancas.model.repository.LancamentoRepository;
import com.projeto.minhafinancas.service.LancamentoService;

@Service
public class LamcamentoServiceImp implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	@Transactional
	public Lancamento salvar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	@Override
	@Transactional
	public Lancamento atualizar(Lancamento lancamento) {

		Objects.requireNonNull(lancamento.getId());
		return lancamentoRepository.save(lancamento);
	}

	@Override
	@Transactional
	public void deletar(Lancamento lancamento) {
		Objects.requireNonNull(lancamento.getId());
		lancamentoRepository.delete(lancamento);

	}

	@Override
	public List<Lancamento> buscar(Lancamento lancamentoFiltro) {
	
		
		
		return null;
	}

	@Override
	public void atualizarStatus(Lancamento lancamento, StatusLancamento status) {
		lancamento.setStatus(status);
		atualizar(lancamento);

	}

}
