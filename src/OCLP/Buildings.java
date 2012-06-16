package OCLP;

import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Node;
import com.jme3.math.Vector3f;
import com.jme3.asset.*;
import com.jme3.math.Vector2f;


/**
*
* @author xenland
*/
public class Buildings{
    private AssetManager assetManager;
    private Node rootNode;
    
    private Node Building1;
    
    public Buildings(AssetManager assetManager, Node rootNode){
        //Give access to assetManager for other functions to use it in this class
        this.assetManager = assetManager;
        this.rootNode = rootNode;
        
        //execute class
        SpawnBuildings();
    }
    
    public void SpawnBuildings(){
        Building1 = new Node();
        
        //Spawn buildings
        Geometry geometry_building = createBuilding();
        
        Building1.attachChild(geometry_building);
        
        rootNode.attachChild(Building1);
    }
    
    private Geometry createBuilding(){
        Vector3f boxVector = new Vector3f(9, 0.9f, 0.2f);
        Box building = new Box(boxVector, 0.2f, 3f, 0.2f);
        building.scaleTextureCoordinates(new Vector2f(1f,10f));
        Geometry geometry_building = new Geometry("Building", building);
        geometry_building.setLocalTranslation(0f,2.05f,0f);
        geometry_building.setMaterial(assetManager.loadMaterial("Materials/Building.j3m"));

        return geometry_building;
    }
    
    /* Other actions */
    public void tickPosition(){
      //Is building1 past camera?
      Vector3f Building1Pos = Building1.getWorldTranslation();
      System.out.print(Building1Pos.x+"\n");
      if(Building1Pos.x < -14){
          Building1.setLocalTranslation(0, 0, 0);
      }
      Building1.move(-0.008f, 0, 0);
        
    }
}