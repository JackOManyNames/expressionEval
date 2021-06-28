/*
 * Author: Jack Parsons
 * Date: 28/10/2020
 */
import java.lang.Math.*;

public class ProgBar implements Plugin
{
    // private fields
    private double top;
	
    /*
    setUp
    import: api (API)
    export: void
    purpose: sets up the top value before the start method gets run.
    */
    @Override
    public void setUp(API api)
    {
        top = api.getMax() - api.getMin();
        System.out.println("0%");
    }

    /*
    begin
    import: api (API)
    export: void
    purpose: calculate the current progress of the expressions being calculated.
    */
    @Override
    public void begin(API api)
    {
        double count = api.getCount();
        double inc = api.getInc();
        double progress = count - api.getMin();
        progress = progress + inc;
        double prog = progress * 100.0 / top;
        System.out.println(Math.round(prog) + "%");
    }
}