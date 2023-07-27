package br.com.conversor_moedas.servico;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoDeCambio {

    private static final String URL_BASE = "https://economia.awesomeapi.com.br/json/last/";
    private final HttpClient client = HttpClient.newHttpClient();

    public JSONObject buscarTaxasDeCambio(String moedas) {
        return buscarDados(URL_BASE + moedas);
    }

    private JSONObject buscarDados(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro ao buscar dados. Código de resposta: " + response.statusCode());
            }

            return new JSONObject(response.body());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados.", e);
        }
    }
}
