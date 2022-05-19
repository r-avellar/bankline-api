package com.nyd.diobankline.controller;

import com.nyd.diobankline.dto.NovaMovimentacaoDTO;
import com.nyd.diobankline.model.Movimentacao;
import com.nyd.diobankline.repository.CorrentistaRepository;
import com.nyd.diobankline.repository.MovimentacaoRepository;
import com.nyd.diobankline.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findMovimentacoesByCorrentista(@PathVariable("idConta") Integer idConta){
        return repository.findByIdConta(idConta);
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacaoDTO movimentacao){
        service.save(movimentacao);
    }
}
