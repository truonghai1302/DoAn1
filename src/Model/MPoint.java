/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author DELL
 */
public class MPoint {

    private int indicator;
    private Point originPoint;
    private ArrayList<Line> listLine;

    public MPoint(int indicator, ArrayList<Line> listLine) {
        this.indicator = indicator;
        this.listLine = listLine;
    }

    public MPoint(int indicator, Point originPoint, ArrayList<Line> listLine) {
        this.indicator = indicator;
        this.listLine = listLine;
        this.originPoint = originPoint;
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
     * @return the indicator
     */
    public int getIndicator() {
        return indicator;
    }

    /**
     * @param indicator the indicator to set
     */
    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    /**
     * @return the listLine
     */
    public ArrayList<Line> getListLine() {
        return listLine;
    }

    /**
     * @param listLine the listLine to set
     */
    public void setListLine(ArrayList<Line> listLine) {
        this.listLine = listLine;
    }

}
