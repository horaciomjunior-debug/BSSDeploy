package br.com.fiap.bss.controller;





import br.com.fiap.bss.model.Equipamento;
import br.com.fiap.bss.service.EquipamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PatchMapping("/{id}/desligar")
    public ResponseEntity<Equipamento> desligarEquipamento(@PathVariable Long id) {
        return ResponseEntity.ok(equipamentoService.desligarEquipamento(id));
    }
}