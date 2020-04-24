import java.util.ArrayList;

public class ContainerItem extends Item{
	
	private ArrayList<Item> items;
	
	public ContainerItem(String name, String type, String description) {
		super(name, type, description);
		this.items = new ArrayList<>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public boolean hasItem(String name)
	{
		for(int i = 0; i < items.size(); i++)
		{
			if(this.items.get(i).getName().toLowerCase().equals(name.toLowerCase()))
				return true;
		}
		
		return false;
	}
	
	public Item removeItem(String name)
	{
		for(int i = 0; i < items.size(); i++)
		{
			if(this.items.get(i).getName().toLowerCase().equals(name.toLowerCase()))
			{
				Item m = new Item(this.items.get(i));
				items.remove(i);
				return m;
			}
		}
		return null;
	}
	
	@Override
	public String toString() 
	{
		String contents = "";
		for (Item item: this.items)
			contents = contents + "\n+ " + item.getName() + "-" + item.getType() + "-" + item.getDescription();
		if (contents.length() == 0)
			return "The inventory is emtpy";
		return super.getName() + " [" + super.getType() + "]: " + super.getDescription() + " that contains:" + contents; 
	}
}
