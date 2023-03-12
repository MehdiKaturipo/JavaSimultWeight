package ma.MyWeight.métier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.MyWeight.dao.IDao;
import ma.MyWeight.modéle.Weight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data @AllArgsConstructor @NoArgsConstructor
@Service("métier")
public class MétierWeight implements IMétierWeight{
    @Autowired
    @Qualifier("dao")
    IDao<Weight,Long> weightDao;
    @Override
    public Weight calculerIMC(Long idWeight) throws Exception {
        var weight = weightDao.trouverParId(idWeight);
        if (weight == null) throw new Exception(" Id du weight est incorrect id introuvable :: [weight id non trouvé]");
        else {
            double taille = weight.getHeight();
            double poids = weight.getPoids();
            double imc = poids / (taille * taille);
             imc = Math.round(imc * 100) / 100;
            weight.setBmi(imc);




        }
        return weight;
    }
}
