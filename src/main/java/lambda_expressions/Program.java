package lambda_expressions;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        List<IShape> shapes = Arrays.asList(new LineAdapter(new LegacyLine()), new RectangleAdapter(new LegacyRectangle()));

        int x1 = 5, y1 = 10, x2 = -3, y2 = 2;

        shapes.forEach(shape -> shape.draw(x1, y1, x2, y2));
    }
}

// ===================== INTERFACE ======================

interface IShape {
    void draw(int x1, int y1, int x2, int y2);
}

// ===================== ADAPTERS ========================

class LineAdapter implements IShape {

    private final LegacyLine legacyLine;

    public LineAdapter(LegacyLine legacyLine) {
        this.legacyLine = legacyLine;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        legacyLine.draw(x1, y1, x2, y2);
    }
}

class RectangleAdapter implements IShape {

    private final LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int w = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);

        legacyRectangle.draw(x, y, w, h);
    }
}

// ===================== LEGACY CLASSES ==================

class LegacyLine {
    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("Drawing line " + x1 + " " + y1 + " " + x2 + " " + y2);
    }
}

class LegacyRectangle {
    public void draw(int x, int y, int w, int h) {
        System.out.println("Drawing rectangle " + x + " " + y + " " + w + " " + h);
    }
}
