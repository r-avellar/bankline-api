package com.nyd.diobankline.controller;

import com.nyd.diobankline.dto.NovoCorrentistaDTO;
import com.nyd.diobankline.model.Correntista;
import com.nyd.diobankline.repository.CorrentistaRepository;
import com.nyd.diobankline.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;
    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }
    @PostMapping
    public void save(@RequestBody NovoCorrentistaDTO correntista){
        service.save(correntista);
    }

}
