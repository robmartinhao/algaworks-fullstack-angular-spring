package com.algaworks.algamoney.algamoneyapi.service;

import com.algaworks.algamoney.algamoneyapi.model.Lancamento;
import com.algaworks.algamoney.algamoneyapi.repository.LancamentoRepository;
import com.algaworks.algamoney.algamoneyapi.repository.PessoaRepository;
import com.algaworks.algamoney.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;


    public Lancamento salvar(Lancamento lancamento) {

        pessoaRepository.findById(lancamento.getPessoa().getCodigo())
                .filter(p -> !p.isInativo())
                .orElseThrow(() -> new PessoaInexistenteOuInativaException());

        return lancamentoRepository.save(lancamento);
    }
}
