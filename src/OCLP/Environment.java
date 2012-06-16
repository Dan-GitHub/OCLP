package OCLP;

import com.jme3.asset.AssetManager;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.FogFilter;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;

public class Environment {
    private AssetManager assetManager;
    private Node rootNode;
    private ViewPort viewPort;
    private Camera cam;
    
    protected Environment(AssetManager assetManager, Node rootNode,ViewPort viewPort, Camera cam){
        this.assetManager = assetManager;
        this.rootNode = rootNode;
        this.viewPort = viewPort;
        this.cam = cam;
        
        //Setup environment
        setUpLight();
        setUpFog();
        setUpCam();
    }
    
    
    protected void setUpLight(){
        /** A white ambient light source. */
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White.mult(1.5f));
        rootNode.addLight(ambient);
        
        /** A white, directional light source */
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-1f, 0f, 0f)).negateLocal());
        sun.setColor(ColorRGBA.White.mult(0.6f));
        rootNode.addLight(sun);
    }
    
    protected void setUpFog(){
        /* 
         * Fog is commented out as it fails
      
        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
        fpp.setNumSamples(4);
        FogFilter fog = new FogFilter();
        fog.setFogColor(new ColorRGBA(0.8f, 0.8f, 1.0f, 1.0f));
        fog.setFogDistance(7);
        fog.setFogDensity(1.4f);
        fpp.addFilter(fog);
        viewPort.addProcessor(fpp);
        */
    }
    
    protected void setUpCam(){
        cam.setLocation(new Vector3f(0f,4.5f,2f));
        cam.setRotation(Quaternion.IDENTITY);
    }
}
