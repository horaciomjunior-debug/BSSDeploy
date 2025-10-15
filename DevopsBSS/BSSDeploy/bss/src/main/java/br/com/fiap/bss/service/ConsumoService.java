package br.com.fiap.bss.service;

import br.com.fiap.bss.model.ConsumoEnergia;
import br.com.fiap.bss.model.Equipamento;
import br.com.fiap.bss.repository.ConsumoEnergiaRepository;
import br.com.fiap.bss.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumoService {

    private final ConsumoEnergiaRepository consumoRepo;
    private final EquipamentoRepository equipamentoRepo;

    public ConsumoService(ConsumoEnergiaRepository consumoRepo, EquipamentoRepository equipamentoRepo) {
        this.consumoRepo = consumoRepo;
        this.equipamentoRepo = equipamentoRepo;
    }

    public ConsumoEnergia registrarLeitura(Long idEquipamento, Double leituraKwh) {
        Equipamento equipamento = equipamentoRepo.findById(idEquipamento)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        ConsumoEnergia leitura = new ConsumoEnergia();
        leitura.setEquipamento(equipamento);
        leitura.setLeituraKwh(leituraKwh);

        return consumoRepo.save(leitura);
    }

    public List<ConsumoEnergia> listarPorEquipamento(Long idEquipamento) {
        Equipamento equipamento = equipamentoRepo.findById(idEquipamento)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        return consumoRepo.findByEquipamento(equipamento);
    }
}