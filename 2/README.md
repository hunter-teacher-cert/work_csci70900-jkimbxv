* Notes for 2 dimensional arrays
  2d = an array of arrays
  e.g. gradeTable[0][4] --> 0 row and 4th column
* kinda depends though depending on your set up
* headings are not a part of the array
* indices must be integers within bounds of the 2d array

Initalizing 2D Int[]
int[][] gradeTable =
        {  {99, 42, 74, 83, 100},
           {90, 91, 72, 88, 95},
           {88, 61, 74, 89, 96},
           {61, 89, 82, 98, 93},
           {93, 73, 75, 78, 99},
           {50, 65, 92, 87, 94},
           {43, 98, 78, 56, 99}  };

each row can be of a different length
int[][] uneven =  { { 1, 9, 4 },
                        { 0, 2},
                        { 0, 1, 2, 3, 4 } };
be careful indexing though. you may get an IOOB error

length of a 2D array is how many rows it has. above length is 3
if you want the number of elements you must get the sum of the lengths of each row.

2d arrays are array of arrays
int[][] myArray = new int[3][];
myArray[0] = new int[3];
note: you can't do this:
myArray[0] = {1,9,4};
because 2nd array doesn't exist yet. needs to be inialized and declared first. 
