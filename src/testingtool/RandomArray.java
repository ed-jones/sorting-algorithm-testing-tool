package testingtool;

/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Test Code to create an instance of the generator and call the RandomArray() function:

RandomArray arrayGenerator = new RandomArray();
List<Object> testArray1 = arrayGenerator.getRandomArray(ArrayType.stringArray, 10);
System.out.println(testArray1.toString());

List<Object> testArray2 = arrayGenerator.getRandomArray(ArrayType.doubleArray, 10);
System.out.println(testArray2.toString());

List<Object> testArray3 = arrayGenerator.getRandomArray(ArrayType.intArray, 10);
System.out.println(testArray3.toString());
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
public class RandomArray
{
    //Creating the test array which will be passed back up for testing
    List<Object> testArray;
    
    
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
                List<Object> returnableIntArray = new ArrayList<Object>(intArray.length);
                for (int i : intArray) {
                    returnableIntArray.add(i);
                }
                this.testArray = returnableIntArray;
                break;
            //If a Double Array is requested:
            case doubleArray:
                double[] doubleArray = randomDoubleArray(length);
                List<Object> returnableDoubleArray = new ArrayList<Object>(doubleArray.length);
                for (double i : doubleArray) {
                    returnableDoubleArray.add(i);
                }
                this.testArray = returnableDoubleArray;
                break;
            //If a String Array is requested:
            case stringArray:
                String[] stringArray = randomStringArray(length);
                List<Object> returnableStringArray = new ArrayList<Object>(stringArray.length);
                for (String i : stringArray) {
                    returnableStringArray.add(i);
                }
                this.testArray = returnableStringArray;
                break;
            //default option, should be unreachable:
            default:
        }
        return this.testArray;
    }
    //create an array of random integers
    public int[] randomIntArray(int arrayLength) {
        //create random number generator
        Random rd = new Random();
        //create integer array
        int[] intArray;
        //initialise array with given length
        intArray = new int[arrayLength];
        //set each position in the array with a random integer
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = rd.nextInt();
        }
        //return the array to the getRandomArray() function
        return intArray;
    }
    //create an array of random doubles
    public double[] randomDoubleArray(int arrayLength) {
        //create random number generator
        Random rd = new Random();
        //create double array
        double[] doubleArray;
        //Initialise array with given length
        doubleArray = new double[arrayLength];
        //set each position in the array with a random double
        for(int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = rd.nextDouble();
        }
        //return the array to the getRandomArray() function
        return doubleArray;
    }
    //create an array of random strings
    public String[] randomStringArray(int arrayLength) {
        //create String array
        String[] stringArray;
        //initialise array with given length
        stringArray = new String[arrayLength];
        //set each position in array with a random string from randomString() below
        for(int i = 0; i < stringArray.length; i++) {
            stringArray[i] = randomString();
        }
        //return the array to the getRandomArray() function
        return stringArray;
    }
        //create a single random String 
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
    //return a string of the generated array for testing purposes
    @Override
    public String toString() {
        //create a string with the array's toString() function
        String readableArray = "Default Value";
        readableArray=testArray.toString();
        //return the array in string form
        return readableArray;
    }
}
