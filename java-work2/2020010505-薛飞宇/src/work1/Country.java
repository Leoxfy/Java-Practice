package work1;

public class Country implements Comparable{
	String name;
	int gold;
	int silver;
	int bronze;
	public Country(String n, int g, int s, int b) {
		name = n;
		gold = g;
		silver = s;
		bronze = b;
	}
	@Override
	public int compareTo(Object o) {
		Country rightCountry = (Country) o;
		if(this.gold!=rightCountry.gold) {
			return rightCountry.gold - this.gold;
		}else if(this.silver!=rightCountry.silver){
			return rightCountry.silver - this.silver;
		}else {
			return rightCountry.bronze - this.bronze;
		}
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + "]";
	}
	
}
