/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Line;
import Model.MPoint;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Const {

    // Đồ thị Có Sẵn 
    public static String[] LIST_DO_THI
            = new String[]{"Đồ thị 1", "Đồ thị 2"};

    public static Object[][] DO_THI_1 = {
        {0, 2, 0, 0, 0},
        {0, 0, 0, 7, 0},
        {26, 22, 0, 0, 0},
        {0, 0, 16, 0, 8},
        {0, 0, 5, 0, 0}
    };

    public static Point[] DO_THI_1_COORDINATE = {
        new Point(50, 50),
        new Point(50, 250),
        new Point(200, 50),
        new Point(200, 250),
        new Point(350, 150),};

    public static Object[][] DO_THI_2 = {
        {0, 7, 0, 0, 0, 0, 0},
        {0, 0, 8, 0, 0, 0, 0},
        {0, 0, 0, 0, 5, 0, 0},
        {5, 9, 0, 0, 15, 6, 0},
        {0, 7, 0, 0, 0, 8, 9},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 11, 0}
    };

    public static Point[] DO_THI_2_COORDINATE = {
        new Point(50, 50),
        new Point(50, 250),
        new Point(200, 50),
        new Point(200, 320),
        new Point(350, 50),
        new Point(350, 250),
        new Point(500, 150),};

    // DELAY TIME LIST 
    public static long[] DELAY_TIME = {500, 1000, 1500, 2000, 2500, 3000};

    // DIMENSION 
    public static int MAX_HEIGHT_OF_TABLE_MATRAN = 325;
    public static int MIN_HEIGHT_OF_TABLE_MATRAN = 263;
    public static int HEIGHT_OF_TABLE_MATRAN = MAX_HEIGHT_OF_TABLE_MATRAN;

    // Draw 
    public static Color COLOR_CELL_SELECTED = Color.RED;
    public static Color COLOR_CELL_NORMAL = Color.WHITE;
    public static Color COLOR_CELL_TEXT = Color.BLACK;
    public static Color COLOR_CELL_TEXT_SELECTED = Color.WHITE;
    public static Color COLOR_TESTING = Color.GRAY;
    public static Color COLOR_POINT_NORMAL = Color.BLUE;
    public static Color COLOR_LINE_NORMAL = Color.BLUE;
    public static Color COLOR_POINT_SELECTED = Color.RED;
    public static Color COLOR_LINE_SELECTED = Color.RED;
    public static Color COLOR_POINT_INDICATOR = Color.GREEN;
    public static int POINT_RADIUS = 35;
    public static int X_POINT_INDICATOR = 14;
    public static int Y_POINT_INDICATOR = 23;
}
