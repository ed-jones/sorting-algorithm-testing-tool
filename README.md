# Sorting Algorithm Testing Tool

This is a testing tool for Java that tests the validitiy and efficiency of sorting algorithms.

# Documentation

## Initialise Testing Tool

```java
TestingTool testingTool = new TestingTool<type T>(sortingAlgorithm, compareFunction);
```

## Set Expected Approximate Efficiency

```java
testingTool.setEfficiency(TestingTool.Efficiency.N_SQUARED);
```

## Add Tests to Queue

```java
testingTool.addTest(TestingTool.Tests.PRESORTED, 500);

testingTool.addTest(TestingTool.Tests.REVERSE_SORTED, 100);

testingTool.addTest(TestingTool.Tests.RANDOM, 500);

testingTool.addTest(TestingTool.Tests.NULL, 100);

testingTool.addTest([0, 1, 4]);
```

## Add Test to Queue Programmatically

```java
for (i=0; i<100; i++){

	TestingTool.addTest(TestingTool.Tests.RANDOM, i);

}
```

## Run Tests

```java
testingTool.runTests();
```
