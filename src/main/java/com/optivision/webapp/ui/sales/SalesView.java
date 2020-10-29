package com.optivision.webapp.ui.sales;

import com.optivision.webapp.product.service.ProductService;
import com.optivision.webapp.sale.dto.Sale;
import com.optivision.webapp.sale.dto.SaleItem;
import com.optivision.webapp.sale.service.SalesService;
import com.optivision.webapp.ui.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import liquibase.pro.packaged.T;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.time.LocalDate;
import java.util.List;

@Route(value = "sales", layout = MainView.class)
@PageTitle("Ventas")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "sales", layout = MainView.class)
public class SalesView extends VerticalLayout {

    private final SalesService salesService;
    private final ProductService productService;
    private final Grid<Sale> grid  = new Grid<Sale>(Sale.class);
    private final TextField searchBar = new TextField();
    private final Button createSale = new Button("Venta");

    private final SaleForm saleForm;

    public SalesView(SalesService salesService, ProductService productService) {
        this.productService = productService;
        this.salesService = salesService;

        this.saleForm = new SaleForm(this, salesService, productService);
        this.saleForm.formShow(null);

        //Filter text
        searchBar.setPlaceholder("Buscar");
        searchBar.setClearButtonVisible(true);
        searchBar.setValueChangeMode(ValueChangeMode.EAGER);
        searchBar.addValueChangeListener(e -> updateGridContent());

        //Add new sale
        createSale.addClickListener(buttonClickEvent -> {
            grid.asSingleSelect().clear();
            if(saleForm.isOpen()){
                saleForm.formShow(null);
                saleForm.setState(false);
            }else {
                saleForm.formShow(new Sale());
                saleForm.setState(true);
            }
        });

        grid.setColumns("total", "paid", "patientName", "items", "state");
        grid.setItemDetailsRenderer(new ComponentRenderer<>(sale -> {
            VerticalLayout verticalLayout = new VerticalLayout();
            List<SaleItem> items = (List<SaleItem>) sale.getItems();
            items.stream()
                    .map(saleItem -> "Producto: " + saleItem.getProduct().getNombreProducto() +
                            " | Tipo: " + saleItem.getType() + " | Marca: " + saleItem.getProduct().getMarca())
                    .peek(s -> verticalLayout.add(new Label(s)))
                    .close();
            return verticalLayout;
        }));
        grid.asSingleSelect().addValueChangeListener(event ->
                saleForm.formShow(grid.asSingleSelect().getValue()));

        HorizontalLayout toolbar = new HorizontalLayout(searchBar, createSale);


        //HorizontalLayout mainContent = new HorizontalLayout(grid, saleForm);
        SplitLayout mainContent = new SplitLayout(grid, saleForm);
        mainContent.setSizeFull();
        setSizeFull();
        add(toolbar, mainContent);
        updateGridContent();
    }

    /**
     * Fill or refresh the sales table with data from
     * the day itself
     */
    public void updateGridContent(){
        grid.setItems(salesService.getSalesByDate(LocalDate.now()));
    }
}
