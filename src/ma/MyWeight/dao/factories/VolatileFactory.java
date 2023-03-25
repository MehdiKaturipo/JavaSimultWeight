package ma.MyWeight.dao.factories;

import ma.MyWeight.dao.IDao;
import ma.MyWeight.modéle.Weight;

public class VolatileFactory extends Factory{
    @Override
    public IDao<Weight, Long> getCréditDao() {
        return null;
    }
}
