package com.optivision.webapp.ui.appointments;

import com.optivision.webapp.appointment.dto.AppointmentDTO;
import com.optivision.webapp.appointment.exception.CollidingAppointmentHoursException;
import com.optivision.webapp.appointment.service.AppointmentService;
import com.optivision.webapp.ui.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.vaadin.crudui.crud.impl.GridCrud;

/**
 * A Designer generated component for the appointments-view template.
 * <p>
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Route(value = "appointments", layout = MainView.class)
@PageTitle("Citas")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "appointments", layout = MainView.class)
public class AppointmentsView extends HorizontalLayout{//extends PolymerTemplate<AppointmentsView.AppointmentsViewModel>  implements RouterLayout {

    private final AppointmentService appointmentService;
    GridCrud<AppointmentDTO> crud;
    /**
     * Creates a new AppointmentsView.
     */
    public AppointmentsView(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        crud = new GridCrud<>(AppointmentDTO.class);
        // You can initialise any data required for the connected UI components here.
        crud.setFindAllOperation(() -> appointmentService.getAllAppointments());
        crud.setAddOperation(appointmentDTO -> {
            try {
                return appointmentService.registerAppointment(appointmentDTO);
            } catch (CollidingAppointmentHoursException e) {
                e.printStackTrace();
            }
            return null;
        });

        add(crud);
    }



    /**
     * This model binds properties between AppointmentsView and appointments-view
     */
    public interface AppointmentsViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
