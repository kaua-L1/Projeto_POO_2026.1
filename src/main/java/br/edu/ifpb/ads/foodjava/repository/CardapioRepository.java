package br.edu.ifpb.ads.foodjava.repository;

import br.edu.ifpb.ads.foodjava.model.Cardapio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CardapioRepository {

    private final String arquivo = "resources/data/cardapio.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public CardapioRepository() {
        if (buscar() == null) {
            salvar(new Cardapio());
        }
    }

    public void salvar(Cardapio cardapio) {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(cardapio, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cardapio buscar() {
        try (FileReader reader = new FileReader(arquivo)) {
            Cardapio cardapio = gson.fromJson(reader, Cardapio.class);

            if (cardapio == null) {
                return new Cardapio();
            }

            return cardapio;

        } catch (IOException e) {
            return new Cardapio();
        }
    }
    
    public Cardapio importar(String caminhoArquivo) {
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            return gson.fromJson(reader, Cardapio.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Cardapio();
        }
    }
}