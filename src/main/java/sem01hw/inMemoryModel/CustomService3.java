package sem01hw.inMemoryModel;

public class CustomService3 implements ModelChangedObserver {

    @Override
    public void applyUpdateModel() {
        // TODO: Реагирует на изменение в хранилище моделей ...
        System.out.println("CustomService2 reacted on model changed");
    }

}