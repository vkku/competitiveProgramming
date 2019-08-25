/*
https://www.hackerrank.com/challenges/vector-erase/problem

Sample Input
6
1 4 6 2 8 9
2
2 4


Sample Output
3
1 8 9

Explanation
The first query is to erase the 2nd element in the vector, which is 4.
Then, modifed vector is {1 6 2 8 9}, we want to remove the range of 2~4,
which means the 2nd and 3rd elements should be removed.
Then 6 and 2 in the modified vector are removed and we finally get {1 8 9}
*/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int size;
    int input;
    int delElem;
    vector<int> intVec;
    int limits[2];

    //Array Size
    cin>>size;

    //Input
    while(size--){
        cin>>input;
        intVec.push_back(input);
    }
    cin>>delElem;
    cin>>limits[0];
    cin>>limits[1];

    // If 1st boundary exists in range of 2nd boundaries
    if(delElem >= limits[0] && delElem < limits[1]){
        intVec.erase(intVec.begin()+limits[0]-1, intVec.begin()+limits[1]);
    }
    else{
        intVec.erase(intVec.begin()+delElem-1);
        intVec.erase(intVec.begin() + (limits[0]-1), intVec.begin() + (limits[1]-1) );
    }

    vector<int>::iterator it;

    //Printing Size
    cout<<distance(intVec.begin(), intVec.end())<<endl;

    //Final Output
    it = intVec.begin();
    while(it != intVec.end()){
        cout<<*it<<" ";
        it++;
    }

    return 0;
}
