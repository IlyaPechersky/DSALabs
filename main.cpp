#include <bits/stdc++.h>

using namespace std;

struct Heap {
private:
    vector<int> tree;

public:
    Heap() {
        tree.push_back(0);
    }

    Heap(vector<int> &array) { // O(n) building
        tree.push_back(0);
        for (int i = 0; i < array.size(); i++) tree.push_back(array[i]);
        for (int i = (int) array.size(); i > 0; i--) {
            sift_down(i);
        }
    }

    void sift_up(int v) {
        if (v == 1) return;
        if (tree[v / 2] < tree[v]) {
            swap(tree[v / 2], tree[v]);
            sift_up(v / 2);
        }
    }

    void sift_down(int v) {
        if (v * 2 >= tree.size()) return;
        int max_idx;
        if (v * 2 + 1 == tree.size()) max_idx = v * 2;
        else if (tree[v * 2] >= tree[v * 2 + 1]) max_idx = v * 2;
        else max_idx = v * 2 + 1;

        if (tree[v] < tree[max_idx]) {
            swap(tree[v], tree[max_idx]);
            sift_down(max_idx);
        }
    }

    void push(int x) {
        tree.push_back(x);
        sift_up(tree.size() - 1);
    }

    void pop() {
        if (tree.size() > 1) {
            tree[1] = tree.back();
            tree.pop_back();
            sift_down(1);
        }
    }

    int get_max() {
        return tree.size() > 1 ? tree[1] : -1;
    }

    bool empty() {
        return tree.size() > 1;
    }

    int get_item(int idx) {
        return tree[idx + 1];
    }

    int size() {
        return tree.size() - 1;
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i];
    }

    Heap heap(array);
    for (int i = 0; i < heap.size(); i++) {
        cout << heap.get_item(i) << " ";
    }
    return 0;
}