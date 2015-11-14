# java-maximum-subvector
It was a little assignment for one of my modules in college - Distributed Systems<br>
It was written in Java using NetBeans.<br><br>

Project Description:<br>
A sub-vector is a sub-list from a list of inputs. For this project, 4 text files have been provided containing 25, 1000, 100000 and 1000000 positive and negative floating point numbers. The files are named vector and then the number of numbers contained within; e.g. vector25.txt contains 25 numbers. Your task is develop code that will read in the values from these text files and then locate and evaluate that consecutive series of numbers that generates the largest sum. E.g. from the list [1, 2,-4, 5,-2, 9] the maximum sub-vector is [5, -2, 9]<br><br>

Expected Inputs:<br>
This project must take the file location as an input from the command line.
e.g.
c:\>java a1_9725814 c:\test\vector25.txt<br><br>


Expected outputs:<br>
The output of the program will be to the system.out and will contain the initial index, final index and value of the maximum sub-vector of the file supplied. From the example above this would generate:

3 (initial index)<br>
5 (final index)<br>
12 (value of max sub-vector)
