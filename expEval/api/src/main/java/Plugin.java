/*
 * Author: Jack Parsons
 * Date: 28/10/2020
 */

public interface Plugin
{
    // Plugin implements two methods as opposed to one.
    // - setUp is used to setup initial variables for a plugin
    // - begin is for running methods in the plugin.
    // - this is done as a plugin may need things setup before
    //   it is run, and would allow a less messy implementation
    //   when calling the Plugins after each calculation is made.
    void setUp(API api);
    void begin(API api);
    
    /*
    To note, the API object passed in will contain all the information a plugin
    will require for a singule run of an expression. 
    Check the API object for those methods.
    Plugins will need to reconcile that it has two methods to do stuff with.
    SetUp can be used to set up initial variables, where as begin will run
    for a single interation of the loop, thus its methods should be made appropriately.
    */
}