package br.com.devagro.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sobreNome", nullable = false)
	private String sobreNome;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Column(name = "telefone", nullable = false)
	private String telefone;

	@Column(name = "sexo", nullable = false)
	private Enum<Sexo> sexo;

	@Column(name = "data_nascimento")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date dataNascimento;

	@Column(name = "data_contratacao")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date dataContratacao;

	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName = "id")
	private Empresa empresa;
}
