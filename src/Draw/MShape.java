/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 *
 * @author DELL
 */
public interface MShape {
    public void paint(Graphics2D g); 
    
    public Point getOriginPoint();
    public void setOriginPoint(Point p);
    
    public Color getColor();
    public void setColor(Color color);
    
    public Shape getShape();
}
