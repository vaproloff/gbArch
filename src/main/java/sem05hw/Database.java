package sem05hw;

import java.util.Collection;

/**
 * Интерфейс БД
 */
public interface Database {

    void load();
    void save();

    Collection<Entity> getAll();

}
