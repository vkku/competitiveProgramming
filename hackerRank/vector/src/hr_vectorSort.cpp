/*
https://www.hackerrank.com/challenges/vector-sort/problem
Sample Input
5
1 6 10 8 4

Sample Output
1 4 6 8 10
*/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    vector<int> inputVec;
    int size;
    int arrElem;

    //Obtain Inputs
    cin>>size;

    //Caution Ahead ! Enter char to break
    while(cin>> arrElem)
    {
        inputVec.push_back(arrElem);
    }

    sort(inputVec.begin(), inputVec.end());
    vector<int>::iterator it;
    for(it = inputVec.begin() ; it < inputVec.end() ; it++ ){
        cout<<*it<<" ";
    }

    return 0;
}
