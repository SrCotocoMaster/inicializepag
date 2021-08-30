package com.inicializepag.inicializepag.repository;

import com.inicializepag.inicializepag.model.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentosRepository extends JpaRepository<Pagamentos,Long> {
}
