package OCLP;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;


public class Main extends SimpleApplication {
    Buildings buildings;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        //Set up the lighting, fog and position the camera
        Environment env = new Environment(assetManager, rootNode, viewPort, cam);

        //Set up the world
            //Set up road
            Road road = new Road(assetManager, rootNode);
            
            //set up buildings
            buildings = new Buildings(assetManager, rootNode);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        buildings.tickPosition();
    }
}
