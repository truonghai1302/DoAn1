/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
public class Line {

    private int startIndicator;
    private int endIndicator;
    private int value;

    public Line(int startIndicator, int endIndicator, int value) {
        this.startIndicator = startIndicator;
        this.endIndicator = endIndicator;
        this.value = value;
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
     * @return the endIndicator
     */
    public int getEndIndicator() {
        return endIndicator;
    }

    /**
     * @param endIndicator the endIndicator to set
     */
    public void setEndIndicator(int endIndicator) {
        this.endIndicator = endIndicator;
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
