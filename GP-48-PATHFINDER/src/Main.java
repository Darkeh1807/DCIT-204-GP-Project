import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel rootPanel;
    private JPanel headPanel;
    private JLabel heading;
    private JPanel bodyPanel;
    private JButton button;
    private JLabel locationLabel;
    private JLabel destinationLabel;
    private JLabel outputBox1;
    private JComboBox LocationSelector;
    private JComboBox DestinationSelector;
    private JLabel outputBox2;

    private static JFrame frame = new JFrame("GP-48 PATHFINDER");
    public static JFrame getFrame() {
        return frame;
    }
    public Main() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = LocationSelector.getSelectedItem().toString();
                String destination = DestinationSelector.getSelectedItem().toString();



                Node loc1;
                Node loc2;
                //Scanner sc = new Scanner(System.in);

                Graph graph = new Graph(true);
                Node engineeringDept = new Node(0, "Engineering Dept");
                Node csDept = new Node(1, "CS Dept");
                Node Law = new Node(2, "Law");
                Node JQB = new Node(3, "JQB");
                Node MainGate = new Node(4, "Main Gate");
                Node PerformingArts = new Node(5, "Performing Arts");
                Node MAthsandStats = new Node(6, "Maths And Stats Department");
                Node Balme = new Node(7, "Balme");
                Node UGCS = new Node(8, "UGCS");
                Node BusinessSchool = new Node(9, "Business School");
                Node VoltaHall = new Node(10, "Volta Hall");
                Node Commonwealth = new Node(11, "Commonwealth Hostel");
                Node GreatHall = new Node(12, "Great Hall");
                Node AkuafoHall = new Node(13, "Akuafo Hall");
                Node LegonHall = new Node(14, "Legon Hall");
                Node BushCanteen = new Node(15, "Bush Canteen");
                Node SarbahPark = new Node(16, "Sarbah Park");
                Node FireService = new Node(17, "Fire Station");
                Node BankingSquare = new Node(18, "Banking Square");
                Node NightMarket = new Node(19, "Night Market");
                Node BasicSchool = new Node(20, "UG Basic School");
                Node Diaspora = new Node(21, "Diaspora");

                loc1 = engineeringDept;
                loc2 = Diaspora;
                // Our addEdge method automatically adds Nodes as well.
                // The addNode method is only there for unconnected Nodes,
                // if we wish to add any
                graph.addEdge(engineeringDept, csDept, 60);
                graph.addEdge(csDept, engineeringDept, 60);
                graph.addEdge(csDept, MAthsandStats, 45);
                graph.addEdge(MAthsandStats, csDept, 45);
                graph.addEdge(MAthsandStats, UGCS, 200);
                graph.addEdge(UGCS, MAthsandStats, 200);
                graph.addEdge(MAthsandStats, AkuafoHall, 180);
                graph.addEdge(AkuafoHall, MAthsandStats, 180);
                graph.addEdge(AkuafoHall, SarbahPark, 198);
                graph.addEdge(SarbahPark, AkuafoHall, 198);
                graph.addEdge(UGCS, BusinessSchool, 20);
                graph.addEdge(BusinessSchool, UGCS, 20);
                graph.addEdge(UGCS, VoltaHall, 100);
                graph.addEdge(VoltaHall, UGCS, 100);
                graph.addEdge(UGCS, LegonHall, 150);
                graph.addEdge(LegonHall, UGCS,  150);
                graph.addEdge(BusinessSchool, Balme, 90);
                graph.addEdge(Balme, BusinessSchool, 90);
                graph.addEdge(UGCS, Balme, 50);
                graph.addEdge(Balme, Balme,  50);
                graph.addEdge(csDept, Law,  55);
                graph.addEdge(Law, csDept,  55);
                graph.addEdge(engineeringDept, Law,  70);
                graph.addEdge(Law, engineeringDept, 70);
                graph.addEdge(Law, JQB,  120);
                graph.addEdge(JQB, Law,  120);
                graph.addEdge(JQB, MainGate, 110);
                graph.addEdge(MainGate, JQB,110);

                graph.addEdge(MainGate, PerformingArts, 70);
                graph.addEdge(PerformingArts, MainGate, 70);
                graph.addEdge(PerformingArts, BushCanteen, 65);
                graph.addEdge(BushCanteen, PerformingArts, 65);
                graph.addEdge(PerformingArts, FireService, 10);
                graph.addEdge(FireService, PerformingArts, 10);
                graph.addEdge(FireService, BushCanteen, 50);
                graph.addEdge(BushCanteen, PerformingArts, 50);
                graph.addEdge(PerformingArts, SarbahPark, 150);
                graph.addEdge(SarbahPark, PerformingArts, 150);
                graph.addEdge(PerformingArts, AkuafoHall, 158 );
                graph.addEdge(AkuafoHall, PerformingArts, 158);
                graph.addEdge(AkuafoHall, Balme, 70);
                graph.addEdge(Balme, AkuafoHall, 70);
                graph.addEdge(Balme, BusinessSchool, 58);
                graph.addEdge(BusinessSchool, Balme, 58);
                graph.addEdge(SarbahPark, BankingSquare, 300);
                graph.addEdge(BankingSquare , SarbahPark, 300);
                graph.addEdge(BankingSquare, NightMarket, 10);
                graph.addEdge(NightMarket, BankingSquare, 10);
                graph.addEdge(BankingSquare, Diaspora, 320);
                graph.addEdge(Diaspora, BankingSquare, 320);
                graph.addEdge(LegonHall, SarbahPark, 135);
                graph.addEdge(SarbahPark, LegonHall, 135);
                graph.addEdge(AkuafoHall, SarbahPark, 100);
                graph.addEdge(SarbahPark, AkuafoHall, 100);

                graph.addEdge(BasicSchool, GreatHall, 400 );
                graph.addEdge(GreatHall, BasicSchool, 400);
                graph.addEdge(GreatHall, Commonwealth, 15);
                graph.addEdge(Commonwealth, GreatHall, 15);

                //System.out.println("Input current location");

                String currentLocation = location;


                switch (currentLocation) {
                    case "Engineering Dept":
                        loc1 = engineeringDept;
                        break;
                    case "Computer Dept":
                        loc1 = csDept;
                        break;
                    case "Law Faculty":
                        loc1 = Law;
                        break;
                    case "JQB":
                        loc1 = JQB;
                        break;
                    case "Maths and Stats":
                        loc1 = MAthsandStats;
                        break;
                    case "Main Gate":
                        loc1 = MainGate;
                        break;
                    case "Performing Arts":
                        loc1 = PerformingArts;
                        break;
                    case "Balme":
                        loc1 = Balme;
                        break;
                    case "UGCS":
                        loc1 = UGCS;
                        break;
                    case "Business School":
                        loc1 = BusinessSchool;
                        break;
                    case "Volta Hall":
                        loc1 = VoltaHall;
                        break;
                    case "Commonwealth":
                        loc1 = Commonwealth;
                        break;
                    case "Great Hall":
                        loc1 = GreatHall;
                        break;
                    case "Akuafo Hall":
                        loc1 = AkuafoHall;
                        break;
                    case "Legon Hall":
                        loc1 = LegonHall;
                        break;
                    case "Sarbah Park":
                        loc1 = SarbahPark;
                        break;
                    case "Basic School":
                        loc1 = BasicSchool;
                        break;
                    case "Night Market":
                        loc1 = NightMarket;
                        break;
                    case "Diaspora":
                        loc1 = Diaspora;
                        break;
                    case "Bush Canteen":
                        loc1 = BushCanteen;
                        break;
                    case "Fire Station":
                        loc1 = FireService;
                        break;
                    case "Banking Square":
                        loc1 = BankingSquare;
                        break;

                }


                String whereTo = destination;

                switch (whereTo) {
                    case "Engineering Dept":
                        loc2 = engineeringDept;
                        break;

                    case "Computer Dept":
                        loc2 = csDept;
                        break;
                    case "Law Faculty":
                        loc2 = Law;
                        break;
                    case "JQB":
                        loc2 = JQB;
                        break;
                    case "Maths and Stats":
                        loc2 = MAthsandStats;
                        break;
                    case "Main Gate":
                        loc2 = MainGate;
                        break;
                    case "Performing Arts":
                        loc2 = PerformingArts;
                        break;
                    case "Balme":
                        loc2 = Balme;
                        break;
                    case "UGCS":
                        loc2 = UGCS;
                        break;
                    case "Business School":
                        loc2 = BusinessSchool;
                        break;
                    case "Volta Hall":
                        loc2 = VoltaHall;
                        break;
                    case "Commonwealth":
                        loc2 = Commonwealth;
                        break;
                    case "Great Hall":
                        loc2 = GreatHall;
                        break;
                    case "Akuafo Hall":
                        loc2 = AkuafoHall;
                        break;
                    case "Legon Hall":
                        loc2 = LegonHall;
                        break;
                    case "Sarbah Park":
                        loc2 = SarbahPark;
                        break;
                    case "Basic School":
                        loc2 = BasicSchool;
                        break;
                    case "Night Market":
                        loc2 = NightMarket;
                        break;
                    case "Diaspora":
                        loc2 = Diaspora;
                        break;
                    case "Bush Canteen":
                        loc2 = BushCanteen;
                        break;
                    case "Fire Station":
                        loc2 = FireService;
                        break;

                    case "Banking Square":
                        loc2 = BankingSquare;
                        break;
                }

//                System.out.println("Location 1: "+loc1.name);
//                System.out.println("Location 2: "+destination);

                String path = graph.shortestPath(loc1, loc2);
                outputBox1.setText("From: "+ loc1.name);
                outputBox2.setText("To: "+ loc2.name);

                    JOptionPane optionPane = new JOptionPane(path, JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("PathFinder Result");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        showMain();
    }

    public  static  void showMain()
    {
        getFrame().setContentPane(new Main().rootPanel);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().pack();
        getFrame().setLocationRelativeTo(null);
        getFrame().setResizable(false);
        getFrame().setVisible(true);
    }
}
