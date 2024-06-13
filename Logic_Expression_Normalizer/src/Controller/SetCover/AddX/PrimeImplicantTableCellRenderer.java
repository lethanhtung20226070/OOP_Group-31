/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.SetCover.AddX;

import Model.PairCombination;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author LENOVO
 */
public class PrimeImplicantTableCellRenderer extends DefaultTableCellRenderer {

    private final List<List<Integer>> coverageLists;

    public PrimeImplicantTableCellRenderer(List<PairCombination> primeImplicants) {
        this.coverageLists = new ArrayList<>();
        for (PairCombination implicant : primeImplicants) {
            this.coverageLists.add(parseIndices(implicant.getIndices()));
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Set text alignment to center for all cells
        setHorizontalAlignment(CENTER); // This centers all the text in the cells
        if (column > 0) {
            List<Integer> coverage = coverageLists.get(row);
            if (coverage.contains(column - 1)) { // Assumption: minterm indices start at 0
                setText("X");
            } else {
                setText("");
            }
        }
        return this;
    }

    private List<Integer> parseIndices(String indices) {
        // Loại bỏ ký tự đặc biệt và tách chuỗi dựa trên dấu phẩy
        String[] parts = indices.replaceAll("[()]", "").split(",");
        return Arrays.stream(parts)
                .map(String::trim) // Loại bỏ khoảng trắng nếu có
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
