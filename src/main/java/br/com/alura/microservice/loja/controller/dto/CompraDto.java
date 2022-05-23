package br.com.alura.microservice.loja.controller.dto;

import java.util.List;

public class CompraDto {
	private List<ItemCompraDto> itens;
	private EnderecoDTO endereco;
	public List<ItemCompraDto> getItens() {
		return itens;
	}
	public void setItens(List<ItemCompraDto> itens) {
		this.itens = itens;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	

}
