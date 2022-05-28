package br.com.alura.microservice.loja.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor")
public interface FornecedorClient {
	@RequestMapping("/info/{estado}")
	ResponseEntity<FornecedorDTO> obterInformacoesPorEstado(@PathVariable String estado);
}
