package br.com.conversor_moedas.conversorMoedas;

import br.com.conversor_moedas.servico.ServicoDeCambio;
import org.json.JSONObject;

public class ConverteMoedasParaReais {

    private final JSONObject taxasDeCambio;

    public ConverteMoedasParaReais() {
        ServicoDeCambio servico = new ServicoDeCambio();
        this.taxasDeCambio = servico.buscarTaxasDeCambio("USD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,CLP-BRL");
    }

    public double converterDolaresParaReais(double valorRecebido) {
        return convert("USDBRL", valorRecebido);
    }

    public double converterEurosParaReais(double valorRecebido) {
        return convert("EURBRL", valorRecebido);
    }

    public double converterLibrasParaReais(double valorRecebido) {
        return convert("GBPBRL", valorRecebido);
    }

    public double converterPesosArgentinosParaReais(double valorRecebido) {
        return convert("ARSBRL", valorRecebido);
    }

    public double converterPesosChilenosParaReais(double valorRecebido) {
        return convert("CLPBRL", valorRecebido);
    }

    private double convert(String currencyPair, double valorRecebido) {
        double taxa = taxasDeCambio.getJSONObject(currencyPair).getDouble("ask");
        return (double) Math.round(valorRecebido * taxa * 100d) / 100;
    }
}