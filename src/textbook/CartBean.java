package textbook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CartBean {
private Map<Integer,ItemBean>items=new HashMap<Integer,ItemBean>();
private int total;

public CartBean(){
}

public Map<Integer,ItemBean>getItems(){
	return items;
}

public void addCart(ItemBean bean,int nums){
	ItemBean item=(ItemBean) items.get(Integer.valueOf(bean.getCode()));
	if (item ==null) {
		bean.setQuantity(nums);
		items.put(Integer.valueOf(bean.getCode()),bean);
	}else{
		item.setQuantity(nums+item.getQuantity());
	}
		recalcTotal();

	}
	public void deleteCart(int itemCode) {
		items.remove(Integer.valueOf(itemCode));
		recalTotal();
	}
public int getTotal() {
	return total;
}
private void recalTotal() {
	total=0;
	Collection<ItemBean>list=items.values();
	total +=item.getprice()*item.geQuantity();
}
}
}