package br.edu.ifpb.ads.foodjava.repository;
import com.google.gson.reflect.TypeToken;
import br.edu.ifpb.ads.foodjava.model.Gerente;

public class GerenteRepository extends JsonRepository<Gerente>{

    public GerenteRepository() {

        super(
            "resources/data/gerente.json",
            new TypeToken<java.util.List<Gerente>>(){}.getType()
        );

    }

}