/*
 * Author: Jack Parsons
 * Date: 29/10/2020
 * note: this file contains code based upon code obtained from external sources.
 */

public class FibFact implements Plugin
{
    /*
    setUp
    import: api (API)
    export: void
    purpose: sets up that needs to be run before the expression is calculated. 
             Calls api.addMathFunctions to implement the factorial and fibonacci functions.
    */
    @Override
    public void setUp(API api)
    {
        String expression = "from StaticMethods import factorial";
        api.addMathFunctions(expression);

        String expr = "from StaticMethods import fibonacci";
        api.addMathFunctions(expr);	
    }
	
    /*
    begin
    import: api (API)
    export: void
    purpose: does nothing as setUp does all we need it to.
    */
    @Override
    public void begin(API api)
    {
        //implements nothing as setUp already does all this plugin needs it to do.
    }
}
