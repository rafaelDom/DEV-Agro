package br.com.devagro.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fazenda")
public class Fazenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@OneToOne
	@JoinColumn(name = "id")
	private Grao grao;

	@Column(name = "estoque_inicial", nullable = false)
	private Double estoqueInicial;

	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName = "id")
	private Empresa empresa;

	@Column(name = "data_ultima_colheira")
	private Date dataUltimaColheita;

}
