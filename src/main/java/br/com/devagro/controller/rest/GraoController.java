package br.com.devagro.controller.rest;

import br.com.devagro.service.GraoService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import br.com.devagro.controller.dto.GraoDto;
import br.com.devagro.model.Empresa;
import br.com.devagro.model.Grao;

@RestController
@RequestMapping("/grao")
public class GraoController {
    private GraoService service;

    public GraoController(GraoService service){
        this.service = service;
    }

    @GetMapping
    public String grao(){
        return "Grao";
    }

    @GetMapping("/todos")
    public List<Grao> listarGraos(){
        return service.listaGraos();
    }

    @PostMapping
    public Grao adicionarGrao(@RequestBody @Valid  GraoDto graoDto){
        return service.adicionaGrao(graoDto.converter());
    }

    @PutMapping("/{id}")
    public Grao atualizarGrao(@PathVariable Long id,@RequestBody @Valid GraoDto graoDto){
        return service.atualizaGrao(id, graoDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarGrao(@PathVariable Long id){
        service.deletaGrao(id);
    }
    
	@GetMapping("/todosGraosEmpresa")
	public List<Grao> listarFazendasEmpresa(@RequestBody Empresa empresa) {
		return service.listaGraoEmpresa(empresa);
	}
	
	@GetMapping("/listaGraoEmpresa")
	public <T> List<T> listaGraoEmpresa(@RequestBody Empresa empresa){
		return service.companyGrades(empresa);
		
	}
}
