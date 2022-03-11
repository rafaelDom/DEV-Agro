package br.com.devagro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devagro.model.Empresa;
import br.com.devagro.repository.EmpresaRepository;

@Service
public class EmpresaService {
	 private final EmpresaRepository repository;

	    public EmpresaService(EmpresaRepository repository) {
	        this.repository = repository;
	    }

	    public List<Empresa> listaEmpresas(){
	        return (List<Empresa>) repository.findAll();
	    }

	    public Empresa adicionaEmpresa(Empresa empresa){
	        return repository.save(empresa);
	    }

	    public Empresa atualizaEmpresa(Long id, Empresa empresa){
	    	Empresa empresaAtualizado = repository.findById(id).get();
	    	empresaAtualizado.setNome(empresa.getNome());
	    	empresaAtualizado.setCnpj(empresa.getCnpj());
	    	empresaAtualizado.setEndereco(empresa.getEndereco());
	    	empresaAtualizado.setFazendas(empresa.getFazendas());
	    	empresaAtualizado.setFuncionarios(empresa.getFuncionarios());
	    	empresaAtualizado.setGraos(empresa.getGraos());
	    	
	        return repository.save(empresaAtualizado);
	    }

	    public void deletaEmpresa(Long id){
	        repository.deleteById(id);
	    }
}
