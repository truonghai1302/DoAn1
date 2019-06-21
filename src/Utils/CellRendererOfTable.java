/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DELL
 */
public class CellRendererOfTable extends JLabel implements TableCellRenderer {

    int row1;
    int column1;
    ArrayList<Pair<Integer, Integer>> listSelectedCell;

    public CellRendererOfTable(ArrayList<Pair<Integer, Integer>> listSelectedCell) {
        this.listSelectedCell = listSelectedCell;
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        boolean flag = false;
        for (Pair<Integer, Integer> cell : listSelectedCell) {
            int row2 = cell.getKey();
            int column2 = cell.getValue();
            if (row2 == row
                    && column2 == column) {
                setBackground(Const.COLOR_CELL_SELECTED);
                setForeground(Const.COLOR_CELL_TEXT_SELECTED);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            setBackground(Const.COLOR_CELL_NORMAL);
            setForeground(Const.COLOR_CELL_TEXT);
        }
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.PLAIN, 15));
        setText(value.toString());
        return this;
    }
}
