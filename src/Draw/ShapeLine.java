/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Draw;

import Utils.Const;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ShapeLine implements MShape {

    private Point originPoint;
    private Point finishPoint;
    private Color color;
    private Shape shape;
    private boolean isCoHuong;
    private boolean isSelected;
    private int startIndicator;
    private int finishIndicator;
    private int value;

    public ShapeLine(Point origin, Point finish, int value, boolean isCoHuong,
            boolean isSelected, int startIndicator, int finishIndicator) {
        this.originPoint = origin;
        this.finishPoint = finish;
        this.value = value;
        this.isCoHuong = isCoHuong;
        if (isSelected) {
            color = Const.COLOR_LINE_SELECTED;
        } else {
            color = Const.COLOR_LINE_NORMAL;
        }
        this.startIndicator = startIndicator;
        this.finishIndicator = finishIndicator;
    }

    @Override
    public void paint(Graphics2D g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setFont(new Font("default", Font.BOLD, 19));

        // draw line 
        int x11 = getOriginPoint().x + 15;
        int y11 = getOriginPoint().y + 15;
        int x22 = getFinishPoint().x + 15;
        int y22 = getFinishPoint().y + 15;

        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

        x1 = x11;
        y1 = y11;
        x2 = Math.abs(x22 - x11) / 2 + Math.min(x22, x11);
        y2 = Math.abs(y22 - y11) / 2 + Math.min(y22, y11);

        // draw Value of 2 Point
        int xValue = 0;
        int yValue = 0;

        xValue = x2 + 14;

        if(x11 == x22 ){
            xValue = x2 + 14; 
        }else if(x11 > x22 ){
            xValue = x2 -14;
        }else {
            xValue = x2 + 14;
        }
        
        if (y11 == y22) {
            yValue = y2 - 10;
        } else if (y11 > y22) {
            yValue = y2 + 15;
        } else if (y11 < y22) {
            yValue= y2 -15 ;
        }

//        if (Math.abs(x2 - x1) < 50) {
//            if (x1 < x2) {
//                xValue = x2 - 10;
//            } else {
//                xValue = x2 + 10;
//            }
//
//        } else {
//            if (x1 < x2) {
//                xValue = x2 - 30;
//            } else {
//                xValue = x2 + 30;
//            }
//        }
//
//        if (Math.abs(y2 - y1) < 30) {
//            if (y1 < y2) {
//                yValue = y1 + 10;
//            } else {
//                yValue = y1 - 10;
//            }
//        } else {
//                
//        }
        g2d.drawString("\t" + getValue(), xValue, yValue);

        // draw shape 
        Polygon polygon = new Polygon();
        if (Math.abs(y22 - y11) > 50) {
            polygon.addPoint(x11 - 14, y11);
            polygon.addPoint(x22 - 14, y22);
            polygon.addPoint(x22 + 14, y22);
            polygon.addPoint(x11 + 14, y11);
            polygon.addPoint(x11, y11);
        } else {
            polygon.addPoint(x11, y11 - 14);
            polygon.addPoint(x22, y22 - 14);
            polygon.addPoint(x22, y22 + 14);
            polygon.addPoint(x11, y11 + 14);
            polygon.addPoint(x11, y11);
        }

        setShape(polygon);

        AlphaComposite alcom = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.0f);
        g2d.setComposite(alcom);

        g2d.setColor(Color.WHITE);
        g2d.draw(getShape());

        // draw line
        AlphaComposite alcom1 = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 1.0f);
        g2d.setComposite(alcom1);

        g2d.setColor(color);
        g2d.drawLine(x11, y11, x22, y22);

        // draw triangle 
        if (isCoHuong) {
            int dx = x2 - x1, dy = y2 - y1;
            double D = Math.sqrt(dx * dx + dy * dy);
            double xm = D - 5, xn = xm, ym = 5, yn = -5, x;
            double sin = dy / D, cos = dx / D;

            x = xm * cos - ym * sin + x1;
            ym = xm * sin + ym * cos + y1;
            xm = x;

            x = xn * cos - yn * sin + x1;
            yn = xn * sin + yn * cos + y1;
            xn = x;

            int[] xpoints = {x2, (int) xm, (int) xn};
            int[] ypoints = {y2, (int) ym, (int) yn};

            g.fillPolygon(xpoints, ypoints, 3);
        }

    }

    /**
     * @return the originPoint
     */
    public Point getOriginPoint() {
        return originPoint;
    }

    /**
     * @param originPoint the originPoint to set
     */
    public void setOriginPoint(Point originPoint) {
        this.originPoint = originPoint;
    }

    /**
     * @return the finishPoint
     */
    public Point getFinishPoint() {
        return finishPoint;
    }

    /**
     * @param finishPoint the finishPoint to set
     */
    public void setFinishPoint(Point finishPoint) {
        this.finishPoint = finishPoint;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * @param shape the shape to set
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * @return the isCoHuong
     */
    public boolean isIsCoHuong() {
        return isCoHuong;
    }

    /**
     * @param isCoHuong the isCoHuong to set
     */
    public void setIsCoHuong(boolean isCoHuong) {
        this.isCoHuong = isCoHuong;

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
            color = Const.COLOR_LINE_SELECTED;
        } else {
            color = Const.COLOR_LINE_NORMAL;
        }
    }

    /**
     * @return the startIndicator
     */
    public int getStartIndicator() {
        return startIndicator;
    }

    /**
     * @param startIndicator the startIndicator to set
     */
    public void setStartIndicator(int startIndicator) {
        this.startIndicator = startIndicator;
    }

    /**
     * @return the finishIndicator
     */
    public int getFinishIndicator() {
        return finishIndicator;
    }

    /**
     * @param finishIndicator the finishIndicator to set
     */
    public void setFinishIndicator(int finishIndicator) {
        this.finishIndicator = finishIndicator;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

}
