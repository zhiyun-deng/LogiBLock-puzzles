import java.util.Hashtable;

/*Solves puzzle shown on https://www.logideez.com/shop
 * The goal is to find all ways to use irregular blocks to make a triangle with a continuous surface
 * */
public class PuzzleSolver{
	public static void main(String[] args) {
		
		int count = 1;
		String[] puzzle = new String[15];
		for (int i = 0; i<15; i++) {
			puzzle[i] = "1";
		}
		while(true) {
			if(analyse(puzzle)) {
				for (String i : puzzle) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			nextComb(puzzle);
			/*if(count%10000==0) {
				System.out.print(count);
				for (String i : puzzle) {
					System.out.println(" "+i + " ");
				}
			}*/
			count++;
		}

		/*String[] puzzle = {"3","3","1","3","3","2","2","1","1","3","3","2","1","2","3"};
		System.out.println(analyse(puzzle));*/
		
		
	}
	public static boolean useBlock(Hashtable<String, Integer> table, String seq) {
		Integer test1, test2, test3;
		String seq2, seq3;
		
		test1=table.get(seq);
	
		
		if(test1!=null && test1!=0) {
			table.put(seq, test1-1); return true;
		}
		else {
			seq2=seq.substring(1,2)+seq.substring(2,3)+seq.substring(0,1);
			test2 = table.get(seq2);
			if(test2!=null && test2!=0) {
				table.put(seq2, test2-1); return true;
			}
			else {
				seq3=seq.substring(2,3)+seq.substring(0,1)+seq.substring(1,2);
				test3 = table.get(seq3);
				if(test3!=null && test3!=0) {
					table.put(seq3, test3-1); return true;
				}
				
			}
			return false;
		}
		
		
	}
	public static String reverse(String input) {
		String res = "";
		for(int i = input.length()-1;i>=0;i--) {
			res+=input.charAt(i);
		}
		return res;
	}
	public static boolean nextComb(String[] puzzle) {
		for(int i = puzzle.length-1; i>=0; i--) {
			if(puzzle[i].equals("2")) {
				puzzle[i] = "3"; return false;
			}
			else if(puzzle[i].equals("1")){
				puzzle[i] = "2"; return false;
			}
			else if(puzzle[i].equals("3")) {
				if(i!=0) {
					if(puzzle[i-1].equals("2")) {
						puzzle[i-1] = "3"; 
						for(int j = puzzle.length-1; j>=i; j--) {
							puzzle[j]="1";
						} 
						return false;
					}
					else if(puzzle[i-1].equals("1")){
						puzzle[i-1] = "2";
						
						for(int j = puzzle.length-1; j>=i; j--) {
							puzzle[j]="1";
						}
						return false;
					}
					else {
						for (int k = i-1; k >=0; k--) {
							if(!puzzle[k].equals("3")) {
								if(puzzle[k].equals("2")) {
									puzzle[k] = "3"; 
								}
								else if(puzzle[k].equals("1")){
									puzzle[k] = "2"; 
								}
								for(int j = puzzle.length-1; j>k; j--) {
									puzzle[j]="1";
								}
								return false;
								
							}
							
						}
					}
				}
			}
			
		}
		return true;
	}
	public static boolean analyse(String[] puzzle) {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		table.put("333", 1);
		table.put("332", 3);

		table.put("331", 1);

		table.put("311", 1);
	
		table.put("223", 2);

		table.put("221", 1);

		table.put("112", 2);

		table.put("111", 1);

		//all numbers are counterclockwise
		table.put("321", 2);

		table.put("312", 2);
		String temp = "";
		temp = puzzle[0]+puzzle[1]+puzzle[2];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[2]+puzzle[1]+puzzle[4];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[1]+puzzle[3]+puzzle[4];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[2]+puzzle[4]+puzzle[5];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[3]+puzzle[6]+puzzle[7];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[3]+puzzle[7]+puzzle[4];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[4]+puzzle[7]+puzzle[8];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[4]+puzzle[8]+puzzle[5];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[5]+puzzle[8]+puzzle[9];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[6]+puzzle[10]+puzzle[11];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[6]+puzzle[11]+puzzle[7];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[7]+puzzle[11]+puzzle[12];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[7]+puzzle[12]+puzzle[8];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[8]+puzzle[12]+puzzle[13];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[8]+puzzle[13]+puzzle[9];
		if(!useBlock(table, temp)) return false;
		temp = puzzle[9]+puzzle[13]+puzzle[14];
		if(!useBlock(table, temp)) return false;
		return true;
	}
}
