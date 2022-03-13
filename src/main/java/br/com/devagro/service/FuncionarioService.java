package br.com.devagro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devagro.model.Empresa;
import br.com.devagro.model.Funcionario;
import br.com.devagro.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	 private final FuncionarioRepository repository;

	    public FuncionarioService(FuncionarioRepository repository) {
	        this.repository = repository;
	    }

	    public List<Funcionario> listaFuncionarios(){
	        return (List<Funcionario>) repository.findAll();
	    }

	    public Funcionario adicionaFuncionario(Funcionario funcionario){
	        return repository.save(funcionario);
	    }

	    public Funcionario atualizaFuncionario(Long id, Funcionario funcionario){
	    	Funcionario funcionarioaAtualizado = repository.findById(id).get();
	    	funcionarioaAtualizado.setNome(funcionario.getNome());
	    	funcionarioaAtualizado.setSobreNome(funcionario.getSobreNome());
	    	funcionarioaAtualizado.setEndereco(funcionario.getEndereco());
	    	funcionarioaAtualizado.setCpf(funcionario.getCpf());
	    	funcionarioaAtualizado.setTelefone(funcionario.getTelefone());
	    	funcionarioaAtualizado.setSexo(funcionario.getSexo());
	    	funcionarioaAtualizado.setDataNascimento(funcionario.getDataNascimento());
	    	funcionarioaAtualizado.setDataContratacao(funcionario.getDataContratacao());
	    	funcionarioaAtualizado.setEmpresa(funcionario.getEmpresa());
	        return repository.save(funcionarioaAtualizado);
	    }

	    public void deletaFuncionario(Long id){
	        repository.deleteById(id);
	    }
	    
	    public List<Funcionario> findAllByFuncionarios(Empresa empresa){
	    	return repository.findAllByFuncionarios(empresa);
	    }
	    
	    public Integer qtdeFuncionariosPorEmpresa(Empresa empresa) {
	    	return repository.numberMmployeesByCompany(empresa);
	    }
}
