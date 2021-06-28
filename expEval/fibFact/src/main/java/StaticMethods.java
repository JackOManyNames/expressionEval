/*
 * Author: Jack Parsons
 * Date: 29/10/2020
 */

public class StaticMethods
{
    /*
    factorial
    import: x (Real)
    export: retVal (Real)
    purpose: calculate the factorial of an inputted value and return it.
    */
    public static double factorial(double x)
    {
        // factorial doesn't really work well with real numbers
        int num = (int) x;
        int retVal = num;
        if(num <= 1)
        {
            retVal = 1;
        }
        else
        {
            /**
             * The following code was adapted from the following site
             * - https://www.tutorialspoint.com/javaexamples/method_factorial.htm
             * - accessed on 20 October 2020
             */
            for(int i = num; i > 1; i--)
            {
                retVal *= (i - 1);
            }
        }
        return (double) retVal;
    }

    /*
    fibonacci
    import: x (Real)
    export: retVal (Real)
    purpose: performs fibonacci sequence on imported variable.
    */
    public static double fibonacci(double x)
    {
        double first = 0.0;
        double second = 0.0;
        double retVal = 0.0;
		
        // fibonacci doesn't really work well with real numbers
        // hence it is converted into an integer
        int count = (int)x;
	
        if(count > 0)
        {
            /*
             * The following code is adapted from the following site
             * - https://www.javatpoint.com/fibonacci-series-in-java
             * - accessed on 20 October 2020
             */
            for(double i = 0; i < x; i+= 1.0)
            {
                retVal = first + second;
                first = second;
                second = retVal;
            }
        }
        return retVal;
    }
}
