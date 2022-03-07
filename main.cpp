#include <bits/stdc++.h>

using namespace std;

template<class T>
void multiples(T& sum, T x, int n);

int main() {

}

template<class T>
void multiples(T& sum, T x, int n) {
    for (int i = 1; i <= n; i++) {
        sum += x * i;
    }
}