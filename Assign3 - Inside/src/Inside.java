/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };
        System.out.println("--- Report of Points and circles ---\n");
        for (int i = 0; i < circleX.length; i++){
            for (int j = 0; j < ptX.length; j++){
                boolean inCircle = isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i]);
                reportPoint(ptX[j], ptY[j]);
                if (inCircle) {
                    System.out.print(" is inside ");
                }else {
                    System.out.print(" is outside ");
                }
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
            }
        }
        System.out.println("\n--- Report of Points and Rectangles ---\n");
        for (int i = 0; i < rectLeft.length; i++){
            for (int j = 0; j < ptX.length; j++){
                boolean inRectangle = isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                reportPoint(ptX[j], ptY[j]);
                if (inRectangle) {
                    System.out.print(" is inside ");
                }else {
                    System.out.print(" is outside ");
                }
                reportRectangle(rectLeft[i], rectWidth[i], rectTop[i], rectHeight[i]);
            }
        }
    }   

    static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        double deltaX = ptX - circleX;
        double deltaY = ptY - circleY;
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        if (distance <= circleRadius) {
            return true;
        } return false;
    }

    static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        double rightSide = rLeft + rWidth;
        double bottom = rTop - rHeight;

        if (ptX >= rLeft && ptX <= rightSide && ptY <= rTop && ptY >= bottom) {
            return true;
        } return false;
    }

    static void reportPoint(double x, double y) {
        System.out.printf("Point(%.1f, %.1f)", x, y);
    }

    static void reportCircle(double x, double y, double r) {
        System.out.printf("Circle(%.1f, %.1f) Radius: %.1f\n", x, y, r);
    }

    static void reportRectangle(double left, double width, double top, double height) {
        double rightSide = left + width;
        double bottom = top - height;
        System.out.printf("Rectangle(%.1f, %.1f, %.1f, %.1f)\n", left, top, rightSide, bottom);
    }
}
