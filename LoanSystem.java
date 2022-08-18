import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Loan
{
	private int accountNumber, curMonth;
	private String accountHolder;
	private String name, surname, middleName, mobileNumber;
        private double principal, rate, time, monthlyPmt, remainingBal;
        
	public Loan(int count)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Account Holder details:-");
		System.out.print("First name : ");
		name=sc.next();
		System.out.print("Middle name : ");
		middleName=sc.next();
		System.out.print("Last name : ");
		surname=sc.next();
		accountHolder=name+" "+middleName+" "+surname;
		accountHolder=accountHolder.toUpperCase();
		accountNumber=count;
                int a;
                do
                {
                    System.out.print("Mobile Number : ");
                    mobileNumber=sc.next();
                    String regex="\\d{10}";
                    Pattern pattern=Pattern.compile(regex);
                    Matcher matcher=pattern.matcher(mobileNumber);
                    if(matcher.matches())
                    {
                        a=1;
                    } else
                    {
                        System.out.println("Given phone number is not valid");
                        a=0;
                    }
                } while(a==0);
                System.out.print("Enter Principal Amount : ");
                principal=sc.nextFloat();
                System.out.print("Enter Annual Percentage Rate of Interest : ");
                rate=sc.nextFloat();
                System.out.print("Enter Total Number of Year for the Loan : ");
                time=sc.nextFloat();
                rate=rate/100; 
                time=time*12;
                curMonth = 0;  
        
                
                
                monthlyPmt = (float)((rate * principal) / (1.0-(Math.pow((1.0 + rate),(curMonth-time)))));
                

		System.out.println("Loan Account No: "+accountNumber+" Successfully created for "+accountHolder);
		System.out.println("Principal Amount:"+principal);
                System.out.println("Total Month To Pay Loan:"+time);
                System.out.print("Monthly EMI is= "+monthlyPmt+"\n");
	}
        
	public void updateName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(accountNumber+ "\t"+accountHolder);
		System.out.println("Account Holder details:-");
		System.out.print("First name : ");
		name=sc.nextLine();
		System.out.print("Middle name : ");
		middleName=sc.nextLine();
		System.out.print("Last name : ");
		surname=sc.nextLine();
		accountHolder=name+" "+middleName+" "+surname;
		accountHolder=accountHolder.toUpperCase();
		System.out.println("Account "+accountNumber+" Name updated to "+accountHolder);
	}
	public void deposit()
	{
            Scanner sc = new Scanner(System.in);
            System.out.print ("Enter Current Payment Month : ");
            curMonth=sc.nextInt();
            remainingBal=monthlyPmt * ((float)(1.0-((Math.pow((1.0+rate),(curMonth - time)))))/rate);
            System.out.println ("Balance remaining after month " + curMonth + " payment = " + remainingBal);
	}
	public boolean checkName(String str)
	{
		if(accountHolder.equals(str)) return true;
		else return false;
	}
	public void AccountInformation()
        {
            System.out.println("Loan Account:"+accountNumber);
            System.out.println("Loan Account Name:"+accountHolder);
            System.out.println("Mobile Number:"+mobileNumber);
            System.out.println("Principal Amount:"+principal);
            System.out.println("Annual Percentage Rate of Interest : "+rate);
            System.out.println("Total Mount To Pay Loan:"+time);
            System.out.println("Monthly EMI is= "+monthlyPmt);
            System.out.println("Current Payment Month:"+curMonth);
        }

	public void RemainingBal()
	{
		System.out.println ("Remaining Loan Amount Balance = " + remainingBal + "\nRemaining Payment Month"+(time-curMonth));
	}
}
public class LoanSystem
{
	public static void main(String args[])
	{
		int i,choice,count,copy;
		String str,str1;
		count=0;
		Scanner sc = new Scanner(System.in);
		Loan b[] = new Loan[100];
		do
		{
			System.out.println("\tWelcome To Loan System");
                        System.out.println("*****************Main Menu****************");
                        System.out.println("Choose One of the Option for Following List");
                        System.out.println("===========================================");
                        System.out.println("\n1 : Add New Loan Account\n2 : Change Account Holder Name\n3 : Deposit Loan Amount \n4 : Account Holder Information\n5 : Check Loan Amount Balance \n6 : Loan Calculate \n7 : exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: count=count+1;
					b[count-1] = new Loan(count);
					break;
				case 2: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].updateName();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].updateName();
					}
					break;
				case 3: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].deposit();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].deposit();
					}
					break;
				case 4: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy-1].AccountInformation();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].AccountInformation();
					}
					break;
				case 5: System.out.println("Enter account number or account holder's first name");
					str=sc.next();
					if(str.charAt(0)>='1'&&str.charAt(0)<='9')
					{
						copy=Integer.parseInt(str);
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						copy=copy-1;
						b[copy].RemainingBal();
					}
					else
					{
						System.out.print("Middle name : ");
						str1=sc.next();
						str=str+" "+str1;					
						System.out.print("Last name : ");
						str1=sc.next();
						str=str+" "+str1;
						str=str.toUpperCase();
						copy=count+1;
						for(i=0;i<=count-1;i++)
						{
							if(b[i].checkName(str))
							{
								copy=i;
								break;
							}
						}
						if(copy>count) 
						{
							System.out.println("Account not found");
							break;  
						}
						b[copy].RemainingBal();
					}
					break;
                                case 6:
                                    int m;
                                    double p, r, t,Pmt;
                                    System.out.print("Enter Principal Amount : ");
                                    p=sc.nextFloat();
                                    System.out.print("Enter Annual Percentage Rate of Interest : ");
                                    r=sc.nextFloat();
                                    System.out.print("Enter Total Number of Year for the Loan : ");
                                    t=sc.nextFloat();
                
                                    r=r/(12*100); 
                                    t=t*12;
                                    m = 0;  
                
                                    Pmt = (float)((r * p) / (1.0-(Math.pow((1.0 + r),(m-t)))));
                
                                    System.out.println("Monthly EMI is= "+Pmt+"\n");
                                    break;
				case 7: 
                                    break;
                                default :
                                    System.out.println("Invalid choice\n");
			}
		}while(choice!=7);
	}
} 						 	