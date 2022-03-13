package br.com.devagro.controller.rest;

import br.com.devagro.service.EmpresaService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import br.com.devagro.controller.dto.EmpresaDto;
import br.com.devagro.model.Empresa;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	private EmpresaService service;

	public EmpresaController(EmpresaService service) {
		this.service = service;
	}

	@GetMapping
	public String empresa() {
		return "Empresa";
	}

	@GetMapping("/todas")
	public List<Empresa> listarEmpresas() {
		return service.listaEmpresas();
	}

	@PostMapping
	public Empresa adicionarEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
		return service.adicionaEmpresa(empresaDto.converter());
	}

	@PutMapping("/{id}")
	public Empresa atualizarEmpresa(@PathVariable Long id, @RequestBody @Valid EmpresaDto empresaDto) {
		return service.atualizaEmpresa(id, empresaDto.converter());
	}

	@DeleteMapping("/{id}")
	public void deletarEmpresa(@PathVariable Long id) {
		service.deletaEmpresa(id);
	}
	
}
