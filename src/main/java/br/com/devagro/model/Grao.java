package br.com.devagro.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Empresa empresa;

	@Column(name = "tempo_medio_colheita_dias", nullable = false)
	private int tempoMedioColheitaDias;
	
}
