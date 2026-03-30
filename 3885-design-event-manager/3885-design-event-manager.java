class EventManager {
HashMap<Integer,Integer> map;
    TreeMap<Integer,TreeSet<Integer>> tmap;
    public EventManager(int[][] events) {
        map=new HashMap<>();
        tmap=new TreeMap<>(Collections.reverseOrder());
        for(int[] curr:events){
            map.put(curr[0],curr[1]);
            TreeSet<Integer> s=tmap.getOrDefault(curr[1],new TreeSet<>());
            s.add(curr[0]);
            tmap.put(curr[1], s);
        }
        
    }
    
    public void updatePriority(int eventId, int newPriority) {
        int oldPriority=map.get(eventId);
        TreeSet<Integer> temp=tmap.get(oldPriority);
        temp.remove(eventId);
        if (temp.size() == 0) {
    tmap.remove(oldPriority);
        }
        if(tmap.containsKey(newPriority)){
            tmap.get(newPriority).add(eventId);
        }
        else{
            TreeSet<Integer> s=new TreeSet<>();
            s.add(eventId);
            tmap.put(newPriority,s);
        }
        map.put(eventId,newPriority);
        
    }
    
    public int pollHighest() {
        if(tmap.size()==0) return -1;
        int highestpriority=tmap.firstKey();
        TreeSet<Integer> temp2=tmap.get(highestpriority);
        int ans=temp2.first();
        temp2.remove(ans);
        if(temp2.size()==0) tmap.remove(highestpriority);
        map.remove(ans);
        return ans;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */