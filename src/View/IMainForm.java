/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Draw.ShapeLine;
import Draw.ShapePoint;
import Model.Matrix;
import Model.Matrix.Mode;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface IMainForm {

    public void setEventListener();

    public void initData();

    public void prepareUI();

    public void addPanelDrawDoThi();

    public void clearViewOfOldRoad();

    public boolean checkValidBeforeExecute();

    public void showDataWithStepIndicator(int startPoint, int finishPoint, int stepIndicator, int maxStep, int soDinh);

    public void handleWithUpdateValueOfLineOnTableMaTran(String value, int pointStartPosition, int pointEndPosition);

    public void handleWithActionChayTuDong();

    public void handleWithSelectedDoThiCoHuong();

    public void handleWithSelectedDoThiVoHuong();

    public void handleWithSelectedDoThiTuVe();

    public void handleWithSelectedDoThiCoSan();

    public void handleWithSelectedDuongDiMoi();

    public void handleWithSelectedDoThiCoSanPosition(int position);

    public void handleWithActionChay1Lan();

    public void handleWithActionChayTungBuoc();

}
