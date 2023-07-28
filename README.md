# 🚀Conversor de Moedas

Um aplicativo em Java que converte entre várias moedas. Este conversor usa uma API para obter cotações em tempo real e apresenta uma interface de usuário desenvolvida com JavaFX.

<p align="center">
  <img src="https://github.com/diovani-dupont/ChallengeOne_Conversor_Moeda/assets/109030838/b5522372-07d9-49b0-93b6-9e4b605daab9" alt="Conversor_de_Moeda" width="400">
</p>

## 🔍 Características

- Conversão entre várias moedas, incluindo Reais, Dólares, Euros, Libras, Peso Argentino e Peso Chileno.
- Interface gráfica amigável com ícones representativos para cada moeda.
- Possibilidade de aplicar taxas ao valor convertido, como taxas de ATM ou de cartão de crédito.
- Validação de entrada para garantir que um número válido seja inserido antes da conversão.

## 🛠️ Arquitetura e Componentes

1. 📋 **Principal.java**

   **Descrição:** Esta é a classe principal que inicia a aplicação JavaFX.

   🚀 **Funcionalidades Principais:**

    - O método start define o layout inicial do aplicativo e mostra a janela principal.

2. 📋 **PrincipalController.java**

   **Descrição:** Esta classe controla a interface gráfica (GUI) definida em "principal.fxml".

   🚀 **Funcionalidades Principais:**
    - 🛠️ Gerencia os eventos dos botões e combinações de moedas e realiza as operações de conversão.
    - 🔍 Utiliza uma classe auxiliar MoedaListCell para definir como cada moeda é mostrada em um ComboBox (com imagem e nome da moeda).
    - 🚀 Os métodos converterMoeda e calcularTaxa são responsáveis por realizar a conversão de moeda e aplicar a taxa selecionada, respectivamente.
    - 🔍 O método showAlert exibe um alerta na interface gráfica.

3. 📋 **ConverteMoedas.java e ConverteMoedasParaReais.java**

   **Descrição:** Ambas as classes possuem métodos específicos para conversão de Reais para outras moedas e vice-versa.

   🚀 **Funcionalidades Principais:**
    - 🛠️ Esses métodos usam taxas de câmbio obtidas de uma API externa através da classe ServicoDeCambio.

4. 📋 **Funcao.java**

   **Descrição:** Esta classe funciona como um agregador que combina funcionalidades das classes ConverteMoedas e ConverteMoedasParaReais.

   🚀 **Funcionalidades Principais:**
    - 🔍 Contém o método converterMoeda que realiza a conversão com base nas moedas de origem e destino selecionadas.
    - 🛠️ Contém o método aplicarTaxa que aplica a taxa de câmbio selecionada ao valor convertido.

## 🚀 Como usar

1. Execute o arquivo `Principal.java` para iniciar a aplicação.
2. Na interface gráfica, selecione a moeda de origem e a moeda de destino.
3. Insira o valor que deseja converter.
4. Pressione o botão "Converter" para obter o resultado.
5. Se desejar, selecione uma taxa a ser aplicada ao valor convertido e pressione o botão "Taxa" para obter o novo valor.

## 📋 Dependências

- JavaFX: para a interface gráfica.
- API de cotação de moedas (não especificada): para obter cotações em tempo real.

## 🛠️ Instalação

Certifique-se de ter o Java e o JavaFX instalados em sua máquina.

1. Clone este repositório para sua máquina local.
2. Navegue até a pasta do projeto e compile o código.
3. Execute a aplicação através da classe `Principal.java`.

## 🛠️ Contribuindo

Sinta-se à vontade para enviar pull requests com melhorias ou novas funcionalidades.

## 📋 Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo `LICENSE.md` para obter detalhes.

## 🚀Créditos

Desenvolvido por Diovani Dupont.



