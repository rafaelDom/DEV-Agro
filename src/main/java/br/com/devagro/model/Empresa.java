package br.com.devagro.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@OneToMany
	@JoinColumn(name="id_empresa")
	private List<Fazenda> fazendas;

	@OneToMany
	@JoinColumn(name="id_empresa")
	private List<Funcionario> funcionarios;

	@OneToMany
	@JoinColumn(name="id_empresa")
	private List<Grao> graos;

}
