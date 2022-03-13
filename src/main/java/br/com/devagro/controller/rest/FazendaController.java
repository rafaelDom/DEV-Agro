package br.com.devagro.controller.rest;

import br.com.devagro.service.FazendaService;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import br.com.devagro.controller.dto.FazendaDto;
import br.com.devagro.model.Empresa;
import br.com.devagro.model.Fazenda;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {
    private FazendaService service;

    public FazendaController(FazendaService service){
        this.service = service;
    }

    @GetMapping
    public String fazenda(){
        return "Fazenda";
    }

    @GetMapping("/todas")
    public List<Fazenda> listarFazendas(){
        return service.listaFazendas();
    }

    @PostMapping
    public Fazenda adicionaFazenda(@RequestBody @Valid FazendaDto fazendaDto){
        return service.adicionaFazenda(fazendaDto.converter());
    }

    @PutMapping("/{id}")
    public Fazenda atualizarFazenda(@PathVariable Long id,@RequestBody @Valid FazendaDto fazendaDto){
        return service.atualizaFazenda(id, fazendaDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarFazenda(@PathVariable Long id){
        service.deletaFazenda(id);
    }
    
	@GetMapping("/todasFazendasDaEmpresaID")
	public List<Fazenda> listarFazendasEmpresa(@RequestBody Empresa empresa) {
		return service.listaFazendasEmpresa(empresa);
	}
	
	@GetMapping("/qtdeFazendasPorEmpresa")
	public Integer qtdeFazendasPorEmpresa(@RequestBody Empresa empresa) {
		return service.qtdeFazendasPorEmpresa(empresa);
	}
	
	@GetMapping("/listaFazendaProximaColheita")
	public <T> List<T> listaFazendaProximaColheita(@RequestBody Empresa empresa){
		return service.listFarmsNextHarvest(empresa);
		
	}
	
	@PutMapping("/registrarColheita")
	public String regitraColheita( @RequestParam Long id, @RequestParam("dataColheita") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataColheita, @RequestParam Double qtdeAumentarEstoque) {
		return "Quantidade de registro atualizado: " + service.registerHarvestFarm(id, dataColheita, qtdeAumentarEstoque);
	}
	
	@PutMapping("/removerGrao")
    public String retirarGrao(@RequestParam Long id, @RequestParam Double qtdeRemoverEstoque) {
		return "Quantidade de registro atualizado: " + service	.removeGrain(id, qtdeRemoverEstoque);

    }
}
