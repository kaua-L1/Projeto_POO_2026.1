package br.edu.ifpb.ads.foodjava.repository;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import br.edu.ifpb.ads.foodjava.model.Entidade;

public abstract class JsonRepository<T extends Entidade> implements Repository<T> {

    protected Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    protected List<T> dados = new ArrayList<>();
    protected File arquivo;
    protected Type tipoLista;
    
    public JsonRepository(String caminhoArquivo, Type tipoLista) {

        this.arquivo = new File(caminhoArquivo);
        this.tipoLista = tipoLista;

        carregar();
    }

    private void carregar() {

        try {

            File pasta = arquivo.getParentFile();

            if (pasta != null && !pasta.exists()) {
                pasta.mkdirs();
            }

            if (!arquivo.exists()) {
                arquivo.createNewFile();
                salvarArquivo();
            }

            FileReader reader = new FileReader(arquivo);

            List<T> lista = gson.fromJson(reader, tipoLista);

            if (lista != null) {
                dados = lista;
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void salvarArquivo() {

        try {

            FileWriter writer = new FileWriter(arquivo);

            gson.toJson(dados, writer);

            writer.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    protected int gerarProximoId() {

        int maior = 0;

        for (T obj : dados)

            if (obj.getId() > maior)
                maior = obj.getId();

        return maior + 1;

    }

    public void salvar(T obj) {

        obj.setId(gerarProximoId());

        dados.add(obj);

        salvarArquivo();

    }
    
    public void atualizar(T obj) {

        for (int i = 0; i < dados.size(); i++) {

            if (dados.get(i).getId() == obj.getId()) {

                dados.set(i, obj);
                salvarArquivo();
                return;
            }
        }
    }
    
    public T buscar(int id) {

        for (T obj : dados)

            if (obj.getId() == id)
                return obj;

        return null;

    }

    public List<T> listar() {

        return dados;

    }

    public void remover(int id) {

        T obj = buscar(id);

        if (obj != null) {

            dados.remove(obj);

            salvarArquivo();

        }

    }
}