import java.util.*;

class Train{
    String train_number="";
    String train_name="";
    String date_of_journey="";

    String start="";
    String end="";
    LinkedHashMap<String,String> station_list = new LinkedHashMap<>();
    HashMap<String,ArrayList<Integer>> station_ticket= new HashMap<>();
    ArrayList<User> list_of_users = new ArrayList<>();
    ArrayList<User> booked = new ArrayList<>();
    ArrayList<ArrayList<String>> waiting_list= new ArrayList<>();
    String no_of_seats = "";
    String ticket_price = "";

}
class Admin{
    Scanner sc = new Scanner(System.in);
    String admin_name = "XYZ";
    String admin_pass ="123";

    ArrayList<Train> list_of_trains = new ArrayList<>();
    ArrayList<User> list_of_users = new ArrayList<>();
    ArrayList<ArrayList<String>> waiting_list = new ArrayList<>();
    public void create_train(Train train){
        System.out.println("Enter the Train Number");
        train.train_number = sc.nextLine();
        System.out.println("Enter the Train Name");
        train.train_name = sc.nextLine();
        System.out.println("Enter the Date of Journey");
        train.date_of_journey = sc.nextLine();
        System.out.println("Enter Number of Tickets ");
        train.no_of_seats= sc.nextLine();
        System.out.println("Enter the General Fare");
        train.ticket_price= sc.nextLine();
        System.out.println("Enter Number of Stations");
        String no= sc.nextLine();
        for(int i=0;i<Integer.parseInt(no);i++){
            if(i==0){
                System.out.println("Enter the Source station");
                String station_name = sc.nextLine();
                train.start = station_name;
                System.out.println("Enter the arrival time");
                String station_time = sc.nextLine();
                train.station_list.put(station_name,station_time);
                train.station_ticket.put(station_name,new ArrayList<>(Arrays.asList(Integer.parseInt(train.no_of_seats),0)));
            }
            else if(i==Integer.parseInt(no)-1){
                System.out.println("Enter the Destination station");
                String station_name = sc.nextLine();
                train.end=station_name;
                System.out.println("Enter the arrival time");
                String station_time = sc.nextLine();
                train.station_list.put(station_name,station_time);
                train.station_ticket.put(station_name,new ArrayList<>(Arrays.asList(Integer.parseInt(train.no_of_seats),0)));
            }
            else{
                System.out.println("Enter the Pathway stations");
                String station_name = sc.nextLine();
                System.out.println("Enter the arrival time");
                String station_time = sc.nextLine();
                train.station_list.put(station_name,station_time);
                train.station_ticket.put(station_name,new ArrayList<>(Arrays.asList(Integer.parseInt(train.no_of_seats),0)));

            }
        }
        list_of_trains.add(train);
    }
    public void view_trains(Admin admin){
        System.out.println();
        System.out.println("Trains Avaliable");
        for(Train train:list_of_trains){
            System.out.println(train.date_of_journey + " " + train.train_number + " " + train.train_name + " " + train.start +"-"+train.end+" "+"Number of Avaliable Seats" + " "+ train.no_of_seats + " " +"General Fee "+ train.ticket_price);
        }
    }

    public void view_passengers(Admin admin){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Trains Avaliable");
        for(Train train:list_of_trains){
            System.out.println(train.date_of_journey + " " + train.train_number + " " + train.train_name + " " + train.start +"-"+train.end+" "+"Number of Avaliable Seats" + " "+ train.no_of_seats + " " +"General Fee "+ train.ticket_price);
        }
        System.out.println("Enter the Train-Number of Interest");
        String t_n = sc.nextLine();
        for(Train train:admin.list_of_trains){
            if(train.train_number.equals(t_n)){
                for(User user : train.list_of_users){
                    System.out.println("Booking info");
                    System.out.println(user.book_info);
                    System.out.println("Waiting info");
                    System.out.println(user.wait_info);

                }
            }
        }
    }
}
class User{
    String name = "";
    String username = "";
    String password = "";
    String contact= "";
    String address = "";
    Scanner sc = new Scanner(System.in);
    ArrayList<ArrayList<String>> book_info = new ArrayList<>();
    ArrayList<ArrayList<String>> wait_info = new ArrayList<>();
    User(String name, String username, String password, String contact, String address){
        this.name = name;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.address = address;
    }
    public void view_trains(Admin admin){
        System.out.println();
        System.out.println("Trains Avaliable");
        for(Train train:admin.list_of_trains){
            System.out.println(train.date_of_journey + " " + train.train_number + " " + train.train_name + " " + train.start+"-"+train.end+" "+"Number of Avaliable Seats" + " "+ train.no_of_seats + " " +"General Fee "+ train.ticket_price);
        }
    }
    public void book_tickets(Admin admin, User user) {
        System.out.println();
        System.out.println("Enter the Date of Journey");
        String date = sc.nextLine();
        for (Train train : admin.list_of_trains) {
            if (train.date_of_journey.equals(date)) {
                System.out.println("Trains avaliable");
                System.out.println(train.date_of_journey + " " + train.train_number + " " + train.train_name + " " + train.start + "-" + train.end + " " + "Number of Avaliable Seats" + " " + train.no_of_seats + " " + "General Fee " + train.ticket_price);
            }
        }
        System.out.println("Enter the train number:");
        String t_n = sc.nextLine();
        ArrayList<String> det = new ArrayList<>();
        for (Train train : admin.list_of_trains) {
            if (train.train_number.equals(t_n)) {
                System.out.println("Train Chart: ");
                for (String key : train.station_list.keySet()) {
                    System.out.println(key + " Time of Arrival  " + train.station_list.get(key));
                    System.out.println("Avaliable Tickets : " + train.station_ticket.get(key).get(0));
                    System.out.println("Waiting List : " + train.station_ticket.get(key).get(1));
                    System.out.println();
                    det.add(key);
                }
            }
        }
        System.out.println("Enter the Depature Station");
        String depature = sc.nextLine();
        System.out.println("Enter the Destination Station");
        String arrival = sc.nextLine();
        System.out.println("Enter the number of tickets: ");
        String no_of_tickets = sc.nextLine();
        int start = 0;
        int end = 0;
        boolean booked = false;
        for (Train train : admin.list_of_trains) {
            if (train.train_number.equals(t_n)) {
                int index = 0;
                for (String i : det) {
                    if (i.equals(depature)) start = index;
                    else if (i.equals(arrival)) end = index;
                    index++;
                }
                for (int i = start; i < end; i++) {
                    if (train.station_ticket.get(det.get(i)).get(0) >= Integer.parseInt(no_of_tickets)) {
                        booked=true;
                    }
                    else{
                        booked=false;
                        break;
                    }
                }
                if(booked){
                    for(int i=start;i<end;i++) {
                        train.station_ticket.get(det.get(i)).set(0, Math.abs(Integer.parseInt(no_of_tickets) - train.station_ticket.get(det.get(i)).get(0)));
                        train.no_of_seats = String.valueOf(Math.abs(Integer.parseInt(train.no_of_seats) - Integer.parseInt(no_of_tickets)));
                    }
                    book_info.add(new ArrayList<>(Arrays.asList(train.date_of_journey, train.train_number, train.train_name, no_of_tickets, String.valueOf(Integer.parseInt(no_of_tickets) * Integer.parseInt(train.ticket_price)),depature,arrival)));
                    train.booked.add(user);
                }
                else{
                    for(int i=start;i<end;i++) {
                        train.station_ticket.get(det.get(i)).set(1, Integer.parseInt(no_of_tickets) + train.station_ticket.get(det.get(i)).get(1));
                    }
                    wait_info.add(new ArrayList<>(Arrays.asList(train.date_of_journey, train.train_number, train.train_name, no_of_tickets, String.valueOf(Integer.parseInt(no_of_tickets) * Integer.parseInt(train.ticket_price)))));
                    train.waiting_list.add(new ArrayList<>(Arrays.asList(user.username,depature,arrival,no_of_tickets)));
                }
            }
        }
    }

    public void display_tickets(Admin admin,User user){
        System.out.println();
        String t_n = "";
        for(int i =0;i<user.book_info.size();i++){
            System.out.println("---------------------TICKET INFO---------------------------");
            System.out.println("Date of Journey : "+ user.book_info.get(i).get(0));
            System.out.println("Train Number : "+ user.book_info.get(i).get(1));
            System.out.println("Train Name : "+ user.book_info.get(i).get(2));
            System.out.println("Number of Tickets booked : "+ user.book_info.get(i).get(3));
            System.out.println("Fare: : "+ user.book_info.get(i).get(4));
        }

        for(int i =0;i<user.wait_info.size();i++){
            System.out.println("---------------------WAITING LIST INFO---------------------------");
            System.out.println("Date of Journey : "+ user.wait_info.get(i).get(0));
            System.out.println("Train Number : "+ user.wait_info.get(i).get(1));
            System.out.println("Train Name : "+ user.wait_info.get(i).get(2));
            System.out.println("Number of Tickets in queue : "+ user.wait_info.get(i).get(3));
            System.out.println("Fare: : "+ user.wait_info.get(i).get(4));
        }
    }

    public void cancel_tickets(Admin admin, User user){
        Scanner sc = new Scanner(System.in);
        int index = 0;
        int start=0;
        int end = 0;
        for(ArrayList<String> i:user.book_info){
            System.out.println("TICKET ID : "+String.valueOf(index+1));
            System.out.println(i);
            index++;
        }
        System.out.println("Enter the Ticket ID you wish to cancel");
        String t_i =sc.nextLine();
        ArrayList<String> to_be_rem = user.book_info.get(Integer.parseInt(t_i)-1);
        ArrayList<String> det = new ArrayList<>();
        for(Train train: admin.list_of_trains){
            if(train.train_number.equals(to_be_rem.get(1))){
                for(String key : train.station_list.keySet()) det.add(key);
                int ind = 0;
                for (String i : det) {
                    if (i.equals(to_be_rem.get(5))) start = ind;
                    else if (i.equals(to_be_rem.get(6))) end = ind;
                    ind++;
                }
                for(int i=start;i<end;i++){
                    train.station_ticket.get(det.get(i)).set(0, Math.abs(Integer.parseInt(to_be_rem.get(3))+train.station_ticket.get(det.get(i)).get(0)));
                }
            }

        }
        user.book_info.remove(Integer.parseInt(t_i)-1);
        int s=0;
        int e=0;
        int u = 0;
        for (Train train : admin.list_of_trains) {
            if (train.train_number.equals(to_be_rem.get(1))) {
                int lindex = 0;
                for (String i : det) {
                    for(int k=0;k<train.waiting_list.size();k++){
                        if (i.equals(train.waiting_list.get(k).get(1))) s = lindex;
                        else if (i.equals(train.waiting_list.get(k).get(2))) e = lindex;
                        if(s!=0 && e!=0){
                            u=k;
                            break;
                        }
                        lindex++;
                    }
                }
                boolean booked=false;
                for (int i = start; i < end; i++) {
                    if (train.station_ticket.get(det.get(i)).get(0) >= Integer.parseInt(train.waiting_list.get(u).get(3))) {
                        booked=true;
                    }
                }
                if(booked){
                    for(int i=start;i<end;i++) {
                        train.station_ticket.get(det.get(i)).set(0, Math.abs(Integer.parseInt(train.waiting_list.get(u).get(3)) - train.station_ticket.get(det.get(i)).get(0)));
                        train.no_of_seats = String.valueOf(Math.abs(Integer.parseInt(train.no_of_seats) - Integer.parseInt(train.waiting_list.get(u).get(3))));
                    }
                    for(User newuser:admin.list_of_users){
                        if (newuser.username.equals(train.waiting_list.get(u).get(0))){
                            newuser.book_info.add(new ArrayList<>(Arrays.asList(train.date_of_journey, train.train_number, train.train_name, (train.waiting_list.get(u).get(3)), String.valueOf(Integer.parseInt(train.waiting_list.get(u).get(3))* Integer.parseInt(train.ticket_price)),det.get(s),det.get(e))));
                            train.booked.add(newuser);
                            newuser.wait_info.remove(0);
                        }
                    }

                }

            }
        }

    }
    }

public class Railways {

    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------WELCOME TO NRCTC-----------------");
        System.out.println("--------------ENTER YOUR INPUT IN UPPERCASE-----------------");
        System.out.println();
        boolean global_exit = true;
        while (global_exit) {
            boolean ADMIN_ACTIVE = true;
            boolean USER_ACTIVE = true;
            System.out.println("ADMIN/USER");
            String current_user = sc.nextLine();
            if (current_user.equals("ADMIN")) {
                while (ADMIN_ACTIVE) {
                    System.out.println("Enter your Username");
                    String username = sc.nextLine();
                    while (!admin.admin_name.equals(username)) {
                        System.out.println("Invalid username Try Again");
                        username = sc.nextLine();
                    }
                    System.out.println("Enter your Password");
                    String password = sc.nextLine();
                    while (!admin.admin_pass.equals(password)) {
                        System.out.println("Invalid Password Try Again");
                        password = sc.nextLine();
                    }
                    while (true) {
                        System.out.println();
                        System.out.println("THANK YOU! SELECT THE OPERATION NUMBER");
                        System.out.println("1.ENTER TRAIN DETAILS");
                        System.out.println("2.VIEW TRAINS");
                        System.out.println("3.VIEW PASSENGERS");
                        System.out.println("4.LOGOUT");
                        int input = sc.nextInt();
                        sc.nextLine();
                        if (input == 1) {
                            Train train = new Train();
                            admin.create_train(train);
                            System.out.println("Thank You");
                        } else if (input == 2) {
                            admin.view_trains(admin);
                        } else if (input == 3) {
                            admin.view_passengers(admin);
                        } else if (input == 4) {
                            ADMIN_ACTIVE = false;
                            break;
                        }
                    }
                }
            } else if (current_user.equals("USER")) {
                while (USER_ACTIVE) {
                    System.out.println();
                    System.out.println("1.NEW USER");
                    System.out.println("2.EXISTING USER");
                    System.out.println("3.GO TO MAIN MENU");
                    int select = sc.nextInt();
                    sc.nextLine();
                    if (select == 1) {
                        System.out.println("Enter your name");
                        String name = sc.nextLine();
                        System.out.println("Enter your UserName");
                        String username = sc.nextLine();
                        System.out.println("Enter your Password");
                        String password = sc.nextLine();
                        System.out.println("Enter your Contact Number");
                        String contact = sc.nextLine();
                        System.out.println("Enter your Address");
                        String address = sc.nextLine();
                        User user = new User(name, username, password, contact, address);
                        admin.list_of_users.add(user);
                    } else if (select == 2) {
                        if (admin.list_of_users.isEmpty()) System.out.println("No users found try again");
                        else {
                            boolean valid = false;
                            User user = new User("","","","","");
                            while (!valid) {
                                System.out.println("Enter your username");
                                String u_n = sc.nextLine();
                                System.out.println("Enter your Password");
                                String pass = sc.nextLine();

                                for (User users : admin.list_of_users) {
                                    if (users.username.equals(u_n) && users.password.equals(pass)){
                                        valid = true;
                                        user=users;
                                    }
                                }
                                if (!valid) System.out.println("Invalid Authentication Try Again");
                            }
                            while (true) {
                                System.out.println();
                            System.out.println("THANK YOU! SELECT THE OPERATION NUMBER");
                            System.out.println("1.VIEW AVALIABLE TRAINS");
                            System.out.println("2.BOOK TICKETS");
                            System.out.println("3.VIEW BOOKED TICKET");
                                System.out.println("4.CANCELLED TICKET");
                            System.out.println("5.LOGOUT");
                            int func = sc.nextInt();
                            if (func == 1) {
                                user.view_trains(admin);
                            }
                            else if(func==2){
                                user.book_tickets(admin,user);
                            }
                            else if (func==3) {
                                user.display_tickets(admin, user);
                            }
                            else if(func==4){
                                user.cancel_tickets(admin,user);
                            }
                            else if(func==5){
                                USER_ACTIVE=false;
                                break;
                            }
                        }


                        }
                    } else if (select==3) {
                        USER_ACTIVE=false;
                        break;
                    }

                }
            }
        }
    }
}