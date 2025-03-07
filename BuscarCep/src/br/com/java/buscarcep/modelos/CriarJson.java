package br.com.java.buscarcep.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriarJson {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        public CepRecord criacao(CepRecord cepRecord) throws IOException {
            try (FileWriter arquivoJson = new FileWriter("ListaDeCeps.json")) {
                arquivoJson.write(gson.toJson(cepRecord));
            } catch (Exception e) {
                System.out.println("Erro ao criar JSON: " + e.getMessage());
            }
            return cepRecord; // Retorna o objeto depois de salvar no JSON
        }

    }

