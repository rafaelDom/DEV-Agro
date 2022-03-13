package br.com.devagro.controller.dto;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Fazenda;
import br.com.devagro.model.Funcionario;
import br.com.devagro.model.Grao;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class EmpresaDto {
	
	@NotBlank
	private String nome;

	@Pattern(regexp="\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}?", message = "Campo CNPJ deve ser no formato XX.XXX.XXX/XXXX-XX")
	private String cnpj;

	@NotBlank
	private String endereco;

	
	private List<Fazenda> fazendas;


	private List<Funcionario> funcionarios;


	private List<Grao> graos;
	
	public Empresa converter(){
    	Empresa empresa = new Empresa();
    	empresa.setNome(nome);
    	empresa.setCnpj(cnpj);
    	empresa.setEndereco(endereco);
    	empresa.setFazendas(fazendas);
    	empresa.setFuncionarios(funcionarios);
    	empresa.setGraos(graos);

        return empresa;
    }
}
