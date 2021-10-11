import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Board
{
	BufferedReader br;
	Random r=new Random();
	synchronized int throwDice(String pna)
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nThrow Dice for player:"+pna+" : ");
		try{br.read();}
		catch(Exception e){}
		int dice=r.nextInt(6);
		dice++;
		System.out.print("Dice is :"+dice+" for player: "+pna);
		return dice;
	}
}
class Player implements Runnable
{
	Thread th;
	String pna;
	Board bd;
	int dice=0,score=0;
	Player(String pna,Board bd)
	{
		th=new Thread(this);
		this.pna=pna;
		this.bd=bd;
		dice=0; score=0;
		th.start();
	}
	public void run()
	{
		while(score<=100)
		{
			try{Thread.sleep(3000);}
			catch(Exception e){}
			dice=bd.throwDice(pna);
			if(dice==6)
			{
				System.out.println("\nHOLA YOU HAVE GOT 6");
			}
			System.out.println("\n Previous Score is "+score);
			score=score+dice;
			if(score==100)
			{
				System.out.println("\n\nHOLA "+pna+" HAVE WON THE GAME!!!");
				System.exit(0);
			}
			else if(score>100)
			{
				score=score-dice;
			}
			else if(score==3 || score==16 || score==30 || score==39 || score==54 || score==67 || score==74 || score==83 || score==89)
			{
				System.out.println("\n"+pna+" Have Got the ladder ");
				score =score +5;
			}
			else if(score==9 || score==15 || score==29 || score==36 || score==41 || score==49 || score==58 || score==69 || score==80 || score==99)
			{
				System.out.println("\n"+pna+" Have Beaten By Snack ");
				score =score -8;
			}
			if(dice==6)
			{
				dice=bd.throwDice(pna);
				score=score+dice;
				if(score==100)
				{
					System.out.println("\n\nHOLA "+pna+" HAVE WON THE GAME!!!");
					System.exit(0);
				}
				else if(score>100)
				{
					score=score-dice;
				}
				else if(score==3 || score==16 || score==30 || score==39 || score==54 || score==67 || score==74 || score==83 || score==89)
				{
					System.out.println("\n"+pna+" Have Got the ladder ");
					score =score +5;
				}
				else if(score==9 || score==15 || score==29 || score==36 || score==41 || score==49 || score==58 || score==69 || score==80 || score==99)
				{
					System.out.println("\n"+pna+" Have Beaten By Snack ");
					score =score -8;
				}
			}
			System.out.println("\nUPDATED SCORE FOR: "+pna+" IS ->>"+score);
			System.out.println("\n----------------------------------------------------------------");
			try{Thread.sleep(3000);}
			catch(Exception e){}
		}
			
	}
}


public class Game 
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		/*System.out.println("How many Player want to play");
		int y=scan.nextInt();
		String a[]=new String[y];*/
		Board bd=new Board();
		/*for(int i=0;i<y;i++)
		{
			System.out.println("Enter the name of "+(i+1)+":");
			a[i]=scan.next();
		}
		for(int i=0;i<y;i++)
		{
			Player p=new Player(a[i],bd);
		}*/
		System.out.println("ENTER THE PLAYER NAME 1:");
		String pa1=scan.next();	
		System.out.println("ENTER THE PLAYER NAME 2:");
		String pa2=scan.next();
		Player p1=new Player(pa1,bd);
		Player p2=new Player(pa2,bd);
	}

}
