/*
380. Insert Delete GetRandom O(1)
*/


class RandomizedSet {

    Map<Integer,Integer> map; // <val, index> , index == values.size();
    List<Integer> randomList;

    public RandomizedSet() {
        map = new HashMap<>();
        randomList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        else {
            map.put(val, randomList.size());
            randomList.add(val);
        }
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        else {
            int rmIndex = map.remove(val); //return the value(index) of the removed key
            int lastValue = randomList.remove(randomList.size()-1);

            //if the removed val was not the last value of the randomList
            if(rmIndex < randomList.size()){
                //copy lastValue into element being removed.
                randomList.set(rmIndex, lastValue);
                map.put(lastValue, rmIndex);
            }
            //else removing the last element.
        }
        return true;
    }

    public int getRandom() {
        return randomList.get( (int)(Math.random() * randomList.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
