package br.edu.ifpb.ads.foodjava.repository;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import br.edu.ifpb.ads.foodjava.model.Cliente;

public class ClienteRepository extends JsonRepository<Cliente>{

    public ClienteRepository() {

        super(
            "resources/data/clientes.json",
            new TypeToken<java.util.List<Cliente>>(){}.getType()
        );

    }

}
