package br.com.starlog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import br.com.starlog.exception.CapacidadeExcedidaException;

public class ModuloCarga {
    private String idModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;

    public ModuloCarga(String idModulo, int capacidadeMaxima) {
        if (idModulo == null || idModulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Id do modulo nao pode ser nulo ou vazio.");
        }
        if (capacidadeMaxima < 0) {
            throw new IllegalArgumentException("Capacidade maxima nao pode ser negativa.");
        }
        this.idModulo = idModulo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.cargas = new ArrayList<>();
    }

    public String getIdModulo() { return idModulo; }

    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException {
        if (this.cargas.size() >= this.capacidadeMaxima) {
            throw new CapacidadeExcedidaException("Capacidade maxima de " + this.capacidadeMaxima
                    + " atingida no modulo " + this.idModulo);
        }
        this.cargas.add(Objects.requireNonNull(carga, "Carga nao pode ser nula."));
    }

    // Relatorios declarativos: sem for e sem if nestes tres metodos.
    public double calcularSeguroTotal() {
        return cargas.stream().mapToDouble(Carga::getValorSeguro).sum();
    }

    public long contarPorCategoria(String categoria) {
        return cargas.stream()
                .filter(carga -> Objects.equals(carga.getCategoria(), categoria))
                .count();
    }

    public double calcularSeguroPesadas(double pesoCorte) {
        return cargas.stream()
                .filter(carga -> carga.getPesoKg() > pesoCorte)
                .mapToDouble(Carga::getValorSeguro)
                .sum();
    }
}
