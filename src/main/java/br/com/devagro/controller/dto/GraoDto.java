package br.com.devagro.controller.dto;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Grao;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GraoDto {
	@NotBlank
	private String nome;
	
	@NotNull
	private Empresa empresa;
	
	@NotNull
	private int tempoMedioColheitaDias;
	
	
    public Grao converter(){
    	Grao grao = new Grao();
    	grao.setNome(nome);
    	grao.setEmpresa(empresa);
    	grao.setTempoMedioColheitaDias(tempoMedioColheitaDias);

        return grao;
    }
}
