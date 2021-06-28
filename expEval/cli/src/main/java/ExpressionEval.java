/*
 * Author: Jack Parsons
 * Date: 29/10/2020
 */

import org.python.core.*;
import org.python.util.*;
import java.util.List;
import java.util.ArrayList;


public class ExpressionEval
{
    private PythonInterpreter pi;
    private ArrayList<Plugin> pl;
    public API api;
	
    /*
    Constructor
    */
    public ExpressionEval(ArrayList<Plugin> pluginList)
    {
        pi = new PythonInterpreter();
        pl = pluginList;
    }
	
    /*
    evaluate
    import: min (Real), max (Real), inc (Real), exp (String)
    export: void
    purpose: check if there are plugins or not. If not, call the methods that
             evaluates the inputted expression. 
       	     Else, send the data through to the method that evaluates with plugins in mind.
             If there are no plugins, there isn't much point in calling a method that would
	     handle things as if there were.
    */
    public void evaluate(double min, double max, double inc, String exp)
    {
        if(pl.isEmpty())
        {
            evaluateNoPlugins(min, max, inc, exp);
        }
        else
        {
            evaluatePlugins(min, max, inc, exp);
        }
    }
	
    /*
    startPlugins
    import: api (API object)
    export: void
    purpose: calls the setUp methods of all plugins in the Plugin List.
    */
    public void setUpPlugins(API api)
    {
        for(Plugin p : pl)
        {
            p.setUp(api);
        }
    }
	
    // evaluation methods
    //-----------------------------------------------------------------------------
	
    /*
    evaluateNoPlugins
    import: min (Real), max (Real), inc (Real), exp (String)
    export: void
    purpose: evaluates the expression for each iteration between the range of min and max using
            the increment supplied. 
            Makes use of Jython to evaluate expressions. 
    */
    public void evaluateNoPlugins(double min, double max, double inc, String exp)
    {
        for(double x = min; x < max; x += inc)
        {
            pi.set("x", x);
            double y = ((PyFloat) pi.eval("float(" + exp + ")")).getValue();
        }
    }
	
    /*
    evaluatePlugins
    import: min (Real), max (Real), inc (Real), inc (Real), exp (String)
    export: void
    purpose: evaluate a user inputted expression, iterating for all values of x
             between the min and max with plugins in mind. We do not know 
             what these plugins might do, only that they exist. Hence, we create
             an API object and send them into the Plugin methods.
    */
    public void evaluatePlugins(double min, double max, double inc, String exp)
    {
        api = new APIClass(min, max, inc, exp, pi);
        setUpPlugins(api);
	
        for(double i = min; i < max; i += inc)
        {
            pi.set("x", i);
            double y = ((PyFloat) pi.eval("float(" + exp + ")")).getValue(); 
            api.notifyResult(y);
            api.notifyCount(i);
            for(Plugin p : pl)
            {
                p.begin(api);
            }
        }
    }
}