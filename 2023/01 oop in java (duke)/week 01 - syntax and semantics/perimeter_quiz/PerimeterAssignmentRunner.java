import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // start with totalPoints = 0
        int totalPoints = 0;
        // iterate through points and add 1 for each additional
        for (Point currPt : s.getPoints()) {
            totalPoints = totalPoints + 1;
        }
        // return totalPoints
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // the average length is simply the perimeter divided by the number of points
        double perim = getPerimeter(s);
        double numpt = getNumPoints(s);
        return  perim / numpt;
    }

    public double getLargestSide(Shape s) {
        // Start with largestSide = 0
        double largestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // replace current value of largestSide with new value if new value is larger
            if (currDist > largestSide) {
                largestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // largestSide is the answer
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Start with largestX = 0
        double largestX = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // extract X value from point using 
            double xVal = currPt.getX();
            // replace current value of largestSide with new value if new value is larger
            if (xVal > largestX) {
                largestX = xVal;
            }
        }
        // largestX is the answer
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // create directory resource containing all relevant files in directory
        DirectoryResource dr = new DirectoryResource();
        // set largestPerimeter to base value 0.0
        double largestPerimeter = 0.0;
        // iterate over each directory in the directory resource, compute the perimeter
        // and assign to largestPerimeter if it is larger than current value
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > largestPerimeter) {
                largestPerimeter = length;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // create directory resource containing all relevant files in directory
        DirectoryResource dr = new DirectoryResource();
        // set largestPerimeter to base value 0.0
        double largestPerimeter = 0.0;
        // initialize variable to hold File object of largest perimeter
        File largestPerimeterFile = null;
        // iterate over each directory in the directory resource, compute the perimeter
        // and assign to largestPerimeter if it is larger than current value
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > largestPerimeter) {
                largestPerimeter = length;
                largestPerimeterFile = f;
            }
        }
        return largestPerimeterFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberPts = getNumPoints(s);
        double avgLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length +
                           "\nnumber of points = " + numberPts +
                           "\naverage length = " + avgLength + 
                           "\nlargest side = " + largestSide + 
                           "\nlargest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // print largest perimeter
        System.out.println("largest perimeter = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // print largest perimeter file name
        System.out.println("largest perimeter file name = " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
