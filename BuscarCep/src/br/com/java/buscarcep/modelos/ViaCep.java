package br.com.java.buscarcep.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCep {


    private String numeroCep;
    private String endereco;
    private String cep;
    private String logradouro;
    private String localidade;
    private String complemento;
    private String bairro;
    private String estado;



    public ViaCep() {
    }

    public void setNumeroCep (String numeroCep){
        this.numeroCep = numeroCep;
        this.endereco = "https://viacep.com.br/ws/" + numeroCep + "/json/";
    }

    public void requisicaoApi() throws IOException, InterruptedException {

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + numeroCep + "/json/"))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            String json = response.body();
            System.out.println(json);

            Gson gson = new Gson();
            ViaCep viaCep = gson.fromJson(json, ViaCep.class);

            this.cep = viaCep.cep;
            this.logradouro = viaCep.logradouro;
            this.complemento = viaCep.complemento;
            this.bairro = viaCep.bairro;
            this.localidade = viaCep.localidade;
            this.estado = viaCep.estado;

        } catch (Exception e) {
            System.out.println("Erro!");
            System.out.println(e.getMessage());
        }
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumeroCep () {
        return numeroCep;
    }


    public String getEndereco () {
        return endereco;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getEstado() {
        return estado;
    }

    public CepRecord toCepRecord() {
        return new CepRecord(cep, logradouro, bairro, localidade, estado);
    }
}




