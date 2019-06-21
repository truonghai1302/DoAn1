/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import Utils.Const;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author DELL
 */
public class ShapePoint implements MShape {

    private Point originPoint;
    private int indicator;
    private Color color;
    private Shape shape;
    private boolean isSelected;

    public ShapePoint(Point originPoint, int indicator, boolean isSelected) {
        this.originPoint = originPoint;
        this.indicator = indicator;
        this.isSelected = isSelected;
        if (isSelected) {
            this.color = Const.COLOR_POINT_SELECTED;
        } else {
            this.color = Const.COLOR_POINT_NORMAL;
        }
    }

    @Override
    public void paint(Graphics2D g) {
        // draw circle 
        g.setColor(color);
        shape = new Ellipse2D.Double(originPoint.x, originPoint.y, Const.POINT_RADIUS, Const.POINT_RADIUS);
        g.fill(shape);
        g.setColor(color);
        g.setFont(new Font("default", Font.BOLD, 19));
        // draw indicator 
        g.setColor(Const.COLOR_POINT_INDICATOR);
        if (getIndicator() > 9) {
            g.drawString("" + getIndicator(),
                    originPoint.x + Const.X_POINT_INDICATOR - 6,
                    originPoint.y + Const.Y_POINT_INDICATOR);
        } else {
            g.drawString("" + getIndicator(),
                    originPoint.x + Const.X_POINT_INDICATOR,
                    originPoint.y + Const.Y_POINT_INDICATOR);
        }
    }

    @Override
    public Point getOriginPoint() {
        return originPoint;
    }

    @Override
    public void setOriginPoint(Point p) {
        this.originPoint = p;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    /**
     * @return the isSelected
     */
    public boolean isIsSelected() {
        return isSelected;
    }

    /**
     * @param isSelected the isSelected to set
     */
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
        if (isSelected) {
            color = Const.COLOR_POINT_SELECTED;
        } else {
            color = Const.COLOR_POINT_NORMAL;
        }

    }

}
