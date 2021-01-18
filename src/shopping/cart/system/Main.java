package shopping.cart.system;


import java.util.Scanner;

public class Main {

    /*
    Create  User Name  and password
    Count check if UserName  of user  equal this Username variable "Admin"  
    and password of User  equal this password variable "123456"
     */
    static String Username = "Admin";
    static int password = 123456;

    static Scanner in = new Scanner(System.in);
    // Create Array 2D  this Store object of Product 
    static String[][] Products = new String[20][4]; //[Row] [Col]

    static int Count = 0;

    public static boolean Login()  {
        System.out.print("Enter Username :  ");
        String User = in.next();
        System.out.print("Enter Password :  ");
        int pass = in.nextInt();
        System.out.println("");
        if (pass == password && User.equalsIgnoreCase(Username)) {
            return true;
        } else {
            System.err.println("Error UserName  or Password is Incorrect");

            return false;

        }
    }

    public static void Show_All_Products() {
        for (String[] Product : Products) { //For each
            if (Product[0] != null) {
                System.out.println("Product {id=" + Product[0] + ", name=" +
                Product[1] + ", price=" + Product[2] + ", quantity=" + Product[3] + " }"); 
            }else{
            break;
            }
        }

    }

    public static void Add_product(String Id, String Name, String Price, String Quantity) {

        if (Count < Products.length) {
            Products[Count][0] = Id;
            Products[Count][1] = Name;
            Products[Count][2] = Price;
            Products[Count][3] = Quantity;
            Count++;
        } else {
            System.out.println("Array  is Full");
        }
    }

    public static void Delete_product(String Id) throws NullPointerException {
        boolean isFound = false;
        for (int j = 0; j < Count; j++) {
                if ((Products[j][0]).equals(Id)) {
                    isFound = true;
                    //Arrange_Products ترتيب الاري بحيث احذف  بالكتابة فوقه .
                    for (int i = j; i < Count; i++) {
                        Products[i] = Products[i + 1];
                    }
                    Count--;

                    break;
                }
        }
        if (!isFound) {
            System.out.println("there is No Product has this Id ");
        }
    }

    public static void Edit_product(String IdEdit, String Name, String Price, String Quantity) {
        boolean isFound = false;
        for (int j = 0; j < Count; j++) {

            if (Products[j][0] != null) {
                if ((Products[j][0]).equals(IdEdit)) {
                    isFound = true;

                    Products[j][0] = IdEdit;
                    Products[j][1] = Name;
                    Products[j][2] = Price;
                    Products[j][3] = Quantity;
                    break;
                }
            }
        }
        if (!isFound) {
            System.out.println("there is No Product has this Id ");
        }
    }

    public static double Calculate_total_product() {
        double total = 0;
        for (String[] Product : Products) {
            if (Product[0] == null) { break;  }
                int pice_product = 0;
                int price = Integer.parseInt(Product[2]);
                int Quantity = Integer.parseInt(Product[3]);

                pice_product = price * Quantity;
                total += pice_product;

        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        boolean Loop = true;

        while (Loop) {
            boolean x = Login();
            if (x) {
                break;
            }

        }
        System.out.println("*******************************************************************");
        System.out.println("***************** Welcom ,the System Is Ready Now *****************");
        System.out.println("*******************************************************************");
        System.out.println(" ");
        while (Loop) {

            System.out.println("1.Show All Products");
            System.out.println("2.Add Product");
            System.out.println("3.Delete Product");
            System.out.println("4.Edit Product");
            System.out.println("5.Calculate Total Price");
            System.out.println("6.Exit");

            System.out.println("Enter your Choice:  ");
            int input = in.nextInt();
            System.out.println("-----");
            switch (input) {

                case 1:
                    Show_All_Products();
                    System.out.println("");
                    break;
                case 2:
                    System.out.println(" Enter : Id, Name, Price, Quantity");
                    String Id = in.next();
                    String Name = in.next();
                    String Price = in.next();
                    String Quantity = in.next();
                    Add_product(Id, Name, Price, Quantity);
                    break;
                case 3:
                    System.out.println(" Enter  Id ");
                    String IdDelete = in.next();
                    Delete_product(IdDelete);
                    System.out.println(" Delete done ");

                    break;
                case 4:
                    System.out.println(" Enter : Id of product Want to Edit ");
                    String IdEdit = in.next();

                    System.out.println(" Enter : Name, Price, Quantity");
                    String NameEdit = in.next();
                    String PriceEdit = in.next();
                    String QuantityEdit = in.next();
                    Edit_product(IdEdit, NameEdit, PriceEdit, QuantityEdit);
                    System.out.println("");

                    break;
                case 5:
                  double total=  Calculate_total_product();
                    System.out.println("total Price =  "+ total);
                    System.out.println("");
                    break;
                case 6:
                    Loop = false;
                    break;

            }

        }
        

    }

}
