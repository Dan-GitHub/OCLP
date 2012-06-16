package OCLP;

import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.asset.*;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;


public class Road{
    Geometry geometry_ground;
    
    protected Road(AssetManager assetManager,Node rootNode){
        Box ground = new Box(Vector3f.ZERO, 100, 0.1f, 3);
        ground.scaleTextureCoordinates(new Vector2f(1f,33f));
        geometry_ground = new Geometry("Road", ground);
        geometry_ground.setMaterial(assetManager.loadMaterial("Materials/Road.j3m"));
        
        rootNode.attachChild(geometry_ground);
    }
    
    public void tickPosition(){
        geometry_ground.move(-0.008f, 0, 0);
    }
}