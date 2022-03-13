package br.com.devagro.controller.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Funcionario;
import br.com.devagro.model.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {
	@NotBlank
	private String nome;

	@NotBlank
	private String sobreNome;

	@NotBlank
	private String endereco;

	@Pattern(regexp="\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}?", message = "Campo CPF deve ser no formato XXX.XXX.XXX-XX")
	private String cpf;

	@Pattern(regexp="\\(\\d{2}\\)\\s*\\d{9}?", message = "Campo Telefone deve ser no formato (XX) XXXXXXXXX")
	private String telefone;

	@NotNull
	private Sexo sexo;

	@NotNull
	private Date dataNascimento;

	@NotNull
	private Date dataContratacao;

	private Empresa empresa;

	public Funcionario converter() {
		Funcionario funcionario = new Funcionario();

		funcionario.setNome(nome);
		funcionario.setSobreNome(sobreNome);
		funcionario.setEndereco(endereco);
		funcionario.setCpf(cpf);
		funcionario.setTelefone(telefone);
		funcionario.setSexo(sexo);
		funcionario.setDataNascimento(dataNascimento);
		funcionario.setDataContratacao(dataContratacao);
		funcionario.setEmpresa(empresa);

		return funcionario;
	}
}
