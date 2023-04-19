package com.company;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.event.*;

public class JavaProject_Sudoku extends Frame {
    public int a=1;
    public int[][] GRID_TO_SOLVE1;

    //CHECK SUB-CONDITION
    private boolean isInRow(int row, int a) {
        for (int i = 0; i < 9; i++)
            if (GRID_TO_SOLVE1[row][i] == a)
                return true;

        return false;
    }

    private boolean isInCol(int col, int a) {
        for (int i = 0; i < 9; i++)
            if (GRID_TO_SOLVE1[i][col] == a)
                return true;
        return false;
    }

    private boolean isInBox(int row, int col, int a) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (GRID_TO_SOLVE1[i][j] == a)
                    return true;

        return false;
    }

    //CHECK MAIN CONDITION
    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }

    /*
    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 9) {
                    for (int number = 1; number <= 9; number++) {
                        if (isOk(row, col, number)) {
                            board[row][col] = number;

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 9;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    */

    JavaProject_Sudoku() {

        //FRAME 1: HOMEPAGE
        Frame f2 = new Frame("Start game!");
        f2.setSize(1970, 1970);
        f2.setBounds(0, 0, 1970, 1970);
        f2.setIconImage(new ImageIcon("C:\\Users\\user\\Downloads\\sudoku.png").getImage());

        JButton b = new JButton("PLAY");
        Border border2 = BorderFactory.createLineBorder(Color.black, 4, true);
        b.setBorder(border2);
        b.setBounds(645, 500, 280, 100);
        Font font2 = new Font("SANS_SERIF", Font.BOLD, 26);
        b.setFont(font2);
        b.setBackground(Color.orange);
        b.setForeground(Color.black);
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b.setBackground(Color.yellow);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b.setBackground(Color.orange);
            }
        });
        b.setActionCommand("PLAY");
        class ButtonClickedListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String c = e.getActionCommand();
                if (c.equals("PLAY")) {
                    //FRAME 2: SELECT LEVEL
                    Frame f3 = new Frame("Choose Level");
                    f3.setBackground(Color.white);
                    f3.setVisible(true);
                    f3.setBounds(0, 0, 1970, 1970);
                    f3.setIconImage(new ImageIcon("C:\\Users\\user\\Downloads\\sudoku.png").getImage());
                    Panel p14 = new Panel();
                    p14.setBounds(650, 250, 210, 45);
                    p14.setBackground(Color.pink);
                    Label choose = new Label("CHOOSE LEVEL");
                    choose.setFont(font2);
                    choose.setForeground(Color.white);
                    choose.setAlignment(Label.CENTER);
                    p14.add(choose);

                    //SUDOKU FRAME
                    Frame Main = new Frame();
                    Main.setBackground(Color.white);
                    Main.setTitle("Let's play SUDOKU!");
                    Main.setForeground(Color.black);
                    Main.setIconImage(new ImageIcon("C:\\Users\\user\\Downloads\\sudoku.png").getImage());
                    Main.setSize(1970, 1970);
                    Main.setVisible(false);
                    //setVisible(true);

                    //panel
                    Panel p = new Panel();
                    //label 1
                    Label l = new Label("SUDOKU");
                    l.setAlignment(Label.CENTER);
                    l.setForeground(Color.black);
                    Font font = new Font("SANS_SERIF", Font.BOLD, 34);
                    l.setFont(font);
                    //button 1:START BUTTON
                    Button b1 = new Button("START");
                    Font font1 = new Font("SANS_SERIF", Font.ITALIC, 16);
                    b1.setBounds(1230, 100, 80, 40);
                    b1.setBackground(Color.white);
                    b1.setForeground(Color.red);
                    b1.setFont(font1);
                    //button 1:Mouse on entering button
                    b1.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                            b1.setBackground(Color.gray.brighter());
                            Font font2 = new Font("SANS_SERIF", Font.BOLD, 18);
                            b1.setForeground(Color.green);
                            b1.setFont(font2);
                        }

                        @Override
                        public void mouseExited(java.awt.event.MouseEvent evt) {
                            b1.setBackground(Color.white);
                            b1.setForeground(Color.red);
                            b1.setFont(font1);
                        }
                    });

                    //button 2: GIVE UP
                    Button b2 = new Button("Give Up!");
                    b2.setBounds(1230, 730, 80, 40);
                    b2.setFont(font1);
                    b2.setBackground(Color.yellow);
                    b2.setForeground(Color.black);
                    b2.setActionCommand("Give Up!");
                    class ButtonClickListener implements ActionListener {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String command = e.getActionCommand();
                            if (command.equals("Give Up!")) {
                                //Give Up Button frame
                                Frame f1 = new Frame("YOU GAVE UP!!");
                                f1.setIconImage(new ImageIcon("C:\\Users\\user\\Downloads\\sudoku_sad.png").getImage());
                                f1.setBackground(Color.black);
                                f1.setBounds(300, 300, 970, 200);
                                Panel p11 = new Panel();
                                Label A = new Label("You couldn't solve the sudoku!");
                                Font font4 = new Font("SANS_SERIF", Font.BOLD, 50);
                                A.setFont(font4);
                                A.setForeground(Color.white);
                                A.setSize(100, 100);
                                A.setAlignment(Label.CENTER);
                                f1.addWindowListener(new WindowAdapter() {
                                    public void windowClosing(WindowEvent we) {
                                        f1.dispose();
                                    }
                                });
                                f1.add(p11);
                                p11.add(A);
                                f1.setVisible(true);
                            }
                        }
                    }
                    b2.addActionListener(new ButtonClickListener());

                    //button 3: SUBMIT
                    Button b3 = new Button("SUBMIT");
                    b3.setBounds(1330, 730, 80, 40);
                    b3.setFont(font1);
                    b3.setBackground(Color.gray.brighter());
                    b3.setForeground(Color.white);
                    b3.setActionCommand("SUBMIT");
                    b3.setVisible(false);

                    class ButtonClickedListener4 implements ActionListener {
                        public void actionPerformed(ActionEvent e) {
                            String get = e.getActionCommand();
                            if (get.equals("SUBMIT")) {
                                Frame finalpg = new Frame("WINNER");
                                finalpg.setVisible(true);
                                finalpg.setBounds(0, 0, 1970, 1080);
                                finalpg.setBackground(Color.black);
                                finalpg.setForeground(Color.white);

                                Panel pf = new Panel();
                                ImageIcon image1 = new ImageIcon("C:\\Users\\user\\Downloads\\Sudoku_smile.jpg");
                                JLabel background1 = new JLabel(image1);
                                background1.setBounds(0, 0, 1970, 1080);

                                Panel Final1 = new Panel();
                                Label final1 = new Label("YOU'VE SUCCESSFULLY SOLVED THE SUDOKU");
                                final1.setFont(font2);
                                Final1.setBackground(Color.white);
                                final1.setForeground(Color.black);
                                finalpg.addWindowListener(new WindowAdapter(){
                                        public void windowClosing(WindowEvent we){
                                            finalpg.dispose();
                                }
                                });

                                Final1.add(final1);
                                Final1.add(background1);
                                finalpg.add(pf);
                                finalpg.add(Final1);
                            }

                        }
                    }

                    class ButtonClickedListener5 implements ActionListener {
                        public void actionPerformed(ActionEvent e) {
                            String get = e.getActionCommand();
                            if (get.equals("SUBMIT")) {
                                Frame finalpg = new Frame("LOSER");

                                finalpg.setVisible(true);
                                finalpg.setBounds(0, 0, 1970, 1080);
                                finalpg.setBackground(Color.black);
                                finalpg.setForeground(Color.white);
                                Panel Final1 = new Panel();
                                Label final1 = new Label("YOU COULDN'T SOLVE THE SUDOKU");
                                final1.setBounds(600, 600, 100, 100);
                                final1.setForeground(Color.white);
                                Final1.add(final1);
                                finalpg.add(Final1);
                                finalpg.addWindowListener(new WindowAdapter(){
                                    public void windowClosing(WindowEvent we){
                                        finalpg.dispose();
                                    }
                                });
                            }
                        }
                    }
                    /**/
                    if (a==1) {
                        b3.addActionListener(new ButtonClickedListener4());
                    } else {
                        b3.addActionListener(new ButtonClickedListener5());
                    }

                    /**/


                    //Sudoku main grid
                    GridLayout layout1 = new GridLayout(3, 3, 1, 1);
                    Panel p1 = new Panel();
                    p1.setBounds(350, 200, 800, 500);
                    p1.setLayout(layout1);
                    Border border = BorderFactory.createLineBorder(Color.black, 3, true);
                    JLabel LL1 = new JLabel();
                    LL1.setBorder(border);
                    JLabel LL2 = new JLabel();
                    LL2.setBorder(border);
                    JLabel LL3 = new JLabel();
                    LL3.setBorder(border);
                    JLabel LL4 = new JLabel();
                    LL4.setBorder(border);
                    JLabel LL5 = new JLabel();
                    LL5.setBorder(border);
                    JLabel LL6 = new JLabel();
                    LL6.setBorder(border);
                    JLabel LL7 = new JLabel();
                    LL7.setBorder(border);
                    JLabel LL8 = new JLabel();
                    LL8.setBorder(border);
                    JLabel LL9 = new JLabel();
                    LL9.setBorder(border);

                    //subgrid 1: sudoku
                    GridLayout layout2 = new GridLayout(3, 3, 1, 1);
                    Panel p2 = new Panel();
                    p2.setBounds(357, 207, 251, 151);
                    p2.setLayout(layout2);
                    Border border1 = BorderFactory.createLineBorder(Color.black, 1, false);
                    JLabel LA1 = new JLabel("", JLabel.CENTER);
                    LA1.setBorder(border1);
                    JLabel LA2 = new JLabel("", JLabel.CENTER);
                    LA2.setBorder(border1);
                    JLabel LA3 = new JLabel("", JLabel.CENTER);
                    LA3.setBorder(border1);
                    JLabel LA4 = new JLabel("", JLabel.CENTER);
                    LA4.setBorder(border1);
                    JLabel LA5 = new JLabel("", JLabel.CENTER);
                    LA5.setBorder(border1);
                    JLabel LA6 = new JLabel("", JLabel.CENTER);
                    LA6.setBorder(border1);
                    JLabel LA7 = new JLabel("", JLabel.CENTER);
                    LA7.setBorder(border1);
                    JLabel LA8 = new JLabel("", JLabel.CENTER);
                    LA8.setBorder(border1);
                    JLabel LA9 = new JLabel("", JLabel.CENTER);
                    LA9.setBorder(border1);

                    //subgrid 2:sudoku
                    GridLayout layout3 = new GridLayout(3, 3, 1, 1);
                    Panel p3 = new Panel();
                    p3.setBounds(625, 207, 251, 151);
                    p3.setLayout(layout3);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LB1 = new JLabel("", JLabel.CENTER);
                    LB1.setBorder(border1);
                    JLabel LB2 = new JLabel("", JLabel.CENTER);
                    LB2.setBorder(border1);
                    JLabel LB3 = new JLabel("", JLabel.CENTER);
                    LB3.setBorder(border1);
                    JLabel LB4 = new JLabel("", JLabel.CENTER);
                    LB4.setBorder(border1);
                    JLabel LB5 = new JLabel("", JLabel.CENTER);
                    LB5.setBorder(border1);
                    JLabel LB6 = new JLabel("", JLabel.CENTER);
                    LB6.setBorder(border1);
                    JLabel LB7 = new JLabel("", JLabel.CENTER);
                    LB7.setBorder(border1);
                    JLabel LB8 = new JLabel("", JLabel.CENTER);
                    LB8.setBorder(border1);
                    JLabel LB9 = new JLabel("", JLabel.CENTER);
                    LB9.setBorder(border1);

                    //subgrid 3:sudoku
                    GridLayout layout4 = new GridLayout(3, 3, 1, 1);
                    Panel p4 = new Panel();
                    p4.setBounds(892, 207, 251, 151);
                    p4.setLayout(layout4);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LC1 = new JLabel("", JLabel.CENTER);
                    LC1.setBorder(border1);
                    JLabel LC2 = new JLabel("", JLabel.CENTER);
                    LC2.setBorder(border1);
                    JLabel LC3 = new JLabel("", JLabel.CENTER);
                    LC3.setBorder(border1);
                    JLabel LC4 = new JLabel("", JLabel.CENTER);
                    LC4.setBorder(border1);
                    JLabel LC5 = new JLabel("", JLabel.CENTER);
                    LC5.setBorder(border1);
                    JLabel LC6 = new JLabel("", JLabel.CENTER);
                    LC6.setBorder(border1);
                    JLabel LC7 = new JLabel("", JLabel.CENTER);
                    LC7.setBorder(border1);
                    JLabel LC8 = new JLabel("", JLabel.CENTER);
                    LC8.setBorder(border1);
                    JLabel LC9 = new JLabel("", JLabel.CENTER);
                    LC9.setBorder(border1);

                    //subgrid 4:sudoku
                    GridLayout layout5 = new GridLayout(3, 3, 1, 1);
                    Panel p5 = new Panel();
                    p5.setBounds(357, 375, 251, 151);
                    p5.setLayout(layout5);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LD1 = new JLabel("", JLabel.CENTER);
                    LD1.setBorder(border1);
                    JLabel LD2 = new JLabel("", JLabel.CENTER);
                    LD2.setBorder(border1);
                    JLabel LD3 = new JLabel("", JLabel.CENTER);
                    LD3.setBorder(border1);
                    JLabel LD4 = new JLabel("", JLabel.CENTER);
                    LD4.setBorder(border1);
                    JLabel LD5 = new JLabel("", JLabel.CENTER);
                    LD5.setBorder(border1);
                    JLabel LD6 = new JLabel("", JLabel.CENTER);
                    LD6.setBorder(border1);
                    JLabel LD7 = new JLabel("", JLabel.CENTER);
                    LD7.setBorder(border1);
                    JLabel LD8 = new JLabel("", JLabel.CENTER);
                    LD8.setBorder(border1);
                    JLabel LD9 = new JLabel("", JLabel.CENTER);
                    LD9.setBorder(border1);

                    //subgrid 5:sudoku
                    GridLayout layout6 = new GridLayout(3, 3, 1, 1);
                    Panel p6 = new Panel();
                    p6.setBounds(625, 375, 251, 151);
                    p6.setLayout(layout6);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LE1 = new JLabel("", JLabel.CENTER);
                    LE1.setBorder(border1);
                    JLabel LE2 = new JLabel("", JLabel.CENTER);
                    LE2.setBorder(border1);
                    JLabel LE3 = new JLabel("", JLabel.CENTER);
                    LE3.setBorder(border1);
                    JLabel LE4 = new JLabel("", JLabel.CENTER);
                    LE4.setBorder(border1);
                    JLabel LE5 = new JLabel("", JLabel.CENTER);
                    LE5.setBorder(border1);
                    JLabel LE6 = new JLabel("", JLabel.CENTER);
                    LE6.setBorder(border1);
                    JLabel LE7 = new JLabel("", JLabel.CENTER);
                    LE7.setBorder(border1);
                    JLabel LE8 = new JLabel("", JLabel.CENTER);
                    LE8.setBorder(border1);
                    JLabel LE9 = new JLabel("", JLabel.CENTER);
                    LE9.setBorder(border1);

                    //subgrid 6:sudoku
                    GridLayout layout7 = new GridLayout(3, 3, 1, 1);
                    Panel p7 = new Panel();
                    p7.setBounds(892, 375, 251, 151);
                    p7.setLayout(layout7);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LF1 = new JLabel("", JLabel.CENTER);
                    LF1.setBorder(border1);
                    JLabel LF2 = new JLabel("", JLabel.CENTER);
                    LF2.setBorder(border1);
                    JLabel LF3 = new JLabel("", JLabel.CENTER);
                    LF3.setBorder(border1);
                    JLabel LF4 = new JLabel("", JLabel.CENTER);
                    LF4.setBorder(border1);
                    JLabel LF5 = new JLabel("", JLabel.CENTER);
                    LF5.setBorder(border1);
                    JLabel LF6 = new JLabel("", JLabel.CENTER);
                    LF6.setBorder(border1);
                    JLabel LF7 = new JLabel("", JLabel.CENTER);
                    LF7.setBorder(border1);
                    JLabel LF8 = new JLabel("", JLabel.CENTER);
                    LF8.setBorder(border1);
                    JLabel LF9 = new JLabel("", JLabel.CENTER);
                    LF9.setBorder(border1);

                    //subgrid 7:sudoku
                    GridLayout layout8 = new GridLayout(3, 3, 1, 1);
                    Panel p8 = new Panel();
                    p8.setBounds(357, 542, 251, 151);
                    p8.setLayout(layout8);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LG1 = new JLabel("", JLabel.CENTER);
                    LG1.setBorder(border1);
                    JLabel LG2 = new JLabel("", JLabel.CENTER);
                    LG2.setBorder(border1);
                    JLabel LG3 = new JLabel("", JLabel.CENTER);
                    LG3.setBorder(border1);
                    JLabel LG4 = new JLabel("", JLabel.CENTER);
                    LG4.setBorder(border1);
                    JLabel LG5 = new JLabel("", JLabel.CENTER);
                    LG5.setBorder(border1);
                    JLabel LG6 = new JLabel("", JLabel.CENTER);
                    LG6.setBorder(border1);
                    JLabel LG7 = new JLabel("", JLabel.CENTER);
                    LG7.setBorder(border1);
                    JLabel LG8 = new JLabel("", JLabel.CENTER);
                    LG8.setBorder(border1);
                    JLabel LG9 = new JLabel("", JLabel.CENTER);
                    LG9.setBorder(border1);

                    //subgrid 8:sudoku
                    GridLayout layout9 = new GridLayout(3, 3, 1, 1);
                    Panel p9 = new Panel();
                    p9.setBounds(625, 542, 251, 151);
                    p9.setLayout(layout9);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LH1 = new JLabel("", JLabel.CENTER);
                    LH1.setBorder(border1);
                    JLabel LH2 = new JLabel("", JLabel.CENTER);
                    LH2.setBorder(border1);
                    JLabel LH3 = new JLabel("", JLabel.CENTER);
                    LH3.setBorder(border1);
                    JLabel LH4 = new JLabel("", JLabel.CENTER);
                    LH4.setBorder(border1);
                    JLabel LH5 = new JLabel("", JLabel.CENTER);
                    LH5.setBorder(border1);
                    JLabel LH6 = new JLabel("", JLabel.CENTER);
                    LH6.setBorder(border1);
                    JLabel LH7 = new JLabel("", JLabel.CENTER);
                    LH7.setBorder(border1);
                    JLabel LH8 = new JLabel("", JLabel.CENTER);
                    LH8.setBorder(border1);
                    JLabel LH9 = new JLabel("", JLabel.CENTER);
                    LH9.setBorder(border1);

                    //subgrid 9:sudoku
                    GridLayout layout10 = new GridLayout(3, 3, 1, 1);
                    Panel p10 = new Panel();
                    p10.setBounds(892, 542, 251, 151);
                    p10.setLayout(layout10);
                    //Border border1 = BorderFactory.createLineBorder(Color.black, 4, false);
                    JLabel LI1 = new JLabel("", JLabel.CENTER);
                    LI1.setBorder(border1);
                    JLabel LI2 = new JLabel("", JLabel.CENTER);
                    LI2.setBorder(border1);
                    JLabel LI3 = new JLabel("", JLabel.CENTER);
                    LI3.setBorder(border1);
                    JLabel LI4 = new JLabel("", JLabel.CENTER);
                    LI4.setBorder(border1);
                    JLabel LI5 = new JLabel("", JLabel.CENTER);
                    LI5.setBorder(border1);
                    JLabel LI6 = new JLabel("", JLabel.CENTER);
                    LI6.setBorder(border1);
                    JLabel LI7 = new JLabel("", JLabel.CENTER);
                    LI7.setBorder(border1);
                    JLabel LI8 = new JLabel("", JLabel.CENTER);
                    LI8.setBorder(border1);
                    JLabel LI9 = new JLabel("", JLabel.CENTER);
                    LI9.setBorder(border1);


                    //ADDING COMPONENTS TO PANEL
                    p1.add(LL1);
                    p1.add(LL2);
                    p1.add(LL3);
                    p1.add(LL4);
                    p1.add(LL5);
                    p1.add(LL6);
                    p1.add(LL7);
                    p1.add(LL8);
                    p1.add(LL9);

                    p2.add(LA1);
                    p2.add(LA2);
                    p2.add(LA3);
                    p2.add(LA4);
                    p2.add(LA5);
                    p2.add(LA6);
                    p2.add(LA7);
                    p2.add(LA8);
                    p2.add(LA9);

                    p3.add(LB1);
                    p3.add(LB2);
                    p3.add(LB3);
                    p3.add(LB4);
                    p3.add(LB5);
                    p3.add(LB6);
                    p3.add(LB7);
                    p3.add(LB8);
                    p3.add(LB9);

                    p4.add(LC1);
                    p4.add(LC2);
                    p4.add(LC3);
                    p4.add(LC4);
                    p4.add(LC5);
                    p4.add(LC6);
                    p4.add(LC7);
                    p4.add(LC8);
                    p4.add(LC9);

                    p5.add(LD1);
                    p5.add(LD2);
                    p5.add(LD3);
                    p5.add(LD4);
                    p5.add(LD5);
                    p5.add(LD6);
                    p5.add(LD7);
                    p5.add(LD8);
                    p5.add(LD9);

                    p6.add(LE1);
                    p6.add(LE2);
                    p6.add(LE3);
                    p6.add(LE4);
                    p6.add(LE5);
                    p6.add(LE6);
                    p6.add(LE7);
                    p6.add(LE8);
                    p6.add(LE9);

                    p7.add(LF1);
                    p7.add(LF2);
                    p7.add(LF3);
                    p7.add(LF4);
                    p7.add(LF5);
                    p7.add(LF6);
                    p7.add(LF7);
                    p7.add(LF8);
                    p7.add(LF9);

                    p8.add(LG1);
                    p8.add(LG2);
                    p8.add(LG3);
                    p8.add(LG4);
                    p8.add(LG5);
                    p8.add(LG6);
                    p8.add(LG7);
                    p8.add(LG8);
                    p8.add(LG9);

                    p9.add(LH1);
                    p9.add(LH2);
                    p9.add(LH3);
                    p9.add(LH4);
                    p9.add(LH5);
                    p9.add(LH6);
                    p9.add(LH7);
                    p9.add(LH8);
                    p9.add(LH9);

                    p10.add(LI1);
                    p10.add(LI2);
                    p10.add(LI3);
                    p10.add(LI4);
                    p10.add(LI5);
                    p10.add(LI6);
                    p10.add(LI7);
                    p10.add(LI8);
                    p10.add(LI9);

                    //panel order matters
                    //SUBGRID TO FRAME
                    Main.add(p2);
                    Main.add(p3);
                    Main.add(p4);
                    Main.add(p5);
                    Main.add(p6);
                    Main.add(p7);
                    Main.add(p8);
                    Main.add(p9);
                    Main.add(p10);
                    //MAIN GRID TO FRAME
                    Main.add(p1);

                    //COMPONENTS TO FRAME
                    p.add(l);
                    Main.add(b1);
                    Main.add(b2);
                    Main.add(b3);
                    Main.add(p);
                    Main.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent we) {
                            Main.dispose();
                        }
                    });


                    JButton button1 = new JButton("EASY");
                    button1.setBorder(border2);
                    button1.setBounds(300, 400, 280, 100);
                    button1.setSize(280, 100);
                    button1.setFont(font2);
                    button1.setBackground(Color.gray.brighter());
                    button1.setForeground(Color.black);

                    JButton button2 = new JButton("INTERMEDIATE");
                    button2.setBorder(border2);
                    button2.setBounds(620, 400, 280, 100);
                    button2.setSize(280, 100);
                    button2.setFont(font2);
                    button2.setBackground(Color.gray);
                    button2.setForeground(Color.black);

                    JButton button3 = new JButton("EXPERT");
                    button3.setBorder(border2);
                    button3.setBounds(940, 400, 280, 100);
                    button3.setSize(280, 100);
                    button3.setFont(font2);
                    button3.setBackground(Color.gray.darker());
                    button3.setForeground(Color.black);


                    //adding button even
                    button1.setActionCommand("EASY");
                    button2.setActionCommand("INTERMEDIATE");
                    button3.setActionCommand("EXPERT");

                    class ButtonClickedListener3 implements ActionListener {
                        public void actionPerformed(ActionEvent e) {
                            String easy = e.getActionCommand();

                            if (easy.equals("EASY")) {

                                Main.setVisible(true);
                                b1.setActionCommand("START");
                                class ButtonClickedListener6 implements ActionListener {
                                    public void actionPerformed(ActionEvent e) {
                                        String start = e.getActionCommand();
                                        if (start.equals("START")) {
                                            LA1.setText("1");
                                            LA2.setText("2");
                                            LA3.setText("3");
                                            LA4.setText("4");
                                            LA5.setText("5");
                                            LA6.setText("6");
                                            LA7.setText("7");
                                            LA8.setText("8");
                                            LA9.setText("9");

                                            LB1.setText("4");
                                            LB2.setText("5");
                                            LB3.setText("6");
                                            LB4.setText("7");
                                            LB5.setText("8");
                                            LB6.setText("9");
                                            LB7.setText("1");
                                            LB8.setText("2");
                                            LB9.setText("3");

                                            LC1.setText("7");
                                            LC2.setText("8");
                                            LC3.setText("9");
                                            LC4.setText("1");
                                            LC5.setText("2");
                                            LC6.setText("3");
                                            LC7.setText("4");
                                            LC8.setText("5");
                                            LC9.setText("6");

                                            LD1.setText("2");
                                            LD2.setText("1");
                                            LD3.setText("4");
                                            LD4.setText("3");
                                            LD5.setText("6");
                                            LD6.setText("7");
                                            LD7.setText("5");
                                            LD8.setText("9");
                                            LD9.setText("8");

                                            LE1.setText("3");
                                            LE2.setText("6");
                                            LE3.setText("5");
                                            LE4.setText("9");
                                            LE5.setText("1");
                                            LE6.setText("8");
                                            LE7.setText("2");
                                            LE8.setText("4");
                                            LE9.setText("7");

                                            LF1.setText("8");
                                            LF2.setText("9");
                                            LF3.setText("7");
                                            LF4.setText("2");
                                            LF5.setText("4");
                                            LF6.setText("5");
                                            LF7.setText("3");
                                            LF8.setText("6");
                                            LF9.setText("1");

                                            LG1.setText("6");
                                            LG2.setText("3");
                                            LG3.setText("1");
                                            LG4.setText("8");
                                            LG5.setText("4");
                                            LG6.setText("5");
                                            LG7.setText("9");
                                            LG8.setText("7");
                                            LG9.setText("2");

                                            LH1.setText("8");
                                            LH2.setText("9");
                                            LH3.setText("2");
                                            LH4.setText("6");
                                            LH5.setText("7");
                                            LH6.setText("1");
                                            LH7.setText("5");
                                            LH8.setText("3");
                                            LH9.setText("4");

                                            LI1.setText("5");
                                            LI2.setText("7");
                                            LI3.setText("4");
                                            LI4.setText("9");
                                            LI5.setText("3");
                                            LI6.setText("2");
                                            LI7.setText("6");
                                            LI8.setText("1");
                                            LI9.setText("8");

                                            b3.setVisible(true);

                                            TextField x = new TextField();

                                            p6.add(x, 5);
                                            p6.remove(LE5);
                                            //b3.setVisible(true);
                                            String ch = x.getText();
                                            a = Integer.parseInt(ch);

                                            GRID_TO_SOLVE1 = new int[][]{
                                                    {1, 2, 3, 4, 5, 6, 7, 8, 9},
                                                    {4, 5, 6, 7, 8, 9, 1, 2, 3},
                                                    {7, 8, 9, 1, 2, 3, 4, 5, 6},
                                                    {2, 1, 4, 3, 6, 5, 8, 9, 7},
                                                    {3, 6, 7, 9, a, 8, 2, 4, 5},
                                                    {5, 9, 8, 2, 4, 7, 3, 6, 1},
                                                    {6, 3, 1, 8, 9, 2, 5, 7, 4},
                                                    {8, 4, 5, 6, 7, 1, 9, 3, 2},
                                                    {9, 7, 2, 5, 3, 4, 6, 1, 8},
                                            };
                                            isOk(5, 5, a);

                                        }
                                    }
                                }
                                b1.addActionListener(new ButtonClickedListener6());
                            }
                            else if (easy.equals("INTERMEDIATE")) {
                                Main.setVisible(true);
                                b1.setActionCommand("START");
                                class ButtonClickedListener6 implements ActionListener {
                                    public void actionPerformed(ActionEvent e) {
                                        String start = e.getActionCommand();
                                        if (start.equals("START")) {
                                            LA1.setText("0");
                                            LA2.setText("0");
                                            LA3.setText("6");
                                            LA4.setText("0");
                                            LA5.setText("0");
                                            LA6.setText("0");
                                            LA7.setText("4");
                                            LA8.setText("0");
                                            LA9.setText("3");

                                            LB1.setText("1");
                                            LB2.setText("2");
                                            LB3.setText("0");
                                            LB4.setText("0");
                                            LB5.setText("7");
                                            LB6.setText("8");
                                            LB7.setText("5");
                                            LB8.setText("0");
                                            LB9.setText("9");

                                            LC1.setText("0");
                                            LC2.setText("0");
                                            LC3.setText("0");
                                            LC4.setText("0");
                                            LC5.setText("2");
                                            LC6.setText("0");
                                            LC7.setText("0");
                                            LC8.setText("0");
                                            LC9.setText("7");

                                            LD1.setText("0");
                                            LD2.setText("3");
                                            LD3.setText("5");
                                            LD4.setText("0");
                                            LD5.setText("0");
                                            LD6.setText("9");
                                            LD7.setText("7");
                                            LD8.setText("0");
                                            LD9.setText("0");

                                            LE1.setText("0");
                                            LE2.setText("8");
                                            LE3.setText("0");
                                            LE4.setText("0");
                                            LE5.setText("3");
                                            LE6.setText("0");
                                            LE7.setText("0");
                                            LE8.setText("5");
                                            LE9.setText("0");

                                            LF1.setText("0");
                                            LF2.setText("0");
                                            LF3.setText("2");
                                            LF4.setText("1");
                                            LF5.setText("0");
                                            LF6.setText("0");
                                            LF7.setText("6");
                                            LF8.setText("3");
                                            LF9.setText("0");

                                            LG1.setText("1");
                                            LG2.setText("0");
                                            LG3.setText("0");
                                            LG4.setText("0");
                                            LG5.setText("5");
                                            LG6.setText("0");
                                            LG7.setText("0");
                                            LG8.setText("0");
                                            LG9.setText("0");

                                            LH1.setText("2");
                                            LH2.setText("0");
                                            LH3.setText("5");
                                            LH4.setText("8");
                                            LH5.setText("4");
                                            LH6.setText("0");
                                            LH7.setText("0");
                                            LH8.setText("1");
                                            LH9.setText("7");

                                            LI1.setText("3");
                                            LI2.setText("0");
                                            LI3.setText("8");
                                            LI4.setText("0");
                                            LI5.setText("0");
                                            LI6.setText("0");
                                            LI7.setText("2");
                                            LI8.setText("0");
                                            LI9.setText("0");
                                            b3.setVisible(true);

                                            GRID_TO_SOLVE1 = new int[][]{
                                                    {0, 0, 6, 1, 2, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 7, 8, 0, 2, 0},
                                                    {4, 0, 3, 5, 0, 9, 0, 0, 7},
                                                    {0, 3, 5, 0, 8, 0, 0, 0, 2},
                                                    {0, 0, 9, 0, 3, 0, 1, 0, 0},
                                                    {7, 0, 0, 0, 5, 0, 6, 3, 0},
                                                    {1, 0, 0, 2, 0, 5, 3, 0, 8},
                                                    {0, 5, 0, 8, 4, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 1, 7, 2, 0, 0},
                                            };

                                            TextField a1 = new TextField();
                                            p2.add(a1, 1);
                                            p2.remove(LA1);

                                            TextField a2 = new TextField();
                                            p2.add(a2, 2);
                                            p2.remove(LA2);

                                            TextField a3 = new TextField();
                                            p2.add(a3, 4);
                                            p2.remove(LA4);

                                            TextField a4 = new TextField();
                                            p2.add(a4, 5);
                                            p2.remove(LA5);

                                            TextField a5 = new TextField();
                                            p2.add(a5, 6);
                                            p2.remove(LA6);

                                            TextField a6 = new TextField();
                                            p2.add(a6, 8);
                                            p2.remove(LA8);

                                            TextField b1 = new TextField();
                                            p3.add(b1, 3);
                                            p3.remove(LB3);

                                            TextField b2 = new TextField();
                                            p3.add(b2, 4);
                                            p3.remove(LB4);

                                            TextField b3 = new TextField();
                                            p3.add(b3, 8);
                                            p3.remove(LB8);

                                            TextField c1 = new TextField();
                                            p4.add(c1, 1);
                                            p4.remove(LC1);

                                            TextField c2 = new TextField();
                                            p4.add(c2, 2);
                                            p4.remove(LC2);

                                            TextField c3 = new TextField();
                                            p4.add(c3, 3);
                                            p4.remove(LC3);

                                            TextField c4 = new TextField();
                                            p4.add(c4, 4);
                                            p4.remove(LC4);

                                            TextField c5 = new TextField();
                                            p4.add(c5, 6);
                                            p4.remove(LC6);

                                            TextField c6 = new TextField();
                                            p4.add(c6, 7);
                                            p4.remove(LC7);

                                            TextField c7 = new TextField();
                                            p4.add(c7, 8);
                                            p4.remove(LC8);

                                            TextField d1 = new TextField();
                                            p5.add(d1, 1);
                                            p5.remove(LD1);

                                            TextField d2 = new TextField();
                                            p5.add(d2, 4);
                                            p5.remove(LD4);

                                            TextField d3 = new TextField();
                                            p5.add(d3, 5);
                                            p5.remove(LD5);

                                            TextField d4 = new TextField();
                                            p5.add(d4, 8);
                                            p5.remove(LD8);

                                            TextField d5 = new TextField();
                                            p5.add(d5, 9);
                                            p5.remove(LD9);

                                            TextField e1 = new TextField();
                                            p6.add(e1, 1);
                                            p6.remove(LE1);

                                            TextField e2 = new TextField();
                                            p6.add(e2, 3);
                                            p6.remove(LE3);

                                            TextField e3 = new TextField();
                                            p6.add(e3, 4);
                                            p6.remove(LE4);

                                            TextField e4 = new TextField();
                                            p6.add(e4, 6);
                                            p6.remove(LE6);

                                            TextField e5 = new TextField();
                                            p6.add(e5, 7);
                                            p6.remove(LE7);

                                            TextField e6 = new TextField();
                                            p6.add(e6, 9);
                                            p6.remove(LE9);

                                            TextField f1 = new TextField();
                                            p7.add(f1, 1);
                                            p7.remove(LF1);

                                            TextField f2 = new TextField();
                                            p7.add(f2, 2);
                                            p7.remove(LF2);

                                            TextField f3 = new TextField();
                                            p7.add(f3, 5);
                                            p7.remove(LF5);

                                            TextField f4 = new TextField();
                                            p7.add(f4, 6);
                                            p7.remove(LF6);

                                            TextField f5 = new TextField();
                                            p7.add(f5, 9);
                                            p7.remove(LF9);

                                            TextField g1 = new TextField();
                                            p8.add(g1, 2);
                                            p8.remove(LG2);

                                            TextField g2 = new TextField();
                                            p8.add(g2, 3);
                                            p8.remove(LG3);

                                            TextField g3 = new TextField();
                                            p8.add(g3, 4);
                                            p8.remove(LG4);

                                            TextField g4 = new TextField();
                                            p8.add(g4, 6);
                                            p8.remove(LG6);

                                            TextField g5 = new TextField();
                                            p8.add(g5, 7);
                                            p8.remove(LG7);

                                            TextField g6 = new TextField();
                                            p8.add(g6, 8);
                                            p8.remove(LG8);

                                            TextField g7 = new TextField();
                                            p8.add(g7, 9);
                                            p8.remove(LG9);


                                            TextField y1 = new TextField();
                                            p9.add(y1, 2);
                                            p9.remove(LH2);

                                            JTextField y2 = new JTextField();
                                            p9.add(y2, 6);
                                            p9.remove(LH6);

                                            JTextField y3 = new JTextField();
                                            p9.add(y3, 7);
                                            p9.remove(LH7);

                                            TextField x1 = new TextField();
                                            p10.add(x1, 2);
                                            p10.remove(LI2);
                                            //String ch = x1.getText();
                                            //int a1 = Integer.parseInt(ch);

                                            JTextField x2 = new JTextField();
                                            p10.add(x2, 4);
                                            p10.remove(LI4);

                                            JTextField x3 = new JTextField();
                                            p10.add(x3, 5);
                                            p10.remove(LI5);

                                            JTextField x4 = new JTextField();
                                            p10.add(x4, 6);
                                            p10.remove(LI6);

                                            JTextField x5 = new JTextField();
                                            p10.add(x5, 8);
                                            p10.remove(LI8);

                                            JTextField x6 = new JTextField();
                                            p10.add(x6, 9);
                                            p10.remove(LI9);




                                            Button submit = new Button("SUBMIT");
                                            submit.setBounds(1330, 730, 80, 40);
                                            submit.setFont(font1);
                                            submit.setBackground(Color.black);
                                            submit.setForeground(Color.white);
                                            submit.setActionCommand("SUBMIT");
                                            Main.add(submit);
                                            class ButtonClickedListener4 implements ActionListener {
                                                public void actionPerformed(ActionEvent e) {
                                                    String get = e.getActionCommand();
                                                    if (get.equals("SUBMIT")) {
                                                        Frame finalpg = new Frame("WINNER");
                                                        finalpg.setVisible(true);
                                                        finalpg.setBounds(0, 0, 1970, 1080);
                                                        finalpg.setBackground(Color.black);
                                                        finalpg.setForeground(Color.white);
                                                        Panel Final1 = new Panel();
                                                        Label final1 = new Label("YOU'VE SUCCESSFULLY SOLVED THE SUDOKU");
                                                        final1.setForeground(Color.white);
                                                        Final1.add(final1);
                                                        finalpg.add(Final1);
                                                    }

                                                }
                                            }

                                            class ButtonClickedListener5 implements ActionListener {
                                                public void actionPerformed(ActionEvent e) {
                                                    String get = e.getActionCommand();
                                                    if (get.equals("SUBMIT")) {
                                                        Frame finalpg = new Frame("LOSER");
                                                        finalpg.setVisible(true);
                                                        finalpg.setBounds(0, 0, 1970, 1080);
                                                        finalpg.setBackground(Color.black);
                                                        finalpg.setForeground(Color.white);
                                                        Panel Final1 = new Panel();
                                                        Label final1 = new Label("YOU COULDN'T SOLVE THE SUDOKU");
                                                        final1.setForeground(Color.white);
                                                        Final1.add(final1);
                                                        finalpg.add(Final1);
                                                    }
                                                }
                                            }
                                            if (a == 1) {
                                                b3.addActionListener(new ButtonClickedListener4());
                                            } else {
                                                b3.addActionListener(new ButtonClickedListener5());

                                            }
                                        }
                                    }
                                }
                                b1.addActionListener(new ButtonClickedListener6());
                            }
                            else if (easy.equals("EXPERT")) {
                                Main.setVisible(true);
                                b1.setActionCommand("START");
                                class ButtonClickedListener6 implements ActionListener {
                                    public void actionPerformed(ActionEvent e) {
                                        String start = e.getActionCommand();
                                        if (start.equals("START")) {
                                            LA1.setText("0");
                                            LA2.setText("0");
                                            LA3.setText("6");
                                            LA4.setText("0");
                                            LA5.setText("0");
                                            LA6.setText("0");
                                            LA7.setText("4");
                                            LA8.setText("0");
                                            LA9.setText("3");

                                            LB1.setText("1");
                                            LB2.setText("2");
                                            LB3.setText("0");
                                            LB4.setText("0");
                                            LB5.setText("7");
                                            LB6.setText("8");
                                            LB7.setText("5");
                                            LB8.setText("0");
                                            LB9.setText("9");

                                            LC1.setText("0");
                                            LC2.setText("0");
                                            LC3.setText("0");
                                            LC4.setText("0");
                                            LC5.setText("2");
                                            LC6.setText("0");
                                            LC7.setText("0");
                                            LC8.setText("0");
                                            LC9.setText("7");

                                            LD1.setText("0");
                                            LD2.setText("3");
                                            LD3.setText("5");
                                            LD4.setText("0");
                                            LD5.setText("0");
                                            LD6.setText("9");
                                            LD7.setText("7");
                                            LD8.setText("0");
                                            LD9.setText("0");

                                            LE1.setText("0");
                                            LE2.setText("8");
                                            LE3.setText("0");
                                            LE4.setText("0");
                                            LE5.setText("3");
                                            LE6.setText("0");
                                            LE7.setText("0");
                                            LE8.setText("5");
                                            LE9.setText("0");

                                            LF1.setText("0");
                                            LF2.setText("0");
                                            LF3.setText("2");
                                            LF4.setText("1");
                                            LF5.setText("0");
                                            LF6.setText("0");
                                            LF7.setText("6");
                                            LF8.setText("3");
                                            LF9.setText("0");

                                            LG1.setText("1");
                                            LG2.setText("0");
                                            LG3.setText("0");
                                            LG4.setText("0");
                                            LG5.setText("5");
                                            LG6.setText("0");
                                            LG7.setText("0");
                                            LG8.setText("0");
                                            LG9.setText("0");

                                            LH1.setText("2");
                                            LH2.setText("0");
                                            LH3.setText("5");
                                            LH4.setText("8");
                                            LH5.setText("4");
                                            LH6.setText("0");
                                            LH7.setText("0");
                                            LH8.setText("1");
                                            LH9.setText("7");

                                            LI1.setText("3");
                                            LI2.setText("0");
                                            LI3.setText("8");
                                            LI4.setText("0");
                                            LI5.setText("0");
                                            LI6.setText("0");
                                            LI7.setText("2");
                                            LI8.setText("0");
                                            LI9.setText("0");
                                            b3.setVisible(true);

                                            GRID_TO_SOLVE1 = new int[][]{
                                                    {0, 0, 0, 1, 2, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 7, 8, 0, 2, 0},
                                                    {0, 0, 0, 5, 0, 9, 0, 0, 7},
                                                    {0, 3, 5, 0, 0, 0, 0, 0, 2},
                                                    {0, 0, 9, 0, 0, 0, 1, 0, 0},
                                                    {7, 0, 0, 0, 0, 0, 6, 3, 0},
                                                    {1, 0, 0, 2, 0, 5, 0, 0, 0},
                                                    {0, 5, 0, 8, 4, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 1, 7, 0, 0, 0},
                                            };

                                            TextField a1 = new TextField();
                                            p2.add(a1, 1);
                                            p2.remove(LA1);

                                            TextField a2 = new TextField();
                                            p2.add(a2, 2);
                                            p2.remove(LA2);

                                            TextField aa = new TextField();
                                            p2.add(aa, 3);
                                            p2.remove(LA3);

                                            TextField a3 = new TextField();
                                            p2.add(a3, 4);
                                            p2.remove(LA4);

                                            TextField a4 = new TextField();
                                            p2.add(a4, 5);
                                            p2.remove(LA5);

                                            TextField a5 = new TextField();
                                            p2.add(a5, 6);
                                            p2.remove(LA6);

                                            TextField a6 = new TextField();
                                            p2.add(a6, 8);
                                            p2.remove(LA8);

                                            TextField a7 = new TextField();
                                            p2.add(a7, 7);
                                            p2.remove(LA7);

                                            TextField a8 = new TextField();
                                            p2.add(a8, 9);
                                            p2.remove(LA9);

                                            TextField b1 = new TextField();
                                            p3.add(b1, 3);
                                            p3.remove(LB3);

                                            TextField b2 = new TextField();
                                            p3.add(b2, 4);
                                            p3.remove(LB4);

                                            TextField b3 = new TextField();
                                            p3.add(b3, 8);
                                            p3.remove(LB8);

                                            TextField c1 = new TextField();
                                            p4.add(c1, 1);
                                            p4.remove(LC1);

                                            TextField c2 = new TextField();
                                            p4.add(c2, 2);
                                            p4.remove(LC2);

                                            TextField c3 = new TextField();
                                            p4.add(c3, 3);
                                            p4.remove(LC3);

                                            TextField c4 = new TextField();
                                            p4.add(c4, 4);
                                            p4.remove(LC4);

                                            TextField c5 = new TextField();
                                            p4.add(c5, 6);
                                            p4.remove(LC6);

                                            TextField c6 = new TextField();
                                            p4.add(c6, 7);
                                            p4.remove(LC7);

                                            TextField c7 = new TextField();
                                            p4.add(c7, 8);
                                            p4.remove(LC8);

                                            TextField d1 = new TextField();
                                            p5.add(d1, 1);
                                            p5.remove(LD1);

                                            TextField d2 = new TextField();
                                            p5.add(d2, 4);
                                            p5.remove(LD4);

                                            TextField d3 = new TextField();
                                            p5.add(d3, 5);
                                            p5.remove(LD5);

                                            TextField d4 = new TextField();
                                            p5.add(d4, 8);
                                            p5.remove(LD8);

                                            TextField d5 = new TextField();
                                            p5.add(d5, 9);
                                            p5.remove(LD9);

                                            TextField e1 = new TextField();
                                            p6.add(e1, 1);
                                            p6.remove(LE1);

                                            TextField ee = new TextField();
                                            p6.add(ee, 2);
                                            p6.remove(LE2);

                                            TextField e2 = new TextField();
                                            p6.add(e2, 3);
                                            p6.remove(LE3);

                                            TextField e3 = new TextField();
                                            p6.add(e3, 4);
                                            p6.remove(LE4);

                                            TextField eb = new TextField();
                                            p6.add(eb, 5);
                                            p6.remove(LE5);

                                            TextField e4 = new TextField();
                                            p6.add(e4, 6);
                                            p6.remove(LE6);

                                            TextField e5 = new TextField();
                                            p6.add(e5, 7);
                                            p6.remove(LE7);

                                            TextField eb1 = new TextField();
                                            p6.add(eb1, 8);
                                            p6.remove(LE8);

                                            TextField e6 = new TextField();
                                            p6.add(e6, 9);
                                            p6.remove(LE9);

                                            TextField f1 = new TextField();
                                            p7.add(f1, 1);
                                            p7.remove(LF1);

                                            TextField f2 = new TextField();
                                            p7.add(f2, 2);
                                            p7.remove(LF2);

                                            TextField f3 = new TextField();
                                            p7.add(f3, 5);
                                            p7.remove(LF5);

                                            TextField f4 = new TextField();
                                            p7.add(f4, 6);
                                            p7.remove(LF6);

                                            TextField f5 = new TextField();
                                            p7.add(f5, 9);
                                            p7.remove(LF9);

                                            TextField g1 = new TextField();
                                            p8.add(g1, 2);
                                            p8.remove(LG2);

                                            TextField g2 = new TextField();
                                            p8.add(g2, 3);
                                            p8.remove(LG3);

                                            TextField g3 = new TextField();
                                            p8.add(g3, 4);
                                            p8.remove(LG4);

                                            TextField g4 = new TextField();
                                            p8.add(g4, 6);
                                            p8.remove(LG6);

                                            TextField g5 = new TextField();
                                            p8.add(g5, 7);
                                            p8.remove(LG7);

                                            TextField g6 = new TextField();
                                            p8.add(g6, 8);
                                            p8.remove(LG8);

                                            TextField g7 = new TextField();
                                            p8.add(g7, 9);
                                            p8.remove(LG9);


                                            TextField y1 = new TextField();
                                            p9.add(y1, 2);
                                            p9.remove(LH2);

                                            JTextField y2 = new JTextField();
                                            p9.add(y2, 6);
                                            p9.remove(LH6);

                                            JTextField y3 = new JTextField();
                                            p9.add(y3, 7);
                                            p9.remove(LH7);

                                            TextField x = new TextField();
                                            p10.add(x, 1);
                                            p10.remove(LI1);

                                            TextField x1 = new TextField();
                                            p10.add(x1, 2);
                                            p10.remove(LI2);
                                            //String ch = x1.getText();
                                            //int a1 = Integer.parseInt(ch);

                                            JTextField xx2 = new JTextField();
                                            p10.add(xx2, 3);
                                            p10.remove(LI3);

                                            JTextField x2 = new JTextField();
                                            p10.add(x2, 4);
                                            p10.remove(LI4);

                                            JTextField x3 = new JTextField();
                                            p10.add(x3, 5);
                                            p10.remove(LI5);

                                            JTextField x4 = new JTextField();
                                            p10.add(x4, 6);
                                            p10.remove(LI6);

                                            JTextField xx4 = new JTextField();
                                            p10.add(xx4, 7);
                                            p10.remove(LI7);

                                            JTextField x5 = new JTextField();
                                            p10.add(x5, 8);
                                            p10.remove(LI8);

                                            JTextField x6 = new JTextField();
                                            p10.add(x6, 9);
                                            p10.remove(LI9);

                                            Button submit = new Button("SUBMIT");
                                            submit.setBounds(1330, 730, 80, 40);
                                            submit.setFont(font1);
                                            submit.setBackground(Color.black);
                                            submit.setForeground(Color.white);
                                            submit.setActionCommand("SUBMIT");
                                            Main.add(submit);
                                            class ButtonClickedListener4 implements ActionListener {
                                                public void actionPerformed(ActionEvent e) {
                                                    String get = e.getActionCommand();
                                                    if (get.equals("SUBMIT")) {
                                                        Frame finalpg = new Frame("WINNER");
                                                        finalpg.setVisible(true);
                                                        finalpg.setBounds(0, 0, 1970, 1080);
                                                        finalpg.setBackground(Color.black);
                                                        finalpg.setForeground(Color.white);
                                                        Panel Final1 = new Panel();
                                                        Label final1 = new Label("YOU'VE SUCCESSFULLY SOLVED THE SUDOKU");
                                                        final1.setForeground(Color.white);
                                                        Final1.add(final1);
                                                        finalpg.add(Final1);
                                                    }

                                                }
                                            }

                                            class ButtonClickedListener5 implements ActionListener {
                                                public void actionPerformed(ActionEvent e) {
                                                    String get = e.getActionCommand();
                                                    if (get.equals("SUBMIT")) {
                                                        Frame finalpg = new Frame("LOSER");
                                                        finalpg.setVisible(true);
                                                        finalpg.setBounds(0, 0, 1970, 1080);
                                                        finalpg.setBackground(Color.black);
                                                        finalpg.setForeground(Color.white);
                                                        Panel Final1 = new Panel();
                                                        Label final1 = new Label("YOU COULDN'T SOLVE THE SUDOKU");
                                                        final1.setForeground(Color.white);
                                                        Final1.add(final1);
                                                        finalpg.add(Final1);
                                                    }
                                                }
                                            }
                                            if (a == 1) {
                                                b3.addActionListener(new ButtonClickedListener4());
                                            } else {
                                                b3.addActionListener(new ButtonClickedListener5());

                                            }
                                        }
                                    }
                                }
                                b1.addActionListener(new ButtonClickedListener6());
                            }
                        }
                    }
                    button1.addActionListener(new ButtonClickedListener3());
                    button2.addActionListener(new ButtonClickedListener3());
                    button3.addActionListener(new ButtonClickedListener3());


                    //add background image
                    Panel p16 = new Panel();
                    ImageIcon img = new ImageIcon("C:\\Users\\user\\Downloads\\sudoku image idea5.png");
                    JLabel bg = new JLabel(img);
                    bg.setBounds(110, 110, 1080, 1080);
                    p16.add(bg);
                    f3.add(button1);
                    f3.add(button2);
                    f3.add(button3);

                    f3.add(p14);
                    f3.add(p16);
                    f3.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent we) {
                            f3.dispose();
                        }
                    });
                }
            }
        }
        b.addActionListener(new ButtonClickedListener());

        Panel p13 = new Panel();
        ImageIcon image = new ImageIcon("C:\\Users\\user\\Downloads\\sudoku_home.png");
        JLabel background = new JLabel(image);
        background.setBounds(0, 0, 1970, 1970);
        f2.add(b);
        p13.add(background);
        f2.add(p13);

        Dialog d = new Dialog(f2, "Exit?", true);
        d.setBackground(Color.white);
        d.setForeground(Color.black);
        d.setBounds(615, 250, 300, 125);
        Panel dlg = new Panel();
        Panel dl = new Panel();
        Label exit = new Label("Do you want to exit the game?");
        exit.setBounds(400, 0, 100, 100);
        exit.setForeground(Color.black);
        Button Yes = new Button("YES");
        Yes.setBounds(100, 70, 50, 20);
        Yes.setBackground(Color.white);
        Yes.setForeground(Color.red);
        Button Cancel = new Button("Cancel");
        Cancel.setBounds(150, 70, 50, 20);
        d.add(dlg);
        dl.add(exit);
        d.add(Yes);
        d.add(Cancel);
        d.add(dl);
        f2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                d.setVisible(true);
            }
        });
        pack();
        f2.setVisible(true);

        Yes.setActionCommand("YES");
        class ButtonClickedListener1 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String g = e.getActionCommand();
                if (g.equals("YES")) {
                    System.exit(0);
                }
            }
        }
        Yes.addActionListener(new ButtonClickedListener1());

        Cancel.setActionCommand("Cancel");
        class ButtonClickedListener2 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String g1 = e.getActionCommand();
                if (g1.equals("Cancel")) {
                    d.setVisible(false);
                }
            }
        }
        Cancel.addActionListener(new ButtonClickedListener2());
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                d.dispose();
            }
        });

    }


    public static void main(String[] args) {
        JavaProject_Sudoku obj = new JavaProject_Sudoku();

    }
}
