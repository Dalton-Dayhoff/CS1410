public class Inside {
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
        for (int i = 0; i < circleX.length; i++){
            for (int j = 0; j < ptX.length; j++){
                boolean inCircle = isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i]);
                System.out.print("The point is " + ptX[j] + "the circle is " + circleX[i]);
                System.out.println(inCircle);
            }
        }
    
    }   

    private static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        double edgeXRight  = circleX + circleRadius;
        double edgeYTop = circleY + circleRadius;
        double edgeXLeft = circleX - circleRadius;
        double edgeYBottom = circleY - circleRadius;

        if (ptX <= edgeXRight && ptX >= edgeXLeft && ptY <= edgeYTop && ptY >= edgeYBottom) {
            return true;
        }return false;
    }
}