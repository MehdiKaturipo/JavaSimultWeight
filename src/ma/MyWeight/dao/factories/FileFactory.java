package ma.MyWeight.dao.factories;

import ma.MyWeight.dao.IDao;
import ma.MyWeight.modéle.Weight;

public class FileFactory extends Factory{
    @Override
    public IDao<Weight, Long> getCréditDao() {
        return null;
    }
}
