package com.algaworks.algamoney.algamoneyapi.repository;

import com.algaworks.algamoney.algamoneyapi.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
