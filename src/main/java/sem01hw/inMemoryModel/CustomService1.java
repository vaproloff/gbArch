package sem01hw.inMemoryModel;

public class CustomService1 implements ModelChangedObserver {
    @Override
    public void applyUpdateModel() {
        // TODO: Реагирует на изменение в хранилище моделей ...
        System.out.println("CustomService1 reacted on model changed");
    }
}
