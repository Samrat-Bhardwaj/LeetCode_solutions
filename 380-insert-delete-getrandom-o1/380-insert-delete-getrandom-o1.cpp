class RandomizedSet {
public:
    vector<int> arr;
    unordered_map<int,int> map; // key vs index
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if(map.find(val)==map.end()){
            map[val]=arr.size();
            arr.push_back(val);
            return true;
        } else {
            return false;
        }
    }
    
    bool remove(int val) {
        if(map.find(val)==map.end()){
            return false;
        } else {
            int idx=map[val];
            
            int last=arr.back();
            
            arr[idx]=last;
            map[last]=idx;
            
            arr.pop_back();
            map.erase(val);
            
            return true;
        }
    }
    
    int getRandom() {
        return arr[rand() % arr.size()];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */