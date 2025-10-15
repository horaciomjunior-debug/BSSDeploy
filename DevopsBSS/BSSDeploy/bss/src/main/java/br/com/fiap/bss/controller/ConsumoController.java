package br.com.fiap.bss.controller;



import br.com.fiap.bss.model.ConsumoEnergia;
import br.com.fiap.bss.service.ConsumoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo")
public class ConsumoController {

    private final ConsumoService consumoService;

    public ConsumoController(ConsumoService consumoService) {
        this.consumoService = consumoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ConsumoEnergia> registrarLeitura(@RequestParam Long equipamentoId, @RequestParam Double leituraKwh) {
        return ResponseEntity.ok(consumoService.registrarLeitura(equipamentoId, leituraKwh));
    }

    @GetMapping("/equipamento/{id}")
    public ResponseEntity<List<ConsumoEnergia>> listarPorEquipamento(@PathVariable Long id) {
        return ResponseEntity.ok(consumoService.listarPorEquipamento(id));
    }
}