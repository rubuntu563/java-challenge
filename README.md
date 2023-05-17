# Java challenge

![alt text](img/igz.jpg)

### Instructions

Implement a REST endpoint that fetches a list of integers saved in DB. You can find the data loaded into memory in the ***data.sql*** file.
After that, process that list of integers with a service that should return a sorted list of integers based on the following criteria:

The higher number of ones in the binary representation of the integer, the closer to index 0 the element is.
In case two or more numbers have the same number of ones in their binary representation, the smaller decimal number comes first in the sorted list.


Example:

> For the input: {1,15,5,7,3} the output should be: {15, 7, 3, 5, 1}

Explanation:

| Decimal | binary |
|:-------:|:-------:|
| 1 | 1 |
| 15 | 1111 |
| 5 | 101 |
| 7 | 111 |
| 3 | 11 |

The decimal number whose binary representation contains the most ones is 15 (1111 in binary), so it goes first (index = 0). Next is 7, with three ones in its binary representation.
Then there are 2 numbers whose binary representation contains the same number of ones, these decimals are 5 and 3, both with 2 ones. In this case, the number 3 goes first (closer to index = 0) because its decimal representation is smaller (3 < 5).

The final REST endpoint should return the result of the processed list of integers.
