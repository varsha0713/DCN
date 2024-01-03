 import java.math.*;
import java.util.*;
import java.util.Random;
import java.io.*;
import java.lang.*;
public class lea{
public static void main(String args[]){
int drop=0,mini,i,o_rate,b_size,nsec,p_remain=0;
int packet[]=new int[100];
Scanner in=new Scanner(System.in);
System.out.print("enter the bucket size:\n");
b_size=in.nextInt();
System.out.print("enter the output rate:\n");
o_rate=in.nextInt();
System.out.print("enter the number of seconds to stimulate:\n");
nsec=in.nextInt();
Random rand = new Random();
for(i=0;i<nsec;i++)
packet[i]=(rand.nextInt(1000));
System.out.println("seconds | packets recieved | packets sent | packet left | packet dropped");
		System.out.println("---------------------------------------------------------------------");
for(i=0;i<nsec;i++){
		p_remain+=packet[i];
		if(p_remain>b_size){
			drop=p_remain-b_size;
			p_remain=b_size;
			System.out.print(i+1+" \t\t");
			System.out.print(packet[i]+" \t\t");
			mini=Math.min(p_remain,o_rate);
			System.out.print(mini+" \t\t");
			p_remain=p_remain-mini;
			System.out.print(p_remain+" \t\t");
			System.out.print(drop+" \t\t");
			System.out.println(" \t\t");
			drop=0;
			}
		}
	while(p_remain!=0){
		if(p_remain>b_size){
			drop=p_remain-b_size;
		}
		mini=Math.min(p_remain,o_rate);
		System.out.print(" \t\t"+p_remain+" \t\t"+mini);
		p_remain=p_remain-mini;
		System.out.println(" \t\t"+p_remain+ " \t\t" +drop);
		drop=0;
		}
	}
}

