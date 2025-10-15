package br.com.fiap.bss.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String localizacao;

    private String status;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsumoEnergia> consumos;

    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertaConsumo> alertas;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ConsumoEnergia> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<ConsumoEnergia> consumos) {
        this.consumos = consumos;
    }

    public List<AlertaConsumo> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<AlertaConsumo> alertas) {
        this.alertas = alertas;
    }
}