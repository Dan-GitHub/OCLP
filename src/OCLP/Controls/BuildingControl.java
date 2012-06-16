/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OCLP.Controls;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author Kevin
 */
public class BuildingControl extends AbstractControl {    
    private float speed = 1.0f;    
    
    @Override
    protected void controlUpdate(float tpf) {
        if(spatial != null){
           spatial.move(-speed*tpf, 0, 0);                                      

            if(spatial.getLocalTranslation().x < -10){
                spatial.setUserData("isAlive", false);
            }
        }
    }

      @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {     
    }
  

    public Control cloneForSpatial(Spatial spatial) {
        BuildingControl control = new BuildingControl();
        this.spatial = spatial;      
        return control;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

  
    
}
