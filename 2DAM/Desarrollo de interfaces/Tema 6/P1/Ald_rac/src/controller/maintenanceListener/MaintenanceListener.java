
package controller.maintenanceListener;

import model.Computer;
import model.ComputerService;

public interface MaintenanceListener {
    void onMaintenanceAdded(Computer computer, ComputerService newService);
    void onMaintenanceUpdated(Computer computer, ComputerService oldService, ComputerService serviceUpdated);
}
