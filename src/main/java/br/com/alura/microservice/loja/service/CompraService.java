package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.clients.FornecedorClient;
import br.com.alura.microservice.loja.clients.FornecedorDTO;
import br.com.alura.microservice.loja.controller.dto.CompraDto;

@Service
public class CompraService {
	@Autowired
	private DiscoveryClient eurekaClient;
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public String realizarCompra(CompraDto compra) {

		ResponseEntity<FornecedorDTO> response = fornecedorClient
				.obterInformacoesPorEstado(compra.getEndereco().getEstado());

		eurekaClient.getInstances("fornecedor")//
				.stream()//
				.map(ServiceInstance::getPort)//
				.forEach(System.out::println);
		
		
		return response.getBody().getEndereco();
		
	}
}
