package com.inicializepag.inicializepag.controller;

import com.inicializepag.inicializepag.model.Pagamentos;
import com.inicializepag.inicializepag.repository.PagamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PagamentoController {

    @Autowired
    private PagamentosRepository pagamentosRepository;

    public PagamentoController(PagamentosRepository pagamentosRepository) {
        this.pagamentosRepository = pagamentosRepository;
    }

    @GetMapping(path = "/listar")
    public List<Pagamentos> listar() {
        return pagamentosRepository.findAll();
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamentos criar(@RequestBody Pagamentos pagamentos) {
        return pagamentosRepository.save(pagamentos);

    }

    @PutMapping("/atualizar/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamentos atualizar(@RequestBody Pagamentos pagamentosAtualizado, @PathVariable Long Id) {
        return pagamentosRepository.findById(Id)
                .map(pagamentos -> {
                    pagamentos.setForma(pagamentosAtualizado.getForma());
                    return pagamentosRepository.save(pagamentos);
                })
                .orElseGet(() -> pagamentosRepository.save(pagamentosAtualizado));
    }
}

