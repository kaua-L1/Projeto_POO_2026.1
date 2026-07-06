package br.edu.ifpb.ads.foodjava.repository;
import com.google.gson.reflect.TypeToken;
import br.edu.ifpb.ads.foodjava.model.Restaurante;
public class RestauranteRepository extends JsonRepository<Restaurante>{

    public RestauranteRepository() {

        super(
            "resources/data/restaurantes.json",
            new TypeToken<java.util.List<Restaurante>>(){}.getType()
        );

    }

}
