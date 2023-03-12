package ma.MyWeight.présentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.MyWeight.métier.IMétierWeight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Data @NoArgsConstructor @AllArgsConstructor
@Controller
public class WeightControlleur implements IWeightControlleur{
    @Autowired
    @Qualifier("métier")
     IMétierWeight métierWeight;

    @Override
    public void afficherIMC(Long idWeight) throws Exception {
        var weightCalcultor = métierWeight.calculerIMC(idWeight);
        System.out.println(weightCalcultor);
    }
}
