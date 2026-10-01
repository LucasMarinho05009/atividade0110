package br.com.starlog.model;

/** Carga identificada exclusivamente pelo codigo de rastreio. */
public class Carga {
    private final String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) {
        // Todas as validacoes ocorrem antes de atribuir os atributos.
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()) {
            throw new IllegalArgumentException("Codigo de rastreio da carga nao pode ser nulo ou vazio.");
        }
        if (!(pesoKg > 0) || !Double.isFinite(pesoKg)) {
            throw new IllegalArgumentException("Peso da carga deve ser maior que zero e finito.");
        }
        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    public String getCodigoRastreio() { return codigoRastreio; }
    public String getCategoria() { return categoria; }
    public double getPesoKg() { return pesoKg; }
    public double getValorSeguro() { return valorSeguro; }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) { return true; }
        if (objeto == null || getClass() != objeto.getClass()) { return false; }
        Carga outra = (Carga) objeto;
        return codigoRastreio.equals(outra.codigoRastreio);
    }

    @Override
    public int hashCode() {
        return codigoRastreio.hashCode();
    }

    @Override
    public String toString() {
        return "Carga [rastreio=" + codigoRastreio + ", categoria=" + categoria
                + ", peso=" + pesoKg + "kg, seguro=R$ " + valorSeguro + "]";
    }
}
