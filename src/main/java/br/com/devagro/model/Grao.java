package br.com.devagro.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grao")
public class Grao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName = "id")
	private Empresa empresa;

	@Column(name = "tempo_medio_colheira_dias", nullable = false)
	private int tempoMedioColheitaDias;
	
}
