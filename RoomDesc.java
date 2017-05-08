import java.util.*;

public class RoomDesc
{
    private String body, itemInfo;
    private ArrayList<Item> items;
    public RoomDesc(String desc, ArrayList<Item> stuff)
    {
        items = stuff;
        body  = desc;
        itemInfo = "";
        
        for( int k = 0; k < items.size(); k++)
        {
            itemInfo += "\nA" + items.get(k).getName() + " " + items.get(k).getLocation();
        }
    }
    
    public void addItem(Item newItem)
    {
        items.add(newItem);
        itemInfo += "\nA" + newItem.getName() + " " + newItem.getLocation();
    }
    
    public void removeItem(String name)
    {
        boolean found = false;
        int index = -1;
        
        for(int k = 0; k < items.size(); k++)
        {
            if( name.toUpperCase().equals(items.get(k).getName().toUpperCase()))
            {
                found = true;
                index = k;
            }
        }
        
        if(found && index != -1)
        {   items.remove(index);
            itemInfo = "";
            for( int k = 0; k < items.size(); k++)
            {
                itemInfo += "\nA" + items.get(k).getName() + " " + items.get(k).getLocation();
            }
        }
    }
        
    public String getDescription()
    {
        return body + itemInfo;
    }
    
    public void setBody(String nBody)
    {
        body = nBody;
    }

        

}
