package ma.MyWeight.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.MyWeight.modéle.Weight;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@Component("dao")
public class WeightDao implements IDao<Weight,Long>{


    public static Set<Weight> BDWeight(){
        return new HashSet<>(
                Arrays.asList(
                        new Weight(1L,"Mehdi","HOMME",24.0,80.0,1.80,0.0,""),
                        new Weight(2L,"Sara","FEMME",17.0,50.4,1.80,0.0,""),
                        new Weight(3L,"Driss","HOMME",30.0,96.0,1.70,0.0,""),
                        new Weight(4L,"Fatima","FEMME",50.0,18.0,1.80,0.0,""),
                        new Weight(5L,"Omar","HOMME",34.0,90.0,1.95,0.0,"")

                )
        );
    }
    @Override
    public Weight trouverParId(Long id) {
        System.out.println("[DAO -DS volatile] trouver le Weight Id N °  : " + id);
        return BDWeight()
                .stream()
                .filter(weight -> weight.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
