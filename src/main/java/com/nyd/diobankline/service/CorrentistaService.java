package com.nyd.diobankline.service;

import com.nyd.diobankline.dto.NovoCorrentistaDTO;
import com.nyd.diobankline.model.Conta;
import com.nyd.diobankline.model.Correntista;
import com.nyd.diobankline.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {
    @Autowired
    private CorrentistaRepository repository;

    public void save (NovoCorrentistaDTO novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);

        repository.save(correntista);
    }
}
