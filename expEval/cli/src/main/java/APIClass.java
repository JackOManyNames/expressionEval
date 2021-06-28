/*
 * Author: Jack Parsons
 * Date: 28/10/2020
 */
import org.python.core.*;
import org.python.util.*;

public class APIClass implements API
{
    // privare fields
    // - the api needs to keep track of these
    //   thus that it can provide them when the
    //   plugins call them.
    private double min;
    private double max;
    private double inc;
    private double count;
    private String exp;
    private PythonInterpreter pi;
    private double y;
	
    /*
    constructor
    */
    public APIClass(double minn, double maxx, double incc, String expp, PythonInterpreter pii)
    {
        this.min = minn;
        this.max = maxx;
        this.inc = incc;
        this.exp = expp;
        this.pi = pii;
        count = 0.0;
    }
	
    /*
    getMin
    import: void 
    export: min (Real)
    purpose: accessor of the min
    */
    @Override
    public double getMin()
    {    
        return min;
    }
	
    /*
    getMax
    import: void
    export: max (Real)
    purpose: accessor of the max
    */
    @Override
    public double getMax()
    {
        return max;
    }

    /*
    getInc
    import: void
    export: inc (Real)
    purpose: accessor of the increment
    */
    @Override
    public double getInc()
    {
        return inc;
    }

    /*
    getExpression
    import: void
    export: exp (String)
    purpose: accessor of the expression
    */
    @Override
    public String getExpression()
    {
        return exp;
    }


    /*
    notifyResult
    import: y (Real)
    export: void
    purpose: update the Result stored within the API object
    */
    @Override
    public void notifyResult(double y)
    {
        this.y = y;
    }

    /*
    getCount
    import: void 
    export: count (Real)
    purpose: accessor of the count
    */
    @Override
    public double getCount()
    {
        return count;
    }
    /*
    notifyCount
    import: cnc (Real)
    export: void
    purpose: update the count variable
    */
    @Override
    public void notifyCount(double cnc)
    {
        this.count = cnc;
    }

    /*
    getResult
    import: void
    export: y (Real)
    purpose: accessor of the Result
    */
    @Override
    public double getResult()
    {
        return y;
    }

    /*
    addMathFunctions
    import: exp (String)
    export: void
    purpose: add a function to the Python Interpreter
    */
    @Override
    public void addMathFunctions(String exp)
    {
        pi.exec(exp);
    }
}