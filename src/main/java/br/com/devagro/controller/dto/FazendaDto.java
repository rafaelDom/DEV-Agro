package br.com.devagro.controller.dto;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Fazenda;
import br.com.devagro.model.Grao;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FazendaDto {

	@NotBlank
	private String nome;

	@NotBlank
	private String endereco;

	private Grao grao;

	@NotBlank
	private Double estoqueInicial;

	private Empresa empresa;

	private Date dataUltimaColheita;

	public Fazenda converter() {
		Fazenda fazenda = new Fazenda();
		fazenda.setNome(nome);
		fazenda.setEndereco(endereco);
		fazenda.setGrao(grao);
		fazenda.setEstoqueInicial(estoqueInicial);
		fazenda.setEmpresa(empresa);
		fazenda.setDataUltimaColheita(dataUltimaColheita);

		return fazenda;
	}
}
