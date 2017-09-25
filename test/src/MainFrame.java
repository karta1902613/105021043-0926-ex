import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.Color.green;

public class MainFrame extends Frame{
    private Button btnAdd =new Button("Add");
    private Button btnAuto =new Button("Auto");
    private Button btnExit =new Button("Exit");
    private Label  lab    =new Label("o");
    private Timer tr;
    private Timer tl;
    int count =0;
    int x=20;
    int y;

    public  MainFrame() {
        init();
    }
    private  void init() {
        this.setLayout(null);
        this.setBounds(50,50,400,200);
        btnAdd.setBounds(10,30,100,50);
        btnExit.setBounds(190,30,100,50);
        btnAuto.setBounds(100,30,100,50);
        lab.setBounds(20,100,50,100);

        this.add(btnAdd);
        this.add(btnAuto);
        this.add(btnExit);
        this.add(lab);

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab.setText(Integer.toString(count++));
                MainFrame.this.setTitle(Integer.toString(count++));

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        btnAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               tr.start();

            }
        });
        tr=new Timer(30,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent t) {
                        x+=3;
                        lab.setBounds(x,100,50,100);
                        if(x<=117){
                            lab.setBackground(new Color(0x0F89FF));
                        }else if(x>117&&x<=234){
                            lab.setBackground(new Color(0x50FFEB));
                        }else if(x>234){
                            lab.setBackground(new Color(0x3EFF5C));
                        }

                if(x>=351){
                            tr.stop();
                            tl.start();
                        }
                    }

        });
        tl=new Timer(30,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent t) {
                x-=3;
                lab.setBounds(x,100,50,100);
                if(x<=117){
                    lab.setBackground(new Color(0x0F89FF));
                }else if(x>117&&x<=234){
                    lab.setBackground(new Color(0x50FFEB));
                }else if(x>234){
                    lab.setBackground(new Color(0x3EFF5C));
                }
                if(x<=0){
                    tl.stop();
                    tr.start();
                }
            }

        });

    }
}
