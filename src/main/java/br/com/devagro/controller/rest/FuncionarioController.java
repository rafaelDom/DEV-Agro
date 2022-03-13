package br.com.devagro.controller.rest;

import br.com.devagro.service.FuncionarioService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import br.com.devagro.controller.dto.FuncionarioDto;
import br.com.devagro.model.Empresa;
import br.com.devagro.model.Funcionario;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @GetMapping
    public String funcionario(){
        return "Funcionario";
    }

    @GetMapping("/todas")
    public List<Funcionario> listarFuncionarios(){
        return service.listaFuncionarios();
    }

    @PostMapping
    public Funcionario adicionarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto){
        return service.adicionaFuncionario(funcionarioDto.converter());
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id,@RequestBody @Valid FuncionarioDto funcionarioDto){
        return service.atualizaFuncionario(id, funcionarioDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id){
        service.deletaFuncionario(id);
    }
    
	@GetMapping("/todosFuncionariosEmpresa")
	public List<Funcionario> listarFazendasEmpresa(@RequestBody Empresa empresa) {
		return service.findAllByFuncionarios(empresa);
	}
	
	@GetMapping("/qtdeFuncionariosPorEmpresa")
	public Integer qtdeFuncionariosPorEmpresa(@RequestBody Empresa empresa) {
		return service.qtdeFuncionariosPorEmpresa(empresa);
	}
	
}
