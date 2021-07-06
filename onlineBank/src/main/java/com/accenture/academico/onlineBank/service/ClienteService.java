package com.accenture.academico.onlineBank.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.academico.onlineBank.model.Cliente;
import com.accenture.academico.onlineBank.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clienteRepository.findAll().forEach(cliente -> clientes.add(cliente));
		
		ModelAndView modelAndView = new ModelAndView("clientes");		
		modelAndView.addObject("clientes", clientes);
		
		return clientes;
	}
	
	public Cliente getClienteById(int id) {
		return clienteRepository.findById(id).get();
	}
	
	public Cliente saveOrUpdate(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(int id) {
		clienteRepository.deleteById(id);
	}
	
	public static boolean isCPF(String strCpf) {
		
		String cpf = converteCpf(strCpf);
		
		if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            (cpf.length() != 11)) {
			return(false);
		}    

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
            	num = (int)(cpf.charAt(i) - 48);
            	sm = sm + (num * peso);
            	peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
            	dig10 = '0';
            } else {
            	dig10 = (char)(r + 48);
            }

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            	num = (int)(cpf.charAt(i) - 48);
            	sm = sm + (num * peso);
            	peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
            	dig11 = '0';
            } else {
            	dig11 = (char)(r + 48);
            }

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
            	return(true);
            } else {
            	return(false);
            }
        } catch (InputMismatchException erro) {
                return(false);
        }
	}

	public static String imprimeCPF(String strCpf) {
        	
		String cpf = converteCpf(strCpf);
        	
		return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
				cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
	}
        
	private static String converteCpf(String cpf) {
    		
		if(cpf.length() == 14) {
			String cpf1 = cpf.substring(0, 3);
			String cpf2 = cpf.substring(4, 7);
			String cpf3 = cpf.substring(8, 11);
			String cpf4 = cpf.substring(12, 14);
    			
			String cpfSemPontuacao = cpf1 + cpf2 + cpf3 + cpf4;
    			
			cpf = cpfSemPontuacao;
		}
    		
		return cpf;
	}

}
