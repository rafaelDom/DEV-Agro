package br.com.devagro.controller.rest;

import br.com.devagro.service.FazendaService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.devagro.controller.dto.FazendaDto;
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
    public Fazenda adicionarFazenda(@RequestBody FazendaDto fazendaDto){
        return service.adicionaFazenda(fazendaDto.converter());
    }

    @PutMapping("/{id}")
    public Fazenda atualizarFazenda(@PathVariable Long id,@RequestBody FazendaDto fazendaDto){
        return service.atualizaFazenda(id, fazendaDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarFazenda(@PathVariable Long id){
        service.deletaFazenda(id);
    }
}
