import java.util.*;
	public class prg{
		public static void main(String args[]) {
			Scanner s=new Scanner(System.in);
			int n;
			System.out.println("Enter the sizen of the data:");
			n=s.nextInt();
			int data[]=new int[n];
			System.out.println("Engtre the bit by bit:");
				for(int i=0;i<n;i++) {
					data[i]=s.nextInt();
					}
			System.out.println("Enter the sizen of the devisor:");
			n=s.nextInt();
			int devisor[]=new int[n];
			System.out.println("Enter the divisor bit by bit:");
			for(int i=0;i<n;i++) 
			devisor[i]=s.nextInt();
			int remainder[]=divide(data,devisor);
			System.out.println("\n CRC code generated is:");
			for(int i=0;i<data.length;i++)
			System.out.println(data[i]);
			for(int i=0;i<remainder.length;i++)
			System.out.println(remainder[i]);
			System.out.println();
			int sent_data[]=new int[data.length+remainder.length-1];
			System.out.println("Enter the data to be sent:");
			for(int i=0;i<sent_data.length;i++)
			sent_data[i]=s.nextInt();
			receive(sent_data,devisor);
			}
	static int[] divide(int old_data[],int devisor[]){
		int remainder[],i;
		int data[]=new int[old_data.length+devisor.length];
		System.arraycopy(old_data,0,data,0,old_data.length);
		System.out.println("Message bits after appendinbg divcisor_length-1 0's:");
		for( i=0;i<data.length-1;i++)
		System.out.println(data[i]);
		remainder=new int [devisor.length];
		System.arraycopy(data,0,remainder,0,devisor.length);
		for( i=0;i<old_data.length;i++){
		if(remainder[0]==1){
		for(int j=1;j<devisor.length;j++){
		remainder[j-1]=exor(remainder[j],devisor[j]);
	}
	}
	else {
		for(int j=1;j<devisor.length;j++)
		remainder[j-1]=exor(remainder[j],0);
		}
		remainder[devisor.length-1]=data[i+devisor.length];
		}
		return remainder;
		}
		static int exor(int a,int b){
		if(a==b)
		return 0;

return 1;
}
static void receive(int data[],int devisor[]){
int remainder[]=divide(data,devisor);
for(int i=0;i<remainder.length;i++){
if(remainder[i] !=0) {
System.out.println("Thereis an error is recived data......");
return;
}
}
System.out.println("Data was received without any error");
}
}


