package com.nyd.diobankline.service;

import com.nyd.diobankline.dto.NovaMovimentacaoDTO;
import com.nyd.diobankline.model.Correntista;
import com.nyd.diobankline.model.Movimentacao;
import com.nyd.diobankline.model.TipoMovimentacao;
import com.nyd.diobankline.repository.CorrentistaRepository;
import com.nyd.diobankline.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save (NovaMovimentacaoDTO novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getTipo() == TipoMovimentacao.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);

        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }

}
