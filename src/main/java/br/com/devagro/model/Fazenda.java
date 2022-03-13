package br.com.devagro.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JoinColumn(name = "id_grao", referencedColumnName = "id")
	@JsonIgnore
	private Grao grao;

	@Column(name = "estoque_inicial", nullable = false)
	private Double estoqueInicial;

	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName = "id")
	@JsonIgnore
	private Empresa empresa;

	@Column(name = "data_ultima_colheita")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataUltimaColheita;

}
