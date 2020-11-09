package com.algaworks.algamoney.algamoneyapi.service;

import com.algaworks.algamoney.algamoneyapi.model.Lancamento;
import com.algaworks.algamoney.algamoneyapi.model.Pessoa;
import com.algaworks.algamoney.algamoneyapi.repository.LancamentoRepository;
import com.algaworks.algamoney.algamoneyapi.repository.PessoaRepository;
import com.algaworks.algamoney.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = buscarLancamentoExitente(codigo);

        Optional.ofNullable(lancamento).map(Lancamento::getPessoa)
                .filter(
                    pessoa -> pessoa.getCodigo().equals(lancamentoSalvo.getPessoa().getCodigo()) && !lancamentoSalvo.getPessoa().isInativo())
                .orElseThrow(PessoaInexistenteOuInativaException::new);

        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");

        return lancamentoRepository.save(lancamentoSalvo);
    }

    private Lancamento buscarLancamentoExitente(Long codigo) {
        return lancamentoRepository.findById(codigo).orElseThrow(IllegalArgumentException::new);
    }
}
