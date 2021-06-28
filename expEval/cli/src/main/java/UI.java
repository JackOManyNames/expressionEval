/*
 * Author: Jack Parsons
 * Date: 29/10/2020
 */

import java.util.*;
import java.lang.reflect.*;

public class UI
{
    // Main method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean chc = false;
		
        // Create and keep track of the Plugins here.
        ArrayList<Plugin> pluginList = new ArrayList<Plugin>();
		
        // set up a loop for the UI
        do
        {
            System.out.println("Equation Evaluaton System: \nSelect from options below: ");
            System.out.println("1. Manage Plugins\n2. Evaluate Expression\n3. Exit");
			
            try
            {	
                int val = sc.nextInt();
	
                if(val == 1)
                {
                    System.out.println("\n1. Show current Plugins\n2. Load new Plugin");
                    int num = sc.nextInt();
                    if(num == 1)
                    {
                        showPlugins(pluginList);
                    }
                    else if(num == 2)
                    {
                        System.out.println("Enter name of Plugin: ");
                        String name = sc.next();
                        loadPlugins(pluginList, name);
                    }
                }
                else if(val == 2)
                {
                    enterExpression(pluginList);
                    chc = true;
                }
                else if(val == 3)
                {
                    chc = true;
                }
                else
                {
                    System.out.println("Not a valid option. Please try again.\n");
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println("Not a valid oInputMismatchException imeption. Please try again.\n");
            }
        } while (chc == false);
        sc.close();
    }
	
    /*
    showPlugins
    import: pluginList (ArrayList<Plugins>)
    export: void
    purpose: show the current list of plugins in use	
    */
    public static void showPlugins(ArrayList<Plugin> pluginList)
    {
        if(!pluginList.isEmpty())
        {
            for(Plugin p : pluginList)
            {
                System.out.println(p.getClass().getName());
            }
            System.out.println("\n");
        }
        else
        {
            System.out.println("No plugins currently loaded in.\n");
        }
    }
	
    /*
    loadPlugins
    import: pluginList (ArrayList<Plugins>), name (String)
    export: void
    purpose: find the Class matching the inputed name and add it to the list of Plugins.
    */
    public static void loadPlugins(ArrayList<Plugin> pluginList, String name)
    {
        try
        {
            Class<?> pc = Class.forName(name);
            Plugin obj = (Plugin) pc.getConstructor().newInstance();

            pluginList.add(obj);
        }
        catch(ClassCastException cce)
        {
            System.out.println("error: " + cce.toString());
        }
        catch(IllegalArgumentException iae)
        {
            System.out.println("error: " + iae.toString());
        }
        catch(NoSuchMethodException nsme)
        {
            System.out.println("error: " + nsme.toString());
        }
        catch(InvocationTargetException ite)
        {
            System.out.println("error: " + ite.toString());
        }
        catch(InstantiationException ie)
        {
            System.out.println("error: " + ie.toString());
        }
        catch(IllegalAccessException iace)
        {
            System.out.println("error: " + iace.toString());
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("error: " + cnfe.toString());
        }
    }
	
    /*
    enterExpression
    import: pluginList (ArrayList<Plugins>), sc (Scanner)
    export: void
    purpose: user input for the min, max, increment and expression. 
            Call ExpressionEval object to evaluate it and call start plugins.
    */
    public static void enterExpression(ArrayList<Plugin> pluginList)
    {
        try
        {
            Scanner s = new Scanner(System.in);
            ExpressionEval expEval = new ExpressionEval(pluginList);
            System.out.println("Enter a minimum: ");
            double min = s.nextDouble();
            System.out.println("Enter Maximum: ");
            double max = s.nextDouble();
            System.out.println("Enter Increment: ");
            double inc = s.nextDouble();
            System.out.println("Enter expression for evaluation: ");

            Scanner ss = new Scanner(System.in);
            String exp = ss.nextLine();
            System.out.println("Equations Calculating");
            expEval.evaluate(min, max, inc, exp);
            s.close();
            ss.close();
        }
        catch(InputMismatchException ime)
        {
            System.out.println("User has entered incorrectly. Please try again.");
        }
    }
}
