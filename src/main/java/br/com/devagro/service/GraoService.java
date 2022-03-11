package br.com.devagro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devagro.model.Grao;
import br.com.devagro.repository.GraoRepository;


@Service
public class GraoService {
	 private final GraoRepository repository;

	    public GraoService(GraoRepository repository) {
	        this.repository = repository;
	    }

	    public List<Grao> listaGraos(){
	        return (List<Grao>) repository.findAll();
	    }

	    public Grao adicionaGrao(Grao grao){
	        return repository.save(grao);
	    }

	    public Grao atualizaGrao(Long id, Grao grao){
	    	Grao graoAtualizado = repository.findById(id).get();
	    	graoAtualizado.setNome(grao.getNome());
	    	graoAtualizado.setEmpresa(grao.getEmpresa());
	    	graoAtualizado.setTempoMedioColheitaDias(grao.getTempoMedioColheitaDias());
	    	
	        return repository.save(graoAtualizado);
	    }

	    public void deletaGrao(Long id){
	        repository.deleteById(id);
	    }
}
