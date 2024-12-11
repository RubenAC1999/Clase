/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import clock.AlarmEvent;
import clock.IAlarmListener;
import controller.clock.ClockController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import view.MainJFrame;
import view.clock.ClockConfigurationDialog;

/**
 *
 * @author fermigo
 */
public class FrontControllerJFrame implements IAlarmListener {

    private final MainJFrame view;

    public FrontControllerJFrame(MainJFrame view) {
        this.view = view;
        this.view.addNotificationMenuItemItemListener(this.getNotificationMenuItemItemListener());
        this.view.addNotificationMenuMouseListener(this.getNotificationMenuMouseListener());
        this.view.addQuitMenuItemListener(this.getQuitMenuItemActionListener());
        this.view.addEnableDisableNotificationMenuItem(this.EnableNotificationMenu());
        this.view.addEnableDisableNotificationMenuItem(this.DisableNotificationMenu());
        configureNotificationReceptor();
    }

    private JMenuItem EnableNotificationMenu() {
        JMenuItem mi = new JMenuItem();
        mi.setText("Enable notification");
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.enableAlarm(true);
            }
        });
        return mi;
    }

    private JMenuItem DisableNotificationMenu() {
        JMenuItem mi = new JMenuItem();
        mi.setText("Disable notification");
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.enableAlarm(false);
            }
        });
        return mi;
    }

    private MouseListener getNotificationMenuMouseListener() {

        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

            }

            @Override
            public void mousePressed(MouseEvent me) {
                if (me.isPopupTrigger()) {
                    view.showPopup(me);
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger()) {
                    view.showPopup(me);
                }

            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        };
        return ml;
    }

    private ActionListener getQuitMenuItemActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }

    private ActionListener getNotificationMenuItemItemListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClockConfigurationDialog ccd = new ClockConfigurationDialog(view, true);
                ClockController cc = new ClockController(view, ccd);
                ccd.setVisible(true);
            }
        };
        return al;
    }

    private void configureNotificationReceptor() {
        this.view.addAlarmListener(this);
    }

    @Override
    public void captureAlarm(AlarmEvent ev) {
        view.setEnableAlarm(false);
        JOptionPane.showMessageDialog(view, view.getAlarmMessage());
    }

}
