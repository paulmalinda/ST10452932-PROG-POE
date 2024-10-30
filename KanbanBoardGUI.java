/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KanbanBoardGUI {
    private JFrame frame;
    private JPanel todoPanel, doingPanel, donePanel;
    private final ArrayList<Task> tasks;

    public KanbanBoardGUI(ArrayList<Task> tasks) {
        this.tasks = tasks;
        setupFrame();
    }

    private void setupFrame() {
        frame = new JFrame("Kanban Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(1, 3));

        // Initialize columns
        todoPanel = createTaskColumn("To Do");
        doingPanel = createTaskColumn("Doing");
        donePanel = createTaskColumn("Done");

        frame.add(todoPanel);
        frame.add(doingPanel);
        frame.add(donePanel);

        updateBoard();
        frame.setVisible(true);
    }

    private JPanel createTaskColumn(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    public void updateBoard() {
        todoPanel.removeAll();
        doingPanel.removeAll();
        donePanel.removeAll();

        for (Task task : tasks) {
            JLabel taskLabel = new JLabel("<html>" + task.getTaskSummary() + "</html>");
            taskLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            switch (task.getTaskStatus()) {
                case "To Do" -> todoPanel.add(taskLabel);
                case "Doing" -> doingPanel.add(taskLabel);
                case "Done" -> donePanel.add(taskLabel);
            }
        }

        todoPanel.revalidate();
        doingPanel.revalidate();
        donePanel.revalidate();
        todoPanel.repaint();
        doingPanel.repaint();
        donePanel.repaint();
    }
}
