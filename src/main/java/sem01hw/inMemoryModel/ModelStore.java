package sem01hw.inMemoryModel;

import sem01hw.modelElements.*;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements ModelChanger {

    //region Public Methods

    public void addPolyModel(PolygonalModel model) {
        polygonalModels.add(model);
        this.notifyChange();
    }

    public void removePolyModel(PolygonalModel model) {
        polygonalModels.remove(model);
        this.notifyChange();
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
        this.notifyChange();
    }

    public void removeScene(Scene scene) {
        scenes.remove(scene);
        this.notifyChange();
    }

    public void addFlash(Flash flash) {
        flashes.add(flash);
        this.notifyChange();
    }

    public void removeFlash(Flash flash) {
        flashes.remove(flash);
        this.notifyChange();
    }

    public Scene getScene(int sceneId) {
        for (Scene scene : scenes) {
            if (scene.getId() == sceneId) {
                return scene;
            }
        }
        return null;
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
        this.notifyChange();
    }

    public void removeCamera(Camera camera) {
        cameras.remove(camera);
        this.notifyChange();
    }

    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : changeObservers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }

    //endregion


    //region Public Properties

    public Collection<PolygonalModel> getPolygonalModels() {
        return polygonalModels;
    }

    public Collection<Scene> getScenes() {
        return scenes;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    //endregion


    //region Private Fields

    private final Collection<PolygonalModel> polygonalModels = new ArrayList<>();
    private final Collection<Scene> scenes = new ArrayList<>();
    private final Collection<Flash> flashes = new ArrayList<>();
    private final Collection<Camera> cameras = new ArrayList<>();
    private final Collection<ModelChangedObserver> changeObservers = new ArrayList<>();

    //endregion

}
