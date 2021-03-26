#include <iostream>
#include <stdio.h>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;
const int MAX = 1000000001;
bool visited[100001];
int monster[100001];
vector< pair<int, int> > hint[100001];
int N, M, P;

struct compare{
    bool operator()(pair<int,int> a, pair<int, int> b){
        return a.second > b.second;
    }
};

int dijkstra(){
    priority_queue< pair<int, int>, vector< pair<int, int> >, compare>pq;
    int minLevel = MAX, minIdx = 0;
    for(int i=1; i<=N; i++){
        if(monster[i] < minLevel){
            minIdx = i;
            minLevel = monster[i];
        }
    }
    pq.push(make_pair(minIdx, minLevel));
    
    int maxLevel = 0;
    pair<int, int> node;
    for(int i=0; i<M-1; i++){
        node = pq.top();
        pq.pop();
        // printf("idx: %d, level: %d\n",node.first, node.second);
        visited[node.first] = true;

        minLevel = MAX;
        for(int j=1; j<=N; j++){
            if(visited[j]) continue;

            if(P > 0 && !hint[node.first].empty()){
                for(pair<int,int> edge : hint[node.first]){
                    if(edge.first == j){
                        monster[j] -= edge.second;
                        break;
                    }
                }
            }
            if(monster[j] < minLevel){
                minIdx = j;
                minLevel = monster[j];
            }
        }
        pq.push(make_pair(minIdx, minLevel));
        maxLevel = max(node.second, minLevel);
    }
    // printf("max: %d\n", maxLevel);
    return maxLevel;
}

int main(){
    cin >> N >> M;
    for(int i=1; i<=N; i++)
        cin >> monster[i];
    
    cin >> P;
    for(int i=0; i<P; i++){
        int from, to, level;
        cin >> from >> to >> level;
        hint[from].push_back(make_pair(to, level));
        monster[to] += level;
    }

    cout << dijkstra() << endl;
}