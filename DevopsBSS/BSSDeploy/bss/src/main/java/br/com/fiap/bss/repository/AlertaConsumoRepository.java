package br.com.fiap.bss.repository;
import br.com.fiap.bss.model.AlertaConsumo;
import br.com.fiap.bss.model.Equipamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaConsumoRepository extends JpaRepository<AlertaConsumo, Long> {
    List<AlertaConsumo> findByEquipamento(Equipamento equipamento);
}