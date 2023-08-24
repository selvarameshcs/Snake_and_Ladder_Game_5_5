import java.util.*;
class SnakeAndLadder{
	static int dc=0; //dice count checking
	public static void cubechk(int[] val,int[] cube,int v) {
		for(int i=1;i<26;i++) {
			if(cube[i]==v) {
				cube[i]=30;
			}
			cube[val[v]]=v;
		}
	}
	public static void check(int[] val,int[] cube,int v) {
		if(cube[val[v]]==30) {
			cube[val[v]]=v;
		}
		else if(cube[val[v]]==v) {
			
		}
		else {
			val[cube[val[v]]]=1;
			cube[val[v]]=v;
		}
	}
	public static void ladAndSlid(int[] slidd,int[] ladd,int[]val,int v) {
		int sl=0,lc=0;//ladder count, slidder count;
		if(val[v]==21){//snake condition;
			val[v]=2;
			sl++;
		}
		if(val[v]==14) {
			val[v]=5;
			sl++;
		}
		if(val[v]==24) {
			val[v]=16;
			sl++;
		}
		if(val[v]==4){//ladder condition;
			val[v]=12;
			lc++;
		}
		if(val[v]==6) {
			val[v]=15;
			lc++;
		}
		if(val[v]==18) {
			val[v]=23;
			lc++;
		}
		slidd[v]=slidd[v]+sl;
		ladd[v]=ladd[v]+lc;
	}
	public static int ladder(String[] players,int val[], boolean[] start,int v,int[]slidd,int[]ladd,int[] cube,int cdt) {
		Scanner sc=new Scanner(System.in);
		int ov=val[v];
		int dv=0;
		boolean rs=false;
		if(val[v]==0) {
			dv=sc.nextInt();
		if(dv==1&&val[v]==0) { 
			val[v]=dv;
			dc++;
		}
		if(val[v]==1) {
			start[v]=true;
		}
		if(start[v]){
		while(dv==1||dv==5) {
				dv=sc.nextInt();
					if(val[v]+dv<=25&&(dv<=6)) 
						val[v]=val[v]+dv;
					else if(val[v]+dv>25&&(dv<=6)) {
						rs=true;
					}
					else {
						val[v]=val[v];
					}
				dc++;
				if(val[v]==25)
					break;
				if(rs) {
					val[v]=1;
					ladAndSlid(slidd,ladd,val,v);
					check(val,cube,v);
					break;
				}else {
					rs=false;
				}
				ladAndSlid(slidd,ladd,val,v);
				check(val,cube,v);
				if(dc==cdt)
					break;
			}
		check(val,cube,v);
		cubechk(val,cube,v);
		System.out.println(players[v]+" you are in cube "+val[v]);
		return val[v];
		}
		else {
			System.out.println(players[v]+" please enter 1 to start the game ");
			return val[v];
		}
		} 
		else if(start[v]&&val[v]!=0){
			dv=sc.nextInt();
			if(val[v]+dv<=25&&(dv<=6))
				val[v]=val[v]+dv;
			else if(val[v]+dv>25&&(dv<=6)) {
				rs=true;
			}
			else
				val[v]=val[v];
		dc++;
		if(val[v]==25){
			check(val,cube,v);
			cubechk(val,cube,v);
			System.out.println(players[v]+" you are in cube "+val[v]);
			return val[v];
		}
		if(rs) {
			val[v]=ov;
			ladAndSlid(slidd,ladd,val,v);
			check(val,cube,v);
			cubechk(val,cube,v);
			return val[v];
		}else {
			rs=false;
		}
		ladAndSlid(slidd,ladd,val,v);
		check(val,cube,v);
		if(dc<cdt)
		while(dv==1||dv==5) {
			dv=sc.nextInt();
				if(val[v]+dv<=25&&(dv<=6))
					val[v]=val[v]+dv;
				else if(val[v]+dv>25&&(dv<=6)) {
					rs=true;
				}
				else
					val[v]=val[v];
			dc++;
			if(val[v]==25)
				break;
			if(rs) {
				val[v]=ov;
				ladAndSlid(slidd,ladd,val,v);
				check(val,cube,v);
				break;
			}else {
				rs=false;
			}
			ladAndSlid(slidd,ladd,val,v);
			check(val,cube,v);
			if(dc==cdt)
				break;
		}  
	check(val,cube,v);
	cubechk(val,cube,v);
	System.out.println(players[v]+" you are in cube "+val[v]);
	return val[v];
		}
		else {
			ladAndSlid(slidd,ladd,val,v);
			check(val,cube,v);
			cubechk(val,cube,v);
			System.out.println(players[v]+" you are in cube "+val[v]);
			return val[v];
		}
	} 
	public static void main(String[] args) {
		System.out.println("Welcome to Snake & Ladder Game...!");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of players: ");
		int nop=sc.nextInt();//No of players...!
		String players[]=new String[nop];
		System.out.println("Enter the player names: ");
		sc.nextLine();
		for(int i=0;i<nop;i++)
			players[i]=sc.nextLine();
		System.out.println("Enter the starting player: ");
		boolean splayer=false;
		String sp=sc.nextLine();//starting player;
		int stp=0;
		for(int i=0;i<nop;i++){
			if(sp.toLowerCase().equals(players[i].toLowerCase())) {
				stp=i;
				splayer=true;
			}
		}
		if(splayer) {
		}
		else {
			System.out.println("Entered player name not found..!\nThe game start from "+players[0]);
		}
		int val[]=new int[nop];
		int slidd[]=new int[nop];
		int ladd[]=new int[nop];
		int cube[]=new int[26];
		for(int i=0;i<26;i++) {
			cube[i]=30;
		}
		boolean start[]=new boolean[nop];
		int win=-1;
		System.out.println("Enter the count of dices thrown:");
		int cdt=sc.nextInt();//count of the dice thrown
		for(int i=stp;i<nop;i++) {
			if(dc==cdt) {
				break;
			}
			System.out.println(players[i]+" it's your turn...!");
			val[i]=ladder(players,val,start,i,slidd,ladd,cube,cdt);
			if(val[i]==25) {
				win=i;
				break;
			}
			if(i==nop-1) {
				i=-1;
			}
		}
		if(win==-1) {
			for(int i=0;i<nop;i++) {
				System.out.println(players[i]+"|"+val[i]+"|"+(25-val[i])+"|"+slidd[i]+"|"+ladd[i]);
			}
			System.out.println("Game tie");
		}
		else {
			System.out.println("Congrats "+players[win]+"....!you Won the game...!");
			for(int i=0;i<nop;i++) {
				System.out.println(players[i]+"|"+val[i]+"|"+(25-val[i])+"|"+slidd[i]+"|"+ladd[i]);
			}
			int j=0;
			for(int i=0;i<nop;i++) {
				if(val[i]==25)
					continue;
				if(val[i]!=25) {
					System.out.print(players[i]);
					j=i;
					break;
				}
			}
			for(int i=0;i<nop;i++) {
				if(i==j)
					continue;
				if(val[i]==25)
					continue;
				System.out.print(","+players[i]);
			}
			System.out.print(" lost the game");
		}
	}
}
