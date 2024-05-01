import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public  class HomePage implements ActionListener, KeyListener {
    static JFrame home = new JFrame();
    static JButton twoPlayerButton = new JButton();
    static JButton fourPLayerButton = new JButton();
    static JButton HOME = new JButton();
    static JLabel Display_option = new JLabel();
    static JLabel GameLogo = new JLabel();
    static JLabel piece1 = new JLabel();
    static JLabel piece2 = new JLabel();
    static JLabel piece3 = new JLabel();
    static JLabel piece4 = new JLabel();
    Noticeboard notice= new Noticeboard();
    ImageIcon cancel = new ImageIcon("cancel.png");
    ImageIcon boardImage = new ImageIcon("snakeboard2.png");
    ImageIcon p1 = new ImageIcon("red.png");
    ImageIcon p2 = new ImageIcon("green1.png");
    ImageIcon p3 = new ImageIcon("blue2.png");
    ImageIcon p4 = new ImageIcon("yellow3.png");

    File THEME = new File("theme.wav");
    File stepfile = new File("step.wav");
    File snakefile = new File("snake.wav");
    File ladderfile = new File("ladder.wav");
    File dicerollfile  = new File("diceroll.wav");
    File winfile  = new File("win.wav");

    AudioInputStream themestream = AudioSystem.getAudioInputStream(THEME);
    AudioInputStream Stepstream =AudioSystem.getAudioInputStream(stepfile);
    AudioInputStream snakestream  =AudioSystem.getAudioInputStream(snakefile);
    AudioInputStream ladderstream  =AudioSystem.getAudioInputStream(ladderfile);
    AudioInputStream dicerollsteam  =AudioSystem.getAudioInputStream(dicerollfile);
    AudioInputStream winstream  =AudioSystem.getAudioInputStream(winfile);

    Clip theme = AudioSystem.getClip();
    Clip step = AudioSystem.getClip();
    Clip ladder = AudioSystem.getClip();
    Clip diceroll = AudioSystem.getClip();
    Clip win = AudioSystem.getClip();
    Clip snake = AudioSystem.getClip();
    JOptionPanel panel= new JOptionPanel();


    int  height = 900, width = 900,Bit=2;
    int[] posX ={0,0,0,0},posY={0,0,0,0},posmemory={0,0,0,0},xAxis={0,0,0,0}, yAxis={0,0,0,0};

    static int Player=0;
    static JButton Dice_button = new JButton();
    static JLabel rolledDice= new JLabel();
    static int dice;
    static   JLabel board_label= new JLabel();
    static   JLabel p1Profile= new JLabel();
    static   JLabel p2Profile= new JLabel();
    static   JLabel p3Profile= new JLabel();
    static   JLabel p4Profile= new JLabel();
    static  JPanel board = new JPanel();
    ImageIcon user= new ImageIcon("user.png");
    ImageIcon user1= new ImageIcon("user1.png");
    ImageIcon user2= new ImageIcon("user2.png");
    ImageIcon user3= new ImageIcon("user3.png");
     int[] position ={0,0,0,0},rollingTime={0,0,0,0};
    int i=0,j=0,k=0;
    Random random = new Random();
    ImageIcon d1 = new ImageIcon("one.png");
    ImageIcon d2 = new ImageIcon("two.png");
    ImageIcon d3 = new ImageIcon("three.png");
    ImageIcon d4 = new ImageIcon("four.png");
    ImageIcon d5 = new ImageIcon("five.png");
    ImageIcon d6 = new ImageIcon("six.png");
    Color sColor(int p){
        return switch (p) {
            case 0 -> Color.red;
            case 1 -> Color.green;
            case 2 ->  Color.blue;
            case 3 -> Color.yellow;
            default -> null;
        };
    }
    String pcolor(int p){
        return switch (p) {
            case 0 -> " red";
            case 1 -> " green";
            case 2 -> " blue";
            case 3 -> " yellow";
            default -> null;
        };
    }
    void soundReset(){
        snake.setMicrosecondPosition(0);
        ladder.setMicrosecondPosition(0);
        step.setMicrosecondPosition(0);
        theme.setMicrosecondPosition(0);
        win.setMicrosecondPosition(0);
        diceroll.setMicrosecondPosition(0);
        snake.stop();
    }
    void AI(){

    }
    void roll(int player) throws InterruptedException, LineUnavailableException, IOException {
        soundReset();
        dice=random.nextInt(6)+1;
        AI();
       diceAnimation();
        if(position[player]!=0&&position[player]+dice<=100){


            switch (position[player]+=dice){
                case 5:
                    changePiece();
                    position[player]=15;
                    PieceUP();
                    break;
                case 7:
                    changePiece();
                    position[player]=26;
                  PieceUP();
                    break;
                case 9:
                    changePiece();
                    position[player]=6;
                    pieceDown();
                    break;
                case 19:
                    changePiece();
                    position[player]=40;
                    PieceUP();

                    break;
                case 22:
                    changePiece();
                    position[player]=13;
                    pieceDown();
                    break;
                case 32:
                    changePiece();
                    position[player]=51;
                    break;
                case 44:
                    changePiece();
                    position[player]=66;
                    PieceUP();
                    break;
                case 45:
                    changePiece();
                    position[player]=14;
                    pieceDown();
                    break;
                case 48:
                    changePiece();
                    position[player]=20;
                    pieceDown();
                    break;
                case 50:
                    changePiece();
                    position[player]=87;
                    PieceUP();
                    break;
                case 72:
                    changePiece();
                    position[player]=43;
                    pieceDown();
                    break;
                case 80:
                    changePiece();
                    position[player]=70;
                    pieceDown();
                    break;
                case 92:
                    changePiece();
                    position[player]=81;
                    pieceDown();
                    break;
                case 94:
                    changePiece();
                    position[player]=85;
                    pieceDown();
                    break;
                case 99:
                    changePiece();
                    position[player]=67;
                    pieceDown();
                    break;
                case 100:
                    changePiece();
                    position[player]=100;
                    win.start();
                    if (Bit==2) {
                        home.setAlwaysOnTop(false);
                        panel.msg = "player" + pcolor((player));
                        if (Player == 0) {
                            panel.yesIcon = user;
                        } else panel.yesIcon = user2;
                        panel.show();
                    }
                    System.out.println("player"+(player+1)+"wins");
                    Dice_button.setEnabled(false);
                    break;
                default:
                   // position[player]+=dice;
            }

        Thread.sleep(300);
            Noticeboard.dashboard.getContentPane().setBackground(new Color(0xB0E379));
        }

        if(position[player]==0){
            if (dice==1){
                position[player]=1;
             //   Noticeboard.dashboard.setVisible(true);
                Noticeboard.title.setText(" "+pcolor(Player)+" just arrived in game");
                Noticeboard.dashboard.getContentPane().setBackground(new Color(0xFF2AFF00));
                changePiece();
            }
        }
        piece1.setVisible(position[0] != 0);
        piece2.setVisible(position[1] != 0);
        piece3.setVisible(position[2] != 0);
        piece4.setVisible(position[3] != 0);

        // rolledDice.setText(" "+dice);
        System.out.println("player:"+(Player+1));
        System.out.println("dice:"+dice+" position: "+position[Player]);
        changePiece();
        changePlayer();
        changeDP();
    }
    void pieceDown() throws InterruptedException {
        xAxis[Player]=posX[Player];
        yAxis[Player]=posY[Player];
        snake.start();
        Noticeboard.title.setText(" "+pcolor(Player)+"bitten by Snake");
       Noticeboard.dashboard.getContentPane().setBackground(new Color(0xFF0090));
        for(i=posmemory[Player];i>=position[Player];i--) {



            posX[Player] =i % 10;
            posY[Player] = i / 10;
            if (posX[Player] == 0) {
                posX[Player] = 10;

                posY[Player]--;
            }

            posY[Player]++;
            posX[Player]++;

            posX[Player] *= 59;
            posY[Player] *= 59;
            posX[Player] -= 59;
            posY[Player] -= 59;


            piece1.setBounds(xAxis[0] - 30, 550 - posY[0] + 10, 50, 50);
            piece2.setBounds(xAxis[1] - 30, 550 - posY[1] + 10, 50, 50);
            piece3.setBounds(xAxis[2] - 30, 550 - posY[2] + 10, 50, 50);
            piece4.setBounds(xAxis[3] - 30, 550 - posY[3] + 10, 50, 50);
            Thread.sleep(10);


        }

        posmemory[Player]=position[Player];
        piece1.setBounds(posX[0] - 30, 550 - posY[0] + 10, 50, 50);
        piece2.setBounds(posX[1] - 30, 550 - posY[1] + 10, 50, 50);
        piece3.setBounds(posX[2] - 30, 550 - posY[2] + 10, 50, 50);
        piece4.setBounds(posX[3] - 30, 550 - posY[3] + 10, 50, 50);
    }

    void PieceUP() throws InterruptedException {
        xAxis[Player]=posX[Player];
        yAxis[Player]=posY[Player];
        ladder.start();

        Noticeboard.title.setText(" "+pcolor(Player)+"just got the ladder");
        Noticeboard.dashboard.getContentPane().setBackground(new Color(0xDBF56B));
        for(i=posmemory[Player];i<=position[Player];i++) {



            posX[Player] =i % 10;
            posY[Player] = i / 10;
            if (posX[Player] == 0) {
                posX[Player] = 10;

                posY[Player]--;
            }

            posY[Player]++;
            posX[Player]++;

            posX[Player] *= 59;
            posY[Player] *= 59;
            posX[Player] -= 59;
            posY[Player] -= 59;


            piece1.setBounds(xAxis[0] - 30, 550 - posY[0] + 10, 50, 50);
            piece2.setBounds(xAxis[1] - 30, 550 - posY[1] + 10, 50, 50);
            piece3.setBounds(xAxis[2] - 30, 550 - posY[2] + 10, 50, 50);
            piece4.setBounds(xAxis[3] - 30, 550 - posY[3] + 10, 50, 50);
            Thread.sleep(10);
            step.setMicrosecondPosition(0);
            step.start();
        }

        posmemory[Player]=position[Player];
        piece1.setBounds(posX[0] - 30, 550 - posY[0] + 10, 50, 50);
        piece2.setBounds(posX[1] - 30, 550 - posY[1] + 10, 50, 50);
        piece3.setBounds(posX[2] - 30, 550 - posY[2] + 10, 50, 50);
        piece4.setBounds(posX[3] - 30, 550 - posY[3] + 10, 50, 50);
    }
    void changePiece() throws InterruptedException {
        xAxis[Player]=posX[Player];
        yAxis[Player]=posY[Player];
        for(i=posmemory[Player];i<=position[Player];i++) {



            posX[Player] =i % 10;
            posY[Player] = i / 10;
            if (posX[Player] == 0) {
                posX[Player] = 10;

                posY[Player]--;
            }

            posY[Player]++;
            posX[Player]++;

            posX[Player] *= 59;
            posY[Player] *= 59;
            posX[Player] -= 59;
            posY[Player] -= 59;


            piece1.setBounds(posX[0] - 30, 550 - posY[0] + 10, 50, 50);
            piece2.setBounds(posX[1] - 30, 550 - posY[1] + 10, 50, 50);
            piece3.setBounds(posX[2] - 30, 550 - posY[2] + 10, 50, 50);
            piece4.setBounds(posX[3] - 30, 550 - posY[3] + 10, 50, 50);
            Thread.sleep(100);
            step.setMicrosecondPosition(0);
            step.start();
        }

        posmemory[Player]=position[Player];
        piece1.setBounds(posX[0] - 30, 550 - posY[0] + 10, 50, 50);
        piece2.setBounds(posX[1] - 30, 550 - posY[1] + 10, 50, 50);
        piece3.setBounds(posX[2] - 30, 550 - posY[2] + 10, 50, 50);
        piece4.setBounds(posX[3] - 30, 550 - posY[3] + 10, 50, 50);
    }
    void changePlayer(){
        if(dice==6&&position[Player]!=0){}

     else if(dice==1&&position[Player]<1){}

      else {

          if (dice==1&&position[Player]==1){}
           else if (Bit==2) {
               if (Player == 0) {
                    Player = 2;
                }
              else {
                    Player = 0;
                }
            }
            else {
                if (Player == 0) {
                    Player = 1;
                }
                else if(Player==1){
                    Player = 2;
                }
                else if (Player == 2) {
                    Player = 3;
                }
                else {
                    Player = 0;
                }
            }
        }
        Noticeboard.player.setText(" "+pcolor(Player)+"s turn!");
      Noticeboard.player.setForeground(sColor(Player));
    }
    void changeRD(){
        if (Player==0){
            rolledDice.setBounds(width/2 -12,50,58,58);
        }
       else if (Player==1){
            rolledDice.setBounds(50,height/2 -12,58,58);
        }
       else if (Player==2){
            rolledDice.setBounds(width/2 -12,height-110,58,58);

        }
        else rolledDice.setBounds(width-100,height/2 -12,58,58); }
    void changeDP() throws InterruptedException {
        Dice_button.setIcon(d1);
        if (Player==0){
            Dice_button.setBounds(width/2 -12,50,58,58);
        }
        else if (Player==1){
            Dice_button.setBounds(50,height/2 -12,58,58);
        }
        else if (Player==2){
            Dice_button.setBounds(width/2 -12,height-110,58,58);

        }
    else Dice_button.setBounds(width-100,height/2 -12,58,58);}
    void ReturnHome() {
        twoPlayerButton.setVisible(true);
        fourPLayerButton.setVisible(true);
        Display_option.setVisible(true);
        board.setVisible(false);
        HOME.setVisible(false);
      p1Profile.setVisible(false);
         p2Profile.setVisible(false);
        rolledDice.setVisible(false);
        Dice_button.setVisible(false);
        position= new int[]{0, 0,0,0};
        theme.start();
    }
    void diceAnimation() throws InterruptedException, LineUnavailableException, IOException {
        int i=1;
        changeRD();
        diceroll.setMicrosecondPosition(0);
        diceroll.start();
        while (i<7){
            Dice_button.setVisible(false);
            posmemory[Player]=position[Player];
            piece1.setBounds(posX[0] - 30, 550 - posY[0] + 10, 50, 50);
            piece2.setBounds(posX[1] - 30, 550 - posY[1] + 10, 50, 50);
            piece3.setBounds(posX[2] - 30, 550 - posY[2] + 10, 50, 50);
            piece4.setBounds(posX[3] - 30, 550 - posY[3] + 10, 50, 50);
            if(i==1){ rolledDice.setIcon(d1);}
            else  if(i== 2) { rolledDice.setIcon(d2); Thread.sleep(100);}
            else  if(i== 3) {rolledDice.setIcon(d3); Thread.sleep(100);}
            else  if(i== 4) { rolledDice.setIcon(d4); Thread.sleep(100);}
            else  if(i== 5) { rolledDice.setIcon(d5); Thread.sleep(100);}
            else  if(i== 6) { rolledDice.setIcon(d6); Thread.sleep(100);}
            i++;
            System.out.println(i);



        }

        switch (dice){
            case 1:
                Dice_button.setIcon(d1);
                rolledDice.setIcon(d1);
                break;
            case 2:
                Dice_button.setIcon(d2);
                rolledDice.setIcon(d2);
                break;
            case 3:
                Dice_button.setIcon(d3);
                rolledDice.setIcon(d3);
                break;
            case 4:
                Dice_button.setIcon(d4);
                rolledDice.setIcon(d4);
                break;
            case 5:
                Dice_button.setIcon(d5);
                rolledDice.setIcon(d5);
                break;
            case 6:
                Dice_button.setIcon(d6);
                rolledDice.setIcon(d6);
                break;

        }
        Thread.sleep(1000);
        Dice_button.setVisible(true);

    }


    void clearHome() {
        twoPlayerButton.setVisible(false);
        fourPLayerButton.setVisible(false);
        Display_option.setVisible(false);
        HOME.setVisible(true);
        Dice_button.setVisible(true);
        rolledDice.setVisible(true);
        p1Profile.setVisible(true);
        p3Profile.setVisible(true);
        //p2Profile.setVisible(true);
        board.setVisible(true);
        theme.stop();
        theme.close();

    }



    HomePage() throws LineUnavailableException, UnsupportedAudioFileException, IOException {


    }

    HomePage(int a) throws InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException {


        home.setVisible(true);
        home.setLayout(null);
        home.setBounds(350, 120, width, height);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        home.getContentPane().setBackground(new Color(0x99BB00));
        home.add(twoPlayerButton);
        home.add(fourPLayerButton);
        home.add(Display_option);
        home.add(GameLogo);
        home.add(HOME);
        HOME.setIcon(cancel);
        home.setAlwaysOnTop(true);

        GameLogo.setBounds(width / 2 - 175, 10, 350, 60);
        Display_option.setBounds(width / 2 - 100, height / 3 - 70, 200, 30);
        twoPlayerButton.setBounds(width / 2 - 60, height / 3 - 30, 120, 40);
        fourPLayerButton.setBounds(width / 2 - 60, height / 3 + 20, 120, 40);
        HOME.setBounds(width - 62, 10, 32, 32);
        board.setBounds(width/2 -300,height/2 -300,620,630);

        //board.setBackground(new Color(0xFFFFFF));

        position = new int[]{0, 0,0,0};
        home.add(Dice_button);
        home.add(rolledDice);
        p1Profile.setVisible(false);
        p2Profile.setVisible(false);
        //Dice_button.setIcon(d1);
        //  Dice_button.setText("ROLL");
        rolledDice.setText("null");
        rolledDice.setFocusable(false);
        Dice_button.setVisible(false);
        rolledDice.setVisible(false);
        Dice_button.setFocusable(false);
        board.setVisible(false);
        p2Profile.setVisible(false);
        p4Profile.setVisible(false);
        p1Profile.setVisible(false);
        p3Profile.setVisible(false);
        rolledDice.setFont(new Font("Showcard Gothic",Font.BOLD,40));
        Dice_button.setBounds(width/2 -12,50,64,64);
       // rolledDice.setBounds(width/2-32,height/3+200,64,64);

        GameLogo.setText("Snake & Ladder");
        twoPlayerButton.setText("Two PLayer");
        fourPLayerButton.setText("Four Player");
        Display_option.setText("Choose  Player !");

        GameLogo.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
        Display_option.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        twoPlayerButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 10));
        fourPLayerButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 10));
        home.add(p1Profile);
        home.add(p2Profile);
        home.add(p3Profile);
        home.add(p4Profile);
        home.add(board);
        board.add(board_label);
        board.add(piece1);
        board.add(piece2);
        board.add(piece3);
        board.add(piece4);
        Dice_button.setIcon(d6);
        p1Profile.setIcon(user);
        p2Profile.setIcon(user1);
        p3Profile.setIcon(user2);
        p4Profile.setIcon(user3);
        board_label.setIcon(boardImage);

        piece1.setIcon(p1);
        piece2.setIcon(p2);
        piece3.setIcon(p3);
        piece4.setIcon(p4);

        board_label.setBounds(0,0,600,600);
        p1Profile.setBounds(width/2 -84,50,64,64);
        p2Profile.setBounds(50,height/2 -118,64,64);
        p3Profile.setBounds(width/2 -84,height-118,64,64);
        p4Profile.setBounds(width -100,height/2 -118,64,64);

        Dice_button.addActionListener(this);
        HOME.addActionListener(this);
        twoPlayerButton.setFocusable(false);
        fourPLayerButton.setFocusable(false);
        home.addKeyListener(this);

        twoPlayerButton.addActionListener(this);
        fourPLayerButton.addActionListener(this);
        HOME.addActionListener(this);
        theme.open(themestream);
        diceroll.open(dicerollsteam);
        snake.open(snakestream);
        ladder.open(ladderstream);
        win.open(winstream);
        step.open(Stepstream);
        theme.start();
        while (i!=-3){

            if(j==1){
                roll(Player);

                j=0;
            } else if (j==-2) {

                home.dispose();
                new HomePage(10);
                ReturnHome();
            }
            Thread.sleep(200);
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fourPLayerButton) {
            Bit=4;
            p2Profile.setVisible(true);
            p4Profile.setVisible(true);
            home.setAlwaysOnTop(false);
            new JOptionPaneWithLabels();

            clearHome();
        }
        if (e.getSource() == twoPlayerButton) {

            Bit=2;

            clearHome();
        }
        if (e.getSource()==Dice_button){

            j=1;


        }
        if (e.getSource()==HOME){
            j=-2;
            ReturnHome();



        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (position[Player]!=100){
        j=1;}
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
