/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author DELL
 */
public class DataPerStepForDijkstra {

    
    private int startPoint; // 3 <=> 5
    private int finishPoint;  // 6 <=> 9                5->2   : 10    5->3  : 9     
    private HashMap<Integer, Integer> listValue; // 2,3,1,7
    private int beforeValue; // tổng giá trị lưu trước đó
    private int currentValue; // tổng giá trị lưu hiện tại 
    private ArrayList<Integer> listPointMarked; // các điểm đã đánh dấu đi qua 

    public DataPerStepForDijkstra(int startPoint, int finishPoint,
            HashMap<Integer, Integer> listValue, int beforeValue,
            int currentValue , ArrayList<Integer> listPointMarked) {
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
        this.listValue = listValue;
        this.beforeValue = beforeValue;
        this.currentValue = currentValue;
        this.listPointMarked = listPointMarked;
    }
    
    /**
     * @return the listPointMarked
     */
    public ArrayList<Integer> getListPointMarked() {
        return listPointMarked;
    }

    /**
     * @param listPointMarked the listPointMarked to set
     */
    public void setListPointMarked(ArrayList<Integer> listPointMarked) {
        this.listPointMarked = listPointMarked;
    }

    /**
     * @return the beforeValue
     */
    public int getBeforeValue() {
        return beforeValue;
    }

    /**
     * @param beforeValue the beforeValue to set
     */
    public void setBeforeValue(int beforeValue) {
        this.beforeValue = beforeValue;
    }

    /**
     * @return the currentValue
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * @param currentValue the currentValue to set
     */
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * @return the startPoint
     */
    public int getStartPoint() {
        return startPoint;
    }

    /**
     * @param startPoint the startPoint to set
     */
    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * @return the finishPoint
     */
    public int getFinishPoint() {
        return finishPoint;
    }

    /**
     * @param finishPoint the finishPoint to set
     */
    public void setFinishPoint(int finishPoint) {
        this.finishPoint = finishPoint;
    }

    /**
     * @return the listValue
     */
    public HashMap<Integer, Integer> getListValue() {
        return listValue;
    }

    /**
     * @param listValue the listValue to set
     */
    public void setListValue(HashMap<Integer, Integer> listValue) {
        this.listValue = listValue;
    }


}
