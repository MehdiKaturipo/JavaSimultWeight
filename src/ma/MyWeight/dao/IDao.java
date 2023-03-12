package ma.MyWeight.dao;

public interface IDao <T,ID>{
    T trouverParId(ID id);
}

