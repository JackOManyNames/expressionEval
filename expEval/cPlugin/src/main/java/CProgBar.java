/*
 * Author: Jack Parsons
 * Date: 29/10/2020
 */

public class CProgBar implements Plugin
{
    // private field
    private double top;
	
    /*
    setUp
    import: api (API)
    export: void
    purpose: called to set up things before the methods start.
    */
    @Override
    public void setUp(API api)
    {
        top = api.getMax() - api.getMin();
        System.out.println("0.00%");
    }
	
    /*
    begin
    import: api (API)
    export: void
    purpose: starts up the plugin as though it were the main method.
    */
    @Override
    public void begin(API api)
    {
        double count = api.getCount();
        double inc = api.getInc();
        double min = api.getMin();
        progress(top, count, inc, min);
    }
	
    /*
    static method
    purpose: used to load in the library
    */
    static 
    {
        System.loadLibrary("progBar");
    }
	
    // used to call the method progress in C code
    public native void progress(double top, double count, double inc, double min);
}