package com.optivision.webapp.ui.sales;

import com.optivision.webapp.product.service.ProductService;
import com.optivision.webapp.sale.dto.Sale;
import com.optivision.webapp.sale.dto.SaleItem;
import com.optivision.webapp.sale.service.SalesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;


public class SaleForm extends FormLayout {
    //-- Metadata
    private boolean formState;
    //-- UI Components
    private final Button addNewProduct = new Button("Añadir producto");
    Grid<SaleItem> items = new Grid<>(SaleItem.class);
    private final NumberField total = new NumberField("Total venta");
    private final NumberField paid = new NumberField("Abono");
    private final NumberField pending = new NumberField("Pendiente");

    private final Button save = new Button("Guardar");
    private final Button update = new Button("Actualizar");
    private final Button delete = new Button("Borrar");

    private final SaleItemForm saleItemForm;
    private final Dialog formModal = new Dialog();

    private Binder<Sale> binder = new Binder<>(Sale.class);

    private final SalesView salesView;

    //--- Spring components
    private final SalesService salesService;
    private final ProductService productService;



    public SaleForm(SalesView salesView, SalesService salesService, ProductService productService){
        this.formState = false;
        this.salesService = salesService;
        this.productService = productService;
        this.salesView = salesView;

        this.saleItemForm = new SaleItemForm(this, productService);

        items.addColumn(saleItem -> "NOMBRE PRODUCTO TEST")//saleItem.getProduct().getNombreProducto())
                .setHeader("Nombre producto");
        items.addColumn(saleItem -> saleItem.getType())
                .setHeader("Tipo producto");
        items.addColumn(saleItem -> "TEST MARCA" )//saleItem.getProduct().getMarca())
                .setHeader("Marca");
        items.addColumn(saleItem -> 0.0)//saleItem.getProduct().getPrecioPublico())
                .setHeader("Valor");

        items.removeColumnByKey("type");
        items.removeColumnByKey("saleId");
        items.removeColumnByKey("product");

        addNewProduct.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        total.setReadOnly(true);
        pending.setReadOnly(true);

        HorizontalLayout buttons = new HorizontalLayout(save, update, delete);
        buttons.setSizeFull();

        VerticalLayout table = new VerticalLayout(addNewProduct, items);
        table.setSizeFull();

        HorizontalLayout fields = new HorizontalLayout(total, paid, pending);
        fields.setSizeFull();

        VerticalLayout allComponents = new VerticalLayout(fields, table, buttons);

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickListener(buttonClickEvent -> saveSale());

        //Add new sale
        formModal.add(saleItemForm);
        formModal.setWidth("50%");
        formModal.setHeight("65%");

        addNewProduct.addClickListener(buttonClickEvent -> {
            saleItemForm.formShow(new SaleItem());
            saleItemForm.setState(true);
            formModal.open();
        });

        delete.addClickListener(buttonClickEvent -> deleteSale());
        add(allComponents);


        binder.bindInstanceFields(this);

    }

    public boolean isOpen(){
        return formState;
    }

    public void setState(boolean state){
        this.formState = state;
    }
    /**
     * Save the sale information
     */
    public void saveSale(){
        Sale sale = binder.getBean();
        salesService.doSale(sale);
        salesView.updateGridContent();
        formShow(null);
    }

    public void deleteSale(){
        //Sale sale = binder.getBean();
        Notification.show("DELETED ;)");
    }

    public Sale getCurrentSale(){
        return binder.getBean();
    }

    public void updateCurrentSale(Sale sale) throws ValidationException {
        binder.writeBean(sale);
        updateSaleItemsContent();
    }

    public void updateSaleItemsContent(){
        Sale sale = binder.getBean();
        items.setItems(sale.getItems());

    }

    /**
     * Form logic to show/hide itself
     * @param sale
     */
    public void formShow(Sale sale){
        binder.setBean(sale);

        if(sale == null){
            setVisible(false);
        }else{
            setVisible(true);
            total.focus();
        }
    }
}
