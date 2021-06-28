/*
 * Author: Jack Parsons
 * Date: 29/10/2020
 */

// Uses "Apache Commons CSV 1.7, Apache Software Foundation
// http://commons.apache.org/proper/commons-csv/
import org.apache.commons.csv.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveCSV implements Plugin
{
    // private fields
    private Writer wr; 
    private CSVPrinter pr; 
	
    /*
    setUp
    import: api (API)
    export: void
    purpose: set up the Writer and the CSVPrinter
    */
    @Override
    public void setUp(API api)
    {
        try
        {
            wr = Files.newBufferedWriter(Paths.get("Results.csv"));
            pr = CSVFormat.DEFAULT.withHeader("X", "Y").print(wr);
        }
        catch(IOException ioe)
        {
            System.out.println("Error: " + ioe.toString());
        }
    }

    /*
    begin
    import: api (API)
    export: void
    purpose: send the count and result to method to be written to file.
    */	
    @Override
    public void begin(API api)
    {
        write(api.getCount(), api.getResult());
        if((api.getCount() + api.getInc()) >= api.getMax())
        {
            clear();
        }
    }

    /*
    write
    import: x (Real), y (Real)
    export: void
    purpose: write x and y to file
    */	
    public void write(double x, double y)
    {
        try
        {
            pr.printRecord(x, y);
        }
        catch(IOException ex)
        {
            System.out.println("Error: " + ex.toString());
        }
    }

    /*
    clear
    import: void
    export: void
    purpose: 
    */	
    public void clear()
    {
        try
        {
            pr.flush();
            wr.close();
        }
        catch(IOException ioex)
        {
            System.out.println("Error: " + ioex.toString());
        }
    }
}