package ma.MyWeight.dao.daoVolatile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.MyWeight.dao.IDao;
import ma.MyWeight.modéle.Weight;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Component("dao")
public class WeightDao implements IDao<Weight,Long> {


    public static Set<Weight> BDWeight(){
        return new HashSet<>(
                Arrays.asList(
                        new Weight(1L,"Mehdi","HOMME",24.0,80.0,1.80,0.0,""),
                        new Weight(2L,"Sara","FEMME",17.0,50.4,1.80,0.0,""),
                        new Weight(3L,"Driss","HOMME",30.0,96.0,1.70,0.0,""),
                        new Weight(4L,"Fatima","FEMME",50.0,80.0,1.62,0.0,""),
                        new Weight(5L,"Omar","HOMME",34.0,90.0,1.95,0.0,"")

                )
        );
    }
    @Override
    public Weight findById(Long id) {
        System.out.println("[DAO BD volatile] trouver le Weight Id N °  : " + id);
        return BDWeight()
                .stream()
                .filter(weight -> weight.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Weight> findAll() {
        return null;
    }

    @Override
    public Weight save(Weight weight) {
        return null;
    }

    @Override
    public Weight update(Weight weight) {
        return null;
    }

    @Override
    public Boolean delete(Weight weight) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
