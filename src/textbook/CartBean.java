package textbook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CartBean {
	private Map<Integer, ItemBean> items = new HashMap<Integer, ItemBean>();
	private int total;

		public CartBean(){
		}

		public Map<Integer, ItemBean> getItems(){
			return items;
		}

		public void addCart(ItemBean bean, int nums) {
			ItemBean item = (ItemBean) items.get(Integer.valueOf(bean.gettitle()));
			if (item == null) {
				bean.setQuantity(nums);
				items.put(Integer.valueOf(bean.gettitle()), bean);
			} else {
				item.setQuantity(nums + item.getQuantity());
			}
			recalcTotal();
		}

		public void deleteCart(int itemＩｄ) {
			items.remove(Integer.valueOf(itemＩｄ));
			recalcTotal();
		}

		public int getTotal() {
			return total;
		}

		private void recalcTotal() {
			total=0;
			Collection<ItemBean> list = items.values();
			for (ItemBean item : list) {
				total += item.getPrice() * item.getQuantity();
			}
		}
}