/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import Draw.DrawDoThi.Flag;
import Model.DataPerStepForRunAutomatically;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface CallBackToMainForm {

    public void callBackUpdatedFromDrawDoThi(Flag flagUpdate, 
            ArrayList<ShapePoint> listShapePoints,
            ArrayList<ShapeLine> listShapeLines);
    
    public void callBackUpdateViewPerStepWithActionChayTuDongFromDrawDoThi(DataPerStepForRunAutomatically dps);
}
