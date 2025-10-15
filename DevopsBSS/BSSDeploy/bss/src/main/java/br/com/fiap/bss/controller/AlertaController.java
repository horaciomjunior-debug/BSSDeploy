package br.com.fiap.bss.controller;


import br.com.fiap.bss.model.AlertaConsumo;
import br.com.fiap.bss.service.AlertaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<AlertaConsumo> criar(@RequestParam Long equipamentoId, @RequestParam Double consumo) {
        return ResponseEntity.ok(alertaService.criarAlerta(equipamentoId, consumo));
    }

    @GetMapping("/equipamento/{id}")
    public ResponseEntity<List<AlertaConsumo>> listarPorEquipamento(@PathVariable Long id) {
        return ResponseEntity.ok(alertaService.listarPorEquipamento(id));
    }
}