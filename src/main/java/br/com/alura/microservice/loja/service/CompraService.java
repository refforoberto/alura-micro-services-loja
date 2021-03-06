package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDto;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate restTemplate;

	public String realizarCompra(CompraDto compra) {
		
		final String url = "http://fornecedor/info/" + compra.getEndereco().getEstado();
				
	    ResponseEntity<InfoFornecedorDTO> response = restTemplate.exchange(url, HttpMethod.GET, null, InfoFornecedorDTO.class);

	    return response.getBody().getEndereco();
		
	}
}
