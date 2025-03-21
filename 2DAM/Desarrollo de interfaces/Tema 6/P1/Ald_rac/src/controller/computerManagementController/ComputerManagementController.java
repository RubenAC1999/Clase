package controller.computerManagementController;

import controller.maintenanceListener.MaintenanceListener;
import controller.serviceDetailsController.ServiceDetailsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Ald;
import model.AllInOne;
import model.Computer;
import model.ComputerService;
import model.DesktopComputer;
import model.Laptop;
import model.MaintenanceType;
import view.computerManagement.ComputerManagementDialog;
import view.serviceDetails.ServiceDetailsDialog;

public class ComputerManagementController implements MaintenanceListener {

    private ComputerManagementDialog view;
    private Ald ald;

    public ComputerManagementController(ComputerManagementDialog view, Ald ald) {
        this.view = view;
        this.ald = ald;
        this.initComponents();
        this.view.addComputerTypeOptionActionListener(this.getComputerTypeOptionActionListener());
        this.view.addComputerActionListener(this.getAddComputerButtonActionListener());
        this.view.addCancelButtonActionListener(this.getCancelButtonActionListener());
        this.view.addSaveButtonActionListener(this.getSaveButtonActionListener());
        this.view.addComputersTableMouseListener(this.getComputersTableMouseListener());
        this.view.addServicesTableMouseListener(this.getServicesTableMouseListener());
        this.view.addEditComputerActionListener(this.getEditComputerButtonActionListener());
        this.view.addRemoveComputerActionListener(this.getRemoveComputerButtonActionListener());
        this.view.addComputersScrollPaneMouseListener(this.getComputersScrollPaneMouseListener());
        this.view.addServiceButtonActionListener(this.getAddServiceButtonActionListener());
        this.view.addEditServiceButtonActionListener(this.getEditServiceButtonActionListener());
        this.view.addRemoveServiceButtonActionListener(this.getRemoveServiceButtonActionListener());
        fillComputerTable();
    }

    private void initComponents() {
        view.clearTextFields();
        view.setAttributeLabelVisibility(false);
        view.setAttributeTextFieldVisibility(false);
        view.setRemoveButtonEnable(false);
        view.setEditButtonEnable(false);
        view.setAddButtonEnable(true);
        view.setSerialNumberTextFieldEnable(false);
        view.setBrandTextFieldEnable(false);
        view.setModelTextFieldEnable(false);
        view.setComputerTypeComboBoxEnable(false);
        view.setAttributeTextFieldEnable(false);
        view.setSaveButtonEnable(false);
        view.setCancelButtonEnable(false);
        view.setComputersTableEnable(true);
        view.setComputersScrollPaneEnable(true);
        view.setMessageLabelText("                                              ");
        view.setDescriptionTextFieldEnable(false);
        view.setObservationsTextFieldEnable(false);
        view.setSeparatorLabelVisibility(false);
        view.setRepairmentDateLabelVisibility(false);
        view.setRepairmentDateVisibility(false);
        view.setTotalPriceVisibility(false);
        view.setPriceLabelVisibility(false);
        view.setEditServiceButtonEnable(false);
        view.setRemoveServiceButtonEnable(false);
        view.setAddServiceButtonEnable(true);

    }

    public ActionListener getComputerTypeOptionActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String computerType = view.getComputerTypeOption();

                switch (computerType) {
                    case "Desktop Computer" -> {
                        view.setAttributeLabelName("Power supply:");
                        view.setAttributeTextFieldVisibility(true);
                        view.setAttributeLabelVisibility(true);
                    }
                    case "Laptop" -> {
                        view.setAttributeLabelName("Keyboard layout:");
                        view.setAttributeTextFieldVisibility(true);
                        view.setAttributeLabelVisibility(true);
                    }
                    case "All in One" -> {
                        view.setAttributeLabelName("Screen resolution:");
                        view.setAttributeTextFieldVisibility(true);
                        view.setAttributeLabelVisibility(true);
                    }
                    default -> {
                        view.setAttributeLabelVisibility(false);
                        view.setAttributeTextFieldVisibility(false);
                        view.setAttributeTextField("");
                    }
                }
            }

        };
        return al;

    }

    public ActionListener getAddComputerButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setAddButtonEnable(false);
                view.setSerialNumberTextFieldEnable(true);
                view.setBrandTextFieldEnable(true);
                view.setModelTextFieldEnable(true);
                view.setComputerTypeComboBoxEnable(true);
                view.setAttributeTextFieldEnable(true);
                view.setSaveButtonEnable(true);
                view.setCancelButtonEnable(true);
                view.setComputersTableEnable(false);
                view.setComputersScrollPaneEnable(false);
                view.setMessageLabelText("                                              ");
            }

        };

        return al;
    }

    public ActionListener getEditComputerButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setSerialNumberTextFieldEnable(true);
                view.setBrandTextFieldEnable(true);
                view.setModelTextFieldEnable(true);
                view.setComputerTypeComboBoxEnable(true);
                view.setAttributeTextFieldEnable(true);
                view.setSaveButtonEnable(true);
                view.setCancelButtonEnable(true);
                view.setRemoveButtonEnable(false);
                view.setEditButtonEnable(false);
                view.setComputersTableEnable(false);
                view.setComputersScrollPaneEnable(false);
            }

        };

        return al;
    }

    public ActionListener getRemoveComputerButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(view, "Are you sure that you want to delete this computer?",
                        "Delete Computer", JOptionPane.INFORMATION_MESSAGE);
                if (option == 0) {
                    ald.deleteComputer(view.getComputerInfo(view.getComputerSelectedRow(), 0));
                    System.out.println("Ordenador borrado");
                    view.clearComputers();
                    fillComputerTable();
                    initComponents();
                    view.setMessageLabelText("Computer deleted succesfully");

                }
            }

        };
        return al;
    }

    public MouseListener getComputersScrollPaneMouseListener() {
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (view.isComputerScrollPaneEnable()) {
                    view.clearSelection();
                    view.clearServices();
                    view.setEditButtonEnable(false);
                    initComponents();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        };

        return ml;
    }

    public MouseListener getComputersTableMouseListener() {
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int rowSelected = view.getComputerSelectedRow();

                if (rowSelected >= 0 && view.isComputerScrollPaneEnable()) {
                    Computer computerSelected = ald.getComputer(view.getComputerInfo(rowSelected, 0));

                    view.setSerialNumberTextField(computerSelected.getSerialNumber());
                    view.setBrandTextField(computerSelected.getBrand());
                    view.setModelTextField(computerSelected.getModel());

                    if (computerSelected instanceof DesktopComputer) {
                        view.setComputerTypeOption(1);
                        view.setAttributeTextField(((DesktopComputer) computerSelected).getPowerSupply());

                    } else if (computerSelected instanceof Laptop) {
                        view.setComputerTypeOption(2);
                        view.setAttributeTextField(((Laptop) computerSelected).getKeyboardLayout());

                    } else if (computerSelected instanceof AllInOne) {
                        view.setComputerTypeOption(3);
                        view.setAttributeTextField(((AllInOne) computerSelected).getScreenResolution());
                    }
                    view.setAddButtonEnable(false);
                    view.setEditButtonEnable(true);
                    view.setRemoveButtonEnable(true);

                    view.clearServices();
                    fillServicesTable(computerSelected);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        };

        return ml;
    }

    public MouseListener getServicesTableMouseListener() {
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int serviceRowSelected = view.getServiceSelectedRow();
                int computerRowSelected = view.getComputerSelectedRow();
                Computer computerSelected = ald.getComputer(view.getComputerInfo(serviceRowSelected, 0));

                if (serviceRowSelected >= 0 && view.isComputerScrollPaneEnable()) {
                    view.setEditButtonEnable(true);
                    ComputerService serviceSelected = computerSelected.getRepair(serviceRowSelected);

                    view.setDescriptionTextField(serviceSelected.getDescription());
                    view.setObservationsTextField(serviceSelected.getObservations());
                    view.setRepairmentDateText(serviceSelected.getDate());
                    view.setTotalPriceText(String.valueOf(serviceSelected.getTotalPrice()));
                    view.setEditServiceButtonEnable(true);
                    view.setRemoveServiceButtonEnable(true);
                    view.setAddServiceButtonEnable(true);

                    if (serviceSelected.isRepaired()) {
                        view.setSeparatorLabelVisibility(true);
                        view.setRepairmentDateLabelVisibility(true);
                        view.setRepairmentDateVisibility(true);
                        view.setTotalPriceVisibility(true);
                        view.setPriceLabelVisibility(true);

                    } else {
                        view.setSeparatorLabelVisibility(false);
                        view.setRepairmentDateLabelVisibility(false);
                        view.setRepairmentDateVisibility(false);
                        view.setTotalPriceVisibility(false);
                        view.setPriceLabelVisibility(false);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        };

        return ml;
    }

    public void fillComputerTable() {
        HashMap<String, Computer> computerList = ald.getComputerList();

        for (Map.Entry<String, Computer> entry : computerList.entrySet()) {
            Vector row = new Vector();
            row.add(entry.getKey());
            row.add(entry.getValue().getBrand());
            row.add(entry.getValue().getModel());

            if (entry.getValue() instanceof DesktopComputer) {
                row.add("Desktop Computer");
            } else if (entry.getValue() instanceof Laptop) {
                row.add("Laptop");
            } else if (entry.getValue() instanceof AllInOne) {
                row.add("All in One");
            }

            view.addRowComputerTable(row);
        }
    }

    public void fillServicesTable(Computer computer) {
        ArrayList<ComputerService> serviceList = computer.getRepairs();
        serviceList.forEach(service -> {
            Vector row = new Vector();
            row.add(service.getComputer().getSerialNumber());
            row.add(service.getMaintenanceType());
            row.add(service.getContactPerson());
            row.add(service.getContactPhone());
            row.add(service.isRepaired() ? "Repaired" : "Not Repaired");
            view.addRowServiceTable(row);
        });
    }

    public ActionListener getSaveButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!view.isAnyTextFieldBlank()) {
                    Vector row = new Vector();
                    String serialNumberSelected = view.getComputerInfo(view.getComputerSelectedRow(), 0);
                    String newSerialNumber = view.getSerialNumberTextField();
                    String newBrand = view.getBrandTextField();
                    String newModel = view.getModelTextField();
                    String newAttribute = view.getAttributeTextField();
                    String computerType = view.getComputerTypeOption();

                    if (ald.isComputerInTheList(newSerialNumber) && !newSerialNumber.equals(serialNumberSelected)) {
                        view.setMessageLabelText("Serial number is duplicated");
                    } else {
                        if (view.isRowSelected(true)) {
                            ald.deleteComputer(serialNumberSelected);
                        }

                        switch (computerType) {
                            case "Desktop Computer" -> {
                                DesktopComputer dc = new DesktopComputer(newSerialNumber,
                                        newBrand, newModel, newAttribute);
                                ald.addComputer((DesktopComputer) dc);
                            }

                            case "Laptop" -> {
                                Laptop l = new Laptop(newSerialNumber, newBrand, newModel,
                                        newAttribute);
                                ald.addComputer((Laptop) l);
                            }

                            case "All in One" -> {
                                AllInOne aio = new AllInOne(newSerialNumber, newBrand,
                                        newModel, newAttribute);
                                ald.addComputer((AllInOne) aio);
                            }
                        }

                        view.clearComputers();
                        fillComputerTable();
                        initComponents();
                    }

                } else {
                    view.setMessageLabelText("You must complete all the fields");
                }
            }

        };

        return al;
    }

    public ActionListener getCancelButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initComponents();
                view.clearSelection();
            }

        };

        return al;
    }

    public ActionListener getAddServiceButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = view.getComputerSelectedRow();
                Computer computerSelected = ald.getComputer(view.getComputerInfo(rowSelected, 0));

                if (computerSelected != null) {
                    ComputerService computerService = new ComputerService(computerSelected, MaintenanceType.HARDWARE_ACTUALIZATION, "", "",
                            "", "", "", 0f, false);
                    ServiceDetailsDialog dialog = new ServiceDetailsDialog(view, true);
                    ServiceDetailsController controller = new ServiceDetailsController(dialog, ald,
                            ComputerManagementController.this, computerService, false);
                    dialog.setVisible(true);
                } else {
                    view.setServiceMessageLabelText("You must select a computer");
                }

            }
        };

        return al;
    }

    public ActionListener getEditServiceButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int computerRowSelected = view.getComputerSelectedRow();
                Computer computerSelected = ald.getComputer(view.getComputerInfo(computerRowSelected, 0));
                int serviceRowSelected = view.getServiceSelectedRow();

                if (serviceRowSelected >= 0 && view.isComputerScrollPaneEnable()) {
                    ComputerService serviceSelected = computerSelected.getRepair(serviceRowSelected);

                    ServiceDetailsDialog dialog = new ServiceDetailsDialog(view, true);
                    ServiceDetailsController controller = new ServiceDetailsController(dialog, ald,
                            ComputerManagementController.this, serviceSelected, true);
                    dialog.setVisible(true);
                }
            }

        };

        return al;
    }

    public ActionListener getRemoveServiceButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int computerRowSelected = view.getComputerSelectedRow();
                Computer computerSelected = ald.getComputer(view.getComputerInfo(computerRowSelected, 0));
                int serviceRowSelected = view.getServiceSelectedRow();

                int option = JOptionPane.showConfirmDialog(view, "Are you sure that you want to delete this service?",
                        "Delete Service", JOptionPane.INFORMATION_MESSAGE);
                if (option == 0) {
                    computerSelected.deleteRepair(computerSelected.getRepair(serviceRowSelected));
                    System.out.println("Servicio borrado");
                    view.clearServices();
                    fillServicesTable(computerSelected);
                    initComponents();
                }

            }

        };
        return al;

    }

    @Override
    public void onMaintenanceAdded(Computer computer, ComputerService newService) {
        computer.addRepair(newService);
        view.clearServices();
        fillServicesTable(computer);
    }

    @Override
    public void onMaintenanceUpdated(Computer computer, ComputerService oldService, ComputerService serviceUpdated) {
        computer.updateRepair(oldService, serviceUpdated);
        view.clearServices();
        fillServicesTable(computer);
    }
}
