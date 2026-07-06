package br.edu.ifpb.ads.foodjava.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import br.edu.ifpb.ads.foodjava.model.ListaPedidos;
import br.edu.ifpb.ads.foodjava.model.Pedido;

public class ListaPedidosRepository {

    private final String arquivo = "resources/data/pedidos.json";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class,
                    (JsonSerializer<LocalDateTime>) (src, type, context) ->
                            new JsonPrimitive(src.toString()))
            .registerTypeAdapter(LocalDateTime.class,
                    (JsonDeserializer<LocalDateTime>) (json, type, context) ->
                            LocalDateTime.parse(json.getAsString()))
            .setPrettyPrinting()
            .create();

    public ListaPedidosRepository() {

        ListaPedidos lista = buscar();

        if (lista == null) {
            salvar(new ListaPedidos());
        }
    }

    public void salvar(ListaPedidos lista) {

        try (FileWriter writer = new FileWriter(arquivo)) {

            gson.toJson(lista, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ListaPedidos buscar() {

        try (FileReader reader = new FileReader(arquivo)) {

            ListaPedidos lista = gson.fromJson(reader, ListaPedidos.class);

            if (lista == null) {
                return new ListaPedidos();
            }

            return lista;

        } catch (IOException e) {

            return new ListaPedidos();
        }
    }

    private int proximoId(ListaPedidos lista) {

        int maior = 0;

        for (Pedido pedido : lista.getPedidos()) {

            if (pedido.getID() > maior) {
                maior = pedido.getID();
            }

        }

        return maior + 1;
    }

    public void adicionar(Pedido pedido) {

        ListaPedidos lista = buscar();

        pedido.setId(proximoId(lista));

        lista.adicionarPedido(pedido);

        salvar(lista);
    }

    public Pedido buscarPorId(int id) {

        ListaPedidos lista = buscar();

        for (Pedido pedido : lista.getPedidos()) {

            if (pedido.getID() == id) {
                return pedido;
            }

        }

        return null;
    }

    public void atualizar(Pedido pedidoAtualizado) {

        ListaPedidos lista = buscar();

        for (int i = 0; i < lista.getPedidos().size(); i++) {

            if (lista.getPedidos().get(i).getID() == pedidoAtualizado.getID()) {

                lista.getPedidos().set(i, pedidoAtualizado);

                salvar(lista);

                return;
            }
        }
    }

    public void remover(int id) {

        ListaPedidos lista = buscar();

        lista.getPedidos().removeIf(p -> p.getID() == id);

        salvar(lista);
    }
    
    public List<Pedido> buscarPorCliente(int idCliente) {

        ListaPedidos lista = buscar();

        List<Pedido> resultado = new ArrayList<>();

        for (Pedido pedido : lista.getPedidos()) {

            if (pedido.getIdCliente() == idCliente) {
                resultado.add(pedido);
            }

        }

        return resultado;
    }
}