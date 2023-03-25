package ma.MyWeight.dao.daoException;

public class DAOConfigException extends RuntimeException {

    public DAOConfigException(String message) {
        super(message);
    }

    public DAOConfigException(String message, Throwable cause) {
        super(message, cause);
    }
}

