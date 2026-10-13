/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int getImportance(Map<Integer,Employee> mp,int id)
    {
    int sum = mp.get(id).importance;
        
        if(mp.get(id).subordinates.size()==0)
            return sum;
    
    for(int sub : mp.get(id).subordinates)
        sum+=getImportance(mp,sub);
    return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> mp = new HashMap<>();
        for(Employee emp : employees)
            mp.put(emp.id,emp);
        if(!mp.containsKey(id))
            return -1;
        return getImportance(mp, id);
    }
}