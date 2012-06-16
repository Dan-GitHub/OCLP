/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OCLP;

import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl.ControlDirection;
import com.jme3.scene.shape.Box;

/**
 *
 * @author Kevin
 */
public class Bird implements AnalogListener{

    InputManager inputManager;    
    Node bird = new Node();
    private float speed = 1.0f;
    
    public Bird(AssetManager assetManager, Node rootNode, Camera cam, InputManager inputManager){
        this.inputManager = inputManager;    
   
        Box b = new Box(Vector3f.ZERO, 0.2f, 0.2f, 0.2f); // create cube shape at the origin
        Geometry geom = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Blue);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        bird.attachChild(geom);
        bird.move(0, 1, 0);
        
        
        
        //Setup input
        setUpKeys();
        
        //Setup the Camera
        // Disable the default flyby cam
        //create the camera Node
        CameraNode camNode = new CameraNode("Camera Node", cam);
        //This mode means that camera copies the movements of the target:
        camNode.setControlDir(ControlDirection.SpatialToCamera);
        //Attach the camNode to the target:
        bird.attachChild(camNode);
        //Move camNode, e.g. behind and above the target:
        camNode.setLocalTranslation(new Vector3f(-2.5f, 1.75f, 0));
        //Rotate the camNode to look at the target:
        camNode.lookAt(bird.getLocalTranslation(), Vector3f.UNIT_Y);
            
        rootNode.attachChild(bird);                     
    }
    
    
    private void setUpKeys(){
        inputManager.addMapping("Left",   new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Right",  new KeyTrigger(KeyInput.KEY_D));
        inputManager.addListener(this, new String[]{"Left", "Right"});
    }

    public void onAnalog(String name, float value, float tpf) {
        if(name.equals("Left")){
            if(bird.getLocalTranslation().z > -2.5){
                bird.move(0, 0, -speed*tpf);
            }   
        }else if(name.equals("Right")){
            if(bird.getLocalTranslation().z < 2.5){
                bird.move(0, 0, speed*tpf);
            }              
        }
    }
    
}
