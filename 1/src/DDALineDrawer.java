import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    PixelDrawer pd;

    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy)) {
            if (x1 > x2) {
                int tmp = x2;
                x2 = x1;
                x1 = tmp;
                tmp = y2;
                y1 = tmp;
            }
            double k = dy / dx;
            for (int j = x1; j <= x2; j++) {
                double i = k * (j - x1) + y1;
                this.pd.colorPixel(j, (int) i, color);
            }
        } else {
            if (y1 > y2) {
                int tmp = x2;
                x1 = tmp;
                tmp = y2;
                y2 = y1;
                y1 = tmp;
            }
            double k = dx / dy;
            for (int i = y1; i <= y2; i++) {
                double j = k * (i - y1) + x1;
                this.pd.colorPixel((int) j, i, color);
            }
        }
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y2, Color.BLACK);
    }
}
