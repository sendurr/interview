import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Scanner;

class StockMarket{
	
	public HashMap<Integer, LinkedList<Transaction>> dailTrade = new HashMap<Integer, LinkedList<Transaction>>();
	public TreeMap<CheatTradeInfo, String> cheatList = new TreeMap<CheatTradeInfo, String>(new Comparator<CheatTradeInfo>(){
		public int compare(CheatTradeInfo t1, CheatTradeInfo t2){
			if(t1.day>=t2.day){
				return 1;
			}else{
				return 0;
			}
		}
	}); 

	int todayPrice=0;
	
	public void processTrans(String feed){
		//String [] result = new String[cheatList.size()];
		String[] data = feed.split("\\|");
		int day = Integer.parseInt(data[0]);
		if(data.length==2){
			todayPrice=Integer.parseInt(data[1]);
			checkInsiderTrade(day);
		}else{
			Transaction trans = new Transaction();
			trans.day = day;
			trans.name = data[1];
			if(data[2].equalsIgnoreCase("BUY")){
				trans.buyOrSell = true;
			}else{
				trans.buyOrSell = false;
			}
			trans.price = todayPrice;
			trans.amt = Integer.parseInt(data[3]);
			if(dailTrade.containsKey(day)){
				LinkedList<Transaction> todayList = dailTrade.get(day);
				todayList.add(trans);
				dailTrade.replace(day, todayList);
			}else{
				LinkedList<Transaction> todayList = new LinkedList<Transaction>();
				todayList.add(trans);
				dailTrade.put(day, todayList);
			}
		}
	}
	
	/*public void updateTodayPrice(String[] data){
		todayPrice=Integer.parseInt(data[1]);
	}*/
	
	public void checkInsiderTrade(int day){
		if(day==11){
			System.out.println("Entering 11");
		}
		for(int i=day-3;i<day;i++){
			if(dailTrade.containsKey(i)){
				for(Transaction data: dailTrade.get(i)){
					CheatTradeInfo cheattrade = new CheatTradeInfo();
					cheattrade.name = data.name;
					cheattrade.day=i;
					if(!cheatList.containsKey(cheattrade)){
						int highPrice , lowPrice;
						if(data.buyOrSell){
							highPrice = todayPrice;
							lowPrice = data.price;
						}
						else{
							lowPrice = todayPrice;
							highPrice = data.price;
						}
						Integer profitAmt = (highPrice-lowPrice)*data.amt;
						if(profitAmt >= 5000000){
							cheatList.put(cheattrade, data.name+"->"+profitAmt.toString()+" trans on "+Integer.toString(day)+" Cheated on "+Integer.toString(i));
						}
					}
					
				}
			}
		}
	}
	
	public void diplayCheatList(){
		System.out.println();
		Set<Entry<CheatTradeInfo, String>> list = cheatList.entrySet();
		for(Entry<CheatTradeInfo, String> map: list){
			//System.out.println(map.getKey() + " , " + map.getValue());
			System.out.println(map.getValue());
		}
	}
}
class Transaction{
	 int day;
	 String name;
	 Boolean buyOrSell; // true = buy and false = sell
	 int price;
	 int amt;
}

class CheatTradeInfo{
	String name;
	int day;
	
	public String hashcode(){
		return name+Integer.toString(day);
	}
	
	public boolean equals(Object obj){
		CheatTradeInfo cheatCompobj = null;
		if(cheatCompobj == null){
			cheatCompobj = (CheatTradeInfo)obj;
		}
		if(cheatCompobj.name.equals(this.name) && cheatCompobj.day == this.day){
			return true;
		}else{
			return false;
		}
		
	}
}



public class catchInsideTrade {

	public static void main(String[] args) {
		StockMarket stockmarket = new StockMarket();
		Scanner p = new Scanner(System.in);
		p.de
		
		String ipFeed="0|1000\n"
				+ "0|Shilpa|BUY|30000\n"
				+ "0|Will|BUY|50000\n"
				+ "0|Tom|BUY|40000\n"
				+ "0|Kristi|BUY|15000\n"
				+ "1|Kristi|BUY|11000\n"
				+ "1|Tom|BUY|1000\n"
				+ "1|Will|BUY|19000\n"
				+ "1|Shilpa|BUY|25000\n"
				+ "2|1500\n"
				+ "2|Will|SELL|7000\n"
				+ "2|Shilpa|SELL|8000\n"
				+ "2|Kristi|SELL|6000\n"
				+ "2|Tom|SELL|9000\n"
				+ "3|500\n"
				+ "38|1000\n"
				+ "78|Shilpa|BUY|30000\n"
				+ "79|Kristi|BUY|60000\n"
				+ "80|1100\n"
				+ "81|1200\n";
		/*String ipFeed ="0|20\n"
				+ "0|Kristi|SELL|3000\n"
				+ "0|Will|BUY|500\n"
				+ "0|Tom|BUY|50000\n"
				+ "0|Shilpa|BUY|1500\n"
				+ "1|Tom|BUY|1500000\n"
				+ "3|25\n"
				+ "5|Shilpa|SELL|1500\n"
				+ "8|Kristi|SELL|600000\n"
				+ "9|Shilpa|BUY|500\n"
				+ "10|15\n"
				+ "11|5\n"
				+ "14|Will|BUY|100000\n"
				+ "15|Will|BUY|100000\n"
				+ "16|Will|BUY|100000\n"
				+ "17|25";*/
		String[] formatedFeed = ipFeed.split("[\\n\r]");
		for(String feed: formatedFeed){
			//System.out.println(feed);
			stockmarket.processTrans(feed);
		}
		stockmarket.diplayCheatList();

	}

}
