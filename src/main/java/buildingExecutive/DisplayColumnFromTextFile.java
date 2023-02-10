/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildingExecutive;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplayColumnFromTextFile {

  public static void main(String[] args) {

    // Read the text file into an ArrayList
    ArrayList<String[]> rows = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("src/textFiles/securityLogin.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] columns = line.split(",");
        rows.add(columns);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Extract the desired column
    ArrayList<String> columnData = new ArrayList<>();
    int columnIndex = 0; // The index of the desired column (0-based)
    int columnIndex2 = 1;
    for (String[] row : rows) {
      columnData.add(row[columnIndex]);
      columnData.add(row[columnIndex2]);
    }

    // Create a JFrame and add a JTable to it
    JFrame frame = new JFrame("Display Column from Text File");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Column", columnData.toArray());
    JTable table = new JTable(model);
    frame.add(new JScrollPane(table), BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }
}
