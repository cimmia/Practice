//此程序计算输入的两个年月日的天数差，并会对用户输入的年月日的合理性报错
package Time_Interval;
import java.util.Scanner;
public class Time_Interval {
		public static void main(String[]args){	
		Scanner in=new Scanner(System.in);
		System.out.println("Input the present time");
		System.out.println("Format:year(Press enter) month(Press Enter) day(Press Enter):");
		//Y1、M1、D1与Y2、M2、D2分别代表“当前年月日”和“先于当前的指定年月日”，为计算的需要，其中Y1、Y2定义为double类型
		double Y1=0;
		while (!in.hasNextInt()) {
			System.out.println("Error:[year]Please input an integer");
			in.next();
		}
		Y1=in.nextInt();
		int M1=0;	
		do{
		if(!in.hasNextInt()) {
			System.out.println("Error:[month]Please input an integer");
			in.next();
			continue;}
		M1=in.nextInt();
		if(M1<1||M1>12){
			System.out.println("The "+M1+"th month dosen't exist,please try again");
			continue;}//确保输入的月份是1-12中整数*/
		break;
		}while(true);

		int D1=1;
		while(true){
			if(!in.hasNextInt()) {
				System.out.println("Error:[day]Please input an integer");
				in.next();
				continue;
			}
		D1=in.nextInt();
		if(D1>MaxDay(Y1,M1)||D1<1){
			System.out.println("The "+M1+"th month doesn't have the "+D1+"th day,please input the day again");
			continue;
		}//确保输入的日期在指定月份天数范围（函数MaxDay）内*/
		break;
		};
		System.out.println("Input the former time ");
		System.out.println("Format:year(Press enter) month(Press Enter) day(Press Enter):");
		double Y2=0;
		while(true){
		if (!in.hasNextInt()) {
			System.out.println("Error:[year]Please input an integer");
			in.next();
			continue;
		}
		Y2=in.nextInt();
		if(Y2>Y1){
			System.out.println("the former year can't be later than the present time,please try again");
            continue;}
		break;
		}
		int M2=0;
		do{
			if(!in.hasNextInt()){
				System.out.println("Error:[month]Please input an integer");
				in.next();
				continue;}
			M2=in.nextInt();
			if(M2<1||M2>12){
				System.out.println("The "+M2+"th month dosen't exist,please try again");
				continue;}
			if(Y2==Y1&&M2>M1){
				System.out.println("the former month in the same year can't be later than the present month,please input the month again");
				continue; }
			break;
		}while(true);//确保输入的月份是1-12中整数并且当同一年时，月份2（M2）要早于月份1（M1）
		
		int D2=0;
		while(true){
		if(!in.hasNextInt()) {
			System.out.println("Error:[day]Please input an integer");
			in.next();
			continue;
		}
		D2=in.nextInt();
		if(D2>MaxDay(Y2,M2)||D2<1){
			System.out.println("The "+M2+"th month doesn't have the "+D2+"th day,please input the day again");
            continue;}
		if(M2==M1&&D2>D1){
					System.out.println("the former day in the same month and year can't be later than the present day,please input the day again");
					continue;}//确保输入的日期在指定月份天数范围（函数MaxDay）内,并且当同年同月时确保日期2（D2）早于日期1（D1）
		break;
		}

		int m=(int)(F(Y1,M1,D1)-F(Y2,M2,D2));//F（）计算两个不同时间与基准日期的距离，再计算它们的差，就是这两个时间的差
		int Y1_int=(int)Y1;//类型转化，输出的语句中的Y1、Y2不含小数位
		int Y2_int=(int)Y2;
		//下面根据天数决定输出语句的单复数形式
		if(m>1)
			System.out.println("The time interval between "+Y1_int+"-"+M1+"-"+D1+" and "+Y2_int+"-"+M2+"-"+D2+" are "+m+" days");
		else
			System.out.println("The time interval between "+Y1_int+"-"+M1+"-"+D1+" and "+Y2_int+"-"+M2+"-"+D2+" is "+m+" day");
		in.next();
		in.close();
		}
		
		//F(x,y,z)返回"x年y月z日"与"公元0001年01月01日"的差值天数
	    	public static double F(double year,int month,int day){
			double Intervals_to_1_1_1;int i;int sum=0;
			int []M={31,28,31,30,31,30,31,31,30,31,30,31};
			for(i=0;i<month-1;i++)
				sum=sum+M[i];
			if(Judge_leap(year)&&month>2) 
				sum++;
			Intervals_to_1_1_1=365*(year-1)+Math.floor((year-1)/4)-Math.floor((year-1)/100)+Math.floor((year-1)/400)+sum+day-1;
			return Intervals_to_1_1_1;
		    }	    	
	  //Judge——leap（year）函数判断year年是否是闰年
	    	public static boolean Judge_leap(double year){
	    		boolean leap;
	    		leap=(year%400==0||(year%100!=0&&year%4==0)) ;
	    		return leap;
	    	}   
	  //MaxDay(year,month)返回 year年year月的总天数 	
	    	public static int MaxDay(double year,int month){
	    		int []M={31,28,31,30,31,30,31,31,30,31,30,31};
	    		if(Judge_leap(year)&&month==2) 
	    			return 29;
	    		else
	    			return M[month-1];
	    	}
}