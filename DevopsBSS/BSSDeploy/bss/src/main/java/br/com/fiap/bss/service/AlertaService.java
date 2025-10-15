package br.com.fiap.bss.service;


import org.springframework.stereotype.Service;



import br.com.fiap.bss.model.AlertaConsumo;
import br.com.fiap.bss.model.Equipamento;
import br.com.fiap.bss.repository.AlertaConsumoRepository;
import br.com.fiap.bss.repository.EquipamentoRepository;
import java.util.List;

@Service
public class AlertaService {

    private final AlertaConsumoRepository alertaRepo;
    private final EquipamentoRepository equipamentoRepo;

    public AlertaService(AlertaConsumoRepository alertaRepo, EquipamentoRepository equipamentoRepo) {
        this.alertaRepo = alertaRepo;
        this.equipamentoRepo = equipamentoRepo;
    }

    public AlertaConsumo criarAlerta(Long idEquipamento, Double consumo) {
        Equipamento equipamento = equipamentoRepo.findById(idEquipamento)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        AlertaConsumo alerta = new AlertaConsumo();
        alerta.setEquipamento(equipamento);
        alerta.setConsumoKwh(consumo);

        return alertaRepo.save(alerta);
    }

    public List<AlertaConsumo> listarPorEquipamento(Long idEquipamento) {
        Equipamento equipamento = equipamentoRepo.findById(idEquipamento)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        return alertaRepo.findByEquipamento(equipamento);
    }
}