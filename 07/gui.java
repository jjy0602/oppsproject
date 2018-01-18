package opens;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
//Jframe ���
public class gui extends JFrame {

	public gui() {
		setTitle("OpenSource");
		getContentPane().setLayout(null); //���̾ƿ�����X
		setSize(200,200); //�� ������
		
		JButton btnNewButton = new JButton("Renew"); //���� ��ư ����
		btnNewButton.addActionListener(new ActionListener() { //��ưŬ���̺�Ʈ
			public void actionPerformed(ActionEvent arg0) {
				//���Ž� �˾� �޽��� �߻�
				 JOptionPane.showMessageDialog(null, "Renew.", "Message", JOptionPane.INFORMATION_MESSAGE); 
				 new goThread(); //���������
			}
		});
		btnNewButton.setBounds(35, 29, 113, 45); //��ư ��ǥ
		getContentPane().add(btnNewButton); //����Ʈ �ҿ� ����
		
		JButton button = new JButton("Pause"); //���� ��ư ����
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//������ �˾� �޽��� �߻�
				JOptionPane.showMessageDialog(null, "Pause.", "Message", JOptionPane.INFORMATION_MESSAGE); 
				goThread.flag = false; //���� �ݺ� ����
			}
		});
		button.setBounds(35, 94, 113, 45); //�ι�° ��ư ����
		getContentPane().add(button); //�ι�° ��ư ��ǥ

		setVisible(true); //â ����ȭ
		
		
        Runnable runner = new Runnable() {
            public void run() {
              if (SystemTray.isSupported()) {
                SystemTray tray = SystemTray.getSystemTray(); //Ʈ���� ����     
                Image image = Toolkit.getDefaultToolkit().getImage("C:\\JHS\\icon.png"); //Ʈ���� ������ ����
                PopupMenu popup = new PopupMenu(); //Ʈ���� �޴� ����
                TrayIcon trayIcon = new TrayIcon(image, "Program Name", popup); //Ʈ���� �����ܿ� Ŀ�� �ø���
                trayIcon.setImageAutoSize(true);
                
                trayIcon.addActionListener(new ActionListener() { //������ ������ ��
                    public void actionPerformed(ActionEvent e) {
                        setVisible(isVisible());
                    }
               });
                
                MenuItem item = new MenuItem("Open"); //�����ʸ��콺 - Open
                item.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setVisible(true);                  
                    }
          });   
                popup.add(item);
                item = new MenuItem("Close"); //�����ʸ��콺 - Close 
        item.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
			           tray.remove(trayIcon); //������ ����
			           System.exit(0);
                  }
        });
                popup.add(item); 


                try {
       tray.add(trayIcon);
                } catch (AWTException e) {
                  System.err.println("Can't add to tray");
                }
              } else {
                System.err.println("Tray unavailable");
              }
            }
          };
          EventQueue.invokeLater(runner);    

	}
}
