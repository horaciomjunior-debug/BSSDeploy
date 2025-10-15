package br.com.fiap.bss.repository;
import br.com.fiap.bss.model.ConsumoEnergia;
import br.com.fiap.bss.model.Equipamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumoEnergiaRepository extends JpaRepository<ConsumoEnergia, Long> {
    List<ConsumoEnergia> findByEquipamento(Equipamento equipamento);
}