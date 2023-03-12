package ma.MyWeight.métier;

import ma.MyWeight.modéle.Weight;

public interface IMétierWeight {
    Weight calculerIMC(Long idWeight) throws Exception;
}
