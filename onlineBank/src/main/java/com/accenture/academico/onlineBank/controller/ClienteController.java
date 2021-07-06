package com.accenture.academico.onlineBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.onlineBank.model.Cliente;
import com.accenture.academico.onlineBank.service.ClienteService;

@RestController
@RequestMapping ("/clientes")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }
    
    @GetMapping("/buscar/{id}")
    public Cliente getCliente(@PathVariable("id") int id) {
    	return clienteService.getClienteById(id);
    }
    
    @DeleteMapping("/remover/{id}")
    public void deleteCliente(@PathVariable("id") int id) {
    	clienteService.delete(id);
    }

    @PostMapping("/adiciona")
    public int saveCliente(@RequestBody Cliente cliente) {
		clienteService.saveOrUpdate(cliente);
		return cliente.getIdCliente();
    }
    
    @PutMapping("/atualizar")
    public Cliente updateCliente(@RequestBody Cliente cliente) {
    	return clienteService.saveOrUpdate(cliente);
    }
    
}
