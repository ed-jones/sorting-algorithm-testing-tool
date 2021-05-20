package codetest;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class RandomArray
{
    //Creating the test array which will be passed back up for testing
    List<Integer> testArray_int;
    List<Double> testArray_double;
    List<String> testArray_string;
    
    
    //Default constructor    
    public RandomArray() {
            
    }
    //Take the input for generating an arraylist with appropriate values and assigning the values from it to the returned testArray
    public List getRandomArray(ArrayType arrayType, int length) {

        switch(arrayType) {
            //Each case creates an array of that data type and calls the appropriate method to fill with values
            //Each case also contains a print function for verification purposes. Commented out by default.
            
            //If an Integer Array is requested:
            case intArray:
                int[] intArray = randomIntArray(length);
                List<Integer> returnableIntArray = new ArrayList<Integer>(intArray.length);
                for (int i : intArray) {
                    returnableIntArray.add(i);
                }
                this.testArray_int = returnableIntArray;
                
                break;
                
                
            //If a Double Array is requested:
            case doubleArray:
                double[] doubleArray = randomDoubleArray(length);
                List<Double> returnableDoubleArray = new ArrayList<Double>(doubleArray.length);
                for (double i : doubleArray) {
                    returnableDoubleArray.add(i);
                }
                this.testArray_double = returnableDoubleArray;
                break;
            //If a String Array is requested:
            case stringArray:
                String[] stringArray = randomStringArray(length);
                /*
                for(Object value : stringArray) {
                    System.out.println(value);
                }
                */
                break;
            //default option, should be unreachable:
            default:
        }
        return this.testArray_int;
    }
    public int[] randomIntArray(int arrayLength) {
            //create random number generator
            Random rd = new Random();
            //create integer array
            int[] intArray;

            intArray = new int[arrayLength];
            
            for(int i = 0; i < intArray.length; i++) {
                intArray[i] = rd.nextInt();
            }

            return intArray;
    }
    public double[] randomDoubleArray(int arrayLength) {
        
        Random rd = new Random();
        
        double[] doubleArray;
        doubleArray = new double[arrayLength];
        
        for(int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = rd.nextDouble();
        }
        
        return doubleArray;
    }
    public String[] randomStringArray(int arrayLength) {
        String[] stringArray;
        stringArray = new String[arrayLength];
        
        
        for(int i = 0; i < stringArray.length; i++) {
            stringArray[i] = randomString();
        }
        return stringArray;
    }
    public String randomString() {
 
    Random rd = new Random();
    StringBuilder sBuilder = new StringBuilder(10);
    
    for (int i = 0; i < 10 /* i < [desired string length]*/; i++) {
        int randomLimitedInt = 97 + (int)(rd.nextFloat() * (122 - 97 + 1));
        sBuilder.append((char) randomLimitedInt);
    }
    
    String randomString = sBuilder.toString();
    return randomString;
    }
    @Override
    public String toString() {
        String readableArray = "Default Value";
        
        if(testArray_int.size() > 0) {
            readableArray = testArray_int.toString();
        } else if (testArray_double.size() > 0) {
            readableArray = testArray_double.toString();
        } else if (testArray_string.size() > 0) {
            readableArray = testArray_string.toString();
        }
        
        return readableArray;
    }
}
