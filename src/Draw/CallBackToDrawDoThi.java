/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import Draw.DrawDoThi.Flag;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
// Call back from AddNewLineDialog -> DrawDoThi
public interface CallBackToDrawDoThi {

    public void callBackSetValueForLine(boolean yes, int value);
    
    public void callBackAddNewLine(int value ,ShapePoint startPoint , ShapePoint finishPoint);

    public void callBackRemovePoint(int pointIndicator, boolean yes);
    
    public void callBackAddNewPoint(ShapePoint newPoint);
    
    public void callBackRemoveLine(ShapeLine lineDelete);
    
    public void callBackChangeValueOfLine(ShapeLine lineChange);
    
    public void callBackChangeIndicatorOfPoint(ShapePoint pointChange);
}
