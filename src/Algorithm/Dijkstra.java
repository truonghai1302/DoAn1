/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import Model.DataPerStepForDijkstra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author DELL
 */
public class Dijkstra {
    // start - > chỉ số của startPoint trong mảng 
    // finish -> chỉ số của finishPoint trong mảng  
    public static ArrayList<DataPerStepForDijkstra> dijkstra(int[][] doThi, int soDinh, int start, int finish) {
        ArrayList<DataPerStepForDijkstra> listDataOfTwoPointsForOneStep = new ArrayList<DataPerStepForDijkstra>();
        int[] back = new int[100]; // Lưu đỉnh cha
        int[] weight = new int[100]; // Lưu trọng số 
        int[] mark = new int[100]; // đánh dấu đỉnh 

        // Khởi tạo 
        for (int i = 0; i < soDinh; i++) {
            back[i] = -1;
            mark[i] = 0;
            weight[i] = Integer.MAX_VALUE;
        }

        back[start] = 0;
        weight[start] = 0;

        // điểm nối trước đó của các đường đi
        ArrayList<Pair<Integer, Integer>> listRoads = new ArrayList<Pair<Integer, Integer>>();

        // kiểm tra đồ thị có liên thông hay ko 
        int connect = -1;

        // Điểm xuất phát đúng trong trường hợp bị rẽ nhánh
        int newStartPoint = start;

        do {
            // listValues of DataOfTwoPoints
            HashMap<Integer, Integer> listValues = new HashMap<Integer, Integer>();

            int finishPoint;
            int beforeValue;
            int currentValue = -1;
            ArrayList<Integer> listPointMarked = new ArrayList<Integer>();

            // đỉnh bắt đầu là đỉnh 0 => gán connect = -1 
            connect = -1;
            int min = Integer.MAX_VALUE;
            // duyệt qua các đỉnh trên đồ thị

            beforeValue = weight[start];

            int PointReNhanh = -1;

            for (int j = 0; j < soDinh; j++) {
                // nếu đỉnh chưa được đánh dấu 
                if (mark[j] == 0) {

                    // lưu lại cặp giá trị ( đỉnh đang thử nối - độ dài đường đi đến điểm đó ) 
                    int pointConnected = j;

                    // nếu tồn tại đường đi giữa đỉnh i và j
                    // weight[j] : tổng trọng số từ đỉnh bắt đầu -> đỉnh đang xét 
                    //  weight[start] + DO_THI[start][j] : trọng số đang xét
                    if (doThi[start][j] > 0) {
                        if (doThi[start][j] != 0
                                && weight[j] > weight[start] + doThi[start][j]) {

                            boolean addNewRoadFlag = true;
                            for (Pair<Integer, Integer> road : listRoads) {
                                if (road.getKey() == j) {
                                    addNewRoadFlag = false;
                                    listRoads.remove(road);
                                    listRoads.add(new Pair(j, start));
                                    break;
                                }
                            }

                            if (addNewRoadFlag) {
                                listRoads.add(new Pair(j, start));
                            }

                            // lưu lại dùng để so sánh lần sau 
                            weight[j] = weight[start] + doThi[start][j];
                            back[j] = start;
                        }
                    }

                    int length = weight[j];
                    listValues.put(pointConnected, length);

                    // dựa vào mảng weight -> tìm đường đi ngắn nhất hiện tại 
                    if (min > weight[j]) {

                        for (Pair<Integer, Integer> road : listRoads) {
                            if (road.getKey() == j) {
                                newStartPoint = road.getValue();
                                break;
                            }
                        }

                        min = weight[j];
                        // dựa vào biến connect 
                        // ta có thể quyết định điểm tiếp theo cần duyệt 
                        // và đổ thị có liên thông không 
                        connect = j;

                    }
                }
            }

            // thêm các vị trí các đỉnh đi qua vào listPointMarked của DataPerStepForDijkstra
            for (int i = 0; i < soDinh; i++) {
                if (mark[i] == 1) {
                    listPointMarked.add(i);
                }
            }

            start = connect;
            finishPoint = connect;
            if (connect != -1) {
                currentValue = weight[connect];
                mark[connect] = 1;
            } else {
//                newStartPoint+=1;
                finishPoint += 1;
            }

            // tạo data và add vào list 
            DataPerStepForDijkstra dotpfos = new DataPerStepForDijkstra(
                    newStartPoint, finishPoint, listValues, beforeValue, currentValue, listPointMarked);
            listDataOfTwoPointsForOneStep.add(dotpfos);
        } while (connect != -1 && start != finish);
        return listDataOfTwoPointsForOneStep;

    }
}
