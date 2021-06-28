/*
 * Author: Jack Parsons
 * Date: 28/10/2020
 */

public interface API
{
    // methods to get the 4 different inputs
    double getMin();
    double getMax();
    double getInc();
    String getExpression();
	
    // notify the API that a new Y value is available
    void notifyResult(double y);

    // there may be plugins that require the current count of the
    // expression for loop. Hence, methods to get from and notify
    // tha api are included
    void notifyCount(double cnc);
    double getCount();
	
    // method to get y value
    double getResult();
	
    //method to add more maths functions
    void addMathFunctions(String val);
}
