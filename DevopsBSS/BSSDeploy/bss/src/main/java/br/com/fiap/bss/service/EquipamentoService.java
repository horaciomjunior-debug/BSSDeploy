package br.com.fiap.bss.service;

import br.com.fiap.bss.model.AlertaConsumo;
import br.com.fiap.bss.model.Equipamento;
import br.com.fiap.bss.repository.AlertaConsumoRepository;
import br.com.fiap.bss.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepo;
    private final AlertaConsumoRepository alertaRepo;

    public EquipamentoService(EquipamentoRepository equipamentoRepo, AlertaConsumoRepository alertaRepo) {
        this.equipamentoRepo = equipamentoRepo;
        this.alertaRepo = alertaRepo;
    }

    public Equipamento desligarEquipamento(Long id) {
        Equipamento equipamento = equipamentoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        equipamento.setStatus("desligado");
        equipamentoRepo.save(equipamento);

        AlertaConsumo alerta = new AlertaConsumo();
        alerta.setEquipamento(equipamento);
        alerta.setConsumoKwh(0.0);
        alerta.setStatus("ocioso - desligado");
        alertaRepo.save(alerta);

        return equipamento;
    }
}