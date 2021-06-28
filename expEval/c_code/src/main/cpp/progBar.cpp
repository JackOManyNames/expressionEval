/*
 * Author: Jack Parsons
 * Date: 28/10/2020
 */
#include <jni.h>
#include <stdio.h>
#include <math.h>

extern "C"
{
    /*
    progress
    import: env (Pointer to JNIEnv), cls (jclass), top (jdouble), count (jdouble), inc (jdouble), min (jdouble)
    export: void
    purpose: show the progress of the calculations by calculating the total percetage done.
    */
    JNIEXPORT void JNICALL Java_CProgBar_progress(JNIEnv *env, jclass cls, jdouble top, jdouble count, jdouble inc, jdouble min)
    {
        jdouble result;
        jdouble progress;
        
        progress = (count - min) + inc;
        result = progress * 100 / top;
        printf("%.2lf%% \n", round(result));
    }
}