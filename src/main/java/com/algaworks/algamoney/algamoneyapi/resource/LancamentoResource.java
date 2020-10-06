package com.algaworks.algamoney.algamoneyapi.resource;

import com.algaworks.algamoney.algamoneyapi.model.Lancamento;
import com.algaworks.algamoney.algamoneyapi.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping
    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscarPeloCodigo (@PathVariable Long codigo) {
        return lancamentoRepository.findById(codigo)
                .map(lancamento -> ResponseEntity.ok(lancamento))
                .orElse(ResponseEntity.notFound().build());
    }
}
