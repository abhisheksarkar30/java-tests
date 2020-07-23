package edu.abhi.test.school;

/**
 * Console based Restaurant Management application designed on BlueJ environment.
 *
 * @author Abhishek Sarkar
 */
import java.io.*;//Imports Input/Output Package
public class TAAZ_RESTAURANT//Class Declaration
{
    public static void main(String args[])throws IOException//Main Function Declaration
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //Creation Of Database Of Food Items According To Food Types
        String type1[]={"Bhetki Macher Paturi","Hilsa Fry","Lemon Rice","Potato Chips","Shukto","Peas Pilao","Brinjal Fry(Beguni)","Rasogolla","Sweet Curd","Potoler Dolma"};
        int cp1[]={45,25,14,8,7,50,5,5,12,60},sp1[]={60,35,20,12,10,65,7,7,20,75};
        String type2[]={"Chilli Chicken(4 pcs)","Hakka Noodles with Gravy","Chicken FriedRice","Chicken Dumblings(3 pcs)","Honey Noodles","Chicken Manchurian(4 pcs)","Momos","Sushi","Hongkong Chicken(5 pcs)","Soup(Chicken Clear Soup)"};
        int cp2[]={60,75,100,40,55,70,35,60,70,20},sp2[]={75,90,125,55,70,90,50,75,85,35};
        String type3[]={"Chicken Biriyani","Mutton Biriyani","Paneer Tikka Kabab","Chicken Sami Kabab","Moglai Paratha","Butter Nun","Lachcha Paratha","Chicken Reshmi Kabab","Chicken Chap(1 pc)","Tandoori Chicken"};
        int cp3[]={75,75,40,75,20,6,8,80,75,70},sp3[]={90,90,60,95,35,10,12,100,90,85};
        String type4[]={"Aloo Paratha with Pickles","Butter Chicken","Lassi","Corn Chapattis","Haldi Milk","Chicken Dopiaza","Chicken Bharta","Doli Dal","Tarka with Rajma","Sarson Ka Saang(With Kashundi)"};
        int cp4[]={20,75,14,8,14,80,85,40,25,25},sp4[]={27,100,20,12,20,95,120,55,40,40};
        String type5[]={"Chicken Leg Roast(1 pc)","Turkey Fry","Americal Chopsuey","Eggless Pastries","Turkish Delight","Mock Tel","French Fries","Pizzas","Club Sandwich","Burgers"};
        int cp5[]={65,225,80,25,30,55,15,280,30,30},sp5[]={80,300,100,40,45,70,25,350,45,45};
        String type[]=new String[10];int cp[]=new int[10],sp[]=new int[10];
        int hd,s=0,ch,c=0,like,choose,se,nos,seat,total_cp=0,total_sp=0,net_profit,select_cp[]=new int[50],select_sp[]=new int[50],select_quan[]=new int[50];
        double vat,hd_amt=0,total_amount;
        String select_item[]=new String[50];
        for(int i=1;i<=3;i++)
        {
            System.out.print("The System is loading some essential documents...\nPlease Wait while the page is loading");
            for(int p=1;p<=4;p++)
            {
                for(int j=1;j<=999999999;j++)
                {
                }
                if(p!=4)
                System.out.print(".");
                else
                System.out.print("\f");
            }
        }
        System.out.println("The System has loaded all the essential documents needed!\nThe Page is Succesfully Loaded!");
        System.out.println("\nTHANK YOU for your Patience!\nThe Process is Starting now!\n\n");
        for(int i=1;i<=3;i++)
        {
            for(int p=1;p<=2;p++)
            {
                for(int j=1;j<=999999999;j++)
                {
                }
            }
            switch(i)
            {
                case 1:System.out.println("How Do you like to start the management System?");break;
                case 2:System.out.println("\t1: With Welcome Screen\n\t2: Without Welcome Screen");break;
                case 3:System.out.print("\n\nEnter Your Choice:\t");break;
            }
        }
        like=Integer.parseInt(br.readLine());
        if(like==1)
        {
            for(int i=1;i<=3;i++)
            {
                System.out.println("\f");
                for(int j=1;j<=999999999;j++)
                {
                }
                System.out.println("\t\t*       *   * * * * *   *            * * *     * * *    *       *   * * * * *");
                System.out.println("\t\t*       *   *           *           *     *   *     *   * *   * *   *        ");
                System.out.println("\t\t*   *   *   * * *       *           *         *     *   *   *   *   * * *    ");
                System.out.println("\t\t* *   * *   *           *           *     *   *     *   *       *   *        ");
                System.out.println("\t\t*       *   * * * * *   * * * * *    * * *     * * *    *       *   * * * * *");
                System.out.println("\n\n");
                if(i==1)
                {
                    for(int j=1;j<=999999999;j++)
                    {
                    }
                }
                System.out.println("\t\t\t\t\t   * * * * *    * * * ");
                System.out.println("\t\t\t\t\t       *       *     *");
                System.out.println("\t\t\t\t\t       *       *     *");
                System.out.println("\t\t\t\t\t       *       *     *");
                System.out.println("\t\t\t\t\t       *        * * * ");
                System.out.println("\n\n");
                if(i==1)
                {
                    for(int j=1;j<=999999999;j++)
                    {
                    }
                }
                System.out.println("\t\t\t* * * * *           *                   *           * * * * *");
                System.out.println("\t\t\t    *             *   *               *   *               *  ");
                System.out.println("\t\t\t    *           * * * * *           * * * * *           *    ");
                System.out.println("\t\t\t    *         *           *       *           *       *      ");
                System.out.println("\t\t\t    *       *               *   *               *   * * * * *");
                for(int p=1;p<=2;p++)
                {
                    for(int j=1;j<=999999999;j++)
                    {
                    }
                }
            }
            System.out.println("\n\n\n\t\t\t ****************A Maker Of Delicious Cuisines***************\n\n");
            for(int j=1;j<=999999999;j++)
            {
            }
            System.out.println("\n\n\t\t\t                     <<<<< ADDRESS >>>>>                      \n");
            System.out.println("\t\t\t |----------------------------------------------------------|");
            System.out.println("\t\t\t | 34 B, BELVERDERE ROAD, ALIPORE, KOLKATA -700 027 (INDIA) |");
            System.out.println("\t\t\t |    Phone :033-2346-3454, Fax :033-2229-4456/2229-7761    |");
            System.out.println("\t\t\t |               Website :www.taazrestaurant.com            |");
            System.out.println("\t\t\t |__________________________________________________________|");
            for(int p=1;p<=5;p++)
            {
                for(int j=1;j<=999999999;j++)
                {
                }
            }
            System.out.println("\f\n\n\t\t\t\t\tCopyrights (©)   Reserved");
            System.out.println("\n\n\n\t\t\t\t   ***********IMPORTANT NOTE***********\n");
            System.out.println("\t\t\tThis Restaurant Management System has been made with res-");
            System.out.println("\t\t\terved copyrights & permissions granted from Indian Govt.");
            System.out.println("\t\t\tNo part of this system ormore clearly, no duplication of");
            System.out.println("\t\t\tthis system must take place otherwise under the reserved");
            System.out.println("\t\t\tCopyrights' penalty law, the offender may be jailed or");
            System.out.println("\t\t\tmay be fined to a sum upto Rs. 10000/- or both!!!\n\n\n");
            for(int p=1;p<=4;p++)
            {
                for(int j=1;j<=999999999;j++)
                {
                }
                switch(p)
                {
                    case 1:System.out.println("\t\t\tFor More Details, You can mail in the following Id(s):");break;
                    case 2:System.out.println("\n\n\t\t\tAbhishek(Group Leader):\tabhishek.sarkar30@yahoo.co.in");break;
                    case 3:System.out.println("\t\t\t                       \tabhisheksarkar30@gmail.com");break;
                    case 4:System.out.println("\n\t\t\tDrimit(Seniour Group Member):\tdrimit.kolkata@gmail.com");break;
                }
            }
            for(int p=1;p<=7;p++)
            {
                for(int j=1;j<=999999999;j++)
                {
                }
            }
            System.out.print("\f\n\n\n\n\n\n");
            for(int i=1;i<=8;i++)
            {
                for(int p=1;p<=2;p++)
                {
                    for(int j=1;j<=999999999;j++)
                    {
                    }
                }
                switch(i)
                {
                    case 1:System.out.println("\t\t   You are currently using the v3.0 of the program RESTAURANT MANAGEMENT\n\n\n\n");break;
                    case 2:System.out.println("\t\t                       *****Brought To You By*****                     \n");break;
                    case 3:System.out.println("\t\t                          MEGASOFT CORPORATIONS                        \n\n\n\n\n");break;
                    case 4:System.out.println("\t\t                      *****Presented To You By*****                    \n");break;
                    case 5:System.out.println("\t\t                           Abhishek & His Team                         \n\n\n\n\n");break;
                    case 6:System.out.println("\t\t                         *****Sponsored By*****                        \n");break;
                    case 7:System.out.println("\t\t                            JULIEN DAY SCHOOL                          ");break;
                    case 8:System.out.println("\t\t                               GANGANAGAR                              ");break;
                }
            }
            for(int p=1;p<=3;p++)
            {
                for(int j=1;j<=999999999;j++)
                {
                }
            }
            System.out.println("\f");
            System.out.println("\t\t\t\t\t**************************");
            System.out.println("\t\t\t\t\t* ********************** *");
            System.out.println("\t\t\t\t\t* *      CREDITS       * *");
            System.out.println("\t\t\t\t\t* ********************** *");
            System.out.println("\t\t\t\t\t**************************");
            System.out.println("\n\t\t\t\t---------Each Group Member's Work---------\n\n");           
            for(int i=1;i<=15;i++)
            {
                for(int p=1;p<=2;p++)
                {
                    for(int j=1;j<=999999999;j++)
                    {
                    }
                }
                switch(i)
                {
                    case 1:System.out.println("\t\t*************Creation of Modules, Algorithm & Presentation By*************");break;
                    case 2:System.out.println("\t\t                          Master Abhishek Sarkar                          \n\n");break;
                    case 3:System.out.println("\t\t***************Food Type Grouping & Rating of Food Items By***************");break;
                    case 4:System.out.println("\t\t                            Master Drimit Ghosal                          \n\n");break;
                    case 5:System.out.println("\t\t*******************Provided with Help in Presentation By******************");break;
                    case 6:System.out.println("\t\t                            Master Debankur Roy                           ");break;
                    case 7:System.out.println("\t\t                            Master Arjun Sarkar                           \n\n");break;
                    case 8:System.out.println("\t\t********************Seat booking & Profit calcutaion by*******************");break;
                    case 9:System.out.println("\t\t                              Master Nilava Dey                           ");break;
                    case 10:System.out.println("\t\t                              Master Saif Azad                            \n\n");break;
                    case 11:System.out.println("\t\t*******************Home delivery, tax & Billing made by*******************");break;                   
                    case 12:System.out.println("\t\t                           Master Rakesh Bhadra                           ");break;
                    case 13:System.out.println("\t\t                           Master Sanket Biswas                           ");break;
                    case 14:System.out.println("\t\t                           Master Dabarghya Pal                           ");break;
                    case 15:System.out.println("\t\t                        Master Pronay Chakroborty                         ");break;
                }
            }
            for(int p=1;p<=5;p++)
            {
                for(int j=1;j<=999999999;j++)
                {
                }
            }
        }
        if(like==1||like==2)
        {
            System.out.println("\f");
            System.out.println("\n\n\n\n\t\t\t\tDoes the Customer want to book seats!\n\t\t\t\t1: Yes\n\t\t\t\t2: No");
            do
            {
                System.out.print("\n\t\t\t\tEnter Cutomer's choice:\t");
                se=Integer.parseInt(br.readLine());
                if(se==1)
                {
                    System.out.print("\n\n\t\t\t\tEnter number of seats:\t");
                    nos=Integer.parseInt(br.readLine());
                    seat=(int)(Math.random()*200);
                    System.out.println("\n\n\t\t\t\tThe seats are:-");
                    for(int i=1;i<=nos;i++)
                    {
                        if((seat+nos-1)<=200)
                        System.out.println("\t\t\t\t"+(seat+i-1));
                        else
                        System.out.println("\t\t\t\t"+(seat-nos+i));
                    }
                    for(int p=1;p<=7;p++)
                    {
                        for(int j=1;j<=999999999;j++)
                        {
                        }
                    }
                }
                else if(se==2)
                break;
                else
                System.out.println("\n\n\t\t\t\tWrong Choice Entered!!!\n\t\t\t\tRe-enter a valid choice!\n");
            }while(se!=1&&se!=2);
            System.out.println("\f");
            do//Starting of Outer-Loop:Chooses Food Type
            {
                System.out.println("\t\t  <<<<-Select The Desired Food Type->>>>\n");
                System.out.println("\t\t\t**************************");
                System.out.println("\t\t\t* ********************** *");
                System.out.println("\t\t\t* *   1. Bengali       * *");
                System.out.println("\t\t\t* *   2. Chinese       * *");
                System.out.println("\t\t\t* *   3. Moglai        * *");
                System.out.println("\t\t\t* *   4. Punjabi       * *");
                System.out.println("\t\t\t* *   5. Continental   * *");
                System.out.println("\t\t\t* ********************** *");
                System.out.println("\t\t\t**************************");
                System.out.print("\n\t\t\t   6. CLS   0. QUIT");
                System.out.print("\n\n\t\tEnter Food type the customer wants:\t");
                ch=Integer.parseInt(br.readLine());
                if(ch==0)
                break;
                else if(ch==6)
                System.out.print("\f");
                else if(ch<0||ch>6)
                System.out.println("\f\t\t   Sorry!!! Invalid Food Type chosen!!!\n\n\t\t   You need to choose the type again!!!");
                else
                {
                    //start of switch block
                    switch(ch)
                    {
                        case 1:type=type1;cp=cp1;sp=sp1; break;
                        case 2:type=type2;cp=cp2;sp=sp2; break;
                        case 3:type=type3;cp=cp3;sp=sp3; break;
                        case 4:type=type4;cp=cp4;sp=sp4; break;
                        case 5:type=type5;cp=cp5;sp=sp5; break;
                    }//end of switch block
                    System.out.println("\f\t\t\t****************************");
                    System.out.println("\t\t\t* ************************ *");
                    switch(ch)
                    {
                        case 1:System.out.println("\t\t\t* *       Bengali        * *");break;
                        case 2:System.out.println("\t\t\t* *       Chinese        * *");break;
                        case 3:System.out.println("\t\t\t* *        Moglai        * *");break;
                        case 4:System.out.println("\t\t\t* *       Punjabi        * *");break;
                        case 5:System.out.println("\t\t\t* *      Continental     * *");break;
                    }
                    System.out.println("\t\t\t* ************************ *");
                    System.out.println("\t\t\t****************************\n");
                    System.out.println("\t\t   <<<<-Select The Desired Food Item->>>>\n");
                    System.out.println("\t\t   Sl.No.\tRate\t\tFood Items");
                    for(int i=0;i<10;i++)
                    System.out.println("\t\t   "+(i+1)+".\t\tRs. "+sp[i]+"\t\t"+type[i]);
                    System.out.println("\n\t\tPress '0' to go back to the Main Menu of Choosing Type\n\n");
                    do//Starting of Inner-Loop:Chooses Food Items
                    {
                        System.out.print("\n\t\tEnter the food item the customer wants:\t\t");
                        choose=Integer.parseInt(br.readLine());
                        if(choose>=1&&choose<=10)
                        {
                            for(int k=0;k<c;k++)//Checks whether the entered Food Item is already chosen or not!
                            {
                                if(type[choose-1].equalsIgnoreCase(select_item[k]))
                                s=1;                           
                            }
                            if(s==1)
                            System.out.println("\t\tThe Customer has already chosen this food item!\n\t\tPlease let him/her Choose another item!");
                            else
                            {
                                select_item[c]=type[choose-1];
                                select_cp[c]=cp[choose-1];
                                select_sp[c]=sp[choose-1];
                                System.out.print("\t\tEnter Quantity of the item(Glasses/Plates):\t");
                                select_quan[c]=Integer.parseInt(br.readLine());
                                c++;
                            }
                            s=0;
                        }
                        else if(choose==0)
                        break;
                        else
                        System.out.println("\t\tSorry!!! Invalid Food Item Chosen!!!\n\t\tYou need to choose the food item again!");
                    }while(choose!=0);//Ending of Inner-Loop:Chooses Food Items
                    System.out.println("\f\t\t  You have been taken to the Main Menu!");
                }
            }while(ch!=0);//Ending of Outer-Loop:Chooses Food Type
            if(c==0)
            {
                System.out.println("\f\t\tYou are successfully Terminated!!!\n\t\tThe customer has ordered nothing!\n\n\n\n\n");
                System.out.println("\t\t**********Thank You*************");
                System.out.println("\t\t<<<<<<<<Visit Again!!!>>>>>>>>>>");
            }
            else
            {
                for(int j=0;j<c;j++)
                {
                    total_cp+=select_quan[j]*select_cp[j];
                    total_sp+=select_quan[j]*select_sp[j];
                }
                net_profit=total_sp-total_cp;
                System.out.println("\f\n\n\n\n\t\t\t\tNet Profit on this Customer's Order(s):\tRs. "+net_profit);
                for(int p=1;p<=5;p++)
                {
                    for(int j=1;j<=999999999;j++)
                    {
                    }
                }
                vat=Math.round((12.5*total_sp)/100);
                System.out.print("\f\n\n\n\t\tDoes the customer want home delivery?\n\t\tpress '1' if yes else press any other number:\t");
                hd=Integer.parseInt(br.readLine());
                if(hd==1)
                {
                    if(total_sp<=2000)
                    hd_amt=Math.round((10*total_sp)/100);
                    else if(total_sp>2000&&total_sp<=5000)
                    hd_amt=Math.round((8*total_sp)/100);
                    else if(total_sp>5000&&total_sp<=10000)
                    hd_amt=Math.round((5*total_sp)/100);
                    if(total_sp>10000)
                    hd_amt=0;
                }
                for(int i=1;i<=3;i++)
                {
                    System.out.print("\f\n\n\n\t\tThe Customer's bill is under processing!!!\n\t\tSo Please Wait");
                    for(int p=1;p<=4;p++)
                    {
                        for(int j=1;j<=999999999;j++)
                        {
                        }
                        if(p!=4)
                        System.out.print(".");
                    }
                }
                System.out.println("\n\n\n\t\tThe Bill Has Been Made!");
                for(int p=1;p<=2;p++)
                {
                    for(int j=1;j<=999999999;j++)
                    {
                    }
                }
                total_amount=total_sp+vat+hd_amt;
                System.out.println("\f\t\t\t\tPayment Details:-\n");
                System.out.println("\t\tThe Food Items Selected By the Customer:-");
                System.out.println("\t\tSL.no\tQuantity\tRate\t\tFood Item");
                for(int p=0;p<c;p++)
                System.out.println("\t\t"+(p+1)+".\t"+select_quan[p]+" pcs\t\tRs. "+select_sp[p]+"\t\t"+select_item[p]);
                System.out.println("\n\n\t\tTotal Amount:\t\t\tRs. "+total_sp);
                System.out.println("\t\tTotal VAT Charged @ 12.5%:\tRs. "+vat);
                if(hd==1)
                {
                    System.out.println("\t\tHome Delivery Charged:\tRs. "+hd_amt);
                    if(total_sp>10000)
                    System.out.println("\t\tThe Customer have not been charged extra for Home Delivery\n\t\tas the customer have ordered foods of total amount above\n\t\tthe sum of Rs. 10000");
                    else if(total_sp<=2000)
                    System.out.println("\t\tThe Customer have been charged 10% extra for Home Delivery\n\t\tas the customer have ordered foods of total amount less\n\t\tthan sum of Rs. 2000");
                    else if(total_sp>2000&&total_sp<=5000)
                    System.out.println("\t\tThe Customer have been charged 8% extra for Home Delivery\n\t\tas the customer have ordered foods of total amount more\n\t\tthan sum of Rs. 2000 & less than sum of Rs. 5000");
                    else if(total_sp>5000&&total_sp<=10000)
                    System.out.println("\t\tThe Customer have been charged 5% extra for Home Delivery\n\t\tas the customer have ordered foods of total amount more\n\t\tthan sum of Rs. 5000 & less than sum of Rs. 10000");
                }
                else
                System.out.println("\n\t\tThe Customer has not chosen to use our Home Delivery Service\n\t\tso the customer has not been charged extra for that!");
                System.out.println("\n\t\tNet Amount Payable By The Customer:\tRs. "+total_amount);
                System.out.println("\n\n\n\t\t\t  You are successfully Terminated!!!");
                System.out.println("\n\t\t\tWe Hope That We Served You The Best!!!\t\n\n\n\n\n");
                System.out.println("\t\t\t  ***********Thank You************");
                System.out.println("\t\t\t  <<<<<<<<<Visit Again!!!>>>>>>>>>");
            }
        }
        else
        System.out.println("\n\nWrong Choice!!! Start the process again!");
    }//End of Main Function
}//End of Class