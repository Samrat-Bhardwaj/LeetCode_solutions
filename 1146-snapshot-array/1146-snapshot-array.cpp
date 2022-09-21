class SnapshotArray {
public:
    int snap_id;
    vector<map<int,int>> arr;
    
    SnapshotArray(int length) {
        arr.resize(length);
        snap_id=0;
    }
    
    void set(int index, int val) {
        arr[index][snap_id]=val;
    }
    
    int snap() {
        return snap_id++;
    }
    
    int get(int index, int snap_id) {
        auto itr=arr[index].upper_bound(snap_id);
        
        if(itr==arr[index].begin()) return 0;
        itr--;
        return itr->second;
    }
};

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray* obj = new SnapshotArray(length);
 * obj->set(index,val);
 * int param_2 = obj->snap();
 * int param_3 = obj->get(index,snap_id);
 */