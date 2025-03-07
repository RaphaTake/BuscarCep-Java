package br.com.java.buscarcep.principal;

import br.com.java.buscarcep.modelos.CepRecord;
import br.com.java.buscarcep.modelos.ViaCep;
import br.com.java.buscarcep.modelos.CriarJson;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ViaCep cep = new ViaCep();
        CriarJson criarJson = new CriarJson();

        System.out.println("Digite o numero do Cep");
        String numCep = scanner.nextLine();
        cep.setNumeroCep(numCep);
        System.out.println(cep.getNumeroCep());
        System.out.println(cep.getEndereco());

        cep.requisicaoApi();
        CepRecord cepRecord = cep.toCepRecord();
        criarJson.criacao(cepRecord);
        System.out.println(cepRecord);

    }
}