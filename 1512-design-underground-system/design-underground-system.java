class Ticket
{
    String stationName;
    int t;
     public Ticket(String stationName,int t){
        this.stationName=stationName;
        this.t=t;
     }
}
class Node
{
    String stationNameAtCheckIn;
    String stationNameAtCheckOut;
    public Node(String stationNameAtCheckIn, String stationNameAtCheckOut)
    {
        this.stationNameAtCheckIn=stationNameAtCheckIn;
        this.stationNameAtCheckOut=stationNameAtCheckOut;
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;

    if (!(obj instanceof Node))
        return false;

    Node other = (Node) obj;

    return stationNameAtCheckIn.equals(other.stationNameAtCheckIn)
        && stationNameAtCheckOut.equals(other.stationNameAtCheckOut);
}

@Override
public int hashCode() {
    return Objects.hash(stationNameAtCheckIn, stationNameAtCheckOut);
}
}
class UndergroundSystem {
    Map<Integer, List<Ticket>> cin, cout;
    Map<Node, List<Integer>> mp;
    public UndergroundSystem() {
        mp=new HashMap<>();
        cin=new HashMap<>();
        cout=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Ticket ticket =new Ticket(stationName,t);
        
        if(!cin.containsKey(id))
            cin.put(id,  new ArrayList<>(List.of(ticket)));
        else
            cin.get(id).add(ticket);
    }
    
    public void checkOut(int id, String stationName, int t) {
               Ticket ticket =new Ticket(stationName,t);
        
        if(!cout.containsKey(id))
            cout.put(id,  new ArrayList<>(List.of(ticket)));
        else
            cout.get(id).add(ticket);
    
            Ticket sTic= cin.get(id).get(cin.get(id).size()-1);
            
            if(sTic.t<ticket.t)
            {
                int diff=ticket.t - sTic.t;
                Node node =new Node(sTic.stationName,ticket.stationName);   
                List<Integer> ls = mp.get(node);
                if(ls==null)
                        mp.put(node, new ArrayList<>(List.of(diff)));
                else
                    ls.add(diff);
            }
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
            Node node = new Node(startStation,endStation);
            List<Integer> ls =mp.get(node);
            long sum=0;
            for(int s : ls)
                sum=sum+s;
            return sum/(1.0*ls.size());
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */