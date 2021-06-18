package textbook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CartBean {
	private Map<Integer, TextbookBean> items = new HashMap<Integer, TextbookBean>();
	private int total;

		public CartBean(){
		}

		public Map<Integer, TextbookBean> getItems(){
			return items;
		}

		public void addCart(TextbookBean bean) {
			TextbookBean item = (TextbookBean) items.get(Integer.valueOf(bean.getId()));
			if (item == null) {
				items.put(Integer.valueOf(bean.getId()), bean);
			}
			recalcTotal();
		}

		public void deleteCart(int textId) {
			items.remove(Integer.valueOf(textId));
			recalcTotal();
		}

		public int getTotal() {
			return total;
		}

		private void recalcTotal() {
			total=0;
			Collection<TextbookBean> list = items.values();
			for (TextbookBean item : list) {
				total += item.getPrice();
			}
		}
}