import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private int n;
    private final double framePadding = 100.0, dotSize = 20.0, lineWidth = 2.0;
    private double probability;

    public DrawPanel(int n, double probability) {
        this.n = n;
        this.probability = probability;
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < n; i++) {
            drawDot(g, new Coords(i));
            for (int j = 0; j < i; j++)
                if (determine())
                    drawLine(g, new Coords(i), new Coords(j));
        }
    }

    private boolean determine() {
        return Math.random() <= probability;
    }

    private void drawDot(Graphics g, Coords A) {
        g.fillOval((int) (A.x - this.dotSize / 2), (int) (A.y - this.dotSize / 2), (int) this.dotSize,
                (int) this.dotSize);
    }

    private void drawLine(Graphics g, Coords A, Coords B) {
        g.drawLine((int) A.x, (int) A.y, (int) B.x, (int) B.y);
    }

    private class Coords {
        public double x, y;
        private double rectSize = Math.min(DrawPanel.this.getWidth(), DrawPanel.this.getHeight())
                - 2 * DrawPanel.this.framePadding, offsetX = (DrawPanel.this.getWidth() - rectSize) / 2,
                offsetY = (DrawPanel.this.getHeight() - rectSize) / 2, delta = 2 * Math.PI / DrawPanel.this.n;

        Coords(int i) {
            this.x = offsetX + rectSize * 0.5 * (Math.sin(i * delta) + 1);
            this.y = offsetY + rectSize * 0.5 * (Math.cos(i * delta) + 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel(Integer.parseInt(args[0]), Double.parseDouble(args[1]));
        frame.add(panel);
        frame.setSize(1280, 1280);
        frame.setVisible(true);
        while (Double.parseDouble(args[1]) < 1 && true) {
            panel.repaint();
            Thread.sleep(600);
        }
    }
}