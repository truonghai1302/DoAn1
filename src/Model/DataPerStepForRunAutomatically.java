/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class DataPerStepForRunAutomatically {

    private ArrayList<Line> listLinesTesting;
    private ArrayList<Line> listLinePassed;
    private int startIndicator;
    private int finishIndicator;
    private Object[][] tableVariable;
    private boolean isFinalStep;

    public DataPerStepForRunAutomatically(ArrayList<Line> listLinesTesting, int startIndicator, int finishIndicator,
            ArrayList<Line> listLinePassed, Object[][] tableVariable, boolean isFinalStep) {
        this.listLinesTesting = listLinesTesting;
        this.startIndicator = startIndicator;
        this.finishIndicator = finishIndicator;
        this.listLinePassed = listLinePassed;
        this.tableVariable = tableVariable;
        this.isFinalStep = isFinalStep;
    }

    public ArrayList<Integer> getListPointOfTrueRoad() {
        ArrayList<Integer> listPoints = new ArrayList<Integer>();
        int startPointBefore = -1;
        // truy vết từ điểm cuối ngược lại tìm những điểm đi đúng đường   
        for (int i = listLinePassed.size() - 1; i >= 0; i--) {
            Line line = listLinePassed.get(i);
            if (startPointBefore == -1) {
                startPointBefore = line.getStartIndicator();
                listPoints.add(line.getEndIndicator());
            } else {
                if (line.getEndIndicator() == startPointBefore) {
                    listPoints.add(line.getEndIndicator());
                    startPointBefore = line.getStartIndicator();
                }
                if (i == 0) {
                    listPoints.add(line.getStartIndicator());
                }
            }
        }
        Collections.reverse(listPoints);
        return listPoints;
    }

    public ArrayList<Line> getListLinesTesting() {
        return listLinesTesting;
    }

    public void setListLinesTesting(ArrayList<Line> listLinesTesting) {
        this.listLinesTesting = listLinesTesting;
    }

    public int getStartIndicator() {
        return startIndicator;
    }

    public void setStartIndicator(int startIndicator) {
        this.startIndicator = startIndicator;
    }

    public int getFinishIndicator() {
        return finishIndicator;
    }

    public void setFinishIndicator(int finishIndicator) {
        this.finishIndicator = finishIndicator;
    }

    public ArrayList<Line> getListLinePassed() {
        return listLinePassed;
    }

    public void setListLinePassed(ArrayList<Line> listPointPassed) {
        this.listLinePassed = listPointPassed;
    }

    public Object[][] getTableVariable() {
        return tableVariable;
    }

    public void setTableVariable(Object[][] tableVariable) {
        this.tableVariable = tableVariable;
    }

    public boolean isIsFinalStep() {
        return isFinalStep;
    }

    public void setIsFinalStep(boolean isFinalStep) {
        this.isFinalStep = isFinalStep;
    }
}
