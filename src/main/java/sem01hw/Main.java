package sem01hw;

import sem01hw.inMemoryModel.CustomService1;
import sem01hw.inMemoryModel.CustomService2;
import sem01hw.inMemoryModel.CustomService3;
import sem01hw.inMemoryModel.ModelStore;
import sem01hw.modelElements.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CustomService1 observer1 = new CustomService1();
        CustomService2 observer2 = new CustomService2();
        CustomService3 observer3 = new CustomService3();

        ModelStore modelStore = new ModelStore();
        modelStore.registerModelChanger(observer1);
        modelStore.registerModelChanger(observer2);
        modelStore.registerModelChanger(observer3);

        modelStore.addCamera(new Camera(new Point3D(2, -1, 20), new Angle3D(45, 30, 90)));

    }
}
