package br.com.fiap.bss.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConsumoEnergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double leituraKwh;

    private LocalDateTime dataLeitura = LocalDateTime.now();

    @ManyToOne
    private Equipamento equipamento;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLeituraKwh() {
        return leituraKwh;
    }

    public void setLeituraKwh(Double leituraKwh) {
        this.leituraKwh = leituraKwh;
    }

    public LocalDateTime getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(LocalDateTime dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}