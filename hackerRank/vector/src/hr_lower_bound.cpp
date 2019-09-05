#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
/*
 * Print Lower Bound Availability and Index
 */

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int size;
    int element;
    int queries;
    vector<int> intVec;

    cin>>size;
    while(size--){
        cin>>element;
        intVec.push_back(element);
    }

    vector<int>::iterator it;

    //Input query count
    cin>>size;
    while(size--){
        //Input Query Element
        cin>>element;
        vector<int>::iterator low_iter = lower_bound(intVec.begin(), intVec.end(), element);
        //cout<<*low_iter<<endl;
        it = intVec.begin();
        bool flag = true;
        while(flag){

        if(*low_iter == *it){
            flag = false;
            // If element itself is present
            if(*it == element)
                cout<<"Yes"<<" ";
            else
                cout<<"No"<<" ";
        }
         it++;

        }

        //Print element position (Index Stating from 1)
        cout<<distance(intVec.begin(), it)<<endl;

    }


    return 0;
}
