package sem01hw.inMemoryModel;

public interface ModelChanger {

    void notifyChange();
    void registerModelChanger(ModelChangedObserver o);
    void removeModelChanger(ModelChangedObserver o);

}
