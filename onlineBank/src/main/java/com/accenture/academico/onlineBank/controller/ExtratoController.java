package com.accenture.academico.onlineBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.onlineBank.exception.RegraNegocioException;
import com.accenture.academico.onlineBank.model.Extrato;
import com.accenture.academico.onlineBank.service.ExtratoService;


@RestController
public class ExtratoController {

	@Autowired
    private ExtratoService extratoService;

    @GetMapping("/extrato/{id}")
    private Extrato getExtrato(@PathVariable("id") int id) {
    	return extratoService.getExtratoById(id);
    }
    
    @GetMapping("/exibeExtrato/{contaCorrenteId}")
    private List<Extrato> getExtratoByCcId(@PathVariable("contaCorrenteId") Integer contaCorrenteId) {
    	return extratoService.getExtratoByContaCorrenteId(contaCorrenteId);
    }
    
    @DeleteMapping("/extrato/{id}")
    private void deleteExtrato(@PathVariable("id") int id) {
    	extratoService.delete(id);
    }

    @RequestMapping(value = "/extrato", method =  RequestMethod.POST)
    private long saveExtrato(@RequestBody Extrato extrato) throws RegraNegocioException {
        extratoService.saveOrUpdate(extrato);
        return extrato.getIdExtrato();
    }
}