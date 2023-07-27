package br.com.conversor_moedas.principal;

import br.com.conversor_moedas.conversorMoedas.Funcao;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import java.util.Map;

public class PrincipalController {

    @FXML
    private ComboBox<String> comboBoxMoedaDe;

    @FXML
    private ComboBox<String> comboBoxMoedaPara;

    @FXML
    private TextField InsereValor;

    @FXML
    private Button BotaoConversao;

    @FXML
    private Label ResultadoConversao;

    @FXML
    private ComboBox<String> ConverteTaxa;

    @FXML
    private Button BotaoTaxa;

    @FXML
    private Label ResultadoTaxa;

    @FXML
    private Button BotaoSair;

    private Map<String, String> moedaToImagePath = Map.of(
            "Reais", "/br/com/conversor_moedas/img/br.png",
            "Dólares", "/br/com/conversor_moedas/img/eua.png",
            "Euros", "/br/com/conversor_moedas/img/eur.png",
            "Libras", "/br/com/conversor_moedas/img/gbp.png",
            "Peso Argentino", "/br/com/conversor_moedas/img/ars.png",
            "Peso Chileno", "/br/com/conversor_moedas/img/clp.png"
    );

    @FXML
    private void initialize() {
        comboBoxMoedaDe.setCellFactory(param -> new MoedaListCell(moedaToImagePath));
        comboBoxMoedaDe.setButtonCell(new MoedaListCell(moedaToImagePath));

        comboBoxMoedaPara.setCellFactory(param -> new MoedaListCell(moedaToImagePath));
        comboBoxMoedaPara.setButtonCell(new MoedaListCell(moedaToImagePath));

        comboBoxMoedaDe.getItems().addAll(
                "Reais",
                "Dólares",
                "Euros",
                "Libras",
                "Peso Argentino",
                "Peso Chileno"
        );

        comboBoxMoedaPara.getItems().addAll(
                "Reais",
                "Dólares",
                "Euros",
                "Libras",
                "Peso Argentino",
                "Peso Chileno"
        );

        ConverteTaxa.getItems().addAll(
                "+/- 0%",
                "+/- 1%",
                "+/- 2% (Taxa típica ATM)",
                "+/- 3% (Taxa típica de cartão de crédito)",
                "+/- 4%",
                "+/- 5% (Taxa típica de quiosque)"
        );
        comboBoxMoedaDe.setValue("Reais");
        comboBoxMoedaPara.setValue("Dólares");
        ConverteTaxa.setValue("+/- 0%");


        BotaoConversao.setOnAction(event -> converterMoeda());
        BotaoTaxa.setOnAction(event -> calcularTaxa());
        BotaoSair.setOnAction(event -> Platform.exit());
    }

    private boolean isValidInput() {
        String inputValue = InsereValor.getText();
        if (inputValue == null || inputValue.trim().isEmpty()) {
            showAlert("Erro", "Por favor, insira um valor.");
            return false;
        }

        try {
            Double.parseDouble(inputValue);
        } catch (NumberFormatException e) {
            showAlert("Erro", "Por favor, insira um valor numérico válido.");
            return false;
        }

        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void converterMoeda() {
        if (!isValidInput()) {
            return;
        }

        Funcao funcao = new Funcao();
        String moedaDe = comboBoxMoedaDe.getValue();
        String moedaPara = comboBoxMoedaPara.getValue();
        var valor = Double.parseDouble(InsereValor.getText());

        double resultado = funcao.converterMoeda(moedaDe, moedaPara, valor);

        // Formatação para usar vírgula como separador decimal
        NumberFormat format = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        format.setMaximumFractionDigits(2); // Definindo a quantidade máxima de casas decimais

        ResultadoConversao.setText(format.format(resultado));
    }


    private void calcularTaxa() {
        Funcao funcao = new Funcao();
        String taxaSelecionada = ConverteTaxa.getValue();

        // Análise do valor formatado do ResultadoConversao
        NumberFormat format = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        double valorConvertido;
        try {
            Number number = format.parse(ResultadoConversao.getText());
            valorConvertido = number.doubleValue();
        } catch (ParseException e) {
            showAlert("Erro", "Houve um erro ao analisar o resultado da conversão.");
            return;
        }

        double resultadoTaxa = funcao.aplicarTaxa(valorConvertido, taxaSelecionada);

        // Formatação para usar vírgula como separador decimal
        ResultadoTaxa.setText(format.format(resultadoTaxa));
    }


    private static class MoedaListCell extends ListCell<String> {
        private final Map<String, String> moedaToImagePath;

        public MoedaListCell(Map<String, String> moedaToImagePath) {
            this.moedaToImagePath = moedaToImagePath;
        }

        @Override
        protected void updateItem(String moeda, boolean empty) {
            super.updateItem(moeda, empty);
            if (empty || moeda == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(moeda);
                Image img = new Image(getClass().getResourceAsStream(moedaToImagePath.get(moeda)));
                ImageView imageView = new ImageView(img);


                imageView.setFitHeight(20);
                imageView.setFitWidth(20);


                Circle circleClip = new Circle(10, 10, 10);
                imageView.setClip(circleClip);

                setGraphic(imageView);
            }
        }
    }
}