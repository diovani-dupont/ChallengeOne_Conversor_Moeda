package br.com.conversor_moedas.conversorMoedas;

import br.com.conversor_moedas.servico.ServicoDeCambio;
import org.json.JSONObject;

public class ConverteMoedas {

    private final JSONObject taxasDeCambio;

    public ConverteMoedas() {
        ServicoDeCambio servico = new ServicoDeCambio();
        this.taxasDeCambio = servico.buscarTaxasDeCambio("USD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,CLP-BRL");
    }

    public double converterReaisParaDolares(double valorRecebido) {
        double taxa = taxasDeCambio.getJSONObject("USDBRL").getDouble("ask");
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    public double converterReaisParaEuros(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("EURBRL").getDouble("ask");
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    public double converterReaisParaLibras(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("GBPBRL").getDouble("ask");
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    public double converterReaisParaPesosArgentinos(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("ARSBRL").getDouble("ask");
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }

    public double converterReaisParaPesosChilenos(double valorRecebido){
        double taxa = taxasDeCambio.getJSONObject("CLPBRL").getDouble("ask");
        return (double) Math.round((valorRecebido / taxa) * 100d) / 100;
    }
}